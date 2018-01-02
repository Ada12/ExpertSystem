package service;

import com.mathworks.toolbox.javabuilder.*;
//import com.mathworks.toolbox.javabuilder.MWException;
import ExternalMatlab.*;
import org.apache.commons.collections.map.HashedMap;
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

    public static Map<String, Object> realCalculate(Map<String, Map<String, Object>> params, String path) {
        Map<String, Object> applyMap = params.get("apply");
        Map<String, Object> controlMap = params.get("control");
//        Map<String, Object> discCaliperMap = params.get("discCaliper");
//        Map<String, Object> discRotorMap = params.get("discRotor");
        Map<String, Object> discBrakeMap = params.get("discBrake");
//        Map<String, Object> drumCaliperMap = params.get("drumCaliper");
//        Map<String, Object> drumRotorMap = params.get("drumRotor");
        Map<String, Object> drumBrakeMap = params.get("drumBrake");
        Map<String, Object> tireMap = params.get("tire");
        Map<String, Object> vehicleMap = params.get("vehicle");
        Map<String, Object> result = new HashedMap();
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
            MWCellArray booster = new MWCellArray(1, 10);
            booster.set(new int[]{1,1}, Double.parseDouble(String.valueOf(applyMap.get("bstSize"))));
            booster.set(new int[]{1,2}, Double.parseDouble(String.valueOf(applyMap.get("bstGain"))));
            booster.set(new int[]{1,3}, Double.parseDouble(String.valueOf(applyMap.get("bstFTotal"))));
            booster.set(new int[]{1,4}, Double.parseDouble(String.valueOf(applyMap.get("bstFEff"))));
            booster.set(new int[]{1,5}, Double.parseDouble(String.valueOf(applyMap.get("bstTEff"))));
            booster.set(new int[]{1,6}, Double.parseDouble(String.valueOf(applyMap.get("bstFLsNp"))));
            booster.set(new int[]{1,7}, Double.parseDouble(String.valueOf(applyMap.get("bstFLsWp"))));
            booster.set(new int[]{1,8}, Double.parseDouble(String.valueOf(applyMap.get("bstFJmp"))));
            booster.set(new int[]{1,9}, Double.parseDouble(String.valueOf(applyMap.get("bstTLs"))));
            booster.set(new int[]{1,10}, "SABS");
//            booster.set(new int[]{1,1}, 635341253);
//            booster.set(new int[]{1,2}, 635341253);
//            booster.set(new int[]{1,3}, 635341253);
//            booster.set(new int[]{1,4}, 635341253);
//            booster.set(new int[]{1,5}, 635341253);
//            booster.set(new int[]{1,6}, 635341253);
//            booster.set(new int[]{1,7}, 635341253);
//            booster.set(new int[]{1,8}, 635341253);
//            booster.set(new int[]{1,9}, 635341253);
//            booster.set(new int[]{1,10}, 635341253);
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
            absControl.set(new int[]{1,3}, Double.parseDouble(controlMap.get("effAbsFrt").toString()));
            absControl.set(new int[]{1,4}, Double.parseDouble(controlMap.get("effAbsRr").toString()));
            // frt/disc caliper
            // MWNumericArray frtPstArea = new MWNumericArray();
            List<Object> frtPVCurveList = (List<Object>) discBrakeMap.get("pVcurve");
            double[] frtPVCurveArray = new double[frtPVCurveList.size()];
            for(int i = 0; i < frtPVCurveList.size(); i ++) {
                frtPVCurveArray[i] = Double.parseDouble(frtPVCurveList.get(i).toString());
            }
            MWNumericArray frtPVCurve = new MWNumericArray(frtPVCurveArray, MWClassID.DOUBLE);
            // MWNumericArray frtPVK = new MWNumericArray();
            // MWNumericArray frtPVB = new MWNumericArray();
            // MWNumericArray frtPVC = new MWNumericArray();
            // MWNumericArray frtLinMu = new MWNumericArray((List<Double>) discCaliperMap.get("linMu"), MWClassID.DOUBLE);
            List<Object> frtLinMuList = (List<Object>) discBrakeMap.get("linMu");
            double[] frtLinMuArray = new double[frtLinMuList.size()];
            for(int i = 0; i < frtLinMuList.size(); i ++) {
                frtLinMuArray[i] = Double.parseDouble(frtLinMuList.get(i).toString());
            }
            MWNumericArray frtLinMu = new MWNumericArray(frtLinMuArray, MWClassID.DOUBLE);
            MWNumericArray frtBrkFactor = new MWNumericArray();
            // MWNumericArray frtLinMuK = new MWNumericArray();
            // MWNumericArray frtLinMuE = new MWNumericArray();
            List<Object> frtLinTList = (List<Object>) discBrakeMap.get("frtRtTempIn");
            double[] frtLinTArray = new double[frtLinTList.size()];
            for(int i = 0; i < frtLinTList.size(); i ++) {
                frtLinTArray[i] = Double.parseDouble(frtLinTList.get(i).toString());
            }
            MWNumericArray frtLinT = new MWNumericArray(frtLinTArray, MWClassID.DOUBLE);
            List<Object> frtLinCPList = (List<Object>) discBrakeMap.get("frtLinWearOut");
            double[] frtLinCPArray = new double[frtLinCPList.size()];
            for(int i = 0; i < frtLinCPList.size(); i ++) {
                frtLinCPArray[i] = Double.parseDouble(frtLinCPList.get(i).toString());
            }
            MWNumericArray frtLinCP = new MWNumericArray(frtLinCPArray, MWClassID.DOUBLE);
            List<Object> frtLinCP1List = (List<Object>) discBrakeMap.get("frtLinFrictOut");
            double[] frtLinCP1Array = new double[frtLinCP1List.size()];
            for(int i = 0; i < frtLinCP1List.size(); i ++) {
                frtLinCP1Array[i] = Double.parseDouble(frtLinCP1List.get(i).toString());
            }
            MWNumericArray frtLinCP1 = new MWNumericArray(frtLinCP1Array, MWClassID.DOUBLE);
            // Object[] discCaliper = new Object[]{"Conti",51,1,frtPstArea,100,frtPVCurve,
            // frtPVK,frtPVB,frtPVC,"FM","Low Mat(#)","TBD",frtLinMu,frtBrkFactor,frtLinMuK,
            // frtLinMuE,0.4,0.8,3430,11,frtLinT,frtLinCP,frtLinCP1};
            MWCellArray discCaliper = new MWCellArray(new int[]{1,23});
            discCaliper.set(new int[]{1,1}, "Conti"); //
            discCaliper.set(new int[]{1,2}, Double.parseDouble(discBrakeMap.get("pstD").toString()));
            discCaliper.set(new int[]{1,3}, Double.parseDouble(discBrakeMap.get("pstNum").toString()));
            discCaliper.set(new int[]{1,4}, Double.parseDouble(discBrakeMap.get("pstArea").toString()));
            discCaliper.set(new int[]{1,5}, Double.parseDouble(discBrakeMap.get("hfP").toString()));
            discCaliper.set(new int[]{1,6}, frtPVCurve);
            discCaliper.set(new int[]{1,7}, Double.parseDouble(discBrakeMap.get("pvK").toString()));
            discCaliper.set(new int[]{1,8}, Double.parseDouble(discBrakeMap.get("pvB").toString()));
            discCaliper.set(new int[]{1,9}, Double.parseDouble(discBrakeMap.get("pvC").toString()));
            discCaliper.set(new int[]{1,10}, "FM"); //
            discCaliper.set(new int[]{1,11}, discBrakeMap.get("linMat").toString());
            discCaliper.set(new int[]{1,12}, "TBD"); //
            // Double.parseDouble(discCaliperMap.get("linMu").toString())
            discCaliper.set(new int[]{1,13}, frtLinMu);
            discCaliper.set(new int[]{1,14}, frtBrkFactor); //
            discCaliper.set(new int[]{1,15}, Double.parseDouble(discBrakeMap.get("linMuK").toString()));
            discCaliper.set(new int[]{1,16}, Double.parseDouble(discBrakeMap.get("linMuE").toString()));
            discCaliper.set(new int[]{1,17}, Double.parseDouble(discBrakeMap.get("linMuNp").toString()));
            discCaliper.set(new int[]{1,18}, 0.8); //
            discCaliper.set(new int[]{1,19}, Double.parseDouble(discBrakeMap.get("linArea").toString()));
            discCaliper.set(new int[]{1,20}, Double.parseDouble(discBrakeMap.get("linWearLim").toString()));
            discCaliper.set(new int[]{1,21}, frtLinT);
            discCaliper.set(new int[]{1,22}, frtLinCP);
            discCaliper.set(new int[]{1,23}, frtLinCP1);
            // frt/disc rotor
            MWNumericArray frtCC50 = new MWNumericArray();
            MWNumericArray frtCC80 = new MWNumericArray();
            List<Object> frtRtTList = (List<Object>)discBrakeMap.get("rtTempIn");
            double[] frtRtTArray = new double[frtRtTList.size()];
            for(int i = 0; i < frtRtTList.size(); i ++) {
                frtRtTArray[i] = Double.parseDouble(frtRtTList.get(i).toString());
            }
            MWNumericArray frtRtT = new MWNumericArray(frtRtTArray, MWClassID.DOUBLE);
            List<Object> frtRtCPList = (List<Object>)discBrakeMap.get("rtTempIn");
            double[] frtRtCPArray = new double[frtRtCPList.size()];
            for(int i = 0; i < frtRtCPList.size(); i ++) {
                frtRtCPArray[i] = Double.parseDouble(frtRtCPList.get(i).toString());
            }
            MWNumericArray frtRtCP = new MWNumericArray(frtRtCPArray, MWClassID.DOUBLE);
            // Object[] discRotor = new Object[]{"Vented","SHAC",0,102.5,256,146,22,6,6,44,42,9.2,5,
            // frtWorkMass,frtWorkArea,7100,frtCC50,frtCC80,0.026,0.026,frtRtT,frtRtCP};
            // rtCkIn and rtCkOut => double
            MWCellArray discRotor = new MWCellArray(new int[]{1,22});
            discRotor.set(new int[]{1,1}, discBrakeMap.get("rtType").toString());
            discRotor.set(new int[]{1,2}, "SHAC"); //
//            discRotor.set(new int[]{1,3}, discCaliperMap.get("rtType").toString().equals("Drum") ? null :
//                    Double.parseDouble(discRotorMap.get("rtSwpArea").toString())); ////
            discRotor.set(new int[]{1,3},1);
            discRotor.set(new int[]{1,4}, Double.parseDouble(discBrakeMap.get("rtEfcR").toString()));
            discRotor.set(new int[]{1,5}, Double.parseDouble(discBrakeMap.get("rtDiaOut").toString()));
            discRotor.set(new int[]{1,6}, Double.parseDouble(discBrakeMap.get("rtDiaIn").toString()));
            discRotor.set(new int[]{1,7}, Double.parseDouble(discBrakeMap.get("rtT").toString()));
            discRotor.set(new int[]{1,8}, Double.parseDouble(discBrakeMap.get("rtCkIn").toString()));
            discRotor.set(new int[]{1,9}, Double.parseDouble(discBrakeMap.get("rtCkOut").toString()));
            discRotor.set(new int[]{1,10}, Double.parseDouble(discBrakeMap.get("rtVanNum").toString()));
            discRotor.set(new int[]{1,11}, Double.parseDouble(discBrakeMap.get("rtVanLen").toString()));
            discRotor.set(new int[]{1,12}, Double.parseDouble(discBrakeMap.get("rtVaneHigh").toString()));
            discRotor.set(new int[]{1,13}, Double.parseDouble(discBrakeMap.get("rtVanT").toString()));
            discRotor.set(new int[]{1,14}, Double.parseDouble(discBrakeMap.get("rtWm").toString()));
            discRotor.set(new int[]{1,15}, Double.parseDouble(discBrakeMap.get("rtWa").toString()));
            discRotor.set(new int[]{1,16}, Double.parseDouble(discBrakeMap.get("rho").toString()));
            discRotor.set(new int[]{1,17}, Double.parseDouble(discBrakeMap.get("cc50").toString()));
            discRotor.set(new int[]{1,18}, Double.parseDouble(discBrakeMap.get("cc80").toString()));
            discRotor.set(new int[]{1,19}, Double.parseDouble(discBrakeMap.get("cvr50").toString()));
            discRotor.set(new int[]{1,20}, Double.parseDouble(discBrakeMap.get("cvr80").toString()));
            discRotor.set(new int[]{1,21}, frtRtT);
            discRotor.set(new int[]{1,22}, frtRtCP);
            // rr/drum caliper
            MWNumericArray rrPstArea = new MWNumericArray();
            List<Object> rrPVCurveList = (List<Object>)drumBrakeMap.get("pVcurve");
            double[] rrPVCurveArray = new double[rrPVCurveList.size()];
            for(int i = 0; i < rrPVCurveList.size(); i ++) {
                rrPVCurveArray[i] = Double.parseDouble(rrPVCurveList.get(i).toString());
            }
            MWNumericArray rrPVCurve = new MWNumericArray(rrPVCurveArray, MWClassID.DOUBLE);
            MWNumericArray rrPVK = new MWNumericArray();
            MWNumericArray rrPVB = new MWNumericArray();
            MWNumericArray rrPVC = new MWNumericArray();
            // MWNumericArray rrLinMu = new MWNumericArray(new double[]{500, 0.82, 5000, 0.86, 12000, 0.9});
            List<Object> rrLinMuList = (List<Object>) drumBrakeMap.get("linMu");
            double[] rrLinMuArray = new double[rrLinMuList.size()];
            for(int i = 0; i < rrLinMuList.size(); i ++) {
                rrLinMuArray[i] = Double.parseDouble(rrLinMuList.get(i).toString());
            }
            MWNumericArray rrLinMu = new MWNumericArray(rrLinMuArray, MWClassID.DOUBLE);
            MWNumericArray rrBrkFactor = new MWNumericArray();
            MWNumericArray rrLinMuK = new MWNumericArray();
            MWNumericArray rrLinMuE = new MWNumericArray();
            List<Object> rrLinTList = (List<Object>) drumBrakeMap.get("frtRtTempIn");
            double[] rrLinTArray = new double[rrLinTList.size()];
            for(int i = 0; i < rrLinTList.size(); i ++) {
                rrLinTArray[i] = Double.parseDouble(rrLinTList.get(i).toString());
            }
            MWNumericArray rrLinT = new MWNumericArray(rrLinTArray, MWClassID.DOUBLE);
            List<Object> rrLinCPList = (List<Object>) drumBrakeMap.get("frtLinWearOut");
            double[] rrLinCPArray = new double[rrLinCPList.size()];
            for(int i = 0; i < rrLinCPList.size(); i ++) {
                rrLinCPArray[i] = Double.parseDouble(rrLinCPList.get(i).toString());
            }
            MWNumericArray rrLinCP = new MWNumericArray(rrLinCPArray, MWClassID.DOUBLE);
            List<Object> rrLinCP1List = (List<Object>) drumBrakeMap.get("frtLinFrictOut");
            double[] rrLinCP1Array = new double[rrLinCP1List.size()];
            for(int i = 0; i < rrLinCP1List.size(); i ++) {
                rrLinCP1Array[i] = Double.parseDouble(rrLinCP1List.get(i).toString());
            }
            MWNumericArray rrLinCP1 = new MWNumericArray(rrLinCP1Array, MWClassID.DOUBLE);
//            MWNumericArray rrRtT = new MWNumericArray(new double[]{});
//            MWNumericArray rrRtCP = new MWNumericArray(new double[]{});
            // Object[] drumCaliper = new Object[]{"BWI",19.05,1,rrPstArea,400,rrPVCurve,
            // rrPVK,rrPVB,rrPVC,"SB","DO4-A","TBD",rrLinMu,rrBrkFactor,rrLinMuK,
            // rrLinMuE,0.825,1.65,5779,5,rrLinT,rrLinCP,rrLinCP1};
            MWCellArray drumCaliper = new MWCellArray(new int[]{1,23});
            drumCaliper.set(new int[]{1,1}, "BWI"); //
            drumCaliper.set(new int[]{1,2}, Double.parseDouble(drumBrakeMap.get("cDia").toString()));
            drumCaliper.set(new int[]{1,3}, Double.parseDouble(drumBrakeMap.get("pstNum").toString()));
            drumCaliper.set(new int[]{1,4}, Double.parseDouble(drumBrakeMap.get("pstArea").toString()));
            drumCaliper.set(new int[]{1,5}, Double.parseDouble(drumBrakeMap.get("cHp").toString()));
            drumCaliper.set(new int[]{1,6}, rrPVCurve);
            drumCaliper.set(new int[]{1,7}, Double.parseDouble(drumBrakeMap.get("pvK").toString()));
            drumCaliper.set(new int[]{1,8}, Double.parseDouble(drumBrakeMap.get("pvB").toString()));
            drumCaliper.set(new int[]{1,9}, Double.parseDouble(drumBrakeMap.get("pvC").toString()));
            drumCaliper.set(new int[]{1,10}, "SB"); //
            drumCaliper.set(new int[]{1,11}, drumBrakeMap.get("linMat").toString());
            drumCaliper.set(new int[]{1,12}, "TBD"); //
            // Double.parseDouble(drumCaliperMap.get("linMu").toString())
            drumCaliper.set(new int[]{1,13}, rrLinMu);
            drumCaliper.set(new int[]{1,14}, rrBrkFactor); //
            drumCaliper.set(new int[]{1,15}, Double.parseDouble(drumBrakeMap.get("linMuK").toString()));
            drumCaliper.set(new int[]{1,16}, Double.parseDouble(drumBrakeMap.get("linMuE").toString()));
            drumCaliper.set(new int[]{1,17}, Double.parseDouble(drumBrakeMap.get("linMuNp").toString()));
            drumCaliper.set(new int[]{1,18}, 1.65); //
            drumCaliper.set(new int[]{1,19}, Double.parseDouble(drumBrakeMap.get("linArea").toString()));
            drumCaliper.set(new int[]{1,20}, Double.parseDouble(drumBrakeMap.get("linWearLim").toString()));
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
            List<Object> rrRtTList = (List<Object>)drumBrakeMap.get("dmTempIn");
            double[] rrRtTArray = new double[rrRtTList.size()];
            for(int i = 0; i < rrRtTList.size(); i ++) {
                rrRtTArray[i] = Double.parseDouble(rrRtTList.get(i).toString());
            }
            MWNumericArray rrRtT = new MWNumericArray(rrRtTArray);
            List<Object> rrRtCPList = (List<Object>)drumBrakeMap.get("dmTempOut");
            double[] rrRtCPArray = new double[rrRtCPList.size()];
            for(int i = 0; i < rrRtCPList.size(); i ++) {
                rrRtCPArray[i] = Double.parseDouble(rrRtCPList.get(i).toString());
            }
            MWNumericArray rrRtCP = new MWNumericArray(rrRtCPArray);
            // Object[] drumRotor = new Object[]{"Drum","SHAC",21980,102.5,216,100,8,42,
            // 14,14,rrWorkMass,rrWorkArea,7100,rrCC50,rrCC80,rrCVR50,rrCVR80,rrRtT,rrRtCP};
            MWCellArray drumRotor = new MWCellArray(new int[]{1, 19});
            drumRotor.set(new int[]{1,1}, drumBrakeMap.get("rtType").toString());
            drumRotor.set(new int[]{1,2}, "SHAC"); //
//            drumRotor.set(new int[]{1,3}, drumRotorMap.get("rtType").toString().equals("Drum") ? null :
//                    Double.parseDouble(drumRotorMap.get("sweptArea").toString()));
            drumRotor.set(new int[]{1,3}, 1d);
            drumRotor.set(new int[]{1,4}, Double.parseDouble(drumBrakeMap.get("rtEfcR").toString()));
            drumRotor.set(new int[]{1,5}, Double.parseDouble(drumBrakeMap.get("odDm").toString()));
            drumRotor.set(new int[]{1,6}, Double.parseDouble(drumBrakeMap.get("idDm").toString()));
            drumRotor.set(new int[]{1,7}, Double.parseDouble(drumBrakeMap.get("thDm").toString()));
            drumRotor.set(new int[]{1,8}, Double.parseDouble(drumBrakeMap.get("rtVaneHigh").toString()));
            drumRotor.set(new int[]{1,9}, Double.parseDouble(drumBrakeMap.get("wdDm").toString()));
            drumRotor.set(new int[]{1,10}, Double.parseDouble(drumBrakeMap.get("jthDm").toString()));
            drumRotor.set(new int[]{1,11}, Double.parseDouble(drumBrakeMap.get("rtWm").toString()));
            drumRotor.set(new int[]{1,12}, Double.parseDouble(drumBrakeMap.get("rtWa").toString()));
            drumRotor.set(new int[]{1,13}, Double.parseDouble(drumBrakeMap.get("rho").toString()));
            drumRotor.set(new int[]{1,14}, Double.parseDouble(drumBrakeMap.get("cc50").toString()));
            drumRotor.set(new int[]{1,15}, Double.parseDouble(drumBrakeMap.get("cc80").toString()));
            drumRotor.set(new int[]{1,16}, Double.parseDouble(drumBrakeMap.get("cvr50").toString()));//rrCVR50
            drumRotor.set(new int[]{1,17}, Double.parseDouble(drumBrakeMap.get("cvr80").toString()));//rrCVR80
            drumRotor.set(new int[]{1,18}, rrRtT);
            drumRotor.set(new int[]{1,19}, rrRtCP);
            Object[] status;
            ManualCalculate calculate = new ManualCalculate();
            calculate.main(pedal, booster, masterCylinder, tyre, vehicle, absControl,
                    discCaliper, discRotor, drumCaliper, drumRotor);
            String relativePath = System.getenv("CATALINA_HOME");
            System.out.println(relativePath);
            String systemType = System.getProperty("os.name");
            // move result picture
            for (int i = 1; i < 14; i ++) {
                String nowPath = "";
                String afterPath = "";
                if (systemType.contains("Windows")) {
                    nowPath = relativePath + "\\bin\\figure" + i + ".png";
                    afterPath = path + "\\figure" + i + ".png";
                } else {
                    nowPath = relativePath + "/bin/figure" + i + ".png";
                    afterPath = path + "/figure" + i + ".png";
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
                resultNowPath = relativePath + "\\bin\\result.xlsx";
                resultAfterPath = path + "\\result.xlsx";
            } else {
                resultNowPath = relativePath + "/bin/result.xlsx";
                resultAfterPath = path + "/result.xlsx";
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
            // create img pathi
            List<String> abUrl = new ArrayList<String>();
            for (int i = 1; i < 14; i ++) {
                abUrl.add("/expert/img/figure"+ i + ".png");
            }
            result.put("img", abUrl);
            result.put("numerical", getResult(resultAfterPath));
        } catch (MWException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Map<String, Object> getResult(String resultAfterPath) {
        Map<String, Object> result = new HashedMap();
        try {
            File file = new File(resultAfterPath);
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
            result.put("BET_Modal", betModal);
            result.put("Hot_Modal", hotModal);
            result.put("Distance_Modal", distanceModal);
            result.put("Rst_Table", rstModal);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("java.library.path"));
        MWCellArray pedal = new MWCellArray(new int[]{1, 4});
        pedal.set(new int[]{1,1}, 1);
        pedal.set(new int[]{1,2}, 2);
        pedal.set(new int[]{1,3}, 3);
        pedal.set(new int[]{1,4}, "sanli");
        System.out.println(pedal);
    }
}
