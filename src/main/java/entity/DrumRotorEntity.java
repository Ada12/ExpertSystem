package entity;

import javax.persistence.*;

/**
 * Created by yangchen on 17/7/1.
 */
@Entity
@Table(name = "drum_rotor", schema = "expert_system", catalog = "")
public class DrumRotorEntity {
    private int id;
    private String drumRId;
    private String applyVw;
    private String rtType;
    private Double rtEfcR;
    private String rtDiaOut;
    private String rtMat;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "drumR_ID")
    public String getDrumRId() {
        return drumRId;
    }

    public void setDrumRId(String drumRId) {
        this.drumRId = drumRId;
    }

    @Basic
    @Column(name = "apply_vw")
    public String getApplyVw() {
        return applyVw;
    }

    public void setApplyVw(String applyVw) {
        this.applyVw = applyVw;
    }

    @Basic
    @Column(name = "rt_type")
    public String getRtType() {
        return rtType;
    }

    public void setRtType(String rtType) {
        this.rtType = rtType;
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
    public String getRtDiaOut() {
        return rtDiaOut;
    }

    public void setRtDiaOut(String rtDiaOut) {
        this.rtDiaOut = rtDiaOut;
    }

    @Basic
    @Column(name = "rt_mat")
    public String getRtMat() {
        return rtMat;
    }

    public void setRtMat(String rtMat) {
        this.rtMat = rtMat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DrumRotorEntity that = (DrumRotorEntity) o;

        if (id != that.id) return false;
        if (drumRId != null ? !drumRId.equals(that.drumRId) : that.drumRId != null) return false;
        if (applyVw != null ? !applyVw.equals(that.applyVw) : that.applyVw != null) return false;
        if (rtType != null ? !rtType.equals(that.rtType) : that.rtType != null) return false;
        if (rtEfcR != null ? !rtEfcR.equals(that.rtEfcR) : that.rtEfcR != null) return false;
        if (rtDiaOut != null ? !rtDiaOut.equals(that.rtDiaOut) : that.rtDiaOut != null) return false;
        if (rtMat != null ? !rtMat.equals(that.rtMat) : that.rtMat != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (drumRId != null ? drumRId.hashCode() : 0);
        result = 31 * result + (applyVw != null ? applyVw.hashCode() : 0);
        result = 31 * result + (rtType != null ? rtType.hashCode() : 0);
        result = 31 * result + (rtEfcR != null ? rtEfcR.hashCode() : 0);
        result = 31 * result + (rtDiaOut != null ? rtDiaOut.hashCode() : 0);
        result = 31 * result + (rtMat != null ? rtMat.hashCode() : 0);
        return result;
    }
}
