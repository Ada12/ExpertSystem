package entity;

import javax.persistence.*;

/**
 * Created by yangchen on 2018/4/3.
 */
@Entity
@Table(name = "basic_parking", schema = "expert_system", catalog = "")
public class BasicParkingEntity {
    private int id;
    private String description;
    private Double elf;
    private Double ecf;
    private Double ect;
    private Double a;
    private Double rv;
    private Double av;
    private Double ad;
    private Double a0;
    private Double dh;
    private Double sigema0;
    private Double sita;
    private Integer userId;
    private Integer isWork;
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
    @Column(name = "elf")
    public Double getElf() {
        return elf;
    }

    public void setElf(Double elf) {
        this.elf = elf;
    }

    @Basic
    @Column(name = "ecf")
    public Double getEcf() {
        return ecf;
    }

    public void setEcf(Double ecf) {
        this.ecf = ecf;
    }

    @Basic
    @Column(name = "ect")
    public Double getEct() {
        return ect;
    }

    public void setEct(Double ect) {
        this.ect = ect;
    }

    @Basic
    @Column(name = "a")
    public Double getA() {
        return a;
    }

    public void setA(Double a) {
        this.a = a;
    }

    @Basic
    @Column(name = "rv")
    public Double getRv() {
        return rv;
    }

    public void setRv(Double rv) {
        this.rv = rv;
    }

    @Basic
    @Column(name = "av")
    public Double getAv() {
        return av;
    }

    public void setAv(Double av) {
        this.av = av;
    }

    @Basic
    @Column(name = "ad")
    public Double getAd() {
        return ad;
    }

    public void setAd(Double ad) {
        this.ad = ad;
    }

    @Basic
    @Column(name = "a0")
    public Double getA0() {
        return a0;
    }

    public void setA0(Double a0) {
        this.a0 = a0;
    }

    @Basic
    @Column(name = "dh")
    public Double getDh() {
        return dh;
    }

    public void setDh(Double dh) {
        this.dh = dh;
    }

    @Basic
    @Column(name = "sigema0")
    public Double getSigema0() {
        return sigema0;
    }

    public void setSigema0(Double sigema0) {
        this.sigema0 = sigema0;
    }

    @Basic
    @Column(name = "sita")
    public Double getSita() {
        return sita;
    }

    public void setSita(Double sita) {
        this.sita = sita;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BasicParkingEntity that = (BasicParkingEntity) o;

        if (id != that.id) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (elf != null ? !elf.equals(that.elf) : that.elf != null) return false;
        if (ecf != null ? !ecf.equals(that.ecf) : that.ecf != null) return false;
        if (ect != null ? !ect.equals(that.ect) : that.ect != null) return false;
        if (a != null ? !a.equals(that.a) : that.a != null) return false;
        if (rv != null ? !rv.equals(that.rv) : that.rv != null) return false;
        if (av != null ? !av.equals(that.av) : that.av != null) return false;
        if (ad != null ? !ad.equals(that.ad) : that.ad != null) return false;
        if (a0 != null ? !a0.equals(that.a0) : that.a0 != null) return false;
        if (dh != null ? !dh.equals(that.dh) : that.dh != null) return false;
        if (sigema0 != null ? !sigema0.equals(that.sigema0) : that.sigema0 != null) return false;
        if (sita != null ? !sita.equals(that.sita) : that.sita != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (isWork != null ? !isWork.equals(that.isWork) : that.isWork != null) return false;
        if (notes != null ? !notes.equals(that.notes) : that.notes != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (elf != null ? elf.hashCode() : 0);
        result = 31 * result + (ecf != null ? ecf.hashCode() : 0);
        result = 31 * result + (ect != null ? ect.hashCode() : 0);
        result = 31 * result + (a != null ? a.hashCode() : 0);
        result = 31 * result + (rv != null ? rv.hashCode() : 0);
        result = 31 * result + (av != null ? av.hashCode() : 0);
        result = 31 * result + (ad != null ? ad.hashCode() : 0);
        result = 31 * result + (a0 != null ? a0.hashCode() : 0);
        result = 31 * result + (dh != null ? dh.hashCode() : 0);
        result = 31 * result + (sigema0 != null ? sigema0.hashCode() : 0);
        result = 31 * result + (sita != null ? sita.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (isWork != null ? isWork.hashCode() : 0);
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        return result;
    }
}
