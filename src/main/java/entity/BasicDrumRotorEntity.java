package entity;

import javax.persistence.*;

/**
 * Created by yangchen on 18/1/8.
 */
@Entity
@Table(name = "basic_drum_rotor", schema = "expert_system", catalog = "")
public class BasicDrumRotorEntity {
    private int id;
    private String rrManu;
    private String rrMat;
    private Double swpArea;
    private Double efcR;
    private Double outD;
    private Double inD;
    private Double rtThick;
    private Double ribThick;
    private Double ribWidth;
    private Double rtWidth;
    private Double wm;
    private Double wa;
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
        if (rrManu != null ? !rrManu.equals(that.rrManu) : that.rrManu != null) return false;
        if (rrMat != null ? !rrMat.equals(that.rrMat) : that.rrMat != null) return false;
        if (swpArea != null ? !swpArea.equals(that.swpArea) : that.swpArea != null) return false;
        if (efcR != null ? !efcR.equals(that.efcR) : that.efcR != null) return false;
        if (outD != null ? !outD.equals(that.outD) : that.outD != null) return false;
        if (inD != null ? !inD.equals(that.inD) : that.inD != null) return false;
        if (rtThick != null ? !rtThick.equals(that.rtThick) : that.rtThick != null) return false;
        if (ribThick != null ? !ribThick.equals(that.ribThick) : that.ribThick != null) return false;
        if (ribWidth != null ? !ribWidth.equals(that.ribWidth) : that.ribWidth != null) return false;
        if (rtWidth != null ? !rtWidth.equals(that.rtWidth) : that.rtWidth != null) return false;
        if (wm != null ? !wm.equals(that.wm) : that.wm != null) return false;
        if (wa != null ? !wa.equals(that.wa) : that.wa != null) return false;
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
        result = 31 * result + (rrManu != null ? rrManu.hashCode() : 0);
        result = 31 * result + (rrMat != null ? rrMat.hashCode() : 0);
        result = 31 * result + (swpArea != null ? swpArea.hashCode() : 0);
        result = 31 * result + (efcR != null ? efcR.hashCode() : 0);
        result = 31 * result + (outD != null ? outD.hashCode() : 0);
        result = 31 * result + (inD != null ? inD.hashCode() : 0);
        result = 31 * result + (rtThick != null ? rtThick.hashCode() : 0);
        result = 31 * result + (ribThick != null ? ribThick.hashCode() : 0);
        result = 31 * result + (ribWidth != null ? ribWidth.hashCode() : 0);
        result = 31 * result + (rtWidth != null ? rtWidth.hashCode() : 0);
        result = 31 * result + (wm != null ? wm.hashCode() : 0);
        result = 31 * result + (wa != null ? wa.hashCode() : 0);
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
