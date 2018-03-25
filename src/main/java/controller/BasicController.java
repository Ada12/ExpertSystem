package controller;

import ExternalMatlab.ManualCalculate;
import entity.*;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by yangchen on 17/9/5.
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class BasicController {

    @Autowired
    private BasicService basicService;

    @Autowired
    ServletContext servletContext;

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

    // basic apply
    @RequestMapping(value = "basic/apply/desc", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getBasicApplyDesc(
            @RequestParam("userId") int userId
    ) {
        List<BasicApplyEntity> list = basicService.getBasicApplyDesc(userId);
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < list.size(); i ++) {
            Map<String, Object> single = new HashedMap();
            single.put("id", list.get(i).getId());
            single.put("desc", list.get(i).getDescription());
            result.add(single);
        }
        return getResponseBody(result);
    }

    @RequestMapping(value = "basic/apply", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getBasicApply(
            @RequestParam("description") String description,
            @RequestParam("userId") int userId
    ) {
        return getResponseBody(basicService.getBasicApply(description, userId));
    }

    @RequestMapping(value = "basic/apply/check", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> checkBasicApply(
            @RequestParam("description") String description,
            @RequestParam("userId") int userId
    ) {
        List<BasicApplyEntity> list = basicService.getBasicApplyDesc(userId);
        List<String> descs = new ArrayList<String>();
        for (int i = 0; i < list.size(); i ++) {
            descs.add(list.get(i).getDescription());
        }
        return getResponseBody(descs.contains(description));
    }

    @RequestMapping(value = "basic/apply/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> addNewBasicApply(
            @RequestBody Map<String, Object> params
    ) {
        try {
            BasicApplyEntity entity = new BasicApplyEntity();
            entity.setDescription(String.valueOf(params.get("description")));
            entity.setPedSpl(String.valueOf(params.get("pedSpl")));
            entity.setPedRatio(String.valueOf(params.get("pedRatio")));
            entity.setPedFEff(getDoubleValue(params.get("pedFEff").toString()));
            entity.setPedTEff((getDoubleValue(params.get("pedTEff").toString())));
            entity.setPedType(getIntegerValue(params.get("pedType").toString()));
            entity.setBstSpl(String.valueOf(params.get("bstSpl")));
            entity.setBstSize(getDoubleValue(params.get("bstSize").toString()));
            entity.setBstGain(getDoubleValue(params.get("bstGain").toString()));
            entity.setBstFTotal(getDoubleValue(params.get("bstFTotal").toString()));
            entity.setBstFEff(getDoubleValue(params.get("bstFEff").toString()));
            entity.setBstTEff(getDoubleValue(params.get("bstTEff").toString()));
            entity.setBstFLsNp(getDoubleValue(params.get("bstFLsNp").toString()));
            entity.setBstFLsWp(getDoubleValue(params.get("bstFLsWp").toString()));
            entity.setBstFJmp((getDoubleValue(params.get("bstFJmp").toString())));
            entity.setBstTLs(getDoubleValue(params.get("bstTLs").toString()));
            entity.setBstVcm(getDoubleValue(params.get("bstVcm").toString()));
            entity.setAltBstVcm(getDoubleValue(params.get("altBstVcm").toString()));
            entity.setMcdSpl(String.valueOf(params.get("mcdSpl")));
            entity.setMcdD((getDoubleValue(params.get("mcdD").toString())));
            entity.setMcdFEff(getDoubleValue(params.get("mcdFEff").toString()));
            entity.setMcdTEff(getDoubleValue(params.get("mcdTEff").toString()));
            entity.setApyFEff(getDoubleValue(params.get("apyFEff").toString()));
            entity.setApyTEff(getDoubleValue(params.get("apyTEff").toString()));
            entity.setIsWork(0);
            entity.setUserId(getIntegerValue(params.get("userId").toString()));
            entity.setNotes(String.valueOf(params.get("notes")));
            return getResponseBody(basicService.addNewApply(entity));
        } catch (Exception e) {
            System.out.println(e);
            return getResponseBody(false);
        }
    }

    @RequestMapping(value = "basic/apply/delete", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> deleteBasicApply(
            @RequestParam("description") String description,
            @RequestParam("userId") int userId
    ) {
        return getResponseBody(basicService.deleteApply(description, userId));
    }

    // basic control
    @RequestMapping(value = "basic/control/desc", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getBasicControlDesc(
            @RequestParam("userId") int userId
    ) {
        List<BasicControlEntity> list = basicService.getBasicControlDesc(userId);
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < list.size(); i ++) {
            Map<String, Object> single = new HashedMap();
            single.put("id", list.get(i).getId());
            single.put("desc", list.get(i).getDescription());
            result.add(single);
        }
        return getResponseBody(result);
    }

    @RequestMapping(value = "basic/control", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getBasicControl(
            @RequestParam("description") String description,
            @RequestParam("userId") int userId
    ) {
        return getResponseBody(basicService.getBasicControl(description, userId));
    }

    @RequestMapping(value = "basic/control/check", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> checkBasicControl(
            @RequestParam("description") String description,
            @RequestParam("userId") int userId
    ) {
        List<BasicControlEntity> list = basicService.getBasicControlDesc(userId);
        List<String> descs = new ArrayList<String>();
        for (int i = 0; i < list.size(); i ++) {
            descs.add(list.get(i).getDescription());
        }
        return getResponseBody(descs.contains(description));
    }

    @RequestMapping(value = "basic/control/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> addNewBasicControl(
            @RequestBody Map<String, Object> params
    ) {
        try {
            BasicControlEntity entity = new BasicControlEntity();
            entity.setDescription(params.get("description").toString());
            entity.setAbsSpl(String.valueOf(params.get("absSpl")));
            entity.setAbsType(String.valueOf(params.get("absType")));
            entity.setEffAbsFrt(getDoubleValue(params.get("effAbsFrt").toString()));
            entity.setEffAbsRr(getDoubleValue(params.get("effAbsRr").toString()));
            entity.setEbd(getIntegerValue(params.get("ebd").toString()));
            entity.setIsWork(0);
            entity.setUserId(getIntegerValue(params.get("userId").toString()));
            entity.setNotes(params.get("notes").toString());
            return getResponseBody(basicService.addNewControl(entity));
        } catch (Exception e) {
            System.out.println(e);
            return getResponseBody(false);
        }
    }

    @RequestMapping(value = "basic/control/delete", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> deleteBasicControl(
            @RequestParam("description") String description,
            @RequestParam("userId") int userId
    ) {
        return getResponseBody(basicService.deleteControl(description, userId));
    }

    // basic disc brake
    @RequestMapping(value = "basic/discBrake/desc", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getBasicDiscBrakeDesc(
            @RequestParam("userId") int userId
    ) {
        List<BasicDiscBrakeEntity> list = basicService.getBasicDiscBrakeDesc(userId);
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < list.size(); i ++) {
            Map<String, Object> single = new HashedMap();
            single.put("id", list.get(i).getId());
            single.put("desc", list.get(i).getDescription());
            result.add(single);
        }
        return getResponseBody(result);
    }

    @RequestMapping(value = "basic/discBrake", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getBasicDiscBrake(
            @RequestParam("description") String description,
            @RequestParam("userId") int userId
    ) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            BasicDiscBrakeEntity basicDiscBrakeEntity = basicService.getBasicDiscBrake(description, userId);
            map.put("caliperLining", basicDiscBrakeEntity);
            if (basicDiscBrakeEntity.getRtType().equals("Vented") || basicDiscBrakeEntity.getRtType().equals("vented")) {
                map.put("rotor", basicService.getBasicVentedRotor(basicDiscBrakeEntity.getRtId()));
            } else if (basicDiscBrakeEntity.getRtType().equals("Solid") || basicDiscBrakeEntity.getRtType().equals("solid")) {
                map.put("rotor", basicService.getBasicSolidRotor(basicDiscBrakeEntity.getRtId()));
            } else {
                map.put("rotor", basicService.getBasicDrumRotor(basicDiscBrakeEntity.getRtId()));
            }
            return getResponseBody(map);
        } catch (Exception e) {
            return getResponseBody(null);
        }
    }

    @RequestMapping(value = "basic/discBrake/check", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> checkBasicDiscBrake(
            @RequestParam("description") String description,
            @RequestParam("userId") int userId
    ) {
        List<BasicDiscBrakeEntity> list = basicService.getBasicDiscBrakeDesc(userId);
        List<String> descs = new ArrayList<String>();
        for (int i = 0; i < list.size(); i ++) {
            descs.add(list.get(i).getDescription());
        }
        return getResponseBody(descs.contains(description));
    }

    @RequestMapping(value = "basic/discBrake/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> addNewBasicDiscBrake(
            @RequestBody Map<String, Object> caliperLining
    ) {
        // caliperLining represent parms
        BasicDiscBrakeEntity basicDiscBrakeEntity = new BasicDiscBrakeEntity();
        basicDiscBrakeEntity.setDescription(caliperLining.get("description").toString());
        basicDiscBrakeEntity.setFrtType(caliperLining.get("frtType").toString());
        basicDiscBrakeEntity.setFrtManu(caliperLining.get("frtManu").toString());
        basicDiscBrakeEntity.setPstD(getDoubleValue(caliperLining.get("pstD").toString()));
        basicDiscBrakeEntity.setPstNum(getIntegerValue(caliperLining.get("pstNum").toString()));
        basicDiscBrakeEntity.setPstArea(getDoubleValue(caliperLining.get("pstArea").toString()));
        basicDiscBrakeEntity.setHfPT(getDoubleValue(caliperLining.get("hfPT").toString()));
        basicDiscBrakeEntity.setHfPV(getDoubleValue(caliperLining.get("hfPV").toString()));
        basicDiscBrakeEntity.setpVcurve(caliperLining.get("pVcurve").toString());
        basicDiscBrakeEntity.setPvK(getDoubleValue(caliperLining.get("pvK").toString()));
        basicDiscBrakeEntity.setPvB(getDoubleValue(caliperLining.get("pvB").toString()));
        basicDiscBrakeEntity.setPvC(getDoubleValue(caliperLining.get("pvC").toString()));
        basicDiscBrakeEntity.setLinSpl(caliperLining.get("linSpl").toString());
        basicDiscBrakeEntity.setLinMat(caliperLining.get("linMat").toString());
        basicDiscBrakeEntity.setLinMu(caliperLining.get("linMu").toString());
        basicDiscBrakeEntity.setLinMuK(getDoubleValue(caliperLining.get("linMuK").toString()));
        basicDiscBrakeEntity.setLinMuE(getDoubleValue(caliperLining.get("linMuE").toString()));
        basicDiscBrakeEntity.setLinMuNp(getDoubleValue(caliperLining.get("linMuNp").toString()));
        basicDiscBrakeEntity.setLinArea(getDoubleValue(caliperLining.get("linArea").toString()));
        basicDiscBrakeEntity.setLinWearLim(getDoubleValue(caliperLining.get("linWearLim").toString()));
        basicDiscBrakeEntity.setFrtRtTempIn(caliperLining.get("frtRtTempIn").toString());
        basicDiscBrakeEntity.setFrtLinWearOut(caliperLining.get("frtLinWearOut").toString());
        basicDiscBrakeEntity.setFrtLinFrictOut(caliperLining.get("frtLinFrictOut").toString());
        basicDiscBrakeEntity.setInPerCorner(getDoubleValue(caliperLining.get("inPerCorner").toString()));
        basicDiscBrakeEntity.setRtType(caliperLining.get("rtType").toString());
        basicDiscBrakeEntity.setIsWork(0);
        basicDiscBrakeEntity.setUserId(getIntegerValue(caliperLining.get("userId").toString()));
        basicDiscBrakeEntity.setNotes(caliperLining.get("notes").toString());
        Object realRotor = getRealRotor(caliperLining, basicDiscBrakeEntity.getRtType());
        return getResponseBody(basicService.addNewDiscBrake(basicDiscBrakeEntity, realRotor));
    }

    @RequestMapping(value = "basic/discBrake/delete", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> deleteBasicDiscBrake(
            @RequestParam("description") String description,
            @RequestParam("userId") int userId
    ) {
        return getResponseBody(basicService.deleteDiscBrake(description, userId));
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

    public Object getRealRotor(Map<String, Object> rotor, String type) {
        if (type.equals("Vented") || type.equals("vented")) {
            BasicVentedRotorEntity basicVentedRotorEntity = new BasicVentedRotorEntity();
            basicVentedRotorEntity.setRrManu(rotor.get("rrManu").toString());
            basicVentedRotorEntity.setRrMat(rotor.get("rrMat").toString());
            basicVentedRotorEntity.setEfcR(getDoubleValue(rotor.get("efcR").toString()));
            basicVentedRotorEntity.setOutD(getDoubleValue(rotor.get("outD").toString()));
            basicVentedRotorEntity.setInD(getDoubleValue(rotor.get("inD").toString()));
            basicVentedRotorEntity.setCkTIn(rotor.get("ckTIn").toString());
            basicVentedRotorEntity.setCkTOut(rotor.get("ckTOut").toString());
            basicVentedRotorEntity.setRtT(getDoubleValue(rotor.get("rtT").toString()));
            basicVentedRotorEntity.setVaneNum(getIntegerValue(rotor.get("vaneNum").toString()));
            basicVentedRotorEntity.setVaneLen(getDoubleValue(rotor.get("vaneLen").toString()));
            basicVentedRotorEntity.setVaneHigh(getDoubleValue(rotor.get("vaneHigh").toString()));
            basicVentedRotorEntity.setVanT(getDoubleValue(rotor.get("vanT").toString()));
            basicVentedRotorEntity.setWm(getDoubleValue(rotor.get("wm").toString()));
            basicVentedRotorEntity.setWa(getDoubleValue(rotor.get("wa").toString()));
            basicVentedRotorEntity.setRho(getDoubleValue(rotor.get("rho").toString()));
            basicVentedRotorEntity.setCc50(getDoubleValue(rotor.get("cc50").toString()));
            basicVentedRotorEntity.setCc80(getDoubleValue(rotor.get("cc80").toString()));
            basicVentedRotorEntity.setCc110(getDoubleValue(rotor.get("cc110").toString()));
            basicVentedRotorEntity.setCvr50(getDoubleValue(rotor.get("cvr50").toString()));
            basicVentedRotorEntity.setCvr80(getDoubleValue(rotor.get("cvr80").toString()));
            basicVentedRotorEntity.setCvr110(getDoubleValue(rotor.get("cvr110").toString()));
            basicVentedRotorEntity.setRtTempIn(rotor.get("rtTempIn").toString());
            basicVentedRotorEntity.setRtSpecOut(rotor.get("rtSpecOut").toString());
            return basicVentedRotorEntity;
        } else if (type.equals("Solid") || type.equals("solid")) {
            BasicSolidRotorEntity basicSolidRotorEntity = new BasicSolidRotorEntity();
            basicSolidRotorEntity.setRrManu(rotor.get("manu").toString());
            basicSolidRotorEntity.setRrMat(rotor.get("rrMat").toString());
            basicSolidRotorEntity.setEfcR(getDoubleValue(rotor.get("rtEfcR").toString()));
            basicSolidRotorEntity.setOutD(getDoubleValue(rotor.get("outD").toString()));
            basicSolidRotorEntity.setInD(getDoubleValue(rotor.get("inD").toString()));
            basicSolidRotorEntity.setRtT(getDoubleValue(rotor.get("rtT").toString()));
            basicSolidRotorEntity.setWm(getDoubleValue(rotor.get("wm").toString()));
            basicSolidRotorEntity.setWa(getDoubleValue(rotor.get("wa").toString()));
            basicSolidRotorEntity.setRho(getDoubleValue(rotor.get("rho").toString()));
            basicSolidRotorEntity.setCc50(getDoubleValue(rotor.get("cc50").toString()));
            basicSolidRotorEntity.setCc80(getDoubleValue(rotor.get("cc80").toString()));
            basicSolidRotorEntity.setCc110(getDoubleValue(rotor.get("cc110").toString()));
            basicSolidRotorEntity.setCvr50(getDoubleValue(rotor.get("cvr50").toString()));
            basicSolidRotorEntity.setCvr80(getDoubleValue(rotor.get("cvr80").toString()));
            basicSolidRotorEntity.setCvr110(getDoubleValue(rotor.get("cvr110").toString()));
            basicSolidRotorEntity.setRtTempIn(rotor.get("rtTempIn").toString());
            basicSolidRotorEntity.setRtSpecOut(rotor.get("rtSpecOut").toString());
            return basicSolidRotorEntity;
        } else {
            BasicDrumRotorEntity basicDrumRotorEntity = new BasicDrumRotorEntity();
            basicDrumRotorEntity.setRrManu(rotor.get("rrManu").toString());
            basicDrumRotorEntity.setRrMat(rotor.get("rrMat").toString());
//            basicDrumRotorEntity.setSwpArea(getDoubleValue(rotor.get("swpArea").toString()));
            basicDrumRotorEntity.setSwpArea(null);
            basicDrumRotorEntity.setEfcR(getDoubleValue(rotor.get("efcR").toString()));
            basicDrumRotorEntity.setOutD(getDoubleValue(rotor.get("outD").toString()));
            basicDrumRotorEntity.setInD(getDoubleValue(rotor.get("inD").toString()));
            basicDrumRotorEntity.setRtThick(getDoubleValue(rotor.get("rtThick").toString()));
            basicDrumRotorEntity.setRibThick(getDoubleValue(rotor.get("ribThick").toString()));
            basicDrumRotorEntity.setRibWidth(getDoubleValue(rotor.get("ribWidth").toString()));
            basicDrumRotorEntity.setRtWidth(getDoubleValue(rotor.get("rtWidth").toString()));
            basicDrumRotorEntity.setWm(getDoubleValue(rotor.get("wm").toString()));
            basicDrumRotorEntity.setWa(getDoubleValue(rotor.get("wa").toString()));
            basicDrumRotorEntity.setRho(getDoubleValue(rotor.get("rho").toString()));
            basicDrumRotorEntity.setCc50(getDoubleValue(rotor.get("cc50").toString()));
            basicDrumRotorEntity.setCc80(getDoubleValue(rotor.get("cc80").toString()));
            basicDrumRotorEntity.setCc110(getDoubleValue(rotor.get("cc110").toString()));
            basicDrumRotorEntity.setCvr50(getDoubleValue(rotor.get("cvr50").toString()));
            basicDrumRotorEntity.setCvr80(getDoubleValue(rotor.get("cvr80").toString()));
            basicDrumRotorEntity.setCvr110(getDoubleValue(rotor.get("cvr110").toString()));
            basicDrumRotorEntity.setDmTempIn(rotor.get("dmTempIn").toString());
            basicDrumRotorEntity.setDmTempOut(rotor.get("dmTempOut").toString());
            return basicDrumRotorEntity;
        }
    }

    // basic drum brake
    @RequestMapping(value = "basic/drumBrake/desc", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getBasicDrumBrakeDesc(
            @RequestParam("userId") int userId
    ) {
        List<BasicDrumBrakeEntity> list = basicService.getBasicDrumBrakeDesc(userId);
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < list.size(); i ++) {
            Map<String, Object> single = new HashedMap();
            single.put("id", list.get(i).getId());
            single.put("desc", list.get(i).getDescription());
            result.add(single);
        }
        return getResponseBody(result);
    }

    @RequestMapping(value = "basic/drumBrake", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getBasicDrumBrake(
            @RequestParam("description") String description,
            @RequestParam("userId") int userId
    ) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            BasicDrumBrakeEntity basicDiscBrakeEntity = basicService.getBasicDrumBrake(description, userId);
            map.put("caliperLining", basicDiscBrakeEntity);
            if (basicDiscBrakeEntity.getRtType().equals("Vented") || basicDiscBrakeEntity.getRtType().equals("vented")) {
                map.put("rotor", basicService.getBasicVentedRotor(basicDiscBrakeEntity.getRtId()));
            } else if (basicDiscBrakeEntity.getRtType().equals("Solid") || basicDiscBrakeEntity.getRtType().equals("solid")) {
                map.put("rotor", basicService.getBasicSolidRotor(basicDiscBrakeEntity.getRtId()));
            } else {
                map.put("rotor", basicService.getBasicDrumRotor(basicDiscBrakeEntity.getRtId()));
            }
            return getResponseBody(map);
        } catch (Exception e) {
            return getResponseBody(null);
        }
    }

    @RequestMapping(value = "basic/drumBrake/check", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> checkBasicDrumBrakeDesc(
            @RequestParam("description") String description,
            @RequestParam("userId") int userId
    ) {
        List<BasicDrumBrakeEntity> list = basicService.getBasicDrumBrakeDesc(userId);
        List<String> descs = new ArrayList<String>();
        for (int i = 0; i < list.size(); i ++) {
            descs.add(list.get(i).getDescription());
        }
        return getResponseBody(descs.contains(description));
    }

    @RequestMapping(value = "basic/drumBrake/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> addNewBasicDrumBrake(
            @RequestBody Map<String, Object> caliperLining
    ) {
        try {
            BasicDrumBrakeEntity basicDrumBrakeEntity = new BasicDrumBrakeEntity();
            // caliperLining replace params
            basicDrumBrakeEntity.setDescription(caliperLining.get("description").toString());
            basicDrumBrakeEntity.setFrtType(caliperLining.get("frtType").toString());
            basicDrumBrakeEntity.setFrtManu(caliperLining.get("frtManu").toString());
            basicDrumBrakeEntity.setPstD(getDoubleValue(caliperLining.get("pstD").toString()));
            basicDrumBrakeEntity.setPstNum(getIntegerValue(caliperLining.get("pstNum").toString()));
            basicDrumBrakeEntity.setPstArea(getDoubleValue(caliperLining.get("pstArea").toString()));
            basicDrumBrakeEntity.setHfPT(getDoubleValue(caliperLining.get("hfPT").toString()));
            basicDrumBrakeEntity.setHfPV(getDoubleValue(caliperLining.get("hfPV").toString()));
            basicDrumBrakeEntity.setpVcurve(caliperLining.get("pVcurve").toString());
            basicDrumBrakeEntity.setPvK(getDoubleValue(caliperLining.get("pvK").toString()));
            basicDrumBrakeEntity.setPvB(getDoubleValue(caliperLining.get("pvB").toString()));
            basicDrumBrakeEntity.setPvC(getDoubleValue(caliperLining.get("pvC").toString()));
            basicDrumBrakeEntity.setLinSpl(caliperLining.get("linSpl").toString());
            basicDrumBrakeEntity.setLinMat(caliperLining.get("linMat").toString());
            basicDrumBrakeEntity.setLinMu(caliperLining.get("linMu").toString());
            basicDrumBrakeEntity.setLinMuK(getDoubleValue(caliperLining.get("linMuK").toString()));
            basicDrumBrakeEntity.setLinMuE(getDoubleValue(caliperLining.get("linMuE").toString()));
            basicDrumBrakeEntity.setLinMuNp(getDoubleValue(caliperLining.get("linMuNp").toString()));
            basicDrumBrakeEntity.setLinArea(getDoubleValue(caliperLining.get("linArea").toString()));
            basicDrumBrakeEntity.setLinWearLim(getDoubleValue(caliperLining.get("linWearLim").toString()));
            basicDrumBrakeEntity.setFrtRtTempIn(caliperLining.get("frtRtTempIn").toString());
            basicDrumBrakeEntity.setFrtLinWearOut(caliperLining.get("frtLinWearOut").toString());
            basicDrumBrakeEntity.setFrtLinFrictOut(caliperLining.get("frtLinFrictOut").toString());
            basicDrumBrakeEntity.setInPerCorner(getDoubleValue(caliperLining.get("inPerCorner").toString()));
            basicDrumBrakeEntity.setRtType(caliperLining.get("rtType").toString());
            basicDrumBrakeEntity.setUserId(getIntegerValue(caliperLining.get("userId").toString()));
            basicDrumBrakeEntity.setIsWork(0);
            basicDrumBrakeEntity.setNotes(caliperLining.get("notes").toString());
            Object realRotor = getRealRotor(caliperLining, basicDrumBrakeEntity.getRtType());
            return getResponseBody(basicService.addNewDrumBrake(basicDrumBrakeEntity, realRotor));
        } catch (Exception e) {
            System.out.println(e);
            return getResponseBody(false);
        }
    }

    @RequestMapping(value = "basic/drumBrake/delete", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> deleteBasicDrumBrake(
            @RequestParam("description") String description,
            @RequestParam("userId") int userId
    ) {
        return getResponseBody(basicService.deleteDrumBrake(description, userId));
    }

    // basic tire wheel
    @RequestMapping(value = "basic/tire/desc", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getBasicTireWheelDesc(
            @RequestParam("userId") int userId
    ) {
        List<BasicTireEntity> list = basicService.getBasicTireWheelDesc(userId);
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < list.size(); i ++) {
            Map<String, Object> single = new HashedMap();
            single.put("id", list.get(i).getId());
            single.put("desc", list.get(i).getDescription());
            result.add(single);
        }
        return getResponseBody(result);
    }

    @RequestMapping(value = "basic/tire", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getBasicTireWheel(
            @RequestParam("description") String description,
            @RequestParam("userId") int userId
    ) {
        return getResponseBody(basicService.getBasicTireWheel(description, userId));
    }

    @RequestMapping(value = "basic/tire/check", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> checkBasicTireWheel(
            @RequestParam("description") String description,
            @RequestParam("userId") int userId
    ) {
        List<BasicTireEntity> list = basicService.getBasicTireWheelDesc(userId);
        List<String> descs = new ArrayList<String>();
        for (int i = 0; i < list.size(); i ++) {
            descs.add(list.get(i).getDescription());
        }
        return getResponseBody(descs.contains(description));
    }

    @RequestMapping(value = "basic/tire/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> addNewBasicTireWheel(
            @RequestBody Map<String, Object> params
    ) {
        try {
            BasicTireEntity entity = new BasicTireEntity();
            entity.setDescription(params.get("description").toString());
            entity.setLvwTrFrt(getDoubleValue(params.get("lvwTrFrt").toString()));
            entity.setLvwTrRr(getDoubleValue(params.get("lvwTrRr").toString()));
            entity.setGvwTrFrt(getDoubleValue(params.get("gvwTrFrt").toString()));
            entity.setGvwTrRr(getDoubleValue(params.get("gvwTrRr").toString()));
            entity.setPeakAdhesLong(getDoubleValue(params.get("peakAdhesLong").toString()));
            entity.setPeakAdhesLat(getDoubleValue(params.get("peakAdhesLat").toString()));
            entity.setTracCoeff(getDoubleValue(params.get("tracCoeff").toString()));
            entity.setS(getDoubleValue(params.get("s").toString()));
            entity.setfR(getDoubleValue(params.get("fR").toString()));
            entity.setUserId(getIntegerValue(params.get("userId").toString()));
            entity.setIsWork(0);
            entity.setNotes(params.get("notes").toString());
            return getResponseBody(basicService.addNewTireWheel(entity));
        } catch (Exception e) {
            System.out.println(e);
            return getResponseBody(false);
        }
    }

    @RequestMapping(value = "basic/tire/delete", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> deleteBasicTire(
            @RequestParam("description") String description,
            @RequestParam("userId") int userId
    ) {
        return getResponseBody(basicService.deleteTireWheel(description, userId));
    }


    // basic vehicle
    @RequestMapping(value = "basic/vehicle/desc", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getBasicVehicleDesc(
            @RequestParam("userId") int userId
    ) {
        List<BasicVehicleEntity> list = basicService.getBasicVehicleDesc(userId);
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < list.size(); i ++) {
            Map<String, Object> single = new HashedMap();
            single.put("id", list.get(i).getId());
            single.put("desc", list.get(i).getDescription());
            result.add(single);
        }
        return getResponseBody(result);
    }

    @RequestMapping(value = "basic/vehicle", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getBasicVehicle(
            @RequestParam("description") String description,
            @RequestParam("userId") int userId
    ) {
        return getResponseBody(basicService.getBasicVehicle(description, userId));
    }

    @RequestMapping(value = "basic/vehicle/check", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> checkBasicVehicle(
            @RequestParam("description") String description,
            @RequestParam("userId") int userId
            ) {
        List<BasicVehicleEntity> list = basicService.getBasicVehicleDesc(userId);
        List<String> descs = new ArrayList<String>();
        for (int i = 0; i < list.size(); i ++) {
            descs.add(list.get(i).getDescription());
        }
        return getResponseBody(descs.contains(description));
    }

    @RequestMapping(value = "basic/vehicle/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> addNewBasicVehicle(
            @RequestBody Map<String, Object> params
    ) {
        try {
            BasicVehicleEntity entity = new BasicVehicleEntity();
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
            entity.setUserId(getIntegerValue(params.get("userId").toString()));
            entity.setNotes(params.get("notes").toString());
            return getResponseBody(basicService.addNewVehicle(entity));
        } catch (Exception e) {
            System.out.println(e);
            return getResponseBody(false);
        }
    }

    @RequestMapping(value = "basic/vehicle/delete", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> deleteBasicVehicle(
            @RequestParam("description") String description,
            @RequestParam("userId") int userId
    ) {
        return getResponseBody(basicService.deleteVehicle(description, userId));
    }

    // requirement
    @RequestMapping(value = "basic/require/desc", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getBasicRequirementDesc(
            @RequestParam("userId") int userId
    ) {
        List<BasicRequirementEntity> list = basicService.getBasicRequirementDesc(userId);
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < list.size(); i ++) {
            Map<String, Object> single = new HashedMap();
            single.put("id", list.get(i).getId());
            single.put("desc", list.get(i).getDescription());
            result.add(single);
        }
        return getResponseBody(result);
    }

    @RequestMapping(value = "basic/require", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getBasicRequirement(
            @RequestParam("description") String description,
            @RequestParam("userId") int userId
    ) {
        return getResponseBody(basicService.getBasicRequirement(description, userId));
    }

    @RequestMapping(value = "basic/require/check", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> checkBasicRequirement(
            @RequestParam("description") String description,
            @RequestParam("userId") int userId
    ) {
        List<BasicRequirementEntity> list = basicService.getBasicRequirementDesc(userId);
        List<String> descs = new ArrayList<String>();
        for (int i = 0; i < list.size(); i ++) {
            descs.add(list.get(i).getDescription());
        }
        return getResponseBody(descs.contains(description));
    }

    @RequestMapping(value = "basic/require/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> addNewBasicRequirement(
            @RequestBody Map<String, Object> params
    ) {
        try {
            BasicRequirementEntity entity = new BasicRequirementEntity();
            entity.setDescription(params.get("description").toString());
            entity.setSglVi(Double.valueOf(params.get("sglVi").toString()));
            entity.setSglV0(Double.valueOf(params.get("sglV0").toString()));
            entity.setFrtSglTmp(Double.valueOf(params.get("frtSglTmp").toString()));
            entity.setRrSglTmp(Double.valueOf(params.get("rrSglTmp").toString()));
            entity.setLinVi(Double.valueOf(params.get("linVi").toString()));
            entity.setLinV0(Double.valueOf(params.get("linV0").toString()));
            entity.setFrtLinPwr(Double.valueOf(params.get("frtLinPwr").toString()));
            entity.setRrLinPwr(Double.valueOf(params.get("rrLinPwr").toString()));
            entity.setHftVi(Double.valueOf(params.get("hftVi").toString()));
            entity.setHftV0(Double.valueOf(params.get("hftV0").toString()));
            entity.setFrtHftPwr(Double.valueOf(params.get("frtHftPwr").toString()));
            entity.setRrHftPwr(Double.valueOf(params.get("rrHftPwr").toString()));
            entity.setBet(params.get("bet").toString());
            entity.setBrakeStop(params.get("brakeStop").toString());
            entity.setPedalFeel(params.get("pedalFeel").toString());
            entity.setIsWork(0);
            entity.setUserId(getIntegerValue(params.get("userId").toString()));
            entity.setNotes(params.get("notes").toString());
            return getResponseBody(basicService.addNewRequirement(entity));
        } catch (Exception e) {
            System.out.println(e);
            return getResponseBody(false);
        }
    }

    @RequestMapping(value = "basic/require/delete", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> deleteBasicRequire(
            @RequestParam("description") String description,
            @RequestParam("userId") int userId
    ) {
        return getResponseBody(basicService.deleteRequirement(description, userId));
    }

    // Configuration!
    @RequestMapping(value = "basic/config/desc", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getBasicConfigurationDesc(
            @RequestParam("userId") int userId
    ) {
        List<ConfigurationEntity> list = basicService.getBasicConfigurationDesc(userId);
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < list.size(); i ++) {
            Map<String, Object> single = new HashedMap();
            single.put("id", list.get(i).getId());
            single.put("desc", list.get(i).getDescription());
            result.add(single);
        }
        return getResponseBody(result);
    }

    @RequestMapping(value = "basic/config", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getBasicConfiguration(
            @RequestParam("description") String description,
            @RequestParam("userId") int userId
    ) {
        return getResponseBody(basicService.getBasicConfiguration(description, userId));
    }

    @RequestMapping(value = "basic/config/check", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> checkBasicConfiguration(
            @RequestParam("description") String description,
            @RequestParam("userId") int userId
    ) {
        List<ConfigurationEntity> list = basicService.getBasicConfigurationDesc(userId);
        List<String> descs = new ArrayList<String>();
        for (int i = 0; i < list.size(); i ++) {
            descs.add(list.get(i).getDescription());
        }
        return getResponseBody(descs.contains(description));
    }

    @RequestMapping(value = "basic/config/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> addNewBasicConfiguration(
            @RequestBody Map<String, Object> params
    ) {
        ConfigurationEntity entity = new ConfigurationEntity();
        try {
            entity.setDescription(params.get("description").toString());
            entity.setVehicleDesc(params.get("vehicleDesc").toString());
            entity.setTireDesc(params.get("tireDesc").toString());
            entity.setApplyDesc(params.get("applyDesc").toString());
            entity.setControlDesc(params.get("controlDesc").toString());
            entity.setDiscBrakeDesc(params.get("discBrakeDesc").toString());
            entity.setDrumBrakeDesc(params.get("drumBrakeDesc").toString());
            entity.setRequireDesc(params.get("requireDesc").toString());
            entity.setIsWork(0);
            entity.setUserId(getIntegerValue(params.get("userId").toString()));
            entity.setNotes(params.get("notes").toString());
            return getResponseBody(basicService.addNewConfiguration(entity));
        } catch (Exception e) {
            System.out.println(e);
            return getResponseBody(false);
        }
    }

    @RequestMapping(value = "basic/config/delete", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> deleteBasicConfig(
            @RequestParam("description") String description,
            @RequestParam("userId") int userId
    ) {
        return getResponseBody(basicService.deleteConfiguration(description, userId));
    }

    // units!
    @RequestMapping(value = "units", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getUnits() {
        List<UnitsEntity> list = basicService.getUnits();
        Map<String, String> units = new HashMap<String, String>();
        for (int i = 0; i < list.size(); i ++) {
            units.put(list.get(i).getAttriName(), list.get(i).getUnitName());
        }
        return getResponseBody(units);
    }

    // images!
    @RequestMapping(value = "img", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getImages(HttpServletRequest request) {
        String schema = request.getScheme();
        String ip = request.getServerName();
        int port = request.getServerPort() ;
        String imageBase = schema + "://" + ip + ":" + port + "/style/images/figure";
        List<String> images = new ArrayList<String>();
        for (int i = 1; i < 14; i ++) {
            images.add(imageBase + i + ".png");
        }
        return getResponseBody(images);
    }

    // calculate
    @RequestMapping(value = "basic/calculate", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> manualCalculate(
            @RequestBody Map<String, Object> params
    ) {
        String path = servletContext.getRealPath("/style/images/");
        Map<String, Object> result = new HashedMap();
        try {
            Map<String, Map<String, Object>> parameter = getRealParams(params);
            UpdateWorkspace updateWorkspace = new UpdateWorkspace();
            List<String> descList = getRealDesc(params);
            updateWorkspace.setBasicService(basicService);
            updateWorkspace.setApply(descList.get(0));
            updateWorkspace.setControl(descList.get(1));
            updateWorkspace.setDiscBrake(descList.get(2));
            updateWorkspace.setDrumBrake(descList.get(3));
            updateWorkspace.setRequire(descList.get(4));
            updateWorkspace.setTire(descList.get(5));
            updateWorkspace.setVehicle(descList.get(6));
            updateWorkspace.setUserId(getIntegerValue(params.get("userId").toString()));
            Thread updateThread = new Thread(updateWorkspace);
            updateThread.start();
            result = MatlabManualCalculate.realCalculate(parameter, path);
            SaveToXlsx myRunnable = new SaveToXlsx();
            myRunnable.setParams(parameter);
            if (Boolean.valueOf(result.get("flag").toString())) {
                Map<String, Object> resultContent = (Map<String, Object>) result.get("content");
                myRunnable.setResultParams((Map<String, Object>) resultContent.get("numerical"));
                myRunnable.setPath(path);
                Thread thread = new Thread(myRunnable);
                thread.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getResponseBody(result);
    }

    public List<String> getRealDesc(Map<String, Object> params) {
        List<String> list = new ArrayList<String>();
        Map<String, Map<String, Object>> parameter = (Map<String, Map<String, Object>>) params.get("param");
        Map<String, Object> desc = (Map<String, Object>) params.get("desc");
        if (desc.get("apply") != null) {
            list.add(desc.get("apply").toString());
        } else {
            list.add(parameter.get("apply").get("description").toString());
        }
        if (desc.get("control") != null) {
            list.add(desc.get("control").toString());
        } else {
            list.add(parameter.get("control").get("description").toString());
        }
        if (desc.get("discBrake") != null) {
            list.add(desc.get("discBrake").toString());
        } else {
            list.add(parameter.get("discBrake").get("description").toString());
        }
        if (desc.get("drumBrake") != null) {
            list.add(desc.get("drumBrake").toString());
        } else {
            list.add(parameter.get("drumBrake").get("description").toString());
        }
        if (desc.get("requirement") != null) {
            list.add(desc.get("requirement").toString());
        } else {
            list.add(parameter.get("requirement").get("description").toString());
        }
        if (desc.get("tire") != null) {
            list.add(desc.get("tire").toString());
        } else {
            list.add(parameter.get("tire").get("description").toString());
        }
        if (desc.get("vehicle") != null) {
            list.add(desc.get("vehicle").toString());
        } else {
            list.add(parameter.get("vehicle").get("description").toString());
        }
        return list;
    }

    public Map<String, Map<String, Object>> getRealParams(Map<String, Object> params) {
        Map<String, Map<String, Object>> parameter = (Map<String, Map<String, Object>>) params.get("param");
        Map<String, Object> desc = (Map<String, Object>) params.get("desc");
        int userId = getIntegerValue(params.get("userId").toString());
        String[] keys = new String[]{"apply", "control", "discBrake", "drumBrake",
                "requirement", "tire", "vehicle"};
        if (desc.get("vehicle") != null) {
            BasicVehicleEntity vehicleEntity = basicService.getBasicVehicle(desc.get("vehicle").toString(), userId);
            Map<String, Object> vehicleMap = new HashedMap();
            vehicleMap.put("description", vehicleEntity.getDescription());
            vehicleMap.put("carModel", vehicleEntity.getCarModel());
            vehicleMap.put("carYear", vehicleEntity.getCarYear());
            vehicleMap.put("carAddInfo", vehicleEntity.getCarAddInfo());
            vehicleMap.put("lvwM", vehicleEntity.getLvwM());
            vehicleMap.put("gvwM", vehicleEntity.getGvwM());
            vehicleMap.put("lvwFrtR", vehicleEntity.getLvwFrtR());
            vehicleMap.put("gvwFrtR", vehicleEntity.getGvwFrtR());
            vehicleMap.put("lvwCgh", vehicleEntity.getLvwCgh());
            vehicleMap.put("gvwCgh", vehicleEntity.getGvwCgh());
            vehicleMap.put("l", vehicleEntity.getL());
            vehicleMap.put("vmax", vehicleEntity.getVmax());
            vehicleMap.put("wot", vehicleEntity.getWot());
            vehicleMap.put("coastDecel", vehicleEntity.getCoastDecel());
            vehicleMap.put("cd", vehicleEntity.getCd());
            vehicleMap.put("a", vehicleEntity.getA());
            vehicleMap.put("carDa", vehicleEntity.getCarDa());
            vehicleMap.put("notes", vehicleEntity.getNotes());
            parameter.put("vehicle", vehicleMap);
        }
        if (desc.get("tire") != null) {
            BasicTireEntity tireEntity = basicService.getBasicTireWheel(desc.get("tire").toString(), userId);
            Map<String, Object> tireMap = new HashedMap();
            tireMap.put("description", tireEntity.getDescription());
            tireMap.put("lvwTrFrt", tireEntity.getLvwTrFrt());
            tireMap.put("gvwTrFrt", tireEntity.getGvwTrFrt());
            tireMap.put("lvwTrRr", tireEntity.getLvwTrRr());
            tireMap.put("gvwTrRr", tireEntity.getGvwTrRr());
            tireMap.put("peakAdhesLong", tireEntity.getPeakAdhesLong());
            tireMap.put("peakAdhesLat", tireEntity.getPeakAdhesLat());
            tireMap.put("tracCoeff", tireEntity.getTracCoeff());
            tireMap.put("s", tireEntity.getS());
            tireMap.put("fR", tireEntity.getfR());
            tireMap.put("notes", tireEntity.getNotes());
            parameter.put("tire", tireMap);
        }
        if (desc.get("apply") != null) {
            BasicApplyEntity applyEntity = basicService.getBasicApply(desc.get("apply").toString(), userId);
            Map<String, Object> applyMap = new HashedMap();
            applyMap.put("description", applyEntity.getDescription());
            applyMap.put("pedSpl", applyEntity.getPedSpl());
            applyMap.put("pedRatio", applyEntity.getPedRatio());
            applyMap.put("pedFEff", applyEntity.getPedFEff());
            applyMap.put("pedTEff", applyEntity.getPedTEff());
            applyMap.put("mcdSpl", applyEntity.getMcdSpl());
            applyMap.put("mcdD", applyEntity.getMcdD());
            applyMap.put("bstSpl", applyEntity.getBstSpl());
            applyMap.put("bstSize", applyEntity.getBstSize());
            applyMap.put("bstGain", applyEntity.getBstGain());
            applyMap.put("bstFTotal", applyEntity.getBstFTotal());
            applyMap.put("apyFEff", applyEntity.getApyFEff());
            applyMap.put("bstFEff", applyEntity.getBstFEff());
            applyMap.put("mcdFEff", applyEntity.getMcdD());
            applyMap.put("apyTEff", applyEntity.getApyTEff());
            applyMap.put("bstTEff", applyEntity.getBstTEff());
            applyMap.put("mcdTEff", applyEntity.getMcdTEff());
            applyMap.put("bstFLsNp", applyEntity.getBstFLsNp());
            applyMap.put("bstTLs", applyEntity.getBstTLs());
            applyMap.put("bstFLsWp", applyEntity.getBstFLsWp());
            applyMap.put("bstFJmp", applyEntity.getBstFJmp());
            applyMap.put("bstVcm", applyEntity.getBstVcm());
            applyMap.put("altBstVcm", applyEntity.getAltBstVcm());
            applyMap.put("pedType", applyEntity.getPedType());
            applyMap.put("notes", applyEntity.getNotes());
            parameter.put("apply", applyMap);
        }
        if (desc.get("control") != null) {
            BasicControlEntity controlEntity = basicService.getBasicControl(desc.get("control").toString(), userId);
            Map<String, Object> controlMap = new HashedMap();
            controlMap.put("description", controlEntity.getDescription());
            controlMap.put("absSpl", controlEntity.getAbsSpl());
            controlMap.put("absType", controlEntity.getEffAbsFrt());
            controlMap.put("effAbsFrt", controlEntity.getEffAbsFrt());
            controlMap.put("effAbsRr", controlEntity.getEffAbsRr());
            controlMap.put("ebd", controlEntity.getEbd());
            controlMap.put("notes", controlEntity.getNotes());
            parameter.put("control", controlMap);
        }
        if (desc.get("discBrake") != null) {
            BasicDiscBrakeEntity discBrakeEntity = basicService.getBasicDiscBrake(desc.get("discBrake").toString(), userId);
            Map<String, Object> discBrakeMap = new HashedMap();
            discBrakeMap.put("rtType", discBrakeEntity.getRtType());
            discBrakeMap.put("description", discBrakeEntity.getDescription());
            discBrakeMap.put("frtType", discBrakeEntity.getFrtType());
            discBrakeMap.put("frtManu", discBrakeEntity.getFrtManu());
            discBrakeMap.put("pstD", discBrakeEntity.getPstD());
            discBrakeMap.put("pstNum", discBrakeEntity.getPstNum());
            discBrakeMap.put("hfPT", discBrakeEntity.getHfPT());
            discBrakeMap.put("hfPV", discBrakeEntity.getHfPV());
            discBrakeMap.put("pvK", discBrakeEntity.getPvK());
            discBrakeMap.put("pvB", discBrakeEntity.getPvB());
            discBrakeMap.put("pvC", discBrakeEntity.getPvC());
            discBrakeMap.put("linSpl", discBrakeEntity.getLinSpl());
            discBrakeMap.put("linMat", discBrakeEntity.getLinMat());
            discBrakeMap.put("linMuK", discBrakeEntity.getLinMuK());
            discBrakeMap.put("linMuE", discBrakeEntity.getLinMuE());
            discBrakeMap.put("linMuNp", discBrakeEntity.getLinMuNp());
            discBrakeMap.put("linArea", discBrakeEntity.getLinArea());
            discBrakeMap.put("linWearLim", discBrakeEntity.getLinWearLim());
            discBrakeMap.put("inPerCorner", discBrakeEntity.getInPerCorner());
            discBrakeMap.put("pstArea", discBrakeEntity.getPstArea());
            discBrakeMap.put("notes", discBrakeEntity.getNotes());
            discBrakeMap.put("frtRtTempIn", getList(discBrakeEntity.getFrtRtTempIn().toString()));
            discBrakeMap.put("frtLinWearOut", getList(discBrakeEntity.getFrtLinWearOut().toString()));
            discBrakeMap.put("frtLinFrictOut", getList(discBrakeEntity.getFrtLinFrictOut().toString()));
            discBrakeMap.put("pVcurve", getList(discBrakeEntity.getpVcurve().toString()));
            discBrakeMap.put("linMu", getList(discBrakeEntity.getLinMu().toString()));
            Map<String, Object> brakeLast = getRotorParam(discBrakeMap, discBrakeEntity.getRtType(), discBrakeEntity.getRtId());
            parameter.put("discBrake", brakeLast);
        }
        if (desc.get("drumBrake") != null) {
            BasicDrumBrakeEntity drumBrakeEntity = basicService.getBasicDrumBrake(desc.get("drumBrake").toString(), userId);

            Map<String, Object> drumBrakeMap = new HashedMap();
            drumBrakeMap.put("rtType", drumBrakeEntity.getRtType());
            drumBrakeMap.put("description", drumBrakeEntity.getDescription());
            drumBrakeMap.put("pstArea", drumBrakeEntity.getPstArea());
            drumBrakeMap.put("frtType", drumBrakeEntity.getFrtType());
            drumBrakeMap.put("frtManu", drumBrakeEntity.getFrtManu());
            drumBrakeMap.put("pstD", drumBrakeEntity.getPstD());
            drumBrakeMap.put("pstNum", drumBrakeEntity.getPstNum());
            drumBrakeMap.put("hfPT", drumBrakeEntity.getHfPT());
            drumBrakeMap.put("hfPV", drumBrakeEntity.getHfPV());
            drumBrakeMap.put("pvK", drumBrakeEntity.getPvK());
            drumBrakeMap.put("pvB", drumBrakeEntity.getPvB());
            drumBrakeMap.put("pvC", drumBrakeEntity.getPvC());
            drumBrakeMap.put("linSpl", drumBrakeEntity.getLinSpl());
            drumBrakeMap.put("linMat", drumBrakeEntity.getLinMat());
            drumBrakeMap.put("insulator", drumBrakeEntity.getInsulator());
            drumBrakeMap.put("linMuK", drumBrakeEntity.getLinMuK());
            drumBrakeMap.put("linMuE", drumBrakeEntity.getLinMuE());
            drumBrakeMap.put("linMuNp", drumBrakeEntity.getLinMuNp());
            drumBrakeMap.put("linArea", drumBrakeEntity.getLinArea());
            drumBrakeMap.put("linWearLim", drumBrakeEntity.getLinWearLim());
            drumBrakeMap.put("inPerCorner", drumBrakeEntity.getInPerCorner());
            drumBrakeMap.put("notes", drumBrakeEntity.getNotes());
            drumBrakeMap.put("frtRtTempIn", getList(drumBrakeEntity.getFrtRtTempIn().toString()));
            drumBrakeMap.put("frtLinWearOut", getList(drumBrakeEntity.getFrtLinWearOut().toString()));
            drumBrakeMap.put("frtLinFrictOut", getList(drumBrakeEntity.getFrtLinFrictOut().toString()));
            drumBrakeMap.put("pVcurve", getList(drumBrakeEntity.getpVcurve().toString()));
            drumBrakeMap.put("linMu", getList(drumBrakeEntity.getLinMu().toString()));
            Map<String, Object> brakeLast = getRotorParam(drumBrakeMap, drumBrakeEntity.getRtType(), drumBrakeEntity.getRtId());
            parameter.put("drumBrake", brakeLast);
        }
        if (desc.get("requirement") != null) {
            BasicRequirementEntity requirementEntity = basicService.getBasicRequirement(desc.get("requirement").toString(), userId);
            Map<String, Object> requirement = new HashedMap();
            requirement.put("description", requirementEntity.getDescription());
            requirement.put("sglVi", requirementEntity.getSglVi());
            requirement.put("sglV0", requirementEntity.getSglV0());
            requirement.put("frtSglTmp", requirementEntity.getFrtSglTmp());
            requirement.put("rrSglTmp", requirementEntity.getRrSglTmp());
            requirement.put("linVi", requirementEntity.getLinVi());
            requirement.put("linV0", requirementEntity.getLinV0());
            requirement.put("frtLinPwr", requirementEntity.getFrtLinPwr());
            requirement.put("rrLinPwr", requirementEntity.getRrLinPwr());
            requirement.put("hftVi", requirementEntity.getHftVi());
            requirement.put("hftV0", requirementEntity.getHftV0());
            requirement.put("frtHftPwr", requirementEntity.getFrtHftPwr());
            requirement.put("rrHftPwr", requirementEntity.getRrHftPwr());
            requirement.put("notes", requirementEntity.getNotes());
            requirement.put("bet", getList(requirementEntity.getBet()));
            requirement.put("brakeStop", getList(requirementEntity.getBrakeStop()));
            requirement.put("pedalFeel", getList(requirementEntity.getPedalFeel()));
            parameter.put("requirement", requirement);
        }
        return parameter;
    }

    public Map<String, Object> getRotorParam(Map<String, Object> brake, String type, int rotorId) {
        if (type.equals("Vented") || type.equals("vented")) {
            BasicVentedRotorEntity ventedRotorEntity = basicService.getBasicVentedRotor(rotorId);
            brake.put("rrManu", ventedRotorEntity.getRrManu());
            brake.put("rrMat", ventedRotorEntity.getRrMat());
            brake.put("efcR", ventedRotorEntity.getEfcR());
            brake.put("outD", ventedRotorEntity.getOutD());
            brake.put("inD", ventedRotorEntity.getInD());
            brake.put("ckTIn", ventedRotorEntity.getCkTIn());
            brake.put("ckTOut", ventedRotorEntity.getCkTOut());
            brake.put("rtT", ventedRotorEntity.getRtT());
            brake.put("vaneNum", ventedRotorEntity.getVaneNum());
            brake.put("vaneLen", ventedRotorEntity.getVaneLen());
            brake.put("vaneHigh", ventedRotorEntity.getVaneHigh());
            brake.put("vanT", ventedRotorEntity.getVanT());
            brake.put("wm", ventedRotorEntity.getWm());
            brake.put("wa", ventedRotorEntity.getWa());
            brake.put("rho", ventedRotorEntity.getRho());
            brake.put("cc50", ventedRotorEntity.getCc50());
            brake.put("cc80", ventedRotorEntity.getCc80());
            brake.put("cc110", ventedRotorEntity.getCc110());
            brake.put("cvr50", ventedRotorEntity.getCvr50());
            brake.put("cvr80", ventedRotorEntity.getCvr80());
            brake.put("cvr110", ventedRotorEntity.getCvr110());
            brake.put("rtTempIn", getList(ventedRotorEntity.getRtTempIn()));
            brake.put("rtSpecOut", getList(ventedRotorEntity.getRtSpecOut()));
        } else if (type.equals("Solid") || type.equals("solid")) {
            BasicSolidRotorEntity solidRotorEntity = basicService.getBasicSolidRotor(rotorId);
            brake.put("manu", solidRotorEntity.getRrManu());
            brake.put("rrMat", solidRotorEntity.getRrMat());
            brake.put("rtEfcR", solidRotorEntity.getEfcR());
            brake.put("outD", solidRotorEntity.getOutD());
            brake.put("inD", solidRotorEntity.getInD());
            brake.put("rtT", solidRotorEntity.getRtT());
            brake.put("wm", solidRotorEntity.getWm());
            brake.put("wa", solidRotorEntity.getWa());
            brake.put("rho", solidRotorEntity.getRho());
            brake.put("cc50", solidRotorEntity.getCc50());
            brake.put("cc80", solidRotorEntity.getCc80());
            brake.put("cc110", solidRotorEntity.getCc110());
            brake.put("cvr50", solidRotorEntity.getCvr50());
            brake.put("cvr80", solidRotorEntity.getCvr80());
            brake.put("cvr110", solidRotorEntity.getCvr110());
            brake.put("rtTempIn", getList(solidRotorEntity.getRtTempIn()));
            brake.put("rtSpecOut", getList(solidRotorEntity.getRtSpecOut()));
        } else {
            BasicDrumRotorEntity drumRotorEntity = basicService.getBasicDrumRotor(rotorId);
            brake.put("rrManu", drumRotorEntity.getRrManu());
            brake.put("rrMat", drumRotorEntity.getRrMat());
            //  basicDrumRotorEntity.setSwpArea(null);
            brake.put("efcR", drumRotorEntity.getEfcR());
            brake.put("outD", drumRotorEntity.getOutD());
            brake.put("inD", drumRotorEntity.getInD());
            brake.put("rtThick", drumRotorEntity.getRtThick());
            brake.put("ribThick", drumRotorEntity.getRibThick());
            brake.put("ribWidth", drumRotorEntity.getRibWidth());
            brake.put("rtWidth", drumRotorEntity.getRtWidth());
            brake.put("wm", drumRotorEntity.getWm());
            brake.put("wa", drumRotorEntity.getWa());
            brake.put("rho", drumRotorEntity.getRho());
            brake.put("cc50", drumRotorEntity.getCc50());
            brake.put("cc80", drumRotorEntity.getCc80());
            brake.put("cc110", drumRotorEntity.getCc110());
            brake.put("cvr50", drumRotorEntity.getCvr50());
            brake.put("cvr80", drumRotorEntity.getCvr80());
            brake.put("cvr110", drumRotorEntity.getCvr110());
            brake.put("dmTempIn", getList(drumRotorEntity.getDmTempIn()));
            brake.put("dmTempOut", getList(drumRotorEntity.getDmTempOut()));
        }
        return brake;
    }

    public List<String> getList(String str) {
        String[] strArray = str.split("\\[|\\]|, ");
        List<String> last = new ArrayList<String>();
        for (int i = 0; i < strArray.length; i ++) {
            if ((strArray[i] != null) && (!strArray[i].equals(""))) {
                last.add(strArray[i]);
            }
        }
        return last;
    }

    @RequestMapping(value = "download/figure/{figure_id}", method = RequestMethod.GET, consumes="*")
    public ResponseEntity<byte[]> downloadHeatIsland(
            @PathVariable("figure_id") int figureId
    ) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        String path = servletContext.getRealPath("/style/images/");
//        File file=new File(MatlabManualCalculate.downloadFigureData(path, figureId));
        File file=new File(path + "figure_"+ figureId +".xlsx");
        headers.setContentDispositionFormData("attachment", "figure_"+ figureId +".xlsx");
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
                headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "download/parameter", method = RequestMethod.GET, consumes="*")
    public ResponseEntity<byte[]> downloadParam() throws IOException{
        HttpHeaders headers = new HttpHeaders();
        String path = servletContext.getRealPath("/style/images/");
        File file=new File(path + "param.xlsx");
        headers.setContentDispositionFormData("attachment", "param.xlsx");
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
                headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "basic/pf2pm", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> PFCurve2Param(
            @RequestBody Map<String, Object> params
    ) {
        Map<String, Double> coeff = MatlabManualCalculate.PFCurve2Param(params);
        return getResponseBody(coeff);
    }

    @RequestMapping(value = "basic/pv2pm", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> PVCurve2Param(
            @RequestBody Map<String, Object> params
    ) {
        Map<String, Double> coeff = MatlabManualCalculate.PVCurve2Param(params);
        return getResponseBody(coeff);
    }

    @RequestMapping(value = "basic/workspace", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getWorkspace(
            @RequestParam("userId") int userId
    ) {
        Map<String, String> map = basicService.getWorkspace(userId);
        return getResponseBody(map);
    }

}
