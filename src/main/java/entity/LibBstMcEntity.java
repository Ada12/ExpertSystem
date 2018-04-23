package entity;

import javax.persistence.*;

/**
 * Created by yangchen on 2018/4/3.
 */
@Entity
@Table(name = "lib_bst_mc", schema = "expert_system", catalog = "")
public class LibBstMcEntity {
    private int id;
    private String description;
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
    private Double bstVcum;
    private Double bstVcumAlt;
    private String mcSpl;
    private Double mcD;
    private Double mcFEff;
    private Double mcTEff;
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
    @Column(name = "bst_vcum")
    public Double getBstVcum() {
        return bstVcum;
    }

    public void setBstVcum(Double bstVcum) {
        this.bstVcum = bstVcum;
    }

    @Basic
    @Column(name = "bst_vcum_alt")
    public Double getBstVcumAlt() {
        return bstVcumAlt;
    }

    public void setBstVcumAlt(Double bstVcumAlt) {
        this.bstVcumAlt = bstVcumAlt;
    }

    @Basic
    @Column(name = "mc_spl")
    public String getMcSpl() {
        return mcSpl;
    }

    public void setMcSpl(String mcSpl) {
        this.mcSpl = mcSpl;
    }

    @Basic
    @Column(name = "mc_d")
    public Double getMcD() {
        return mcD;
    }

    public void setMcD(Double mcD) {
        this.mcD = mcD;
    }

    @Basic
    @Column(name = "mc_F_eff")
    public Double getMcFEff() {
        return mcFEff;
    }

    public void setMcFEff(Double mcFEff) {
        this.mcFEff = mcFEff;
    }

    @Basic
    @Column(name = "mc_T_eff")
    public Double getMcTEff() {
        return mcTEff;
    }

    public void setMcTEff(Double mcTEff) {
        this.mcTEff = mcTEff;
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

        LibBstMcEntity that = (LibBstMcEntity) o;

        if (id != that.id) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
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
        if (bstVcum != null ? !bstVcum.equals(that.bstVcum) : that.bstVcum != null) return false;
        if (bstVcumAlt != null ? !bstVcumAlt.equals(that.bstVcumAlt) : that.bstVcumAlt != null) return false;
        if (mcSpl != null ? !mcSpl.equals(that.mcSpl) : that.mcSpl != null) return false;
        if (mcD != null ? !mcD.equals(that.mcD) : that.mcD != null) return false;
        if (mcFEff != null ? !mcFEff.equals(that.mcFEff) : that.mcFEff != null) return false;
        if (mcTEff != null ? !mcTEff.equals(that.mcTEff) : that.mcTEff != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (notes != null ? !notes.equals(that.notes) : that.notes != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (description != null ? description.hashCode() : 0);
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
        result = 31 * result + (bstVcum != null ? bstVcum.hashCode() : 0);
        result = 31 * result + (bstVcumAlt != null ? bstVcumAlt.hashCode() : 0);
        result = 31 * result + (mcSpl != null ? mcSpl.hashCode() : 0);
        result = 31 * result + (mcD != null ? mcD.hashCode() : 0);
        result = 31 * result + (mcFEff != null ? mcFEff.hashCode() : 0);
        result = 31 * result + (mcTEff != null ? mcTEff.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        return result;
    }
}
