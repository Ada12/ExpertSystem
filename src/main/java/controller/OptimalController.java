package controller;

import entity.BasicVehicleEntity;
import entity.PreOptimizationInstanceEntity;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.BasicService;
import service.OptimalService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yangchen on 2018/4/3.
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class OptimalController {

    @Autowired
    private OptimalService optimalService;

    @Autowired
    private BasicService basicService;

    public ResponseEntity<Map<String, Object>> getResponseBody(Object object) {
        Map<String, Object> returnInfo = new HashMap<String, Object>();
        returnInfo.put("Code", 0);
        returnInfo.put("Msg", "Success");
        returnInfo.put("results", object);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Credentials", "true");
        headers.add("allowed_cross_domains", "true");
        headers.add("Access-Control-Allow-Origin", "*");
        headers.add("Access-Control-Allow-Headers", " Accept, Content-Type");
        headers.add("Access-Control-Max-Age", "1728000");
        return new ResponseEntity<Map<String, Object>>(returnInfo, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "library/all", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> getLibrary(
            @RequestParam("type") String type
    ) {
        return getResponseBody(optimalService.getLibrary(type));
    }

    @RequestMapping(value = "basic/preOptimal/desc", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getPreOptimalDesc(
            @RequestParam("userId") int userId
    ) {
        List<PreOptimizationInstanceEntity> list = optimalService.getOptimizationDesc(userId);
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < list.size(); i ++) {
            Map<String, Object> single = new HashedMap();
            single.put("id", list.get(i).getId());
            single.put("desc", list.get(i).getDescription());
            result.add(single);
        }
        return getResponseBody(result);
    }

    @RequestMapping(value = "basic/preOptimal", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getPreOptimal(
            @RequestParam("description") String description,
            @RequestParam("userId") int userId
    ) {
        PreOptimizationInstanceEntity entity = optimalService.getOptimization(description, userId);
        Map<String, Object> result = new HashedMap();
        result.put("description", entity.getDescription());
        result.put("carModel", entity.getCarModel());
        result.put("carYear", entity.getCarYear());
        result.put("carDa", entity.getCarDa());
        result.put("carAddInfo", entity.getCarAddInfo());
        result.put("lvwM", entity.getLvwM());
        result.put("lvwFrtR", entity.getLvwFrtR());
        result.put("lvwCgh", entity.getLvwCgh());
        result.put("gvwM", entity.getGvwM());
        result.put("gvwFrtR", entity.getGvwFrtR());
        result.put("gvwCgh", entity.getGvwCgh());
        result.put("l", entity.getL());
        result.put("vmax", entity.getVmax());
        result.put("wot", entity.getWot());
        result.put("coastDecel", entity.getCoastDecel());
        result.put("cd", entity.getCd());
        result.put("a", entity.getA());
        result.put("notes", entity.getNotes());
        result.put("indexContent", getIndexContent(entity.getIndexContent()));
        result.put("pedal", getPartDetail(entity.getPedal()));
        result.put("bstMc", getPartDetail(entity.getApply()));
        result.put("discCaliper", getPartDetail(entity.getFrtClp()));
        result.put("discLining", getPartDetail(entity.getFrtLin()));
        result.put("frtRotor", getPartDetail(entity.getFrtRt()));
        result.put("drumCaliper", getPartDetail(entity.getRrClp()));
        result.put("drumLining", getPartDetail(entity.getRrLin()));
        result.put("rrRotor", getPartDetail(entity.getRrRt()));
        result.put("abs", getPartDetail(entity.getAbs()));
        result.put("tire", getPartDetail(entity.getTire()));
        result.put("userId", entity.getUserId());
        return getResponseBody(result);
    }

    public static String trimMarks(String str) {
        if (str.contains("\"")) {
            return str.substring(1, str.length()-1);
        }
        return str;
    }

    public List<Object[]> getIndexContent(String indexContent) {
        String[] item = indexContent.split("\\[\\[|\\],\\[|\\]\\]|\\], \\[");
        List<Object[]> result = new ArrayList<Object[]>();
        for (int i = 1; i < item.length; i ++) {
            String[] indexArray = item[i].split(",");
            Object[] index = new Object[3];
            index[0] = trimMarks(indexArray[0].trim());
            index[1] = trimMarks(indexArray[1].trim());
            index[2] = trimMarks(indexArray[2].trim());
            result.add(index);
        }
        return result;
    }

    public Object getPartDetail(int content) {
        if (content == -1000) {
            return false;
        }
        return content;
    }

    @RequestMapping(value = "basic/preOptimal/check", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> checkPreOptimal(
            @RequestParam("description") String description,
            @RequestParam("userId") int userId
    ) {
        List<PreOptimizationInstanceEntity> list = optimalService.getOptimizationDesc(userId);
        List<String> descs = new ArrayList<String>();
        for (int i = 0; i < list.size(); i ++) {
            descs.add(list.get(i).getDescription());
        }
        return getResponseBody(descs.contains(description));
    }

    @RequestMapping(value = "basic/preOptimal/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> addNewPreOptimal(
            @RequestBody Map<String, Object> params
    ) {
        //try {
            PreOptimizationInstanceEntity entity = new PreOptimizationInstanceEntity();
            entity.setDescription(params.get("description").toString());
            entity.setCarModel(params.get("carModel").toString());
            entity.setCarYear(getDoubleValue(params.get("carYear").toString()));
            entity.setCarDa(params.get("carDa").toString());
            entity.setCarAddInfo(params.get("carAddInfo").toString());
            entity.setLvwM(getDoubleValue(params.get("lvwM").toString()));
            entity.setLvwFrtR(getDoubleValue(params.get("lvwFrtR").toString()));
            entity.setLvwCgh(getDoubleValue(params.get("lvwCgh").toString()));
            entity.setGvwM(getDoubleValue(params.get("gvwM").toString()));
            entity.setGvwFrtR(getDoubleValue(params.get("gvwFrtR").toString()));
            entity.setGvwCgh(getDoubleValue(params.get("gvwCgh").toString()));
            entity.setL(getDoubleValue(params.get("l").toString()));
            entity.setVmax(getDoubleValue(params.get("vmax").toString()));
            entity.setWot(getDoubleValue(params.get("wot").toString()));
            entity.setCoastDecel(getDoubleValue(params.get("coastDecel").toString()));
            entity.setCd(getDoubleValue(params.get("cd").toString()));
            entity.setA(getDoubleValue(params.get("a").toString()));
            entity.setIsWork(0);
            entity.setIndexContent(params.get("indexContent").toString());
            entity.setPedal(setPartDetail(params.get("pedal")));
            entity.setApply(setPartDetail(params.get("bstMc")));
            entity.setFrtClp(setPartDetail(params.get("discCaliper")));
            entity.setFrtLin(setPartDetail(params.get("discLining")));
            entity.setFrtRt(setPartDetail(params.get("frtRotor")));
            entity.setRrClp(setPartDetail(params.get("drumCaliper")));
            entity.setRrLin(setPartDetail(params.get("drumLining")));
            entity.setRrRt(setPartDetail(params.get("rrRotor")));
            entity.setAbs(setPartDetail(params.get("abs")));
            entity.setTire(setPartDetail(params.get("tire")));;
            entity.setUserId(getIntegerValue(params.get("userId").toString()));
            entity.setNotes(params.get("notes").toString());
            return getResponseBody(optimalService.addNewOptimization(entity));
        //} catch (Exception e) {
            //System.out.println(e);
          //  return getResponseBody(false);
        //}
    }

    public int setPartDetail(Object detail) {
        if (detail.toString().equals("false") || (detail.toString().equals("FALSE") || detail.toString().equals("False"))) {
            return -1000;
        }
        return getIntegerValue(detail.toString());
    }

    public Double getDoubleValue(String value) {
        if (value.equals("")) {
            return null;
        }
        return Double.valueOf(value);
    }

    public Integer getIntegerValue(String value) {
        if (value.equals("")) {
            return null;
        }
        return Integer.valueOf(value);
    }


}
