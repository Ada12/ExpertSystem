package entity;

import javax.persistence.*;

/**
 * Created by yangchen on 2018/3/13.
 */
@Entity
@Table(name = "basic_disc_brake", schema = "expert_system", catalog = "")
public class BasicDiscBrakeEntity {
    private int id;
    private String description;
    private String frtType;
    private String frtManu;
    private Double pstD;
    private Integer pstNum;
    private Double pstArea;
    private Double hfPT;
    private Double hfPV;
    private String pVcurve;
    private Double pvK;
    private Double pvB;
    private Double pvC;
    private String linSpl;
    private String linMat;
    private String linMu;
    private Double linMuK;
    private Double linMuE;
    private Double linMuNp;
    private Double linArea;
    private Double linWearLim;
    private String frtRtTempIn;
    private String frtLinWearOut;
    private String frtLinFrictOut;
    private Double inPerCorner;
    private Integer rtId;
    private String rtType;
    private Integer isWork;
    private String notes;
    private Integer userId;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
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
    @Column(name = "frt_type")
    public String getFrtType() {
        return frtType;
    }

    public void setFrtType(String frtType) {
        this.frtType = frtType;
    }

    @Basic
    @Column(name = "frt_manu")
    public String getFrtManu() {
        return frtManu;
    }

    public void setFrtManu(String frtManu) {
        this.frtManu = frtManu;
    }

    @Basic
    @Column(name = "pst_d")
    public Double getPstD() {
        return pstD;
    }

    public void setPstD(Double pstD) {
        this.pstD = pstD;
    }

    @Basic
    @Column(name = "pst_num")
    public Integer getPstNum() {
        return pstNum;
    }

    public void setPstNum(Integer pstNum) {
        this.pstNum = pstNum;
    }

    @Basic
    @Column(name = "pst_area")
    public Double getPstArea() {
        return pstArea;
    }

    public void setPstArea(Double pstArea) {
        this.pstArea = pstArea;
    }

    @Basic
    @Column(name = "hf_P_T")
    public Double getHfPT() {
        return hfPT;
    }

    public void setHfPT(Double hfPT) {
        this.hfPT = hfPT;
    }

    @Basic
    @Column(name = "hf_P_V")
    public Double getHfPV() {
        return hfPV;
    }

    public void setHfPV(Double hfPV) {
        this.hfPV = hfPV;
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
    @Column(name = "lin_spl")
    public String getLinSpl() {
        return linSpl;
    }

    public void setLinSpl(String linSpl) {
        this.linSpl = linSpl;
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
    public String getLinMu() {
        return linMu;
    }

    public void setLinMu(String linMu) {
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
    @Column(name = "in_per_corner")
    public Double getInPerCorner() {
        return inPerCorner;
    }

    public void setInPerCorner(Double inPerCorner) {
        this.inPerCorner = inPerCorner;
    }

    @Basic
    @Column(name = "rt_id")
    public Integer getRtId() {
        return rtId;
    }

    public void setRtId(Integer rtId) {
        this.rtId = rtId;
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
    @Column(name = "is_work")
    public Integer getIsWork() {
        return isWork;
    }

    public void setIsWork(Integer isWork) {
        this.isWork = isWork;
    }

    @Basic
    @Column(name = "notes")
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Basic
    @Column(name = "user_id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BasicDiscBrakeEntity that = (BasicDiscBrakeEntity) o;

        if (id != that.id) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (frtType != null ? !frtType.equals(that.frtType) : that.frtType != null) return false;
        if (frtManu != null ? !frtManu.equals(that.frtManu) : that.frtManu != null) return false;
        if (pstD != null ? !pstD.equals(that.pstD) : that.pstD != null) return false;
        if (pstNum != null ? !pstNum.equals(that.pstNum) : that.pstNum != null) return false;
        if (pstArea != null ? !pstArea.equals(that.pstArea) : that.pstArea != null) return false;
        if (hfPT != null ? !hfPT.equals(that.hfPT) : that.hfPT != null) return false;
        if (hfPV != null ? !hfPV.equals(that.hfPV) : that.hfPV != null) return false;
        if (pVcurve != null ? !pVcurve.equals(that.pVcurve) : that.pVcurve != null) return false;
        if (pvK != null ? !pvK.equals(that.pvK) : that.pvK != null) return false;
        if (pvB != null ? !pvB.equals(that.pvB) : that.pvB != null) return false;
        if (pvC != null ? !pvC.equals(that.pvC) : that.pvC != null) return false;
        if (linSpl != null ? !linSpl.equals(that.linSpl) : that.linSpl != null) return false;
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
        if (inPerCorner != null ? !inPerCorner.equals(that.inPerCorner) : that.inPerCorner != null) return false;
        if (rtId != null ? !rtId.equals(that.rtId) : that.rtId != null) return false;
        if (rtType != null ? !rtType.equals(that.rtType) : that.rtType != null) return false;
        if (isWork != null ? !isWork.equals(that.isWork) : that.isWork != null) return false;
        if (notes != null ? !notes.equals(that.notes) : that.notes != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (frtType != null ? frtType.hashCode() : 0);
        result = 31 * result + (frtManu != null ? frtManu.hashCode() : 0);
        result = 31 * result + (pstD != null ? pstD.hashCode() : 0);
        result = 31 * result + (pstNum != null ? pstNum.hashCode() : 0);
        result = 31 * result + (pstArea != null ? pstArea.hashCode() : 0);
        result = 31 * result + (hfPT != null ? hfPT.hashCode() : 0);
        result = 31 * result + (hfPV != null ? hfPV.hashCode() : 0);
        result = 31 * result + (pVcurve != null ? pVcurve.hashCode() : 0);
        result = 31 * result + (pvK != null ? pvK.hashCode() : 0);
        result = 31 * result + (pvB != null ? pvB.hashCode() : 0);
        result = 31 * result + (pvC != null ? pvC.hashCode() : 0);
        result = 31 * result + (linSpl != null ? linSpl.hashCode() : 0);
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
        result = 31 * result + (inPerCorner != null ? inPerCorner.hashCode() : 0);
        result = 31 * result + (rtId != null ? rtId.hashCode() : 0);
        result = 31 * result + (rtType != null ? rtType.hashCode() : 0);
        result = 31 * result + (isWork != null ? isWork.hashCode() : 0);
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }
}
