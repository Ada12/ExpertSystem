package entity;

import javax.persistence.*;

/**
 * Created by yangchen on 17/7/1.
 */
@Entity
@Table(name = "meta_calculate_list", schema = "expert_system", catalog = "")
public class MetaCalculateListEntity {
    private int id;
    private String desc;
    private String invokeDescJson;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "desc")
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Basic
    @Column(name = "invoke_desc_json")
    public String getInvokeDescJson() {
        return invokeDescJson;
    }

    public void setInvokeDescJson(String invokeDescJson) {
        this.invokeDescJson = invokeDescJson;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MetaCalculateListEntity that = (MetaCalculateListEntity) o;

        if (id != that.id) return false;
        if (desc != null ? !desc.equals(that.desc) : that.desc != null) return false;
        if (invokeDescJson != null ? !invokeDescJson.equals(that.invokeDescJson) : that.invokeDescJson != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (desc != null ? desc.hashCode() : 0);
        result = 31 * result + (invokeDescJson != null ? invokeDescJson.hashCode() : 0);
        return result;
    }
}
