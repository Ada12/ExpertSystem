package service;

import com.mathworks.toolbox.javabuilder.*;
import ExternalMatlab.*;
import com.mathworks.toolbox.javabuilder.statemanager.ObjectNotFoundException;

import java.util.ArrayList;
import java.io.*;

/**
 * Created by yangchen on 17/12/17.
 */
public class MatlabManualCalculate {

    public static void main(String[] args) {
        try {
            // Pedal param
            // Object[] pedal1 = new Object[]{3,1,1,"sanli"};
            MWCellArray pedal = new MWCellArray(new int[]{1, 4});
            pedal.set(new int[]{1,1}, 3d);
            pedal.set(new int[]{1,2}, 1d);
            pedal.set(new int[]{1,3}, 1d);
            pedal.set(new int[]{1,4}, "sanli");
            // booster param
            // Object[] booster1 = new Object[]{10,6,2360,0.95,0.85,320,80,320,2,"SABS"};
            MWCellArray booster = new MWCellArray(new int[]{1,10});
            booster.set(new int[]{1,1}, 9d);
            booster.set(new int[]{1,2}, 7.2);
            booster.set(new int[]{1,3}, 2300d);
            booster.set(new int[]{1,4}, 0.95);
            booster.set(new int[]{1,5}, 0.85);
            booster.set(new int[]{1,6}, 320d);
            booster.set(new int[]{1,7}, 80d);
            booster.set(new int[]{1,8}, 320d);
            booster.set(new int[]{1,9}, 2d);
            booster.set(new int[]{1,10}, "SABS");
            //  master cylinder
            // Object[] masterCylinder = new Object[]{19.05,1,1,"SABS"};
            MWCellArray masterCylinder = new MWCellArray(new int[]{1,4});
            masterCylinder.set(new int[]{1,1}, 19.05);
            masterCylinder.set(new int[]{1,2}, 1d);
            masterCylinder.set(new int[]{1,3}, 1d);
            masterCylinder.set(new int[]{1,4}, "SABS");
            // tyre
            // Object[] rollResis = new Object[]{};
            MWNumericArray rollResis = new MWNumericArray();
            // MWArray rollResis = new MWArray();
            //Object[] tyre = new Object[]{292,292,292,292,1.07,0.7,0.9,0.1,rollResis};
            MWCellArray tyre = new MWCellArray(new int[]{1,9});
            tyre.set(new int[]{1,1}, 292d);
            tyre.set(new int[]{1,2}, 292d);
            tyre.set(new int[]{1,3}, 292d);
            tyre.set(new int[]{1,4}, 292d);
            tyre.set(new int[]{1,5}, 1.07);
            tyre.set(new int[]{1,6}, 0.7);
            tyre.set(new int[]{1,7}, 0.9);
            tyre.set(new int[]{1,8}, 0.1);
            tyre.set(new int[]{1,9}, rollResis);
            // vehicle
            // Object[] vehicle = new Object[]{"SGM318",2015,"F","NB",1250,0.584,565,1490,0.514,565,2499,170,0.05,0.35,2};
            MWCellArray vehicle = new MWCellArray(new int[]{1,15});
            vehicle.set(new int[]{1,1}, "SGM318");
            vehicle.set(new int[]{1,2}, 2015d);
            vehicle.set(new int[]{1,3}, "F");
            vehicle.set(new int[]{1,4}, "NB");
            vehicle.set(new int[]{1,5}, 1250d);
            vehicle.set(new int[]{1,6}, 0.584);
            vehicle.set(new int[]{1,7}, 565d);
            vehicle.set(new int[]{1,8}, 1490d);
            vehicle.set(new int[]{1,9}, 0.514);
            vehicle.set(new int[]{1,10}, 565d);
            vehicle.set(new int[]{1,11}, 2499d);
            vehicle.set(new int[]{1,12}, 170d);
            vehicle.set(new int[]{1,13}, 0.05);
            vehicle.set(new int[]{1,14}, 0.35);
            vehicle.set(new int[]{1,15}, 2d);
            // ABSControl
            // Object[] absControl = new Object[]{"","",0.93,0.93};
            MWCellArray absControl = new MWCellArray(new int[]{1,4});
            absControl.set(new int[]{1,1}, ":BWI");
            absControl.set(new int[]{1,2}, ":DBC7.8");
            absControl.set(new int[]{1,3}, 0.93);
            absControl.set(new int[]{1,4}, 0.93);
            // frt/disc caliper
            // MWNumericArray frtPstArea = new MWNumericArray();
            MWNumericArray frtPVCurve = new MWNumericArray(new double[]{500, 0.2, 5000, 0.63, 12000, 1.1}, MWClassID.DOUBLE);
            // MWNumericArray frtPVK = new MWNumericArray();
            // MWNumericArray frtPVB = new MWNumericArray();
            // MWNumericArray frtPVC = new MWNumericArray();
            MWNumericArray frtLinMu = new MWNumericArray(new double[]{500, 0.32, 5000, 0.36, 12000, 0.4});
            MWNumericArray frtBrkFactor = new MWNumericArray();
            // MWNumericArray frtLinMuK = new MWNumericArray();
            // MWNumericArray frtLinMuE = new MWNumericArray();
            MWNumericArray frtLinT = new MWNumericArray(new double[]{100, 150, 200, 250, 300, 350, 400});
            MWNumericArray frtLinCP = new MWNumericArray();
            MWNumericArray frtLinCP1 = new MWNumericArray();
            // Object[] discCaliper = new Object[]{"Conti",51,1,frtPstArea,100,frtPVCurve,
            // frtPVK,frtPVB,frtPVC,"FM","Low Mat(#)","TBD",frtLinMu,frtBrkFactor,frtLinMuK,
            // frtLinMuE,0.4,0.8,3430,11,frtLinT,frtLinCP,frtLinCP1};
            MWCellArray discCaliper = new MWCellArray(new int[]{1,23});
            discCaliper.set(new int[]{1,1}, "Conti");
            discCaliper.set(new int[]{1,2}, 52d);
            discCaliper.set(new int[]{1,3}, 1d);
            discCaliper.set(new int[]{1,4}, 2123.7);
            discCaliper.set(new int[]{1,5}, 100d);
            discCaliper.set(new int[]{1,6}, frtPVCurve);
            discCaliper.set(new int[]{1,7}, 0.0671);
            discCaliper.set(new int[]{1,8}, 0.301);
            discCaliper.set(new int[]{1,9}, 2.354);
            discCaliper.set(new int[]{1,10}, "FM");
            discCaliper.set(new int[]{1,11}, "Low Mat(#)");
            discCaliper.set(new int[]{1,12}, "TBD");
            discCaliper.set(new int[]{1,13}, frtLinMu);
            discCaliper.set(new int[]{1,14}, frtBrkFactor);
            discCaliper.set(new int[]{1,15}, 0d);
            discCaliper.set(new int[]{1,16}, 0d);
            discCaliper.set(new int[]{1,17}, 0.4);
            discCaliper.set(new int[]{1,18}, 0.8);
            discCaliper.set(new int[]{1,19}, 3430d);
            discCaliper.set(new int[]{1,20}, 11d);
            discCaliper.set(new int[]{1,21}, frtLinT);
            discCaliper.set(new int[]{1,22}, frtLinCP);
            discCaliper.set(new int[]{1,23}, frtLinCP1);
            // frt/disc rotor
            MWNumericArray frtWorkMass = new MWNumericArray();
            MWNumericArray frtWorkArea = new MWNumericArray();
            MWNumericArray frtCC50 = new MWNumericArray();
            MWNumericArray frtCC80 = new MWNumericArray();
            MWNumericArray frtRtT = new MWNumericArray(new double[]{20, 100, 200, 300, 400, 500});
            MWNumericArray frtRtCP = new MWNumericArray(new double[]{492, 511, 532, 549, 569, 588});
            // Object[] discRotor = new Object[]{"Vented","SHAC",0,102.5,256,146,22,6,6,44,42,9.2,5,
            // frtWorkMass,frtWorkArea,7100,frtCC50,frtCC80,0.026,0.026,frtRtT,frtRtCP};
            MWCellArray discRotor = new MWCellArray(new int[]{1,22});
            discRotor.set(new int[]{1,1}, "Vented");
            discRotor.set(new int[]{1,2}, "SHAC");
            discRotor.set(new int[]{1,3}, 0d);
            discRotor.set(new int[]{1,4}, 102.5);
            discRotor.set(new int[]{1,5}, 256d);
            discRotor.set(new int[]{1,6}, 146d);
            discRotor.set(new int[]{1,7}, 22d);
            discRotor.set(new int[]{1,8}, 6d);
            discRotor.set(new int[]{1,9}, 6d);
            discRotor.set(new int[]{1,10}, 44d);
            discRotor.set(new int[]{1,11}, 42d);
            discRotor.set(new int[]{1,12}, 9.2);
            discRotor.set(new int[]{1,13}, 5d);
            discRotor.set(new int[]{1,14}, 3.6151);
            discRotor.set(new int[]{1,15}, frtWorkArea);
            discRotor.set(new int[]{1,16}, 7100d);
            discRotor.set(new int[]{1,17}, frtCC50);
            discRotor.set(new int[]{1,18}, frtCC80);
            discRotor.set(new int[]{1,19}, 0.026);
            discRotor.set(new int[]{1,20}, 0.026);
            discRotor.set(new int[]{1,21}, frtRtT);
            discRotor.set(new int[]{1,22}, frtRtCP);
            // rr/drum caliper
            MWNumericArray rrPstArea = new MWNumericArray();
            MWNumericArray rrPVCurve = new MWNumericArray(new double[]{500, 1.1, 5000, 2.2, 12000, 3.2});
            MWNumericArray rrPVK = new MWNumericArray();
            MWNumericArray rrPVB = new MWNumericArray();
            MWNumericArray rrPVC = new MWNumericArray();
            MWNumericArray rrLinMu = new MWNumericArray(new double[]{500, 0.82, 5000, 0.86, 12000, 0.9});
            MWNumericArray rrBrkFactor = new MWNumericArray();
            MWNumericArray rrLinMuK = new MWNumericArray();
            MWNumericArray rrLinMuE = new MWNumericArray();
            MWNumericArray rrLinT = new MWNumericArray(new double[]{100, 150, 200, 250, 300, 350, 400});
            MWNumericArray rrLinCP = new MWNumericArray(new double[]{0.08, 0.17, 0.15, 0.08, 0.13, 0.2, 0.7});
            MWNumericArray rrLinCP1 = new MWNumericArray(new double[]{0.08, 0.17, 0.15, 0.08, 0.13, 0.2, 0.7});
//            MWNumericArray rrRtT = new MWNumericArray(new double[]{});
//            MWNumericArray rrRtCP = new MWNumericArray(new double[]{});
            // Object[] drumCaliper = new Object[]{"BWI",19.05,1,rrPstArea,400,rrPVCurve,
            // rrPVK,rrPVB,rrPVC,"SB","DO4-A","TBD",rrLinMu,rrBrkFactor,rrLinMuK,
            // rrLinMuE,0.825,1.65,5779,5,rrLinT,rrLinCP,rrLinCP1};
            MWCellArray drumCaliper = new MWCellArray(new int[]{1,23});
            drumCaliper.set(new int[]{1,1}, "BWI");
            drumCaliper.set(new int[]{1,2}, 19.05);
            drumCaliper.set(new int[]{1,3}, 1d);
            drumCaliper.set(new int[]{1,4}, rrPstArea);
            drumCaliper.set(new int[]{1,5}, 400d);
            drumCaliper.set(new int[]{1,6}, rrPVCurve);
            drumCaliper.set(new int[]{1,7}, rrPVK);
            drumCaliper.set(new int[]{1,8}, rrPVB);
            drumCaliper.set(new int[]{1,9}, rrPVC);
            drumCaliper.set(new int[]{1,10}, "SB");
            drumCaliper.set(new int[]{1,11}, "DO4-A");
            drumCaliper.set(new int[]{1,12}, "TBD");
            drumCaliper.set(new int[]{1,13}, rrLinMu);
            drumCaliper.set(new int[]{1,14}, rrBrkFactor);
            drumCaliper.set(new int[]{1,15}, rrLinMuK);
            drumCaliper.set(new int[]{1,16}, rrLinMuE);
            drumCaliper.set(new int[]{1,17}, 0.825);
            drumCaliper.set(new int[]{1,18}, 1.65);
            drumCaliper.set(new int[]{1,19}, 5779d);
            drumCaliper.set(new int[]{1,20}, 5d);
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
            MWNumericArray rrRtT = new MWNumericArray(new double[]{20, 100, 200, 300, 400, 500});
            MWNumericArray rrRtCP = new MWNumericArray(new double[]{492, 511, 532, 549, 569, 588});
            // Object[] drumRotor = new Object[]{"Drum","SHAC",21980,102.5,216,100,8,42,
            // 14,14,rrWorkMass,rrWorkArea,7100,rrCC50,rrCC80,rrCVR50,rrCVR80,rrRtT,rrRtCP};
            MWCellArray drumRotor = new MWCellArray(new int[]{1, 19});
            drumRotor.set(new int[]{1,1}, "Drum");
            drumRotor.set(new int[]{1,2}, "SHAC");
            drumRotor.set(new int[]{1,3}, 21980d);
            drumRotor.set(new int[]{1,4}, 102.5);
            drumRotor.set(new int[]{1,5}, 216d);
            drumRotor.set(new int[]{1,6}, 100d);
            drumRotor.set(new int[]{1,7}, 8d);
            drumRotor.set(new int[]{1,8}, 42d);
            drumRotor.set(new int[]{1,9}, 14d);
            drumRotor.set(new int[]{1,10}, 14d);
            drumRotor.set(new int[]{1,11}, 0d);//rrWorkMass
            drumRotor.set(new int[]{1,12}, 0d);//rrWorkArea
            drumRotor.set(new int[]{1,13}, 7100d);
            drumRotor.set(new int[]{1,14}, 0);//rrCC50
            drumRotor.set(new int[]{1,15}, 0);//rrCC80
            drumRotor.set(new int[]{1,16}, 0.025);//rrCVR50
            drumRotor.set(new int[]{1,17}, 0.025);//rrCVR80
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
            System.out.println("==============================");
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
}
