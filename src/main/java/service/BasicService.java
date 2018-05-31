package service;

import dao.BasicDao;
import entity.*;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by yangchen on 17/9/5.
 */
@Transactional
@Service
public class BasicService {
    @Autowired
    private BasicDao basicDao;

    // basic apply
    public List<BasicApplyEntity> getBasicApplyDesc(int userId) {
        return basicDao.getBasicApplyDesc(userId);
    }

    public BasicApplyEntity getBasicApply(String description, int userId) {
        return basicDao.getBasicApply(description, userId);
    }

    public boolean addNewApply(BasicApplyEntity entity) {
        return basicDao.addNewApply(entity);
    }

    public boolean deleteApply(String description, int userId) {
        return basicDao.deleteApply(description, userId);
    }

    // basic control
    public List<BasicControlEntity> getBasicControlDesc(int userId) {
        return basicDao.getBasicControlDesc(userId);
    }

    public BasicControlEntity getBasicControl(String description, int userId) {
        return basicDao.getBasicControl(description, userId);
    }

    public boolean addNewControl(BasicControlEntity entity) {
        return basicDao.addNewControl(entity);
    }

    public boolean deleteControl(String description, int userId) {
        return basicDao.deleteControl(description, userId);
    }

    // basic disc brake
    public List<BasicDiscBrakeEntity> getBasicDiscBrakeDesc(int userId) {
        return basicDao.getBasicDiscBrakeDesc(userId);
    }

    public BasicDiscBrakeEntity getBasicDiscBrake(String description, int userId) {
        return basicDao.getBasicDiscBrake(description, userId);
    }

    public boolean addNewDiscBrake(BasicDiscBrakeEntity entity, Object rotor) {
        int rotorId;
        if (entity.getRtType().equals("Vented") || entity.getRtType().equals("vented")) {
            rotorId = basicDao.addNewVentedRotor((BasicVentedRotorEntity) rotor);
        } else if (entity.getRtType().equals("Solid") || entity.getRtType().equals("solid")) {
            rotorId = basicDao.addNewSolidRotor((BasicSolidRotorEntity) rotor);
        } else {
            rotorId = basicDao.addNewDrumRotor((BasicDrumRotorEntity) rotor);
        }
        if (rotorId == -1) {
            return false;
        } else {
            entity.setRtId(rotorId);
            return basicDao.addNewDiscBrake(entity);
        }
    }

    public boolean deleteDiscBrake(String description, int userId) {
        BasicDiscBrakeEntity entity = basicDao.getBasicDiscBrake(description, userId);
        if (entity.getRtType().equals("Vented") || entity.getRtType().equals("vented")) {
            boolean flag = basicDao.deleteVentedRotor(entity.getRtId());
            if (flag) {
                return basicDao.deleteDiscBrake(description, userId);
            } else {
                return false;
            }
        } else if (entity.getRtType().equals("Solid") || entity.getRtType().equals("solid")) {
            boolean flag = basicDao.deleteSolidRotor(entity.getRtId());
            if (flag) {
                return basicDao.deleteDiscBrake(description, userId);
            } else {
                return false;
            }
        } else {
            boolean flag = basicDao.deleteDrumRotor(entity.getRtId());
            if (flag) {
                return basicDao.deleteDiscBrake(description, userId);
            } else {
                return false;
            }
        }
    }

    // basic drum brake
    public List<BasicDrumBrakeEntity> getBasicDrumBrakeDesc(int userId) {
        return basicDao.getBasicDrumBrakeDesc(userId);
    }

    public BasicDrumBrakeEntity getBasicDrumBrake(String description, int userId) {
        return basicDao.getBasicDrumBrake(description, userId);
    }

    public boolean addNewDrumBrake(BasicDrumBrakeEntity entity, Object rotor) {
        int rotorId;
        if (entity.getRtType().equals("Vented") || entity.getRtType().equals("vented")) {
            rotorId = basicDao.addNewVentedRotor((BasicVentedRotorEntity) rotor);
        } else if (entity.getRtType().equals("Solid") || entity.getRtType().equals("solid")) {
            rotorId = basicDao.addNewSolidRotor((BasicSolidRotorEntity) rotor);
        } else {
            rotorId = basicDao.addNewDrumRotor((BasicDrumRotorEntity) rotor);
        }
        if (rotorId == -1) {
            return false;
        } else {
            entity.setRtId(rotorId);
            return basicDao.addNewDrumBrake(entity);
        }
    }

    public boolean deleteDrumBrake(String description, int userId) {
        BasicDrumBrakeEntity entity = basicDao.getBasicDrumBrake(description, userId);
        if (entity.getRtType().equals("Vented") || entity.getRtType().equals("vented")) {
            boolean flag = basicDao.deleteVentedRotor(entity.getRtId());
            if (flag) {
                return basicDao.deleteDrumBrake(description, userId);
            } else {
                return false;
            }
        } else if (entity.getRtType().equals("Solid") || entity.getRtType().equals("solid")) {
            boolean flag = basicDao.deleteSolidRotor(entity.getRtId());
            if (flag) {
                return basicDao.deleteDrumBrake(description, userId);
            } else {
                return false;
            }
        } else {
            boolean flag = basicDao.deleteDrumRotor(entity.getRtId());
            if (flag) {
                return basicDao.deleteDrumBrake(description, userId);
            } else {
                return false;
            }
        }
    }

    // get basic rotor
    public BasicVentedRotorEntity getBasicVentedRotor(int id) {
        return basicDao.getBasicVentedRotor(id);
    }
    public BasicSolidRotorEntity getBasicSolidRotor(int id) {
        return basicDao.getBasicSolidRotor(id);
    }
    public BasicDrumRotorEntity getBasicDrumRotor(int id) {
        return basicDao.getBasicDrumRotor(id);
    }

    // basic tire wheel
    public List<BasicTireEntity> getBasicTireWheelDesc(int userId) {
        return basicDao.getBasicTireWheelDesc(userId);
    }

    public BasicTireEntity getBasicTireWheel(String description, int userId) {
        return basicDao.getBasicTireWheel(description, userId);
    }

    public boolean addNewTireWheel(BasicTireEntity entity) {
        return basicDao.addNewTireWheel(entity);
    }

    public boolean deleteTireWheel(String description, int userId) {
        return basicDao.deleteTireWheel(description, userId);
    }

    // basic vehicle
    public List<BasicVehicleEntity> getBasicVehicleDesc(int userId) {
        return basicDao.getBasicVehicleDesc(userId);
    }

    public BasicVehicleEntity getBasicVehicle(String description, int userId) {
        return basicDao.getBasicVehicle(description, userId);
    }

    public boolean addNewVehicle(BasicVehicleEntity entity) {
        return basicDao.addNewVehicle(entity);
    }

    public boolean deleteVehicle(String description, int userId) {
        return basicDao.deleteVehicle(description, userId);
    }

    // requirement
    public List<BasicRequirementEntity> getBasicRequirementDesc(int userId) {
        return basicDao.getBasicRequirementDesc(userId);
    }

    public BasicRequirementEntity getBasicRequirement(String description, int userId) {
        return basicDao.getBasicRequirement(description, userId);
    }

    public boolean addNewRequirement(BasicRequirementEntity entity) {
        return basicDao.addNewRequirement(entity);
    }

    public boolean deleteRequirement(String description, int userId) {
        return basicDao.deleteRequirement(description, userId);
    }

    // Configuration !!!!!!!!!!!!!!!
    public List<ConfigurationEntity> getBasicConfigurationDesc(int userId) {
        return basicDao.getBasicConfigurationDesc(userId);
    }

    public ConfigurationEntity getBasicConfiguration(String description, int userId) {
        return basicDao.getBasicConfiguration(description, userId);
    }

    public boolean addNewConfiguration(ConfigurationEntity entity) {
        return basicDao.addNewConfiguration(entity);
    }

    public boolean deleteConfiguration(String description, int userId) {
        return basicDao.deleteConfiguration(description, userId);
    }

    // Parking !!!!!!!!!!!!!!!
    public List<BasicParkingEntity> getBasicParkingDesc(int userId) {
        return basicDao.getBasicParkingDesc(userId);
    }

    public BasicParkingEntity getBasicParking(String description, int userId) {
        return basicDao.getBasicParking(description, userId);
    }

    public boolean addNewConfiguration(BasicParkingEntity entity) {
        return basicDao.addNewParking(entity);
    }

    public boolean deleteParking(String description, int userId) {
        return basicDao.deleteParking(description, userId);
    }

    public List<UnitsEntity> getUnits() {
        return basicDao.getUnits();
    }

    public void updateWorkspace(
            String apply,
            String control,
            String discBrake,
            String drumBrake,
            String require,
            String tire,
            String vehicle,
            String parking,
            int userId
    ) {
        basicDao.updateWorkspace(apply, control, discBrake, drumBrake, require, tire, vehicle, parking, userId);
    }

    public Map<String, String> getWorkspace(int userId) {
        return basicDao.getWorkspace(userId);
    }

    // parameters with description generates to full parameter
    public Map<String, Map<String, Object>> getRealParams(Map<String, Object> params) {
        Map<String, Map<String, Object>> parameter = (Map<String, Map<String, Object>>) params.get("param");
        Map<String, Object> desc = (Map<String, Object>) params.get("desc");
        int userId = getIntegerValue(params.get("userId").toString());
        String[] keys = new String[]{"apply", "control", "discBrake", "drumBrake",
                "requirement", "tire", "vehicle"};
        if (desc.get("vehicle") != null) {
            BasicVehicleEntity vehicleEntity = getBasicVehicle(desc.get("vehicle").toString(), userId);
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
            BasicTireEntity tireEntity = getBasicTireWheel(desc.get("tire").toString(), userId);
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
            BasicApplyEntity applyEntity = getBasicApply(desc.get("apply").toString(), userId);
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
            applyMap.put("mcdFEff", applyEntity.getMcdFEff());
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
            BasicControlEntity controlEntity = getBasicControl(desc.get("control").toString(), userId);
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
            BasicDiscBrakeEntity discBrakeEntity = getBasicDiscBrake(desc.get("discBrake").toString(), userId);
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
            BasicDrumBrakeEntity drumBrakeEntity = getBasicDrumBrake(desc.get("drumBrake").toString(), userId);

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
            BasicRequirementEntity requirementEntity = getBasicRequirement(desc.get("requirement").toString(), userId);
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
        if (desc.get("parking") != null) {
            BasicParkingEntity parkingEntity = getBasicParking(desc.get("parking").toString(), userId);
            Map<String, Object> parking = new HashedMap();
            parking.put("elf", parkingEntity.getElf());
            parking.put("ecf", parkingEntity.getEcf());
            parking.put("ect", parkingEntity.getEct());
            parking.put("a", parkingEntity.getA());
            parking.put("rv", parkingEntity.getRv());
            parking.put("av", parkingEntity.getAv());
            parking.put("ad", parkingEntity.getAd());
            parking.put("a0", parkingEntity.getA0());
            parking.put("dh", parkingEntity.getDh());
            parking.put("sigema0", parkingEntity.getSigema0());
            parking.put("sita", parkingEntity.getSita());
            parameter.put("parking", parking);
        }
        return parameter;
    }

    // different type of rotor maps to real rotor
    public Map<String, Object> getRotorParam(Map<String, Object> brake, String type, int rotorId) {
        if (type.equals("Vented") || type.equals("vented")) {
            BasicVentedRotorEntity ventedRotorEntity = getBasicVentedRotor(rotorId);
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
            BasicSolidRotorEntity solidRotorEntity = getBasicSolidRotor(rotorId);
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
            BasicDrumRotorEntity drumRotorEntity = getBasicDrumRotor(rotorId);
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

    // update configuration filename
    public boolean updateConfigurationFileName(String desc, String fileName, int userId) {
        return basicDao.updateConfigurationFileName(desc, fileName, userId);
    }

    public String getConfigurationFileName(String desc, int userId) {
        return basicDao.getConfigurationFileName(desc, userId);
    }

    // delete useless files
    public void deleteUselessFiles(String filepath, int userId) {
        List<String> fileNames = basicDao.getUselessFileNames(userId);
        for (String name: fileNames) {
            File file = new File(filepath + name);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    // util transformation
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
