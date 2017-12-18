package entity;

import javax.persistence.*;

/**
 * Created by yangchen on 17/11/17.
 */
@Entity
@Table(name = "basic_tire_wheel", schema = "expert_system", catalog = "")
public class BasicTireWheelEntity {
    private int id;
    private String description;
    private Double lvwTrFrt;
    private Double lvwTrRr;
    private Double gvwTrFrt;
    private Double gvwTrRr;
    private Double peakAdhesLong;
    private Double peakAdhesLat;
    private Double tracCoeff;
    private Double s;
    private Double fR;
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
    @Column(name = "lvw_tr_frt")
    public Double getLvwTrFrt() {
        return lvwTrFrt;
    }

    public void setLvwTrFrt(Double lvwTrFrt) {
        this.lvwTrFrt = lvwTrFrt;
    }

    @Basic
    @Column(name = "lvw_tr_rr")
    public Double getLvwTrRr() {
        return lvwTrRr;
    }

    public void setLvwTrRr(Double lvwTrRr) {
        this.lvwTrRr = lvwTrRr;
    }

    @Basic
    @Column(name = "gvw_tr_frt")
    public Double getGvwTrFrt() {
        return gvwTrFrt;
    }

    public void setGvwTrFrt(Double gvwTrFrt) {
        this.gvwTrFrt = gvwTrFrt;
    }

    @Basic
    @Column(name = "gvw_tr_rr")
    public Double getGvwTrRr() {
        return gvwTrRr;
    }

    public void setGvwTrRr(Double gvwTrRr) {
        this.gvwTrRr = gvwTrRr;
    }

    @Basic
    @Column(name = "peak_adhes_long")
    public Double getPeakAdhesLong() {
        return peakAdhesLong;
    }

    public void setPeakAdhesLong(Double peakAdhesLong) {
        this.peakAdhesLong = peakAdhesLong;
    }

    @Basic
    @Column(name = "peak_adhes_lat")
    public Double getPeakAdhesLat() {
        return peakAdhesLat;
    }

    public void setPeakAdhesLat(Double peakAdhesLat) {
        this.peakAdhesLat = peakAdhesLat;
    }

    @Basic
    @Column(name = "trac_coeff")
    public Double getTracCoeff() {
        return tracCoeff;
    }

    public void setTracCoeff(Double tracCoeff) {
        this.tracCoeff = tracCoeff;
    }

    @Basic
    @Column(name = "s")
    public Double getS() {
        return s;
    }

    public void setS(Double s) {
        this.s = s;
    }

    @Basic
    @Column(name = "F_R")
    public Double getfR() {
        return fR;
    }

    public void setfR(Double fR) {
        this.fR = fR;
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

        BasicTireWheelEntity that = (BasicTireWheelEntity) o;

        if (id != that.id) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (lvwTrFrt != null ? !lvwTrFrt.equals(that.lvwTrFrt) : that.lvwTrFrt != null) return false;
        if (lvwTrRr != null ? !lvwTrRr.equals(that.lvwTrRr) : that.lvwTrRr != null) return false;
        if (gvwTrFrt != null ? !gvwTrFrt.equals(that.gvwTrFrt) : that.gvwTrFrt != null) return false;
        if (gvwTrRr != null ? !gvwTrRr.equals(that.gvwTrRr) : that.gvwTrRr != null) return false;
        if (peakAdhesLong != null ? !peakAdhesLong.equals(that.peakAdhesLong) : that.peakAdhesLong != null)
            return false;
        if (peakAdhesLat != null ? !peakAdhesLat.equals(that.peakAdhesLat) : that.peakAdhesLat != null) return false;
        if (tracCoeff != null ? !tracCoeff.equals(that.tracCoeff) : that.tracCoeff != null) return false;
        if (s != null ? !s.equals(that.s) : that.s != null) return false;
        if (fR != null ? !fR.equals(that.fR) : that.fR != null) return false;
        if (notes != null ? !notes.equals(that.notes) : that.notes != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (lvwTrFrt != null ? lvwTrFrt.hashCode() : 0);
        result = 31 * result + (lvwTrRr != null ? lvwTrRr.hashCode() : 0);
        result = 31 * result + (gvwTrFrt != null ? gvwTrFrt.hashCode() : 0);
        result = 31 * result + (gvwTrRr != null ? gvwTrRr.hashCode() : 0);
        result = 31 * result + (peakAdhesLong != null ? peakAdhesLong.hashCode() : 0);
        result = 31 * result + (peakAdhesLat != null ? peakAdhesLat.hashCode() : 0);
        result = 31 * result + (tracCoeff != null ? tracCoeff.hashCode() : 0);
        result = 31 * result + (s != null ? s.hashCode() : 0);
        result = 31 * result + (fR != null ? fR.hashCode() : 0);
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        return result;
    }
}
