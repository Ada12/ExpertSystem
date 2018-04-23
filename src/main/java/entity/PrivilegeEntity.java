package entity;

import javax.persistence.*;

/**
 * Created by yangchen on 2018/4/3.
 */
@Entity
@Table(name = "privilege", schema = "expert_system", catalog = "")
public class PrivilegeEntity {
    private int privilegeId;
    private String privilegeName;
    private String comment;

    @Id
    @Column(name = "privilege_id")
    public int getPrivilegeId() {
        return privilegeId;
    }

    public void setPrivilegeId(int privilegeId) {
        this.privilegeId = privilegeId;
    }

    @Basic
    @Column(name = "privilege_name")
    public String getPrivilegeName() {
        return privilegeName;
    }

    public void setPrivilegeName(String privilegeName) {
        this.privilegeName = privilegeName;
    }

    @Basic
    @Column(name = "comment")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PrivilegeEntity that = (PrivilegeEntity) o;

        if (privilegeId != that.privilegeId) return false;
        if (privilegeName != null ? !privilegeName.equals(that.privilegeName) : that.privilegeName != null)
            return false;
        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = privilegeId;
        result = 31 * result + (privilegeName != null ? privilegeName.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        return result;
    }
}
