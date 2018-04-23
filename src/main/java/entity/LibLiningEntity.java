package entity;

import javax.persistence.*;

/**
 * Created by yangchen on 2018/4/3.
 */
@Entity
@Table(name = "lib_lining", schema = "expert_system", catalog = "")
public class LibLiningEntity {
    private int id;
    private String description;
    private String type;
    private String spl;
    private String mat;
    private String mu;
    private Double muNp;
    private Double area;
    private Double wearLim;
    private String tempIn;
    private String wearSpecOut;
    private String fricSpecOut;
    private Double inertia;
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
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
    @Column(name = "mat")
    public String getMat() {
        return mat;
    }

    public void setMat(String mat) {
        this.mat = mat;
    }

    @Basic
    @Column(name = "mu")
    public String getMu() {
        return mu;
    }

    public void setMu(String mu) {
        this.mu = mu;
    }

    @Basic
    @Column(name = "mu_np")
    public Double getMuNp() {
        return muNp;
    }

    public void setMuNp(Double muNp) {
        this.muNp = muNp;
    }

    @Basic
    @Column(name = "area")
    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    @Basic
    @Column(name = "wear_lim")
    public Double getWearLim() {
        return wearLim;
    }

    public void setWearLim(Double wearLim) {
        this.wearLim = wearLim;
    }

    @Basic
    @Column(name = "temp_in")
    public String getTempIn() {
        return tempIn;
    }

    public void setTempIn(String tempIn) {
        this.tempIn = tempIn;
    }

    @Basic
    @Column(name = "wear_spec_out")
    public String getWearSpecOut() {
        return wearSpecOut;
    }

    public void setWearSpecOut(String wearSpecOut) {
        this.wearSpecOut = wearSpecOut;
    }

    @Basic
    @Column(name = "fric_spec_out")
    public String getFricSpecOut() {
        return fricSpecOut;
    }

    public void setFricSpecOut(String fricSpecOut) {
        this.fricSpecOut = fricSpecOut;
    }

    @Basic
    @Column(name = "inertia")
    public Double getInertia() {
        return inertia;
    }

    public void setInertia(Double inertia) {
        this.inertia = inertia;
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

        LibLiningEntity that = (LibLiningEntity) o;

        if (id != that.id) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (spl != null ? !spl.equals(that.spl) : that.spl != null) return false;
        if (mat != null ? !mat.equals(that.mat) : that.mat != null) return false;
        if (mu != null ? !mu.equals(that.mu) : that.mu != null) return false;
        if (muNp != null ? !muNp.equals(that.muNp) : that.muNp != null) return false;
        if (area != null ? !area.equals(that.area) : that.area != null) return false;
        if (wearLim != null ? !wearLim.equals(that.wearLim) : that.wearLim != null) return false;
        if (tempIn != null ? !tempIn.equals(that.tempIn) : that.tempIn != null) return false;
        if (wearSpecOut != null ? !wearSpecOut.equals(that.wearSpecOut) : that.wearSpecOut != null) return false;
        if (fricSpecOut != null ? !fricSpecOut.equals(that.fricSpecOut) : that.fricSpecOut != null) return false;
        if (inertia != null ? !inertia.equals(that.inertia) : that.inertia != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (notes != null ? !notes.equals(that.notes) : that.notes != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (spl != null ? spl.hashCode() : 0);
        result = 31 * result + (mat != null ? mat.hashCode() : 0);
        result = 31 * result + (mu != null ? mu.hashCode() : 0);
        result = 31 * result + (muNp != null ? muNp.hashCode() : 0);
        result = 31 * result + (area != null ? area.hashCode() : 0);
        result = 31 * result + (wearLim != null ? wearLim.hashCode() : 0);
        result = 31 * result + (tempIn != null ? tempIn.hashCode() : 0);
        result = 31 * result + (wearSpecOut != null ? wearSpecOut.hashCode() : 0);
        result = 31 * result + (fricSpecOut != null ? fricSpecOut.hashCode() : 0);
        result = 31 * result + (inertia != null ? inertia.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        return result;
    }
}
