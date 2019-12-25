package com.humanup.adminmatrix.vo;

public class RoleVO {
    private String roleTitle;
    private String roleDescription;

    public RoleVO() {
    }

    public RoleVO(String roleTitle, String roleDescription) {
        this.roleTitle = roleTitle;
        this.roleDescription = roleDescription;
    }

    public String getRoleTitle() {
        return this.roleTitle;
    }
    public String getRoleDescription() {
        return this.roleDescription;
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

        public RoleVO build() {
            return new RoleVO(roleTitle, roleDescription);
        }
    }

}
