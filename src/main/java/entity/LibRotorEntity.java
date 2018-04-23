package entity;

import javax.persistence.*;

/**
 * Created by yangchen on 2018/4/7.
 */
@Entity
@Table(name = "lib_rotor", schema = "expert_system", catalog = "")
public class LibRotorEntity {
    private int id;
    private String description;
    private String type;
    private String manu;
    private String mat;
    private Double swpArea;
    private Double efcR;
    private Double dOut;
    private Double dIn;
    private Double rtThick;
    private Double ribThick;
    private Double ribWidth;
    private Double rtWidth;
    private String ckTIn;
    private String ckTOut;
    private Double thick;
    private Integer vaneNum;
    private Double vaneLen;
    private Double vaneHigh;
    private Double vaneThick;
    private Double wm;
    private Double wa;
    private Double rho;
    private Double cc50;
    private Double cc80;
    private Double cc110;
    private Double cvr50;
    private Double cvr80;
    private Double cvr110;
    private String tempIn;
    private String specOut;
    private Integer userId;
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
    @Column(name = "mat")
    public String getMat() {
        return mat;
    }

    public void setMat(String mat) {
        this.mat = mat;
    }

    @Basic
    @Column(name = "swp_area")
    public Double getSwpArea() {
        return swpArea;
    }

    public void setSwpArea(Double swpArea) {
        this.swpArea = swpArea;
    }

    @Basic
    @Column(name = "efc_r")
    public Double getEfcR() {
        return efcR;
    }

    public void setEfcR(Double efcR) {
        this.efcR = efcR;
    }

    @Basic
    @Column(name = "d_out")
    public Double getdOut() {
        return dOut;
    }

    public void setdOut(Double dOut) {
        this.dOut = dOut;
    }

    @Basic
    @Column(name = "d_in")
    public Double getdIn() {
        return dIn;
    }

    public void setdIn(Double dIn) {
        this.dIn = dIn;
    }

    @Basic
    @Column(name = "rt_thick")
    public Double getRtThick() {
        return rtThick;
    }

    public void setRtThick(Double rtThick) {
        this.rtThick = rtThick;
    }

    @Basic
    @Column(name = "rib_thick")
    public Double getRibThick() {
        return ribThick;
    }

    public void setRibThick(Double ribThick) {
        this.ribThick = ribThick;
    }

    @Basic
    @Column(name = "rib_width")
    public Double getRibWidth() {
        return ribWidth;
    }

    public void setRibWidth(Double ribWidth) {
        this.ribWidth = ribWidth;
    }

    @Basic
    @Column(name = "rt_width")
    public Double getRtWidth() {
        return rtWidth;
    }

    public void setRtWidth(Double rtWidth) {
        this.rtWidth = rtWidth;
    }

    @Basic
    @Column(name = "ck_t_in")
    public String getCkTIn() {
        return ckTIn;
    }

    public void setCkTIn(String ckTIn) {
        this.ckTIn = ckTIn;
    }

    @Basic
    @Column(name = "ck_t_out")
    public String getCkTOut() {
        return ckTOut;
    }

    public void setCkTOut(String ckTOut) {
        this.ckTOut = ckTOut;
    }

    @Basic
    @Column(name = "thick")
    public Double getThick() {
        return thick;
    }

    public void setThick(Double thick) {
        this.thick = thick;
    }

    @Basic
    @Column(name = "vane_num")
    public Integer getVaneNum() {
        return vaneNum;
    }

    public void setVaneNum(Integer vaneNum) {
        this.vaneNum = vaneNum;
    }

    @Basic
    @Column(name = "vane_len")
    public Double getVaneLen() {
        return vaneLen;
    }

    public void setVaneLen(Double vaneLen) {
        this.vaneLen = vaneLen;
    }

    @Basic
    @Column(name = "vane_high")
    public Double getVaneHigh() {
        return vaneHigh;
    }

    public void setVaneHigh(Double vaneHigh) {
        this.vaneHigh = vaneHigh;
    }

    @Basic
    @Column(name = "vane_thick")
    public Double getVaneThick() {
        return vaneThick;
    }

    public void setVaneThick(Double vaneThick) {
        this.vaneThick = vaneThick;
    }

    @Basic
    @Column(name = "wm")
    public Double getWm() {
        return wm;
    }

    public void setWm(Double wm) {
        this.wm = wm;
    }

    @Basic
    @Column(name = "wa")
    public Double getWa() {
        return wa;
    }

    public void setWa(Double wa) {
        this.wa = wa;
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
    @Column(name = "cc_50")
    public Double getCc50() {
        return cc50;
    }

    public void setCc50(Double cc50) {
        this.cc50 = cc50;
    }

    @Basic
    @Column(name = "cc_80")
    public Double getCc80() {
        return cc80;
    }

    public void setCc80(Double cc80) {
        this.cc80 = cc80;
    }

    @Basic
    @Column(name = "cc_110")
    public Double getCc110() {
        return cc110;
    }

    public void setCc110(Double cc110) {
        this.cc110 = cc110;
    }

    @Basic
    @Column(name = "cvr_50")
    public Double getCvr50() {
        return cvr50;
    }

    public void setCvr50(Double cvr50) {
        this.cvr50 = cvr50;
    }

    @Basic
    @Column(name = "cvr_80")
    public Double getCvr80() {
        return cvr80;
    }

    public void setCvr80(Double cvr80) {
        this.cvr80 = cvr80;
    }

    @Basic
    @Column(name = "cvr_110")
    public Double getCvr110() {
        return cvr110;
    }

    public void setCvr110(Double cvr110) {
        this.cvr110 = cvr110;
    }

    @Basic
    @Column(name = "temp_in")
    public String getTempIn() {
        return tempIn;
    }

    public void setTempIn(String tempIn) {
        this.tempIn = tempIn;
    }

    @Basic
    @Column(name = "spec_out")
    public String getSpecOut() {
        return specOut;
    }

    public void setSpecOut(String specOut) {
        this.specOut = specOut;
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

        LibRotorEntity that = (LibRotorEntity) o;

        if (id != that.id) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (manu != null ? !manu.equals(that.manu) : that.manu != null) return false;
        if (mat != null ? !mat.equals(that.mat) : that.mat != null) return false;
        if (swpArea != null ? !swpArea.equals(that.swpArea) : that.swpArea != null) return false;
        if (efcR != null ? !efcR.equals(that.efcR) : that.efcR != null) return false;
        if (dOut != null ? !dOut.equals(that.dOut) : that.dOut != null) return false;
        if (dIn != null ? !dIn.equals(that.dIn) : that.dIn != null) return false;
        if (rtThick != null ? !rtThick.equals(that.rtThick) : that.rtThick != null) return false;
        if (ribThick != null ? !ribThick.equals(that.ribThick) : that.ribThick != null) return false;
        if (ribWidth != null ? !ribWidth.equals(that.ribWidth) : that.ribWidth != null) return false;
        if (rtWidth != null ? !rtWidth.equals(that.rtWidth) : that.rtWidth != null) return false;
        if (ckTIn != null ? !ckTIn.equals(that.ckTIn) : that.ckTIn != null) return false;
        if (ckTOut != null ? !ckTOut.equals(that.ckTOut) : that.ckTOut != null) return false;
        if (thick != null ? !thick.equals(that.thick) : that.thick != null) return false;
        if (vaneNum != null ? !vaneNum.equals(that.vaneNum) : that.vaneNum != null) return false;
        if (vaneLen != null ? !vaneLen.equals(that.vaneLen) : that.vaneLen != null) return false;
        if (vaneHigh != null ? !vaneHigh.equals(that.vaneHigh) : that.vaneHigh != null) return false;
        if (vaneThick != null ? !vaneThick.equals(that.vaneThick) : that.vaneThick != null) return false;
        if (wm != null ? !wm.equals(that.wm) : that.wm != null) return false;
        if (wa != null ? !wa.equals(that.wa) : that.wa != null) return false;
        if (rho != null ? !rho.equals(that.rho) : that.rho != null) return false;
        if (cc50 != null ? !cc50.equals(that.cc50) : that.cc50 != null) return false;
        if (cc80 != null ? !cc80.equals(that.cc80) : that.cc80 != null) return false;
        if (cc110 != null ? !cc110.equals(that.cc110) : that.cc110 != null) return false;
        if (cvr50 != null ? !cvr50.equals(that.cvr50) : that.cvr50 != null) return false;
        if (cvr80 != null ? !cvr80.equals(that.cvr80) : that.cvr80 != null) return false;
        if (cvr110 != null ? !cvr110.equals(that.cvr110) : that.cvr110 != null) return false;
        if (tempIn != null ? !tempIn.equals(that.tempIn) : that.tempIn != null) return false;
        if (specOut != null ? !specOut.equals(that.specOut) : that.specOut != null) return false;
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
        result = 31 * result + (mat != null ? mat.hashCode() : 0);
        result = 31 * result + (swpArea != null ? swpArea.hashCode() : 0);
        result = 31 * result + (efcR != null ? efcR.hashCode() : 0);
        result = 31 * result + (dOut != null ? dOut.hashCode() : 0);
        result = 31 * result + (dIn != null ? dIn.hashCode() : 0);
        result = 31 * result + (rtThick != null ? rtThick.hashCode() : 0);
        result = 31 * result + (ribThick != null ? ribThick.hashCode() : 0);
        result = 31 * result + (ribWidth != null ? ribWidth.hashCode() : 0);
        result = 31 * result + (rtWidth != null ? rtWidth.hashCode() : 0);
        result = 31 * result + (ckTIn != null ? ckTIn.hashCode() : 0);
        result = 31 * result + (ckTOut != null ? ckTOut.hashCode() : 0);
        result = 31 * result + (thick != null ? thick.hashCode() : 0);
        result = 31 * result + (vaneNum != null ? vaneNum.hashCode() : 0);
        result = 31 * result + (vaneLen != null ? vaneLen.hashCode() : 0);
        result = 31 * result + (vaneHigh != null ? vaneHigh.hashCode() : 0);
        result = 31 * result + (vaneThick != null ? vaneThick.hashCode() : 0);
        result = 31 * result + (wm != null ? wm.hashCode() : 0);
        result = 31 * result + (wa != null ? wa.hashCode() : 0);
        result = 31 * result + (rho != null ? rho.hashCode() : 0);
        result = 31 * result + (cc50 != null ? cc50.hashCode() : 0);
        result = 31 * result + (cc80 != null ? cc80.hashCode() : 0);
        result = 31 * result + (cc110 != null ? cc110.hashCode() : 0);
        result = 31 * result + (cvr50 != null ? cvr50.hashCode() : 0);
        result = 31 * result + (cvr80 != null ? cvr80.hashCode() : 0);
        result = 31 * result + (cvr110 != null ? cvr110.hashCode() : 0);
        result = 31 * result + (tempIn != null ? tempIn.hashCode() : 0);
        result = 31 * result + (specOut != null ? specOut.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        return result;
    }
}
