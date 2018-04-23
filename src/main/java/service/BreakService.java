package service;

import dao.BreakDao;
import entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yangchen on 17/7/1.
 */
@Transactional
@Service
public class BreakService {

    @Autowired
    private BreakDao breakDao;

//    public VehicleEntity getMostSim(VehicleEntity input, int flag){
//        List<VehicleEntity> list = breakDao.getAllVehicles();
//        int vId = list.get(0).getId();
//        // lvw_w 1268
//        // lvw_hg 550
//        // lvw_wr 0.6
//        // gvm_w 1504
//        // gvm_hg 548
//        // gvm_wr 0.5
//        // car_l 2490
//        // car_slr 292
//        if (flag == 0) {
//            double weight = Math.pow((list.get(0).getLvwW() - input.getLvwW())/1268, 2) + Math.pow((list.get(0).getLvwHg() - input.getLvwHg())/550, 2)
//                    + Math.pow((list.get(0).getLvwWr() - input.getLvwWr())/0.6, 2) + Math.pow((list.get(0).getCarL() - input.getCarL())/2490, 2)
//                    + Math.pow((list.get(0).getCarSlr() - input.getCarSlr())/292, 2);;
//            for (int i = 0; i < list.size(); i ++) {
//                VehicleEntity standard = list.get(i);
//                double nowWeight = Math.pow((standard.getLvwW() - input.getLvwW())/1268, 2) + Math.pow((standard.getLvwHg() - input.getLvwHg())/550, 2)
//                        + Math.pow((standard.getLvwWr() - input.getLvwWr())/0.6, 2) + Math.pow((standard.getCarL() - input.getCarL())/2490, 2)
//                        + Math.pow((standard.getCarSlr() - input.getCarSlr())/292, 2);
//                if (nowWeight < weight) {
//                    weight = nowWeight;
//                    vId = standard.getId();
//                }
//                System.out.println("the " + i + ":" + weight);
//            }
//        } else {
//            double weight = Math.pow((list.get(0).getGvwW() - input.getGvwW())/1504, 2) + Math.pow((list.get(0).getGvwHg() - input.getGvwHg())/548, 2)
//                    + Math.pow((list.get(0).getGvwWr() - input.getGvwWr())/0.5, 2) + Math.pow((list.get(0).getCarL() - input.getCarL())/2490, 2)
//                    + Math.pow((list.get(0).getCarSlr() - input.getCarSlr())/292, 2);;
//            for (int i = 0; i < list.size(); i ++) {
//                VehicleEntity standard = list.get(i);
//                double nowWeight = Math.pow((standard.getGvwW() - input.getGvwW())/1504, 2) + Math.pow((standard.getGvwHg() - input.getGvwHg())/548, 2)
//                        + Math.pow((standard.getGvwWr() - input.getGvwWr())/0.5, 2) + Math.pow((standard.getCarL() - input.getCarL())/2490, 2)
//                        + Math.pow((standard.getCarSlr() - input.getCarSlr())/292, 2);
//                if (nowWeight < weight) {
//                    weight = nowWeight;
//                    vId = standard.getId();
//                }
//            }
//        }
//        VehicleEntity similar = breakDao.getSingleVehicle(vId);
//        return similar;
//    }
//
//    public Map<String, List<String[]>> geneAllAttriValue(InstanceLibEntity entity) {
//        Map<String, List<String[]>> allAttriValue = new HashMap<String, List<String[]>>();
//        // get booster_mc
//        BoosterMcEntity boosterMcEntity = breakDao.getBoosterMc(entity.getBstMc());
//        List<String[]> boosterMcContent = new ArrayList<String[]>();
//        String[] bm0 = {"id", "id", String.valueOf(boosterMcEntity.getId()), getUnits("id")};
//        boosterMcContent.add(bm0);
//        String[] bm1 = {"apply_vw", "apply_vw", boosterMcEntity.getApplyVw().toString(), getUnits("apply_vw")};
//        boosterMcContent.add(bm1);
//        String[] bm2 = {"Booster size", "bst_size", boosterMcEntity.getBstSize().toString(), getUnits("bst_size")};
//        boosterMcContent.add(bm2);
//        String[] bm3 = {"Booster Gain", "bst_gain", boosterMcEntity.getBstGain().toString(), getUnits("bst_gain")};
//        boosterMcContent.add(bm3);
//        String[] bm4 = {"Total Booster Force", "bst_F_total", boosterMcEntity.getBstFTotal().toString(), getUnits("bst_F_total")};
//        boosterMcContent.add(bm4);
//        String[] bm5 = {"Booster Force Efficiency", "bst_F_eff", boosterMcEntity.getBstFEff().toString(), getUnits("bst_F_eff")};
//        boosterMcContent.add(bm5);
//        String[] bm6 = {"Booster Travel Efficiency", "bst_T_eff", boosterMcEntity.getBstTEff().toString(), getUnits("bst_T_eff")};
//        boosterMcContent.add(bm6);
//        String[] bm7 = {"Force Loss – No Power", "bst_F_ls_np", boosterMcEntity.getBstFLsNp().toString(), getUnits("bst_F_ls_np")};
//        boosterMcContent.add(bm7);
//        String[] bm8 = {"Force Loss – with Power", "bst_F_ls_wp", boosterMcEntity.getBstFLsWp().toString(), getUnits("bst_F_ls_wp")};
//        boosterMcContent.add(bm8);
//        String[] bm9 = {"Jump in Force", "bst_F_jmp", boosterMcEntity.getBstFJmp().toString(), getUnits("bst_F_jmp")};
//        boosterMcContent.add(bm9);
//        String[] bm10 = {"Travel Loss", "bst_T_ls", boosterMcEntity.getBstTLs().toString(), getUnits("bst_T_ls")};
//        boosterMcContent.add(bm10);
//        String[] bm11 = {"mcd Bore Diameter", "mcd_d", boosterMcEntity.getMcdD().toString(), getUnits("mcd_d")};
//        boosterMcContent.add(bm11);
//        String[] bm12 = {"mcd Travel Efficiency", "mcd_travel", boosterMcEntity.getMcdTravel().toString(), getUnits("mcd_travel")};
//        boosterMcContent.add(bm12);
//        String[] bm13 = {"Master Cylinder Supplier", "bst_mc_spl", boosterMcEntity.getBstMcSpl(), getUnits("bst_mc_spl")};
//        boosterMcContent.add(bm13);
//        allAttriValue.put("bst_mc", boosterMcContent);
//
//        DiscCaliperEntity discCaliperEntity = breakDao.getDiscCaliper(entity.getFrtCaliper());
//        List<String[]> discCaliperContent = new ArrayList<String[]>();
//        String[] dc0 = {"id", "id", String.valueOf(discCaliperEntity.getId()), getUnits("id")};
//        discCaliperContent.add(dc0);
//        String[] dc1 = {"discC_ID", "discC_ID", discCaliperEntity.getDiscCId().toString(), getUnits("discC_ID")};
//        discCaliperContent.add(dc1);
//        String[] dc2 = {"apply_vw", "apply_vw", discCaliperEntity.getApplyVw().toString(), getUnits("apply_vw")};
//        discCaliperContent.add(dc2);
//        String[] dc3 = {"Caliper Type", "clp_type", discCaliperEntity.getClpType().toString(), getUnits("clp_type")};
//        discCaliperContent.add(dc3);
//        String[] dc4 = {"Caliper Piston Diameter", "pst_d", discCaliperEntity.getPstD().toString(), getUnits("pst_d")};
//        discCaliperContent.add(dc4);
//        String[] dc5 = {"# of Piston per Caliper", "pst_num", discCaliperEntity.getPstNum().toString(), getUnits("pst_num")};
//        discCaliperContent.add(dc5);
//        String[] dc6 = {"Caliper hold off Pressure", "hf_P", discCaliperEntity.getHfP().toString(), getUnits("hf_P")};
//        discCaliperContent.add(dc6);
//        String[] dc7 = {"Caliper PV curve", "PVcurve", discCaliperEntity.getpVcurve().toString(), getUnits("PVcurve")};
//        discCaliperContent.add(dc7);
//        String[] dc8 = {"Post-bunished lining mu", "lin_mu", discCaliperEntity.getLinMu().toString(), getUnits("lin_mu")};
//        discCaliperContent.add(dc8);
//        String[] dc9 = {"Lining Wear Limit", "lin_wear_lim", discCaliperEntity.getLinWearLim().toString(), getUnits("lin_wear_lim")};
//        discCaliperContent.add(dc9);
//        String[] dc10 = {"Lining Material", "lin_mat", discCaliperEntity.getLinMat().toString(), getUnits("lin_mat")};
//        discCaliperContent.add(dc10);
//        allAttriValue.put("frt_caliper", discCaliperContent);
//
//        DiscRotorEntity discRotorEntity = breakDao.getDiscRotor(entity.getFrtRotor());
//        List<String[]> discRotorContent = new ArrayList<String[]>();
//        String[] dr0 = {"id", "id", String.valueOf(discRotorEntity.getId()), getUnits("id")};
//        discRotorContent.add(dr0);
//        String[] dr1 = {"discR_ID", "discR_ID", discRotorEntity.getDiscRId().toString(), getUnits("discR_ID")};
//        discRotorContent.add(dr1);
//        String[] dr2 = {"apply_vw", "apply_vw", discRotorEntity.getApplyVw().toString(), getUnits("apply_vw")};
//        discRotorContent.add(dr2);
//        String[] dr3 = {"Rotor Type", "rt_type", discRotorEntity.getRtType().toString(), getUnits("rt_type")};
//        discRotorContent.add(dr3);
//        String[] dr4 = {"Rotor Effective Radius", "rt_efc_r", discRotorEntity.getRtEfcR().toString(), getUnits("rt_efc_r")};
//        discRotorContent.add(dr4);
//        String[] dr5 = {"Rotor Outer Diameter", "rt_dia_out", discRotorEntity.getRtDiaOut().toString(), getUnits("rt_dia_out")};
//        discRotorContent.add(dr5);
//        String[] dr6 = {"Rotor Manufacturer", "rt_mat", discRotorEntity.getRtMat().toString(), getUnits("rt_mat")};
//        discRotorContent.add(dr6);
//        allAttriValue.put("frt_rotor", discRotorContent);
//
//        DrumCaliperEntity drumCaliperEntity = breakDao.getDrumCaliper(entity.getRrCaliper());
//        List<String[]> drumCaliperContent = new ArrayList<String[]>();
//        String[] duc0 = {"id", "id", String.valueOf(drumCaliperEntity.getId()), getUnits("id")};
//        drumCaliperContent.add(duc0);
//        String[] duc1 = {"drumC_ID", "drumC_ID", drumCaliperEntity.getDrumCId().toString(), getUnits("drumC_ID")};
//        drumCaliperContent.add(duc1);
//        String[] duc2 = {"apply_vw", "apply_vw", drumCaliperEntity.getApplyVw().toString(), getUnits("apply_vw")};
//        drumCaliperContent.add(duc2);
//        String[] duc3 = {"Caliper Type", "clp_type", drumCaliperEntity.getClpType().toString(), getUnits("clp_type")};
//        drumCaliperContent.add(duc3);
//        String[] duc4 = {"Caliper Piston Diameter", "pst_d", drumCaliperEntity.getPstD().toString(), getUnits("pst_d")};
//        drumCaliperContent.add(duc4);
//        String[] duc5 = {"# of Piston per Caliper", "pst_num", drumCaliperEntity.getPstNum().toString(), getUnits("pst_num")};
//        drumCaliperContent.add(duc5);
//        String[] duc6 = {"Caliper hold off Pressure", "hf_P", drumCaliperEntity.getHfP().toString(), getUnits("hf_P")};
//        drumCaliperContent.add(duc6);
//        String[] duc7 = {"Caliper PV curve", "PVcurve", drumCaliperEntity.getpVcurve().toString(), getUnits("PVcurve")};
//        drumCaliperContent.add(duc7);
//        String[] duc8 = {"Post-bunished lining mu", "lin_mu", drumCaliperEntity.getLinMu().toString(), getUnits("lin_mu")};
//        drumCaliperContent.add(duc8);
//        String[] duc9 = {"Lining Wear Limit", "lin_wear_lim", drumCaliperEntity.getLinWearLim().toString(), getUnits("lin_wear_lim")};
//        drumCaliperContent.add(duc9);
//        String[] duc10 = {"Lining Material", "lin_mat", drumCaliperEntity.getLinMat().toString(), getUnits("lin_mat")};
//        drumCaliperContent.add(duc10);
//        allAttriValue.put("rr_caliper", drumCaliperContent);
//
//        DrumRotorEntity drumRotorEntity = breakDao.getDrumRotor(entity.getRrRotor());
//        List<String[]> drumRotorContent = new ArrayList<String[]>();
//        String[] dur0 = {"id", "id", String.valueOf(drumRotorEntity.getId()), getUnits("id")};
//        drumRotorContent.add(dur0);
//        String[] dur1 = {"discR_ID", "drumR_ID", drumRotorEntity.getDrumRId().toString(), getUnits("drumR_ID")};
//        drumRotorContent.add(dur1);
//        String[] dur2 = {"apply_vw", "apply_vw", drumRotorEntity.getApplyVw().toString(), getUnits("apply_vw")};
//        drumRotorContent.add(dur2);
//        String[] dur3 = {"Rotor Type", "rt_type", drumRotorEntity.getRtType().toString(), getUnits("rt_type")};
//        drumRotorContent.add(dur3);
//        String[] dur4 = {"Rotor Effective Radius", "rt_efc_r", drumRotorEntity.getRtEfcR().toString(), getUnits("rt_efc_r")};
//        drumRotorContent.add(dur4);
//        String[] dur5 = {"Rotor Outer Diameter", "rt_dia_out", drumRotorEntity.getRtDiaOut().toString(), getUnits("rt_dia_out")};
//        drumRotorContent.add(dur5);
//        String[] dur6 = {"Rotor Manufacturer", "rt_mat", drumRotorEntity.getRtMat().toString(), getUnits("rt_mat")};
//        drumRotorContent.add(dur6);
//        allAttriValue.put("rr_rotor", drumRotorContent);
//
//        PedalEntity pedalEntity = breakDao.getPedal(entity.getPed());
//        List<String[]> pedalContent = new ArrayList<String[]>();
//        String[] ped0 = {"id", "id", String.valueOf(pedalEntity.getId()), getUnits("id")};
//        pedalContent.add(ped0);
//        String[] ped1 = {"Pedal type", "ped_type", pedalEntity.getPedType().toString(), getUnits("ped_type")};
//        pedalContent.add(ped1);
//        String[] ped2 = {"Pedal Ratio", "ped_ratio", pedalEntity.getPedRatio().toString(), getUnits("ped_ratio")};
//        pedalContent.add(ped2);
//        String[] ped3 = {"Pedal Force Efficiency", "ped_F_eff", pedalEntity.getPedFEff().toString(), getUnits("ped_F_eff")};
//        pedalContent.add(ped3);
//        String[] ped4 = {"Pedal Travel Efficiency", "ped_T_eff", pedalEntity.getPedTEff().toString(), getUnits("ped_T_eff")};
//        pedalContent.add(ped4);
//        String[] ped5 = {"Pedal Supplier", "ped_spl", pedalEntity.getPedSpl().toString(), getUnits("ped_spl")};
//        pedalContent.add(ped5);
//        allAttriValue.put("pedal", pedalContent);
//        return allAttriValue;
//    }
//
//    public String getUnits(String attri) {
//        List<UnitsEntity> unitsEntities = breakDao.getAllUnits();
//        Map<String, String> units = new HashMap<String, String>();
//        for (int i = 0; i < unitsEntities.size(); i ++) {
//            units.put(unitsEntities.get(i).getAttriName(), unitsEntities.get(i).getUnitName());
//        }
//        String unit = units.get(attri);
//        if ((unit == null)||(unit == "")) {
//            unit = "--";
//        }
//        return unit;
//    }
//
//    public VehicleEntity getVehicle(int id) {
//        return breakDao.getVehicle(id);
//    }

    public int saveInstance(InstanceLibEntity entity) {
        return breakDao.saveInstance(entity);
    }

    public InstanceLibEntity getInstance(int id) {
        return breakDao.getInstance(id);
    }

    public List<InstanceLibEntity> getAllInstances(int userId) {
        return breakDao.getAllInstance(userId);
    }
}
