package entity;

import javax.persistence.*;

/**
 * Created by yangchen on 17/11/17.
 */
@Entity
@Table(name = "basic_control", schema = "expert_system", catalog = "")
public class BasicControlEntity {
    private int id;
    private String description;
    private Double effAbsFrt;
    private Double effAbsRr;
    private String peakTire;
    private String effDrive;
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
    @Column(name = "eff_abs_frt")
    public Double getEffAbsFrt() {
        return effAbsFrt;
    }

    public void setEffAbsFrt(Double effAbsFrt) {
        this.effAbsFrt = effAbsFrt;
    }

    @Basic
    @Column(name = "eff_abs_rr")
    public Double getEffAbsRr() {
        return effAbsRr;
    }

    public void setEffAbsRr(Double effAbsRr) {
        this.effAbsRr = effAbsRr;
    }

    @Basic
    @Column(name = "peak_tire")
    public String getPeakTire() {
        return peakTire;
    }

    public void setPeakTire(String peakTire) {
        this.peakTire = peakTire;
    }

    @Basic
    @Column(name = "eff_drive")
    public String getEffDrive() {
        return effDrive;
    }

    public void setEffDrive(String effDrive) {
        this.effDrive = effDrive;
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

        BasicControlEntity entity = (BasicControlEntity) o;

        if (id != entity.id) return false;
        if (description != null ? !description.equals(entity.description) : entity.description != null) return false;
        if (effAbsFrt != null ? !effAbsFrt.equals(entity.effAbsFrt) : entity.effAbsFrt != null) return false;
        if (effAbsRr != null ? !effAbsRr.equals(entity.effAbsRr) : entity.effAbsRr != null) return false;
        if (peakTire != null ? !peakTire.equals(entity.peakTire) : entity.peakTire != null) return false;
        if (effDrive != null ? !effDrive.equals(entity.effDrive) : entity.effDrive != null) return false;
        if (notes != null ? !notes.equals(entity.notes) : entity.notes != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (effAbsFrt != null ? effAbsFrt.hashCode() : 0);
        result = 31 * result + (effAbsRr != null ? effAbsRr.hashCode() : 0);
        result = 31 * result + (peakTire != null ? peakTire.hashCode() : 0);
        result = 31 * result + (effDrive != null ? effDrive.hashCode() : 0);
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        return result;
    }
}
