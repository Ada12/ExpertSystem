package service;

import com.mathworks.toolbox.javabuilder.*;
//import com.mathworks.toolbox.javabuilder.MWException;
import ExternalMatlab.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.ArrayList;
import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by yangchen on 17/12/17.
 */
public class MatlabManualCalculate {

    public static void realCalculate(Map<String, Map<String, Object>> params) {
        Map<String, Object> applyMap = params.get("apply");
        Map<String, Object> controlMap = params.get("control");
        Map<String, Object> discCaliperMap = params.get("discCaliper");
        Map<String, Object> discRotorMap = params.get("discRotor");
        Map<String, Object> drumCaliperMap = params.get("drumCaliper");
        Map<String, Object> drumRotorMap = params.get("drumRotor");
        Map<String, Object> tireMap = params.get("tire");
        Map<String, Object> vehicleMap = params.get("vehicle");
        try {
            // Pedal param
            // Object[] pedal1 = new Object[]{3,1,1,"sanli"};
            MWCellArray pedal = new MWCellArray(new int[]{1, 4});
            pedal.set(new int[]{1,1}, Double.parseDouble(applyMap.get("pedRatio").toString()));
            pedal.set(new int[]{1,2}, Double.parseDouble(applyMap.get("pedFEff").toString()));
            pedal.set(new int[]{1,3}, Double.parseDouble(applyMap.get("pedTEff").toString()));
            pedal.set(new int[]{1,4}, "sanli");
            // booster param
            // Object[] booster1 = new Object[]{10,6,2360,0.95,0.85,320,80,320,2,"SABS"};
            MWCellArray booster = new MWCellArray(new int[]{1,10});
            booster.set(new int[]{1,1}, Double.parseDouble(applyMap.get("bstSize").toString()));
            booster.set(new int[]{1,2}, Double.parseDouble(applyMap.get("bstGain").toString()));
            booster.set(new int[]{1,3}, Double.parseDouble(applyMap.get("bstFTotal").toString()));
            booster.set(new int[]{1,4}, Double.parseDouble(applyMap.get("bstFEff").toString()));
            booster.set(new int[]{1,5}, Double.parseDouble(applyMap.get("bstTEff").toString()));
            booster.set(new int[]{1,6}, Double.parseDouble(applyMap.get("bstFLsNp").toString()));
            booster.set(new int[]{1,7}, Double.parseDouble(applyMap.get("bstFLsWp").toString()));
            booster.set(new int[]{1,8}, Double.parseDouble(applyMap.get("bstFJmp").toString()));
            booster.set(new int[]{1,9}, Double.parseDouble(applyMap.get("bstTLs").toString()));
            booster.set(new int[]{1,10}, "SABS");
            //  master cylinder
            // Object[] masterCylinder = new Object[]{19.05,1,1,"SABS"};
            MWCellArray masterCylinder = new MWCellArray(new int[]{1,4});
            masterCylinder.set(new int[]{1,1}, Double.parseDouble(applyMap.get("mcdD").toString()));
            masterCylinder.set(new int[]{1,2}, Double.parseDouble(applyMap.get("mcdFEff").toString()));
            masterCylinder.set(new int[]{1,3}, Double.parseDouble(applyMap.get("mcdTEff").toString()));
            masterCylinder.set(new int[]{1,4}, "SABS");
            // tyre
            // Object[] rollResis = new Object[]{};
            MWNumericArray rollResis = new MWNumericArray();
            // MWArray rollResis = new MWArray();
            //Object[] tyre = new Object[]{292,292,292,292,1.07,0.7,0.9,0.1,rollResis};
            MWCellArray tyre = new MWCellArray(new int[]{1,9});
            tyre.set(new int[]{1,1}, Double.parseDouble(tireMap.get("lvwTrFrt").toString()));
            tyre.set(new int[]{1,2}, Double.parseDouble(tireMap.get("lvwTrRr").toString()));
            tyre.set(new int[]{1,3}, Double.parseDouble(tireMap.get("gvwTrFrt").toString()));
            tyre.set(new int[]{1,4}, Double.parseDouble(tireMap.get("gvwTrRr").toString()));
            tyre.set(new int[]{1,5}, Double.parseDouble(tireMap.get("peakAdhesLong").toString()));
            tyre.set(new int[]{1,6}, Double.parseDouble(tireMap.get("peakAdhesLat").toString()));
            tyre.set(new int[]{1,7}, Double.parseDouble(tireMap.get("tracCoeff").toString()));
            tyre.set(new int[]{1,8}, Double.parseDouble(tireMap.get("s").toString()));
            tyre.set(new int[]{1,9}, Double.parseDouble(tireMap.get("fR").toString()));
            // vehicle
            // Object[] vehicle = new Object[]{"SGM318",2015,"F","NB",1250,0.584,565,1490,0.514,565,2499,170,0.05,0.35,2};
            MWCellArray vehicle = new MWCellArray(new int[]{1,15});
            vehicle.set(new int[]{1,1}, vehicleMap.get("carModel").toString());
            vehicle.set(new int[]{1,2}, Double.parseDouble(vehicleMap.get("carYear").toString()));
            vehicle.set(new int[]{1,3}, vehicleMap.get("carDa").toString());
            vehicle.set(new int[]{1,4}, vehicleMap.get("carAddInfo").toString());
            vehicle.set(new int[]{1,5}, Double.parseDouble(vehicleMap.get("lvwM").toString()));
            vehicle.set(new int[]{1,6}, Double.parseDouble(vehicleMap.get("lvwFrtR").toString()));
            vehicle.set(new int[]{1,7}, Double.parseDouble(vehicleMap.get("lvwCgh").toString()));
            vehicle.set(new int[]{1,8}, Double.parseDouble(vehicleMap.get("gvwM").toString()));
            vehicle.set(new int[]{1,9}, Double.parseDouble(vehicleMap.get("gvwFrtR").toString()));
            vehicle.set(new int[]{1,10}, Double.parseDouble(vehicleMap.get("gvwCgh").toString()));
            vehicle.set(new int[]{1,11}, Double.parseDouble(vehicleMap.get("l").toString()));
            vehicle.set(new int[]{1,12}, Double.parseDouble(vehicleMap.get("vmax").toString()));
            vehicle.set(new int[]{1,13}, Double.parseDouble(vehicleMap.get("coastDecel").toString()));
            vehicle.set(new int[]{1,14}, Double.parseDouble(vehicleMap.get("cd").toString()));
            vehicle.set(new int[]{1,15}, Double.parseDouble(vehicleMap.get("a").toString()));
            // ABSControl
            // Object[] absControl = new Object[]{"","",0.93,0.93};
            MWCellArray absControl = new MWCellArray(new int[]{1,4});
            absControl.set(new int[]{1,1}, ":BWI");
            absControl.set(new int[]{1,2}, ":DBC7.8");
            absControl.set(new int[]{1,3}, Double.parseDouble(controlMap.get("peakTire").toString()));
            absControl.set(new int[]{1,4}, Double.parseDouble(controlMap.get("effDrive").toString()));
            // frt/disc caliper
            // MWNumericArray frtPstArea = new MWNumericArray();
            MWNumericArray frtPVCurve = new MWNumericArray((List<Double>) discCaliperMap.get("pVcurve"), MWClassID.DOUBLE);
            // MWNumericArray frtPVK = new MWNumericArray();
            // MWNumericArray frtPVB = new MWNumericArray();
            // MWNumericArray frtPVC = new MWNumericArray();
            MWNumericArray frtLinMu = new MWNumericArray((List<Double>) discCaliperMap.get("linMu"), MWClassID.DOUBLE);
            MWNumericArray frtBrkFactor = new MWNumericArray();
            // MWNumericArray frtLinMuK = new MWNumericArray();
            // MWNumericArray frtLinMuE = new MWNumericArray();
            MWNumericArray frtLinT = new MWNumericArray((List<Double>) discCaliperMap.get("frtRtTempIn"), MWClassID.DOUBLE);
            MWNumericArray frtLinCP = new MWNumericArray((List<Double>) discCaliperMap.get("frtLinWearOut"), MWClassID.DOUBLE);
            MWNumericArray frtLinCP1 = new MWNumericArray((List<Double>) discCaliperMap.get("frtLinFrictOut"), MWClassID.DOUBLE);
            // Object[] discCaliper = new Object[]{"Conti",51,1,frtPstArea,100,frtPVCurve,
            // frtPVK,frtPVB,frtPVC,"FM","Low Mat(#)","TBD",frtLinMu,frtBrkFactor,frtLinMuK,
            // frtLinMuE,0.4,0.8,3430,11,frtLinT,frtLinCP,frtLinCP1};
            MWCellArray discCaliper = new MWCellArray(new int[]{1,23});
            discCaliper.set(new int[]{1,1}, "Conti"); //
            discCaliper.set(new int[]{1,2}, Double.parseDouble(discCaliperMap.get("pstD").toString()));
            discCaliper.set(new int[]{1,3}, Double.parseDouble(discCaliperMap.get("pstNum").toString()));
            discCaliper.set(new int[]{1,4}, Double.parseDouble(discCaliperMap.get("pstArea").toString()));
            discCaliper.set(new int[]{1,5}, Double.parseDouble(discCaliperMap.get("hfP").toString()));
            discCaliper.set(new int[]{1,6}, frtPVCurve);
            discCaliper.set(new int[]{1,7}, Double.parseDouble(discCaliperMap.get("pvK").toString()));
            discCaliper.set(new int[]{1,8}, Double.parseDouble(discCaliperMap.get("pvB").toString()));
            discCaliper.set(new int[]{1,9}, Double.parseDouble(discCaliperMap.get("pvC").toString()));
            discCaliper.set(new int[]{1,10}, "FM"); //
            discCaliper.set(new int[]{1,11}, discCaliperMap.get("linMat").toString());
            discCaliper.set(new int[]{1,12}, "TBD"); //
            discCaliper.set(new int[]{1,13}, frtLinMu);
            discCaliper.set(new int[]{1,14}, frtBrkFactor); //
            discCaliper.set(new int[]{1,15}, Double.parseDouble(discCaliperMap.get("linMuK").toString()));
            discCaliper.set(new int[]{1,16}, Double.parseDouble(discCaliperMap.get("linMuE").toString()));
            discCaliper.set(new int[]{1,17}, Double.parseDouble(discCaliperMap.get("linMuNp").toString()));
            discCaliper.set(new int[]{1,18}, 0.8); //
            discCaliper.set(new int[]{1,19}, Double.parseDouble(discCaliperMap.get("linArea").toString()));
            discCaliper.set(new int[]{1,20}, Double.parseDouble(discCaliperMap.get("linWearLim").toString()));
            discCaliper.set(new int[]{1,21}, frtLinT);
            discCaliper.set(new int[]{1,22}, frtLinCP);
            discCaliper.set(new int[]{1,23}, frtLinCP1);
            // frt/disc rotor
            MWNumericArray frtCC50 = new MWNumericArray();
            MWNumericArray frtCC80 = new MWNumericArray();
            MWNumericArray frtRtT = new MWNumericArray((List<Double>)discRotorMap.get("rtTempIn"), MWClassID.DOUBLE);
            MWNumericArray frtRtCP = new MWNumericArray((List<Double>)discRotorMap.get("rtTempIn"), MWClassID.DOUBLE);
            // Object[] discRotor = new Object[]{"Vented","SHAC",0,102.5,256,146,22,6,6,44,42,9.2,5,
            // frtWorkMass,frtWorkArea,7100,frtCC50,frtCC80,0.026,0.026,frtRtT,frtRtCP};
            // rtCkIn and rtCkOut => double
            MWCellArray discRotor = new MWCellArray(new int[]{1,22});
            discRotor.set(new int[]{1,1}, discCaliperMap.get("rtType").toString());
            discRotor.set(new int[]{1,2}, "SHAC"); //
            discRotor.set(new int[]{1,3}, discCaliperMap.get("rtType").toString().equals("Drum") ? null :
                    Double.parseDouble(discRotorMap.get("rtSwpArea").toString())); ////
            discRotor.set(new int[]{1,4}, Double.parseDouble(discRotorMap.get("rtEfcR").toString()));
            discRotor.set(new int[]{1,5}, Double.parseDouble(discRotorMap.get("rtDiaOut").toString()));
            discRotor.set(new int[]{1,6}, Double.parseDouble(discRotorMap.get("rtDiaIn").toString()));
            discRotor.set(new int[]{1,7}, Double.parseDouble(discRotorMap.get("rtT").toString()));
            discRotor.set(new int[]{1,8}, Double.parseDouble(discRotorMap.get("rtCkIn").toString()));
            discRotor.set(new int[]{1,9}, Double.parseDouble(discRotorMap.get("rtCkOut").toString()));
            discRotor.set(new int[]{1,10}, Double.parseDouble(discRotorMap.get("rtVanNum").toString()));
            discRotor.set(new int[]{1,11}, Double.parseDouble(discRotorMap.get("rtVanLen").toString()));
            discRotor.set(new int[]{1,12}, Double.parseDouble(discRotorMap.get("rtVaneHigh").toString()));
            discRotor.set(new int[]{1,13}, Double.parseDouble(discRotorMap.get("rtVanT").toString()));
            discRotor.set(new int[]{1,14}, Double.parseDouble(discRotorMap.get("rtWm").toString()));
            discRotor.set(new int[]{1,15}, Double.parseDouble(discRotorMap.get("rtWa").toString()));
            discRotor.set(new int[]{1,16}, Double.parseDouble(discRotorMap.get("rho").toString()));
            discRotor.set(new int[]{1,17}, Double.parseDouble(discRotorMap.get("cc50").toString()));
            discRotor.set(new int[]{1,18}, Double.parseDouble(discRotorMap.get("cc80").toString()));
            discRotor.set(new int[]{1,19}, Double.parseDouble(discRotorMap.get("cvr50").toString()));
            discRotor.set(new int[]{1,20}, Double.parseDouble(discRotorMap.get("cvr80").toString()));
            discRotor.set(new int[]{1,21}, frtRtT);
            discRotor.set(new int[]{1,22}, frtRtCP);
            // rr/drum caliper
            MWNumericArray rrPstArea = new MWNumericArray();
            MWNumericArray rrPVCurve = new MWNumericArray((List<Double>)drumCaliperMap.get("pVcurve"), MWClassID.DOUBLE);
            MWNumericArray rrPVK = new MWNumericArray();
            MWNumericArray rrPVB = new MWNumericArray();
            MWNumericArray rrPVC = new MWNumericArray();
            MWNumericArray rrLinMu = new MWNumericArray(new double[]{500, 0.82, 5000, 0.86, 12000, 0.9});
            MWNumericArray rrBrkFactor = new MWNumericArray();
            MWNumericArray rrLinMuK = new MWNumericArray();
            MWNumericArray rrLinMuE = new MWNumericArray();
            MWNumericArray rrLinT = new MWNumericArray((List<Double>) drumCaliperMap.get("frtRtTempIn"), MWClassID.DOUBLE);
            MWNumericArray rrLinCP = new MWNumericArray((List<Double>) drumCaliperMap.get("frtLinWearOut"), MWClassID.DOUBLE);
            MWNumericArray rrLinCP1 = new MWNumericArray((List<Double>) drumCaliperMap.get("frtLinFrictOut"), MWClassID.DOUBLE);
//            MWNumericArray rrRtT = new MWNumericArray(new double[]{});
//            MWNumericArray rrRtCP = new MWNumericArray(new double[]{});
            // Object[] drumCaliper = new Object[]{"BWI",19.05,1,rrPstArea,400,rrPVCurve,
            // rrPVK,rrPVB,rrPVC,"SB","DO4-A","TBD",rrLinMu,rrBrkFactor,rrLinMuK,
            // rrLinMuE,0.825,1.65,5779,5,rrLinT,rrLinCP,rrLinCP1};
            MWCellArray drumCaliper = new MWCellArray(new int[]{1,23});
            drumCaliper.set(new int[]{1,1}, "BWI"); //
            drumCaliper.set(new int[]{1,2}, Double.parseDouble(drumCaliperMap.get("cDia").toString()));
            drumCaliper.set(new int[]{1,3}, Double.parseDouble(drumCaliperMap.get("pstNum").toString()));
            drumCaliper.set(new int[]{1,4}, Double.parseDouble(drumCaliperMap.get("pstArea").toString()));
            drumCaliper.set(new int[]{1,5}, Double.parseDouble(drumCaliperMap.get("cHp").toString()));
            drumCaliper.set(new int[]{1,6}, rrPVCurve);
            drumCaliper.set(new int[]{1,7}, Double.parseDouble(drumCaliperMap.get("pvK").toString()));
            drumCaliper.set(new int[]{1,8}, Double.parseDouble(drumCaliperMap.get("pvB").toString()));
            drumCaliper.set(new int[]{1,9}, Double.parseDouble(drumCaliperMap.get("pvC").toString()));
            drumCaliper.set(new int[]{1,10}, "SB"); //
            drumCaliper.set(new int[]{1,11}, drumCaliperMap.get("linMat").toString());
            drumCaliper.set(new int[]{1,12}, "TBD"); //
            drumCaliper.set(new int[]{1,13}, Double.parseDouble(drumCaliperMap.get("linMu").toString()));
            drumCaliper.set(new int[]{1,14}, rrBrkFactor); //
            drumCaliper.set(new int[]{1,15}, Double.parseDouble(drumCaliperMap.get("linMuK").toString()));
            drumCaliper.set(new int[]{1,16}, Double.parseDouble(drumCaliperMap.get("linMuE").toString()));
            drumCaliper.set(new int[]{1,17}, Double.parseDouble(drumCaliperMap.get("linMuNp").toString()));
            drumCaliper.set(new int[]{1,18}, 1.65); //
            drumCaliper.set(new int[]{1,19}, Double.parseDouble(drumCaliperMap.get("linArea").toString()));
            drumCaliper.set(new int[]{1,20}, Double.parseDouble(drumCaliperMap.get("linWearLim").toString()));
            drumCaliper.set(new int[]{1,21}, rrLinT);
            drumCaliper.set(new int[]{1,22}, rrLinCP);
            drumCaliper.set(new int[]{1,23}, rrLinCP1);
            // rr/drum rotor
            MWNumericArray rrWorkMass = new MWNumericArray();
            MWNumericArray rrWorkArea = new MWNumericArray();
            MWNumericArray rrCC50 = new MWNumericArray();
            MWNumericArray rrCC80 = new MWNumericArray();
            MWNumericArray rrCVR50 = new MWNumericArray();
            MWNumericArray rrCVR80 = new MWNumericArray();
            MWNumericArray rrRtT = new MWNumericArray((List<Double>)drumRotorMap.get("dmTempIn"));
            MWNumericArray rrRtCP = new MWNumericArray((List<Double>)drumRotorMap.get("dmTempOut"));
            // Object[] drumRotor = new Object[]{"Drum","SHAC",21980,102.5,216,100,8,42,
            // 14,14,rrWorkMass,rrWorkArea,7100,rrCC50,rrCC80,rrCVR50,rrCVR80,rrRtT,rrRtCP};
            MWCellArray drumRotor = new MWCellArray(new int[]{1, 19});
            drumRotor.set(new int[]{1,1}, drumCaliperMap.get("rtType").toString());
            drumRotor.set(new int[]{1,2}, "SHAC"); //
            drumRotor.set(new int[]{1,3}, drumRotorMap.get("rtType").toString().equals("Drum") ? null :
                    Double.parseDouble(drumRotorMap.get("sweptArea").toString()));
            drumRotor.set(new int[]{1,4}, Double.parseDouble(drumRotorMap.get("rtEfcR").toString()));
            drumRotor.set(new int[]{1,5}, Double.parseDouble(drumRotorMap.get("odDm").toString()));
            drumRotor.set(new int[]{1,6}, Double.parseDouble(drumRotorMap.get("idDm").toString()));
            drumRotor.set(new int[]{1,7}, Double.parseDouble(drumRotorMap.get("thDm").toString()));
            drumRotor.set(new int[]{1,8}, Double.parseDouble(drumRotorMap.get("rtVaneHigh").toString()));
            drumRotor.set(new int[]{1,9}, Double.parseDouble(drumRotorMap.get("wdDm").toString()));
            drumRotor.set(new int[]{1,10}, Double.parseDouble(drumRotorMap.get("jthDm").toString()));
            drumRotor.set(new int[]{1,11}, Double.parseDouble(drumRotorMap.get("rtWm").toString()));
            drumRotor.set(new int[]{1,12}, Double.parseDouble(drumRotorMap.get("rtWa").toString()));
            drumRotor.set(new int[]{1,13}, Double.parseDouble(drumRotorMap.get("rho").toString()));
            drumRotor.set(new int[]{1,14}, Double.parseDouble(drumRotorMap.get("cc50").toString()));
            drumRotor.set(new int[]{1,15}, Double.parseDouble(drumRotorMap.get("cc80").toString()));
            drumRotor.set(new int[]{1,16}, Double.parseDouble(drumRotorMap.get("cvr50").toString()));//rrCVR50
            drumRotor.set(new int[]{1,17}, Double.parseDouble(drumRotorMap.get("cvr80").toString()));//rrCVR80
            drumRotor.set(new int[]{1,18}, rrRtT);
            drumRotor.set(new int[]{1,19}, rrRtCP);
            Object[] status;
            ManualCalculate calculate = new ManualCalculate();
            calculate.main(pedal, booster, masterCylinder, tyre, vehicle, absControl,
                    discCaliper, discRotor, drumCaliper, drumRotor);
            Object[] results;
//            results = calculate.CalcOutputIndex_v2(0);
//            calculate.generic_main_file(0);
            String relativePath = System.getProperty("user.dir");
            System.out.println(relativePath);
            String systemType = System.getProperty("os.name");
            // move result picture
            for (int i = 1; i < 14; i ++) {
                String nowPath = "";
                String afterPath = "";
                if (systemType.contains("Windows")) {
                    nowPath = relativePath + "\\figure" + i + ".png";
                    afterPath = relativePath + "\\web\\img\\figure" + i + ".png";
                } else {
                    nowPath = relativePath + "/figure" + i + ".png";
                    afterPath = relativePath + "/web/img/figure" + i + ".png";
                }
                File nowFile = new File(nowPath);
                if (nowFile.exists()) {
                    File afterFile = new File(afterPath);
                    if (afterFile.exists()) {
                        afterFile.delete();
                    }
                    nowFile.renameTo(afterFile);
                }
                File deleteFile = new File(nowPath);
                deleteFile.delete();
            }
            // move result excel
            String resultNowPath = "";
            String resultAfterPath = "";
            if (systemType.contains("Windows")) {
                resultNowPath = relativePath + "\\result.xlsx";
                resultAfterPath = relativePath + "\\web\\img\\result.xlsx";
            } else {
                resultNowPath = relativePath + "/result.xlsx";
                resultAfterPath = relativePath + "/web/img/result.xlsx";
            }
            File resultNowFile = new File(resultNowPath);
            if (resultNowFile.exists()) {
                File resultAfterFile = new File(resultAfterPath);
                if (resultAfterFile.exists()) {
                    resultAfterFile.delete();
                }
                resultNowFile.renameTo(resultAfterFile);
            }
            File resultDeleteFile = new File(resultNowPath);
            resultDeleteFile.delete();
        } catch (MWException e) {
            e.printStackTrace();
        }
    }

    public void main1(String[] args) {
        try {
            String relativePath = System.getProperty("user.dir");
            System.out.println(relativePath);
            String systemType = System.getProperty("os.name");
            String fullPath = "";
            if (systemType.contains("Windows")) {
                fullPath = relativePath + "\\web\\img\\result.xlsx";
            } else {
                fullPath = relativePath + "/web/img/result.xlsx";
            }
            System.out.println(fullPath);
            File file = new File(fullPath);
            FileInputStream fis = new FileInputStream(file);
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            // BET modal
            XSSFSheet shBET = wb.getSheet("BET_modal");
            List<List<Object>> betModal = new ArrayList<List<Object>>();
            for (int i = 0; i < 6; i ++) {
                List<Object> line = new ArrayList<Object>();
                line.add(shBET.getRow(i).getCell(0).getStringCellValue());
                try {
                    line.add(shBET.getRow(i).getCell(1).getRawValue());
                } catch (NullPointerException e) {
                    line.add("NaN");
                }
                line.add(shBET.getRow(i).getCell(2).getStringCellValue());
                betModal.add(line);
            }
            System.out.println(betModal.toString());
            // hot modal
            XSSFSheet shHot = wb.getSheet("hot_modal");
            List<List<Object>> hotModal = new ArrayList<List<Object>>();
            for (int i = 0; i < 4; i ++) {
                List<Object> line = new ArrayList<Object>();
                line.add(shHot.getRow(i).getCell(0).getStringCellValue());
                try {
                    line.add(shHot.getRow(i).getCell(1).getRawValue());
                } catch (NullPointerException e) {
                    line.add("NaN");
                }
                line.add(shHot.getRow(i).getCell(2).getStringCellValue());
                hotModal.add(line);
            }
            System.out.println(hotModal.toString());
            // distance modal
            XSSFSheet shDistance = wb.getSheet("distance_modal");
            List<List<Object>> distanceModal = new ArrayList<List<Object>>();
            for (int i = 0; i < 12; i ++) {
                List<Object> line = new ArrayList<Object>();
                line.add(shDistance.getRow(i).getCell(0).getStringCellValue());
                try {
                    line.add(shDistance.getRow(i).getCell(1).getRawValue());
                } catch (NullPointerException e) {
                    line.add("NaN");
                }
                line.add(shDistance.getRow(i).getCell(2).getStringCellValue());
                distanceModal.add(line);
            }
            System.out.println(distanceModal.toString());
            // rst table
            // distance modal
            XSSFSheet shRst = wb.getSheet("Sheet1");
            List<List<Object>> rstModal = new ArrayList<List<Object>>();
            for (int i = 1; i < 26; i ++) {
                List<Object> line = new ArrayList<Object>();
                try {
                    line.add(shRst.getRow(i).getCell(1).getStringCellValue());
                } catch (NullPointerException e) {
                    line.add("NaN");
                }
                try {
                    line.add(shRst.getRow(i).getCell(2).getRawValue());
                } catch (NullPointerException e) {
                    line.add("NaN");
                }
                try {
                    line.add(shRst.getRow(i).getCell(3).getStringCellValue());
                } catch (NullPointerException e) {
                    line.add("NaN");
                }
                rstModal.add(line);
            }
            System.out.println(rstModal.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void main(String[] args) {
//        Object a = {};
//        MWNumericArray frtRtT = new MWNumericArray(new double[]{1,2,3,4}, MWClassID.DOUBLE);
//        System.out.println(frtRtT);
    }
}
