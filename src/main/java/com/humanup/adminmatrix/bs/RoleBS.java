package com.humanup.adminmatrix.bs;
import com.humanup.adminmatrix.vo.RoleVO;

import java.util.List;
public interface RoleBS {
    boolean createRole(RoleVO role);
    RoleVO findByRoleTitle(String roleTitle);
    List<RoleVO> findListRole();
    List<RoleVO> findListAuthorizationsByAuthorizationsTitle(String authorizationsTitle);
}