package entity;

import javax.persistence.*;

/**
 * Created by yangchen on 17/9/22.
 */
@Entity
@Table(name = "configuration", schema = "expert_system", catalog = "")
public class ConfigurationEntity {
    private int id;
    private String description;
    private String vehicleDesc;
    private String frontCornerDesc;
    private String rearCornerDesc;
    private String pedalDesc;
    private String absContralVaveDesc;
    private String masterCylinderDesc;
    private String boosterDesc;
    private Integer rearCornerNum;
    private Integer frontCornerNum;
    private String note;

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
    @Column(name = "vehicle_desc")
    public String getVehicleDesc() {
        return vehicleDesc;
    }

    public void setVehicleDesc(String vehicleDesc) {
        this.vehicleDesc = vehicleDesc;
    }

    @Basic
    @Column(name = "front_corner_desc")
    public String getFrontCornerDesc() {
        return frontCornerDesc;
    }

    public void setFrontCornerDesc(String frontCornerDesc) {
        this.frontCornerDesc = frontCornerDesc;
    }

    @Basic
    @Column(name = "rear_corner_desc")
    public String getRearCornerDesc() {
        return rearCornerDesc;
    }

    public void setRearCornerDesc(String rearCornerDesc) {
        this.rearCornerDesc = rearCornerDesc;
    }

    @Basic
    @Column(name = "pedal_desc")
    public String getPedalDesc() {
        return pedalDesc;
    }

    public void setPedalDesc(String pedalDesc) {
        this.pedalDesc = pedalDesc;
    }

    @Basic
    @Column(name = "ABS_contral_vave_desc")
    public String getAbsContralVaveDesc() {
        return absContralVaveDesc;
    }

    public void setAbsContralVaveDesc(String absContralVaveDesc) {
        this.absContralVaveDesc = absContralVaveDesc;
    }

    @Basic
    @Column(name = "master_cylinder_desc")
    public String getMasterCylinderDesc() {
        return masterCylinderDesc;
    }

    public void setMasterCylinderDesc(String masterCylinderDesc) {
        this.masterCylinderDesc = masterCylinderDesc;
    }

    @Basic
    @Column(name = "booster_desc")
    public String getBoosterDesc() {
        return boosterDesc;
    }

    public void setBoosterDesc(String boosterDesc) {
        this.boosterDesc = boosterDesc;
    }

    @Basic
    @Column(name = "rear_corner_num")
    public Integer getRearCornerNum() {
        return rearCornerNum;
    }

    public void setRearCornerNum(Integer rearCornerNum) {
        this.rearCornerNum = rearCornerNum;
    }

    @Basic
    @Column(name = "front_corner_num")
    public Integer getFrontCornerNum() {
        return frontCornerNum;
    }

    public void setFrontCornerNum(Integer frontCornerNum) {
        this.frontCornerNum = frontCornerNum;
    }

    @Basic
    @Column(name = "note")
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConfigurationEntity entity = (ConfigurationEntity) o;

        if (id != entity.id) return false;
        if (description != null ? !description.equals(entity.description) : entity.description != null) return false;
        if (vehicleDesc != null ? !vehicleDesc.equals(entity.vehicleDesc) : entity.vehicleDesc != null) return false;
        if (frontCornerDesc != null ? !frontCornerDesc.equals(entity.frontCornerDesc) : entity.frontCornerDesc != null)
            return false;
        if (rearCornerDesc != null ? !rearCornerDesc.equals(entity.rearCornerDesc) : entity.rearCornerDesc != null)
            return false;
        if (pedalDesc != null ? !pedalDesc.equals(entity.pedalDesc) : entity.pedalDesc != null) return false;
        if (absContralVaveDesc != null ? !absContralVaveDesc.equals(entity.absContralVaveDesc) : entity.absContralVaveDesc != null)
            return false;
        if (masterCylinderDesc != null ? !masterCylinderDesc.equals(entity.masterCylinderDesc) : entity.masterCylinderDesc != null)
            return false;
        if (boosterDesc != null ? !boosterDesc.equals(entity.boosterDesc) : entity.boosterDesc != null) return false;
        if (rearCornerNum != null ? !rearCornerNum.equals(entity.rearCornerNum) : entity.rearCornerNum != null)
            return false;
        if (frontCornerNum != null ? !frontCornerNum.equals(entity.frontCornerNum) : entity.frontCornerNum != null)
            return false;
        if (note != null ? !note.equals(entity.note) : entity.note != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (vehicleDesc != null ? vehicleDesc.hashCode() : 0);
        result = 31 * result + (frontCornerDesc != null ? frontCornerDesc.hashCode() : 0);
        result = 31 * result + (rearCornerDesc != null ? rearCornerDesc.hashCode() : 0);
        result = 31 * result + (pedalDesc != null ? pedalDesc.hashCode() : 0);
        result = 31 * result + (absContralVaveDesc != null ? absContralVaveDesc.hashCode() : 0);
        result = 31 * result + (masterCylinderDesc != null ? masterCylinderDesc.hashCode() : 0);
        result = 31 * result + (boosterDesc != null ? boosterDesc.hashCode() : 0);
        result = 31 * result + (rearCornerNum != null ? rearCornerNum.hashCode() : 0);
        result = 31 * result + (frontCornerNum != null ? frontCornerNum.hashCode() : 0);
        result = 31 * result + (note != null ? note.hashCode() : 0);
        return result;
    }
}
