package com.humanup.adminmatrix.dao.entities;

import javax.persistence.*;


@Entity

public class Account {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long accountId;
    private String accountFirstName;
    private String accountLastName;

    @ManyToOne
    @JoinColumn(name = "roleId")
    private Role role;

    protected Account() {}

    public Account(String accountFirstName, String accountLastName, Role role) {
        this.accountFirstName = accountFirstName;
        this.accountLastName = accountLastName;
        this.role = role;
    }

    @Override
    public String toString() {
        return String.format(
                "Account[id=%d, accountFirstName='%s', AccountLastName='%s']",
                accountId, accountFirstName, accountLastName);
    }

    public Long getAccountId() {
        return this.accountId;
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

        private String accountFirstName;
        private String accountLastName;
        private Role role;

        public Builder() {
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
            return new Account( accountFirstName,  accountLastName, role);
        }
    }

}
