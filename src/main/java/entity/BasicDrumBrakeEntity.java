package entity;

import javax.persistence.*;

/**
 * Created by yangchen on 17/12/23.
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
    private Double inPerCorner;
    private String rtType;
    private Integer rtId;
    private String notes;

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
    @Column(name = "in_per_corner")
    public Double getInPerCorner() {
        return inPerCorner;
    }

    public void setInPerCorner(Double inPerCorner) {
        this.inPerCorner = inPerCorner;
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
    @Column(name = "rt_id")
    public Integer getRtId() {
        return rtId;
    }

    public void setRtId(Integer rtId) {
        this.rtId = rtId;
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
        if (inPerCorner != null ? !inPerCorner.equals(that.inPerCorner) : that.inPerCorner != null) return false;
        if (rtType != null ? !rtType.equals(that.rtType) : that.rtType != null) return false;
        if (rtId != null ? !rtId.equals(that.rtId) : that.rtId != null) return false;
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
        result = 31 * result + (inPerCorner != null ? inPerCorner.hashCode() : 0);
        result = 31 * result + (rtType != null ? rtType.hashCode() : 0);
        result = 31 * result + (rtId != null ? rtId.hashCode() : 0);
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        return result;
    }
}
