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
    public List<BasicApplyEntity> getBasicApplyDesc() {
        return basicDao.getBasicApplyDesc();
    }

    public BasicApplyEntity getBasicApply(String description) {
        return basicDao.getBasicApply(description);
    }

    public boolean addNewApply(BasicApplyEntity entity) {
        return basicDao.addNewApply(entity);
    }

    public boolean deleteApply(String description) {
        return basicDao.deleteApply(description);
    }

    // basic control
    public List<BasicControlEntity> getBasicControlDesc() {
        return basicDao.getBasicControlDesc();
    }

    public BasicControlEntity getBasicControl(String description) {
        return basicDao.getBasicControl(description);
    }

    public boolean addNewControl(BasicControlEntity entity) {
        return basicDao.addNewControl(entity);
    }

    public boolean deleteControl(String description) {
        return basicDao.deleteControl(description);
    }

    // basic disc brake
    public List<BasicDiscBrakeEntity> getBasicDiscBrakeDesc() {
        return basicDao.getBasicDiscBrakeDesc();
    }

    public BasicDiscBrakeEntity getBasicDiscBrake(String description) {
        return basicDao.getBasicDiscBrake(description);
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

    public boolean deleteDiscBrake(String description) {
        BasicDiscBrakeEntity entity = basicDao.getBasicDiscBrake(description);
        if (entity.getRtType().equals("Vented") || entity.getRtType().equals("vented")) {
            boolean flag = basicDao.deleteVentedRotor(entity.getRtId());
            if (flag) {
                return basicDao.deleteDiscBrake(description);
            } else {
                return false;
            }
        } else if (entity.getRtType().equals("Solid") || entity.getRtType().equals("solid")) {
            boolean flag = basicDao.deleteSolidRotor(entity.getRtId());
            if (flag) {
                return basicDao.deleteDiscBrake(description);
            } else {
                return false;
            }
        } else {
            boolean flag = basicDao.deleteDrumRotor(entity.getRtId());
            if (flag) {
                return basicDao.deleteDiscBrake(description);
            } else {
                return false;
            }
        }
    }

    // basic drum brake
    public List<BasicDrumBrakeEntity> getBasicDrumBrakeDesc() {
        return basicDao.getBasicDrumBrakeDesc();
    }

    public BasicDrumBrakeEntity getBasicDrumBrake(String description) {
        return basicDao.getBasicDrumBrake(description);
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

    public boolean deleteDrumBrake(String description) {
        BasicDrumBrakeEntity entity = basicDao.getBasicDrumBrake(description);
        if (entity.getRtType().equals("Vented") || entity.getRtType().equals("vented")) {
            boolean flag = basicDao.deleteVentedRotor(entity.getRtId());
            if (flag) {
                return basicDao.deleteDrumBrake(description);
            } else {
                return false;
            }
        } else if (entity.getRtType().equals("Solid") || entity.getRtType().equals("solid")) {
            boolean flag = basicDao.deleteSolidRotor(entity.getRtId());
            if (flag) {
                return basicDao.deleteDrumBrake(description);
            } else {
                return false;
            }
        } else {
            boolean flag = basicDao.deleteDrumRotor(entity.getRtId());
            if (flag) {
                return basicDao.deleteDrumBrake(description);
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
    public List<BasicTireEntity> getBasicTireWheelDesc() {
        return basicDao.getBasicTireWheelDesc();
    }

    public BasicTireEntity getBasicTireWheel(String description) {
        return basicDao.getBasicTireWheel(description);
    }

    public boolean addNewTireWheel(BasicTireEntity entity) {
        return basicDao.addNewTireWheel(entity);
    }

    public boolean deleteTireWheel(String description) {
        return basicDao.deleteTireWheel(description);
    }

    // basic vehicle
    public List<BasicVehicleEntity> getBasicVehicleDesc() {
        return basicDao.getBasicVehicleDesc();
    }

    public BasicVehicleEntity getBasicVehicle(String description) {
        return basicDao.getBasicVehicle(description);
    }

    public boolean addNewVehicle(BasicVehicleEntity entity) {
        return basicDao.addNewVehicle(entity);
    }

    public boolean deleteVehicle(String description) {
        return basicDao.deleteVehicle(description);
    }

    // requirement
    public List<BasicRequirementEntity> getBasicRequirementDesc() {
        return basicDao.getBasicRequirementDesc();
    }

    public BasicRequirementEntity getBasicRequirement(String description) {
        return basicDao.getBasicRequirement(description);
    }

    public boolean addNewRequirement(BasicRequirementEntity entity) {
        return basicDao.addNewRequirement(entity);
    }

    public boolean deleteRequirement(String description) {
        return basicDao.deleteRequirement(description);
    }

    // Configuration !!!!!!!!!!!!!!!
    public List<ConfigurationEntity> getBasicConfigurationDesc() {
        return basicDao.getBasicConfigurationDesc();
    }

    public ConfigurationEntity getBasicConfiguration(String description) {
        return basicDao.getBasicConfiguration(description);
    }

    public boolean addNewConfiguration(ConfigurationEntity entity) {
        return basicDao.addNewConfiguration(entity);
    }

    public boolean deleteConfiguration(String description) {
        return basicDao.deleteConfiguration(description);
    }

    public List<UnitsEntity> getUnits() {
        return basicDao.getUnits();
    }
}
