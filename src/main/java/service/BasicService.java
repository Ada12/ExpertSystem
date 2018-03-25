package service;

import dao.BasicDao;
import entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
            int userId
    ) {
        basicDao.updateWorkspace(apply, control, discBrake, drumBrake, require, tire, vehicle, userId);
    }

    public Map<String, String> getWorkspace(int userId) {
        return basicDao.getWorkspace(userId);
    }
}
