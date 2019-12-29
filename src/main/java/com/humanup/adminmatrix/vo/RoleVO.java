package com.humanup.adminmatrix.vo;

public class RoleVO {
    private String roleTitle;
    private String roleDescription;
    private int countAccount;

    public RoleVO() {
    }

    public RoleVO(String roleTitle, String roleDescription, int countAccount) {
        this.roleTitle = roleTitle;
        this.roleDescription = roleDescription;
        this.countAccount = countAccount;
    }

    public String getRoleTitle() {
        return this.roleTitle;
    }
    public String getRoleDescription() {
        return this.roleDescription;
    }
    public int getCountAccount() {
        return countAccount;
    }

    public static class Builder{
        private String roleTitle;
        private String roleDescription;
        private int countAccount;

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

        public Builder setCountAccount(int countAccount) {
            this.countAccount = countAccount;
            return this;
        }


        public RoleVO build() {
            return new RoleVO(roleTitle, roleDescription, countAccount);
        }
    }

}
