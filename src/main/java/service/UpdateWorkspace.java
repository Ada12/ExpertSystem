package service;

/**
 * Created by yangchen on 2018/3/14.
 */
public class UpdateWorkspace implements Runnable {

    private BasicService basicService;

    private int userId;

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setBasicService(BasicService basicService) {
        this.basicService = basicService;
    }

    public void setApply(String apply) {
        this.apply = apply;
    }

    public void setControl(String control) {
        this.control = control;
    }

    public void setDiscBrake(String discBrake) {
        this.discBrake = discBrake;
    }

    public void setDrumBrake(String drumBrake) {
        this.drumBrake = drumBrake;
    }

    public void setRequire(String require) {
        this.require = require;
    }

    public void setTire(String tire) {
        this.tire = tire;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    private String apply;
    private String control;
    private String discBrake;
    private String drumBrake;
    private String require;
    private String tire;
    private String vehicle;

    public void run() {
        basicService.updateWorkspace(apply, control, discBrake, drumBrake, require, tire, vehicle, userId);
    }
}
