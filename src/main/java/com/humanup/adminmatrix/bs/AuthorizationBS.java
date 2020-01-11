package com.humanup.adminmatrix.bs;

import com.humanup.adminmatrix.vo.AuthorizationVO;

import java.util.List;

public interface AuthorizationBS {

    boolean createAuthorization(AuthorizationVO authorization);
    AuthorizationVO findAuthorizationByTitle(String authorizationTitle);
    List<AuthorizationVO> findListAuthorization();
    List<AuthorizationVO> findListAuthorizationsByTitle(String authorizationTitle);
    List<AuthorizationVO> findAutorisationsByAccountEmail(String accountMailAdresse);


}
