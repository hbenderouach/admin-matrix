package com.humanup.adminmatrix.vo;

public class AccountVO {

    private String accountMailAdresse;
    private String accountFirstName;
    private String accountLastName;
    private String accountRole;

    public AccountVO() {
    }

    public AccountVO(String accountMailAdresse, String accountFirstName, String accountLastName, String accountRole) {
        this.accountMailAdresse = accountMailAdresse;
        this.accountFirstName = accountFirstName;
        this.accountLastName = accountLastName;
        this.accountRole = accountRole;
    }

    public String getAccountMailAdresse() {
        return accountMailAdresse;
    }

    public String getAccountFirstName() {
        return accountFirstName;
    }

    public String getAccountLastName() {
        return accountLastName;
    }

    public String getAccountRole() {
        return accountRole;
    }

    public static class Builder {
        private String accountMailAdresse;
        private String accountFirstName;
        private String accountLastName;
        private String accountRole;

        public Builder() {
        }

        public Builder setAccountMailAdresse(String accountMailAdresse) {
            this.accountMailAdresse = accountMailAdresse;
            return this;
        }

        public Builder setAccountFirstName(String accountFirstName) {
            this.accountFirstName = accountFirstName;
            return this;
        }

        public Builder setAccountLastName(String accountLastName) {
            this.accountLastName = accountLastName;
            return this;
        }

        public Builder setAccountRole(String accountRole) {
            this.accountRole = accountRole;
            return this;
        }

        public AccountVO build() {
            return new AccountVO(accountMailAdresse, accountFirstName, accountLastName, accountRole);
        }
    }

}
