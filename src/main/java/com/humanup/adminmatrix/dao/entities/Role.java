package com.humanup.adminmatrix.dao.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long roleId;
    private String roleTitle;
    private String roleDescription;

    @OneToMany(mappedBy="role",fetch=FetchType.LAZY)
    private List<Account> accountList;

    @OneToMany(mappedBy="role",fetch=FetchType.LAZY)
    private List<Authorization> authorizationList;

    protected Role() {}

    public Role(String roleTitle, String roleDescription) {
        this.roleTitle = roleTitle;
        this.roleDescription = roleDescription;
    }

    @Override
    public String toString() {
        return String.format(
                "Role[id=%d, RoleTitle='%s', RoleDescription='%s']",
                roleId, roleTitle, roleDescription);
    }


    public Long getId() {
        return this.roleId;
    }
    public String getRoleTitle() {
        return this.roleTitle;
    }
    public String getRoleDescription() {
        return this.roleDescription;
    }
    public List<Account> getAccountList() {
        return this.accountList;
    }
    public List<Authorization> getAuthorization() {
        return this.authorizationList;
    }

    public static class Builder{

        private String roleTitle;
        private String roleDescription;

        public Builder() {
        }

        public Builder setRoleTitle(String roleTitle) {
            this.roleTitle = roleTitle;
            return this;
        }

        public Builder setRoleDescription(String roleDescription) {
            this.roleDescription = roleDescription;
            return this;
        }

        public Role build(){
            return new Role(roleTitle,  roleDescription);
        }
    }

}
