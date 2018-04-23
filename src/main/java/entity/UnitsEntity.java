package entity;

import javax.persistence.*;

/**
 * Created by yangchen on 2018/4/3.
 */
@Entity
@Table(name = "units", schema = "expert_system", catalog = "")
public class UnitsEntity {
    private int id;
    private String attriName;
    private String unitName;

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
    @Column(name = "attri_name")
    public String getAttriName() {
        return attriName;
    }

    public void setAttriName(String attriName) {
        this.attriName = attriName;
    }

    @Basic
    @Column(name = "unit_name")
    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UnitsEntity that = (UnitsEntity) o;

        if (id != that.id) return false;
        if (attriName != null ? !attriName.equals(that.attriName) : that.attriName != null) return false;
        if (unitName != null ? !unitName.equals(that.unitName) : that.unitName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (attriName != null ? attriName.hashCode() : 0);
        result = 31 * result + (unitName != null ? unitName.hashCode() : 0);
        return result;
    }
}
