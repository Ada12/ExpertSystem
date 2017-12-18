package entity;

import javax.persistence.*;

/**
 * Created by yangchen on 17/7/1.
 */
@Entity
@Table(name = "model_process", schema = "expert_system", catalog = "")
public class ModelProcessEntity {
    private int id;
    private String inputJson;
    private String outputJson;
    private Integer metaCalId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "input_json")
    public String getInputJson() {
        return inputJson;
    }

    public void setInputJson(String inputJson) {
        this.inputJson = inputJson;
    }

    @Basic
    @Column(name = "output_json")
    public String getOutputJson() {
        return outputJson;
    }

    public void setOutputJson(String outputJson) {
        this.outputJson = outputJson;
    }

    @Basic
    @Column(name = "meta_cal_id")
    public Integer getMetaCalId() {
        return metaCalId;
    }

    public void setMetaCalId(Integer metaCalId) {
        this.metaCalId = metaCalId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ModelProcessEntity that = (ModelProcessEntity) o;

        if (id != that.id) return false;
        if (inputJson != null ? !inputJson.equals(that.inputJson) : that.inputJson != null) return false;
        if (outputJson != null ? !outputJson.equals(that.outputJson) : that.outputJson != null) return false;
        if (metaCalId != null ? !metaCalId.equals(that.metaCalId) : that.metaCalId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (inputJson != null ? inputJson.hashCode() : 0);
        result = 31 * result + (outputJson != null ? outputJson.hashCode() : 0);
        result = 31 * result + (metaCalId != null ? metaCalId.hashCode() : 0);
        return result;
    }
}
