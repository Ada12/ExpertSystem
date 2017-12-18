package entity;

import javax.persistence.*;

/**
 * Created by yangchen on 17/7/1.
 */
@Entity
@Table(name = "model_process_list", schema = "expert_system", catalog = "")
public class ModelProcessListEntity {
    private int id;
    private String processJson;
    private String processDec;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "process_json")
    public String getProcessJson() {
        return processJson;
    }

    public void setProcessJson(String processJson) {
        this.processJson = processJson;
    }

    @Basic
    @Column(name = "process_dec")
    public String getProcessDec() {
        return processDec;
    }

    public void setProcessDec(String processDec) {
        this.processDec = processDec;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ModelProcessListEntity that = (ModelProcessListEntity) o;

        if (id != that.id) return false;
        if (processJson != null ? !processJson.equals(that.processJson) : that.processJson != null) return false;
        if (processDec != null ? !processDec.equals(that.processDec) : that.processDec != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (processJson != null ? processJson.hashCode() : 0);
        result = 31 * result + (processDec != null ? processDec.hashCode() : 0);
        return result;
    }
}
