package entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by yangchen on 17/7/2.
 */
@Entity
@Table(name = "instance_lib", schema = "expert_system", catalog = "")
public class InstanceLibEntity {
    private int id;
    private Double w;
    private Double hg;
    private Double wr;
    private Double carL;
    private Double carSlr;
    private Integer frtCaliper;
    private Integer frtRotor;
    private Integer rrCaliper;
    private Integer rrRotor;
    private Integer bstMc;
    private Integer ped;
    private Integer userId;
    private Timestamp geneTime;
    private Integer evaId;
    private Integer type;

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "w")
    public Double getW() {
        return w;
    }

    public void setW(Double w) {
        this.w = w;
    }

    @Basic
    @Column(name = "hg")
    public Double getHg() {
        return hg;
    }

    public void setHg(Double hg) {
        this.hg = hg;
    }

    @Basic
    @Column(name = "wr")
    public Double getWr() {
        return wr;
    }

    public void setWr(Double wr) {
        this.wr = wr;
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

    @Basic
    @Column(name = "user_id")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "gene_time")
    public Timestamp getGeneTime() {
        return geneTime;
    }

    public void setGeneTime(Timestamp geneTime) {
        this.geneTime = geneTime;
    }

    @Basic
    @Column(name = "eva_id")
    public Integer getEvaId() {
        return evaId;
    }

    public void setEvaId(Integer evaId) {
        this.evaId = evaId;
    }

    @Basic
    @Column(name = "type")
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InstanceLibEntity entity = (InstanceLibEntity) o;

        if (id != entity.id) return false;
        if (w != null ? !w.equals(entity.w) : entity.w != null) return false;
        if (hg != null ? !hg.equals(entity.hg) : entity.hg != null) return false;
        if (wr != null ? !wr.equals(entity.wr) : entity.wr != null) return false;
        if (carL != null ? !carL.equals(entity.carL) : entity.carL != null) return false;
        if (carSlr != null ? !carSlr.equals(entity.carSlr) : entity.carSlr != null) return false;
        if (frtCaliper != null ? !frtCaliper.equals(entity.frtCaliper) : entity.frtCaliper != null) return false;
        if (frtRotor != null ? !frtRotor.equals(entity.frtRotor) : entity.frtRotor != null) return false;
        if (rrCaliper != null ? !rrCaliper.equals(entity.rrCaliper) : entity.rrCaliper != null) return false;
        if (rrRotor != null ? !rrRotor.equals(entity.rrRotor) : entity.rrRotor != null) return false;
        if (bstMc != null ? !bstMc.equals(entity.bstMc) : entity.bstMc != null) return false;
        if (ped != null ? !ped.equals(entity.ped) : entity.ped != null) return false;
        if (userId != null ? !userId.equals(entity.userId) : entity.userId != null) return false;
        if (geneTime != null ? !geneTime.equals(entity.geneTime) : entity.geneTime != null) return false;
        if (evaId != null ? !evaId.equals(entity.evaId) : entity.evaId != null) return false;
        if (type != null ? !type.equals(entity.type) : entity.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (w != null ? w.hashCode() : 0);
        result = 31 * result + (hg != null ? hg.hashCode() : 0);
        result = 31 * result + (wr != null ? wr.hashCode() : 0);
        result = 31 * result + (carL != null ? carL.hashCode() : 0);
        result = 31 * result + (carSlr != null ? carSlr.hashCode() : 0);
        result = 31 * result + (frtCaliper != null ? frtCaliper.hashCode() : 0);
        result = 31 * result + (frtRotor != null ? frtRotor.hashCode() : 0);
        result = 31 * result + (rrCaliper != null ? rrCaliper.hashCode() : 0);
        result = 31 * result + (rrRotor != null ? rrRotor.hashCode() : 0);
        result = 31 * result + (bstMc != null ? bstMc.hashCode() : 0);
        result = 31 * result + (ped != null ? ped.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (geneTime != null ? geneTime.hashCode() : 0);
        result = 31 * result + (evaId != null ? evaId.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
