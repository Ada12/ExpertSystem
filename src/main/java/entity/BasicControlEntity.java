package entity;

import javax.persistence.*;

/**
 * Created by yangchen on 18/1/8.
 */
@Entity
@Table(name = "basic_control", schema = "expert_system", catalog = "")
public class BasicControlEntity {
    private int id;
    private String description;
    private String absSpl;
    private String absType;
    private Double effAbsFrt;
    private Double effAbsRr;
    private Integer ebd;
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
    @Column(name = "abs_spl")
    public String getAbsSpl() {
        return absSpl;
    }

    public void setAbsSpl(String absSpl) {
        this.absSpl = absSpl;
    }

    @Basic
    @Column(name = "abs_type")
    public String getAbsType() {
        return absType;
    }

    public void setAbsType(String absType) {
        this.absType = absType;
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
    @Column(name = "EBD")
    public Integer getEbd() {
        return ebd;
    }

    public void setEbd(Integer ebd) {
        this.ebd = ebd;
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
        if (absSpl != null ? !absSpl.equals(entity.absSpl) : entity.absSpl != null) return false;
        if (absType != null ? !absType.equals(entity.absType) : entity.absType != null) return false;
        if (effAbsFrt != null ? !effAbsFrt.equals(entity.effAbsFrt) : entity.effAbsFrt != null) return false;
        if (effAbsRr != null ? !effAbsRr.equals(entity.effAbsRr) : entity.effAbsRr != null) return false;
        if (ebd != null ? !ebd.equals(entity.ebd) : entity.ebd != null) return false;
        if (notes != null ? !notes.equals(entity.notes) : entity.notes != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (absSpl != null ? absSpl.hashCode() : 0);
        result = 31 * result + (absType != null ? absType.hashCode() : 0);
        result = 31 * result + (effAbsFrt != null ? effAbsFrt.hashCode() : 0);
        result = 31 * result + (effAbsRr != null ? effAbsRr.hashCode() : 0);
        result = 31 * result + (ebd != null ? ebd.hashCode() : 0);
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        return result;
    }
}
