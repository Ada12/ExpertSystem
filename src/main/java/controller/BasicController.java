package controller;

import entity.*;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.BasicService;
import service.MatlabManualCalculate;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @RequestMapping(value = "basic/apply/desc", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getBasicApplyDesc() {
        List<BasicApplyEntity> list = basicService.getBasicApplyDesc();
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
            @RequestParam("description") String description
    ) {
        return getResponseBody(basicService.getBasicApply(description));
    }

    @RequestMapping(value = "basic/apply/check", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> checkBasicApply(
            @RequestParam("description") String description
    ) {
        List<BasicApplyEntity> list = basicService.getBasicApplyDesc();
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
            entity.setPedRatio(String.valueOf(params.get("pedRatio")));
            entity.setPedFEff(Double.valueOf(params.get("pedFEff").toString()));
            entity.setPedTEff((Double.valueOf(params.get("pedTEff").toString())));
            entity.setPedType(Integer.valueOf(params.get("pedType").toString()));
            entity.setBstSize(Double.valueOf(params.get("bstSize").toString()));
            entity.setBstGain(Double.valueOf(params.get("bstGain").toString()));
            entity.setBstFTotal(Double.valueOf(params.get("bstFTotal").toString()));
            entity.setBstFEff(Double.valueOf(params.get("bstFEff").toString()));
            entity.setBstTEff(Double.valueOf(params.get("bstTEff").toString()));
            entity.setBstFLsNp(Double.valueOf(params.get("bstFLsNp").toString()));
            entity.setBstFLsWp(Double.valueOf(params.get("bstFLsWp").toString()));
            entity.setBstFJmp((Double.valueOf(params.get("bstFJmp").toString())));
            entity.setBstTLs(Double.valueOf(params.get("bstTLs").toString()));
            entity.setBstVcm(Double.valueOf(params.get("bstVcm").toString()));
            entity.setAltBstVcm(Double.valueOf(params.get("altBstVcm").toString()));
            entity.setMcdD((Double.valueOf(params.get("mcdD").toString())));
            entity.setMcdFEff(Double.valueOf(params.get("mcdFEff").toString()));
            entity.setMcdTEff(Double.valueOf(params.get("mcdTEff").toString()));
            entity.setApyFEff(Double.valueOf(params.get("apyFEff").toString()));
            entity.setApyTEff(Double.valueOf(params.get("apyTEff").toString()));
            entity.setNotes((String) params.get("notes"));
            return getResponseBody(basicService.addNewApply(entity));
        } catch (Exception e) {
            System.out.println(e);
            return getResponseBody(false);
        }
    }

    // basic control
    @RequestMapping(value = "basic/control/desc", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getBasicControlDesc() {
        List<BasicControlEntity> list = basicService.getBasicControlDesc();
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
            @RequestParam("description") String description
    ) {
        return getResponseBody(basicService.getBasicControl(description));
    }

    @RequestMapping(value = "basic/control/check", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> checkBasicControl(
            @RequestParam("description") String description
    ) {
        List<BasicControlEntity> list = basicService.getBasicControlDesc();
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
            entity.setEffAbsFrt(Double.valueOf(params.get("effAbsFrt").toString()));
            entity.setEffAbsRr(Double.valueOf(params.get("effAbsRr").toString()));
            entity.setPeakTire(params.get("peakTire").toString());
            entity.setEffDrive(params.get("effDrive").toString());
            entity.setNotes(params.get("notes").toString());
            return getResponseBody(basicService.addNewControl(entity));
        } catch (Exception e) {
            System.out.println(e);
            return getResponseBody(false);
        }
    }

    // basic disc brake
    @RequestMapping(value = "basic/discBrake/desc", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getBasicDiscBrakeDesc() {
        List<BasicDiscBrakeEntity> list = basicService.getBasicDiscBrakeDesc();
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
            @RequestParam("description") String description
    ) {
        Map<String, Object> map = new HashMap<String, Object>();
        BasicDiscBrakeEntity basicDiscBrakeEntity = basicService.getBasicDiscBrake(description);
        map.put("caliperLining", basicDiscBrakeEntity);
        if (basicDiscBrakeEntity.getRtType().equals("Vented") || basicDiscBrakeEntity.getRtType().equals("vented")) {
            map.put("rotor", basicService.getBasicVentedRotor(basicDiscBrakeEntity.getRtId()));
        } else if (basicDiscBrakeEntity.getRtType().equals("Solid") || basicDiscBrakeEntity.getRtType().equals("solid")) {
            map.put("rotor", basicService.getBasicSolidRotor(basicDiscBrakeEntity.getRtId()));
        } else {
            map.put("rotor", basicService.getBasicDrumRotor(basicDiscBrakeEntity.getRtId()));
        }
        return getResponseBody(map);
    }

    @RequestMapping(value = "basic/discBrake/check", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> checkBasicDiscBrake(
            @RequestParam("description") String description
    ) {
        List<BasicDiscBrakeEntity> list = basicService.getBasicDiscBrakeDesc();
        List<String> descs = new ArrayList<String>();
        for (int i = 0; i < list.size(); i ++) {
            descs.add(list.get(i).getDescription());
        }
        return getResponseBody(descs.contains(description));
    }

    @RequestMapping(value = "basic/discBrake/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> addNewBasicDiscBrake(
            @RequestBody Map<String, Map<String, Object>> params
    ) {
        Map<String, Object> caliperLining = params.get("caliperLining");
        BasicDiscBrakeEntity basicDiscBrakeEntity = new BasicDiscBrakeEntity();
        basicDiscBrakeEntity.setDescription(caliperLining.get("description").toString());
        basicDiscBrakeEntity.setPstD(Double.valueOf(caliperLining.get("pstD").toString()));
        basicDiscBrakeEntity.setPstNum(Integer.valueOf(caliperLining.get("pstNum").toString()));
        basicDiscBrakeEntity.setPstArea(Double.valueOf(caliperLining.get("pstArea").toString()));
        basicDiscBrakeEntity.setHfP(Double.valueOf(caliperLining.get("hfP").toString()));
        basicDiscBrakeEntity.setpVcurve(caliperLining.get("pVcurve").toString());
        basicDiscBrakeEntity.setPvK(Double.valueOf(caliperLining.get("pvK").toString()));
        basicDiscBrakeEntity.setPvB(Double.valueOf(caliperLining.get("pvB").toString()));
        basicDiscBrakeEntity.setPvC(Double.valueOf(caliperLining.get("pvC").toString()));
        basicDiscBrakeEntity.setLinMat(caliperLining.get("linMat").toString());
        basicDiscBrakeEntity.setLinMu(Double.valueOf(caliperLining.get("linMu").toString()));
        basicDiscBrakeEntity.setLinMuK(Double.valueOf(caliperLining.get("linMuK").toString()));
        basicDiscBrakeEntity.setLinMuE(Double.valueOf(caliperLining.get("linMuE").toString()));
        basicDiscBrakeEntity.setLinMuNp(Double.valueOf(caliperLining.get("linMuNp").toString()));
        basicDiscBrakeEntity.setLinArea(Double.valueOf(caliperLining.get("linArea").toString()));
        basicDiscBrakeEntity.setLinWearLim(Double.valueOf(caliperLining.get("linWearLim").toString()));
        basicDiscBrakeEntity.setFrtRtTempIn(caliperLining.get("frtRtTempIn").toString());
        basicDiscBrakeEntity.setFrtLinWearOut(caliperLining.get("frtLinWearOut").toString());
        basicDiscBrakeEntity.setFrtLinFrictOut(caliperLining.get("frtLinFrictOut").toString());
        basicDiscBrakeEntity.setInPerCorner(Double.valueOf(caliperLining.get("inPerCorner").toString()));
        basicDiscBrakeEntity.setRtType(caliperLining.get("rtType").toString());
        basicDiscBrakeEntity.setNotes(caliperLining.get("notes").toString());
        Map<String, Object> rotor = params.get("rotor");
        Object realRotor = getRealRotor(rotor, basicDiscBrakeEntity.getRtType());
        return getResponseBody(basicService.addNewDiscBrake(basicDiscBrakeEntity, realRotor));
//        try {
//
//        } catch (Exception e) {
//            System.out.println(e);
//            return getResponseBody(false);
//        }
    }

    public Object getRealRotor(Map<String, Object> rotor, String type) {
        if (type.equals("Vented") || type.equals("vented")) {
            BasicVentedRotorEntity basicVentedRotorEntity = new BasicVentedRotorEntity();
            basicVentedRotorEntity.setRtSwpArea(Double.valueOf(rotor.get("rtSwpArea").toString()));
            basicVentedRotorEntity.setRtEfcR(Double.valueOf(rotor.get("rtEfcR").toString()));
            basicVentedRotorEntity.setRtDiaOut(Double.valueOf(rotor.get("rtDiaOut").toString()));
            basicVentedRotorEntity.setRtDiaIn(Double.valueOf(rotor.get("rtDiaIn").toString()));
            basicVentedRotorEntity.setRtCkIn(rotor.get("rtCkIn").toString());
            basicVentedRotorEntity.setRtCkOut(rotor.get("rtCkOut").toString());
            basicVentedRotorEntity.setRtT(Double.valueOf(rotor.get("rtT").toString()));
            basicVentedRotorEntity.setRtVanNum(Integer.valueOf(rotor.get("rtVanNum").toString()));
            basicVentedRotorEntity.setRtVanLen(Double.valueOf(rotor.get("rtVanLen").toString()));
            basicVentedRotorEntity.setRtVaneHigh(Double.valueOf(rotor.get("rtVaneHigh").toString()));
            basicVentedRotorEntity.setRtVanT(Double.valueOf(rotor.get("rtVanT").toString()));
            basicVentedRotorEntity.setRtWm(Double.valueOf(rotor.get("rtWm").toString()));
            basicVentedRotorEntity.setRtWa(Double.valueOf(rotor.get("rtWa").toString()));
            basicVentedRotorEntity.setRho(Double.valueOf(rotor.get("rho").toString()));
            basicVentedRotorEntity.setCc50(Double.valueOf(rotor.get("cc50").toString()));
            basicVentedRotorEntity.setCc80(Double.valueOf(rotor.get("cc80").toString()));
            basicVentedRotorEntity.setCc110(Double.valueOf(rotor.get("cc110").toString()));
            basicVentedRotorEntity.setCvr50(Double.valueOf(rotor.get("cvr50").toString()));
            basicVentedRotorEntity.setCvr80(Double.valueOf(rotor.get("cvr80").toString()));
            basicVentedRotorEntity.setCvr110(Double.valueOf(rotor.get("cvr110").toString()));
            basicVentedRotorEntity.setRtTempIn(rotor.get("rtTempIn").toString());
            basicVentedRotorEntity.setRtSpecOut(rotor.get("rtSpecOut").toString());
            return basicVentedRotorEntity;
        } else if (type.equals("Solid") || type.equals("solid")) {
            BasicSolidRotorEntity basicSolidRotorEntity = new BasicSolidRotorEntity();
            basicSolidRotorEntity.setRtSwpArea(Double.valueOf(rotor.get("rtSwpArea").toString()));
            basicSolidRotorEntity.setRtEfcR(Double.valueOf(rotor.get("rtEfcR").toString()));
            basicSolidRotorEntity.setRtDiaOut(Double.valueOf(rotor.get("rtDiaOut").toString()));
            basicSolidRotorEntity.setRtDiaIn(Double.valueOf(rotor.get("rtDiaIn").toString()));
            basicSolidRotorEntity.setRtT(Double.valueOf(rotor.get("rtT").toString()));
            basicSolidRotorEntity.setRtWm(Double.valueOf(rotor.get("rtWm").toString()));
            basicSolidRotorEntity.setRtWa(Double.valueOf(rotor.get("rtWa").toString()));
            basicSolidRotorEntity.setRho(Double.valueOf(rotor.get("rho").toString()));
            basicSolidRotorEntity.setCc50(Double.valueOf(rotor.get("cc50").toString()));
            basicSolidRotorEntity.setCc80(Double.valueOf(rotor.get("cc80").toString()));
            basicSolidRotorEntity.setCc110(Double.valueOf(rotor.get("cc110").toString()));
            basicSolidRotorEntity.setCvr50(Double.valueOf(rotor.get("cvr50").toString()));
            basicSolidRotorEntity.setCvr80(Double.valueOf(rotor.get("cvr80").toString()));
            basicSolidRotorEntity.setCvr110(Double.valueOf(rotor.get("cvr110").toString()));
            basicSolidRotorEntity.setRtTempIn(rotor.get("rtTempIn").toString());
            basicSolidRotorEntity.setRtSpecOut(rotor.get("rtSpecOut").toString());
            return basicSolidRotorEntity;
        } else {
            BasicDrumRotorEntity basicDrumRotorEntity = new BasicDrumRotorEntity();
            basicDrumRotorEntity.setRtEfcR(Double.valueOf(rotor.get("rtEfcR").toString()));
            basicDrumRotorEntity.setOdDm(Double.valueOf(rotor.get("odDm").toString()));
            basicDrumRotorEntity.setIdDm(Double.valueOf(rotor.get("idDm").toString()));
            basicDrumRotorEntity.setThDm(Double.valueOf(rotor.get("thDm").toString()));
            basicDrumRotorEntity.setWdDm(Double.valueOf(rotor.get("wdDm").toString()));
            basicDrumRotorEntity.setJthDm(Double.valueOf(rotor.get("jthDm").toString()));
            basicDrumRotorEntity.setRtVaneHigh(Double.valueOf(rotor.get("rtVaneHigh").toString()));
            basicDrumRotorEntity.setRtWm(Double.valueOf(rotor.get("rtWm").toString()));
            basicDrumRotorEntity.setRtWa(Double.valueOf(rotor.get("rtWa").toString()));
            basicDrumRotorEntity.setRho(Double.valueOf(rotor.get("rho").toString()));
            basicDrumRotorEntity.setCc50(Double.valueOf(rotor.get("cc50").toString()));
            basicDrumRotorEntity.setCc80(Double.valueOf(rotor.get("cc80").toString()));
            basicDrumRotorEntity.setCc110(Double.valueOf(rotor.get("cc110").toString()));
            basicDrumRotorEntity.setCvr50(Double.valueOf(rotor.get("cvr50").toString()));
            basicDrumRotorEntity.setCvr80(Double.valueOf(rotor.get("cvr80").toString()));
            basicDrumRotorEntity.setCvr110(Double.valueOf(rotor.get("cvr110").toString()));
            basicDrumRotorEntity.setDmTempIn(rotor.get("dmTempIn").toString());
            basicDrumRotorEntity.setDmTempOut(rotor.get("dmTempOut").toString());
            return basicDrumRotorEntity;
        }
    }

    // basic drum brake
    @RequestMapping(value = "basic/drumBrake/desc", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getBasicDrumBrakeDesc() {
        List<BasicDrumBrakeEntity> list = basicService.getBasicDrumBrakeDesc();
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
            @RequestParam("description") String description
    ) {
        Map<String, Object> map = new HashMap<String, Object>();
        BasicDrumBrakeEntity basicDiscBrakeEntity = basicService.getBasicDrumBrake(description);
        map.put("caliperLining", basicDiscBrakeEntity);
        if (basicDiscBrakeEntity.getRtType().equals("Vented") || basicDiscBrakeEntity.getRtType().equals("vented")) {
            map.put("rotor", basicService.getBasicVentedRotor(basicDiscBrakeEntity.getRtId()));
        } else if (basicDiscBrakeEntity.getRtType().equals("Solid") || basicDiscBrakeEntity.getRtType().equals("solid")) {
            map.put("rotor", basicService.getBasicSolidRotor(basicDiscBrakeEntity.getRtId()));
        } else {
            map.put("rotor", basicService.getBasicDrumRotor(basicDiscBrakeEntity.getRtId()));
        }
        return getResponseBody(map);
    }

    @RequestMapping(value = "basic/drumBrake/check", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> checkBasicDrumBrakeDesc(
            @RequestParam("description") String description
    ) {
        List<BasicDrumBrakeEntity> list = basicService.getBasicDrumBrakeDesc();
        List<String> descs = new ArrayList<String>();
        for (int i = 0; i < list.size(); i ++) {
            descs.add(list.get(i).getDescription());
        }
        return getResponseBody(descs.contains(description));
    }

    @RequestMapping(value = "basic/drumBrake/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> addNewBasicDrumBrake(
            @RequestBody Map<String, Map<String, Object>> params
    ) {
        try {
            BasicDrumBrakeEntity basicDrumBrakeEntity = new BasicDrumBrakeEntity();
            Map<String, Object> caliperLining = params.get("caliperLining");
            basicDrumBrakeEntity.setDescription(caliperLining.get("description").toString());
            basicDrumBrakeEntity.setcDia(Double.valueOf(caliperLining.get("cDia").toString()));
            basicDrumBrakeEntity.setPstNum(Integer.valueOf(caliperLining.get("pstNum").toString()));
            basicDrumBrakeEntity.setPstArea(Double.valueOf(caliperLining.get("pstArea").toString()));
            basicDrumBrakeEntity.setcHp(Double.valueOf(caliperLining.get("cHp").toString()));
            basicDrumBrakeEntity.setpVcurve(caliperLining.get("pVcurve").toString());
            basicDrumBrakeEntity.setPvK(Double.valueOf(caliperLining.get("pvK").toString()));
            basicDrumBrakeEntity.setPvB(Double.valueOf(caliperLining.get("pvB").toString()));
            basicDrumBrakeEntity.setPvC(Double.valueOf(caliperLining.get("pvC").toString()));
            basicDrumBrakeEntity.setLinMat(caliperLining.get("linMat").toString());
            basicDrumBrakeEntity.setLinMu(Double.valueOf(caliperLining.get("linMu").toString()));
            basicDrumBrakeEntity.setLinMuK(Double.valueOf(caliperLining.get("linMuK").toString()));
            basicDrumBrakeEntity.setLinMuE(Double.valueOf(caliperLining.get("linMuE").toString()));
            basicDrumBrakeEntity.setLinMuNp(Double.valueOf(caliperLining.get("linMuNp").toString()));
            basicDrumBrakeEntity.setLinArea(Double.valueOf(caliperLining.get("linArea").toString()));
            basicDrumBrakeEntity.setLinWearLim(Double.valueOf(caliperLining.get("linWearLim").toString()));
            basicDrumBrakeEntity.setFrtRtTempIn(caliperLining.get("frtRtTempIn").toString());
            basicDrumBrakeEntity.setFrtLinWearOut(caliperLining.get("frtLinWearOut").toString());
            basicDrumBrakeEntity.setFrtLinFrictOut(caliperLining.get("frtLinFrictOut").toString());
            basicDrumBrakeEntity.setInPerCorner(Double.valueOf(caliperLining.get("inPerCorner").toString()));
            basicDrumBrakeEntity.setRtType(caliperLining.get("rtType").toString());
            basicDrumBrakeEntity.setNotes(caliperLining.get("notes").toString());
            Map<String, Object> rotor = params.get("rotor");
            Object realRotor = getRealRotor(rotor, basicDrumBrakeEntity.getRtType());
            return getResponseBody(basicService.addNewDrumBrake(basicDrumBrakeEntity, realRotor));
        } catch (Exception e) {
            System.out.println(e);
            return getResponseBody(false);
        }
    }

    // basic tire wheel
    @RequestMapping(value = "basic/tire/desc", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getBasicTireWheelDesc() {
        List<BasicTireEntity> list = basicService.getBasicTireWheelDesc();
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
            @RequestParam("description") String description
    ) {
        return getResponseBody(basicService.getBasicTireWheel(description));
    }

    @RequestMapping(value = "basic/tire/check", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> checkBasicTireWheel(
            @RequestParam("description") String description
    ) {
        List<BasicTireEntity> list = basicService.getBasicTireWheelDesc();
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
            entity.setLvwTrFrt(Double.valueOf(params.get("lvwTrFrt").toString()));
            entity.setLvwTrRr(Double.valueOf(params.get("lvwTrRr").toString()));
            entity.setGvwTrFrt(Double.valueOf(params.get("gvwTrFrt").toString()));
            entity.setGvwTrRr(Double.valueOf(params.get("gvwTrRr").toString()));
            entity.setPeakAdhesLong(Double.valueOf(params.get("peakAdhesLong").toString()));
            entity.setPeakAdhesLat(Double.valueOf(params.get("peakAdhesLat").toString()));
            entity.setTracCoeff(Double.valueOf(params.get("tracCoeff").toString()));
            entity.setS(Double.valueOf(params.get("s").toString()));
            entity.setfR(Double.valueOf(params.get("fR").toString()));
            entity.setNotes(params.get("notes").toString());
            return getResponseBody(basicService.addNewTireWheel(entity));
        } catch (Exception e) {
            System.out.println(e);
            return getResponseBody(false);
        }
    }


    // basic vehicle
    @RequestMapping(value = "basic/vehicle/desc", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getBasicVehicleDesc() {
        List<BasicVehicleEntity> list = basicService.getBasicVehicleDesc();
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
            @RequestParam("description") String description
    ) {
        return getResponseBody(basicService.getBasicVehicle(description));
    }

    @RequestMapping(value = "basic/vehicle/check", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> checkBasicVehicle(
            @RequestParam("description") String description
            ) {
        List<BasicVehicleEntity> list = basicService.getBasicVehicleDesc();
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
            entity.setCarYear(Double.valueOf(params.get("carYear").toString()));
            entity.setCarDa(params.get("carDa").toString());
            entity.setCarAddInfo(params.get("carAddInfo").toString());
            entity.setLvwM(Double.valueOf(params.get("lvwM").toString()));
            entity.setLvwFrtR(Double.valueOf(params.get("lvwFrtR").toString()));
            entity.setLvwCgh(Double.valueOf(params.get("lvwCgh").toString()));
            entity.setGvwM(Double.valueOf(params.get("gvwM").toString()));
            entity.setGvwFrtR(Double.valueOf(params.get("gvwFrtR").toString()));
            entity.setGvwCgh(Double.valueOf(params.get("gvwCgh").toString()));
            entity.setL(Double.valueOf(params.get("l").toString()));
            entity.setVmax(Double.valueOf(params.get("vmax").toString()));
            entity.setCoastDecel(Double.valueOf(params.get("coastDecel").toString()));
            entity.setCd(Double.valueOf(params.get("cd").toString()));
            entity.setA(Double.valueOf(params.get("a").toString()));
            entity.setNotes(params.get("notes").toString());
            return getResponseBody(basicService.addNewVehicle(entity));
        } catch (Exception e) {
            System.out.println(e);
            return getResponseBody(false);
        }
    }

    // requirement
    @RequestMapping(value = "basic/require/desc", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getBasicRequirementDesc() {
        List<BasicRequirementEntity> list = basicService.getBasicRequirementDesc();
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
            @RequestParam("description") String description
    ) {
        return getResponseBody(basicService.getBasicRequirement(description));
    }

    @RequestMapping(value = "basic/require/check", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> checkBasicRequirement(
            @RequestParam("description") String description
    ) {
        List<BasicRequirementEntity> list = basicService.getBasicRequirementDesc();
        List<String> descs = new ArrayList<String>();
        for (int i = 0; i < list.size(); i ++) {
            descs.add(list.get(i).getDescription());
        }
        return getResponseBody(descs.contains(description));
    }

    @RequestMapping(value = "basic/require/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> addNewBasicRequirement(
            @RequestBody Map<String, String> params
    ) {
        try {
            BasicRequirementEntity entity = new BasicRequirementEntity();
            entity.setDescription(params.get("description"));
            entity.setTf0(Double.valueOf(params.get("tf0")));
            entity.setVi(Double.valueOf(params.get("vi")));
            entity.setV0(Double.valueOf(params.get("v0")));
            entity.setAb(Double.valueOf(params.get("ab")));
            entity.setAa(Double.valueOf(params.get("aa")));
            entity.setT(Double.valueOf(params.get("t")));
            entity.setJ(Integer.valueOf(params.get("j")));
            entity.setvR(Double.valueOf(params.get("vR")));
            entity.setV2R(Double.valueOf(params.get("v2R")));
            entity.setT0(Double.valueOf(params.get("t0")));
            entity.setRhoa(Double.valueOf(params.get("rhoa")));
            entity.setUa(Double.valueOf(params.get("ua")));
            entity.setKa(Double.valueOf(params.get("ka")));
            entity.setNotes(params.get("notes"));
            return getResponseBody(basicService.addNewRequirement(entity));
        } catch (Exception e) {
            System.out.println(e);
            return getResponseBody(false);
        }
    }

    // Configuration!
    @RequestMapping(value = "basic/config/desc", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getBasicConfigurationDesc() {
        List<ConfigurationEntity> list = basicService.getBasicConfigurationDesc();
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
            @RequestParam("description") String description
    ) {
        return getResponseBody(basicService.getBasicConfiguration(description));
    }

    @RequestMapping(value = "basic/config/check", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> checkBasicConfiguration(
            @RequestParam("description") String description
    ) {
        List<ConfigurationEntity> list = basicService.getBasicConfigurationDesc();
        List<String> descs = new ArrayList<String>();
        for (int i = 0; i < list.size(); i ++) {
            descs.add(list.get(i).getDescription());
        }
        return getResponseBody(descs.contains(description));
    }

    @RequestMapping(value = "basic/config/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> addNewBasicConfiguration(
            @RequestParam("description") String description,
            @RequestParam("vehicleDesc") String vehicleDesc,
            @RequestParam("frontCornerDesc") String frontCornerDesc,
            @RequestParam("rearCornerDesc") String rearCornerDesc,
            @RequestParam("pedalDesc") String pedalDesc,
            @RequestParam("absContralVaveDesc") String absContralVaveDesc,
            @RequestParam("masterCylinderDesc") String masterCylinderDesc,
            @RequestParam("boosterDesc") String boosterDesc,
            @RequestParam("rearCornerNum") String rearCornerNum,
            @RequestParam("frontCornerNum") String frontCornerNum,
            @RequestParam("note") String notes
    ) {
        ConfigurationEntity entity = new ConfigurationEntity();
        try {
            entity.setDescription(description);
            entity.setVehicleDesc(vehicleDesc);
            entity.setFrontCornerDesc(frontCornerDesc);
            entity.setRearCornerDesc(rearCornerDesc);
            entity.setPedalDesc(pedalDesc);
            entity.setAbsContralVaveDesc(absContralVaveDesc);
            entity.setMasterCylinderDesc(masterCylinderDesc);
            entity.setBoosterDesc(boosterDesc);
            entity.setFrontCornerNum(Integer.valueOf(frontCornerNum));
            entity.setRearCornerNum(Integer.valueOf(rearCornerNum));
            entity.setNote(notes);
            return getResponseBody(basicService.addNewConfiguration(entity));
        } catch (Exception e) {
            System.out.println(e);
            return getResponseBody(false);
        }
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
            @RequestBody Map<String, Map<String, Object>> params
    ) {
        String path = servletContext.getRealPath("img");
        Map<String, Object> result = MatlabManualCalculate.realCalculate(params, path);
        return getResponseBody(result);
    }

}
