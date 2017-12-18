package entity;

import javax.persistence.*;

/**
 * Created by yangchen on 17/11/18.
 */
@Entity
@Table(name = "basic_drum_brake", schema = "expert_system", catalog = "")
public class BasicDrumBrakeEntity {
    private int id;
    private String description;
    private Double cDia;
    private Integer pstNum;
    private Double pstArea;
    private Double cHp;
    private String pVcurve;
    private Double pvK;
    private Double pvB;
    private Double pvC;
    private String linMat;
    private Double linMu;
    private Double linMuK;
    private Double linMuE;
    private Double linMuNp;
    private Double linArea;
    private Double linWearLim;
    private String frtRtTempIn;
    private String frtLinWearOut;
    private String frtLinFrictOut;
    private Double perCorner;
    private String rtType;
    private Double rtEfcR;
    private Double odDm;
    private Double idDm;
    private String thDm;
    private String wdDm;
    private Double jthDm;
    private Double rtVaneHigh;
    private Double rtWm;
    private Double rtWa;
    private Double rho;
    private Double cc50;
    private Double cc80;
    private Double cvr50;
    private Double cvr80;
    private String rtTempIn;
    private String rtSpecOut;
    private String notes;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "C_dia")
    public Double getcDia() {
        return cDia;
    }

    public void setcDia(Double cDia) {
        this.cDia = cDia;
    }

    @Basic
    @Column(name = "Pst_num")
    public Integer getPstNum() {
        return pstNum;
    }

    public void setPstNum(Integer pstNum) {
        this.pstNum = pstNum;
    }

    @Basic
    @Column(name = "Pst_area")
    public Double getPstArea() {
        return pstArea;
    }

    public void setPstArea(Double pstArea) {
        this.pstArea = pstArea;
    }

    @Basic
    @Column(name = "C_hp")
    public Double getcHp() {
        return cHp;
    }

    public void setcHp(Double cHp) {
        this.cHp = cHp;
    }

    @Basic
    @Column(name = "PVcurve")
    public String getpVcurve() {
        return pVcurve;
    }

    public void setpVcurve(String pVcurve) {
        this.pVcurve = pVcurve;
    }

    @Basic
    @Column(name = "PV_k")
    public Double getPvK() {
        return pvK;
    }

    public void setPvK(Double pvK) {
        this.pvK = pvK;
    }

    @Basic
    @Column(name = "PV_b")
    public Double getPvB() {
        return pvB;
    }

    public void setPvB(Double pvB) {
        this.pvB = pvB;
    }

    @Basic
    @Column(name = "PV_c")
    public Double getPvC() {
        return pvC;
    }

    public void setPvC(Double pvC) {
        this.pvC = pvC;
    }

    @Basic
    @Column(name = "lin_mat")
    public String getLinMat() {
        return linMat;
    }

    public void setLinMat(String linMat) {
        this.linMat = linMat;
    }

    @Basic
    @Column(name = "lin_mu")
    public Double getLinMu() {
        return linMu;
    }

    public void setLinMu(Double linMu) {
        this.linMu = linMu;
    }

    @Basic
    @Column(name = "lin_mu_k")
    public Double getLinMuK() {
        return linMuK;
    }

    public void setLinMuK(Double linMuK) {
        this.linMuK = linMuK;
    }

    @Basic
    @Column(name = "lin_mu_e")
    public Double getLinMuE() {
        return linMuE;
    }

    public void setLinMuE(Double linMuE) {
        this.linMuE = linMuE;
    }

    @Basic
    @Column(name = "lin_mu_np")
    public Double getLinMuNp() {
        return linMuNp;
    }

    public void setLinMuNp(Double linMuNp) {
        this.linMuNp = linMuNp;
    }

    @Basic
    @Column(name = "lin_area")
    public Double getLinArea() {
        return linArea;
    }

    public void setLinArea(Double linArea) {
        this.linArea = linArea;
    }

    @Basic
    @Column(name = "lin_wear_lim")
    public Double getLinWearLim() {
        return linWearLim;
    }

    public void setLinWearLim(Double linWearLim) {
        this.linWearLim = linWearLim;
    }

    @Basic
    @Column(name = "frt_rt_temp_in")
    public String getFrtRtTempIn() {
        return frtRtTempIn;
    }

    public void setFrtRtTempIn(String frtRtTempIn) {
        this.frtRtTempIn = frtRtTempIn;
    }

    @Basic
    @Column(name = "frt_lin_wear_out")
    public String getFrtLinWearOut() {
        return frtLinWearOut;
    }

    public void setFrtLinWearOut(String frtLinWearOut) {
        this.frtLinWearOut = frtLinWearOut;
    }

    @Basic
    @Column(name = "frt_lin_frict_out")
    public String getFrtLinFrictOut() {
        return frtLinFrictOut;
    }

    public void setFrtLinFrictOut(String frtLinFrictOut) {
        this.frtLinFrictOut = frtLinFrictOut;
    }

    @Basic
    @Column(name = "per_corner")
    public Double getPerCorner() {
        return perCorner;
    }

    public void setPerCorner(Double perCorner) {
        this.perCorner = perCorner;
    }

    @Basic
    @Column(name = "rt_type")
    public String getRtType() {
        return rtType;
    }

    public void setRtType(String rtType) {
        this.rtType = rtType;
    }

    @Basic
    @Column(name = "rt_efc_r")
    public Double getRtEfcR() {
        return rtEfcR;
    }

    public void setRtEfcR(Double rtEfcR) {
        this.rtEfcR = rtEfcR;
    }

    @Basic
    @Column(name = "Od_dm")
    public Double getOdDm() {
        return odDm;
    }

    public void setOdDm(Double odDm) {
        this.odDm = odDm;
    }

    @Basic
    @Column(name = "Id_dm")
    public Double getIdDm() {
        return idDm;
    }

    public void setIdDm(Double idDm) {
        this.idDm = idDm;
    }

    @Basic
    @Column(name = "Th_dm")
    public String getThDm() {
        return thDm;
    }

    public void setThDm(String thDm) {
        this.thDm = thDm;
    }

    @Basic
    @Column(name = "Wd_dm")
    public String getWdDm() {
        return wdDm;
    }

    public void setWdDm(String wdDm) {
        this.wdDm = wdDm;
    }

    @Basic
    @Column(name = "Jth_dm")
    public Double getJthDm() {
        return jthDm;
    }

    public void setJthDm(Double jthDm) {
        this.jthDm = jthDm;
    }

    @Basic
    @Column(name = "rt_vane_high")
    public Double getRtVaneHigh() {
        return rtVaneHigh;
    }

    public void setRtVaneHigh(Double rtVaneHigh) {
        this.rtVaneHigh = rtVaneHigh;
    }

    @Basic
    @Column(name = "rt_wm")
    public Double getRtWm() {
        return rtWm;
    }

    public void setRtWm(Double rtWm) {
        this.rtWm = rtWm;
    }

    @Basic
    @Column(name = "rt_wa")
    public Double getRtWa() {
        return rtWa;
    }

    public void setRtWa(Double rtWa) {
        this.rtWa = rtWa;
    }

    @Basic
    @Column(name = "rho")
    public Double getRho() {
        return rho;
    }

    public void setRho(Double rho) {
        this.rho = rho;
    }

    @Basic
    @Column(name = "CC_50")
    public Double getCc50() {
        return cc50;
    }

    public void setCc50(Double cc50) {
        this.cc50 = cc50;
    }

    @Basic
    @Column(name = "CC_80")
    public Double getCc80() {
        return cc80;
    }

    public void setCc80(Double cc80) {
        this.cc80 = cc80;
    }

    @Basic
    @Column(name = "CVR_50")
    public Double getCvr50() {
        return cvr50;
    }

    public void setCvr50(Double cvr50) {
        this.cvr50 = cvr50;
    }

    @Basic
    @Column(name = "CVR_80")
    public Double getCvr80() {
        return cvr80;
    }

    public void setCvr80(Double cvr80) {
        this.cvr80 = cvr80;
    }

    @Basic
    @Column(name = "rt_temp_in")
    public String getRtTempIn() {
        return rtTempIn;
    }

    public void setRtTempIn(String rtTempIn) {
        this.rtTempIn = rtTempIn;
    }

    @Basic
    @Column(name = "rt_spec_out")
    public String getRtSpecOut() {
        return rtSpecOut;
    }

    public void setRtSpecOut(String rtSpecOut) {
        this.rtSpecOut = rtSpecOut;
    }

    @Basic
    @Column(name = "notes")
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BasicDrumBrakeEntity that = (BasicDrumBrakeEntity) o;

        if (id != that.id) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (cDia != null ? !cDia.equals(that.cDia) : that.cDia != null) return false;
        if (pstNum != null ? !pstNum.equals(that.pstNum) : that.pstNum != null) return false;
        if (pstArea != null ? !pstArea.equals(that.pstArea) : that.pstArea != null) return false;
        if (cHp != null ? !cHp.equals(that.cHp) : that.cHp != null) return false;
        if (pVcurve != null ? !pVcurve.equals(that.pVcurve) : that.pVcurve != null) return false;
        if (pvK != null ? !pvK.equals(that.pvK) : that.pvK != null) return false;
        if (pvB != null ? !pvB.equals(that.pvB) : that.pvB != null) return false;
        if (pvC != null ? !pvC.equals(that.pvC) : that.pvC != null) return false;
        if (linMat != null ? !linMat.equals(that.linMat) : that.linMat != null) return false;
        if (linMu != null ? !linMu.equals(that.linMu) : that.linMu != null) return false;
        if (linMuK != null ? !linMuK.equals(that.linMuK) : that.linMuK != null) return false;
        if (linMuE != null ? !linMuE.equals(that.linMuE) : that.linMuE != null) return false;
        if (linMuNp != null ? !linMuNp.equals(that.linMuNp) : that.linMuNp != null) return false;
        if (linArea != null ? !linArea.equals(that.linArea) : that.linArea != null) return false;
        if (linWearLim != null ? !linWearLim.equals(that.linWearLim) : that.linWearLim != null) return false;
        if (frtRtTempIn != null ? !frtRtTempIn.equals(that.frtRtTempIn) : that.frtRtTempIn != null) return false;
        if (frtLinWearOut != null ? !frtLinWearOut.equals(that.frtLinWearOut) : that.frtLinWearOut != null)
            return false;
        if (frtLinFrictOut != null ? !frtLinFrictOut.equals(that.frtLinFrictOut) : that.frtLinFrictOut != null)
            return false;
        if (perCorner != null ? !perCorner.equals(that.perCorner) : that.perCorner != null) return false;
        if (rtType != null ? !rtType.equals(that.rtType) : that.rtType != null) return false;
        if (rtEfcR != null ? !rtEfcR.equals(that.rtEfcR) : that.rtEfcR != null) return false;
        if (odDm != null ? !odDm.equals(that.odDm) : that.odDm != null) return false;
        if (idDm != null ? !idDm.equals(that.idDm) : that.idDm != null) return false;
        if (thDm != null ? !thDm.equals(that.thDm) : that.thDm != null) return false;
        if (wdDm != null ? !wdDm.equals(that.wdDm) : that.wdDm != null) return false;
        if (jthDm != null ? !jthDm.equals(that.jthDm) : that.jthDm != null) return false;
        if (rtVaneHigh != null ? !rtVaneHigh.equals(that.rtVaneHigh) : that.rtVaneHigh != null) return false;
        if (rtWm != null ? !rtWm.equals(that.rtWm) : that.rtWm != null) return false;
        if (rtWa != null ? !rtWa.equals(that.rtWa) : that.rtWa != null) return false;
        if (rho != null ? !rho.equals(that.rho) : that.rho != null) return false;
        if (cc50 != null ? !cc50.equals(that.cc50) : that.cc50 != null) return false;
        if (cc80 != null ? !cc80.equals(that.cc80) : that.cc80 != null) return false;
        if (cvr50 != null ? !cvr50.equals(that.cvr50) : that.cvr50 != null) return false;
        if (cvr80 != null ? !cvr80.equals(that.cvr80) : that.cvr80 != null) return false;
        if (rtTempIn != null ? !rtTempIn.equals(that.rtTempIn) : that.rtTempIn != null) return false;
        if (rtSpecOut != null ? !rtSpecOut.equals(that.rtSpecOut) : that.rtSpecOut != null) return false;
        if (notes != null ? !notes.equals(that.notes) : that.notes != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (cDia != null ? cDia.hashCode() : 0);
        result = 31 * result + (pstNum != null ? pstNum.hashCode() : 0);
        result = 31 * result + (pstArea != null ? pstArea.hashCode() : 0);
        result = 31 * result + (cHp != null ? cHp.hashCode() : 0);
        result = 31 * result + (pVcurve != null ? pVcurve.hashCode() : 0);
        result = 31 * result + (pvK != null ? pvK.hashCode() : 0);
        result = 31 * result + (pvB != null ? pvB.hashCode() : 0);
        result = 31 * result + (pvC != null ? pvC.hashCode() : 0);
        result = 31 * result + (linMat != null ? linMat.hashCode() : 0);
        result = 31 * result + (linMu != null ? linMu.hashCode() : 0);
        result = 31 * result + (linMuK != null ? linMuK.hashCode() : 0);
        result = 31 * result + (linMuE != null ? linMuE.hashCode() : 0);
        result = 31 * result + (linMuNp != null ? linMuNp.hashCode() : 0);
        result = 31 * result + (linArea != null ? linArea.hashCode() : 0);
        result = 31 * result + (linWearLim != null ? linWearLim.hashCode() : 0);
        result = 31 * result + (frtRtTempIn != null ? frtRtTempIn.hashCode() : 0);
        result = 31 * result + (frtLinWearOut != null ? frtLinWearOut.hashCode() : 0);
        result = 31 * result + (frtLinFrictOut != null ? frtLinFrictOut.hashCode() : 0);
        result = 31 * result + (perCorner != null ? perCorner.hashCode() : 0);
        result = 31 * result + (rtType != null ? rtType.hashCode() : 0);
        result = 31 * result + (rtEfcR != null ? rtEfcR.hashCode() : 0);
        result = 31 * result + (odDm != null ? odDm.hashCode() : 0);
        result = 31 * result + (idDm != null ? idDm.hashCode() : 0);
        result = 31 * result + (thDm != null ? thDm.hashCode() : 0);
        result = 31 * result + (wdDm != null ? wdDm.hashCode() : 0);
        result = 31 * result + (jthDm != null ? jthDm.hashCode() : 0);
        result = 31 * result + (rtVaneHigh != null ? rtVaneHigh.hashCode() : 0);
        result = 31 * result + (rtWm != null ? rtWm.hashCode() : 0);
        result = 31 * result + (rtWa != null ? rtWa.hashCode() : 0);
        result = 31 * result + (rho != null ? rho.hashCode() : 0);
        result = 31 * result + (cc50 != null ? cc50.hashCode() : 0);
        result = 31 * result + (cc80 != null ? cc80.hashCode() : 0);
        result = 31 * result + (cvr50 != null ? cvr50.hashCode() : 0);
        result = 31 * result + (cvr80 != null ? cvr80.hashCode() : 0);
        result = 31 * result + (rtTempIn != null ? rtTempIn.hashCode() : 0);
        result = 31 * result + (rtSpecOut != null ? rtSpecOut.hashCode() : 0);
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        return result;
    }
}
