package entity;

import javax.persistence.*;

/**
 * Created by yangchen on 17/12/23.
 */
@Entity
@Table(name = "basic_solid_rotor", schema = "expert_system", catalog = "")
public class BasicSolidRotorEntity {
    private int id;
    private Double rtSwpArea;
    private Double rtEfcR;
    private Double rtDiaOut;
    private Double rtDiaIn;
    private Double rtT;
    private Double rtWm;
    private Double rtWa;
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
    @Column(name = "rt_swp_area")
    public Double getRtSwpArea() {
        return rtSwpArea;
    }

    public void setRtSwpArea(Double rtSwpArea) {
        this.rtSwpArea = rtSwpArea;
    }

    @Basic
    @Column(name = "rt_efc_r")
    public Double getRtEfcR() {
        return rtEfcR;
    }

    public void setRtEfcR(Double rtEfcR) {
        this.rtEfcR = rtEfcR;
    }

    @Basic
    @Column(name = "rt_dia_out")
    public Double getRtDiaOut() {
        return rtDiaOut;
    }

    public void setRtDiaOut(Double rtDiaOut) {
        this.rtDiaOut = rtDiaOut;
    }

    @Basic
    @Column(name = "rt_dia_in")
    public Double getRtDiaIn() {
        return rtDiaIn;
    }

    public void setRtDiaIn(Double rtDiaIn) {
        this.rtDiaIn = rtDiaIn;
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
    @Column(name = "rt_wm")
    public Double getRtWm() {
        return rtWm;
    }

    public void setRtWm(Double rtWm) {
        this.rtWm = rtWm;
    }

    @Basic
    @Column(name = "rt_wa")
    public Double getRtWa() {
        return rtWa;
    }

    public void setRtWa(Double rtWa) {
        this.rtWa = rtWa;
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

        BasicSolidRotorEntity that = (BasicSolidRotorEntity) o;

        if (id != that.id) return false;
        if (rtSwpArea != null ? !rtSwpArea.equals(that.rtSwpArea) : that.rtSwpArea != null) return false;
        if (rtEfcR != null ? !rtEfcR.equals(that.rtEfcR) : that.rtEfcR != null) return false;
        if (rtDiaOut != null ? !rtDiaOut.equals(that.rtDiaOut) : that.rtDiaOut != null) return false;
        if (rtDiaIn != null ? !rtDiaIn.equals(that.rtDiaIn) : that.rtDiaIn != null) return false;
        if (rtT != null ? !rtT.equals(that.rtT) : that.rtT != null) return false;
        if (rtWm != null ? !rtWm.equals(that.rtWm) : that.rtWm != null) return false;
        if (rtWa != null ? !rtWa.equals(that.rtWa) : that.rtWa != null) return false;
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
        result = 31 * result + (rtSwpArea != null ? rtSwpArea.hashCode() : 0);
        result = 31 * result + (rtEfcR != null ? rtEfcR.hashCode() : 0);
        result = 31 * result + (rtDiaOut != null ? rtDiaOut.hashCode() : 0);
        result = 31 * result + (rtDiaIn != null ? rtDiaIn.hashCode() : 0);
        result = 31 * result + (rtT != null ? rtT.hashCode() : 0);
        result = 31 * result + (rtWm != null ? rtWm.hashCode() : 0);
        result = 31 * result + (rtWa != null ? rtWa.hashCode() : 0);
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
