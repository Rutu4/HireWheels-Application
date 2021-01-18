package com.upgrad.hirewheels.entities;
import javax.persistence.*;

@Entity
public class Role {

    @Id
    @GeneratedValue
    @Column(name = "role_id")
    private int roleId;

    @Column(name = "role_name", nullable = false, unique = true)
    private String roleName;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "Role{roleId="+roleId
                +", roleName="+roleName
                +"}";
    }
}
