package service;

import entity.ConfigurationEntity;
import org.apache.commons.collections.map.HashedMap;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.Callable;

/**
 * Created by yangchen on 2018/4/8.
 */
public class ParallelCalculate implements Callable<Map<String, Object>> {

    private BasicService basicService;
    private String desc;
    private int userId;
    private String path;

    public ParallelCalculate(BasicService basicService, String desc, int userId, String path) {
        this.basicService = basicService;
        this.desc = desc;
        this.userId = userId;
        this.path = path;
    }

    public Map<String, Object> call() throws Exception {
        // construct parameters
        ConfigurationEntity configurationEntity = basicService.getBasicConfiguration(desc, userId);
        Map<String, Object> parameter = new HashedMap();
        Map<String, Object> descContent = new HashedMap();
        descContent.put("vehicle", configurationEntity.getVehicleDesc());
        descContent.put("tire", configurationEntity.getTireDesc());
        descContent.put("apply", configurationEntity.getApplyDesc());
        descContent.put("control", configurationEntity.getControlDesc());
        descContent.put("discBrake", configurationEntity.getDiscBrakeDesc());
        descContent.put("drumBrake", configurationEntity.getDrumBrakeDesc());
        descContent.put("requirement", configurationEntity.getRequireDesc());
        descContent.put("parking", configurationEntity.getParkingDesc());
        parameter.put("desc", descContent);
        parameter.put("userId", userId);
        Map<String, Map<String, Object>> formParam = new HashedMap();
        parameter.put("param", formParam);
        // real calculate without generate images and file
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String date = df.format(new Date());
        System.out.println("-----------------------------------------------------------------------");
        System.out.println(desc + ":" + date);
        Map<String, Map<String, Object>> parameters = basicService.getRealParams(parameter);
        Map<String, Object> result = MatlabManualCalculate.realCalculate(parameters, path, 0, date);
        return result;
    }
}
