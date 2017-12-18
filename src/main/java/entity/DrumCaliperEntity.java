package entity;

import javax.persistence.*;

/**
 * Created by yangchen on 17/7/1.
 */
@Entity
@Table(name = "drum_caliper", schema = "expert_system", catalog = "")
public class DrumCaliperEntity {
    private int id;
    private String drumCId;
    private String applyVw;
    private String clpType;
    private Double pstD;
    private Integer pstNum;
    private Double hfP;
    private String pVcurve;
    private Double linMu;
    private String linWearLim;
    private String linMat;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "drumC_ID")
    public String getDrumCId() {
        return drumCId;
    }

    public void setDrumCId(String drumCId) {
        this.drumCId = drumCId;
    }

    @Basic
    @Column(name = "apply_vw")
    public String getApplyVw() {
        return applyVw;
    }

    public void setApplyVw(String applyVw) {
        this.applyVw = applyVw;
    }

    @Basic
    @Column(name = "clp_type")
    public String getClpType() {
        return clpType;
    }

    public void setClpType(String clpType) {
        this.clpType = clpType;
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
    @Column(name = "hf_P")
    public Double getHfP() {
        return hfP;
    }

    public void setHfP(Double hfP) {
        this.hfP = hfP;
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
    @Column(name = "lin_mu")
    public Double getLinMu() {
        return linMu;
    }

    public void setLinMu(Double linMu) {
        this.linMu = linMu;
    }

    @Basic
    @Column(name = "lin_wear_lim")
    public String getLinWearLim() {
        return linWearLim;
    }

    public void setLinWearLim(String linWearLim) {
        this.linWearLim = linWearLim;
    }

    @Basic
    @Column(name = "lin_mat")
    public String getLinMat() {
        return linMat;
    }

    public void setLinMat(String linMat) {
        this.linMat = linMat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DrumCaliperEntity that = (DrumCaliperEntity) o;

        if (id != that.id) return false;
        if (drumCId != null ? !drumCId.equals(that.drumCId) : that.drumCId != null) return false;
        if (applyVw != null ? !applyVw.equals(that.applyVw) : that.applyVw != null) return false;
        if (clpType != null ? !clpType.equals(that.clpType) : that.clpType != null) return false;
        if (pstD != null ? !pstD.equals(that.pstD) : that.pstD != null) return false;
        if (pstNum != null ? !pstNum.equals(that.pstNum) : that.pstNum != null) return false;
        if (hfP != null ? !hfP.equals(that.hfP) : that.hfP != null) return false;
        if (pVcurve != null ? !pVcurve.equals(that.pVcurve) : that.pVcurve != null) return false;
        if (linMu != null ? !linMu.equals(that.linMu) : that.linMu != null) return false;
        if (linWearLim != null ? !linWearLim.equals(that.linWearLim) : that.linWearLim != null) return false;
        if (linMat != null ? !linMat.equals(that.linMat) : that.linMat != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (drumCId != null ? drumCId.hashCode() : 0);
        result = 31 * result + (applyVw != null ? applyVw.hashCode() : 0);
        result = 31 * result + (clpType != null ? clpType.hashCode() : 0);
        result = 31 * result + (pstD != null ? pstD.hashCode() : 0);
        result = 31 * result + (pstNum != null ? pstNum.hashCode() : 0);
        result = 31 * result + (hfP != null ? hfP.hashCode() : 0);
        result = 31 * result + (pVcurve != null ? pVcurve.hashCode() : 0);
        result = 31 * result + (linMu != null ? linMu.hashCode() : 0);
        result = 31 * result + (linWearLim != null ? linWearLim.hashCode() : 0);
        result = 31 * result + (linMat != null ? linMat.hashCode() : 0);
        return result;
    }
}
