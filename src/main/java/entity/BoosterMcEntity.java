package entity;

import javax.persistence.*;

/**
 * Created by yangchen on 17/9/21.
 */
@Entity
@Table(name = "booster_mc", schema = "expert_system", catalog = "")
public class BoosterMcEntity {
    private int id;
    private Double applyVw;
    private Double bstSize;
    private Double bstGain;
    private Double bstFTotal;
    private Double bstFEff;
    private Double bstTEff;
    private Double bstFLsNp;
    private Double bstFLsWp;
    private Double bstFJmp;
    private Double bstTLs;
    private Double mcdD;
    private Double mcdTravel;
    private String bstMcSpl;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "apply_vw")
    public Double getApplyVw() {
        return applyVw;
    }

    public void setApplyVw(Double applyVw) {
        this.applyVw = applyVw;
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
    @Column(name = "mcd_d")
    public Double getMcdD() {
        return mcdD;
    }

    public void setMcdD(Double mcdD) {
        this.mcdD = mcdD;
    }

    @Basic
    @Column(name = "mcd_travel")
    public Double getMcdTravel() {
        return mcdTravel;
    }

    public void setMcdTravel(Double mcdTravel) {
        this.mcdTravel = mcdTravel;
    }

    @Basic
    @Column(name = "bst_mc_spl")
    public String getBstMcSpl() {
        return bstMcSpl;
    }

    public void setBstMcSpl(String bstMcSpl) {
        this.bstMcSpl = bstMcSpl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BoosterMcEntity that = (BoosterMcEntity) o;

        if (id != that.id) return false;
        if (applyVw != null ? !applyVw.equals(that.applyVw) : that.applyVw != null) return false;
        if (bstSize != null ? !bstSize.equals(that.bstSize) : that.bstSize != null) return false;
        if (bstGain != null ? !bstGain.equals(that.bstGain) : that.bstGain != null) return false;
        if (bstFTotal != null ? !bstFTotal.equals(that.bstFTotal) : that.bstFTotal != null) return false;
        if (bstFEff != null ? !bstFEff.equals(that.bstFEff) : that.bstFEff != null) return false;
        if (bstTEff != null ? !bstTEff.equals(that.bstTEff) : that.bstTEff != null) return false;
        if (bstFLsNp != null ? !bstFLsNp.equals(that.bstFLsNp) : that.bstFLsNp != null) return false;
        if (bstFLsWp != null ? !bstFLsWp.equals(that.bstFLsWp) : that.bstFLsWp != null) return false;
        if (bstFJmp != null ? !bstFJmp.equals(that.bstFJmp) : that.bstFJmp != null) return false;
        if (bstTLs != null ? !bstTLs.equals(that.bstTLs) : that.bstTLs != null) return false;
        if (mcdD != null ? !mcdD.equals(that.mcdD) : that.mcdD != null) return false;
        if (mcdTravel != null ? !mcdTravel.equals(that.mcdTravel) : that.mcdTravel != null) return false;
        if (bstMcSpl != null ? !bstMcSpl.equals(that.bstMcSpl) : that.bstMcSpl != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (applyVw != null ? applyVw.hashCode() : 0);
        result = 31 * result + (bstSize != null ? bstSize.hashCode() : 0);
        result = 31 * result + (bstGain != null ? bstGain.hashCode() : 0);
        result = 31 * result + (bstFTotal != null ? bstFTotal.hashCode() : 0);
        result = 31 * result + (bstFEff != null ? bstFEff.hashCode() : 0);
        result = 31 * result + (bstTEff != null ? bstTEff.hashCode() : 0);
        result = 31 * result + (bstFLsNp != null ? bstFLsNp.hashCode() : 0);
        result = 31 * result + (bstFLsWp != null ? bstFLsWp.hashCode() : 0);
        result = 31 * result + (bstFJmp != null ? bstFJmp.hashCode() : 0);
        result = 31 * result + (bstTLs != null ? bstTLs.hashCode() : 0);
        result = 31 * result + (mcdD != null ? mcdD.hashCode() : 0);
        result = 31 * result + (mcdTravel != null ? mcdTravel.hashCode() : 0);
        result = 31 * result + (bstMcSpl != null ? bstMcSpl.hashCode() : 0);
        return result;
    }
}
