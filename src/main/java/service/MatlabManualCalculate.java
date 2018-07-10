package service;

import com.mathworks.toolbox.javabuilder.*;
//import com.mathworks.toolbox.javabuilder.MWException;
import ExternalMatlab.*;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.commons.collections.ArrayStack;
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

    public static Map<String, Object> realCalculate(Map<String, Map<String, Object>> params, String path, int geneFlag, String timeStamp) {
        Map<String, Object> applyMap = params.get("apply");
        Map<String, Object> controlMap = params.get("control");
        Map<String, Object> discBrakeMap = params.get("discBrake");
        Map<String, Object> drumBrakeMap = params.get("drumBrake");
        Map<String, Object> tireMap = params.get("tire");
        Map<String, Object> vehicleMap = params.get("vehicle");
        Map<String, Object> requireMap = params.get("requirement");
        Map<String, Object> parkingMap = params.get("parking");
        Map<String, Object> result = new HashedMap();
        boolean flag;
        String message = "";
        try {
            // Pedal param
            // Object[] pedal1 = new Object[]{3,1,1,"sanli"};
            MWCellArray pedal = new MWCellArray(new int[]{1, 4});
            pedal.set(new int[]{1,1}, getDoubleValue(applyMap.get("pedRatio")));
            pedal.set(new int[]{1,2}, getDoubleValue(applyMap.get("pedFEff")));
            pedal.set(new int[]{1,3}, getDoubleValue(applyMap.get("pedTEff")));
            pedal.set(new int[]{1,4}, String.valueOf(applyMap.get("pedSpl")));
            // booster param
            // Object[] booster1 = new Object[]{10,6,2360,0.95,0.85,320,80,320,2,"SABS"};
            MWCellArray booster = new MWCellArray(1, 10);
            booster.set(new int[]{1,1}, getDoubleValue(applyMap.get("bstSize")));
            booster.set(new int[]{1,2}, getDoubleValue(applyMap.get("bstGain")));
            booster.set(new int[]{1,3}, getDoubleValue(applyMap.get("bstFTotal")));
            booster.set(new int[]{1,4}, getDoubleValue(applyMap.get("bstFEff")));
            booster.set(new int[]{1,5}, getDoubleValue(applyMap.get("bstTEff")));
            booster.set(new int[]{1,6}, getDoubleValue(applyMap.get("bstFLsNp")));
            booster.set(new int[]{1,7}, getDoubleValue(applyMap.get("bstFLsWp")));
            booster.set(new int[]{1,8}, getDoubleValue(applyMap.get("bstFJmp")));
            booster.set(new int[]{1,9}, getDoubleValue(applyMap.get("bstTLs")));
            booster.set(new int[]{1,10}, String.valueOf(applyMap.get("bstSpl")));
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
            masterCylinder.set(new int[]{1,1}, getDoubleValue(applyMap.get("mcdD")));
            masterCylinder.set(new int[]{1,2}, getDoubleValue(applyMap.get("mcdFEff")));
            masterCylinder.set(new int[]{1,3}, getDoubleValue(applyMap.get("mcdTEff")));
            masterCylinder.set(new int[]{1,4}, String.valueOf(applyMap.get("mcdSpl")));
            // tyre
            // Object[] rollResis = new Object[]{};
            MWNumericArray rollResis = new MWNumericArray();
            // MWArray rollResis = new MWArray();
            //Object[] tyre = new Object[]{292,292,292,292,1.07,0.7,0.9,0.1,rollResis};
            MWCellArray tyre = new MWCellArray(new int[]{1,9});
            tyre.set(new int[]{1,1}, getDoubleValue(tireMap.get("lvwTrFrt")));
            tyre.set(new int[]{1,2}, getDoubleValue(tireMap.get("lvwTrRr")));
            tyre.set(new int[]{1,3}, getDoubleValue(tireMap.get("gvwTrFrt")));
            tyre.set(new int[]{1,4}, getDoubleValue(tireMap.get("gvwTrRr")));
            tyre.set(new int[]{1,5}, getDoubleValue(tireMap.get("peakAdhesLong")));
            tyre.set(new int[]{1,6}, getDoubleValue(tireMap.get("peakAdhesLat")));
            tyre.set(new int[]{1,7}, getDoubleValue(tireMap.get("tracCoeff")));
            tyre.set(new int[]{1,8}, getDoubleValue(tireMap.get("s")));
            tyre.set(new int[]{1,9}, getDoubleValue(tireMap.get("fR")));
            // vehicle
            // Object[] vehicle = new Object[]{"SGM318",2015,"F","NB",1250,0.584,565,1490,0.514,565,2499,170,0.05,0.35,2};
            MWCellArray vehicle = new MWCellArray(new int[]{1,15});
            vehicle.set(new int[]{1,1}, getStringValue(vehicleMap.get("carModel")));
            vehicle.set(new int[]{1,2}, getDoubleValue(vehicleMap.get("carYear")));
            vehicle.set(new int[]{1,3}, getStringValue(vehicleMap.get("carDa")));
            vehicle.set(new int[]{1,4}, getStringValue(vehicleMap.get("carAddInfo")));
            vehicle.set(new int[]{1,5}, getDoubleValue(vehicleMap.get("lvwM")));
            vehicle.set(new int[]{1,6}, getDoubleValue(vehicleMap.get("lvwFrtR")));
            vehicle.set(new int[]{1,7}, getDoubleValue(vehicleMap.get("lvwCgh")));
            vehicle.set(new int[]{1,8}, getDoubleValue(vehicleMap.get("gvwM")));
            vehicle.set(new int[]{1,9}, getDoubleValue(vehicleMap.get("gvwFrtR")));
            vehicle.set(new int[]{1,10}, getDoubleValue(vehicleMap.get("gvwCgh")));
            vehicle.set(new int[]{1,11}, getDoubleValue(vehicleMap.get("l")));
            vehicle.set(new int[]{1,12}, getDoubleValue(vehicleMap.get("vmax")));
            vehicle.set(new int[]{1,13}, getDoubleValue(vehicleMap.get("coastDecel")));
            vehicle.set(new int[]{1,14}, getDoubleValue(vehicleMap.get("cd")));
            vehicle.set(new int[]{1,15}, getDoubleValue(vehicleMap.get("a")));
            // ABSControl
            // Object[] absControl = new Object[]{"","",0.93,0.93};
            MWCellArray absControl = new MWCellArray(new int[]{1,4});
            absControl.set(new int[]{1,1}, String.valueOf(controlMap.get("absSpl")));
            absControl.set(new int[]{1,2}, String.valueOf(controlMap.get("absType")));
            absControl.set(new int[]{1,3}, getDoubleValue(controlMap.get("effAbsFrt")));
            absControl.set(new int[]{1,4}, getDoubleValue(controlMap.get("effAbsRr")));
            // frt/disc caliper
            // MWNumericArray frtPstArea = new MWNumericArray();
//            List<Object> frtPVCurveList = (List<Object>) discBrakeMap.get("pVcurve");
//            double[] frtPVCurveArray = new double[frtPVCurveList.size()];
//            for(int i = 0; i < frtPVCurveList.size(); i ++) {
//                frtPVCurveArray[i] = getDoubleValue(frtPVCurveList.get(i).toString());
//            }
//            MWNumericArray frtPVCurve = new MWNumericArray(frtPVCurveArray, MWClassID.DOUBLE);
            // frt PVcure
            List<Object> frtPVCurveList = (List<Object>) discBrakeMap.get("pVcurve");
            double[] frtPVCurveArray = new double[frtPVCurveList.size() * 2];
            frtPVCurveArray[0] = 500d;
            frtPVCurveArray[2] = 5000d;
            frtPVCurveArray[4] = 12000d;
            for(int i = 0; i < frtPVCurveList.size(); i ++) {
                frtPVCurveArray[i * 2 + 1] = getDoubleValue(frtPVCurveList.get(i));
            }
            MWNumericArray frtPVCurve = new MWNumericArray(frtPVCurveArray, MWClassID.DOUBLE);
            // MWNumericArray frtLinMu = new MWNumericArray((List<Double>) discCaliperMap.get("linMu"), MWClassID.DOUBLE);
            List<Object> frtLinMuList = (List<Object>) discBrakeMap.get("linMu");
            double[] frtLinMuArray = new double[frtLinMuList.size() * 2];
            frtLinMuArray[0] = 500d;
            frtLinMuArray[2] = 5000d;
            frtLinMuArray[4] = 12000d;
            for(int i = 0; i < frtLinMuList.size(); i ++) {
                frtLinMuArray[i * 2 + 1] = getDoubleValue(frtLinMuList.get(i));
            }
            MWNumericArray frtLinMu = new MWNumericArray(frtLinMuArray, MWClassID.DOUBLE);
            MWNumericArray frtBrkFactor = new MWNumericArray();
            // MWNumericArray frtLinMuK = new MWNumericArray();
            // MWNumericArray frtLinMuE = new MWNumericArray();
            List<Object> frtLinTList = (List<Object>) discBrakeMap.get("frtRtTempIn");
            double[] frtLinTArray = new double[frtLinTList.size()];
            for(int i = 0; i < frtLinTList.size(); i ++) {
                frtLinTArray[i] = getDoubleValue(frtLinTList.get(i));
            }
            MWNumericArray frtLinT = new MWNumericArray(frtLinTArray, MWClassID.DOUBLE);
            List<Object> frtLinCPList = (List<Object>) discBrakeMap.get("frtLinWearOut");
            double[] frtLinCPArray = new double[frtLinCPList.size()];
            for(int i = 0; i < frtLinCPList.size(); i ++) {
                frtLinCPArray[i] = getDoubleValue(frtLinCPList.get(i));
            }
            MWNumericArray frtLinCP = new MWNumericArray(frtLinCPArray, MWClassID.DOUBLE);
            List<Object> frtLinCP1List = (List<Object>) discBrakeMap.get("frtLinFrictOut");
            double[] frtLinCP1Array = new double[frtLinCP1List.size()];
            for(int i = 0; i < frtLinCP1List.size(); i ++) {
                frtLinCP1Array[i] = getDoubleValue(frtLinCP1List.get(i));
            }
            MWNumericArray frtLinCP1 = new MWNumericArray(frtLinCP1Array, MWClassID.DOUBLE);
            // Object[] discCaliper = new Object[]{"Conti",51,1,frtPstArea,100,frtPVCurve,
            // frtPVK,frtPVB,frtPVC,"FM","Low Mat(#)","TBD",frtLinMu,frtBrkFactor,frtLinMuK,
            // frtLinMuE,0.4,0.8,3430,11,frtLinT,frtLinCP,frtLinCP1};
            MWCellArray discCaliper = new MWCellArray(new int[]{1,19});
            discCaliper.set(new int[]{1,1}, String.valueOf(discBrakeMap.get("frtManu")));
            discCaliper.set(new int[]{1,2}, getDoubleValue(discBrakeMap.get("pstD")));
            discCaliper.set(new int[]{1,3}, getDoubleValue(discBrakeMap.get("pstNum")));
            discCaliper.set(new int[]{1,4}, getDoubleValue(discBrakeMap.get("pstArea")));
            discCaliper.set(new int[]{1,5}, getDoubleValue(discBrakeMap.get("hfPT")));
            discCaliper.set(new int[]{1,6}, getDoubleValue(discBrakeMap.get("hfPV")));
            discCaliper.set(new int[]{1,7}, frtPVCurve);
            discCaliper.set(new int[]{1,8}, getDoubleValue(discBrakeMap.get("pvK")));
            discCaliper.set(new int[]{1,9}, getDoubleValue(discBrakeMap.get("pvB")));
            discCaliper.set(new int[]{1,10}, getDoubleValue(discBrakeMap.get("pvC")));
            discCaliper.set(new int[]{1,11}, getStringValue(discBrakeMap.get("linSpl"))); //
            discCaliper.set(new int[]{1,12}, getStringValue(discBrakeMap.get("linMat")));
            // Double.parseDouble(discCaliperMap.get("linMu").toString())
            discCaliper.set(new int[]{1,13}, frtLinMu);
            // discCaliper.set(new int[]{1,14}, frtBrkFactor); //
            // discCaliper.set(new int[]{1,15}, getDoubleValue(discBrakeMap.get("linMuK").toString()));
            // discCaliper.set(new int[]{1,16}, getDoubleValue(discBrakeMap.get("linMuE").toString()));
            discCaliper.set(new int[]{1,14}, getDoubleValue(discBrakeMap.get("linMuNp")));
            // discCaliper.set(new int[]{1,18}, 0.8); // deleted
            discCaliper.set(new int[]{1,15}, getDoubleValue(discBrakeMap.get("linArea")));
            discCaliper.set(new int[]{1,16}, getDoubleValue(discBrakeMap.get("linWearLim")));
            discCaliper.set(new int[]{1,17}, frtLinT);
            discCaliper.set(new int[]{1,18}, frtLinCP);
            discCaliper.set(new int[]{1,19}, frtLinCP1);
            // frt/disc rotor
            MWNumericArray frtCC50 = new MWNumericArray();
            MWNumericArray frtCC80 = new MWNumericArray();
            List<Object> frtRtTList = (List<Object>)discBrakeMap.get("rtTempIn");
            double[] frtRtTArray = new double[frtRtTList.size()];
            for(int i = 0; i < frtRtTList.size(); i ++) {
                frtRtTArray[i] = getDoubleValue(frtRtTList.get(i));
            }
            MWNumericArray frtRtT = new MWNumericArray(frtRtTArray, MWClassID.DOUBLE);
            List<Object> frtRtCPList = (List<Object>)discBrakeMap.get("rtSpecOut");
            double[] frtRtCPArray = new double[frtRtCPList.size()];
            for(int i = 0; i < frtRtCPList.size(); i ++) {
                frtRtCPArray[i] = getDoubleValue(frtRtCPList.get(i));
            }
            MWNumericArray frtRtCP = new MWNumericArray(frtRtCPArray, MWClassID.DOUBLE);
            // Object[] discRotor = new Object[]{"Vented","SHAC",0,102.5,256,146,22,6,6,44,42,9.2,5,
            // frtWorkMass,frtWorkArea,7100,frtCC50,frtCC80,0.026,0.026,frtRtT,frtRtCP};
            // rtCkIn and rtCkOut => double
            MWCellArray discRotor = new MWCellArray(new int[]{1,23});
            discRotor.set(new int[]{1,1}, getStringValue(discBrakeMap.get("rtType")));
            discRotor.set(new int[]{1,2}, getStringValue(discBrakeMap.get("rrManu"))); //
            // discRotor.set(new int[]{1,3}, 21980d); // swp_area
            discRotor.set(new int[]{1,3}, getDoubleValue(discBrakeMap.get("efcR")));
            discRotor.set(new int[]{1,4}, getDoubleValue(discBrakeMap.get("outD")));
            discRotor.set(new int[]{1,5}, getDoubleValue(discBrakeMap.get("inD")));
            discRotor.set(new int[]{1,6}, getDoubleValue(discBrakeMap.get("rtT")));
            discRotor.set(new int[]{1,7}, getDoubleValue(discBrakeMap.get("ckTIn")));
            discRotor.set(new int[]{1,8}, getDoubleValue(discBrakeMap.get("ckTOut")));
            discRotor.set(new int[]{1,9}, getDoubleValue(discBrakeMap.get("vaneNum")));
            discRotor.set(new int[]{1,10}, getDoubleValue(discBrakeMap.get("vaneLen")));
            discRotor.set(new int[]{1,11}, getDoubleValue(discBrakeMap.get("vaneHigh")));
            discRotor.set(new int[]{1,12}, getDoubleValue(discBrakeMap.get("vanT")));
            discRotor.set(new int[]{1,13}, getDoubleValue(discBrakeMap.get("wm")));
            discRotor.set(new int[]{1,14}, getDoubleValue(discBrakeMap.get("wa")));
            discRotor.set(new int[]{1,15}, getDoubleValue(discBrakeMap.get("rho")));
            discRotor.set(new int[]{1,16}, getDoubleValue(discBrakeMap.get("cc50")));
            discRotor.set(new int[]{1,17}, getDoubleValue(discBrakeMap.get("cc80")));
            discRotor.set(new int[]{1,18}, getDoubleValue(discBrakeMap.get("cc110")));
            discRotor.set(new int[]{1,19}, getDoubleValue(discBrakeMap.get("cvr50")));
            discRotor.set(new int[]{1,20}, getDoubleValue(discBrakeMap.get("cvr80")));
            discRotor.set(new int[]{1,21}, getDoubleValue(discBrakeMap.get("cvr80")));
            discRotor.set(new int[]{1,22}, frtRtT);
            discRotor.set(new int[]{1,23}, frtRtCP);
            // rr/drum caliper
            List<Object> rrPVCurveList = (List<Object>)drumBrakeMap.get("pVcurve");
            double[] rrPVCurveArray = new double[rrPVCurveList.size() * 2];
            rrPVCurveArray[0] = 500d;
            rrPVCurveArray[2] = 5000d;
            rrPVCurveArray[4] = 12000d;
            for(int i = 0; i < rrPVCurveList.size(); i ++) {
                rrPVCurveArray[i * 2 + 1] = getDoubleValue(rrPVCurveList.get(i));
            }
            MWNumericArray rrPVCurve = new MWNumericArray(rrPVCurveArray, MWClassID.DOUBLE);
            // MWNumericArray rrLinMu = new MWNumericArray(new double[]{500, 0.82, 5000, 0.86, 12000, 0.9});
            List<Object> rrLinMuList = (List<Object>) drumBrakeMap.get("linMu");
            double[] rrLinMuArray = new double[rrLinMuList.size() * 2];
            rrLinMuArray[0] = 500d;
            rrLinMuArray[2] = 5000d;
            rrLinMuArray[4] = 12000d;
            for(int i = 0; i < rrLinMuList.size(); i ++) {
                rrLinMuArray[i * 2 + 1] = getDoubleValue(rrLinMuList.get(i));
            }
            MWNumericArray rrLinMu = new MWNumericArray(rrLinMuArray, MWClassID.DOUBLE);
            MWNumericArray rrBrkFactor = new MWNumericArray();
            MWNumericArray rrLinMuK = new MWNumericArray();
            MWNumericArray rrLinMuE = new MWNumericArray();
            List<Object> rrLinTList = (List<Object>) drumBrakeMap.get("frtRtTempIn");
            double[] rrLinTArray = new double[rrLinTList.size()];
            for(int i = 0; i < rrLinTList.size(); i ++) {
                rrLinTArray[i] = getDoubleValue(rrLinTList.get(i));
            }
            MWNumericArray rrLinT = new MWNumericArray(rrLinTArray, MWClassID.DOUBLE);
            List<Object> rrLinCPList = (List<Object>) drumBrakeMap.get("frtLinWearOut");
            double[] rrLinCPArray = new double[rrLinCPList.size()];
            for(int i = 0; i < rrLinCPList.size(); i ++) {
                rrLinCPArray[i] = getDoubleValue(rrLinCPList.get(i));
            }
            MWNumericArray rrLinCP = new MWNumericArray(rrLinCPArray, MWClassID.DOUBLE);
            List<Object> rrLinCP1List = (List<Object>) drumBrakeMap.get("frtLinFrictOut");
            double[] rrLinCP1Array = new double[rrLinCP1List.size()];
            for(int i = 0; i < rrLinCP1List.size(); i ++) {
                rrLinCP1Array[i] = getDoubleValue(rrLinCP1List.get(i));
            }
            MWNumericArray rrLinCP1 = new MWNumericArray(rrLinCP1Array, MWClassID.DOUBLE);
//            MWNumericArray rrRtT = new MWNumericArray(new double[]{});
//            MWNumericArray rrRtCP = new MWNumericArray(new double[]{});
            // Object[] drumCaliper = new Object[]{"BWI",19.05,1,rrPstArea,400,rrPVCurve,
            // rrPVK,rrPVB,rrPVC,"SB","DO4-A","TBD",rrLinMu,rrBrkFactor,rrLinMuK,
            // rrLinMuE,0.825,1.65,5779,5,rrLinT,rrLinCP,rrLinCP1};
            MWCellArray drumCaliper = new MWCellArray(new int[]{1,19});
            drumCaliper.set(new int[]{1,1}, String.valueOf(drumBrakeMap.get("frtManu"))); //
            drumCaliper.set(new int[]{1,2}, getDoubleValue(drumBrakeMap.get("pstD")));
            drumCaliper.set(new int[]{1,3}, getDoubleValue(drumBrakeMap.get("pstNum")));
            drumCaliper.set(new int[]{1,4}, getDoubleValue(drumBrakeMap.get("pstArea")));
            drumCaliper.set(new int[]{1,5}, getDoubleValue(drumBrakeMap.get("hfPT")));
            drumCaliper.set(new int[]{1,6}, getDoubleValue(drumBrakeMap.get("hfPV")));
            drumCaliper.set(new int[]{1,7}, rrPVCurve);
            drumCaliper.set(new int[]{1,8}, getDoubleValue(drumBrakeMap.get("pvK")));
            drumCaliper.set(new int[]{1,9}, getDoubleValue(drumBrakeMap.get("pvB")));
            drumCaliper.set(new int[]{1,10}, getDoubleValue(drumBrakeMap.get("pvC")));
            drumCaliper.set(new int[]{1,11}, getStringValue(drumBrakeMap.get("linSpl"))); //
            drumCaliper.set(new int[]{1,12}, getStringValue(drumBrakeMap.get("linMat")));
            // drumCaliper.set(new int[]{1,12}, drumBrakeMap.get("insulator").toString()); // insulator
            drumCaliper.set(new int[]{1,13}, rrLinMu);
            // drumCaliper.set(new int[]{1,14}, rrBrkFactor); //
            // drumCaliper.set(new int[]{1,15}, getDoubleValue(drumBrakeMap.get("linMuK").toString()));
            // drumCaliper.set(new int[]{1,16}, getDoubleValue(drumBrakeMap.get("linMuE").toString()));
            drumCaliper.set(new int[]{1,14}, getDoubleValue(drumBrakeMap.get("linMuNp")));
            // drumCaliper.set(new int[]{1,18}, 1.65); // deleted: brkFactorNP
            drumCaliper.set(new int[]{1,15}, getDoubleValue(drumBrakeMap.get("linArea")));
            drumCaliper.set(new int[]{1,16}, getDoubleValue(drumBrakeMap.get("linWearLim")));
            drumCaliper.set(new int[]{1,17}, rrLinT);
            drumCaliper.set(new int[]{1,18}, rrLinCP);
            drumCaliper.set(new int[]{1,19}, rrLinCP1);
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
                rrRtTArray[i] = getDoubleValue(rrRtTList.get(i));
            }
            MWNumericArray rrRtT = new MWNumericArray(rrRtTArray);
            List<Object> rrRtCPList = (List<Object>)drumBrakeMap.get("dmTempOut");
            double[] rrRtCPArray = new double[rrRtCPList.size()];
            for(int i = 0; i < rrRtCPList.size(); i ++) {
                rrRtCPArray[i] = getDoubleValue(rrRtCPList.get(i));
            }
            MWNumericArray rrRtCP = new MWNumericArray(rrRtCPArray);
            // Object[] drumRotor = new Object[]{"Drum","SHAC",21980,102.5,216,100,8,42,
            // 14,14,rrWorkMass,rrWorkArea,7100,rrCC50,rrCC80,rrCVR50,rrCVR80,rrRtT,rrRtCP};
            MWCellArray drumRotor = new MWCellArray(new int[]{1, 21});
            drumRotor.set(new int[]{1,1}, getStringValue(drumBrakeMap.get("rtType")));
            drumRotor.set(new int[]{1,2}, getStringValue(drumBrakeMap.get("rrManu"))); //
//            drumRotor.set(new int[]{1,3}, drumRotorMap.get("rtType").toString().equals("Drum") ? null :
//                    Double.parseDouble(drumRotorMap.get("sweptArea").toString()));
            double swpArea = 21980d;
//            if (drumBrakeMap.get("rtType").toString().equals("Drum")) {
//                swpArea = getDoubleValue(drumBrakeMap.get("swpArea").toString());
//            }
            drumRotor.set(new int[]{1,3}, swpArea);
            drumRotor.set(new int[]{1,4}, getDoubleValue(drumBrakeMap.get("efcR")));
            drumRotor.set(new int[]{1,5}, getDoubleValue(drumBrakeMap.get("outD")));
            drumRotor.set(new int[]{1,6}, getDoubleValue(drumBrakeMap.get("inD")));
            // rotor thick
            double rotorThick = 21980d;
            if (drumBrakeMap.get("rtType").toString().equals("Drum")) {
                rotorThick = getDoubleValue(drumBrakeMap.get("rtThick"));
            } else {
                rotorThick = getDoubleValue(drumBrakeMap.get("rtT"));
            }
            drumRotor.set(new int[]{1,7}, rotorThick);
            // rotor width
            double rotorWidth = 42d;
            if (drumBrakeMap.get("rtType").toString().equals("Drum")) {
                rotorWidth = getDoubleValue(drumBrakeMap.get("rtWidth"));
            }
            drumRotor.set(new int[]{1,8}, rotorWidth);
            // rib thick
            double ribThick = 14d;
            if (drumBrakeMap.get("rtType").toString().equals("Drum")) {
                ribThick = getDoubleValue(drumBrakeMap.get("ribThick"));
            } else if (drumBrakeMap.get("rtType").toString().equals("Vented")) {
                ribThick = getDoubleValue(drumBrakeMap.get("vanT"));
            }
            drumRotor.set(new int[]{1,9}, ribThick);
            // rib width
            double ribWidth = 14d;
            if (drumBrakeMap.get("rtType").toString().equals("Drum")) {
                ribWidth = getDoubleValue(drumBrakeMap.get("ribWidth"));
            } else if (drumBrakeMap.get("rtType").toString().equals("Vented")) {
                ribWidth = getDoubleValue(drumBrakeMap.get("vaneLen"));
            }
            drumRotor.set(new int[]{1,10}, ribWidth);
            drumRotor.set(new int[]{1,11}, getDoubleValue(drumBrakeMap.get("wm")));
            drumRotor.set(new int[]{1,12}, getDoubleValue(drumBrakeMap.get("wa")));
            drumRotor.set(new int[]{1,13}, getDoubleValue(drumBrakeMap.get("rho")));
            drumRotor.set(new int[]{1,14}, getDoubleValue(drumBrakeMap.get("cc50")));
            drumRotor.set(new int[]{1,15}, getDoubleValue(drumBrakeMap.get("cc80")));
            drumRotor.set(new int[]{1,16}, getDoubleValue(drumBrakeMap.get("cc110")));//rrCVR80
            drumRotor.set(new int[]{1,17}, getDoubleValue(drumBrakeMap.get("cvr50")));//rrCVR50
            drumRotor.set(new int[]{1,18}, getDoubleValue(drumBrakeMap.get("cvr80")));//rrCVR80
            drumRotor.set(new int[]{1,19}, getDoubleValue(drumBrakeMap.get("cvr110")));//rrCVR80
            drumRotor.set(new int[]{1,20}, rrRtT);
            drumRotor.set(new int[]{1,21}, rrRtCP);
            // requirement !!!!
            MWCellArray requirement = new MWCellArray(new int[]{1, 34});
            List<Object> brakeStop = (List<Object>) requireMap.get("brakeStop");
            List<Object> bet = (List<Object>) requireMap.get("bet");
            List<Object> pedalFeel = (List<Object>) requireMap.get("pedalFeel");
            // 热模型结果
            requirement.set(new int[]{1,1}, getDoubleValue(requireMap.get("linVi")));
            requirement.set(new int[]{1,2}, getDoubleValue(requireMap.get("linV0")));
//            requirement.set(new int[]{1,3}, Double.parseDouble(requireMap.get("frtLinPwr").toString()));
            requirement.set(new int[]{1,3}, 0.85);
            // 制动距离模型
            requirement.set(new int[]{1,4}, getDoubleValue(brakeStop.get(5)));
            requirement.set(new int[]{1,5}, getDoubleValue(brakeStop.get(1)));
            requirement.set(new int[]{1,6}, getDoubleValue(brakeStop.get(9)));
            requirement.set(new int[]{1,7}, getDoubleValue(brakeStop.get(13)));
            requirement.set(new int[]{1,8}, getDoubleValue(brakeStop.get(7)));
            requirement.set(new int[]{1,9}, getDoubleValue(brakeStop.get(3)));
            requirement.set(new int[]{1,10}, getDoubleValue(brakeStop.get(11)));
            requirement.set(new int[]{1,11}, getDoubleValue(brakeStop.get(15)));
            requirement.set(new int[]{1,12}, getDoubleValue(brakeStop.get(4)));
            requirement.set(new int[]{1,13}, getDoubleValue(brakeStop.get(0)));
            requirement.set(new int[]{1,14}, getDoubleValue(brakeStop.get(8)));
            requirement.set(new int[]{1,15}, getDoubleValue(brakeStop.get(12)));
            requirement.set(new int[]{1,16}, getDoubleValue(brakeStop.get(6)));
            requirement.set(new int[]{1,17}, getDoubleValue(brakeStop.get(2)));
            requirement.set(new int[]{1,18}, getDoubleValue(brakeStop.get(10)));
            requirement.set(new int[]{1,19}, getDoubleValue(brakeStop.get(14)));
            // BET模型输出
            requirement.set(new int[]{1,20}, getDoubleValue(bet.get(0)));
            requirement.set(new int[]{1,21}, getDoubleValue(bet.get(3)));
            requirement.set(new int[]{1,22}, getDoubleValue(bet.get(6)));
            requirement.set(new int[]{1,23}, getDoubleValue(bet.get(9)));
            requirement.set(new int[]{1,24}, getDoubleValue(bet.get(12)));
            requirement.set(new int[]{1,25}, getDoubleValue(bet.get(15)));
            requirement.set(new int[]{1,26}, getDoubleValue(bet.get(18)));
            requirement.set(new int[]{1,27}, getDoubleValue(requireMap.get("sglVi")));
            requirement.set(new int[]{1,28}, getDoubleValue(requireMap.get("sglV0")));
            requirement.set(new int[]{1,29}, getDoubleValue(pedalFeel.get(1)));
            requirement.set(new int[]{1,30}, getDoubleValue(pedalFeel.get(4)));
            requirement.set(new int[]{1,31}, getDoubleValue(pedalFeel.get(7)));
            requirement.set(new int[]{1,32}, getDoubleValue(pedalFeel.get(10)));
            requirement.set(new int[]{1,33}, getDoubleValue(pedalFeel.get(13)));
            requirement.set(new int[]{1,34}, getDoubleValue(pedalFeel.get(16)));
            // parking
            MWCellArray parking = new MWCellArray(new int[]{1,11});
            parking.set(new int[]{1,1}, getDoubleValue(parkingMap.get("elf")));
            parking.set(new int[]{1,2}, getDoubleValue(parkingMap.get("ecf")));
            parking.set(new int[]{1,3}, getDoubleValue(parkingMap.get("ect")));
            parking.set(new int[]{1,4}, getDoubleValue(parkingMap.get("a")));
            parking.set(new int[]{1,5}, getDoubleValue(parkingMap.get("rv")));
            parking.set(new int[]{1,6}, getDoubleValue(parkingMap.get("av")));
            parking.set(new int[]{1,7}, getDoubleValue(parkingMap.get("a0")));
            parking.set(new int[]{1,8}, getDoubleValue(parkingMap.get("ad")));
            parking.set(new int[]{1,9}, getDoubleValue(parkingMap.get("dh")));
            parking.set(new int[]{1,10}, getDoubleValue(parkingMap.get("sigema0")));
            parking.set(new int[]{1,11}, getDoubleValue(parkingMap.get("sita")));
            // calculate begin
            ManualCalculate calculate = new ManualCalculate();
            calculate.main(pedal, booster, masterCylinder, tyre, vehicle, absControl,
                    discCaliper, discRotor, drumCaliper, drumRotor, requirement, parking, geneFlag, timeStamp);
            // calculate end
            String relativePath = System.getenv("CATALINA_HOME");
            System.out.println(relativePath);
            String systemType = System.getProperty("os.name");
            // move result picture
            for (int i = 1; i < 13; i ++) {
                String nowPath = "";
                String afterPath = "";
                String nowDownloadPath = "";
                String afterDownloadPath = "";
                if (systemType.contains("Windows")) {
                    nowPath = relativePath + "\\bin\\figure" + i + ".png";
                    afterPath = path + "\\figure" + i + ".png";
                    nowDownloadPath = relativePath + "\\bin\\figure" + i + ".xlsx";
                    afterDownloadPath = path + "\\figure_" + i + ".xlsx";
                } else {
                    nowPath = relativePath + "/bin/figure" + i + ".xlsx";
                    afterPath = path + "/figure" + i + ".png";
                    nowDownloadPath = relativePath + "/bin/figure" + i + ".xlsx";
                    afterDownloadPath = path + "/figure_" + i + ".xlsx";
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
                File nowXlsxFile = new File(nowDownloadPath);
                if (nowXlsxFile.exists()) {
                    File afterDownloadFile = new File(afterDownloadPath);
                    if (afterDownloadFile.exists()) {
                        afterDownloadFile.delete();
                    }
                    nowXlsxFile.renameTo(afterDownloadFile);
                }
                nowXlsxFile.delete();
            }
            // move result excel
            String resultNowPath = "";
            String resultAfterPath = "";
            if (systemType.contains("Windows")) {
                if (geneFlag == 1) {
                    resultNowPath = relativePath + "\\bin\\result.xlsx";
                    resultAfterPath = path + "\\result.xlsx";
                } else {
                    resultNowPath = relativePath + "\\bin\\result_" +timeStamp + ".xlsx";
                    resultAfterPath = path + "\\result_" + timeStamp + ".xlsx";
                }
            } else {
                if (geneFlag == 1) {
                    resultNowPath = relativePath + "/bin/result.xlsx";
                    resultAfterPath = path + "/result.xlsx";
                } else {
                    resultNowPath = relativePath + "/bin/result_" + timeStamp + ".xlsx";
                    resultAfterPath = path + "/result_" + timeStamp + ".xlsx";
                }
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
            List<List<String>> abUrl = new ArrayList<List<String>>();
            List<String> titles = new ArrayList<String>();
            titles.add("Vehicle Deceleration .vs. Pedal Force");
            titles.add("Vehicle Deceleration .vs. Pedal Travel");
            titles.add("Pedal Force .vs. Pedal Travel");
            titles.add("Brake Efficiency .vs. Brake Strength");
            titles.add("Adhesion Coefficient .vs. Brake Strength");
            titles.add("Vehicle Deceleration .vs. Brake Pressure");
            titles.add("Vehicle Brake Torque .vs. Pedal Force");
            titles.add("Brake Volume .vs. Brake Pressure");
            titles.add("Piston Brake Torque .vs. Brake Pressure");
            titles.add("Front .vs. Rear Brake Pressure");
            titles.add("Temperature of Front Corner");
            titles.add("Temperature of Rear Corner");
            for (int i = 1; i < 13; i ++) {
                List<String> pic = new ArrayList<String>();
                pic.add(titles.get(i-1));
                pic.add("/expert/img/figure"+ i +".png");
                abUrl.add(pic);
            }
            if (geneFlag == 1) {
                result.put("img", abUrl);
            }
            result.put("numerical", getNewResult(params, resultAfterPath));
            flag = true;
        } catch (MWException e) {
            flag = false;
//            try {
//                message = new String(e.getMessage().getBytes("ISO-8859-1"), "GBK");
//                message = "MATLAB计算程序出错：" + message;
//            } catch (UnsupportedEncodingException e1) {
//                e1.printStackTrace();
//            }
            message = "The parameters provided cannot be calculated.（MATLAB Error）";
//            message = getEncoding(e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            flag = false;
            message = "The parameters provided cannot be calculated.";
        }
        // return result;
        Map<String, Object> returnResult = new HashedMap();
        returnResult.put("flag", flag);
        if (flag) {
            returnResult.put("content", result);
        } else {
            returnResult.put("content", message);
        }
        return returnResult;
    }

    public static String getEncoding(String str) {
        String encode = "GB2312";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                String s = encode;
                return s;
            }
        } catch (Exception exception) {
        }
        encode = "ISO-8859-1";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                String s1 = encode;
                return s1;
            }
        } catch (Exception exception1) {
        }
        encode = "UTF-8";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                String s2 = encode;
                return s2;
            }
        } catch (Exception exception2) {
        }
        encode = "GBK";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                String s3 = encode;
                return s3;
            }
        } catch (Exception exception3) {
        }
        return "";
    }

    public static Map<String, Object> getNewResult(Map<String, Map<String, Object>> params, String resultAfterPath) {
        Map<String, Object> result = new HashedMap();
        Map<String, Object> requirementMap = params.get("requirement");
        try {
            File file = new File(resultAfterPath);
            FileInputStream fis = new FileInputStream(file);
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            // Thermal
            // BET modal
            XSSFSheet shBET = wb.getSheet("BET_modal");
            List<String> betT = new ArrayList<String>();
            try {
                betT.add(shBET.getRow(0).getCell(1).getRawValue());
            } catch (NullPointerException e) {
                betT.add("--");
            }
            betT.add("--");
            try {
                betT.add(shBET.getRow(1).getCell(1).getRawValue());
            } catch (NullPointerException e) {
                betT.add("--");
            }
            betT.add("--");
            result.put("BET", betT);
            List<String> ams3T = new ArrayList<String>();
            // no ams3 result data
//            try {
//                ams3T.add(shBET.getRow(2).getCell(1).getRawValue());
//            } catch (NullPointerException e) {
//                ams3T.add("--");
//            }
            ams3T.add("--");
            ams3T.add("--");
//            try {
//                ams3T.add(shBET.getRow(5).getCell(1).getRawValue());
//            } catch (NullPointerException e) {
//                ams3T.add("--");
//            }
            ams3T.add("--");
            ams3T.add("--");
            result.put("AMS3", ams3T);
            List<String> ssT = new ArrayList<String>();
            // single stop result data
            try {
                ssT.add(shBET.getRow(2).getCell(1).getRawValue());
            } catch (NullPointerException e) {
                ssT.add("--");
            }
            try {
                ssT.add(getStringValue(requirementMap.get("frtSglTmp")));
            } catch (Exception e) {
                ssT.add("--");
            }
            try {
                ssT.add(shBET.getRow(3).getCell(1).getRawValue());
            } catch (NullPointerException e) {
                ssT.add("--");
            }
            try {
                ssT.add(getStringValue(requirementMap.get("rrSglTmp")));
            } catch (Exception e) {
                ssT.add("--");
            }
            result.put("Single Stop", ssT);
            // hot modal
            XSSFSheet shHot = wb.getSheet("hot_modal");
            List<String> lpT = new ArrayList<String>();
            try {
                lpT.add(shHot.getRow(0).getCell(1).getRawValue());
            } catch (NullPointerException e) {
                lpT.add("--");
            }
            try {
                lpT.add(getStringValue(requirementMap.get("frtLinPwr")));
            } catch (Exception e) {
                lpT.add("--");
            }
            try {
                lpT.add(shHot.getRow(1).getCell(1).getRawValue());
            } catch (NullPointerException e) {
                lpT.add("--");
            }
            try {
                lpT.add(getStringValue(requirementMap.get("rrLinPwr")));
            } catch (Exception e) {
                lpT.add("--");
            }
            result.put("Lining Power", lpT);
            List<String> hfdT = new ArrayList<String>();
            try {
                hfdT.add(shHot.getRow(2).getCell(1).getRawValue());
            } catch (NullPointerException e) {
                hfdT.add("--");
            }
            try {
                hfdT.add(getStringValue(requirementMap.get("frtHftPwr")));
            } catch (Exception e) {
                hfdT.add("--");
            }
            try {
                hfdT.add(shHot.getRow(3).getCell(1).getRawValue());
            } catch (NullPointerException e) {
                hfdT.add("--");
            }
            try {
                hfdT.add(getStringValue(requirementMap.get("rrHftPwr")));
            } catch (Exception e) {
                hfdT.add("--");
            }
            result.put("HFD", hfdT);
            List<String> llT = new ArrayList<String>();
            llT.add("--");
            llT.add("--");
            llT.add("--");
            llT.add("--");
            result.put("Lining Life", llT);
            // distance modal
            XSSFSheet shDistance = wb.getSheet("distance_modal");
            List<Double> brakeStop = (List<Double>) requirementMap.get("brakeStop");
            List<String> sdlpBS = new ArrayList<String>();
            try {
                sdlpBS.add(shDistance.getRow(6).getCell(1).getRawValue());
            } catch (NullPointerException e) {
                sdlpBS.add("--");
            }
            try {
                sdlpBS.add(getStringValue(brakeStop.get(24)));
            } catch (Exception e) {
                sdlpBS.add("--");
            }
            try {
                sdlpBS.add(shDistance.getRow(8).getCell(1).getRawValue());
            } catch (NullPointerException e) {
                sdlpBS.add("--");
            }
            try {
                sdlpBS.add(getStringValue(brakeStop.get(16)));
            } catch (Exception e) {
                sdlpBS.add("--");
            }
            try {
                sdlpBS.add(shDistance.getRow(7).getCell(1).getRawValue());
            } catch (NullPointerException e) {
                sdlpBS.add("--");
            }
            try {
                sdlpBS.add(getStringValue(brakeStop.get(20)));
            } catch (Exception e) {
                sdlpBS.add("--");
            }
            result.put("Stopping Distance @ LVW Power", sdlpBS);
            List<String> sdlnBS = new ArrayList<String>();
            try {
                sdlnBS.add(shDistance.getRow(0).getCell(1).getRawValue());
            } catch (NullPointerException e) {
                sdlnBS.add("--");
            }
            try {
                sdlnBS.add(getStringValue(brakeStop.get(25)));
            } catch (Exception e) {
                sdlnBS.add("--");
            }
            try {
                sdlnBS.add(shDistance.getRow(2).getCell(1).getRawValue());
            } catch (NullPointerException e) {
                sdlnBS.add("--");
            }
            try {
                sdlnBS.add(getStringValue(brakeStop.get(17)));
            } catch (Exception e) {
                sdlnBS.add("--");
            }
            try {
                sdlnBS.add(shDistance.getRow(1).getCell(1).getRawValue());
            } catch (NullPointerException e) {
                sdlnBS.add("--");
            }
            try {
                sdlnBS.add(getStringValue(brakeStop.get(21)));
            } catch (Exception e) {
                sdlnBS.add("--");
            }
            result.put("Stopping Distance @ LVW Nopower", sdlnBS);
            List<String> sdgpBS = new ArrayList<String>();
            try {
                sdgpBS.add(shDistance.getRow(9).getCell(1).getRawValue());
            } catch (NullPointerException e) {
                sdgpBS.add("--");
            }
            try {
                sdgpBS.add(getStringValue(brakeStop.get(26)));
            } catch (Exception e) {
                sdgpBS.add("--");
            }
            try {
                sdgpBS.add(shDistance.getRow(11).getCell(1).getRawValue());
            } catch (NullPointerException e) {
                sdgpBS.add("--");
            }
            try {
                sdgpBS.add(getStringValue(brakeStop.get(18)));
            } catch (Exception e) {
                sdgpBS.add("--");
            }            try {
                sdgpBS.add(shDistance.getRow(10).getCell(1).getRawValue());
            } catch (NullPointerException e) {
                sdgpBS.add("--");
            }
            try {
                sdgpBS.add(getStringValue(brakeStop.get(22)));
            } catch (Exception e) {
                sdgpBS.add("--");
            }
            sdgpBS.add(String.valueOf(brakeStop.get(22)));
            result.put("Stopping Distance @ GVW Power", sdgpBS);
            List<String> sdgnBS = new ArrayList<String>();
            try {
                sdgnBS.add(shDistance.getRow(3).getCell(1).getRawValue());
            } catch (NullPointerException e) {
                sdgnBS.add("--");
            }
            try {
                sdgnBS.add(String.valueOf(brakeStop.get(27)));
            } catch (Exception e) {
                sdgnBS.add("--");
            }            try {
                sdgnBS.add(shDistance.getRow(5).getCell(1).getRawValue());
            } catch (NullPointerException e) {
                sdgnBS.add("--");
            }
            try {
                sdgnBS.add(getStringValue(brakeStop.get(19)));
            } catch (Exception e) {
                sdgnBS.add("--");
            }
            try {
                sdgnBS.add(shDistance.getRow(4).getCell(1).getRawValue());
            } catch (NullPointerException e) {
                sdgnBS.add("--");
            }
            try {
                sdgnBS.add(String.valueOf(brakeStop.get(23)));
            } catch (Exception e) {
                sdgnBS.add("--");
            }
            result.put("Stopping Distance @ GVW Nopower", sdgnBS);
            // rst table
            XSSFSheet shRst = wb.getSheet("Sheet1");
            List<Double> pedalFeel = (List<Double>) requirementMap.get("pedalFeel");
            List<String> bfiVP = new ArrayList<String>();
            for (int i = 8; i < 21; i ++) {
                // Pedal Force @0.8g GVW
                // Pedal Force @0.9g GVW
                if (i == 13) {
                    bfiVP.add("--");
                } else if (i == 14) {
                    try {
                        bfiVP.add(shRst.getRow(13).getCell(2).getRawValue());
                    } catch (NullPointerException e) {
                        bfiVP.add("--");
                    }
                } else {
                    try {
                        bfiVP.add(shRst.getRow(i).getCell(2).getRawValue());
                    } catch (NullPointerException e) {
                        bfiVP.add("--");
                    }
                }
                if (i >=8 && i < 13) {
                    try {
                        bfiVP.add(String.valueOf(pedalFeel.get((i-8)*3)));
                    } catch (Exception e) {
                        bfiVP.add("--");
                    }
                    try {
                        bfiVP.add(String.valueOf(pedalFeel.get((i-8)*3 + 1)));
                    } catch (Exception e) {
                        bfiVP.add("--");
                    }
                    try {
                        bfiVP.add(String.valueOf(pedalFeel.get((i-8)*3 + 2)));
                    } catch (Exception e) {
                        bfiVP.add("--");
                    }
                } else if (i == 14) {
                    try {
                        bfiVP.add(String.valueOf(pedalFeel.get(15)));
                    } catch (Exception e) {
                        bfiVP.add("--");
                    }
                    try {
                        bfiVP.add(String.valueOf(pedalFeel.get(16)));
                    } catch (Exception e) {
                        bfiVP.add("--");
                    }
                    try {
                        bfiVP.add(String.valueOf(pedalFeel.get(17)));
                    } catch (Exception e) {
                        bfiVP.add("--");
                    }
                } else {
                    bfiVP.add("--");
                    bfiVP.add("--");
                    bfiVP.add("--");
                }
            }
            try {
                bfiVP.add(shRst.getRow(3).getCell(2).getRawValue());
            } catch (NullPointerException e) {
                bfiVP.add("--");
            }
            bfiVP.add("--");
            bfiVP.add("--");
            bfiVP.add("--");
            try {
                bfiVP.add(shRst.getRow(4).getCell(2).getRawValue());
            } catch (NullPointerException e) {
                bfiVP.add("--");
            }
            bfiVP.add("--");
            bfiVP.add("--");
            bfiVP.add("--");
            result.put("BFI", bfiVP);
            List<String> brkBaVP = new ArrayList<String>();
            try {
                brkBaVP.add(shRst.getRow(1).getCell(2).getRawValue());
            } catch (NullPointerException e) {
                brkBaVP.add("--");
            }
            brkBaVP.add("--");
            brkBaVP.add("--");
            brkBaVP.add("--");
            try {
                brkBaVP.add(shRst.getRow(2).getCell(2).getRawValue());
            } catch (NullPointerException e) {
                brkBaVP.add("--");
            }
            brkBaVP.add("--");
            brkBaVP.add("--");
            brkBaVP.add("--");
            result.put("Brake Balance", brkBaVP);
            List<String> bstRunVP = new ArrayList<String>();
            try {
                bstRunVP.add(shRst.getRow(5).getCell(2).getRawValue());
            } catch (NullPointerException e) {
                bstRunVP.add("--");
            }
            bstRunVP.add("--");
            bstRunVP.add("--");
            bstRunVP.add("--");
            try {
                bstRunVP.add(shRst.getRow(6).getCell(2).getRawValue());
            } catch (NullPointerException e) {
                bstRunVP.add("--");
            }
            bstRunVP.add("--");
            bstRunVP.add("--");
            bstRunVP.add("--");
            result.put("Booster Runout", bstRunVP);
            List<String> brkPreVP = new ArrayList<String>();
            try {
                brkPreVP.add(shRst.getRow(23).getCell(2).getRawValue());
            } catch (NullPointerException e) {
                brkPreVP.add("--");
            }
            brkPreVP.add("--");
            brkPreVP.add("--");
            brkPreVP.add("--");
            try {
                brkPreVP.add(shRst.getRow(24).getCell(2).getRawValue());
            } catch (NullPointerException e) {
                brkPreVP.add("--");
            }
            brkPreVP.add("--");
            brkPreVP.add("--");
            brkPreVP.add("--");
            result.put("Brake Pressure @1g", brkPreVP);
            List<String> noneVP = new ArrayList<String>();
            try {
                noneVP.add(shRst.getRow(21).getCell(2).getRawValue());
            } catch (NullPointerException e) {
                noneVP.add("--");
            }
            noneVP.add("--");
            noneVP.add("--");
            noneVP.add("--");
            try {
                noneVP.add(shRst.getRow(22).getCell(2).getRawValue());
            } catch (NullPointerException e) {
                noneVP.add("--");
            }
            noneVP.add("--");
            noneVP.add("--");
            noneVP.add("--");
            result.put("noneVP",noneVP);
            XSSFSheet parkingRst = wb.getSheet("parking");
            List<String> parkingList = new ArrayList<String>();
            parkingList.add(parkingRst.getRow(0).getCell(0).getRawValue());
            parkingList.add(parkingRst.getRow(0).getCell(1).getRawValue());
            parkingList.add(parkingRst.getRow(1).getCell(0).getRawValue());
            parkingList.add(parkingRst.getRow(1).getCell(1).getRawValue());
            parkingList.add(parkingRst.getRow(2).getCell(0).getRawValue());
            parkingList.add(parkingRst.getRow(2).getCell(1).getRawValue());
            parkingList.add(parkingRst.getRow(3).getCell(0).getRawValue());
            parkingList.add(parkingRst.getRow(3).getCell(1).getRawValue());
            result.put("parking", parkingList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Map<String, Object> getContrastResult(Map<String, Map<String, Object>> params, String filePath) {
        Map<String, Object> vehicleMap = params.get("vehicle");
        Map<String, Object> tireMap = params.get("tire");
        Map<String, Object> applyMap = params.get("apply");
        Map<String, Object> discBrakeMap = params.get("discBrake");
        Map<String, Object> drumBrakeMap = params.get("drumBrake");
        Map<String, Object> result = new HashedMap();
        // vehicleMap
        List<Object> vehicleList = new ArrayList<Object>();
        vehicleList.add(vehicleMap.get("lvwM"));
        vehicleList.add(vehicleMap.get("gvwM"));
        vehicleList.add(vehicleMap.get("lvwFrtR"));
        vehicleList.add(vehicleMap.get("gvwFrtR"));
        vehicleList.add(vehicleMap.get("lvwCgh"));
        vehicleList.add(vehicleMap.get("gvwCgh"));
        vehicleList.add(vehicleMap.get("l"));
        result.put("vehicle", vehicleList);
        // tireMap
        List<Object> tireList = new ArrayList<Object>();
        tireList.add(tireMap.get("lvwTrFrt"));
        tireList.add(tireMap.get("gvwTrFrt"));
        tireList.add(tireMap.get("lvwTrRr"));
        tireList.add(tireMap.get("gvwTrRr"));
        result.put("tire", tireList);
        // discBrakeMap
        List<Object> discBrakeList = new ArrayList<Object>();
        discBrakeList.add(discBrakeMap.get("outD"));
        discBrakeList.add(discBrakeMap.get("pstD"));
        discBrakeList.add(discBrakeMap.get("linMuNp"));
        result.put("frtCorner", discBrakeList);
        // drumBrakeMap
        List<Object> drumBrakeList = new ArrayList<Object>();
        drumBrakeList.add(drumBrakeMap.get("outD"));
        drumBrakeList.add(drumBrakeMap.get("pstD"));
        drumBrakeList.add(drumBrakeMap.get("linMuNp"));
        result.put("rrCorner", drumBrakeList);
        // applyMap
        List<Object> applyList = new ArrayList<Object>();
        applyList.add(applyMap.get("pedRatio"));
        applyList.add(applyMap.get("mcdD"));
        applyList.add(applyMap.get("bstGain"));
        applyList.add(applyMap.get("bstFTotal"));
        applyList.add(applyMap.get("bstTLs"));
        applyList.add(applyMap.get("bstFJmp"));
        applyList.add(applyMap.get("bstFLsNp"));
        applyList.add(applyMap.get("bstFLsWp"));
        result.put("apply", applyList);
        // file
        File file = new File(filePath);
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet vehicleTab = wb.getSheet("Sheet1");
            XSSFSheet hotModalTab = wb.getSheet("hot_modal");
            XSSFSheet distanceModalTab = wb.getSheet("distance_modal");
            XSSFSheet betModalTab = wb.getSheet("BET_modal");
            List<Object> bfiList = new ArrayList<Object>();
            // bfi
            bfiList.add(vehicleTab.getRow(9).getCell(2).getRawValue());
            bfiList.add(vehicleTab.getRow(10).getCell(2).getRawValue());
            bfiList.add(vehicleTab.getRow(11).getCell(2).getRawValue());
            bfiList.add(vehicleTab.getRow(12).getCell(2).getRawValue());
            bfiList.add(vehicleTab.getRow(13).getCell(2).getRawValue());
            result.put("BFI", bfiList);
            // brake
            List<Object> brakeList = new ArrayList<Object>();
            brakeList.add(vehicleTab.getRow(1).getCell(2).getRawValue());
            brakeList.add("--");
            brakeList.add("--");
            brakeList.add(distanceModalTab.getRow(0).getCell(1).getRawValue());
            brakeList.add(distanceModalTab.getRow(1).getCell(1).getRawValue());
            brakeList.add(distanceModalTab.getRow(2).getCell(1).getRawValue());
            brakeList.add(distanceModalTab.getRow(3).getCell(1).getRawValue());
            brakeList.add(distanceModalTab.getRow(4).getCell(1).getRawValue());
            brakeList.add(distanceModalTab.getRow(5).getCell(1).getRawValue());
            brakeList.add(distanceModalTab.getRow(6).getCell(1).getRawValue());
            brakeList.add(distanceModalTab.getRow(7).getCell(1).getRawValue());
            brakeList.add(distanceModalTab.getRow(8).getCell(1).getRawValue());
            brakeList.add(distanceModalTab.getRow(9).getCell(1).getRawValue());
            brakeList.add(distanceModalTab.getRow(10).getCell(1).getRawValue());
            brakeList.add(distanceModalTab.getRow(11).getCell(1).getRawValue());
            result.put("brake", brakeList);
            // thermal
            List<Object> thermalList = new ArrayList<Object>();
            thermalList.add(betModalTab.getRow(0).getCell(1).getRawValue());
            thermalList.add(betModalTab.getRow(1).getCell(1).getRawValue());
            thermalList.add(betModalTab.getRow(2).getCell(1).getRawValue());
            thermalList.add(betModalTab.getRow(3).getCell(1).getRawValue());
            thermalList.add("--");
            thermalList.add("--");
            thermalList.add("--");
            thermalList.add("--");
            thermalList.add(hotModalTab.getRow(2).getCell(1).getRawValue());
            thermalList.add(hotModalTab.getRow(3).getCell(1).getRawValue());
            thermalList.add(hotModalTab.getRow(0).getCell(1).getRawValue());
            thermalList.add(hotModalTab.getRow(1).getCell(1).getRawValue());
            result.put("thermal", thermalList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
//        String a = "[100, 150, 200, 250, 300, 400]";
//        String[] b = a.split("\\[|\\]|, ");
//        List<String> last = new ArrayList<String>();
//        for (int i = 0; i < b.length; i ++) {
//            if ((b[i] != null) && (!b[i].equals(""))) {
//                last.add(b[i]);
//            }
//        }
//        System.out.println(last.toString());
        System.out.println(setPartDetail("False"));
    }

    public static int setPartDetail(Object detail) {
        if (detail.toString().equals("false") || (detail.toString().equals("FALSE") || detail.toString().equals("False"))) {
            return -1000;
        }
        return Integer.parseInt(detail.toString());
    }

    public static String downloadFigureData(String path, int figureId) {
        String systemType = System.getProperty("os.name");
        String resultAfterPath = "";
        String  newPath = "";
        if (systemType.contains("Windows")) {
            resultAfterPath = path + "\\result.xlsx";
            newPath = path + "\\figure" + figureId + ".xlsx";
        } else {
            resultAfterPath = path + "/result.xlsx";
            newPath = path + "/figure" + figureId + ".xlsx";
        }
        try {
            CopySheet.main(resultAfterPath, newPath, "figure" + figureId);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newPath;
    }

    public static Double getDoubleValue(Object value) {
        if (value == null) {
            return null;
        } else if (value.toString().equals("")) {
            return null;
        }
        return Double.valueOf(value.toString());
    }

    public static String getStringValue(Object value) {
        if (value == null) {
            return null;
        } else if (value.toString().equals("")) {
            return null;
        }
        return String.valueOf(value.toString());
    }

    public static Map<String, Double> PFCurve2Param(Map<String, Object> params) {
        double hfPT = getDoubleValue(params.get("hfPT").toString());
        double pstArea = getDoubleValue(params.get("pstArea").toString());
        double pstNum = getDoubleValue(params.get("pstNum").toString());
        double efcR = getDoubleValue(params.get("efcR").toString());
        List<Object> linMuList = (List<Object>) params.get("linMu");
        MWCellArray linMu = new MWCellArray(new int[]{1, 6});
        linMu.set(new int[]{1,1}, 500d);
        linMu.set(new int[]{1,2}, getDoubleValue(linMuList.get(0).toString()));
        linMu.set(new int[]{1,3}, 5000d);
        linMu.set(new int[]{1,4}, getDoubleValue(linMuList.get(1).toString()));
        linMu.set(new int[]{1,5}, 12000d);
        linMu.set(new int[]{1,6}, getDoubleValue(linMuList.get(2).toString()));
        Map<String, Double> coeff = new HashedMap();
        try {
            ManualCalculate manualCalculate = new ManualCalculate();
            Object[] result = null;
            result = manualCalculate.PfCurve2ParamLinkage(2,hfPT,pstArea,pstNum,efcR,linMu);
            coeff.put("linMuK", getDoubleValue(result[0].toString()));
            coeff.put("linMuE", getDoubleValue(result[1].toString()));
        } catch (MWException e) {
            e.printStackTrace();
        }
        return coeff;
    }

    public static Map<String, Double> PVCurve2Param(Map<String, Object> params) {
        double hfPV = getDoubleValue(params.get("hfPV").toString());
        double pstArea = getDoubleValue(params.get("pstArea").toString());
        double pstNum = getDoubleValue(params.get("pstNum").toString());
        List<Object> linMuList = (List<Object>) params.get("pVcurve");
        MWCellArray pVcurve = new MWCellArray(new int[]{1, 6});
        pVcurve.set(new int[]{1,1}, 500d);
        pVcurve.set(new int[]{1,2}, getDoubleValue(linMuList.get(0).toString()));
        pVcurve.set(new int[]{1,3}, 5000d);
        pVcurve.set(new int[]{1,4}, getDoubleValue(linMuList.get(1).toString()));
        pVcurve.set(new int[]{1,5}, 12000d);
        pVcurve.set(new int[]{1,6}, getDoubleValue(linMuList.get(2).toString()));
        Map<String, Double> coeff = new HashedMap();
        try {
            ManualCalculate manualCalculate = new ManualCalculate();
            Object[] result = null;
            result = manualCalculate.PVCurve2ParamLinkage(3,hfPV,pVcurve,pstArea,pstNum);
            coeff.put("pvK", getDoubleValue(result[0].toString()));
            coeff.put("pvB", getDoubleValue(result[1].toString()));
            coeff.put("pvC", getDoubleValue(result[2].toString()));
        } catch (MWException e) {
            e.printStackTrace();
        }
        return coeff;
    }
}
