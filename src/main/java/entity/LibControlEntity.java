package entity;

import javax.persistence.*;

/**
 * Created by yangchen on 2018/4/3.
 */
@Entity
@Table(name = "lib_control", schema = "expert_system", catalog = "")
public class LibControlEntity {
    private int id;
    private String description;
    private String spl;
    private String type;
    private Double frtEff;
    private Double rrEff;
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
    @Column(name = "spl")
    public String getSpl() {
        return spl;
    }

    public void setSpl(String spl) {
        this.spl = spl;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "frt_eff")
    public Double getFrtEff() {
        return frtEff;
    }

    public void setFrtEff(Double frtEff) {
        this.frtEff = frtEff;
    }

    @Basic
    @Column(name = "rr_eff")
    public Double getRrEff() {
        return rrEff;
    }

    public void setRrEff(Double rrEff) {
        this.rrEff = rrEff;
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

        LibControlEntity that = (LibControlEntity) o;

        if (id != that.id) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (spl != null ? !spl.equals(that.spl) : that.spl != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (frtEff != null ? !frtEff.equals(that.frtEff) : that.frtEff != null) return false;
        if (rrEff != null ? !rrEff.equals(that.rrEff) : that.rrEff != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (notes != null ? !notes.equals(that.notes) : that.notes != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (spl != null ? spl.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (frtEff != null ? frtEff.hashCode() : 0);
        result = 31 * result + (rrEff != null ? rrEff.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        return result;
    }
}
