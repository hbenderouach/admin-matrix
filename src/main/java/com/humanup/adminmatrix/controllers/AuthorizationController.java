package com.humanup.adminmatrix.controllers;
import com.humanup.adminmatrix.bs.AuthorizationBS;
import com.humanup.adminmatrix.vo.AuthorizationVO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AuthorizationController {

    @Autowired
    private AuthorizationBS authorizationBS;

    @Operation(summary = "Create authorization", description = " Create new authorization by title, decsription ...", tags = { "authorization" })
    @RequestMapping(value="/authorization", method= RequestMethod.POST,consumes={ "application/json"})
    @ResponseBody
    public ResponseEntity createAuthorization(@RequestBody AuthorizationVO authorization){
        Optional<Object> findAuthorization = Optional.ofNullable(authorizationBS.findAuthorizationByTitle(authorization.getAuthorizationTitle()));

        if(findAuthorization.isPresent()){
            return ResponseEntity.status(HttpStatus.FOUND).body("This Authorization is Founded");
        }
        boolean isCreated = authorizationBS.createAuthorization(authorization);
        if (!isCreated) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("This Authorization can not be created, can you check the role!");
        return ResponseEntity.status(HttpStatus.CREATED).body(authorization);
    }

    @Operation(summary = "Find authorization by title", description = "authorization search by %authorizationTitle% format", tags = { "authorization" })
    @RequestMapping(value="/authorization/title", method=RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getAuthorizationInfo(@RequestParam(value="title", defaultValue="Create person") String authorizationTitle){
        Optional<AuthorizationVO> findAuthorization = Optional.ofNullable(authorizationBS.findAuthorizationByTitle(authorizationTitle));
        if(findAuthorization.isEmpty()){
            Optional<List<AuthorizationVO>> findListAuthorizationsByTitle = Optional.ofNullable(authorizationBS.findListAuthorizationsByTitle(authorizationTitle));
            if(findListAuthorizationsByTitle.get().isEmpty())
            {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("This Authorization not Found");
            }
            return ResponseEntity.status(HttpStatus.OK).body(findListAuthorizationsByTitle.get());
        }
        return ResponseEntity.status(HttpStatus.OK).body(findAuthorization.get());
    }

    @Operation(summary = "Find all authorizations", description = "Find all authorizations", tags = { "authorization" })
    @RequestMapping(value="/authorization/all", method=RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getAllAuthorizationInfo(){
        List<AuthorizationVO> findAuthorizations = authorizationBS.findListAuthorization();

        if(findAuthorizations.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(findAuthorizations);
    }

    @Operation(summary = "Find authorization by account email", description = "authorization search by %accountMailAdresse% format", tags = { "authorization" })
    @RequestMapping(value="/authorization/email", method=RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getAutorisationsByAccountEmail(@RequestParam(value="email", defaultValue="yelouardi@sqli.com") String accountMailAdresse){
        Optional<List<AuthorizationVO>> findAuthorization = Optional.ofNullable(authorizationBS.findAutorisationsByAccountEmail(accountMailAdresse));
        if(findAuthorization.isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("This Authorization not Found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(findAuthorization.get());
    }

}
