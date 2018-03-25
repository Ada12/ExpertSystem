package entity;

import javax.persistence.*;

/**
 * Created by yangchen on 2018/3/13.
 */
@Entity
@Table(name = "configuration", schema = "expert_system", catalog = "")
public class ConfigurationEntity {
    private int id;
    private String description;
    private String vehicleDesc;
    private String tireDesc;
    private String applyDesc;
    private String controlDesc;
    private String discBrakeDesc;
    private String drumBrakeDesc;
    private String requireDesc;
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
    @Column(name = "vehicle_desc")
    public String getVehicleDesc() {
        return vehicleDesc;
    }

    public void setVehicleDesc(String vehicleDesc) {
        this.vehicleDesc = vehicleDesc;
    }

    @Basic
    @Column(name = "tire_desc")
    public String getTireDesc() {
        return tireDesc;
    }

    public void setTireDesc(String tireDesc) {
        this.tireDesc = tireDesc;
    }

    @Basic
    @Column(name = "apply_desc")
    public String getApplyDesc() {
        return applyDesc;
    }

    public void setApplyDesc(String applyDesc) {
        this.applyDesc = applyDesc;
    }

    @Basic
    @Column(name = "control_desc")
    public String getControlDesc() {
        return controlDesc;
    }

    public void setControlDesc(String controlDesc) {
        this.controlDesc = controlDesc;
    }

    @Basic
    @Column(name = "disc_brake_desc")
    public String getDiscBrakeDesc() {
        return discBrakeDesc;
    }

    public void setDiscBrakeDesc(String discBrakeDesc) {
        this.discBrakeDesc = discBrakeDesc;
    }

    @Basic
    @Column(name = "drum_brake_desc")
    public String getDrumBrakeDesc() {
        return drumBrakeDesc;
    }

    public void setDrumBrakeDesc(String drumBrakeDesc) {
        this.drumBrakeDesc = drumBrakeDesc;
    }

    @Basic
    @Column(name = "require_desc")
    public String getRequireDesc() {
        return requireDesc;
    }

    public void setRequireDesc(String requireDesc) {
        this.requireDesc = requireDesc;
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
    @Column(name = "userId")
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

        ConfigurationEntity that = (ConfigurationEntity) o;

        if (id != that.id) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (vehicleDesc != null ? !vehicleDesc.equals(that.vehicleDesc) : that.vehicleDesc != null) return false;
        if (tireDesc != null ? !tireDesc.equals(that.tireDesc) : that.tireDesc != null) return false;
        if (applyDesc != null ? !applyDesc.equals(that.applyDesc) : that.applyDesc != null) return false;
        if (controlDesc != null ? !controlDesc.equals(that.controlDesc) : that.controlDesc != null) return false;
        if (discBrakeDesc != null ? !discBrakeDesc.equals(that.discBrakeDesc) : that.discBrakeDesc != null)
            return false;
        if (drumBrakeDesc != null ? !drumBrakeDesc.equals(that.drumBrakeDesc) : that.drumBrakeDesc != null)
            return false;
        if (requireDesc != null ? !requireDesc.equals(that.requireDesc) : that.requireDesc != null) return false;
        if (isWork != null ? !isWork.equals(that.isWork) : that.isWork != null) return false;
        if (notes != null ? !notes.equals(that.notes) : that.notes != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (vehicleDesc != null ? vehicleDesc.hashCode() : 0);
        result = 31 * result + (tireDesc != null ? tireDesc.hashCode() : 0);
        result = 31 * result + (applyDesc != null ? applyDesc.hashCode() : 0);
        result = 31 * result + (controlDesc != null ? controlDesc.hashCode() : 0);
        result = 31 * result + (discBrakeDesc != null ? discBrakeDesc.hashCode() : 0);
        result = 31 * result + (drumBrakeDesc != null ? drumBrakeDesc.hashCode() : 0);
        result = 31 * result + (requireDesc != null ? requireDesc.hashCode() : 0);
        result = 31 * result + (isWork != null ? isWork.hashCode() : 0);
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }
}
