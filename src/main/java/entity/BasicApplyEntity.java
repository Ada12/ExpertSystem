package entity;

import javax.persistence.*;

/**
 * Created by yangchen on 2018/3/13.
 */
@Entity
@Table(name = "basic_apply", schema = "expert_system", catalog = "")
public class BasicApplyEntity {
    private int id;
    private String description;
    private String pedSpl;
    private String pedRatio;
    private Double pedFEff;
    private Double pedTEff;
    private Integer pedType;
    private String bstSpl;
    private Double bstSize;
    private Double bstGain;
    private Double bstFTotal;
    private Double bstFEff;
    private Double bstTEff;
    private Double bstFLsNp;
    private Double bstFLsWp;
    private Double bstFJmp;
    private Double bstTLs;
    private Double bstVcm;
    private Double altBstVcm;
    private String mcdSpl;
    private Double mcdD;
    private Double mcdFEff;
    private Double mcdTEff;
    private Double apyFEff;
    private Double apyTEff;
    private Integer isWork;
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
    @Column(name = "ped_spl")
    public String getPedSpl() {
        return pedSpl;
    }

    public void setPedSpl(String pedSpl) {
        this.pedSpl = pedSpl;
    }

    @Basic
    @Column(name = "ped_ratio")
    public String getPedRatio() {
        return pedRatio;
    }

    public void setPedRatio(String pedRatio) {
        this.pedRatio = pedRatio;
    }

    @Basic
    @Column(name = "ped_F_eff")
    public Double getPedFEff() {
        return pedFEff;
    }

    public void setPedFEff(Double pedFEff) {
        this.pedFEff = pedFEff;
    }

    @Basic
    @Column(name = "ped_T_eff")
    public Double getPedTEff() {
        return pedTEff;
    }

    public void setPedTEff(Double pedTEff) {
        this.pedTEff = pedTEff;
    }

    @Basic
    @Column(name = "ped_type")
    public Integer getPedType() {
        return pedType;
    }

    public void setPedType(Integer pedType) {
        this.pedType = pedType;
    }

    @Basic
    @Column(name = "bst_spl")
    public String getBstSpl() {
        return bstSpl;
    }

    public void setBstSpl(String bstSpl) {
        this.bstSpl = bstSpl;
    }

    @Basic
    @Column(name = "bst_size")
    public Double getBstSize() {
        return bstSize;
    }

    public void setBstSize(Double bstSize) {
        this.bstSize = bstSize;
    }

    @Basic
    @Column(name = "bst_gain")
    public Double getBstGain() {
        return bstGain;
    }

    public void setBstGain(Double bstGain) {
        this.bstGain = bstGain;
    }

    @Basic
    @Column(name = "bst_F_total")
    public Double getBstFTotal() {
        return bstFTotal;
    }

    public void setBstFTotal(Double bstFTotal) {
        this.bstFTotal = bstFTotal;
    }

    @Basic
    @Column(name = "bst_F_eff")
    public Double getBstFEff() {
        return bstFEff;
    }

    public void setBstFEff(Double bstFEff) {
        this.bstFEff = bstFEff;
    }

    @Basic
    @Column(name = "bst_T_eff")
    public Double getBstTEff() {
        return bstTEff;
    }

    public void setBstTEff(Double bstTEff) {
        this.bstTEff = bstTEff;
    }

    @Basic
    @Column(name = "bst_F_ls_np")
    public Double getBstFLsNp() {
        return bstFLsNp;
    }

    public void setBstFLsNp(Double bstFLsNp) {
        this.bstFLsNp = bstFLsNp;
    }

    @Basic
    @Column(name = "bst_F_ls_wp")
    public Double getBstFLsWp() {
        return bstFLsWp;
    }

    public void setBstFLsWp(Double bstFLsWp) {
        this.bstFLsWp = bstFLsWp;
    }

    @Basic
    @Column(name = "bst_F_jmp")
    public Double getBstFJmp() {
        return bstFJmp;
    }

    public void setBstFJmp(Double bstFJmp) {
        this.bstFJmp = bstFJmp;
    }

    @Basic
    @Column(name = "bst_T_ls")
    public Double getBstTLs() {
        return bstTLs;
    }

    public void setBstTLs(Double bstTLs) {
        this.bstTLs = bstTLs;
    }

    @Basic
    @Column(name = "bst_vcm")
    public Double getBstVcm() {
        return bstVcm;
    }

    public void setBstVcm(Double bstVcm) {
        this.bstVcm = bstVcm;
    }

    @Basic
    @Column(name = "alt_bst_vcm")
    public Double getAltBstVcm() {
        return altBstVcm;
    }

    public void setAltBstVcm(Double altBstVcm) {
        this.altBstVcm = altBstVcm;
    }

    @Basic
    @Column(name = "mcd_spl")
    public String getMcdSpl() {
        return mcdSpl;
    }

    public void setMcdSpl(String mcdSpl) {
        this.mcdSpl = mcdSpl;
    }

    @Basic
    @Column(name = "mcd_d")
    public Double getMcdD() {
        return mcdD;
    }

    public void setMcdD(Double mcdD) {
        this.mcdD = mcdD;
    }

    @Basic
    @Column(name = "mcd_F_eff")
    public Double getMcdFEff() {
        return mcdFEff;
    }

    public void setMcdFEff(Double mcdFEff) {
        this.mcdFEff = mcdFEff;
    }

    @Basic
    @Column(name = "mcd_T_eff")
    public Double getMcdTEff() {
        return mcdTEff;
    }

    public void setMcdTEff(Double mcdTEff) {
        this.mcdTEff = mcdTEff;
    }

    @Basic
    @Column(name = "apy_F_eff")
    public Double getApyFEff() {
        return apyFEff;
    }

    public void setApyFEff(Double apyFEff) {
        this.apyFEff = apyFEff;
    }

    @Basic
    @Column(name = "apy_T_eff")
    public Double getApyTEff() {
        return apyTEff;
    }

    public void setApyTEff(Double apyTEff) {
        this.apyTEff = apyTEff;
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

        BasicApplyEntity that = (BasicApplyEntity) o;

        if (id != that.id) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (pedSpl != null ? !pedSpl.equals(that.pedSpl) : that.pedSpl != null) return false;
        if (pedRatio != null ? !pedRatio.equals(that.pedRatio) : that.pedRatio != null) return false;
        if (pedFEff != null ? !pedFEff.equals(that.pedFEff) : that.pedFEff != null) return false;
        if (pedTEff != null ? !pedTEff.equals(that.pedTEff) : that.pedTEff != null) return false;
        if (pedType != null ? !pedType.equals(that.pedType) : that.pedType != null) return false;
        if (bstSpl != null ? !bstSpl.equals(that.bstSpl) : that.bstSpl != null) return false;
        if (bstSize != null ? !bstSize.equals(that.bstSize) : that.bstSize != null) return false;
        if (bstGain != null ? !bstGain.equals(that.bstGain) : that.bstGain != null) return false;
        if (bstFTotal != null ? !bstFTotal.equals(that.bstFTotal) : that.bstFTotal != null) return false;
        if (bstFEff != null ? !bstFEff.equals(that.bstFEff) : that.bstFEff != null) return false;
        if (bstTEff != null ? !bstTEff.equals(that.bstTEff) : that.bstTEff != null) return false;
        if (bstFLsNp != null ? !bstFLsNp.equals(that.bstFLsNp) : that.bstFLsNp != null) return false;
        if (bstFLsWp != null ? !bstFLsWp.equals(that.bstFLsWp) : that.bstFLsWp != null) return false;
        if (bstFJmp != null ? !bstFJmp.equals(that.bstFJmp) : that.bstFJmp != null) return false;
        if (bstTLs != null ? !bstTLs.equals(that.bstTLs) : that.bstTLs != null) return false;
        if (bstVcm != null ? !bstVcm.equals(that.bstVcm) : that.bstVcm != null) return false;
        if (altBstVcm != null ? !altBstVcm.equals(that.altBstVcm) : that.altBstVcm != null) return false;
        if (mcdSpl != null ? !mcdSpl.equals(that.mcdSpl) : that.mcdSpl != null) return false;
        if (mcdD != null ? !mcdD.equals(that.mcdD) : that.mcdD != null) return false;
        if (mcdFEff != null ? !mcdFEff.equals(that.mcdFEff) : that.mcdFEff != null) return false;
        if (mcdTEff != null ? !mcdTEff.equals(that.mcdTEff) : that.mcdTEff != null) return false;
        if (apyFEff != null ? !apyFEff.equals(that.apyFEff) : that.apyFEff != null) return false;
        if (apyTEff != null ? !apyTEff.equals(that.apyTEff) : that.apyTEff != null) return false;
        if (isWork != null ? !isWork.equals(that.isWork) : that.isWork != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (notes != null ? !notes.equals(that.notes) : that.notes != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (pedSpl != null ? pedSpl.hashCode() : 0);
        result = 31 * result + (pedRatio != null ? pedRatio.hashCode() : 0);
        result = 31 * result + (pedFEff != null ? pedFEff.hashCode() : 0);
        result = 31 * result + (pedTEff != null ? pedTEff.hashCode() : 0);
        result = 31 * result + (pedType != null ? pedType.hashCode() : 0);
        result = 31 * result + (bstSpl != null ? bstSpl.hashCode() : 0);
        result = 31 * result + (bstSize != null ? bstSize.hashCode() : 0);
        result = 31 * result + (bstGain != null ? bstGain.hashCode() : 0);
        result = 31 * result + (bstFTotal != null ? bstFTotal.hashCode() : 0);
        result = 31 * result + (bstFEff != null ? bstFEff.hashCode() : 0);
        result = 31 * result + (bstTEff != null ? bstTEff.hashCode() : 0);
        result = 31 * result + (bstFLsNp != null ? bstFLsNp.hashCode() : 0);
        result = 31 * result + (bstFLsWp != null ? bstFLsWp.hashCode() : 0);
        result = 31 * result + (bstFJmp != null ? bstFJmp.hashCode() : 0);
        result = 31 * result + (bstTLs != null ? bstTLs.hashCode() : 0);
        result = 31 * result + (bstVcm != null ? bstVcm.hashCode() : 0);
        result = 31 * result + (altBstVcm != null ? altBstVcm.hashCode() : 0);
        result = 31 * result + (mcdSpl != null ? mcdSpl.hashCode() : 0);
        result = 31 * result + (mcdD != null ? mcdD.hashCode() : 0);
        result = 31 * result + (mcdFEff != null ? mcdFEff.hashCode() : 0);
        result = 31 * result + (mcdTEff != null ? mcdTEff.hashCode() : 0);
        result = 31 * result + (apyFEff != null ? apyFEff.hashCode() : 0);
        result = 31 * result + (apyTEff != null ? apyTEff.hashCode() : 0);
        result = 31 * result + (isWork != null ? isWork.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        return result;
    }
}
