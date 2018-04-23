package entity;

import javax.persistence.*;

/**
 * Created by yangchen on 2018/4/3.
 */
@Entity
@Table(name = "lib_pedal", schema = "expert_system", catalog = "")
public class LibPedalEntity {
    private int id;
    private String description;
    private String spl;
    private String ratio;
    private Double fEff;
    private Double tEff;
    private Integer type;
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
    @Column(name = "ratio")
    public String getRatio() {
        return ratio;
    }

    public void setRatio(String ratio) {
        this.ratio = ratio;
    }

    @Basic
    @Column(name = "F_eff")
    public Double getfEff() {
        return fEff;
    }

    public void setfEff(Double fEff) {
        this.fEff = fEff;
    }

    @Basic
    @Column(name = "T_eff")
    public Double gettEff() {
        return tEff;
    }

    public void settEff(Double tEff) {
        this.tEff = tEff;
    }

    @Basic
    @Column(name = "type")
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

        LibPedalEntity that = (LibPedalEntity) o;

        if (id != that.id) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (spl != null ? !spl.equals(that.spl) : that.spl != null) return false;
        if (ratio != null ? !ratio.equals(that.ratio) : that.ratio != null) return false;
        if (fEff != null ? !fEff.equals(that.fEff) : that.fEff != null) return false;
        if (tEff != null ? !tEff.equals(that.tEff) : that.tEff != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (notes != null ? !notes.equals(that.notes) : that.notes != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (spl != null ? spl.hashCode() : 0);
        result = 31 * result + (ratio != null ? ratio.hashCode() : 0);
        result = 31 * result + (fEff != null ? fEff.hashCode() : 0);
        result = 31 * result + (tEff != null ? tEff.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        return result;
    }
}
