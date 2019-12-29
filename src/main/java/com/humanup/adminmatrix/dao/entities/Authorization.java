package com.humanup.adminmatrix.dao.entities;


import javax.persistence.*;
import java.util.List;

@Entity
public class Authorization {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long authorizationId;
    private String authorizationTitle;
    private String authorizationDescription;
    private String authorizationUrl;


    @ManyToOne
    @JoinColumn(name = "roleId")
    private Role role;

    protected Authorization() {}

    public Authorization(String authorizationTitle, String authorizationDescription, String authorizationUrl, Role role) {
        this.authorizationTitle = authorizationTitle;
        this.authorizationDescription = authorizationDescription;
        this.authorizationUrl = authorizationUrl;
        this.role = role;
    }

    @Override
    public String toString() {
        return String.format(
                "Authorization[authorizationId=%d, authorizationTitle='%s', authorizationUrl='%s']",
                authorizationTitle, authorizationUrl);
    }

    public Long getAuthorizationId() {
        return this.authorizationId;
    }
    public String getAuthorizationTitle() {
        return this.authorizationTitle;
    }
    public String getAuthorizationDescription() {
        return this.authorizationDescription;
    }
    public String getAuthorizationUrl() {
        return this.authorizationUrl;
    }
    public Role getRole() {
        return role;
    }

    public static class Builder{

        private String authorizationTitle;
        private String authorizationDescription;
        private String authorizationUrl;
        private Role role;

        public Builder() {
        }

        public Builder setAuthorizationTitle(String authorizationTitle) {
            this.authorizationTitle = authorizationTitle;
            return this;
        }

        public Builder setAuthorizationDescription(String authorizationDescription) {
            this.authorizationDescription = authorizationDescription;
            return this;
        }

        public Builder setAuthorizationUrl(String authorizationUrl) {
            this.authorizationUrl = authorizationUrl;
            return this;
        }

        public Builder setRole(Role role) {
            this.role = role;
            return this;
        }

        public Authorization build(){
            return new Authorization(authorizationTitle,authorizationDescription,authorizationUrl,role);
        }
    }

}
