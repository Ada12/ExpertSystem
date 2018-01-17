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
        Map<String, Object> discBrakeMap = params.get("discBrake");
        Map<String, Object> drumBrakeMap = params.get("drumBrake");
        Map<String, Object> tireMap = params.get("tire");
        Map<String, Object> vehicleMap = params.get("vehicle");
        Map<String, Object> requireMap = params.get("requirement");
        Map<String, Object> result = new HashedMap();
        try {
            // Pedal param
            // Object[] pedal1 = new Object[]{3,1,1,"sanli"};
            MWCellArray pedal = new MWCellArray(new int[]{1, 4});
            pedal.set(new int[]{1,1}, getDoubleValue(applyMap.get("pedRatio").toString()));
            pedal.set(new int[]{1,2}, getDoubleValue(applyMap.get("pedFEff").toString()));
            pedal.set(new int[]{1,3}, getDoubleValue(applyMap.get("pedTEff").toString()));
            pedal.set(new int[]{1,4}, String.valueOf(applyMap.get("pedSpl")));
            // booster param
            // Object[] booster1 = new Object[]{10,6,2360,0.95,0.85,320,80,320,2,"SABS"};
            MWCellArray booster = new MWCellArray(1, 10);
            booster.set(new int[]{1,1}, getDoubleValue(String.valueOf(applyMap.get("bstSize"))));
            booster.set(new int[]{1,2}, getDoubleValue(String.valueOf(applyMap.get("bstGain"))));
            booster.set(new int[]{1,3}, getDoubleValue(String.valueOf(applyMap.get("bstFTotal"))));
            booster.set(new int[]{1,4}, getDoubleValue(String.valueOf(applyMap.get("bstFEff"))));
            booster.set(new int[]{1,5}, getDoubleValue(String.valueOf(applyMap.get("bstTEff"))));
            booster.set(new int[]{1,6}, getDoubleValue(String.valueOf(applyMap.get("bstFLsNp"))));
            booster.set(new int[]{1,7}, getDoubleValue(String.valueOf(applyMap.get("bstFLsWp"))));
            booster.set(new int[]{1,8}, getDoubleValue(String.valueOf(applyMap.get("bstFJmp"))));
            booster.set(new int[]{1,9}, getDoubleValue(String.valueOf(applyMap.get("bstTLs"))));
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
            masterCylinder.set(new int[]{1,1}, getDoubleValue(applyMap.get("mcdD").toString()));
            masterCylinder.set(new int[]{1,2}, getDoubleValue(applyMap.get("mcdFEff").toString()));
            masterCylinder.set(new int[]{1,3}, getDoubleValue(applyMap.get("mcdTEff").toString()));
            masterCylinder.set(new int[]{1,4}, String.valueOf(applyMap.get("mcdSpl")));
            // tyre
            // Object[] rollResis = new Object[]{};
            MWNumericArray rollResis = new MWNumericArray();
            // MWArray rollResis = new MWArray();
            //Object[] tyre = new Object[]{292,292,292,292,1.07,0.7,0.9,0.1,rollResis};
            MWCellArray tyre = new MWCellArray(new int[]{1,9});
            tyre.set(new int[]{1,1}, getDoubleValue(tireMap.get("lvwTrFrt").toString()));
            tyre.set(new int[]{1,2}, getDoubleValue(tireMap.get("lvwTrRr").toString()));
            tyre.set(new int[]{1,3}, getDoubleValue(tireMap.get("gvwTrFrt").toString()));
            tyre.set(new int[]{1,4}, getDoubleValue(tireMap.get("gvwTrRr").toString()));
            tyre.set(new int[]{1,5}, getDoubleValue(tireMap.get("peakAdhesLong").toString()));
            tyre.set(new int[]{1,6}, getDoubleValue(tireMap.get("peakAdhesLat").toString()));
            tyre.set(new int[]{1,7}, getDoubleValue(tireMap.get("tracCoeff").toString()));
            tyre.set(new int[]{1,8}, getDoubleValue(tireMap.get("s").toString()));
            tyre.set(new int[]{1,9}, getDoubleValue(tireMap.get("fR").toString()));
            // vehicle
            // Object[] vehicle = new Object[]{"SGM318",2015,"F","NB",1250,0.584,565,1490,0.514,565,2499,170,0.05,0.35,2};
            MWCellArray vehicle = new MWCellArray(new int[]{1,15});
            vehicle.set(new int[]{1,1}, vehicleMap.get("carModel").toString());
            vehicle.set(new int[]{1,2}, getDoubleValue(vehicleMap.get("carYear").toString()));
            vehicle.set(new int[]{1,3}, vehicleMap.get("carDa").toString());
            vehicle.set(new int[]{1,4}, vehicleMap.get("carAddInfo").toString());
            vehicle.set(new int[]{1,5}, getDoubleValue(vehicleMap.get("lvwM").toString()));
            vehicle.set(new int[]{1,6}, getDoubleValue(vehicleMap.get("lvwFrtR").toString()));
            vehicle.set(new int[]{1,7}, getDoubleValue(vehicleMap.get("lvwCgh").toString()));
            vehicle.set(new int[]{1,8}, getDoubleValue(vehicleMap.get("gvwM").toString()));
            vehicle.set(new int[]{1,9}, getDoubleValue(vehicleMap.get("gvwFrtR").toString()));
            vehicle.set(new int[]{1,10}, getDoubleValue(vehicleMap.get("gvwCgh").toString()));
            vehicle.set(new int[]{1,11}, getDoubleValue(vehicleMap.get("l").toString()));
            vehicle.set(new int[]{1,12}, getDoubleValue(vehicleMap.get("vmax").toString()));
            vehicle.set(new int[]{1,13}, getDoubleValue(vehicleMap.get("coastDecel").toString()));
            vehicle.set(new int[]{1,14}, getDoubleValue(vehicleMap.get("cd").toString()));
            vehicle.set(new int[]{1,15}, getDoubleValue(vehicleMap.get("a").toString()));
            // ABSControl
            // Object[] absControl = new Object[]{"","",0.93,0.93};
            MWCellArray absControl = new MWCellArray(new int[]{1,4});
            absControl.set(new int[]{1,1}, String.valueOf(controlMap.get("absSpl")));
            absControl.set(new int[]{1,2}, String.valueOf(controlMap.get("absType")));
            absControl.set(new int[]{1,3}, getDoubleValue(controlMap.get("effAbsFrt").toString()));
            absControl.set(new int[]{1,4}, getDoubleValue(controlMap.get("effAbsRr").toString()));
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
                frtPVCurveArray[i * 2 + 1] = getDoubleValue(frtPVCurveList.get(i).toString());
            }
            MWNumericArray frtPVCurve = new MWNumericArray(frtPVCurveArray, MWClassID.DOUBLE);
            // MWNumericArray frtLinMu = new MWNumericArray((List<Double>) discCaliperMap.get("linMu"), MWClassID.DOUBLE);
            List<Object> frtLinMuList = (List<Object>) discBrakeMap.get("linMu");
            double[] frtLinMuArray = new double[frtLinMuList.size() * 2];
            frtLinMuArray[0] = 500d;
            frtLinMuArray[2] = 5000d;
            frtLinMuArray[4] = 12000d;
            for(int i = 0; i < frtLinMuList.size(); i ++) {
                frtLinMuArray[i * 2 + 1] = getDoubleValue(frtLinMuList.get(i).toString());
            }
            MWNumericArray frtLinMu = new MWNumericArray(frtLinMuArray, MWClassID.DOUBLE);
            MWNumericArray frtBrkFactor = new MWNumericArray();
            // MWNumericArray frtLinMuK = new MWNumericArray();
            // MWNumericArray frtLinMuE = new MWNumericArray();
            List<Object> frtLinTList = (List<Object>) discBrakeMap.get("frtRtTempIn");
            double[] frtLinTArray = new double[frtLinTList.size()];
            for(int i = 0; i < frtLinTList.size(); i ++) {
                frtLinTArray[i] = getDoubleValue(frtLinTList.get(i).toString());
            }
            MWNumericArray frtLinT = new MWNumericArray(frtLinTArray, MWClassID.DOUBLE);
            List<Object> frtLinCPList = (List<Object>) discBrakeMap.get("frtLinWearOut");
            double[] frtLinCPArray = new double[frtLinCPList.size()];
            for(int i = 0; i < frtLinCPList.size(); i ++) {
                frtLinCPArray[i] = getDoubleValue(frtLinCPList.get(i).toString());
            }
            MWNumericArray frtLinCP = new MWNumericArray(frtLinCPArray, MWClassID.DOUBLE);
            List<Object> frtLinCP1List = (List<Object>) discBrakeMap.get("frtLinFrictOut");
            double[] frtLinCP1Array = new double[frtLinCP1List.size()];
            for(int i = 0; i < frtLinCP1List.size(); i ++) {
                frtLinCP1Array[i] = getDoubleValue(frtLinCP1List.get(i).toString());
            }
            MWNumericArray frtLinCP1 = new MWNumericArray(frtLinCP1Array, MWClassID.DOUBLE);
            // Object[] discCaliper = new Object[]{"Conti",51,1,frtPstArea,100,frtPVCurve,
            // frtPVK,frtPVB,frtPVC,"FM","Low Mat(#)","TBD",frtLinMu,frtBrkFactor,frtLinMuK,
            // frtLinMuE,0.4,0.8,3430,11,frtLinT,frtLinCP,frtLinCP1};
            MWCellArray discCaliper = new MWCellArray(new int[]{1,23});
            discCaliper.set(new int[]{1,1}, String.valueOf(discBrakeMap.get("frtManu")));
            discCaliper.set(new int[]{1,2}, getDoubleValue(discBrakeMap.get("pstD").toString()));
            discCaliper.set(new int[]{1,3}, getDoubleValue(discBrakeMap.get("pstNum").toString()));
            discCaliper.set(new int[]{1,4}, getDoubleValue(discBrakeMap.get("pstArea").toString()));
            discCaliper.set(new int[]{1,5}, getDoubleValue(discBrakeMap.get("hfP").toString()));
            discCaliper.set(new int[]{1,6}, frtPVCurve);
            discCaliper.set(new int[]{1,7}, getDoubleValue(discBrakeMap.get("pvK").toString()));
            discCaliper.set(new int[]{1,8}, getDoubleValue(discBrakeMap.get("pvB").toString()));
            discCaliper.set(new int[]{1,9}, getDoubleValue(discBrakeMap.get("pvC").toString()));
            discCaliper.set(new int[]{1,10}, discBrakeMap.get("linSpl").toString()); //
            discCaliper.set(new int[]{1,11}, discBrakeMap.get("linMat").toString());
            discCaliper.set(new int[]{1,12}, "TBD"); // deleted
            // Double.parseDouble(discCaliperMap.get("linMu").toString())
            discCaliper.set(new int[]{1,13}, frtLinMu);
            discCaliper.set(new int[]{1,14}, frtBrkFactor); //
            discCaliper.set(new int[]{1,15}, getDoubleValue(discBrakeMap.get("linMuK").toString()));
            discCaliper.set(new int[]{1,16}, getDoubleValue(discBrakeMap.get("linMuE").toString()));
            discCaliper.set(new int[]{1,17}, getDoubleValue(discBrakeMap.get("linMuNp").toString()));
            discCaliper.set(new int[]{1,18}, 0.8); // deleted
            discCaliper.set(new int[]{1,19}, getDoubleValue(discBrakeMap.get("linArea").toString()));
            discCaliper.set(new int[]{1,20}, getDoubleValue(discBrakeMap.get("linWearLim").toString()));
            discCaliper.set(new int[]{1,21}, frtLinT);
            discCaliper.set(new int[]{1,22}, frtLinCP);
            discCaliper.set(new int[]{1,23}, frtLinCP1);
            // frt/disc rotor
            MWNumericArray frtCC50 = new MWNumericArray();
            MWNumericArray frtCC80 = new MWNumericArray();
            List<Object> frtRtTList = (List<Object>)discBrakeMap.get("rtTempIn");
            double[] frtRtTArray = new double[frtRtTList.size()];
            for(int i = 0; i < frtRtTList.size(); i ++) {
                frtRtTArray[i] = getDoubleValue(frtRtTList.get(i).toString());
            }
            MWNumericArray frtRtT = new MWNumericArray(frtRtTArray, MWClassID.DOUBLE);
            List<Object> frtRtCPList = (List<Object>)discBrakeMap.get("rtSpecOut");
            double[] frtRtCPArray = new double[frtRtCPList.size()];
            for(int i = 0; i < frtRtCPList.size(); i ++) {
                frtRtCPArray[i] = getDoubleValue(frtRtCPList.get(i).toString());
            }
            MWNumericArray frtRtCP = new MWNumericArray(frtRtCPArray, MWClassID.DOUBLE);
            // Object[] discRotor = new Object[]{"Vented","SHAC",0,102.5,256,146,22,6,6,44,42,9.2,5,
            // frtWorkMass,frtWorkArea,7100,frtCC50,frtCC80,0.026,0.026,frtRtT,frtRtCP};
            // rtCkIn and rtCkOut => double
            MWCellArray discRotor = new MWCellArray(new int[]{1,22});
            discRotor.set(new int[]{1,1}, discBrakeMap.get("rtType").toString());
            discRotor.set(new int[]{1,2}, discBrakeMap.get("rrManu").toString()); //
//            discRotor.set(new int[]{1,3}, discCaliperMap.get("rtType").toString().equals("Drum") ? null :
//                    Double.parseDouble(discRotorMap.get("rtSwpArea").toString())); ////
            discRotor.set(new int[]{1,3}, 21980d); // swp_area
            discRotor.set(new int[]{1,4}, getDoubleValue(discBrakeMap.get("efcR").toString()));
            discRotor.set(new int[]{1,5}, getDoubleValue(discBrakeMap.get("outD").toString()));
            discRotor.set(new int[]{1,6}, getDoubleValue(discBrakeMap.get("inD").toString()));
            discRotor.set(new int[]{1,7}, getDoubleValue(discBrakeMap.get("rtT").toString()));
            discRotor.set(new int[]{1,8}, getDoubleValue(discBrakeMap.get("ckTIn").toString()));
            discRotor.set(new int[]{1,9}, getDoubleValue(discBrakeMap.get("ckTOut").toString()));
            discRotor.set(new int[]{1,10}, getDoubleValue(discBrakeMap.get("vaneNum").toString()));
            discRotor.set(new int[]{1,11}, getDoubleValue(discBrakeMap.get("vaneLen").toString()));
            discRotor.set(new int[]{1,12}, getDoubleValue(discBrakeMap.get("vaneHigh").toString()));
            discRotor.set(new int[]{1,13}, getDoubleValue(discBrakeMap.get("vanT").toString()));
            discRotor.set(new int[]{1,14}, getDoubleValue(discBrakeMap.get("wm").toString()));
            discRotor.set(new int[]{1,15}, getDoubleValue(discBrakeMap.get("wa").toString()));
            discRotor.set(new int[]{1,16}, getDoubleValue(discBrakeMap.get("rho").toString()));
            discRotor.set(new int[]{1,17}, getDoubleValue(discBrakeMap.get("cc50").toString()));
            discRotor.set(new int[]{1,18}, getDoubleValue(discBrakeMap.get("cc80").toString()));
            discRotor.set(new int[]{1,19}, getDoubleValue(discBrakeMap.get("cvr50").toString()));
            discRotor.set(new int[]{1,20}, getDoubleValue(discBrakeMap.get("cvr80").toString()));
            discRotor.set(new int[]{1,21}, frtRtT);
            discRotor.set(new int[]{1,22}, frtRtCP);
            // rr/drum caliper
            List<Object> rrPVCurveList = (List<Object>)drumBrakeMap.get("pVcurve");
            double[] rrPVCurveArray = new double[rrPVCurveList.size() * 2];
            rrPVCurveArray[0] = 500d;
            rrPVCurveArray[2] = 5000d;
            rrPVCurveArray[4] = 12000d;
            for(int i = 0; i < rrPVCurveList.size(); i ++) {
                rrPVCurveArray[i * 2 + 1] = getDoubleValue(rrPVCurveList.get(i).toString());
            }
            MWNumericArray rrPVCurve = new MWNumericArray(rrPVCurveArray, MWClassID.DOUBLE);
            // MWNumericArray rrLinMu = new MWNumericArray(new double[]{500, 0.82, 5000, 0.86, 12000, 0.9});
            List<Object> rrLinMuList = (List<Object>) drumBrakeMap.get("linMu");
            double[] rrLinMuArray = new double[rrLinMuList.size() * 2];
            rrLinMuArray[0] = 500d;
            rrLinMuArray[2] = 5000d;
            rrLinMuArray[4] = 12000d;
            for(int i = 0; i < rrLinMuList.size(); i ++) {
                rrLinMuArray[i * 2 + 1] = getDoubleValue(rrLinMuList.get(i).toString());
            }
            MWNumericArray rrLinMu = new MWNumericArray(rrLinMuArray, MWClassID.DOUBLE);
            MWNumericArray rrBrkFactor = new MWNumericArray();
            MWNumericArray rrLinMuK = new MWNumericArray();
            MWNumericArray rrLinMuE = new MWNumericArray();
            List<Object> rrLinTList = (List<Object>) drumBrakeMap.get("frtRtTempIn");
            double[] rrLinTArray = new double[rrLinTList.size()];
            for(int i = 0; i < rrLinTList.size(); i ++) {
                rrLinTArray[i] = getDoubleValue(rrLinTList.get(i).toString());
            }
            MWNumericArray rrLinT = new MWNumericArray(rrLinTArray, MWClassID.DOUBLE);
            List<Object> rrLinCPList = (List<Object>) drumBrakeMap.get("frtLinWearOut");
            double[] rrLinCPArray = new double[rrLinCPList.size()];
            for(int i = 0; i < rrLinCPList.size(); i ++) {
                rrLinCPArray[i] = getDoubleValue(rrLinCPList.get(i).toString());
            }
            MWNumericArray rrLinCP = new MWNumericArray(rrLinCPArray, MWClassID.DOUBLE);
            List<Object> rrLinCP1List = (List<Object>) drumBrakeMap.get("frtLinFrictOut");
            double[] rrLinCP1Array = new double[rrLinCP1List.size()];
            for(int i = 0; i < rrLinCP1List.size(); i ++) {
                rrLinCP1Array[i] = getDoubleValue(rrLinCP1List.get(i).toString());
            }
            MWNumericArray rrLinCP1 = new MWNumericArray(rrLinCP1Array, MWClassID.DOUBLE);
//            MWNumericArray rrRtT = new MWNumericArray(new double[]{});
//            MWNumericArray rrRtCP = new MWNumericArray(new double[]{});
            // Object[] drumCaliper = new Object[]{"BWI",19.05,1,rrPstArea,400,rrPVCurve,
            // rrPVK,rrPVB,rrPVC,"SB","DO4-A","TBD",rrLinMu,rrBrkFactor,rrLinMuK,
            // rrLinMuE,0.825,1.65,5779,5,rrLinT,rrLinCP,rrLinCP1};
            MWCellArray drumCaliper = new MWCellArray(new int[]{1,23});
            drumCaliper.set(new int[]{1,1}, String.valueOf(drumBrakeMap.get("frtManu"))); //
            drumCaliper.set(new int[]{1,2}, getDoubleValue(drumBrakeMap.get("pstD").toString()));
            drumCaliper.set(new int[]{1,3}, getDoubleValue(drumBrakeMap.get("pstNum").toString()));
            drumCaliper.set(new int[]{1,4}, getDoubleValue(drumBrakeMap.get("pstArea").toString()));
            drumCaliper.set(new int[]{1,5}, getDoubleValue(drumBrakeMap.get("hfP").toString()));
            drumCaliper.set(new int[]{1,6}, rrPVCurve);
            drumCaliper.set(new int[]{1,7}, getDoubleValue(drumBrakeMap.get("pvK").toString()));
            drumCaliper.set(new int[]{1,8}, getDoubleValue(drumBrakeMap.get("pvB").toString()));
            drumCaliper.set(new int[]{1,9}, getDoubleValue(drumBrakeMap.get("pvC").toString()));
            drumCaliper.set(new int[]{1,10}, drumBrakeMap.get("linSpl").toString()); //
            drumCaliper.set(new int[]{1,11}, drumBrakeMap.get("linMat").toString());
            drumCaliper.set(new int[]{1,12}, drumBrakeMap.get("insulator").toString()); // insulator
            // Double.parseDouble(drumCaliperMap.get("linMu").toString())
            drumCaliper.set(new int[]{1,13}, rrLinMu);
            drumCaliper.set(new int[]{1,14}, rrBrkFactor); //
            drumCaliper.set(new int[]{1,15}, getDoubleValue(drumBrakeMap.get("linMuK").toString()));
            drumCaliper.set(new int[]{1,16}, getDoubleValue(drumBrakeMap.get("linMuE").toString()));
            drumCaliper.set(new int[]{1,17}, getDoubleValue(drumBrakeMap.get("linMuNp").toString()));
            drumCaliper.set(new int[]{1,18}, 1.65); // deleted: brkFactorNP
            drumCaliper.set(new int[]{1,19}, getDoubleValue(drumBrakeMap.get("linArea").toString()));
            drumCaliper.set(new int[]{1,20}, getDoubleValue(drumBrakeMap.get("linWearLim").toString()));
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
                rrRtTArray[i] = getDoubleValue(rrRtTList.get(i).toString());
            }
            MWNumericArray rrRtT = new MWNumericArray(rrRtTArray);
            List<Object> rrRtCPList = (List<Object>)drumBrakeMap.get("dmTempOut");
            double[] rrRtCPArray = new double[rrRtCPList.size()];
            for(int i = 0; i < rrRtCPList.size(); i ++) {
                rrRtCPArray[i] = getDoubleValue(rrRtCPList.get(i).toString());
            }
            MWNumericArray rrRtCP = new MWNumericArray(rrRtCPArray);
            // Object[] drumRotor = new Object[]{"Drum","SHAC",21980,102.5,216,100,8,42,
            // 14,14,rrWorkMass,rrWorkArea,7100,rrCC50,rrCC80,rrCVR50,rrCVR80,rrRtT,rrRtCP};
            MWCellArray drumRotor = new MWCellArray(new int[]{1, 19});
            drumRotor.set(new int[]{1,1}, drumBrakeMap.get("rtType").toString());
            drumRotor.set(new int[]{1,2}, drumBrakeMap.get("rrManu").toString()); //
//            drumRotor.set(new int[]{1,3}, drumRotorMap.get("rtType").toString().equals("Drum") ? null :
//                    Double.parseDouble(drumRotorMap.get("sweptArea").toString()));
            double swpArea = 21980d;
            if (drumBrakeMap.get("rtType").toString().equals("Drum")) {
                swpArea = getDoubleValue(drumBrakeMap.get("swpArea").toString());
            }
            drumRotor.set(new int[]{1,3}, swpArea);
            drumRotor.set(new int[]{1,4}, getDoubleValue(drumBrakeMap.get("efcR").toString()));
            drumRotor.set(new int[]{1,5}, getDoubleValue(drumBrakeMap.get("outD").toString()));
            drumRotor.set(new int[]{1,6}, getDoubleValue(drumBrakeMap.get("inD").toString()));
            // rotor thick
            double rotorThick = 21980d;
            if (drumBrakeMap.get("rtType").toString().equals("Drum")) {
                rotorThick = Double.valueOf(drumBrakeMap.get("rtThick").toString());
            } else {
                rotorThick = Double.valueOf(drumBrakeMap.get("rtT").toString());
            }
            drumRotor.set(new int[]{1,7}, rotorThick);
            // rotor width
            double rotorWidth = 42d;
            if (drumBrakeMap.get("rtType").toString().equals("Drum")) {
                rotorWidth = getDoubleValue(drumBrakeMap.get("rtWidth").toString());
            }
            drumRotor.set(new int[]{1,8}, rotorWidth);
            // rib thick
            double ribThick = 14d;
            if (drumBrakeMap.get("rtType").toString().equals("Drum")) {
                ribThick = getDoubleValue(drumBrakeMap.get("ribThick").toString());
            } else if (drumBrakeMap.get("rtType").toString().equals("Vented")) {
                ribThick = getDoubleValue(drumBrakeMap.get("vanT").toString());
            }
            drumRotor.set(new int[]{1,9}, ribThick);
            // rib width
            double ribWidth = 14d;
            if (drumBrakeMap.get("rtType").toString().equals("Drum")) {
                ribWidth = getDoubleValue(drumBrakeMap.get("ribWidth").toString());
            } else if (drumBrakeMap.get("rtType").toString().equals("Vented")) {
                ribWidth = getDoubleValue(drumBrakeMap.get("vaneLen").toString());
            }
            drumRotor.set(new int[]{1,10}, ribWidth);
            drumRotor.set(new int[]{1,11}, getDoubleValue(drumBrakeMap.get("wm").toString()));
            drumRotor.set(new int[]{1,12}, getDoubleValue(drumBrakeMap.get("wa").toString()));
            drumRotor.set(new int[]{1,13}, getDoubleValue(drumBrakeMap.get("rho").toString()));
            drumRotor.set(new int[]{1,14}, getDoubleValue(drumBrakeMap.get("cc50").toString()));
            drumRotor.set(new int[]{1,15}, getDoubleValue(drumBrakeMap.get("cc80").toString()));
            drumRotor.set(new int[]{1,16}, getDoubleValue(drumBrakeMap.get("cvr50").toString()));//rrCVR50
            drumRotor.set(new int[]{1,17}, getDoubleValue(drumBrakeMap.get("cvr80").toString()));//rrCVR80
            drumRotor.set(new int[]{1,18}, rrRtT);
            drumRotor.set(new int[]{1,19}, rrRtCP);
            // requirement !!!!
            MWCellArray requirement = new MWCellArray(new int[]{1, 19});
            List<Object> brakeStop = (List<Object>) requireMap.get("brakeStop");
            List<Object> bet = (List<Object>) requireMap.get("bet");
            List<Object> pedalFeel = (List<Object>) requireMap.get("pedalFeel");
            // 热模型结果
            requirement.set(new int[]{1,1}, getDoubleValue(requireMap.get("linV0").toString()));
            requirement.set(new int[]{1,2}, getDoubleValue(requireMap.get("linVi").toString()));
//            requirement.set(new int[]{1,3}, Double.parseDouble(requireMap.get("frtLinPwr").toString()));
            requirement.set(new int[]{1,3}, 0.85);
            // 制动距离模型
            requirement.set(new int[]{1,4}, getDoubleValue(String.valueOf(brakeStop.get(1))));
            requirement.set(new int[]{1,5}, getDoubleValue(String.valueOf(brakeStop.get(9))));
            requirement.set(new int[]{1,6}, getDoubleValue(String.valueOf(brakeStop.get(13))));
            requirement.set(new int[]{1,7}, getDoubleValue(String.valueOf(brakeStop.get(2))));
            requirement.set(new int[]{1,8}, getDoubleValue(String.valueOf(brakeStop.get(10))));
            requirement.set(new int[]{1,9}, getDoubleValue(String.valueOf(brakeStop.get(14))));
            // BET模型输出
            requirement.set(new int[]{1,10}, getDoubleValue(String.valueOf(bet.get(0))));
            requirement.set(new int[]{1,11}, getDoubleValue(String.valueOf(bet.get(3))));
            requirement.set(new int[]{1,12}, getDoubleValue(String.valueOf(bet.get(6))));
            requirement.set(new int[]{1,13}, getDoubleValue(String.valueOf(bet.get(9))));
            requirement.set(new int[]{1,14}, getDoubleValue(String.valueOf(bet.get(12))));
            requirement.set(new int[]{1,15}, getDoubleValue(String.valueOf(bet.get(15))));
            requirement.set(new int[]{1,16}, getDoubleValue(String.valueOf(bet.get(18))));
            // calculate begin
            ManualCalculate calculate = new ManualCalculate();
            calculate.main(pedal, booster, masterCylinder, tyre, vehicle, absControl,
                    discCaliper, discRotor, drumCaliper, drumRotor, requirement);
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
            List<List<String>> abUrl = new ArrayList<List<String>>();
            List<String> titles = new ArrayList<String>();
            titles.add("Vehicle Deceleration .vs. Pedal Force");
            titles.add("Vehicle Deceleration .vs. Pedal Travel");
            titles.add("Pedal Force .vs. Pedal Travel");
            titles.add("Adhesion Coefficient .vs. Brake Strength");
            titles.add("Vehicle Deceleration .vs. Brake Pressure");
            titles.add("Vehicle Brake Torque .vs. Pedal Force");
            titles.add("Brake Volume .vs. Brake Pressure");
            titles.add("Piston Brake Torque .vs. Brake Pressure");
            titles.add("Front .vs. Rear Brake Pressure");
            titles.add("Brake Efficiency .vs. Decel");
            titles.add("Temperature of Front Corner");
            titles.add("Temperature of Rear Corner");
            for (int i = 1; i < 13; i ++) {
                List<String> pic = new ArrayList<String>();
                pic.add(titles.get(i-1));
                pic.add("/expert/img/figure"+ i +".png");
                abUrl.add(pic);
            }
            result.put("img", abUrl);
            result.put("numerical", getNewResult(params, resultAfterPath));
        } catch (MWException e) {
            e.printStackTrace();
        }
        return result;
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
                ssT.add(requirementMap.get("frtSglTmp").toString());
            } catch (Exception e) {
                ssT.add("--");
            }
            try {
                ssT.add(shBET.getRow(3).getCell(1).getRawValue());
            } catch (NullPointerException e) {
                ssT.add("--");
            }
            try {
                ssT.add(requirementMap.get("rrSglTmp").toString());
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
                lpT.add(requirementMap.get("frtLinPwr").toString());
            } catch (Exception e) {
                lpT.add("--");
            }
            try {
                lpT.add(shHot.getRow(1).getCell(1).getRawValue());
            } catch (NullPointerException e) {
                lpT.add("--");
            }
            try {
                lpT.add(requirementMap.get("rrLinPwr").toString());
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
                hfdT.add(requirementMap.get("frtHftPwr").toString());
            } catch (Exception e) {
                hfdT.add("--");
            }
            try {
                hfdT.add(shHot.getRow(3).getCell(1).getRawValue());
            } catch (NullPointerException e) {
                hfdT.add("--");
            }
            try {
                hfdT.add(requirementMap.get("rrHftPwr").toString());
            } catch (Exception e) {
                hfdT.add("--");
            }
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
                sdlpBS.add(brakeStop.get(24).toString());
            } catch (Exception e) {
                sdlpBS.add("--");
            }
            try {
                sdlpBS.add(shDistance.getRow(8).getCell(1).getRawValue());
            } catch (NullPointerException e) {
                sdlpBS.add("--");
            }
            try {
                sdlpBS.add(brakeStop.get(16).toString());
            } catch (Exception e) {
                sdlpBS.add("--");
            }
            try {
                sdlpBS.add(shDistance.getRow(7).getCell(1).getRawValue());
            } catch (NullPointerException e) {
                sdlpBS.add("--");
            }
            try {
                sdlpBS.add(brakeStop.get(20).toString());
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
                sdlnBS.add(brakeStop.get(25).toString());
            } catch (Exception e) {
                sdlnBS.add("--");
            }
            try {
                sdlnBS.add(shDistance.getRow(2).getCell(1).getRawValue());
            } catch (NullPointerException e) {
                sdlnBS.add("--");
            }
            try {
                sdlnBS.add(brakeStop.get(17).toString());
            } catch (Exception e) {
                sdlnBS.add("--");
            }
            try {
                sdlnBS.add(shDistance.getRow(1).getCell(1).getRawValue());
            } catch (NullPointerException e) {
                sdlnBS.add("--");
            }
            try {
                sdlnBS.add(brakeStop.get(21).toString());
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
                sdgpBS.add(brakeStop.get(16).toString());
            } catch (Exception e) {
                sdgpBS.add("--");
            }
            try {
                sdgpBS.add(shDistance.getRow(11).getCell(1).getRawValue());
            } catch (NullPointerException e) {
                sdgpBS.add("--");
            }
            try {
                sdgpBS.add(brakeStop.get(18).toString());
            } catch (Exception e) {
                sdgpBS.add("--");
            }            try {
                sdgpBS.add(shDistance.getRow(10).getCell(1).getRawValue());
            } catch (NullPointerException e) {
                sdgpBS.add("--");
            }
            try {
                sdgpBS.add(brakeStop.get(22).toString());
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
                sdgnBS.add(brakeStop.get(19).toString());
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
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
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
        // test thread
//        Runnable myRunnable = new SaveToXlsx();
//        Thread thread = new Thread(myRunnable);
//        thread.start();
//        System.out.println("main thread");
//        int a = 100;
//        String b = String.valueOf("");
//        System.out.println(String.valueOf(a));
//        System.out.println(b);
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

    public static Double getDoubleValue(String value) {
        if (value.equals("")) {
            return null;
        }
        return Double.valueOf(value);
    }

    public static Map<String, Double> PFCurve2Param(Map<String, Object> params) {
        double hfP = getDoubleValue(params.get("hfP").toString());
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
            result = manualCalculate.PfCurve2Param(2,hfP,pstArea,pstNum,efcR,linMu);
            coeff.put("linMuK", getDoubleValue(result[0].toString()));
            coeff.put("linMuE", getDoubleValue(result[1].toString()));
        } catch (MWException e) {
            e.printStackTrace();
        }
        return coeff;
    }

    public static Map<String, Double> PVCurve2Param(Map<String, Object> params) {
        double hfP = getDoubleValue(params.get("hfP").toString());
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
            result = manualCalculate.PVCurve2Param(3,hfP,pVcurve);
            coeff.put("pvK", getDoubleValue(result[0].toString()));
            coeff.put("pvB", getDoubleValue(result[1].toString()));
            coeff.put("pvC", getDoubleValue(result[1].toString()));
        } catch (MWException e) {
            e.printStackTrace();
        }
        return coeff;
    }
}
