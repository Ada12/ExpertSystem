package entity;

import javax.persistence.*;

/**
 * Created by yangchen on 2018/4/3.
 */
@Entity
@Table(name = "lib_vehicle", schema = "expert_system", catalog = "")
public class LibVehicleEntity {
    private int id;
    private String description;
    private String carAddInfo;
    private String carModel;
    private Double carYear;
    private String carDa;
    private Double lvwM;
    private Double lvwFrtR;
    private Double lvwCgh;
    private Double gvwM;
    private Double gvwFrtR;
    private Double gvwCgh;
    private Double l;
    private Double vmax;
    private Double wot;
    private Double cd;
    private Double a;
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
    @Column(name = "carAddInfo")
    public String getCarAddInfo() {
        return carAddInfo;
    }

    public void setCarAddInfo(String carAddInfo) {
        this.carAddInfo = carAddInfo;
    }

    @Basic
    @Column(name = "carModel")
    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    @Basic
    @Column(name = "carYear")
    public Double getCarYear() {
        return carYear;
    }

    public void setCarYear(Double carYear) {
        this.carYear = carYear;
    }

    @Basic
    @Column(name = "carDA")
    public String getCarDa() {
        return carDa;
    }

    public void setCarDa(String carDa) {
        this.carDa = carDa;
    }

    @Basic
    @Column(name = "lvw_m")
    public Double getLvwM() {
        return lvwM;
    }

    public void setLvwM(Double lvwM) {
        this.lvwM = lvwM;
    }

    @Basic
    @Column(name = "lvw_frt_r")
    public Double getLvwFrtR() {
        return lvwFrtR;
    }

    public void setLvwFrtR(Double lvwFrtR) {
        this.lvwFrtR = lvwFrtR;
    }

    @Basic
    @Column(name = "lvw_cgh")
    public Double getLvwCgh() {
        return lvwCgh;
    }

    public void setLvwCgh(Double lvwCgh) {
        this.lvwCgh = lvwCgh;
    }

    @Basic
    @Column(name = "gvw_m")
    public Double getGvwM() {
        return gvwM;
    }

    public void setGvwM(Double gvwM) {
        this.gvwM = gvwM;
    }

    @Basic
    @Column(name = "gvw_frt_r")
    public Double getGvwFrtR() {
        return gvwFrtR;
    }

    public void setGvwFrtR(Double gvwFrtR) {
        this.gvwFrtR = gvwFrtR;
    }

    @Basic
    @Column(name = "gvw_cgh")
    public Double getGvwCgh() {
        return gvwCgh;
    }

    public void setGvwCgh(Double gvwCgh) {
        this.gvwCgh = gvwCgh;
    }

    @Basic
    @Column(name = "L")
    public Double getL() {
        return l;
    }

    public void setL(Double l) {
        this.l = l;
    }

    @Basic
    @Column(name = "vmax")
    public Double getVmax() {
        return vmax;
    }

    public void setVmax(Double vmax) {
        this.vmax = vmax;
    }

    @Basic
    @Column(name = "wot")
    public Double getWot() {
        return wot;
    }

    public void setWot(Double wot) {
        this.wot = wot;
    }

    @Basic
    @Column(name = "Cd")
    public Double getCd() {
        return cd;
    }

    public void setCd(Double cd) {
        this.cd = cd;
    }

    @Basic
    @Column(name = "A")
    public Double getA() {
        return a;
    }

    public void setA(Double a) {
        this.a = a;
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

        LibVehicleEntity that = (LibVehicleEntity) o;

        if (id != that.id) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (carAddInfo != null ? !carAddInfo.equals(that.carAddInfo) : that.carAddInfo != null) return false;
        if (carModel != null ? !carModel.equals(that.carModel) : that.carModel != null) return false;
        if (carYear != null ? !carYear.equals(that.carYear) : that.carYear != null) return false;
        if (carDa != null ? !carDa.equals(that.carDa) : that.carDa != null) return false;
        if (lvwM != null ? !lvwM.equals(that.lvwM) : that.lvwM != null) return false;
        if (lvwFrtR != null ? !lvwFrtR.equals(that.lvwFrtR) : that.lvwFrtR != null) return false;
        if (lvwCgh != null ? !lvwCgh.equals(that.lvwCgh) : that.lvwCgh != null) return false;
        if (gvwM != null ? !gvwM.equals(that.gvwM) : that.gvwM != null) return false;
        if (gvwFrtR != null ? !gvwFrtR.equals(that.gvwFrtR) : that.gvwFrtR != null) return false;
        if (gvwCgh != null ? !gvwCgh.equals(that.gvwCgh) : that.gvwCgh != null) return false;
        if (l != null ? !l.equals(that.l) : that.l != null) return false;
        if (vmax != null ? !vmax.equals(that.vmax) : that.vmax != null) return false;
        if (wot != null ? !wot.equals(that.wot) : that.wot != null) return false;
        if (cd != null ? !cd.equals(that.cd) : that.cd != null) return false;
        if (a != null ? !a.equals(that.a) : that.a != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (notes != null ? !notes.equals(that.notes) : that.notes != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (carAddInfo != null ? carAddInfo.hashCode() : 0);
        result = 31 * result + (carModel != null ? carModel.hashCode() : 0);
        result = 31 * result + (carYear != null ? carYear.hashCode() : 0);
        result = 31 * result + (carDa != null ? carDa.hashCode() : 0);
        result = 31 * result + (lvwM != null ? lvwM.hashCode() : 0);
        result = 31 * result + (lvwFrtR != null ? lvwFrtR.hashCode() : 0);
        result = 31 * result + (lvwCgh != null ? lvwCgh.hashCode() : 0);
        result = 31 * result + (gvwM != null ? gvwM.hashCode() : 0);
        result = 31 * result + (gvwFrtR != null ? gvwFrtR.hashCode() : 0);
        result = 31 * result + (gvwCgh != null ? gvwCgh.hashCode() : 0);
        result = 31 * result + (l != null ? l.hashCode() : 0);
        result = 31 * result + (vmax != null ? vmax.hashCode() : 0);
        result = 31 * result + (wot != null ? wot.hashCode() : 0);
        result = 31 * result + (cd != null ? cd.hashCode() : 0);
        result = 31 * result + (a != null ? a.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        return result;
    }
}
