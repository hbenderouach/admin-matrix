package com.humanup.adminmatrix.dao;
import com.humanup.adminmatrix.dao.entities.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoleDAO extends CrudRepository<Role, Long> {

    Role findByRoleTitle(String roleTitle);
    List<Role> findAll();
    Role findByRoleId(long roleId);

}