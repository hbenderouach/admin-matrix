package com.humanup.adminmatrix.controllers;

import com.humanup.adminmatrix.bs.RoleBS;
import com.humanup.adminmatrix.vo.RoleVO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class RoleController {
    @Autowired
    private RoleBS roleBS;

    @Operation(summary = "Create role", description = " Create new role by title, decsription ...", tags = { "role" })
    @RequestMapping(value="/role", method= RequestMethod.POST,consumes={ "application/json"})
    @ResponseBody
    public ResponseEntity createRole(@RequestBody RoleVO role){
        Optional<Object> findRole = Optional.ofNullable(roleBS.findByRoleTitle(role.getRoleTitle()));
        if(findRole.isPresent()){
            return ResponseEntity.status(HttpStatus.FOUND).body("This Role is Founded");
        }
        roleBS.createRole(role);
        return ResponseEntity.status(HttpStatus.CREATED).body(role);
    }

    @Operation(summary = "Find role by title", description = "role search by %roleTitle% format", tags = { "role" })
    @RequestMapping(value="/role", method=RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getRoleInfo(@RequestParam(value="title", defaultValue="hr") String roleTitle){
        Optional<RoleVO> findRole = Optional.ofNullable(roleBS.findByRoleTitle(roleTitle));
        if(findRole.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(findRole.get());
    }

    @Operation(summary = "Find all roles", description = "Find all roles", tags = { "role" })
    @RequestMapping(value="/role/all", method=RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getAllRoleInfo(){
        List<RoleVO> findRoles = roleBS.findListRole();

        if(findRoles.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(findRoles);
    }
}
