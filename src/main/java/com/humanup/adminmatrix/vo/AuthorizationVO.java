package com.humanup.adminmatrix.vo;

public class AuthorizationVO {

    private String authorizationTitle;
    private String authorizationDescription;
    private String authorizationUrl;
    private String authorizationRole;


    public AuthorizationVO() {
    }

    public AuthorizationVO(String authorizationTitle, String authorizationDescription,String authorizationUrl,String authorizationRole) {
        this.authorizationTitle = authorizationTitle;
        this.authorizationDescription = authorizationDescription;
        this.authorizationUrl = authorizationUrl;
        this.authorizationRole = authorizationRole;
    }

    public String getAuthorizationTitle() {
        return authorizationTitle;
    }
    public String getAuthorizationDescription() {
        return authorizationDescription;
    }
    public String getAuthorizationUrl() {
        return authorizationUrl;
    }
    public String getAuthorizationRole() {
        return authorizationRole;
    }

    public static class Builder{

        private String authorizationTitle;
        private String authorizationDescription;
        private String authorizationUrl;
        private String authorizationRole;

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
        public Builder setAuthorizationRole(String authorizationRole) {
            this.authorizationRole = authorizationRole;
            return this;
        }


        public AuthorizationVO build() {
            return new AuthorizationVO(authorizationTitle, authorizationDescription,authorizationUrl,authorizationRole);
        }

    }

}
