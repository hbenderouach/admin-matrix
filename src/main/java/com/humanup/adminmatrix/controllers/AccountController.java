package com.humanup.adminmatrix.controllers;


import com.humanup.adminmatrix.bs.AccountBS;
import com.humanup.adminmatrix.vo.AccountVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AccountController {

    @Autowired
    private AccountBS accountBS;

    @RequestMapping(value="/account", method= RequestMethod.POST)
    @ResponseBody

    public ResponseEntity createAccount(@RequestBody AccountVO account){
        Optional<Object> findAccount = Optional.ofNullable(accountBS.findByAccountLastName(account.getAccountLastName()));

        if(findAccount.isPresent()){
            return ResponseEntity.status(HttpStatus.FOUND).body("This Account is Founded");
        }
        accountBS.createAccount(account);
        return ResponseEntity.status(HttpStatus.OK).body(account);
    }

    @RequestMapping(value="/account", method=RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getAccountInfo(@RequestParam(value="Last_Name", defaultValue="Last Name") String accountLastName){
        Optional<AccountVO> findAccount = Optional.ofNullable(accountBS.findByAccountLastName(accountLastName));
        if(findAccount.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(findAccount.get());
    }

    @RequestMapping(value="/account/all", method=RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getAllAccountInfo(){
        List<AccountVO> findAccount = accountBS.findListAccount();

        if(findAccount.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(findAccount);
    }

    @RequestMapping(value="/account/all/role", method=RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getRoleAccounts(@RequestParam(value="Role_Name", defaultValue="HR Manager") String roleTitle){
        Optional<List<AccountVO>> findRole = Optional.ofNullable(accountBS.findListRolesByProfileTitle(roleTitle));
        if(findRole.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("This Role not Found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(findRole.get());
    }

}
