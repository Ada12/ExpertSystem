package entity;

import javax.persistence.*;

/**
 * Created by yangchen on 2018/4/3.
 */
@Entity
@Table(name = "lib_caliper", schema = "expert_system", catalog = "")
public class LibCaliperEntity {
    private int id;
    private String description;
    private String type;
    private String manu;
    private Double pstD;
    private Integer pstNum;
    private Double pstArea;
    private Double hfPT;
    private Double hfPV;
    private String pVcurve;
    private Double pvK;
    private Double pvB;
    private Double pvC;
    private Integer userId;
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
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "manu")
    public String getManu() {
        return manu;
    }

    public void setManu(String manu) {
        this.manu = manu;
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
    @Column(name = "user_id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

        LibCaliperEntity that = (LibCaliperEntity) o;

        if (id != that.id) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (manu != null ? !manu.equals(that.manu) : that.manu != null) return false;
        if (pstD != null ? !pstD.equals(that.pstD) : that.pstD != null) return false;
        if (pstNum != null ? !pstNum.equals(that.pstNum) : that.pstNum != null) return false;
        if (pstArea != null ? !pstArea.equals(that.pstArea) : that.pstArea != null) return false;
        if (hfPT != null ? !hfPT.equals(that.hfPT) : that.hfPT != null) return false;
        if (hfPV != null ? !hfPV.equals(that.hfPV) : that.hfPV != null) return false;
        if (pVcurve != null ? !pVcurve.equals(that.pVcurve) : that.pVcurve != null) return false;
        if (pvK != null ? !pvK.equals(that.pvK) : that.pvK != null) return false;
        if (pvB != null ? !pvB.equals(that.pvB) : that.pvB != null) return false;
        if (pvC != null ? !pvC.equals(that.pvC) : that.pvC != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (notes != null ? !notes.equals(that.notes) : that.notes != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (manu != null ? manu.hashCode() : 0);
        result = 31 * result + (pstD != null ? pstD.hashCode() : 0);
        result = 31 * result + (pstNum != null ? pstNum.hashCode() : 0);
        result = 31 * result + (pstArea != null ? pstArea.hashCode() : 0);
        result = 31 * result + (hfPT != null ? hfPT.hashCode() : 0);
        result = 31 * result + (hfPV != null ? hfPV.hashCode() : 0);
        result = 31 * result + (pVcurve != null ? pVcurve.hashCode() : 0);
        result = 31 * result + (pvK != null ? pvK.hashCode() : 0);
        result = 31 * result + (pvB != null ? pvB.hashCode() : 0);
        result = 31 * result + (pvC != null ? pvC.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        return result;
    }
}
