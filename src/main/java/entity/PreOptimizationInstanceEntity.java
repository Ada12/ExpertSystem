package entity;

import javax.persistence.*;

/**
 * Created by yangchen on 2018/6/1.
 */
@Entity
@Table(name = "pre_optimization_instance", schema = "expert_system", catalog = "")
public class PreOptimizationInstanceEntity {
    private int id;
    private String description;
    private String carModel;
    private Double carYear;
    private String carDa;
    private String carAddInfo;
    private Double lvwM;
    private Double lvwFrtR;
    private Double lvwCgh;
    private Double gvwM;
    private Double gvwFrtR;
    private Double gvwCgh;
    private Double l;
    private Double vmax;
    private Double wot;
    private Double coastDecel;
    private Double cd;
    private Double a;
    private String indexContent;
    private Integer pedal;
    private Integer apply;
    private Integer frtClp;
    private Integer frtLin;
    private Integer frtRt;
    private Integer rrClp;
    private Integer rrLin;
    private Integer rrRt;
    private Integer abs;
    private Integer tire;
    private Integer isWork;
    private String notes;
    private Integer userId;

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
    @Column(name = "carAddInfo")
    public String getCarAddInfo() {
        return carAddInfo;
    }

    public void setCarAddInfo(String carAddInfo) {
        this.carAddInfo = carAddInfo;
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
    @Column(name = "coast_decel")
    public Double getCoastDecel() {
        return coastDecel;
    }

    public void setCoastDecel(Double coastDecel) {
        this.coastDecel = coastDecel;
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
    @Column(name = "index_content")
    public String getIndexContent() {
        return indexContent;
    }

    public void setIndexContent(String indexContent) {
        this.indexContent = indexContent;
    }

    @Basic
    @Column(name = "pedal")
    public Integer getPedal() {
        return pedal;
    }

    public void setPedal(Integer pedal) {
        this.pedal = pedal;
    }

    @Basic
    @Column(name = "apply")
    public Integer getApply() {
        return apply;
    }

    public void setApply(Integer apply) {
        this.apply = apply;
    }

    @Basic
    @Column(name = "frt_clp")
    public Integer getFrtClp() {
        return frtClp;
    }

    public void setFrtClp(Integer frtClp) {
        this.frtClp = frtClp;
    }

    @Basic
    @Column(name = "frt_lin")
    public Integer getFrtLin() {
        return frtLin;
    }

    public void setFrtLin(Integer frtLin) {
        this.frtLin = frtLin;
    }

    @Basic
    @Column(name = "frt_rt")
    public Integer getFrtRt() {
        return frtRt;
    }

    public void setFrtRt(Integer frtRt) {
        this.frtRt = frtRt;
    }

    @Basic
    @Column(name = "rr_clp")
    public Integer getRrClp() {
        return rrClp;
    }

    public void setRrClp(Integer rrClp) {
        this.rrClp = rrClp;
    }

    @Basic
    @Column(name = "rr_lin")
    public Integer getRrLin() {
        return rrLin;
    }

    public void setRrLin(Integer rrLin) {
        this.rrLin = rrLin;
    }

    @Basic
    @Column(name = "rr_rt")
    public Integer getRrRt() {
        return rrRt;
    }

    public void setRrRt(Integer rrRt) {
        this.rrRt = rrRt;
    }

    @Basic
    @Column(name = "abs")
    public Integer getAbs() {
        return abs;
    }

    public void setAbs(Integer abs) {
        this.abs = abs;
    }

    @Basic
    @Column(name = "tire")
    public Integer getTire() {
        return tire;
    }

    public void setTire(Integer tire) {
        this.tire = tire;
    }

    @Basic
    @Column(name = "is_work")
    public Integer getIsWork() {
        return isWork;
    }

    public void setIsWork(Integer isWork) {
        this.isWork = isWork;
    }

    @Basic
    @Column(name = "notes")
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Basic
    @Column(name = "user_id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PreOptimizationInstanceEntity that = (PreOptimizationInstanceEntity) o;

        if (id != that.id) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (carModel != null ? !carModel.equals(that.carModel) : that.carModel != null) return false;
        if (carYear != null ? !carYear.equals(that.carYear) : that.carYear != null) return false;
        if (carDa != null ? !carDa.equals(that.carDa) : that.carDa != null) return false;
        if (carAddInfo != null ? !carAddInfo.equals(that.carAddInfo) : that.carAddInfo != null) return false;
        if (lvwM != null ? !lvwM.equals(that.lvwM) : that.lvwM != null) return false;
        if (lvwFrtR != null ? !lvwFrtR.equals(that.lvwFrtR) : that.lvwFrtR != null) return false;
        if (lvwCgh != null ? !lvwCgh.equals(that.lvwCgh) : that.lvwCgh != null) return false;
        if (gvwM != null ? !gvwM.equals(that.gvwM) : that.gvwM != null) return false;
        if (gvwFrtR != null ? !gvwFrtR.equals(that.gvwFrtR) : that.gvwFrtR != null) return false;
        if (gvwCgh != null ? !gvwCgh.equals(that.gvwCgh) : that.gvwCgh != null) return false;
        if (l != null ? !l.equals(that.l) : that.l != null) return false;
        if (vmax != null ? !vmax.equals(that.vmax) : that.vmax != null) return false;
        if (wot != null ? !wot.equals(that.wot) : that.wot != null) return false;
        if (coastDecel != null ? !coastDecel.equals(that.coastDecel) : that.coastDecel != null) return false;
        if (cd != null ? !cd.equals(that.cd) : that.cd != null) return false;
        if (a != null ? !a.equals(that.a) : that.a != null) return false;
        if (indexContent != null ? !indexContent.equals(that.indexContent) : that.indexContent != null) return false;
        if (pedal != null ? !pedal.equals(that.pedal) : that.pedal != null) return false;
        if (apply != null ? !apply.equals(that.apply) : that.apply != null) return false;
        if (frtClp != null ? !frtClp.equals(that.frtClp) : that.frtClp != null) return false;
        if (frtLin != null ? !frtLin.equals(that.frtLin) : that.frtLin != null) return false;
        if (frtRt != null ? !frtRt.equals(that.frtRt) : that.frtRt != null) return false;
        if (rrClp != null ? !rrClp.equals(that.rrClp) : that.rrClp != null) return false;
        if (rrLin != null ? !rrLin.equals(that.rrLin) : that.rrLin != null) return false;
        if (rrRt != null ? !rrRt.equals(that.rrRt) : that.rrRt != null) return false;
        if (abs != null ? !abs.equals(that.abs) : that.abs != null) return false;
        if (tire != null ? !tire.equals(that.tire) : that.tire != null) return false;
        if (isWork != null ? !isWork.equals(that.isWork) : that.isWork != null) return false;
        if (notes != null ? !notes.equals(that.notes) : that.notes != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (carModel != null ? carModel.hashCode() : 0);
        result = 31 * result + (carYear != null ? carYear.hashCode() : 0);
        result = 31 * result + (carDa != null ? carDa.hashCode() : 0);
        result = 31 * result + (carAddInfo != null ? carAddInfo.hashCode() : 0);
        result = 31 * result + (lvwM != null ? lvwM.hashCode() : 0);
        result = 31 * result + (lvwFrtR != null ? lvwFrtR.hashCode() : 0);
        result = 31 * result + (lvwCgh != null ? lvwCgh.hashCode() : 0);
        result = 31 * result + (gvwM != null ? gvwM.hashCode() : 0);
        result = 31 * result + (gvwFrtR != null ? gvwFrtR.hashCode() : 0);
        result = 31 * result + (gvwCgh != null ? gvwCgh.hashCode() : 0);
        result = 31 * result + (l != null ? l.hashCode() : 0);
        result = 31 * result + (vmax != null ? vmax.hashCode() : 0);
        result = 31 * result + (wot != null ? wot.hashCode() : 0);
        result = 31 * result + (coastDecel != null ? coastDecel.hashCode() : 0);
        result = 31 * result + (cd != null ? cd.hashCode() : 0);
        result = 31 * result + (a != null ? a.hashCode() : 0);
        result = 31 * result + (indexContent != null ? indexContent.hashCode() : 0);
        result = 31 * result + (pedal != null ? pedal.hashCode() : 0);
        result = 31 * result + (apply != null ? apply.hashCode() : 0);
        result = 31 * result + (frtClp != null ? frtClp.hashCode() : 0);
        result = 31 * result + (frtLin != null ? frtLin.hashCode() : 0);
        result = 31 * result + (frtRt != null ? frtRt.hashCode() : 0);
        result = 31 * result + (rrClp != null ? rrClp.hashCode() : 0);
        result = 31 * result + (rrLin != null ? rrLin.hashCode() : 0);
        result = 31 * result + (rrRt != null ? rrRt.hashCode() : 0);
        result = 31 * result + (abs != null ? abs.hashCode() : 0);
        result = 31 * result + (tire != null ? tire.hashCode() : 0);
        result = 31 * result + (isWork != null ? isWork.hashCode() : 0);
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }
}
