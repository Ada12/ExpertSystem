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
            @RequestParam("description") String description
    ) {
        return getResponseBody(basicService.deleteApply(description));
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
            entity.setAbsSpl(String.valueOf(params.get("absSpl")));
            entity.setAbsType(String.valueOf(params.get("absType")));
            entity.setEffAbsFrt(getDoubleValue(params.get("effAbsFrt").toString()));
            entity.setEffAbsRr(getDoubleValue(params.get("effAbsRr").toString()));
            entity.setEbd(getIntegerValue(params.get("ebd").toString()));
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
            @RequestParam("description") String description
    ) {
        return getResponseBody(basicService.deleteControl(description));
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
        try {
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
        } catch (Exception e) {
            return getResponseBody(null);
        }
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
        basicDiscBrakeEntity.setHfP(getDoubleValue(caliperLining.get("hfP").toString()));
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
        basicDiscBrakeEntity.setNotes(caliperLining.get("notes").toString());
        Object realRotor = getRealRotor(caliperLining, basicDiscBrakeEntity.getRtType());
        return getResponseBody(basicService.addNewDiscBrake(basicDiscBrakeEntity, realRotor));
    }

    @RequestMapping(value = "basic/discBrake/delete", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> deleteBasicDiscBrake(
            @RequestParam("description") String description
    ) {
        return getResponseBody(basicService.deleteDiscBrake(description));
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
            basicDrumRotorEntity.setRrManu(rotor.get("rrMat").toString());
            basicDrumRotorEntity.setEfcR(getDoubleValue(rotor.get("efcR").toString()));
            basicDrumRotorEntity.setOutD(getDoubleValue(rotor.get("outD").toString()));
            basicDrumRotorEntity.setInD(getDoubleValue(rotor.get("inD").toString()));
            basicDrumRotorEntity.setRtThick(rotor.get("rtThick").toString());
            basicDrumRotorEntity.setRibThick(rotor.get("ribThick").toString());
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
        try {
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
        } catch (Exception e) {
            return getResponseBody(null);
        }
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
            basicDrumBrakeEntity.setHfP(getDoubleValue(caliperLining.get("hfP").toString()));
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
            @RequestParam("description") String description
    ) {
        return getResponseBody(basicService.deleteDrumBrake(description));
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
            entity.setLvwTrFrt(getDoubleValue(params.get("lvwTrFrt").toString()));
            entity.setLvwTrRr(getDoubleValue(params.get("lvwTrRr").toString()));
            entity.setGvwTrFrt(getDoubleValue(params.get("gvwTrFrt").toString()));
            entity.setGvwTrRr(getDoubleValue(params.get("gvwTrRr").toString()));
            entity.setPeakAdhesLong(getDoubleValue(params.get("peakAdhesLong").toString()));
            entity.setPeakAdhesLat(getDoubleValue(params.get("peakAdhesLat").toString()));
            entity.setTracCoeff(getDoubleValue(params.get("tracCoeff").toString()));
            entity.setS(getDoubleValue(params.get("s").toString()));
            entity.setfR(getDoubleValue(params.get("fR").toString()));
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
            @RequestParam("description") String description
    ) {
        return getResponseBody(basicService.deleteTireWheel(description));
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
            @RequestParam("description") String description
    ) {
        return getResponseBody(basicService.deleteVehicle(description));
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
            @RequestBody Map<String, Object> params
    ) {
        try {
            BasicRequirementEntity entity = new BasicRequirementEntity();
            entity.setDescription(params.get("description").toString());
            entity.setTf0(getDoubleValue(params.get("tf0").toString()));
            entity.setVi(getDoubleValue(params.get("vi").toString()));
            entity.setV0(getDoubleValue(params.get("v0").toString()));
            entity.setAb(getDoubleValue(params.get("ab").toString()));
            entity.setAa(getDoubleValue(params.get("aa").toString()));
            entity.setT(getDoubleValue(params.get("t").toString()));
            entity.setJ(getIntegerValue(params.get("j").toString()));
            entity.setvR(getDoubleValue(params.get("vR").toString()));
            entity.setV2R(getDoubleValue(params.get("v2R").toString()));
            entity.setT0(getDoubleValue(params.get("t0").toString()));
            entity.setRhoa(getDoubleValue(params.get("rhoa").toString()));
            entity.setUa(getDoubleValue(params.get("ua").toString()));
            entity.setKa(getDoubleValue(params.get("ka").toString()));
            entity.setHotV1(getDoubleValue(params.get("hotV1").toString()));
            entity.setHotV0(getDoubleValue(params.get("hotV0").toString()));
            entity.setHotAb(getDoubleValue(params.get("hotAb").toString()));
            entity.setDistanceV1(getDoubleValue(params.get("distanceV1").toString()));
            entity.setDistanceStop(getDoubleValue(params.get("distanceStop").toString()));
            entity.setDistanceTime(getDoubleValue(params.get("distanceTime").toString()));
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
            @RequestParam("description") String description
    ) {
        return getResponseBody(basicService.deleteRequirement(description));
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
            @RequestParam("description") String description
    ) {
        return getResponseBody(basicService.deleteConfiguration(description));
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
        Map<String, Object> result = new HashedMap();
        try {
            result = MatlabManualCalculate.realCalculate(params, path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getResponseBody(result);
    }

}
