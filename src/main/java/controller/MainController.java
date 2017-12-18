package controller;

import entity.InstanceLibEntity;
import entity.UserEntity;
import entity.VehicleEntity;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.BreakService;
import service.UserService;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by yangchen on 17/6/30.
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class MainController {

    @Autowired
    private UserService userService;

    @Autowired
    private BreakService breakService;

    @RequestMapping(value = "survey", method = RequestMethod.GET)
    public String getMulti(){
//        Field[] fields = entity.getClass().getDeclaredFields();
//        for (Field field : fields) {
//            field.setAccessible(true);
//            String classType = field.getType().toString();
//            int lastIndex = classType.lastIndexOf(".");
//            classType = classType.substring(lastIndex + 1);
//            System.out.println(field.getName());
//        }
        String[][] bm = {
                {"id", "id"},
                {"apply_vw", "apply_vw"},
                {"bst_size", "Booster size"},
                {"bst_gain", "Booster Gain"},
                {"bst_F_total", "Total Booster Force"},
                {"bst_F_eff", "Booster Force Efficiency"},
                {"bst_T_eff", "Booster Travel Efficiency"},
                {"bst_F_ls_np", "Force Loss – No Power"},
                {"bst_F_ls_wp", "Force Loss – with Power"},
                {"bst_F_jmp", "Jump in Force"},
                {"bst_T_ls", "Travel Loss"},
                {"mcd_d", "mcd Bore Diameter"},
                {"mcd_travel", "mcd Travel Efficiency"},
                {"bst_mc_spl", "Master Cylinder Supplier"}

        };
        String[][] dc = {
                {"id", "id"},
                {"discC_ID", "discC_ID"},
                {"apply_vw", "apply_vw"},
                {"clp_type", "Caliper Type"},
                {"pst_d", "Caliper Piston Diameter"},
                {"pst_num", "# of Piston per Caliper"},
                {"hf_P", "Caliper hold off Pressure"},
                {"PVcurve", "Caliper PV curve"},
                {"lin_mu", "Post-bunished lining mu"},
                {"lin_wear_lim", "Lining Wear Limit"},
                {"lin_mat", "Lining Material"}
        };

        String [][] dr = {
                {"id", "id"},
                {"discR_ID", "discR_ID"},
                {"apply_vw", "apply_vw"},
                {"rt_type", "Rotor Type"},
                {"rt_efc_r", "Rotor Effective Radius"},
                {"rt_dia_out", "Rotor Outer Diameter"},
                {"rt_mat", "Rotor Manufacturer"}
        };

        String[][] duc = {
                {"id", "id"},
                {"drumC_ID", "drumC_ID"},
                {"apply_vw", "apply_vw"},
                {"clp_type", "Caliper Type"},
                {"pst_d", "Caliper Piston Diameter"},
                {"pst_num", "# of Piston per Caliper"},
                {"hf_P", "Caliper hold off Pressure"},
                {"PVcurve", "Caliper PV curve"},
                {"lin_mu", "Post-bunished lining mu"},
                {"lin_wear_lim", "Lining Wear Limit"},
                {"lin_mat", "Lining Material"}
        };

        String [][] dur = {
                {"id", "id"},
                {"drumR_ID", "discR_ID"},
                {"apply_vw", "apply_vw"},
                {"rt_type", "Rotor Type"},
                {"rt_efc_r", "Rotor Effective Radius"},
                {"rt_dia_out", "Rotor Outer Diameter"},
                {"rt_mat", "Rotor Manufacturer"}
        };

        String [][] ped = {
                {"id", "id"},
                {"ped_type", "Pedal type"},
                {"ped_ratio", "Pedal Ratio"},
                {"ped_F_eff", "Pedal Force Efficiency"},
                {"ped_T_eff", "Pedal Travel Efficiency"},
                {"ped_spl", "Pedal Supplier"}
        };

        String[][] ins = {
                {"id", "id"},
                {"w", "LLVW/GVW"},
                {"hg", "CG Height"},
                {"wr", "Front %"},
                {"car_L", "Wheelbase Length"},
                {"car_slr", "Tire Static Loaded Radius"},
                {"frtCaliper", "Front caliper"},
                {"frtRotor", "Front rotor"},
                {"rrCaliper", "Rear caliper"},
                {"rrRotor", "Rear rotor"},
                {"bst_mc", "Booster mc"},
                {"ped", "Pedal"},
                {"gene_time", "Generate time"},
                {"type", "type"}
        };

        printSth1(ins);
        return "getStatus";
    }

    public void printSth(String[][] list) {
        for (int i = 0; i < list.length; i ++) {
            System.out.println(
                    "String[] bm" + i + " = {\""+ list[i][1] +"\", \""+ list[i][0] +"\", boosterMcEntity.getApplyVw().toString(), getUnits(\""+ list[i][0] +"\")};\n" +
                            "boosterMcContent.add(bm"+ i +");"
            );
        }
    }

    public void printSth1(String[][] list) {
        for (int i = 0; i < list.length; i ++) {
            System.out.println(
                    "String[] ins" + i + " = {\""+ list[i][1] +"\", \""+ list[i][0] +"\", instance.getApplyVw().toString(), getUnits(\""+ list[i][0] +"\")};\n" +
                            "instanceContent.add(ins"+ i +");"
            );
        }
    }


    @RequestMapping(value = "test", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getAllData(){
        InstanceLibEntity entity = new InstanceLibEntity();
        entity.setFrtCaliper(1);
        entity.setFrtRotor(2);
        entity.setRrCaliper(3);
        entity.setRrRotor(4);
        entity.setPed(1);
        entity.setBstMc(3);
        Map<String, List<String[]>> map = breakService.geneAllAttriValue(entity);
        Map<String, Object> returnInfo = new HashMap<String, Object>();
        returnInfo.put("Code", 0);
        returnInfo.put("Msg", "Success");
        returnInfo.put("results", map);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Credentials", "true");
        headers.add("allowed_cross_domains", "true");
        headers.add("Access-Control-Allow-Origin", "*");
        headers.add("Access-Control-Allow-Headers", " Accept, Content-Type");
        headers.add("Access-Control-Max-Age", "1728000");
        return new ResponseEntity<Map<String, Object>>(returnInfo, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> hanleLogin(
            @RequestParam("username") String username,
            @RequestParam("password") String password
    ){
        UserEntity user = userService.getUser(username);
        boolean auth = false;
        if (user != null) {
            if (user.getPassword().equals(password)) {
                auth = true;
            }
        }
        Map<String, Object> results = new HashedMap();
        results.put("auth", auth);
        results.put("user", user);
        Map<String, Object> returnInfo = new HashMap<String, Object>();
        returnInfo.put("Code", 0);
        returnInfo.put("Msg", "Success");
        returnInfo.put("results", results);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Credentials", "true");
        headers.add("allowed_cross_domains", "true");
        headers.add("Access-Control-Allow-Origin", "*");
        headers.add("Access-Control-Allow-Headers", " Accept, Content-Type");
        headers.add("Access-Control-Max-Age", "1728000");
        return new ResponseEntity<Map<String, Object>>(returnInfo, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "similar", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getSimilar(
            @RequestParam("flag") String flag,
            @RequestParam("w") String w,
            @RequestParam("hg") String hg,
            @RequestParam("wr") String wr,
            @RequestParam("car_l") String carL,
            @RequestParam("car_slr") String carSlr
    ){
        // flag: lvm: 0, gvm: 1
        VehicleEntity entity = new VehicleEntity();
        if (Integer.parseInt(flag) == 0) {
            entity.setLvwW(Double.parseDouble(w));
            entity.setLvwHg(Double.parseDouble(hg));
            entity.setLvwWr(Double.parseDouble(wr));
        } else {
            entity.setGvwW(Double.parseDouble(w));
            entity.setGvwHg(Double.parseDouble(hg));
            entity.setGvwWr(Double.parseDouble(wr));
        }
        entity.setCarL(Double.parseDouble(carL));
        entity.setCarSlr(Double.parseDouble(carSlr));
        VehicleEntity similar = breakService.getMostSim(entity, Integer.parseInt(flag));
        Map<String, Object> returnInfo = new HashMap<String, Object>();
        returnInfo.put("Code", 0);
        returnInfo.put("Msg", "Success");
        returnInfo.put("results", similar);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Credentials", "true");
        headers.add("allowed_cross_domains", "true");
        headers.add("Access-Control-Allow-Origin", "*");
        headers.add("Access-Control-Allow-Headers", " Accept, Content-Type");
        headers.add("Access-Control-Max-Age", "1728000");
        return new ResponseEntity<Map<String, Object>>(returnInfo, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "download/instance/{instance_id}", method = RequestMethod.GET, consumes="*")
    public ResponseEntity<byte[]> downloadHeatIsland(
            @PathVariable("instance_id") int instanceId
    ) throws IOException {

        // get all attributes
        InstanceLibEntity entity = breakService.getInstance(instanceId);
        Map<String, List<String[]>> map = breakService.geneAllAttriValue(entity);
        List<String[]> instanceContent = getNormalInstance(entity.getId(), entity);
        map.put("instance", instanceContent);

        HSSFWorkbook wb = new HSSFWorkbook();

        // vehicle
        HSSFSheet sheet = wb.createSheet("instance");
        HSSFRow row = sheet.createRow((int) 0);
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        HSSFCell cell = row.createCell(0);
        cell.setCellValue("id");
        cell.setCellStyle(style);
        cell = row.createCell(1);
        cell.setCellValue("name");
        cell.setCellStyle(style);
        cell = row.createCell(2);
        cell.setCellValue("symbol");
        cell.setCellStyle(style);
        cell = row.createCell(3);
        cell.setCellValue("value");
        cell.setCellStyle(style);
        cell = row.createCell(4);
        cell.setCellValue("unit");
        cell.setCellStyle(style);
        List<String[]> single = map.get("instance");
        for (int i = 0; i < single.size(); i ++) {
            row = sheet.createRow(i + 1);
            row.createCell(0).setCellValue(i);
            row.createCell(1).setCellValue(single.get(i)[0]);
            row.createCell(2).setCellValue(single.get(i)[1]);
            row.createCell(3).setCellValue(single.get(i)[2]);
            row.createCell(4).setCellValue(single.get(i)[3]);
        }

        // frt_caliper
        HSSFSheet sheetFC = wb.createSheet("frt_caliper");
        HSSFRow rowFC = sheetFC.createRow((int) 0);
        HSSFCellStyle styleFC = wb.createCellStyle();
        styleFC.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        HSSFCell cellFC = rowFC.createCell(0);
        cellFC.setCellValue("id");
        cellFC.setCellStyle(styleFC);
        cellFC = rowFC.createCell(1);
        cellFC.setCellValue("name");
        cellFC.setCellStyle(styleFC);
        cellFC = rowFC.createCell(2);
        cellFC.setCellValue("symbol");
        cellFC.setCellStyle(styleFC);
        cellFC = rowFC.createCell(3);
        cellFC.setCellValue("value");
        cellFC.setCellStyle(styleFC);
        cellFC = rowFC.createCell(4);
        cellFC.setCellValue("unit");
        cellFC.setCellStyle(styleFC);
        List<String[]> singleFC = map.get("frt_caliper");
        for (int i = 0; i < singleFC.size(); i ++) {
            rowFC = sheetFC.createRow(i + 1);
            rowFC.createCell(0).setCellValue(i);
            rowFC.createCell(1).setCellValue(singleFC.get(i)[0]);
            rowFC.createCell(2).setCellValue(singleFC.get(i)[1]);
            rowFC.createCell(3).setCellValue(singleFC.get(i)[2]);
            rowFC.createCell(4).setCellValue(singleFC.get(i)[3]);
        }

        // frt_rotor
        HSSFSheet sheetFR = wb.createSheet("frt_rotor");
        HSSFRow rowFR = sheetFR.createRow((int) 0);
        HSSFCellStyle styleFR = wb.createCellStyle();
        styleFR.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        HSSFCell cellFR = rowFR.createCell(0);
        cellFR.setCellValue("id");
        cellFR.setCellStyle(styleFR);
        cellFR = rowFR.createCell(1);
        cellFR.setCellValue("name");
        cellFR.setCellStyle(styleFR);
        cellFR = rowFR.createCell(2);
        cellFR.setCellValue("symbol");
        cellFR.setCellStyle(styleFR);
        cellFR = rowFR.createCell(3);
        cellFR.setCellValue("value");
        cellFR.setCellStyle(styleFR);
        cellFR = rowFR.createCell(4);
        cellFR.setCellValue("unit");
        cellFR.setCellStyle(styleFR);
        List<String[]> singleFR = map.get("frt_rotor");
        for (int i = 0; i < singleFR.size(); i ++) {
            rowFR = sheetFR.createRow(i + 1);
            rowFR.createCell(0).setCellValue(i);
            rowFR.createCell(1).setCellValue(singleFR.get(i)[0]);
            rowFR.createCell(2).setCellValue(singleFR.get(i)[1]);
            rowFR.createCell(3).setCellValue(singleFR.get(i)[2]);
            rowFR.createCell(4).setCellValue(singleFR.get(i)[3]);
        }

        // rr_caliper
        HSSFSheet sheetRC = wb.createSheet("rr_caliper");
        HSSFRow rowRC = sheetRC.createRow((int) 0);
        HSSFCellStyle styleRC = wb.createCellStyle();
        styleRC.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        HSSFCell cellRC = rowRC.createCell(0);
        cellRC.setCellValue("id");
        cellRC.setCellStyle(styleRC);
        cellRC = rowRC.createCell(1);
        cellRC.setCellValue("name");
        cellRC.setCellStyle(styleRC);
        cellRC = rowRC.createCell(2);
        cellRC.setCellValue("symbol");
        cellRC.setCellStyle(styleRC);
        cellRC = rowRC.createCell(3);
        cellRC.setCellValue("value");
        cellRC.setCellStyle(styleRC);
        cellRC = rowRC.createCell(4);
        cellRC.setCellValue("unit");
        cellRC.setCellStyle(styleRC);
        List<String[]> singleRC = map.get("rr_caliper");
        for (int i = 0; i < singleRC.size(); i ++) {
            rowRC = sheetRC.createRow(i + 1);
            rowRC.createCell(0).setCellValue(i);
            rowRC.createCell(1).setCellValue(singleRC.get(i)[0]);
            rowRC.createCell(2).setCellValue(singleRC.get(i)[1]);
            rowRC.createCell(3).setCellValue(singleRC.get(i)[2]);
            rowRC.createCell(4).setCellValue(singleRC.get(i)[3]);
        }

        // rr_rotor
        HSSFSheet sheetRR = wb.createSheet("rr_rotor");
        HSSFRow rowRR = sheetRR.createRow((int) 0);
        HSSFCellStyle styleRR = wb.createCellStyle();
        styleRR.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        HSSFCell cellRR = rowRR.createCell(0);
        cellRR.setCellValue("id");
        cellRR.setCellStyle(styleRR);
        cellRR = rowRR.createCell(1);
        cellRR.setCellValue("name");
        cellRR.setCellStyle(styleRR);
        cellRR = rowRR.createCell(2);
        cellRR.setCellValue("symbol");
        cellRR.setCellStyle(styleRR);
        cellRR = rowRR.createCell(3);
        cellRR.setCellValue("value");
        cellRR.setCellStyle(styleRR);
        cellRR = rowRR.createCell(4);
        cellRR.setCellValue("unit");
        cellRR.setCellStyle(styleRR);
        List<String[]> singleRR = map.get("rr_rotor");
        for (int i = 0; i < singleRR.size(); i ++) {
            rowRR = sheetRR.createRow(i + 1);
            rowRR.createCell(0).setCellValue(i);
            rowRR.createCell(1).setCellValue(singleRR.get(i)[0]);
            rowRR.createCell(2).setCellValue(singleRR.get(i)[1]);
            rowRR.createCell(3).setCellValue(singleRR.get(i)[2]);
            rowRR.createCell(4).setCellValue(singleRR.get(i)[3]);
        }

        // pedal
        HSSFSheet sheetP = wb.createSheet("pedal");
        HSSFRow rowP = sheetP.createRow((int) 0);
        HSSFCellStyle styleP = wb.createCellStyle();
        styleP.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        HSSFCell cellP = rowP.createCell(0);
        cellP.setCellValue("id");
        cellP.setCellStyle(styleP);
        cellP = rowP.createCell(1);
        cellP.setCellValue("name");
        cellP.setCellStyle(styleP);
        cellP = rowP.createCell(2);
        cellP.setCellValue("symbol");
        cellP.setCellStyle(styleP);
        cellP = rowP.createCell(3);
        cellP.setCellValue("value");
        cellP.setCellStyle(styleP);
        cellP = rowP.createCell(4);
        cellP.setCellValue("unit");
        cellP.setCellStyle(styleP);
        List<String[]> singleP = map.get("pedal");
        for (int i = 0; i < singleP.size(); i ++) {
            rowP = sheetP.createRow(i + 1);
            rowP.createCell(0).setCellValue(i);
            rowP.createCell(1).setCellValue(singleP.get(i)[0]);
            rowP.createCell(2).setCellValue(singleP.get(i)[1]);
            rowP.createCell(3).setCellValue(singleP.get(i)[2]);
            rowP.createCell(4).setCellValue(singleP.get(i)[3]);
        }

        File directory = new File(".");
        SimpleDateFormat df = new SimpleDateFormat("HHmmss");//设置日期格式
        String timePath = df.format(new Date());// new Date()为获取当前系统时间
        try {
            System.out.print(directory.getCanonicalPath());
            FileOutputStream out = new FileOutputStream(directory.getCanonicalPath() + "/instance_"+ timePath +".xls");
            wb.write(out);
            out.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        String path= directory.getCanonicalPath() + "/instance_"+ timePath +".xls";
        File file=new File(path);
        HttpHeaders headers = new HttpHeaders();
        //String fileName=new String("热岛.xls".getBytes("UTF-8"),"iso-8859-1");//为了解决中文名称乱码问题
        headers.setContentDispositionFormData("attachment", "instance_"+ timePath +".xls");
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
                headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "instance", method = RequestMethod.POST, consumes="*")
    public ResponseEntity<Map<String, Object>> getBest(
            @RequestParam("op_type") String op_type,
            @RequestParam("v_type") String v_type,
            @RequestParam("vehicle_id") String vehicleId,
            @RequestParam("user_id") String user_id
    ){
        // lvw_w 106, lvw_hg 83, lvw_wr 0.01; gvw_w 106, gvw_hg 61, gvw_wr 0.1 car_L 135, car_slr 111
        VehicleEntity vehicleEntity = breakService.getVehicle(Integer.parseInt(vehicleId));
        double w = 0;
        double hg = 0;
        double wr = 0;
        double carL = 0;
        double carSlr = 0;
        Random random = new Random();
        if (Integer.parseInt(v_type) == 0) {
            w = vehicleEntity.getLvwW() + random.nextInt(106) - 53;
            hg = vehicleEntity.getLvwHg() + random.nextInt(83) - 41;
            wr = vehicleEntity.getLvwWr() + random.nextDouble()/10 -0.05;
        } else {
            w = vehicleEntity.getGvwW() + random.nextInt(106) - 53;
            hg = vehicleEntity.getGvwHg() + random.nextInt(61) - 30;
            wr = vehicleEntity.getGvwWr() + random.nextDouble()/10 -0.05;
        }
        carL = vehicleEntity.getCarL() + random.nextInt(135) - 67;
        carSlr = vehicleEntity.getCarSlr() + random.nextInt(111) - 55;
        InstanceLibEntity instanceLibEntity = new InstanceLibEntity();
        instanceLibEntity.setW(w);
        instanceLibEntity.setHg(hg);
        instanceLibEntity.setWr(wr);
        instanceLibEntity.setCarL(carL);
        instanceLibEntity.setCarSlr(carSlr);
        instanceLibEntity.setBstMc(random.nextInt(10)+1);
        instanceLibEntity.setFrtCaliper(random.nextInt(12)+1);
        instanceLibEntity.setFrtRotor(random.nextInt(10)+1);
        instanceLibEntity.setRrCaliper(random.nextInt(12)+1);
        instanceLibEntity.setRrRotor(random.nextInt(12)+1);
        instanceLibEntity.setPed(random.nextInt(10)+1);
        instanceLibEntity.setUserId(Integer.parseInt(user_id));
        instanceLibEntity.setType(Integer.parseInt(v_type));
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timeNow = df.format(new Date());
        instanceLibEntity.setGeneTime(Timestamp.valueOf(timeNow));

        int instance_id = breakService.saveInstance(instanceLibEntity);
        Map<String, List<String[]>> map = breakService.geneAllAttriValue(instanceLibEntity);

        List<String[]> instanceContent = getNormalInstance(instance_id, instanceLibEntity);

        map.put("instance", instanceContent);
        Map<String, Object> returnInfo = new HashMap<String, Object>();
        returnInfo.put("Code", 0);
        returnInfo.put("Msg", "Success");
        returnInfo.put("results", map);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Credentials", "true");
        headers.add("allowed_cross_domains", "true");
        headers.add("Access-Control-Allow-Origin", "*");
        headers.add("Access-Control-Allow-Headers", " Accept, Content-Type");
        headers.add("Access-Control-Max-Age", "1728000");
        return new ResponseEntity<Map<String, Object>>(returnInfo, headers, HttpStatus.OK);
    }

    // http://localhost:8080/download/instance/5

    public List<String[]> getNormalInstance(int instance_id, InstanceLibEntity instanceLibEntity) {
        List<String[]> instanceContent = new ArrayList<String[]>();
        String[] ins0 = {"id", "id", String.valueOf(instance_id), breakService.getUnits("id")};
        instanceContent.add(ins0);
        String[] ins1 = {"LLVW/GVW", "w", instanceLibEntity.getW().toString(), breakService.getUnits("w")};
        instanceContent.add(ins1);
        String[] ins2 = {"CG Height", "hg", instanceLibEntity.getHg().toString(), breakService.getUnits("hg")};
        instanceContent.add(ins2);
        String[] ins3 = {"Front %", "wr", instanceLibEntity.getWr().toString(), breakService.getUnits("wr")};
        instanceContent.add(ins3);
        String[] ins4 = {"Wheelbase Length", "car_L", instanceLibEntity.getCarL().toString(), breakService.getUnits("car_L")};
        instanceContent.add(ins4);
        String[] ins5 = {"Tire Static Loaded Radius", "car_slr", instanceLibEntity.getCarSlr().toString(), breakService.getUnits("car_slr")};
        instanceContent.add(ins5);
        String[] ins6 = {"Front caliper", "frtCaliper", instanceLibEntity.getFrtCaliper().toString(), breakService.getUnits("frtCaliper")};
        instanceContent.add(ins6);
        String[] ins7 = {"Front rotor", "frtRotor", instanceLibEntity.getFrtRotor().toString(), breakService.getUnits("frtRotor")};
        instanceContent.add(ins7);
        String[] ins8 = {"Rear caliper", "rrCaliper", instanceLibEntity.getRrCaliper().toString(), breakService.getUnits("rrCaliper")};
        instanceContent.add(ins8);
        String[] ins9 = {"Rear rotor", "rrRotor", instanceLibEntity.getRrRotor().toString(), breakService.getUnits("rrRotor")};
        instanceContent.add(ins9);
        String[] ins10 = {"Booster mc", "bst_mc", instanceLibEntity.getBstMc().toString(), breakService.getUnits("bst_mc")};
        instanceContent.add(ins10);
        String[] ins11 = {"Pedal", "ped", instanceLibEntity.getPed().toString(), breakService.getUnits("ped")};
        instanceContent.add(ins11);
        String[] ins12 = {"Generate time", "gene_time", instanceLibEntity.getGeneTime().toString(), breakService.getUnits("gene_time")};
        instanceContent.add(ins12);
        String[] ins13 = {"type", "type", instanceLibEntity.getType().toString(), breakService.getUnits("type")};
        instanceContent.add(ins13);
        return instanceContent;
    }

    @RequestMapping(value = "allInstance/{user_id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getAllInstances(@PathVariable("user_id") int userId){
        List<InstanceLibEntity> entites = breakService.getAllInstances(userId);
        Map<String, Object> returnInfo = new HashMap<String, Object>();
        returnInfo.put("Code", 0);
        returnInfo.put("Msg", "Success");
        returnInfo.put("results", entites);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Credentials", "true");
        headers.add("allowed_cross_domains", "true");
        headers.add("Access-Control-Allow-Origin", "*");
        headers.add("Access-Control-Allow-Headers", " Accept, Content-Type");
        headers.add("Access-Control-Max-Age", "1728000");
        return new ResponseEntity<Map<String, Object>>(returnInfo, headers, HttpStatus.OK);
    }

    // test interface
    @RequestMapping(value = "test/base64", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getTestBase64(
            @RequestBody Map<String, List<Map<String, String>>> files
    ){
        List<String> names = new ArrayList<String>();
        try {
            for (int i = 0; i < files.get("files").size(); i ++) {
                names.add(files.get("files").get(i).get("file_name"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        Map<String, Object> returnInfo = new HashMap<String, Object>();
        returnInfo.put("Code", 0);
        returnInfo.put("Msg", "Success");
        returnInfo.put("results", names);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Credentials", "true");
        headers.add("allowed_cross_domains", "true");
        headers.add("Access-Control-Allow-Origin", "*");
        headers.add("Access-Control-Allow-Headers", " Accept, Content-Type");
        headers.add("Access-Control-Max-Age", "1728000");
        return new ResponseEntity<Map<String, Object>>(returnInfo, headers, HttpStatus.OK);
    }
}
