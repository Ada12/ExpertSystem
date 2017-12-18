package entity;

import javax.persistence.*;

/**
 * Created by yangchen on 17/7/1.
 */
@Entity
@Table(name = "pedal", schema = "expert_system", catalog = "")
public class PedalEntity {
    private int id;
    private Integer pedType;
    private Double pedRatio;
    private Double pedFEff;
    private Double pedTEff;
    private String pedSpl;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ped_type")
    public Integer getPedType() {
        return pedType;
    }

    public void setPedType(Integer pedType) {
        this.pedType = pedType;
    }

    @Basic
    @Column(name = "ped_ratio")
    public Double getPedRatio() {
        return pedRatio;
    }

    public void setPedRatio(Double pedRatio) {
        this.pedRatio = pedRatio;
    }

    @Basic
    @Column(name = "ped_F_eff")
    public Double getPedFEff() {
        return pedFEff;
    }

    public void setPedFEff(Double pedFEff) {
        this.pedFEff = pedFEff;
    }

    @Basic
    @Column(name = "ped_T_eff")
    public Double getPedTEff() {
        return pedTEff;
    }

    public void setPedTEff(Double pedTEff) {
        this.pedTEff = pedTEff;
    }

    @Basic
    @Column(name = "ped_spl")
    public String getPedSpl() {
        return pedSpl;
    }

    public void setPedSpl(String pedSpl) {
        this.pedSpl = pedSpl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PedalEntity that = (PedalEntity) o;

        if (id != that.id) return false;
        if (pedType != null ? !pedType.equals(that.pedType) : that.pedType != null) return false;
        if (pedRatio != null ? !pedRatio.equals(that.pedRatio) : that.pedRatio != null) return false;
        if (pedFEff != null ? !pedFEff.equals(that.pedFEff) : that.pedFEff != null) return false;
        if (pedTEff != null ? !pedTEff.equals(that.pedTEff) : that.pedTEff != null) return false;
        if (pedSpl != null ? !pedSpl.equals(that.pedSpl) : that.pedSpl != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (pedType != null ? pedType.hashCode() : 0);
        result = 31 * result + (pedRatio != null ? pedRatio.hashCode() : 0);
        result = 31 * result + (pedFEff != null ? pedFEff.hashCode() : 0);
        result = 31 * result + (pedTEff != null ? pedTEff.hashCode() : 0);
        result = 31 * result + (pedSpl != null ? pedSpl.hashCode() : 0);
        return result;
    }
}
