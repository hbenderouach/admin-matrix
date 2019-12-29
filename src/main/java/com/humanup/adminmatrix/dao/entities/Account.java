package com.humanup.adminmatrix.dao.entities;

import javax.persistence.*;


@Entity

public class Account {

    @Id
    @Column(unique = true)
    private String accountMailAdresse;
    private String accountFirstName;
    private String accountLastName;

    @ManyToOne
    @JoinColumn(name = "roleId")
    private Role role;

    protected Account() {}

    public Account(String accountMailAdresse, String accountFirstName, String accountLastName, Role role) {
        this.accountMailAdresse = accountMailAdresse;
        this.accountFirstName = accountFirstName;
        this.accountLastName = accountLastName;
        this.role = role;
    }

    @Override
    public String toString() {
        return String.format(
                "Account[id=%s, accountFirstName='%s', AccountLastName='%s']",
                accountMailAdresse, accountFirstName, accountLastName);
    }

    public String getAccountMailAdresse() {
        return this.accountMailAdresse;
    }
    public String getAccountFirstName() {
        return this.accountFirstName;
    }
    public String getAccountLastName() {
        return this.accountLastName;
    }
    public Role getRole() {
        return role;
    }


    public static class Builder{

        private String accountMailAdresse;
        private String accountFirstName;
        private String accountLastName;
        private Role role;

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

        public Builder setRole(Role role) {
            this.role = role;
            return this;
        }

        public Account build(){
            return new Account(accountMailAdresse, accountFirstName,  accountLastName, role);
        }
    }

}
