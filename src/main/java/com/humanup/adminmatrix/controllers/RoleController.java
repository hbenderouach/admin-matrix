package com.humanup.adminmatrix.controllers;

import com.humanup.adminmatrix.bs.RoleBS;
import com.humanup.adminmatrix.vo.RoleVO;
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

    @RequestMapping(value="/role", method= RequestMethod.POST)
    @ResponseBody

    public ResponseEntity createRole(@RequestBody RoleVO role){
        Optional<Object> findRole = Optional.ofNullable(roleBS.findByRoleTitle(role.getRoleTitle()));

        if(findRole.isPresent()){
            return ResponseEntity.status(HttpStatus.FOUND).body("This Role is Founded");
        }
        roleBS.createRole(role);
        return ResponseEntity.status(HttpStatus.OK).body(role);
    }

    @RequestMapping(value="/role", method=RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getRoleInfo(@RequestParam(value="title", defaultValue="Manager RH") String roleTitle){
        Optional<RoleVO> findRole = Optional.ofNullable(roleBS.findByRoleTitle(roleTitle));
        if(findRole.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(findRole.get());
    }

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
