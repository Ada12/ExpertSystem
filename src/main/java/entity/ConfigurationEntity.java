package entity;

import javax.persistence.*;

/**
 * Created by yangchen on 17/12/25.
 */
@Entity
@Table(name = "configuration", schema = "expert_system", catalog = "")
public class ConfigurationEntity {
    private int id;
    private String description;
    private Integer vehicleId;
    private Integer tireId;
    private Integer applyId;
    private Integer controlId;
    private Integer discBrakeId;
    private Integer drumBrakeId;
    private Integer requireId;
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
    @Column(name = "vehicle_id")
    public Integer getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    @Basic
    @Column(name = "tire_id")
    public Integer getTireId() {
        return tireId;
    }

    public void setTireId(Integer tireId) {
        this.tireId = tireId;
    }

    @Basic
    @Column(name = "apply_id")
    public Integer getApplyId() {
        return applyId;
    }

    public void setApplyId(Integer applyId) {
        this.applyId = applyId;
    }

    @Basic
    @Column(name = "control_id")
    public Integer getControlId() {
        return controlId;
    }

    public void setControlId(Integer controlId) {
        this.controlId = controlId;
    }

    @Basic
    @Column(name = "disc_brake_id")
    public Integer getDiscBrakeId() {
        return discBrakeId;
    }

    public void setDiscBrakeId(Integer discBrakeId) {
        this.discBrakeId = discBrakeId;
    }

    @Basic
    @Column(name = "drum_brake_id")
    public Integer getDrumBrakeId() {
        return drumBrakeId;
    }

    public void setDrumBrakeId(Integer drumBrakeId) {
        this.drumBrakeId = drumBrakeId;
    }

    @Basic
    @Column(name = "require_id")
    public Integer getRequireId() {
        return requireId;
    }

    public void setRequireId(Integer requireId) {
        this.requireId = requireId;
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

        ConfigurationEntity entity = (ConfigurationEntity) o;

        if (id != entity.id) return false;
        if (description != null ? !description.equals(entity.description) : entity.description != null) return false;
        if (vehicleId != null ? !vehicleId.equals(entity.vehicleId) : entity.vehicleId != null) return false;
        if (tireId != null ? !tireId.equals(entity.tireId) : entity.tireId != null) return false;
        if (applyId != null ? !applyId.equals(entity.applyId) : entity.applyId != null) return false;
        if (controlId != null ? !controlId.equals(entity.controlId) : entity.controlId != null) return false;
        if (discBrakeId != null ? !discBrakeId.equals(entity.discBrakeId) : entity.discBrakeId != null) return false;
        if (drumBrakeId != null ? !drumBrakeId.equals(entity.drumBrakeId) : entity.drumBrakeId != null) return false;
        if (requireId != null ? !requireId.equals(entity.requireId) : entity.requireId != null) return false;
        if (notes != null ? !notes.equals(entity.notes) : entity.notes != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (vehicleId != null ? vehicleId.hashCode() : 0);
        result = 31 * result + (tireId != null ? tireId.hashCode() : 0);
        result = 31 * result + (applyId != null ? applyId.hashCode() : 0);
        result = 31 * result + (controlId != null ? controlId.hashCode() : 0);
        result = 31 * result + (discBrakeId != null ? discBrakeId.hashCode() : 0);
        result = 31 * result + (drumBrakeId != null ? drumBrakeId.hashCode() : 0);
        result = 31 * result + (requireId != null ? requireId.hashCode() : 0);
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        return result;
    }
}
