package entity;

import javax.persistence.*;

/**
 * Created by yangchen on 2018/4/3.
 */
@Entity
@Table(name = "role_prrivilege", schema = "expert_system", catalog = "")
public class RolePrrivilegeEntity {
    private int roleId;
    private Integer privilegeId;

    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "privilege_id")
    public Integer getPrivilegeId() {
        return privilegeId;
    }

    public void setPrivilegeId(Integer privilegeId) {
        this.privilegeId = privilegeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RolePrrivilegeEntity that = (RolePrrivilegeEntity) o;

        if (roleId != that.roleId) return false;
        if (privilegeId != null ? !privilegeId.equals(that.privilegeId) : that.privilegeId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roleId;
        result = 31 * result + (privilegeId != null ? privilegeId.hashCode() : 0);
        return result;
    }
}
