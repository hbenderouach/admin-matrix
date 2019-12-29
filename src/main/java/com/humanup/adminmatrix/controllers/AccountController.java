package com.humanup.adminmatrix.controllers;


import com.humanup.adminmatrix.bs.AccountBS;
import com.humanup.adminmatrix.vo.AccountVO;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(summary = "Create account", description = " Create new account by mail adresse (id), first name, last name ...", tags = { "account" })
    @RequestMapping(value="/account", method= RequestMethod.POST,consumes={ "application/json"})
    @ResponseBody
    public ResponseEntity createAccount(@RequestBody AccountVO account){
        Optional<Object> findAccount = Optional.ofNullable(accountBS.findAccountByMailAdresse(account.getAccountMailAdresse()));

        if(findAccount.isPresent()){
            return ResponseEntity.status(HttpStatus.FOUND).body("This Account is Founded");
        }
        accountBS.createAccount(account);
        return ResponseEntity.status(HttpStatus.CREATED).body(account);
    }

    @Operation(summary = "Find account by mail adresse", description = "account search by %accountMailAdresse% format", tags = { "account" })
    @RequestMapping(value="/account", method=RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getAccountInfo(@RequestParam(value="email", defaultValue="yelouardi@sqli.com") String accountMailAdresse){
        Optional<AccountVO> findAccount = Optional.ofNullable(accountBS.findAccountByMailAdresse(accountMailAdresse));
        if(findAccount.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(findAccount.get());
    }

    @Operation(summary = "Find all accounts", description = "Find all accounts", tags = { "account" })
    @RequestMapping(value="/account/all", method=RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getAllAccountInfo(){
        List<AccountVO> findAccount = accountBS.findListAccount();

        if(findAccount.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(findAccount);
    }

    @Operation(summary = "Find all accounts by role", description = "Find all accounts by role title", tags = { "account" })
    @RequestMapping(value="/account/all/role", method=RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getRoleAccounts(@RequestParam(value="Role_Name", defaultValue="HR Manager") String roleTitle){
        Optional<List<AccountVO>> findRole = Optional.ofNullable(accountBS.findListRolesByRoleTitle(roleTitle));
        if(findRole.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("This Role not Found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(findRole.get());
    }




}
