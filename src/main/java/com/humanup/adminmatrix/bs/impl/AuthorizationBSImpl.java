package com.humanup.adminmatrix.bs.impl;

import com.humanup.adminmatrix.bs.AuthorizationBS;
import com.humanup.adminmatrix.dao.AccountDAO;
import com.humanup.adminmatrix.dao.AuthorizationDAO;
import com.humanup.adminmatrix.dao.RoleDAO;
import com.humanup.adminmatrix.dao.entities.Account;
import com.humanup.adminmatrix.dao.entities.Authorization;
import com.humanup.adminmatrix.dao.entities.Role;
import com.humanup.adminmatrix.vo.AccountVO;
import com.humanup.adminmatrix.vo.AuthorizationVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Transactional(readOnly = true)
public class AuthorizationBSImpl implements AuthorizationBS {


    @Autowired
    private AuthorizationDAO authorizationDAO;

    @Autowired
    private RoleDAO roleDAO;

    @Autowired
    private AccountDAO accountDAO;

    @Transactional
    @Override
    public boolean createAuthorization(AuthorizationVO authorization) {
        Role role = roleDAO.findByRoleTitle(authorization.getAuthorizationRole());
        if (null==role) return false;
        Authorization authorizationToSave = Authorization.builder()
                .authorizationTitle(authorization.getAuthorizationTitle())
                .authorizationDescription(authorization.getAuthorizationDescription())
                .authorizationUrl(authorization.getAuthorizationUrl())
                .role(role)
                .build();
        return  authorizationDAO.save(authorizationToSave)!=null;
    }

    @Override
    public AuthorizationVO findAuthorizationByTitle(String authorizationTitle) {
        Optional<Authorization> authorizationFinded = Optional.ofNullable(authorizationDAO.findByAuthorizationTitle(authorizationTitle));
        if(authorizationFinded.isPresent()) {
            return  AuthorizationVO.builder()
                    .authorizationTitle(authorizationFinded.get().getAuthorizationTitle())
                    .authorizationDescription(authorizationFinded.get().getAuthorizationDescription())
                    .authorizationUrl(authorizationFinded.get().getAuthorizationUrl())
                    .authorizationRole(authorizationFinded.get().getRole().getRoleTitle())
                    .build();
        }
        return null;
    }

    @Override
    public List<AuthorizationVO> findListAuthorization() {
        return authorizationDAO.findAll()
                .stream()
                .map(authorizationFinded ->  AuthorizationVO.builder()
                        .authorizationTitle(authorizationFinded.getAuthorizationTitle())
                        .authorizationDescription(authorizationFinded.getAuthorizationDescription())
                        .authorizationUrl(authorizationFinded.getAuthorizationUrl())
                        .authorizationRole(authorizationFinded.getRole().getRoleTitle())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public List<AuthorizationVO> findListAuthorizationsByTitle(String authorizationTitle) {
        return authorizationDAO.findListAuthorizationsByTitle(authorizationTitle)
                .stream()
                .map(authorizationFinded ->  AuthorizationVO.builder()
                        .authorizationTitle(authorizationFinded.getAuthorizationTitle())
                        .authorizationDescription(authorizationFinded.getAuthorizationDescription())
                        .authorizationUrl(authorizationFinded.getAuthorizationUrl())
                        .authorizationRole(authorizationFinded.getRole().getRoleTitle())
                        .build())
                .collect(Collectors.toList());
    }


    @Override
    public List<AuthorizationVO> findAutorisationsByAccountEmail(String accountMailAdresse) {

        Account account = accountDAO.findByAccountMailAdresse(accountMailAdresse);
        if(null==account) return null;
        return authorizationDAO.findAuthorizationsByRoleId(account.getRole().getRoleId())
                .stream()
                .map(authorizationFinded ->  AuthorizationVO.builder()
                        .authorizationTitle(authorizationFinded.getAuthorizationTitle())
                        .authorizationDescription(authorizationFinded.getAuthorizationDescription())
                        .authorizationUrl(authorizationFinded.getAuthorizationUrl())
                        .authorizationRole(authorizationFinded.getRole().getRoleTitle())
                        .build())
                .collect(Collectors.toList());
    }
}
