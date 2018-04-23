package entity;

import javax.persistence.*;

/**
 * Created by yangchen on 2018/4/3.
 */
@Entity
@Table(name = "lib_solid_rotor", schema = "expert_system", catalog = "")
public class LibSolidRotorEntity {
    private int id;
    private String description;
    private String manu;
    private String mat;
    private Double efcR;
    private Double dOut;
    private Double dIn;
    private Double thick;
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
    @Column(name = "thick")
    public Double getThick() {
        return thick;
    }

    public void setThick(Double thick) {
        this.thick = thick;
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

        LibSolidRotorEntity that = (LibSolidRotorEntity) o;

        if (id != that.id) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (manu != null ? !manu.equals(that.manu) : that.manu != null) return false;
        if (mat != null ? !mat.equals(that.mat) : that.mat != null) return false;
        if (efcR != null ? !efcR.equals(that.efcR) : that.efcR != null) return false;
        if (dOut != null ? !dOut.equals(that.dOut) : that.dOut != null) return false;
        if (dIn != null ? !dIn.equals(that.dIn) : that.dIn != null) return false;
        if (thick != null ? !thick.equals(that.thick) : that.thick != null) return false;
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
        result = 31 * result + (manu != null ? manu.hashCode() : 0);
        result = 31 * result + (mat != null ? mat.hashCode() : 0);
        result = 31 * result + (efcR != null ? efcR.hashCode() : 0);
        result = 31 * result + (dOut != null ? dOut.hashCode() : 0);
        result = 31 * result + (dIn != null ? dIn.hashCode() : 0);
        result = 31 * result + (thick != null ? thick.hashCode() : 0);
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
