package entity;

import javax.persistence.*;

/**
 * Created by yangchen on 2018/4/3.
 */
@Entity
@Table(name = "basic_vented_rotor", schema = "expert_system", catalog = "")
public class BasicVentedRotorEntity {
    private int id;
    private String rrManu;
    private String rrMat;
    private Double efcR;
    private Double outD;
    private Double inD;
    private String ckTIn;
    private String ckTOut;
    private Double rtT;
    private Integer vaneNum;
    private Double vaneLen;
    private Double vaneHigh;
    private Double vanT;
    private Double wm;
    private Double wa;
    private Double rho;
    private Double cc50;
    private Double cc80;
    private Double cc110;
    private Double cvr50;
    private Double cvr80;
    private Double cvr110;
    private String rtTempIn;
    private String rtSpecOut;

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
    @Column(name = "rr_manu")
    public String getRrManu() {
        return rrManu;
    }

    public void setRrManu(String rrManu) {
        this.rrManu = rrManu;
    }

    @Basic
    @Column(name = "rr_mat")
    public String getRrMat() {
        return rrMat;
    }

    public void setRrMat(String rrMat) {
        this.rrMat = rrMat;
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
    @Column(name = "out_d")
    public Double getOutD() {
        return outD;
    }

    public void setOutD(Double outD) {
        this.outD = outD;
    }

    @Basic
    @Column(name = "in_d")
    public Double getInD() {
        return inD;
    }

    public void setInD(Double inD) {
        this.inD = inD;
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
    @Column(name = "rt_t")
    public Double getRtT() {
        return rtT;
    }

    public void setRtT(Double rtT) {
        this.rtT = rtT;
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
    @Column(name = "van_t")
    public Double getVanT() {
        return vanT;
    }

    public void setVanT(Double vanT) {
        this.vanT = vanT;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BasicVentedRotorEntity that = (BasicVentedRotorEntity) o;

        if (id != that.id) return false;
        if (rrManu != null ? !rrManu.equals(that.rrManu) : that.rrManu != null) return false;
        if (rrMat != null ? !rrMat.equals(that.rrMat) : that.rrMat != null) return false;
        if (efcR != null ? !efcR.equals(that.efcR) : that.efcR != null) return false;
        if (outD != null ? !outD.equals(that.outD) : that.outD != null) return false;
        if (inD != null ? !inD.equals(that.inD) : that.inD != null) return false;
        if (ckTIn != null ? !ckTIn.equals(that.ckTIn) : that.ckTIn != null) return false;
        if (ckTOut != null ? !ckTOut.equals(that.ckTOut) : that.ckTOut != null) return false;
        if (rtT != null ? !rtT.equals(that.rtT) : that.rtT != null) return false;
        if (vaneNum != null ? !vaneNum.equals(that.vaneNum) : that.vaneNum != null) return false;
        if (vaneLen != null ? !vaneLen.equals(that.vaneLen) : that.vaneLen != null) return false;
        if (vaneHigh != null ? !vaneHigh.equals(that.vaneHigh) : that.vaneHigh != null) return false;
        if (vanT != null ? !vanT.equals(that.vanT) : that.vanT != null) return false;
        if (wm != null ? !wm.equals(that.wm) : that.wm != null) return false;
        if (wa != null ? !wa.equals(that.wa) : that.wa != null) return false;
        if (rho != null ? !rho.equals(that.rho) : that.rho != null) return false;
        if (cc50 != null ? !cc50.equals(that.cc50) : that.cc50 != null) return false;
        if (cc80 != null ? !cc80.equals(that.cc80) : that.cc80 != null) return false;
        if (cc110 != null ? !cc110.equals(that.cc110) : that.cc110 != null) return false;
        if (cvr50 != null ? !cvr50.equals(that.cvr50) : that.cvr50 != null) return false;
        if (cvr80 != null ? !cvr80.equals(that.cvr80) : that.cvr80 != null) return false;
        if (cvr110 != null ? !cvr110.equals(that.cvr110) : that.cvr110 != null) return false;
        if (rtTempIn != null ? !rtTempIn.equals(that.rtTempIn) : that.rtTempIn != null) return false;
        if (rtSpecOut != null ? !rtSpecOut.equals(that.rtSpecOut) : that.rtSpecOut != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (rrManu != null ? rrManu.hashCode() : 0);
        result = 31 * result + (rrMat != null ? rrMat.hashCode() : 0);
        result = 31 * result + (efcR != null ? efcR.hashCode() : 0);
        result = 31 * result + (outD != null ? outD.hashCode() : 0);
        result = 31 * result + (inD != null ? inD.hashCode() : 0);
        result = 31 * result + (ckTIn != null ? ckTIn.hashCode() : 0);
        result = 31 * result + (ckTOut != null ? ckTOut.hashCode() : 0);
        result = 31 * result + (rtT != null ? rtT.hashCode() : 0);
        result = 31 * result + (vaneNum != null ? vaneNum.hashCode() : 0);
        result = 31 * result + (vaneLen != null ? vaneLen.hashCode() : 0);
        result = 31 * result + (vaneHigh != null ? vaneHigh.hashCode() : 0);
        result = 31 * result + (vanT != null ? vanT.hashCode() : 0);
        result = 31 * result + (wm != null ? wm.hashCode() : 0);
        result = 31 * result + (wa != null ? wa.hashCode() : 0);
        result = 31 * result + (rho != null ? rho.hashCode() : 0);
        result = 31 * result + (cc50 != null ? cc50.hashCode() : 0);
        result = 31 * result + (cc80 != null ? cc80.hashCode() : 0);
        result = 31 * result + (cc110 != null ? cc110.hashCode() : 0);
        result = 31 * result + (cvr50 != null ? cvr50.hashCode() : 0);
        result = 31 * result + (cvr80 != null ? cvr80.hashCode() : 0);
        result = 31 * result + (cvr110 != null ? cvr110.hashCode() : 0);
        result = 31 * result + (rtTempIn != null ? rtTempIn.hashCode() : 0);
        result = 31 * result + (rtSpecOut != null ? rtSpecOut.hashCode() : 0);
        return result;
    }
}
