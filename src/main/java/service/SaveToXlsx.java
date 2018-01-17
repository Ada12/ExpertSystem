package service;

//import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by yangchen on 2018/1/17.
 */
public class SaveToXlsx implements Runnable {

    private Map<String, Map<String, Object>> params;
    private String path;

    public void setParams(Map<String, Map<String, Object>> params){
        this.params = params;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void run() {
//        try {
//            Thread.sleep(2000);
//            System.out.println("停顿了 " + 2 + "秒");
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        Map<String, Object> applyMap = params.get("apply");
        Map<String, Object> controlMap = params.get("control");
        Map<String, Object> discBrakeMap = params.get("discBrake");
        Map<String, Object> drumBrakeMap = params.get("drumBrake");
        Map<String, Object> tireMap = params.get("tire");
        Map<String, Object> vehicleMap = params.get("vehicle");
        Map<String, Object> requireMap = params.get("requirement");

        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFCellStyle style = wb.createCellStyle();
        String[] header = new String[]{"Parameter", "Value", "Unit"};
        // vehicle
        XSSFSheet vehicle = wb.createSheet("Vehicle");
        String[] vehicleParam = new String[]{"Model", "Year", "Driven Axle (F/R/4WD/AWD)", "Additional Info.",
                "LLVW(Total)", "%Front Mass", "CG Height", "GVW(Total)", "%Front Mass", "CG Height", "Wheelbase Length",
                "Max Speed", "WOT", "Coastdown Decel", "Drag Coff.","Frontal Aera"};
        String[] vehicleUnit = new String[]{"N/A", "N/A", "N/A", "N/A", "kg", "N/A", "mm", "kg", "N/A", "mm", "mm",
                "Km/h", "g", "g", "N/A", "m^2"};
        String[] vehicleKey = new String[]{"carModel", "carYear", "carDa", "carAddInfo", "lvwM", "lvwFrtR", "lvwCgh",
                "gvwM", "gvwFrtR", "gvwCgh", "l", "vmax", "wot", "coastDecel", "cd", "a"};
        XSSFRow vehicleRow = vehicle.createRow((int) 0);
        style.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        for (int i = 0; i < header.length; i++) {
            XSSFCell cell = vehicleRow.createCell(i);
            cell.setCellValue(header[i]);
            cell.setCellStyle(style);
        }
        for (int i = 0; i < vehicleParam.length; i ++) {
            vehicleRow = vehicle.createRow(i + 1);
            vehicleRow.createCell(0).setCellValue(vehicleParam[i]);
            vehicleRow.createCell(1).setCellValue(vehicleMap.get(vehicleKey[i]).toString());
            vehicleRow.createCell(2).setCellValue(vehicleUnit[i]);
        }
        // tire
        XSSFSheet tire = wb.createSheet("Tire");
        String[] tireParam = new String[]{"Front LVW Tire Static Loaded Rad.", "Rear LVW Tire Static Loaded Rad.",
                "Front GVW Tire Static Loaded Rad.", "Rear GVW Tire Static Loaded Rad.", "Tire Peak Adhes.（Long）",
                "Tire Peak Adhes.（Lat）", "Max Traction Coeff", "Slip @ Max Traction", "Rolling Resistance"};
        String[] tireUnit = new String[]{"mm", "mm", "mm", "mm", "g", "g", "g", "N/A", "N"};
        String[] tireKey = new String[]{"lvwTrFrt", "lvwTrRr", "gvwTrFrt", "gvwTrRr", "peakAdhesLong", "peakAdhesLat",
                "tracCoeff", "s", "fR"};
        XSSFRow tireRow = tire.createRow((int) 0);
        style.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        for (int i = 0; i < header.length; i++) {
            XSSFCell cell = tireRow.createCell(i);
            cell.setCellValue(header[i]);
            cell.setCellStyle(style);
        }
        for (int i = 0; i < tireParam.length; i ++) {
            tireRow = tire.createRow(i + 1);
            tireRow.createCell(0).setCellValue(tireParam[i]);
            tireRow.createCell(1).setCellValue(tireMap.get(tireKey[i]).toString());
            tireRow.createCell(2).setCellValue(tireUnit[i]);
        }
        // apply
        XSSFSheet apply = wb.createSheet("Apply");
        String[] applyParam = new String[]{"Pedal Supplier", "Pedal Ratio", "Pedal Force efficiency", "Pedal Travel Efficiency",
                "Pedal Type", "Booster Supplier", "Booster Size", "Booster Gain", "Total Boost Force (N) @ 67.7 kPa Vacuum",
                "Booster Force Efficiency", "Booster Travel Efficiency", "Cut-in Force", "Force Loss - w / power", "Jump in Force",
                "Travel Loss", "Boost Vacuum", "Alt. Booster Vacuum", "Master Cylinder Supplier", "M/C Bore Diameter",
                "M/C Force Efficiency", "M/C Travel Efficiency", "Apply Force Efficiency", " Apply Travel Efficiency"};
        String[] applyUnit = new String[]{"N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "inch", "N/A", "N", "N/A", "N/A", "N", "N",
                "N", "mm", "KPa", "KPa", "N/A", "mm", "N/A", "N/A", "N/A", "N/A"};
        String[] applyKey = new String[]{"pedSpl", "pedRatio", "pedFEff", "pedTEff", "pedType", "pedType", "bstSpl", "bstSize",
                "bstGain", "bstFTotal", "bstFEff", "bstTEff", "bstFLsNp", "bstFLsWp", "bstFJmp", "bstTLs", "bstVcm", "altBstVcm",
                "mcdSpl", "mcdD", "mcdFEff", "mcdTEff", "apyFEff", "apyTEff"};
        XSSFRow applyRow = apply.createRow((int) 0);
        style.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        for (int i = 0; i < header.length; i++) {
            XSSFCell cell = applyRow.createCell(i);
            cell.setCellValue(header[i]);
            cell.setCellStyle(style);
        }
        applyRow = apply.createRow(1);
        applyRow.createCell(0).setCellValue("Pedal");
        applyRow.createCell(1).setCellValue("");
        applyRow.createCell(2).setCellValue("");
        for (int i = 2; i < 7; i ++) {
            applyRow = apply.createRow(i);
            applyRow.createCell(0).setCellValue(applyParam[i-2]);
            applyRow.createCell(1).setCellValue(applyMap.get(applyKey[i-2]).toString());
            applyRow.createCell(2).setCellValue(applyUnit[i-2]);
        }
        applyRow = apply.createRow(7);
        applyRow.createCell(0).setCellValue("");
        applyRow.createCell(1).setCellValue("");
        applyRow.createCell(2).setCellValue("");
        applyRow = apply.createRow(8);
        applyRow.createCell(0).setCellValue("Booster");
        applyRow.createCell(1).setCellValue("");
        applyRow.createCell(2).setCellValue("");
        for (int i = 9; i < 21; i ++) {
            applyRow = apply.createRow(i);
            applyRow.createCell(0).setCellValue(applyParam[i-4]);
            applyRow.createCell(1).setCellValue(applyMap.get(applyKey[i-4]).toString());
            applyRow.createCell(2).setCellValue(applyUnit[i-4]);
        }
        applyRow = apply.createRow(21);
        applyRow.createCell(0).setCellValue("");
        applyRow.createCell(1).setCellValue("");
        applyRow.createCell(2).setCellValue("");
        applyRow = apply.createRow(22);
        applyRow.createCell(0).setCellValue("MasterCylinder");
        applyRow.createCell(1).setCellValue("");
        applyRow.createCell(2).setCellValue("");
        for (int i = 23; i < 29; i ++) {
            applyRow = apply.createRow(i);
            applyRow.createCell(0).setCellValue(applyParam[i-6]);
            applyRow.createCell(1).setCellValue(applyMap.get(applyKey[i-6]).toString());
            applyRow.createCell(2).setCellValue(applyUnit[i-6]);
        }
        // control
        XSSFSheet control = wb.createSheet("Control");
        String[] controlParam = new String[]{"ABS Unit Supplier", "ABS Type", "Front Axle ABS Efficiency", "Rear Axle ABS Efficiency"};
        String[] controlUnit = new String[]{"N/A", "N/A", "N/A", "N/A"};
        String[] controlKey = new String[]{"absSpl", "absType", "effAbsFrt", "effAbsRr"};
        XSSFRow controlRow = control.createRow((int) 0);
        style.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        for (int i = 0; i < header.length; i++) {
            XSSFCell cell = controlRow.createCell(i);
            cell.setCellValue(header[i]);
            cell.setCellStyle(style);
        }
        for (int i = 0; i < controlParam.length; i ++) {
            controlRow = control.createRow(i+1);
            controlRow.createCell(0).setCellValue(controlParam[i]);
            controlRow.createCell(1).setCellValue(controlMap.get(controlKey[i]).toString());
            controlRow.createCell(2).setCellValue(controlUnit[i]);
        }
        // front brake
        XSSFSheet frontBrake = wb.createSheet("Front Brake");
        setCaliperLin(style, discBrakeMap, frontBrake);
        setRotor(style, discBrakeMap, frontBrake, 45);
        // rear brake
        XSSFSheet rearBrake = wb.createSheet("Rear Brake");
        setCaliperLin(style, drumBrakeMap, rearBrake);
        setRotor(style, drumBrakeMap, rearBrake, 45);
        // configuration
        XSSFSheet requirement = wb.createSheet("Requirement");
        XSSFRow requireRow;
        requireRow = requirement.createRow(0);
        requirement.addMergedRegion(new CellRangeAddress(0,0,0,2));
        requireRow.createCell(0).setCellValue("Thermal Performance");

        requireRow = requirement.createRow(1);
        requireRow.createCell(0).setCellValue("Single Stop Temp. Rise");
        requireRow.createCell(1).setCellValue("");
        requireRow.createCell(2).setCellValue("Unit");
        String[] requireParam1 = new String[]{"Initial Velocity before Brake", "End Velocity after Brake", "Front Single Stop Temp. Rise",
                "Rear Single Stop Temp. Rise"};
        String[] requireUnit1 = new String[]{"km/h", "km/h", "℃", "℃"};
        String[] requireKey1 = new String[]{"sglVi", "sglV0", "frtSglTmp", "rrSglTmp"};
        for (int i = 3; i < 7; i ++) {
            requireRow = requirement.createRow(i);
            requireRow.createCell(0).setCellValue(requireParam1[i-3]);
            requireRow.createCell(1).setCellValue(requireMap.get(requireKey1[i-3]).toString());
            requireRow.createCell(2).setCellValue(requireUnit1[i-3]);
        }
        requireRow = requirement.createRow(7);
        requireRow.createCell(0).setCellValue("Lining Power");
        requireRow.createCell(1).setCellValue("");
        requireRow.createCell(2).setCellValue("");
        String[] requireParam2 = new String[]{"End Velocity after Brake", "Lining Power Front @0.85g GVW",
                "Lining Power Rear @0.85g GVW", "Initial Velocity before Brake"};
        String[] requireUnit2 = new String[]{"km/h", "km/h", "kW/cm^2", "kW/cm^2"};
        String[] requireKey2 = new String[]{"linVi", "linV0", "frtLinPwr", "rrLinPwr"};
        for (int i = 8; i < 12; i ++) {
            requireRow = requirement.createRow(i);
            requireRow.createCell(0).setCellValue(requireParam2[i-3]);
            requireRow.createCell(1).setCellValue(requireMap.get(requireKey2[i-3]).toString());
            requireRow.createCell(2).setCellValue(requireUnit2[i-3]);
        }
        requireRow = requirement.createRow(12);
        requireRow.createCell(0).setCellValue("HFT");
        requireRow.createCell(1).setCellValue("");
        requireRow.createCell(2).setCellValue("");
        String[] requireParam3 = new String[]{"Initial Velocity before Brake", "End Velocity after Brake",
                "Heat Flow Density Front Rotor @0.85g GVW", "Heat Flow Density Rear Rotor @0.85g GVW"};
        String[] requireUnit3 = new String[]{"km/h", "km/h", "kW/cm^2", "kW/cm^2"};
        String[] requireKey3 = new String[]{ "hftVi", "hftV0", "frtHftPwr", "rrHftPwr"};
        for (int i = 13; i < 17; i ++) {
            requireRow = requirement.createRow(i);
            requireRow.createCell(0).setCellValue(requireParam3[i-3]);
            requireRow.createCell(1).setCellValue(requireMap.get(requireKey3[i-3]).toString());
            requireRow.createCell(2).setCellValue(requireUnit3[i-3]);
        }
        // BET AMS II AMS III
        List<Object> bet = (List<Object>) requireMap.get("bet");
        requireRow = requirement.createRow(18);
        requireRow.createCell(0).setCellValue("");
        requireRow.createCell(1).setCellValue("@LVW Power");
        requireRow.createCell(2).setCellValue("@LVW Nopower");
        requireRow.createCell(2).setCellValue("@GVW Power");
        requireRow.createCell(2).setCellValue("@GVW Nopower");
        requireRow.createCell(2).setCellValue("Unit");

        // save to file
        try {
            FileOutputStream out = new FileOutputStream(path + "param.xlsx");
            System.out.println("path"+path);
            wb.write(out);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setCaliperLin(XSSFCellStyle style, Map<String, Object> discBrakeMap, XSSFSheet frontBrake) {
        String[] frontBrakeParam1 = new String[]{"Caliper Type (I.E. Collet)", "Caliper Manufacturer", "Caliper Piston Diameter",
                "# of Pistons per Caliper", "Overall Piston Area", "Caliper Hold off Pressure"};
        String[] frontBrakeUnit1 = new String[]{"N/A", "N/A", "mm", "N/A", "mm^2", "kPa"};
        String[] frontBrakeKey1 = new String[]{"frtType", "frtManu", "pstD", "pstNum", "pstArea", "hfP"};
        XSSFRow frontBrakeRow;
        style.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        // header
        frontBrake.addMergedRegion(new CellRangeAddress(0,0,1,2));
        frontBrakeRow = frontBrake.createRow(0);
        frontBrakeRow.createCell(0).setCellValue("Parameter");
        frontBrakeRow.createCell(1).setCellValue("Value");
        frontBrakeRow.createCell(3).setCellValue("Unit");
        // caliper
        frontBrakeRow = frontBrake.createRow(1);
        frontBrakeRow.createCell(0).setCellValue("Caliper");
        frontBrakeRow.createCell(1).setCellValue("");
        frontBrakeRow.createCell(2).setCellValue("");
        frontBrakeRow.createCell(3).setCellValue("");
        for (int i = 2; i < 8; i ++) {
            frontBrakeRow = frontBrake.createRow(i);
            frontBrakeRow.createCell(0).setCellValue(frontBrakeParam1[i-2]);
            frontBrake.addMergedRegion(new CellRangeAddress(i,i,1,2));
            frontBrakeRow.createCell(1).setCellValue(discBrakeMap.get(frontBrakeKey1[i-2]).toString());
            frontBrakeRow.createCell(3).setCellValue(frontBrakeUnit1[i-2]);
        }
        frontBrakeRow = frontBrake.createRow(8);
        frontBrake.addMergedRegion(new CellRangeAddress(8,10,0,0));
        List<Object> frtPVCurveList = (List<Object>) discBrakeMap.get("pVcurve");
        frontBrakeRow.createCell(0).setCellValue("Caliper PV curve");
        frontBrakeRow.createCell(1).setCellValue("500");
        frontBrakeRow.createCell(2).setCellValue(frtPVCurveList.get(0).toString());
        frontBrakeRow.createCell(3).setCellValue("N/A");
        frontBrakeRow = frontBrake.createRow(9);
        frontBrakeRow.createCell(1).setCellValue("5000");
        frontBrakeRow.createCell(2).setCellValue(frtPVCurveList.get(1).toString());
        frontBrakeRow.createCell(3).setCellValue("N/A");
        frontBrakeRow = frontBrake.createRow(10);
        frontBrakeRow.createCell(1).setCellValue("12000");
        frontBrakeRow.createCell(2).setCellValue(frtPVCurveList.get(2).toString());
        frontBrakeRow.createCell(3).setCellValue("N/A");
        String[] frontBrakeParam2 = new String[]{"Corner Compliance", "Displ. Intercept", "Exp. Term"};
        String[] frontBrakeUnit2 = new String[]{"mm^3/kPa", "kPa", "kPa^-1"};
        String[] frontBrakeKey2 = new String[]{"pvK", "pvB", "pvC"};
        for (int i = 11; i < 14; i ++) {
            frontBrakeRow = frontBrake.createRow(i);
            frontBrakeRow.createCell(0).setCellValue(frontBrakeParam2[i-11]);
            frontBrake.addMergedRegion(new CellRangeAddress(i,i,1,2));
            frontBrakeRow.createCell(1).setCellValue(discBrakeMap.get(frontBrakeKey2[i-11]).toString());
            frontBrakeRow.createCell(3).setCellValue(frontBrakeUnit2[i-11]);
        }
        frontBrakeRow = frontBrake.createRow(14);
        frontBrakeRow.createCell(0).setCellValue("");
        frontBrakeRow.createCell(1).setCellValue("");
        frontBrakeRow.createCell(3).setCellValue("");
        // lining
        frontBrakeRow = frontBrake.createRow(15);
        frontBrakeRow.createCell(0).setCellValue("Lining");
        frontBrakeRow.createCell(1).setCellValue("");
        frontBrakeRow.createCell(3).setCellValue("");
        frontBrakeRow = frontBrake.createRow(16);
        frontBrake.addMergedRegion(new CellRangeAddress(16,16,1,2));
        frontBrakeRow.createCell(0).setCellValue("Lining Supplier");
        frontBrakeRow.createCell(1).setCellValue(discBrakeMap.get("linSpl").toString());
        frontBrakeRow.createCell(3).setCellValue("N/A");
        frontBrakeRow = frontBrake.createRow(17);
        frontBrake.addMergedRegion(new CellRangeAddress(17,17,1,2));
        frontBrakeRow.createCell(0).setCellValue("Lining Material");
        frontBrakeRow.createCell(1).setCellValue(discBrakeMap.get("linMat").toString());
        frontBrakeRow.createCell(3).setCellValue("N/A");
        // lin mu
        frontBrakeRow = frontBrake.createRow(18);
        frontBrake.addMergedRegion(new CellRangeAddress(18,20,0,0));
        List<Object> frtLinmu = (List<Object>) discBrakeMap.get("linMu");
        frontBrakeRow.createCell(0).setCellValue("Caliper PV curve");
        frontBrakeRow.createCell(1).setCellValue("500");
        frontBrakeRow.createCell(2).setCellValue(frtLinmu.get(0).toString());
        frontBrakeRow.createCell(3).setCellValue("N/A");
        frontBrakeRow = frontBrake.createRow(19);
        frontBrakeRow.createCell(1).setCellValue("5000");
        frontBrakeRow.createCell(2).setCellValue(frtLinmu.get(1).toString());
        frontBrakeRow.createCell(3).setCellValue("N/A");
        frontBrakeRow = frontBrake.createRow(20);
        frontBrakeRow.createCell(1).setCellValue("12000");
        frontBrakeRow.createCell(2).setCellValue(frtLinmu.get(2).toString());
        frontBrakeRow.createCell(3).setCellValue("N/A");
        String[] frontBrakeParam3 = new String[]{"K for Output Force", "Exp. For Output Force", "No Power Lining mu",
                "Lining Area", "Lining Wear Limit"};
        String[] frontBrakeUnit3 = new String[]{"N·m/kPa", "N/A", "N/A", "N/A", "mm^2", "mm"};
        String[] frontBrakeKey3 = new String[]{"linMuK", "linMuE", "linMuNp", "linArea", "linWearLim"};
        for (int i = 21; i < 26; i ++) {
            frontBrakeRow = frontBrake.createRow(i);
            frontBrakeRow.createCell(0).setCellValue(frontBrakeParam3[i-21]);
            frontBrake.addMergedRegion(new CellRangeAddress(i,i,1,2));
            frontBrakeRow.createCell(1).setCellValue(discBrakeMap.get(frontBrakeKey3[i-21]).toString());
            frontBrakeRow.createCell(3).setCellValue(frontBrakeUnit3[i-21]);
        }
        // Front Rotor Temperature Input
        frontBrake.addMergedRegion(new CellRangeAddress(26,31,0,0));
        List<Object> frtRtTempIn = (List<Object>) discBrakeMap.get("frtRtTempIn");
        for (int i = 26; i < 32; i ++) {
            frontBrakeRow = frontBrake.createRow(i);
            if (i == 26) {
                frontBrakeRow.createCell(0).setCellValue("Front Rotor Temperature Input");
            }
            frontBrake.addMergedRegion(new CellRangeAddress(i,i,1,2));
            frontBrakeRow.createCell(1).setCellValue(getListContent(frtRtTempIn, i-26));
            frontBrakeRow.createCell(3).setCellValue("℃");
        }
        frontBrake.addMergedRegion(new CellRangeAddress(32,37,0,0));
        List<Object> frtLinWearOut = (List<Object>) discBrakeMap.get("frtLinWearOut");
        for (int i = 32; i < 38; i ++) {
            frontBrakeRow = frontBrake.createRow(i);
            if (i == 32) {
                frontBrakeRow.createCell(0).setCellValue("Front Lining Wear Specific Output");
            }
            frontBrake.addMergedRegion(new CellRangeAddress(i,i,1,2));
            frontBrakeRow.createCell(1).setCellValue(getListContent(frtLinWearOut, i-32));
            frontBrakeRow.createCell(3).setCellValue("℃");
        }
        frontBrake.addMergedRegion(new CellRangeAddress(38,43,0,0));
        List<Object> frtLinFrictOut = (List<Object>) discBrakeMap.get("frtLinFrictOut");
        for (int i = 38; i < 44; i ++) {
            frontBrakeRow = frontBrake.createRow(i);
            if (i == 38) {
                frontBrakeRow.createCell(0).setCellValue("Front Lining Wear Specific Output");
            }
            frontBrake.addMergedRegion(new CellRangeAddress(i,i,1,2));
            frontBrakeRow.createCell(1).setCellValue(getListContent(frtLinFrictOut, i-38));
            frontBrakeRow.createCell(3).setCellValue("℃");
        }
        frontBrakeRow = frontBrake.createRow(44);
        frontBrakeRow.createCell(0).setCellValue("Inertia Per Corner");
        frontBrake.addMergedRegion(new CellRangeAddress(44,44,1,2));
        frontBrakeRow.createCell(1).setCellValue(discBrakeMap.get("inPerCorner").toString());
        frontBrakeRow.createCell(3).setCellValue("Kg.m^2");
    }

    public static void setRotor(XSSFCellStyle style, Map<String, Object> brakeMap, XSSFSheet rotor, int startRow) {
        String rotorType = brakeMap.get("rtType").toString();
        XSSFRow rotorRow;
        style.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        rotorRow = rotor.createRow(startRow + 0);
        rotorRow.createCell(0).setCellValue("");
        rotorRow.createCell(1).setCellValue("");
        rotorRow.createCell(2).setCellValue("");
        rotorRow.createCell(3).setCellValue("");
        rotorRow = rotor.createRow(startRow + 1);
        rotorRow.createCell(0).setCellValue("Rotor");
        rotorRow.createCell(1).setCellValue("");
        rotorRow.createCell(2).setCellValue("");
        rotorRow.createCell(3).setCellValue("");
        rotorRow = rotor.createRow(startRow + 2);
        rotor.addMergedRegion(new CellRangeAddress(startRow + 2,startRow + 2,1,2));
        rotorRow.createCell(0).setCellValue("Rotor Type");
        rotorRow.createCell(1).setCellValue(rotorType);
        rotorRow.createCell(3).setCellValue("N/A");
        String[] rotorUnit;
        String[] rotorParam;
        String[] rotorKey;
        if(rotorType.equals("Vented")) {
            rotorParam = new String[]{"Rotor Manufacturer", "Rotor Material", "Rotor Effective Radius",
                    "Rotor OD", "Rotor ID", "inner Cheek Thickness", "outer Cheek Thickness", "Rotor Thickness", "Number of Vanes",
                    "Vane Length", "Vane Height", "Vane Thickness", "Working Mass", "Working Area", "Frt Rotor Denisty", "CC@50",
                    "CC@80", "CC@110", "CVR@50", "CVR@80", "CVR@110"};
            rotorUnit = new String[]{"N/A", "N/A", "mm", "mm", "mm", "mm", "mm", "mm", "N/A", "mm", "mm", "mm", "kg",
                    "mm^2", "kg/m^3", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A"};
            rotorKey = new String[]{"rrManu", "rrMat", "efcR", "outD", "inD", "ckTIn", "ckTOut", "rtT", "vaneNum",
                    "vaneLen", "vaneHigh", "vanT", "wm", "wa", "rho", "cc50", "cc80", "cc110", "cvr50", "cvr80", "cvr110"};
        } else if (rotorType.equals("Solid")) {
            rotorParam= new String[]{"Rotor Manufacturer", "Rotor Material", "Rotor Effective Radius",
                    "Rotor OD", "Rotor ID", "Rotor Thickness", "Working Mass",
                    "Working Area", "Frt Rotor Denisty", "CC@50", "CC@80", "CC@110", "CVR@50", "CVR@80", "CVR@110"};
            rotorUnit = new String[]{"N/A", "N/A", "mm", "mm", "mm", "mm", "kg",
                    "mm^2", "kg/m^3", "N/A", "N/A", "N/A", "N/A", "N/A", "N/A"};
            rotorKey = new String[]{"manu", "rrMat", "rtEfcR", "outD", "inD", "rtT", "wm", "wa", "rho", "cc50", "cc80",
                    "cc110", "cvr50", "cvr80", "cvr110"};
        } else {
            rotorParam = new String[]{"Rotor Manufacturer", "Rotor Material", "Rotor swept area", "Drum Effective Radius",
                    "Drum OD", "Drum ID", "Drum Thickness", "Drum Rib Thicknes", "Drum Rib Width", "Drum Width",
                    "Working Mass", "Working Area", "RR Drum Denisty", "CC@50", "CC@80", "CC@110", "CVR@50", "CVR@80", "CVR@110"};
            rotorUnit = new String[]{"N/A", "N/A", "mm^2", "mm", "mm", "mm", "mm", "mm", "mm", "mm", "kg", "mm^2", "kg/m^3", "N/A",
                    "N/A", "N/A", "N/A", "N/A", "N/A"};
            rotorKey = new String[]{"rrManu", "rrMat", "swpArea", "efcR", "outD", "inD", "rtThick", "ribThick", "ribWidth", "rtWidth",
                    "wm", "wa", "rho", "cc50", "cc80", "cc110", "cvr50", "cvr80", "cvr110"};
        }
        for (int i = startRow + 3; i < startRow + 3 + rotorParam.length; i ++) {
            rotorRow = rotor.createRow(i);
            rotorRow.createCell(0).setCellValue(rotorParam[i-startRow-3]);
            rotor.addMergedRegion(new CellRangeAddress(i,i,1,2));
            rotorRow.createCell(1).setCellValue(brakeMap.get(rotorKey[i-startRow-3]).toString());
            rotorRow.createCell(3).setCellValue(rotorUnit[i-startRow-3]);
        }
        // Rotor Temperature Input
        rotor.addMergedRegion(new CellRangeAddress(startRow + 3 + rotorParam.length,startRow + 8 + rotorParam.length,0,0));
        List<Object> rtTempIn = rotorType.equals("Drum") ? (List<Object>) brakeMap.get("dmTempIn") : (List<Object>) brakeMap.get("rtTempIn");
        for (int i = startRow + 3 + rotorParam.length; i < startRow + 9 + rotorParam.length; i ++) {
            rotorRow = rotor.createRow(i);
            if (i == startRow + 3 + rotorParam.length) {
                rotorRow.createCell(0).setCellValue("Rotor Temperature Input");
            }
            rotor.addMergedRegion(new CellRangeAddress(i,i,1,2));
            rotorRow.createCell(1).setCellValue(getListContent(rtTempIn, i- startRow - 3 - rotorParam.length));
            rotorRow.createCell(3).setCellValue("℃");
        }
        // Rotor Specific Output
        rotor.addMergedRegion(new CellRangeAddress(startRow + 9 + rotorParam.length,startRow + 14 + rotorParam.length,0,0));
        List<Object> rtSpecOut = rotorType.equals("Drum") ? (List<Object>) brakeMap.get("dmTempOut") : (List<Object>) brakeMap.get("rtSpecOut");
        for (int i = startRow + 9 + rotorParam.length; i < startRow + 15 + rotorParam.length; i ++) {
            rotorRow = rotor.createRow(i);
            if (i == startRow + 9 + rotorParam.length) {
                rotorRow.createCell(0).setCellValue("Rotor Specific Output");
            }
            rotor.addMergedRegion(new CellRangeAddress(i,i,1,2));
            rotorRow.createCell(1).setCellValue(getListContent(rtSpecOut, i- startRow - 9 - rotorParam.length));
            rotorRow.createCell(3).setCellValue("J/(Kg.C)");
        }
    }

    public static String getListContent(List<Object> list, int index) {
        try {
            String content = list.get(index).toString();
            return content;
        } catch (Exception e) {
            return "";
        }
    }
}
