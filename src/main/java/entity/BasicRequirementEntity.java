package entity;

import javax.persistence.*;

/**
 * Created by yangchen on 17/12/23.
 */
@Entity
@Table(name = "basic_requirement", schema = "expert_system", catalog = "")
public class BasicRequirementEntity {
    private int id;
    private String description;
    private Double tf0;
    private Double vi;
    private Double v0;
    private Double ab;
    private Double aa;
    private Double t;
    private Integer j;
    private Double vR;
    private Double v2R;
    private Double t0;
    private Double rhoa;
    private Double ua;
    private Double ka;
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
    @Column(name = "Tf0")
    public Double getTf0() {
        return tf0;
    }

    public void setTf0(Double tf0) {
        this.tf0 = tf0;
    }

    @Basic
    @Column(name = "Vi")
    public Double getVi() {
        return vi;
    }

    public void setVi(Double vi) {
        this.vi = vi;
    }

    @Basic
    @Column(name = "V0")
    public Double getV0() {
        return v0;
    }

    public void setV0(Double v0) {
        this.v0 = v0;
    }

    @Basic
    @Column(name = "ab")
    public Double getAb() {
        return ab;
    }

    public void setAb(Double ab) {
        this.ab = ab;
    }

    @Basic
    @Column(name = "aa")
    public Double getAa() {
        return aa;
    }

    public void setAa(Double aa) {
        this.aa = aa;
    }

    @Basic
    @Column(name = "t")
    public Double getT() {
        return t;
    }

    public void setT(Double t) {
        this.t = t;
    }

    @Basic
    @Column(name = "j")
    public Integer getJ() {
        return j;
    }

    public void setJ(Integer j) {
        this.j = j;
    }

    @Basic
    @Column(name = "vR")
    public Double getvR() {
        return vR;
    }

    public void setvR(Double vR) {
        this.vR = vR;
    }

    @Basic
    @Column(name = "v2R")
    public Double getV2R() {
        return v2R;
    }

    public void setV2R(Double v2R) {
        this.v2R = v2R;
    }

    @Basic
    @Column(name = "T0")
    public Double getT0() {
        return t0;
    }

    public void setT0(Double t0) {
        this.t0 = t0;
    }

    @Basic
    @Column(name = "rhoa")
    public Double getRhoa() {
        return rhoa;
    }

    public void setRhoa(Double rhoa) {
        this.rhoa = rhoa;
    }

    @Basic
    @Column(name = "ua")
    public Double getUa() {
        return ua;
    }

    public void setUa(Double ua) {
        this.ua = ua;
    }

    @Basic
    @Column(name = "ka")
    public Double getKa() {
        return ka;
    }

    public void setKa(Double ka) {
        this.ka = ka;
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

        BasicRequirementEntity that = (BasicRequirementEntity) o;

        if (id != that.id) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (tf0 != null ? !tf0.equals(that.tf0) : that.tf0 != null) return false;
        if (vi != null ? !vi.equals(that.vi) : that.vi != null) return false;
        if (v0 != null ? !v0.equals(that.v0) : that.v0 != null) return false;
        if (ab != null ? !ab.equals(that.ab) : that.ab != null) return false;
        if (aa != null ? !aa.equals(that.aa) : that.aa != null) return false;
        if (t != null ? !t.equals(that.t) : that.t != null) return false;
        if (j != null ? !j.equals(that.j) : that.j != null) return false;
        if (vR != null ? !vR.equals(that.vR) : that.vR != null) return false;
        if (v2R != null ? !v2R.equals(that.v2R) : that.v2R != null) return false;
        if (t0 != null ? !t0.equals(that.t0) : that.t0 != null) return false;
        if (rhoa != null ? !rhoa.equals(that.rhoa) : that.rhoa != null) return false;
        if (ua != null ? !ua.equals(that.ua) : that.ua != null) return false;
        if (ka != null ? !ka.equals(that.ka) : that.ka != null) return false;
        if (notes != null ? !notes.equals(that.notes) : that.notes != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (tf0 != null ? tf0.hashCode() : 0);
        result = 31 * result + (vi != null ? vi.hashCode() : 0);
        result = 31 * result + (v0 != null ? v0.hashCode() : 0);
        result = 31 * result + (ab != null ? ab.hashCode() : 0);
        result = 31 * result + (aa != null ? aa.hashCode() : 0);
        result = 31 * result + (t != null ? t.hashCode() : 0);
        result = 31 * result + (j != null ? j.hashCode() : 0);
        result = 31 * result + (vR != null ? vR.hashCode() : 0);
        result = 31 * result + (v2R != null ? v2R.hashCode() : 0);
        result = 31 * result + (t0 != null ? t0.hashCode() : 0);
        result = 31 * result + (rhoa != null ? rhoa.hashCode() : 0);
        result = 31 * result + (ua != null ? ua.hashCode() : 0);
        result = 31 * result + (ka != null ? ka.hashCode() : 0);
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        return result;
    }
}
