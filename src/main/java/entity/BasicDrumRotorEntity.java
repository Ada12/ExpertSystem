package entity;

import javax.persistence.*;

/**
 * Created by yangchen on 17/12/23.
 */
@Entity
@Table(name = "basic_drum_rotor", schema = "expert_system", catalog = "")
public class BasicDrumRotorEntity {
    private int id;
    private Double rtEfcR;
    private Double odDm;
    private Double idDm;
    private Double thDm;
    private Double wdDm;
    private Double jthDm;
    private Double rtVaneHigh;
    private Double rtWm;
    private Double rtWa;
    private Double rho;
    private Double cc50;
    private Double cc80;
    private Double cc110;
    private Double cvr50;
    private Double cvr80;
    private Double cvr110;
    private String dmTempIn;
    private String dmTempOut;

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
    @Column(name = "rt_efc_r")
    public Double getRtEfcR() {
        return rtEfcR;
    }

    public void setRtEfcR(Double rtEfcR) {
        this.rtEfcR = rtEfcR;
    }

    @Basic
    @Column(name = "Od_dm")
    public Double getOdDm() {
        return odDm;
    }

    public void setOdDm(Double odDm) {
        this.odDm = odDm;
    }

    @Basic
    @Column(name = "Id_dm")
    public Double getIdDm() {
        return idDm;
    }

    public void setIdDm(Double idDm) {
        this.idDm = idDm;
    }

    @Basic
    @Column(name = "Th_dm")
    public Double getThDm() {
        return thDm;
    }

    public void setThDm(Double thDm) {
        this.thDm = thDm;
    }

    @Basic
    @Column(name = "Wd_dm")
    public Double getWdDm() {
        return wdDm;
    }

    public void setWdDm(Double wdDm) {
        this.wdDm = wdDm;
    }

    @Basic
    @Column(name = "Jth_dm")
    public Double getJthDm() {
        return jthDm;
    }

    public void setJthDm(Double jthDm) {
        this.jthDm = jthDm;
    }

    @Basic
    @Column(name = "rt_vane_high")
    public Double getRtVaneHigh() {
        return rtVaneHigh;
    }

    public void setRtVaneHigh(Double rtVaneHigh) {
        this.rtVaneHigh = rtVaneHigh;
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
    @Column(name = "dm_temp_in")
    public String getDmTempIn() {
        return dmTempIn;
    }

    public void setDmTempIn(String dmTempIn) {
        this.dmTempIn = dmTempIn;
    }

    @Basic
    @Column(name = "dm_temp_out")
    public String getDmTempOut() {
        return dmTempOut;
    }

    public void setDmTempOut(String dmTempOut) {
        this.dmTempOut = dmTempOut;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BasicDrumRotorEntity that = (BasicDrumRotorEntity) o;

        if (id != that.id) return false;
        if (rtEfcR != null ? !rtEfcR.equals(that.rtEfcR) : that.rtEfcR != null) return false;
        if (odDm != null ? !odDm.equals(that.odDm) : that.odDm != null) return false;
        if (idDm != null ? !idDm.equals(that.idDm) : that.idDm != null) return false;
        if (thDm != null ? !thDm.equals(that.thDm) : that.thDm != null) return false;
        if (wdDm != null ? !wdDm.equals(that.wdDm) : that.wdDm != null) return false;
        if (jthDm != null ? !jthDm.equals(that.jthDm) : that.jthDm != null) return false;
        if (rtVaneHigh != null ? !rtVaneHigh.equals(that.rtVaneHigh) : that.rtVaneHigh != null) return false;
        if (rtWm != null ? !rtWm.equals(that.rtWm) : that.rtWm != null) return false;
        if (rtWa != null ? !rtWa.equals(that.rtWa) : that.rtWa != null) return false;
        if (rho != null ? !rho.equals(that.rho) : that.rho != null) return false;
        if (cc50 != null ? !cc50.equals(that.cc50) : that.cc50 != null) return false;
        if (cc80 != null ? !cc80.equals(that.cc80) : that.cc80 != null) return false;
        if (cc110 != null ? !cc110.equals(that.cc110) : that.cc110 != null) return false;
        if (cvr50 != null ? !cvr50.equals(that.cvr50) : that.cvr50 != null) return false;
        if (cvr80 != null ? !cvr80.equals(that.cvr80) : that.cvr80 != null) return false;
        if (cvr110 != null ? !cvr110.equals(that.cvr110) : that.cvr110 != null) return false;
        if (dmTempIn != null ? !dmTempIn.equals(that.dmTempIn) : that.dmTempIn != null) return false;
        if (dmTempOut != null ? !dmTempOut.equals(that.dmTempOut) : that.dmTempOut != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (rtEfcR != null ? rtEfcR.hashCode() : 0);
        result = 31 * result + (odDm != null ? odDm.hashCode() : 0);
        result = 31 * result + (idDm != null ? idDm.hashCode() : 0);
        result = 31 * result + (thDm != null ? thDm.hashCode() : 0);
        result = 31 * result + (wdDm != null ? wdDm.hashCode() : 0);
        result = 31 * result + (jthDm != null ? jthDm.hashCode() : 0);
        result = 31 * result + (rtVaneHigh != null ? rtVaneHigh.hashCode() : 0);
        result = 31 * result + (rtWm != null ? rtWm.hashCode() : 0);
        result = 31 * result + (rtWa != null ? rtWa.hashCode() : 0);
        result = 31 * result + (rho != null ? rho.hashCode() : 0);
        result = 31 * result + (cc50 != null ? cc50.hashCode() : 0);
        result = 31 * result + (cc80 != null ? cc80.hashCode() : 0);
        result = 31 * result + (cc110 != null ? cc110.hashCode() : 0);
        result = 31 * result + (cvr50 != null ? cvr50.hashCode() : 0);
        result = 31 * result + (cvr80 != null ? cvr80.hashCode() : 0);
        result = 31 * result + (cvr110 != null ? cvr110.hashCode() : 0);
        result = 31 * result + (dmTempIn != null ? dmTempIn.hashCode() : 0);
        result = 31 * result + (dmTempOut != null ? dmTempOut.hashCode() : 0);
        return result;
    }
}
