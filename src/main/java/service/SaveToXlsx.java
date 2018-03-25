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
    private Map<String, Object> resultParams;
    private String path;

    public void setParams(Map<String, Map<String, Object>> params){
        this.params = params;
    }

    public void setResultParams(Map<String, Object> resultParams){
        this.resultParams = resultParams;
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
        for (int i = 2; i < 6; i ++) {
            requireRow = requirement.createRow(i);
            requireRow.createCell(0).setCellValue(requireParam1[i-2]);
            requireRow.createCell(1).setCellValue(requireMap.get(requireKey1[i-2]).toString());
            requireRow.createCell(2).setCellValue(requireUnit1[i-2]);
        }
        requireRow = requirement.createRow(6);
        requireRow.createCell(0).setCellValue("Lining Power");
        requireRow.createCell(1).setCellValue("");
        requireRow.createCell(2).setCellValue("");
        String[] requireParam2 = new String[]{"End Velocity after Brake", "Lining Power Front @0.85g GVW",
                "Lining Power Rear @0.85g GVW", "Initial Velocity before Brake"};
        String[] requireUnit2 = new String[]{"km/h", "km/h", "kW/cm^2", "kW/cm^2"};
        String[] requireKey2 = new String[]{"linVi", "linV0", "frtLinPwr", "rrLinPwr"};
        for (int i = 7; i < 11; i ++) {
            requireRow = requirement.createRow(i);
            requireRow.createCell(0).setCellValue(requireParam2[i-7]);
            requireRow.createCell(1).setCellValue(requireMap.get(requireKey2[i-7]).toString());
            requireRow.createCell(2).setCellValue(requireUnit2[i-7]);
        }
        requireRow = requirement.createRow(11);
        requireRow.createCell(0).setCellValue("HFT");
        requireRow.createCell(1).setCellValue("");
        requireRow.createCell(2).setCellValue("");
        String[] requireParam3 = new String[]{"Initial Velocity before Brake", "End Velocity after Brake",
                "Heat Flow Density Front Rotor @0.85g GVW", "Heat Flow Density Rear Rotor @0.85g GVW"};
        String[] requireUnit3 = new String[]{"km/h", "km/h", "kW/cm^2", "kW/cm^2"};
        String[] requireKey3 = new String[]{ "hftVi", "hftV0", "frtHftPwr", "rrHftPwr"};
        for (int i = 12; i < 16; i ++) {
            requireRow = requirement.createRow(i);
            requireRow.createCell(0).setCellValue(requireParam3[i-12]);
            requireRow.createCell(1).setCellValue(requireMap.get(requireKey3[i-12]).toString());
            requireRow.createCell(2).setCellValue(requireUnit3[i-12]);
        }
        // BET AMS II AMS III
        List<Object> bet = (List<Object>) requireMap.get("bet");
        requireRow = requirement.createRow(17);
        requireRow.createCell(0).setCellValue("");
        requireRow.createCell(1).setCellValue("BET");
        requireRow.createCell(2).setCellValue("AMS II");
        requireRow.createCell(3).setCellValue("AMS III");
        requireRow.createCell(4).setCellValue("Unit");
        String[] requireParam4 = new String[]{"Initial Rotor Tempeture", "Initial Velocity before Brake", "End Velocity after Brake",
                "Deceleration on brake", "Acceleration on accelerate（WOT)", "Total Time", "Total Circle Times", "Max Front", "Max Rear"};
        String[] requireUnit4 = new String[]{"℃", "km/h", "km/h", "g", "g", "s", "N/A", "℃", "℃"};
        for (int i = 18; i < 27; i ++) {
            requireRow = requirement.createRow(i);
            requireRow.createCell(0).setCellValue(requireParam4[i-18]);
            requireRow.createCell(1).setCellValue(String.valueOf(bet.get((i-18) * 3)));
            requireRow.createCell(2).setCellValue(String.valueOf(bet.get((i-18) * 3 + 1)));
            requireRow.createCell(3).setCellValue(String.valueOf(bet.get((i-18) * 3 + 2)));
            requireRow.createCell(4).setCellValue(requireUnit4[i-18]);
        }
        // brake stop
        requireRow = requirement.createRow(28);
        requirement.addMergedRegion(new CellRangeAddress(28,28,0,5));
        requireRow.createCell(0).setCellValue("Brake Stop");
        List<Object> brakeStop = (List<Object>) requireMap.get("brakeStop");
        requireRow = requirement.createRow(29);
        requireRow.createCell(0).setCellValue("");
        requireRow.createCell(1).setCellValue("@LVW Power");
        requireRow.createCell(2).setCellValue("@LVW Nopower");
        requireRow.createCell(3).setCellValue("@GVW Power");
        requireRow.createCell(4).setCellValue("@GVW Nopower");
        requireRow.createCell(5).setCellValue("Unit");
        String[] requireParam5 = new String[]{"initial velocity", "Pedal force", "Stopping Distance  requirement",
                "response time", "pass margin", "decel", "brake distance"};
        String[] requireUnit5 = new String[]{"km/h", "N", "m", "s", "N/A", "g", "m"};
        for (int i = 30; i < 37; i ++) {
            requireRow = requirement.createRow(i);
            requireRow.createCell(0).setCellValue(requireParam5[i-30]);
            requireRow.createCell(1).setCellValue(String.valueOf(brakeStop.get((i-30) * 4)));
            requireRow.createCell(2).setCellValue(String.valueOf(brakeStop.get((i-30) * 4 + 1)));
            requireRow.createCell(3).setCellValue(String.valueOf(brakeStop.get((i-30) * 4 + 2)));
            requireRow.createCell(4).setCellValue(String.valueOf(brakeStop.get((i-30) * 4 + 3)));
            requireRow.createCell(5).setCellValue(requireUnit5[i-30]);
        }
        // pedal feel
        requireRow = requirement.createRow(39);
        requirement.addMergedRegion(new CellRangeAddress(39,39,0,4));
        requireRow.createCell(0).setCellValue("Pedal Feel");
        List<Object> pedalFeel = (List<Object>) requireMap.get("pedalFeel");
        requireRow = requirement.createRow(40);
        requireRow.createCell(0).setCellValue("");
        requireRow.createCell(1).setCellValue("Min");
        requireRow.createCell(2).setCellValue("Normal");
        requireRow.createCell(3).setCellValue("Max");
        requireRow.createCell(4).setCellValue("Unit");
        String[] requireParam6 = new String[]{"Preload：Pedal Force", "Onset Pedal force @0.05g", "Onset Pedal Travel @0.05g",
                "Normal Pedal force（Onset+0.5）", "Normal Pedal travel（Onset+0.5）", "Pedal Force @0.9g GVW"};
        String[] requireUnit6 = new String[]{"N", "N", "mm", "N", "mm", "N"};
        for (int i = 41; i < 47; i ++) {
            requireRow = requirement.createRow(i);
            requireRow.createCell(0).setCellValue(requireParam6[i-41]);
            requireRow.createCell(1).setCellValue(String.valueOf(pedalFeel.get((i-41) * 3)));
            requireRow.createCell(2).setCellValue(String.valueOf(pedalFeel.get((i-41) * 3 + 1)));
            requireRow.createCell(3).setCellValue(String.valueOf(pedalFeel.get((i-41) * 3 + 2)));
            requireRow.createCell(4).setCellValue(requireUnit6[i-41]);
        }
        // result

        XSSFSheet result = wb.createSheet("Result");
        XSSFRow resultRow;
        resultRow = result.createRow(0);
        result.addMergedRegion(new CellRangeAddress(0,0,0,6));
        resultRow.createCell(0).setCellValue("Vehicle Performance");
        resultRow = result.createRow(1);
        resultRow.createCell(0).setCellValue("");
        resultRow.createCell(1).setCellValue("Metric");
        resultRow.createCell(2).setCellValue("Value");
        resultRow.createCell(3).setCellValue("Min");
        resultRow.createCell(4).setCellValue("Req");
        resultRow.createCell(5).setCellValue("Max");
        resultRow.createCell(6).setCellValue("Unit");
        String[] resultParam1 = new String[]{"Preload：Pedal Force", "Onset Pedal force @0.05g", "Onset Pedal Travel @0.05g",
                "Normal Pedal force（Onset+0.5）", "Normal Pedal travel（Onset+0.5）", "Pedal Force @0.8g GVW", "Pedal Force @0.9g GVW",
                "Pedal Force @1g GVW", "Linearity Pedal Force", "Linearity Pedal Travel", "Tire k @ 0.7g GVW", "Tire k @ 0.8g GVW",
                "Tire k @ 0.9g GVW", "Max GVW Decel", "Max LVW Decel"};
        String[] resultUnit1 = new String[]{"N", "N", "mm", "N", "mm", "N", "N", "N", "N/A", "N/A", "N/A", "N/A", "N/A", "g", "g"};
        List<String> bfi = (List<String>) resultParams.get("BFI");
        resultRow = result.createRow(2);
        result.addMergedRegion(new CellRangeAddress(2,16,0,0));
        resultRow.createCell(0).setCellValue("BFI");
        for (int i = 2; i < 17; i ++) {
            if (i != 2) {
                resultRow = result.createRow(i);
            }
            resultRow.createCell(1).setCellValue(resultParam1[i-2]);
            resultRow.createCell(2).setCellValue(bfi.get((i-2)*4));
            resultRow.createCell(3).setCellValue(bfi.get((i-2)*4 + 1));
            resultRow.createCell(4).setCellValue(bfi.get((i-2)*4 + 2));
            resultRow.createCell(5).setCellValue(bfi.get((i-2)*4 + 3));
            resultRow.createCell(6).setCellValue(resultUnit1[i-2]);
        }
        String[] resultParam2 = new String[]{"LVW Z Critical", "GVW Z Critical"};
        String[] resultUnit2 = new String[]{"N/A", "N/A"};
        List<String> brkBalance = (List<String>) resultParams.get("Brake Balance");
        resultRow = result.createRow(17);
        result.addMergedRegion(new CellRangeAddress(17,18,0,0));
        resultRow.createCell(0).setCellValue("Brake Balance");
        for (int i = 17; i < 19; i ++) {
            if (i != 17) {
                resultRow = result.createRow(i);
            }
            resultRow.createCell(1).setCellValue(resultParam2[i-17]);
            resultRow.createCell(2).setCellValue(brkBalance.get((i-17)*4));
            resultRow.createCell(3).setCellValue(brkBalance.get((i-17)*4 + 1));
            resultRow.createCell(4).setCellValue(brkBalance.get((i-17)*4 + 2));
            resultRow.createCell(5).setCellValue(brkBalance.get((i-17)*4 + 3));
            resultRow.createCell(6).setCellValue(resultUnit2[i-17]);
        }
        // Booster Runout
        String[] resultParam3 = new String[]{"Decel Booster Runout GVW", "Decel Booster Runout LVW"};
        String[] resultUnit3 = new String[]{"g", "g"};
        List<String> bstRun = (List<String>) resultParams.get("Booster Runout");
        resultRow = result.createRow(19);
        result.addMergedRegion(new CellRangeAddress(19,20,0,0));
        resultRow.createCell(0).setCellValue("Booster Runout");
        for (int i = 19; i < 21; i ++) {
            if (i != 19) {
                resultRow = result.createRow(i);
            }
            resultRow.createCell(1).setCellValue(resultParam3[i-19]);
            resultRow.createCell(2).setCellValue(bstRun.get((i-19)*4));
            resultRow.createCell(3).setCellValue(bstRun.get((i-19)*4 + 1));
            resultRow.createCell(4).setCellValue(bstRun.get((i-19)*4 + 2));
            resultRow.createCell(5).setCellValue(bstRun.get((i-19)*4 + 3));
            resultRow.createCell(6).setCellValue(resultUnit3[i-19]);
        }
        // Brake Pressure @1g
        String[] resultParam4 = new String[]{"Front Brake Pressure @1g GVW", "Rear Brake Pressure @1g GVW"};
        String[] resultUnit4 = new String[]{"MPa", "MPa"};
        List<String> brakePressure = (List<String>) resultParams.get("Brake Pressure @1g");
        resultRow = result.createRow(21);
        result.addMergedRegion(new CellRangeAddress(21,22,0,0));
        resultRow.createCell(0).setCellValue("Brake Pressure @1g");
        for (int i = 21; i < 23; i ++) {
            if (i != 21) {
                resultRow = result.createRow(i);
            }
            resultRow.createCell(1).setCellValue(resultParam4[i-21]);
            resultRow.createCell(2).setCellValue(brakePressure.get((i-21)*4));
            resultRow.createCell(3).setCellValue(brakePressure.get((i-21)*4 + 1));
            resultRow.createCell(4).setCellValue(brakePressure.get((i-21)*4 + 2));
            resultRow.createCell(5).setCellValue(brakePressure.get((i-21)*4 + 3));
            resultRow.createCell(6).setCellValue(resultUnit4[i-21]);
        }

        // none VP
        String[] resultParam5 = new String[]{"Stroke of Master Cylinder", "Total Pedal Travel"};
        String[] resultUnit5 = new String[]{"mm", "mm"};
        List<String> noneVP = (List<String>) resultParams.get("noneVP");
        resultRow = result.createRow(23);
        result.addMergedRegion(new CellRangeAddress(23,24,0,0));
        resultRow.createCell(0).setCellValue("Brake Pressure @1g");
        for (int i = 23; i < 25; i ++) {
            if (i != 23) {
                resultRow = result.createRow(i);
            }
            resultRow.createCell(1).setCellValue(resultParam5[i-23]);
            resultRow.createCell(2).setCellValue(noneVP.get((i-23)*4));
            resultRow.createCell(3).setCellValue(noneVP.get((i-23)*4 + 1));
            resultRow.createCell(4).setCellValue(noneVP.get((i-23)*4 + 2));
            resultRow.createCell(5).setCellValue(noneVP.get((i-23)*4 + 3));
            resultRow.createCell(6).setCellValue(resultUnit5[i-23]);
        }

        // Thermal
        resultRow = result.createRow(26);
        result.addMergedRegion(new CellRangeAddress(26,26,0,4));
        resultRow.createCell(0).setCellValue("Thermal");
        resultRow = result.createRow(27);
        resultRow.createCell(0).setCellValue("");
        resultRow.createCell(1).setCellValue("Metric");
        resultRow.createCell(2).setCellValue("Value");
        resultRow.createCell(3).setCellValue("Req");
        resultRow.createCell(4).setCellValue("Unit");
        // BET
        String[] resultParam6 = new String[]{"Front BET Temp. Rise", "Rear BET Temp. Rise"};
        String[] resultUnit6 = new String[]{"℃", "℃"};
        List<String> betT = (List<String>) resultParams.get("BET");
        resultRow = result.createRow(28);
        result.addMergedRegion(new CellRangeAddress(28,29,0,0));
        resultRow.createCell(0).setCellValue("BET");
        for (int i = 28; i < 30; i ++) {
            if (i != 28) {
                resultRow = result.createRow(i);
            }
            resultRow.createCell(1).setCellValue(resultParam6[i-28]);
            resultRow.createCell(2).setCellValue(betT.get((i-28)*2));
            resultRow.createCell(3).setCellValue(betT.get((i-28)*2 + 1));
            resultRow.createCell(4).setCellValue(resultUnit6[i-28]);
        }

        // AMS3
        String[] resultParam7 = new String[]{"Front AMS3 Temp. Rise", "Rear AMS3 Temp. Rise"};
        String[] resultUnit7 = new String[]{"℃", "℃"};
        List<String> AMS3 = (List<String>) resultParams.get("AMS3");
        resultRow = result.createRow(30);
        result.addMergedRegion(new CellRangeAddress(30,31,0,0));
        resultRow.createCell(0).setCellValue("AMS3");
        for (int i = 30; i < 32; i ++) {
            if (i != 30) {
                resultRow = result.createRow(i);
            }
            resultRow.createCell(1).setCellValue(resultParam7[i-30]);
            resultRow.createCell(2).setCellValue(AMS3.get((i-30)*2));
            resultRow.createCell(3).setCellValue(AMS3.get((i-30)*2 + 1));
            resultRow.createCell(4).setCellValue(resultUnit7[i-30]);
        }

        // Single Stop
        String[] resultParam8 = new String[]{"Front AMS3 Temp. Rise", "Rear AMS3 Temp. Rise"};
        String[] resultUnit8 = new String[]{"℃", "℃"};
        List<String> sngStop = (List<String>) resultParams.get("Single Stop");
        resultRow = result.createRow(32);
        result.addMergedRegion(new CellRangeAddress(32,33,0,0));
        resultRow.createCell(0).setCellValue("Single Stop");
        for (int i = 32; i < 34; i ++) {
            if (i != 32) {
                resultRow = result.createRow(i);
            }
            resultRow.createCell(1).setCellValue(resultParam8[i-32]);
            resultRow.createCell(2).setCellValue(sngStop.get((i-32)*2));
            resultRow.createCell(3).setCellValue(sngStop.get((i-32)*2 + 1));
            resultRow.createCell(4).setCellValue(resultUnit8[i-32]);
        }

        // Single Stop
        String[] resultParam9 = new String[]{"Lining Power Front @0.85g GVW", "Lining Power Rear @0.85g GVW"};
        String[] resultUnit9 = new String[]{"kW/cm^2", "kW/cm^2"};
        List<String> linP = (List<String>) resultParams.get("Lining Power");
        resultRow = result.createRow(34);
        result.addMergedRegion(new CellRangeAddress(34,35,0,0));
        resultRow.createCell(0).setCellValue("Lining Power");
        for (int i = 34; i < 36; i ++) {
            if (i != 34) {
                resultRow = result.createRow(i);
            }
            resultRow.createCell(1).setCellValue(resultParam9[i-34]);
            resultRow.createCell(2).setCellValue(linP.get((i-34)*2));
            resultRow.createCell(3).setCellValue(linP.get((i-34)*2 + 1));
            resultRow.createCell(4).setCellValue(resultUnit9[i-34]);
        }

        // HFD
        String[] resultParam10 = new String[]{"Heat Flow Density Front Rotor @0.85g GVW", "Heat Flow Density Rear Rotor @0.85g GVW"};
        String[] resultUnit10 = new String[]{"kW/cm^2", "kW/cm^2"};
        List<String> HFD = (List<String>) resultParams.get("HFD");
        resultRow = result.createRow(36);
        result.addMergedRegion(new CellRangeAddress(36,37,0,0));
        resultRow.createCell(0).setCellValue("HFD");
        for (int i = 36; i < 38; i ++) {
            if (i != 36) {
                resultRow = result.createRow(i);
            }
            resultRow.createCell(1).setCellValue(resultParam10[i-36]);
            resultRow.createCell(2).setCellValue(HFD.get((i-36)*2));
            resultRow.createCell(3).setCellValue(HFD.get((i-36)*2 + 1));
            resultRow.createCell(4).setCellValue(resultUnit10[i-36]);
        }

        // lin life
        String[] resultParam11 = new String[]{"Front lining life", "Rear lining life"};
        String[] resultUnit11 = new String[]{"N/A", "N/A"};
        List<String> linLife = (List<String>) resultParams.get("Lining Life");
        resultRow = result.createRow(38);
        result.addMergedRegion(new CellRangeAddress(38,39,0,0));
        resultRow.createCell(0).setCellValue("Lining Life");
        for (int i = 38; i < 40; i ++) {
            if (i != 38) {
                resultRow = result.createRow(i);
            }
            resultRow.createCell(1).setCellValue(resultParam11[i-38]);
            resultRow.createCell(2).setCellValue(linLife.get((i-38)*2));
            resultRow.createCell(3).setCellValue(linLife.get((i-38)*2 + 1));
            resultRow.createCell(4).setCellValue(resultUnit11[i-38]);
        }

        // brake stop
        resultRow = result.createRow(41);
        result.addMergedRegion(new CellRangeAddress(41,41,0,4));
        resultRow.createCell(0).setCellValue("Brake stop");
        resultRow = result.createRow(42);
        resultRow.createCell(0).setCellValue("");
        resultRow.createCell(1).setCellValue("Metric");
        resultRow.createCell(2).setCellValue("Value");
        resultRow.createCell(3).setCellValue("Req");
        resultRow.createCell(4).setCellValue("Unit");

        // Stopping Distance @ LVW Power
        String[] resultParam12 = new String[]{"brake distance", "pass margin", "decel"};
        String[] resultUnit12 = new String[]{"m", "N/A", "g"};
        List<String> SDLP = (List<String>) resultParams.get("Stopping Distance @ LVW Power");
        resultRow = result.createRow(43);
        result.addMergedRegion(new CellRangeAddress(43,45,0,0));
        resultRow.createCell(0).setCellValue("Stopping Distance @ LVW Power");
        for (int i = 43; i < 46; i ++) {
            if (i != 43) {
                resultRow = result.createRow(i);
            }
            resultRow.createCell(1).setCellValue(resultParam12[i-43]);
            resultRow.createCell(2).setCellValue(SDLP.get((i-43)*2));
            resultRow.createCell(3).setCellValue(SDLP.get((i-43)*2 + 1));
            resultRow.createCell(4).setCellValue(resultUnit12[i-43]);
        }

        // Stopping Distance @ LVW Nopower
        List<String> SDLN = (List<String>) resultParams.get("Stopping Distance @ LVW Nopower");
        resultRow = result.createRow(46);
        result.addMergedRegion(new CellRangeAddress(46,48,0,0));
        resultRow.createCell(0).setCellValue("Stopping Distance @ LVW Nopower");
        for (int i = 46; i < 49; i ++) {
            if (i != 46) {
                resultRow = result.createRow(i);
            }
            resultRow.createCell(1).setCellValue(resultParam12[i-46]);
            resultRow.createCell(2).setCellValue(SDLN.get((i-46)*2));
            resultRow.createCell(3).setCellValue(SDLN.get((i-46)*2 + 1));
            resultRow.createCell(4).setCellValue(resultUnit12[i-46]);
        }

        // Stopping Distance @ GVW Power
        List<String> SDGP = (List<String>) resultParams.get("Stopping Distance @ GVW Power");
        resultRow = result.createRow(49);
        result.addMergedRegion(new CellRangeAddress(49,51,0,0));
        resultRow.createCell(0).setCellValue("Stopping Distance @ GVW Power");
        for (int i = 49; i < 52; i ++) {
            if (i != 49) {
                resultRow = result.createRow(i);
            }
            resultRow.createCell(1).setCellValue(resultParam12[i-49]);
            resultRow.createCell(2).setCellValue(SDGP.get((i-49)*2));
            resultRow.createCell(3).setCellValue(SDGP.get((i-49)*2 + 1));
            resultRow.createCell(4).setCellValue(resultUnit12[i-49]);
        }

        // Stopping Distance @ GVW Nopower
        List<String> SDGN = (List<String>) resultParams.get("Stopping Distance @ GVW Nopower");
        resultRow = result.createRow(52);
        result.addMergedRegion(new CellRangeAddress(52,54,0,0));
        resultRow.createCell(0).setCellValue("Stopping Distance @ GVW Nopower");
        for (int i = 52; i < 55; i ++) {
            if (i != 52) {
                resultRow = result.createRow(i);
            }
            resultRow.createCell(1).setCellValue(resultParam12[i-52]);
            resultRow.createCell(2).setCellValue(SDGN.get((i-52)*2));
            resultRow.createCell(3).setCellValue(SDGN.get((i-52)*2 + 1));
            resultRow.createCell(4).setCellValue(resultUnit12[i-52]);
        }

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
                "# of Pistons per Caliper", "Overall Piston Area", "Caliper Hold off Pressure Torque", "Caliper Hold off Pressure Volume"};
        String[] frontBrakeUnit1 = new String[]{"N/A", "N/A", "mm", "N/A", "mm^2", "kPa", "kPa"};
        String[] frontBrakeKey1 = new String[]{"frtType", "frtManu", "pstD", "pstNum", "pstArea", "hfPT", "hfPV"};
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
        for (int i = 2; i < 9; i ++) {
            frontBrakeRow = frontBrake.createRow(i);
            frontBrakeRow.createCell(0).setCellValue(frontBrakeParam1[i-2]);
            frontBrake.addMergedRegion(new CellRangeAddress(i,i,1,2));
            frontBrakeRow.createCell(1).setCellValue(discBrakeMap.get(frontBrakeKey1[i-2]).toString());
            frontBrakeRow.createCell(3).setCellValue(frontBrakeUnit1[i-2]);
        }
        frontBrakeRow = frontBrake.createRow(9);
        frontBrake.addMergedRegion(new CellRangeAddress(9,11,0,0));
        List<Object> frtPVCurveList = (List<Object>) discBrakeMap.get("pVcurve");
        frontBrakeRow.createCell(0).setCellValue("Caliper PV curve");
        frontBrakeRow.createCell(1).setCellValue("500");
        frontBrakeRow.createCell(2).setCellValue(frtPVCurveList.get(0).toString());
        frontBrakeRow.createCell(3).setCellValue("N/A");
        frontBrakeRow = frontBrake.createRow(10);
        frontBrakeRow.createCell(1).setCellValue("5000");
        frontBrakeRow.createCell(2).setCellValue(frtPVCurveList.get(1).toString());
        frontBrakeRow.createCell(3).setCellValue("N/A");
        frontBrakeRow = frontBrake.createRow(11);
        frontBrakeRow.createCell(1).setCellValue("12000");
        frontBrakeRow.createCell(2).setCellValue(frtPVCurveList.get(2).toString());
        frontBrakeRow.createCell(3).setCellValue("N/A");
        String[] frontBrakeParam2 = new String[]{"Corner Compliance", "Displ. Intercept", "Exp. Term"};
        String[] frontBrakeUnit2 = new String[]{"mm^3/kPa", "kPa", "kPa^-1"};
        String[] frontBrakeKey2 = new String[]{"pvK", "pvB", "pvC"};
        for (int i = 12; i < 15; i ++) {
            frontBrakeRow = frontBrake.createRow(i);
            frontBrakeRow.createCell(0).setCellValue(frontBrakeParam2[i-12]);
            frontBrake.addMergedRegion(new CellRangeAddress(i,i,1,2));
            frontBrakeRow.createCell(1).setCellValue(discBrakeMap.get(frontBrakeKey2[i-12]).toString());
            frontBrakeRow.createCell(3).setCellValue(frontBrakeUnit2[i-12]);
        }
        frontBrakeRow = frontBrake.createRow(15);
        frontBrakeRow.createCell(0).setCellValue("");
        frontBrakeRow.createCell(1).setCellValue("");
        frontBrakeRow.createCell(3).setCellValue("");
        // lining
        frontBrakeRow = frontBrake.createRow(16);
        frontBrakeRow.createCell(0).setCellValue("Lining");
        frontBrakeRow.createCell(1).setCellValue("");
        frontBrakeRow.createCell(3).setCellValue("");
        frontBrakeRow = frontBrake.createRow(17);
        frontBrake.addMergedRegion(new CellRangeAddress(17,17,1,2));
        frontBrakeRow.createCell(0).setCellValue("Lining Supplier");
        frontBrakeRow.createCell(1).setCellValue(discBrakeMap.get("linSpl").toString());
        frontBrakeRow.createCell(3).setCellValue("N/A");
        frontBrakeRow = frontBrake.createRow(18);
        frontBrake.addMergedRegion(new CellRangeAddress(18,18,1,2));
        frontBrakeRow.createCell(0).setCellValue("Lining Material");
        frontBrakeRow.createCell(1).setCellValue(discBrakeMap.get("linMat").toString());
        frontBrakeRow.createCell(3).setCellValue("N/A");
        // lin mu
        frontBrakeRow = frontBrake.createRow(19);
        frontBrake.addMergedRegion(new CellRangeAddress(19,21,0,0));
        List<Object> frtLinmu = (List<Object>) discBrakeMap.get("linMu");
        frontBrakeRow.createCell(0).setCellValue("Caliper PV curve");
        frontBrakeRow.createCell(1).setCellValue("500");
        frontBrakeRow.createCell(2).setCellValue(frtLinmu.get(0).toString());
        frontBrakeRow.createCell(3).setCellValue("N/A");
        frontBrakeRow = frontBrake.createRow(20);
        frontBrakeRow.createCell(1).setCellValue("5000");
        frontBrakeRow.createCell(2).setCellValue(frtLinmu.get(1).toString());
        frontBrakeRow.createCell(3).setCellValue("N/A");
        frontBrakeRow = frontBrake.createRow(21);
        frontBrakeRow.createCell(1).setCellValue("12000");
        frontBrakeRow.createCell(2).setCellValue(frtLinmu.get(2).toString());
        frontBrakeRow.createCell(3).setCellValue("N/A");
        String[] frontBrakeParam3 = new String[]{"K for Output Force", "Exp. For Output Force", "No Power Lining mu",
                "Lining Area", "Lining Wear Limit"};
        String[] frontBrakeUnit3 = new String[]{"N·m/kPa", "N/A", "N/A", "N/A", "mm^2", "mm"};
        String[] frontBrakeKey3 = new String[]{"linMuK", "linMuE", "linMuNp", "linArea", "linWearLim"};
        for (int i = 22; i < 27; i ++) {
            frontBrakeRow = frontBrake.createRow(i);
            frontBrakeRow.createCell(0).setCellValue(frontBrakeParam3[i-22]);
            frontBrake.addMergedRegion(new CellRangeAddress(i,i,1,2));
            frontBrakeRow.createCell(1).setCellValue(discBrakeMap.get(frontBrakeKey3[i-22]).toString());
            frontBrakeRow.createCell(3).setCellValue(frontBrakeUnit3[i-22]);
        }
        // Front Rotor Temperature Input
        frontBrake.addMergedRegion(new CellRangeAddress(27,32,0,0));
        List<Object> frtRtTempIn = (List<Object>) discBrakeMap.get("frtRtTempIn");
        for (int i = 27; i < 33; i ++) {
            frontBrakeRow = frontBrake.createRow(i);
            if (i == 27) {
                frontBrakeRow.createCell(0).setCellValue("Front Rotor Temperature Input");
            }
            frontBrake.addMergedRegion(new CellRangeAddress(i,i,1,2));
            frontBrakeRow.createCell(1).setCellValue(getListContent(frtRtTempIn, i-27));
            frontBrakeRow.createCell(3).setCellValue("℃");
        }
        frontBrake.addMergedRegion(new CellRangeAddress(33,38,0,0));
        List<Object> frtLinWearOut = (List<Object>) discBrakeMap.get("frtLinWearOut");
        for (int i = 33; i < 39; i ++) {
            frontBrakeRow = frontBrake.createRow(i);
            if (i == 33) {
                frontBrakeRow.createCell(0).setCellValue("Front Lining Wear Specific Output");
            }
            frontBrake.addMergedRegion(new CellRangeAddress(i,i,1,2));
            frontBrakeRow.createCell(1).setCellValue(getListContent(frtLinWearOut, i-33));
            frontBrakeRow.createCell(3).setCellValue("℃");
        }
        frontBrake.addMergedRegion(new CellRangeAddress(39,44,0,0));
        List<Object> frtLinFrictOut = (List<Object>) discBrakeMap.get("frtLinFrictOut");
        for (int i = 39; i < 45; i ++) {
            frontBrakeRow = frontBrake.createRow(i);
            if (i == 39) {
                frontBrakeRow.createCell(0).setCellValue("Front Lining Wear Specific Output");
            }
            frontBrake.addMergedRegion(new CellRangeAddress(i,i,1,2));
            frontBrakeRow.createCell(1).setCellValue(getListContent(frtLinFrictOut, i-39));
            frontBrakeRow.createCell(3).setCellValue("℃");
        }
        frontBrakeRow = frontBrake.createRow(45);
        frontBrakeRow.createCell(0).setCellValue("Inertia Per Corner");
        frontBrake.addMergedRegion(new CellRangeAddress(45,45,1,2));
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
            // remove swpArea 2
            rotorParam = new String[]{"Rotor Manufacturer", "Rotor Material", "Drum Effective Radius",
                    "Drum OD", "Drum ID", "Drum Thickness", "Drum Rib Thicknes", "Drum Rib Width", "Drum Width",
                    "Working Mass", "Working Area", "RR Drum Denisty", "CC@50", "CC@80", "CC@110", "CVR@50", "CVR@80", "CVR@110"};
            rotorUnit = new String[]{"N/A", "N/A", "mm", "mm", "mm", "mm", "mm", "mm", "mm", "kg", "mm^2", "kg/m^3", "N/A",
                    "N/A", "N/A", "N/A", "N/A", "N/A"};
            rotorKey = new String[]{"rrManu", "rrMat", "efcR", "outD", "inD", "rtThick", "ribThick", "ribWidth", "rtWidth",
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
