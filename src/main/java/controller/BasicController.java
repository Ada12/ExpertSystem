package controller;

import entity.*;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.BasicService;

import javax.naming.ldap.BasicControl;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Array;
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
            @RequestParam("description") String description,
            @RequestParam("pedRatio") String pedRatio,
            @RequestParam("pedFEff") String pedFEff,
            @RequestParam("pedTEff") String pedTEff,
            @RequestParam("pedType") String pedType,
            @RequestParam("bstSize") String bstSize,
            @RequestParam("bstGain") String bstGain,
            @RequestParam("bstFTotal") String bstFTotal,
            @RequestParam("bstFEff") String bstFEff,
            @RequestParam("bstTEff") String bstTEff,
            @RequestParam("bstFLsNp") String bstFLsNp,
            @RequestParam("bstFLsWp") String bstFLsWp,
            @RequestParam("bstFJmp") String bstFJmp,
            @RequestParam("bstTLs") String bstTLs,
            @RequestParam("bstVcm") String bstVcm,
            @RequestParam("altBstVcm") String altBstVcm,
            @RequestParam("mcdD") String mcdD,
            @RequestParam("mcdFEff") String mcdFEff,
            @RequestParam("mcdTEff") String mcdTEff,
            @RequestParam("apyFEff") String apyFEff,
            @RequestParam("apyTEff") String apyTEff,
            @RequestParam("notes") String notes
    ) {
        BasicApplyEntity entity = new BasicApplyEntity();
        try {
            entity.setDescription(description);
            entity.setPedRatio(pedRatio);
            entity.setPedFEff(Double.valueOf(pedFEff));
            entity.setApyTEff(Double.valueOf(pedTEff));
            entity.setPedType(Integer.valueOf(pedType));
            entity.setBstSize(Double.valueOf(bstSize));
            entity.setBstGain(Double.valueOf(bstGain));
            entity.setBstFTotal(Double.valueOf(bstFTotal));
            entity.setBstFEff(Double.valueOf(bstFEff));
            entity.setBstTEff(Double.valueOf(bstTEff));
            entity.setBstFLsNp(Double.valueOf(bstFLsNp));
            entity.setBstFLsWp(Double.valueOf(bstFLsWp));
            entity.setBstFJmp(Double.valueOf(bstFJmp));
            entity.setBstTLs(Double.valueOf(bstTLs));
            entity.setBstVcm(Double.valueOf(bstVcm));
            entity.setAltBstVcm(Double.valueOf(altBstVcm));
            entity.setMcdD(Double.valueOf(mcdD));
            entity.setMcdFEff(Double.valueOf(mcdFEff));
            entity.setMcdTEff(Double.valueOf(mcdTEff));
            entity.setApyFEff(Double.valueOf(apyFEff));
            entity.setApyTEff(Double.valueOf(apyTEff));
            entity.setNotes(notes);
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
            @RequestParam("description") String description,
            @RequestParam("effAbsFrt") String effAbsFrt,
            @RequestParam("effAbsRr") String effAbsRr,
            @RequestParam("peakTire") String peakTire,
            @RequestParam("effDrive") String effDrive,
            @RequestParam("notes") String notes
    ) {
        BasicControlEntity entity = new BasicControlEntity();
        try {
            entity.setDescription(description);
            entity.setEffAbsFrt(Double.valueOf(effAbsFrt));
            entity.setEffAbsRr(Double.valueOf(effAbsRr));
            entity.setPeakTire(peakTire);
            entity.setEffDrive(effDrive);
            entity.setNotes(notes);
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
        return getResponseBody(basicService.getBasicDiscBrake(description));
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
            @RequestParam("description") String description,
            @RequestParam("pstD") String pstD,
            @RequestParam("pstNum") String pstNum,
            @RequestParam("pstArea") String pstArea,
            @RequestParam("hfP") String hfP,
            @RequestParam("pVcurve") String pVcurve,
            @RequestParam("pvK") String pvK,
            @RequestParam("pvB") String pvB,
            @RequestParam("pvC") String pvC,
            @RequestParam("linMat") String linMat,
            @RequestParam("linMu") String linMu,
            @RequestParam("linMuK") String linMuK,
            @RequestParam("linMuE") String linMuE,
            @RequestParam("linMuNp") String linMuNp,
            @RequestParam("linArea") String linArea,
            @RequestParam("linWearLim") String linWearLim,
            @RequestParam("frtRtTempIn") String frtRtTempIn,
            @RequestParam("frtLinWearOut") String frtLinWearOut,
            @RequestParam("frtLinFrictOut") String frtLinFrictOut,
            @RequestParam("perCorner") String perCorner,
            @RequestParam("rtTypeV") String rtTypeV,
            @RequestParam("rtSwpAreaV") String rtSwpAreaV,
            @RequestParam("rtEfcRV") String rtEfcRV,
            @RequestParam("rtDiaOutV") String rtDiaOutV,
            @RequestParam("rtDiaInV") String rtDiaInV,
            @RequestParam("rtInCkTV") String rtInCkTV,
            @RequestParam("rtOutCkTV") String rtOutCkTV,
            @RequestParam("rtTV") String rtTV,
            @RequestParam("rtVanNumV") String rtVanNumV,
            @RequestParam("rtVanLenV") String rtVanLenV,
            @RequestParam("rtVaneHighV") String rtVaneHighV,
            @RequestParam("rtVanTV") String rtVanTV,
            @RequestParam("rtWmV") String rtWmV,
            @RequestParam("rtWaV") String rtWaV,
            @RequestParam("rhoV") String rhoV,
            @RequestParam("cc50V") String cc50V,
            @RequestParam("cc80V") String cc80V,
            @RequestParam("cvr50V") String cvr50V,
            @RequestParam("cvr80V") String cvr80V,
            @RequestParam("rtTempInV") String rtTempInV,
            @RequestParam("rtSpecOutV") String rtSpecOutV,
            @RequestParam("rtTypeS") String rtTypeS,
            @RequestParam("rtSwpAreaS") String rtSwpAreaS,
            @RequestParam("rtEfcRS") String rtEfcRS,
            @RequestParam("rtDiaOutS") String rtDiaOutS,
            @RequestParam("rtDiaInS") String rtDiaInS,
            @RequestParam("rtTS") String rtTS,
            @RequestParam("rtWmS") String rtWmS,
            @RequestParam("rtWaS") String rtWaS,
            @RequestParam("rhoS") String rhoS,
            @RequestParam("cc50S") String cc50S,
            @RequestParam("cc80S") String cc80S,
            @RequestParam("cvr50S") String cvr50S,
            @RequestParam("cvr80S") String cvr80S,
            @RequestParam("rtTempInS") String rtTempInS,
            @RequestParam("rtSpecOutS") String rtSpecOutS,
            @RequestParam("notes") String notes
    ) {
        BasicDiscBrakeEntity entity = new BasicDiscBrakeEntity();
        try {
            entity.setDescription(description);
            entity.setPstD(Double.valueOf(pstD));
            entity.setPstNum(Integer.valueOf(pstNum));
            entity.setPstArea(Double.valueOf(pstArea));
            entity.setHfP(Double.valueOf(hfP));
            entity.setpVcurve(pVcurve);
            entity.setPvK(Double.valueOf(pvK));
            entity.setPvB(Double.valueOf(pvB));
            entity.setPvC(Double.valueOf(pvC));
            entity.setLinMat(linMat);
            entity.setLinMu(Double.valueOf(linMu));
            entity.setLinMuK(Double.valueOf(linMuK));
            entity.setLinMuE(Double.valueOf(linMuE));
            entity.setLinMuNp(Double.valueOf(linMuNp));
            entity.setLinArea(Double.valueOf(linArea));
            entity.setLinWearLim(Double.valueOf(linWearLim));
            entity.setFrtRtTempIn(frtRtTempIn);
            entity.setFrtLinWearOut(frtLinWearOut);
            entity.setFrtLinFrictOut(frtLinFrictOut);
            entity.setPerCorner(Double.valueOf(perCorner));
            entity.setRtTypeV(rtTypeV);
            entity.setRtSwpAreaV(Double.valueOf(rtSwpAreaV));
            entity.setRtEfcRV(Double.valueOf(rtEfcRV));
            entity.setRtDiaOutV(Double.valueOf(rtDiaOutV));
            entity.setRtDiaInV(Double.valueOf(rtDiaInV));
            entity.setRtInCkTV(rtInCkTV);
            entity.setRtOutCkTV(rtOutCkTV);
            entity.setRtTV(Double.valueOf(rtTV));
            entity.setRtVanNumV(Integer.valueOf(rtVanNumV));
            entity.setRtVanLenV(Double.valueOf(rtVanLenV));
            entity.setRtVaneHighV(Double.valueOf(rtVaneHighV));
            entity.setRtVanTV(Double.valueOf(rtVanTV));
            entity.setRtWmV(Double.valueOf(rtWmV));
            entity.setRtWaV(Double.valueOf(rtWaV));
            entity.setRhoV(Double.valueOf(rhoV));
            entity.setCc50V(Double.valueOf(cc50V));
            entity.setCc80V(Double.valueOf(cc80V));
            entity.setCvr50V(Double.valueOf(cvr50V));
            entity.setCvr80V(Double.valueOf(cvr80V));
            entity.setRtTempInV(rtTempInV);
            entity.setRtSpecOutV(rtSpecOutV);
            entity.setRtTypeS(rtTypeS);
            entity.setRtSwpAreaS(Double.valueOf(rtSwpAreaS));
            entity.setRtEfcRS(Double.valueOf(rtEfcRS));
            entity.setRtDiaOutS(Double.valueOf(rtDiaOutS));
            entity.setRtDiaInS(Double.valueOf(rtDiaInS));
            entity.setRtTS(Double.valueOf(rtTS));
            entity.setRtWmS(Double.valueOf(rtWmS));
            entity.setRtWaS(Double.valueOf(rtWaS));
            entity.setRhoS(Double.valueOf(rhoS));
            entity.setCc50S(Double.valueOf(cc50S));
            entity.setCc80S(Double.valueOf(cc80S));
            entity.setCvr50S(Double.valueOf(cvr50S));
            entity.setCvr80S(Double.valueOf(cvr80S));
            entity.setRtTempInS(rtTempInS);
            entity.setRtSpecOutS(rtSpecOutS);
            entity.setNotes(notes);
            return getResponseBody(basicService.addNewDiscBrake(entity));
        } catch (Exception e) {
            System.out.println(e);
            return getResponseBody(false);
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
        return getResponseBody(basicService.getBasicDrumBrake(description));
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
            @RequestParam("description") String description,
            @RequestParam("cDia") String cDia,
            @RequestParam("pstNum") String pstNum,
            @RequestParam("pstArea") String pstArea,
            @RequestParam("cHp") String cHp,
            @RequestParam("pVcurve") String pVcurve,
            @RequestParam("pvK") String pvK,
            @RequestParam("pvB") String pvB,
            @RequestParam("pvC") String pvC,
            @RequestParam("linMat") String linMat,
            @RequestParam("linMu") String linMu,
            @RequestParam("linMuK") String linMuK,
            @RequestParam("linMuE") String linMuE,
            @RequestParam("linMuNp") String linMuNp,
            @RequestParam("linArea") String linArea,
            @RequestParam("linWearLim") String linWearLim,
            @RequestParam("frtRtTempIn") String frtRtTempIn,
            @RequestParam("frtLinWearOut") String frtLinWearOut,
            @RequestParam("frtLinFrictOut") String frtLinFrictOut,
            @RequestParam("perCorner") String perCorner,
            @RequestParam("rtType") String rtType,
            @RequestParam("rtEfcR") String rtEfcR,
            @RequestParam("odDm") String odDm,
            @RequestParam("idDm") String idDm,
            @RequestParam("thDm") String thDm,
            @RequestParam("wdDm") String wdDm,
            @RequestParam("jthDm") String jthDm,
            @RequestParam("rtVaneHigh") String rtVaneHigh,
            @RequestParam("rtWm") String rtWm,
            @RequestParam("rtWa") String rtWa,
            @RequestParam("rho") String rho,
            @RequestParam("cc50") String cc50,
            @RequestParam("cc80") String cc80,
            @RequestParam("cvr50") String cvr50,
            @RequestParam("cvr80") String cvr80,
            @RequestParam("rtTempIn") String rtTempIn,
            @RequestParam("rtSpecOut") String rtSpecOut,
            @RequestParam("notes") String notes
    ) {
        BasicDrumBrakeEntity entity = new BasicDrumBrakeEntity();
        try {
            entity.setDescription(description);
            entity.setcHp(Double.valueOf(cHp));
            entity.setpVcurve(pVcurve);
            entity.setPvK(Double.valueOf(pvK));
            entity.setPvB(Double.valueOf(pvB));
            entity.setPvC(Double.valueOf(pvC));
            entity.setLinMat(linMat);
            entity.setLinMu(Double.valueOf(linMu));
            entity.setLinMuK(Double.valueOf(linMuK));
            entity.setLinMuE(Double.valueOf(linMuE));
            entity.setLinMuNp(Double.valueOf(linMuNp));
            entity.setLinArea(Double.valueOf(linArea));
            entity.setLinWearLim(Double.valueOf(linWearLim));
            entity.setFrtRtTempIn(frtRtTempIn);
            entity.setFrtLinWearOut(frtLinWearOut);
            entity.setFrtLinFrictOut(frtLinFrictOut);
            entity.setPerCorner(Double.valueOf(perCorner));
            entity.setRtType(rtType);
            entity.setRtEfcR(Double.valueOf(rtEfcR));
            entity.setOdDm(Double.valueOf(odDm));
            entity.setIdDm(Double.valueOf(idDm));
            entity.setThDm(thDm);
            entity.setWdDm(wdDm);
            entity.setJthDm(Double.valueOf(jthDm));
            entity.setRtVaneHigh(Double.valueOf(rtVaneHigh));
            entity.setRtWm(Double.valueOf(rtWm));
            entity.setRtWa(Double.valueOf(rtWa));
            entity.setRho(Double.valueOf(rho));
            entity.setCc50(Double.valueOf(cc50));
            entity.setCc80(Double.valueOf(cc80));
            entity.setCvr50(Double.valueOf(cvr50));
            entity.setCvr80(Double.valueOf(cvr80));
            entity.setRtTempIn(rtTempIn);
            entity.setRtSpecOut(rtSpecOut);
            entity.setNotes(notes);
            return getResponseBody(basicService.addNewDrumBrake(entity));
        } catch (Exception e) {
            System.out.println(e);
            return getResponseBody(false);
        }
    }

    // basic tire wheel
    @RequestMapping(value = "basic/tireWheel/desc", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getBasicTireWheelDesc() {
        List<BasicTireWheelEntity> list = basicService.getBasicTireWheelDesc();
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < list.size(); i ++) {
            Map<String, Object> single = new HashedMap();
            single.put("id", list.get(i).getId());
            single.put("desc", list.get(i).getDescription());
            result.add(single);
        }
        return getResponseBody(result);
    }

    @RequestMapping(value = "basic/tireWheel", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getBasicTireWheel(
            @RequestParam("description") String description
    ) {
        return getResponseBody(basicService.getBasicTireWheel(description));
    }

    @RequestMapping(value = "basic/tireWheel/check", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> checkBasicTireWheel(
            @RequestParam("description") String description
    ) {
        List<BasicTireWheelEntity> list = basicService.getBasicTireWheelDesc();
        List<String> descs = new ArrayList<String>();
        for (int i = 0; i < list.size(); i ++) {
            descs.add(list.get(i).getDescription());
        }
        return getResponseBody(descs.contains(description));
    }

    @RequestMapping(value = "basic/tireWheel/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> addNewBasicTireWheel(
            @RequestParam("description") String description,
            @RequestParam("lvwTrFrt") String lvwTrFrt,
            @RequestParam("lvwTrRr") String lvwTrRr,
            @RequestParam("gvwTrFrt") String gvwTrFrt,
            @RequestParam("gvwTrRr") String gvwTrRr,
            @RequestParam("peakAdhesLong") String peakAdhesLong,
            @RequestParam("peakAdhesLat") String peakAdhesLat,
            @RequestParam("tracCoeff") String tracCoeff,
            @RequestParam("s") String s,
            @RequestParam("fR") String fR,
            @RequestParam("notes") String notes
    ) {
        BasicTireWheelEntity entity = new BasicTireWheelEntity();
        try {
            entity.setDescription(description);
            entity.setLvwTrFrt(Double.valueOf(lvwTrFrt));
            entity.setLvwTrRr(Double.valueOf(lvwTrRr));
            entity.setGvwTrFrt(Double.valueOf(gvwTrFrt));
            entity.setGvwTrRr(Double.valueOf(gvwTrRr));
            entity.setPeakAdhesLong(Double.valueOf(peakAdhesLong));
            entity.setPeakAdhesLat(Double.valueOf(peakAdhesLat));
            entity.setTracCoeff(Double.valueOf(tracCoeff));
            entity.setS(Double.valueOf(s));
            entity.setfR(Double.valueOf(fR));
            entity.setNotes(notes);
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
            @RequestParam("description") String description,
            @RequestParam("carModel") String carModel,
            @RequestParam("carYear") String carYear,
            @RequestParam("carDa") String carDa,
            @RequestParam("carAddInfo") String carAddInfo,
            @RequestParam("lvwM") String lvwM,
            @RequestParam("lvwFrtR") String lvwFrtR,
            @RequestParam("lvwCgh") String lvwCgh,
            @RequestParam("gvwM") String gvwM,
            @RequestParam("gvwFrtR") String gvwFrtR,
            @RequestParam("gvwCgh") String gvwCgh,
            @RequestParam("l") String l,
            @RequestParam("vmax") String vmax,
            @RequestParam("coastDecel") String coastDecel,
            @RequestParam("cd") String cd,
            @RequestParam("a") String a,
            @RequestParam("notes") String notes
    ) {
        BasicVehicleEntity entity = new BasicVehicleEntity();
        try {
            entity.setDescription(description);
            entity.setCarModel(carModel);
            entity.setCarYear(Double.valueOf(carYear));
            entity.setCarDa(carDa);
            entity.setCarAddInfo(carAddInfo);
            entity.setLvwM(Double.valueOf(lvwM));
            entity.setLvwFrtR(Double.valueOf(lvwFrtR));
            entity.setLvwCgh(Double.valueOf(lvwCgh));
            entity.setGvwM(Double.valueOf(gvwM));
            entity.setGvwFrtR(Double.valueOf(gvwFrtR));
            entity.setGvwCgh(Double.valueOf(gvwCgh));
            entity.setL(Double.valueOf(l));
            entity.setVmax(Double.valueOf(vmax));
            entity.setCoastDecel(Double.valueOf(coastDecel));
            entity.setCd(Double.valueOf(cd));
            entity.setA(Double.valueOf(a));
            entity.setNotes(notes);
            return getResponseBody(basicService.addNewVehicle(entity));
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
}
