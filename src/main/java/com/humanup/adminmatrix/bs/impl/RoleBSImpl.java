package com.humanup.adminmatrix.bs.impl;
import com.humanup.adminmatrix.bs.RoleBS;
import com.humanup.adminmatrix.dao.RoleDAO;
import com.humanup.adminmatrix.dao.entities.Role;
import com.humanup.adminmatrix.vo.RoleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class RoleBSImpl implements RoleBS {

    @Autowired
    private RoleDAO roleDAO;

    @Override
    public boolean createRole(RoleVO roleVO) {
        Role roleToSave =new Role.Builder()
                .setRoleTitle(roleVO.getRoleTitle())
                .setRoleDescription(roleVO.getRoleDescription())
                .build();
        return  roleDAO.save(roleToSave)!=null;
    }

    @Override
    public RoleVO findByRoleTitle(String roleTitle) {
        Optional<Role> roleFinded = Optional.ofNullable(roleDAO.findByRoleTitle(roleTitle));
        if(roleFinded.isPresent()) {
            return new RoleVO.Builder()
                    .setRoleTitle(roleFinded.get().getRoleTitle())
                    .setRoleDescription(roleFinded.get().getRoleDescription())
                    .build();
        }
        return null;
    }

    @Override
    public List<RoleVO> findListRole() {
        return roleDAO.findAll()
                .stream()
                .map(roleFinded -> new RoleVO.Builder()
                        .setRoleTitle(roleFinded.getRoleTitle())
                        .setRoleDescription(roleFinded.getRoleDescription())
                        .build())
                .collect(Collectors.toList());

    }

}
