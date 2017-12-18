package entity;

import javax.persistence.*;

/**
 * Created by yangchen on 17/7/1.
 */
@Entity
@Table(name = "vehicle", schema = "expert_system", catalog = "")
public class VehicleEntity {
    private int id;
    private String carMy;
    private Double lvwW;
    private Double lvwHg;
    private Double lvwWr;
    private Double gvwW;
    private Double gvwHg;
    private Double gvwWr;
    private Double carL;
    private Double carSlr;
    private Integer frtCaliper;
    private Integer frtRotor;
    private Integer rrCaliper;
    private Integer rrRotor;
    private Integer bstMc;
    private Integer ped;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "car_MY")
    public String getCarMy() {
        return carMy;
    }

    public void setCarMy(String carMy) {
        this.carMy = carMy;
    }

    @Basic
    @Column(name = "lvw_w")
    public Double getLvwW() {
        return lvwW;
    }

    public void setLvwW(Double lvwW) {
        this.lvwW = lvwW;
    }

    @Basic
    @Column(name = "lvw_hg")
    public Double getLvwHg() {
        return lvwHg;
    }

    public void setLvwHg(Double lvwHg) {
        this.lvwHg = lvwHg;
    }

    @Basic
    @Column(name = "lvw_wr")
    public Double getLvwWr() {
        return lvwWr;
    }

    public void setLvwWr(Double lvwWr) {
        this.lvwWr = lvwWr;
    }

    @Basic
    @Column(name = "gvw_w")
    public Double getGvwW() {
        return gvwW;
    }

    public void setGvwW(Double gvwW) {
        this.gvwW = gvwW;
    }

    @Basic
    @Column(name = "gvw_hg")
    public Double getGvwHg() {
        return gvwHg;
    }

    public void setGvwHg(Double gvwHg) {
        this.gvwHg = gvwHg;
    }

    @Basic
    @Column(name = "gvw_wr")
    public Double getGvwWr() {
        return gvwWr;
    }

    public void setGvwWr(Double gvwWr) {
        this.gvwWr = gvwWr;
    }

    @Basic
    @Column(name = "car_L")
    public Double getCarL() {
        return carL;
    }

    public void setCarL(Double carL) {
        this.carL = carL;
    }

    @Basic
    @Column(name = "car_slr")
    public Double getCarSlr() {
        return carSlr;
    }

    public void setCarSlr(Double carSlr) {
        this.carSlr = carSlr;
    }

    @Basic
    @Column(name = "frtCaliper")
    public Integer getFrtCaliper() {
        return frtCaliper;
    }

    public void setFrtCaliper(Integer frtCaliper) {
        this.frtCaliper = frtCaliper;
    }

    @Basic
    @Column(name = "frtRotor")
    public Integer getFrtRotor() {
        return frtRotor;
    }

    public void setFrtRotor(Integer frtRotor) {
        this.frtRotor = frtRotor;
    }

    @Basic
    @Column(name = "rrCaliper")
    public Integer getRrCaliper() {
        return rrCaliper;
    }

    public void setRrCaliper(Integer rrCaliper) {
        this.rrCaliper = rrCaliper;
    }

    @Basic
    @Column(name = "rrRotor")
    public Integer getRrRotor() {
        return rrRotor;
    }

    public void setRrRotor(Integer rrRotor) {
        this.rrRotor = rrRotor;
    }

    @Basic
    @Column(name = "bst_mc")
    public Integer getBstMc() {
        return bstMc;
    }

    public void setBstMc(Integer bstMc) {
        this.bstMc = bstMc;
    }

    @Basic
    @Column(name = "ped")
    public Integer getPed() {
        return ped;
    }

    public void setPed(Integer ped) {
        this.ped = ped;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VehicleEntity that = (VehicleEntity) o;

        if (id != that.id) return false;
        if (carMy != null ? !carMy.equals(that.carMy) : that.carMy != null) return false;
        if (lvwW != null ? !lvwW.equals(that.lvwW) : that.lvwW != null) return false;
        if (lvwHg != null ? !lvwHg.equals(that.lvwHg) : that.lvwHg != null) return false;
        if (lvwWr != null ? !lvwWr.equals(that.lvwWr) : that.lvwWr != null) return false;
        if (gvwW != null ? !gvwW.equals(that.gvwW) : that.gvwW != null) return false;
        if (gvwHg != null ? !gvwHg.equals(that.gvwHg) : that.gvwHg != null) return false;
        if (gvwWr != null ? !gvwWr.equals(that.gvwWr) : that.gvwWr != null) return false;
        if (carL != null ? !carL.equals(that.carL) : that.carL != null) return false;
        if (carSlr != null ? !carSlr.equals(that.carSlr) : that.carSlr != null) return false;
        if (frtCaliper != null ? !frtCaliper.equals(that.frtCaliper) : that.frtCaliper != null) return false;
        if (frtRotor != null ? !frtRotor.equals(that.frtRotor) : that.frtRotor != null) return false;
        if (rrCaliper != null ? !rrCaliper.equals(that.rrCaliper) : that.rrCaliper != null) return false;
        if (rrRotor != null ? !rrRotor.equals(that.rrRotor) : that.rrRotor != null) return false;
        if (bstMc != null ? !bstMc.equals(that.bstMc) : that.bstMc != null) return false;
        if (ped != null ? !ped.equals(that.ped) : that.ped != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (carMy != null ? carMy.hashCode() : 0);
        result = 31 * result + (lvwW != null ? lvwW.hashCode() : 0);
        result = 31 * result + (lvwHg != null ? lvwHg.hashCode() : 0);
        result = 31 * result + (lvwWr != null ? lvwWr.hashCode() : 0);
        result = 31 * result + (gvwW != null ? gvwW.hashCode() : 0);
        result = 31 * result + (gvwHg != null ? gvwHg.hashCode() : 0);
        result = 31 * result + (gvwWr != null ? gvwWr.hashCode() : 0);
        result = 31 * result + (carL != null ? carL.hashCode() : 0);
        result = 31 * result + (carSlr != null ? carSlr.hashCode() : 0);
        result = 31 * result + (frtCaliper != null ? frtCaliper.hashCode() : 0);
        result = 31 * result + (frtRotor != null ? frtRotor.hashCode() : 0);
        result = 31 * result + (rrCaliper != null ? rrCaliper.hashCode() : 0);
        result = 31 * result + (rrRotor != null ? rrRotor.hashCode() : 0);
        result = 31 * result + (bstMc != null ? bstMc.hashCode() : 0);
        result = 31 * result + (ped != null ? ped.hashCode() : 0);
        return result;
    }
}
