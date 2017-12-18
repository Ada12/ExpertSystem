package service;

import dao.BasicDao;
import entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    // basic disc brake
    public List<BasicDiscBrakeEntity> getBasicDiscBrakeDesc() {
        return basicDao.getBasicDiscBrakeDesc();
    }

    public BasicDiscBrakeEntity getBasicDiscBrake(String description) {
        return basicDao.getBasicDiscBrake(description);
    }

    public boolean addNewDiscBrake(BasicDiscBrakeEntity entity) {
        return basicDao.addNewDiscBrake(entity);
    }

    // basic drum brake
    public List<BasicDrumBrakeEntity> getBasicDrumBrakeDesc() {
        return basicDao.getBasicDrumBrakeDesc();
    }

    public BasicDrumBrakeEntity getBasicDrumBrake(String description) {
        return basicDao.getBasicDrumBrake(description);
    }

    public boolean addNewDrumBrake(BasicDrumBrakeEntity entity) {
        return basicDao.addNewDrumBrake(entity);
    }

    // basic tire wheel
    public List<BasicTireWheelEntity> getBasicTireWheelDesc() {
        return basicDao.getBasicTireWheelDesc();
    }

    public BasicTireWheelEntity getBasicTireWheel(String description) {
        return basicDao.getBasicTireWheel(description);
    }

    public boolean addNewTireWheel(BasicTireWheelEntity entity) {
        return basicDao.addNewTireWheel(entity);
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

    public List<UnitsEntity> getUnits() {
        return basicDao.getUnits();
    }
}
