package com.humanup.adminmatrix.bs.impl;

import com.humanup.adminmatrix.bs.AccountBS;
import com.humanup.adminmatrix.dao.AccountDAO;
import com.humanup.adminmatrix.dao.RoleDAO;
import com.humanup.adminmatrix.dao.entities.Account;
import com.humanup.adminmatrix.dao.entities.Role;
import com.humanup.adminmatrix.vo.AccountVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccountBSImpl implements AccountBS {

    @Autowired
    private AccountDAO accountDAO;

    @Autowired
    private RoleDAO roleDAO;

    @Override
    public boolean createAccount(AccountVO accountVO) {
        Role role = roleDAO.findByRoleTitle(accountVO.getAccountRole());
        Account accountToSave =new Account.Builder()
                .setAccountFirstName(accountVO.getAccountFirstName())
                .setAccountLastName(accountVO.getAccountLastName())
                .setRole(role)
                .build();
        return  accountDAO.save(accountToSave)!=null;
    }

    @Override
    public AccountVO findByAccountLastName(String accountLastName) {
        Optional<Account> accountFinded = Optional.ofNullable(accountDAO.findByAccountLastName(accountLastName));
        if(accountFinded.isPresent()) {
            return new AccountVO.Builder()
                    .setAccountFirstName(accountFinded.get().getAccountFirstName())
                    .setAccountLastName(accountFinded.get().getAccountLastName())
                    .setAccountRole(accountFinded.get().getRole().getRoleTitle())
                    .build();
        }
        return null;
    }

    @Override
    public List<AccountVO> findListAccount() {
        return accountDAO.findAll()
                .stream()
                .map(accountFinded -> new AccountVO.Builder()
                        .setAccountFirstName(accountFinded.getAccountFirstName())
                        .setAccountLastName(accountFinded.getAccountLastName())
                        .setAccountRole(accountFinded.getRole().getRoleTitle())
                        .build())
                .collect(Collectors.toList());

    }

    @Override
    public List<AccountVO> findListRolesByProfileTitle(String roleTitle) {
        return accountDAO.findListRolesByProfileTitle(roleTitle)
                .stream()
                .map(accountFinded -> new AccountVO.Builder()
                        .setAccountFirstName(accountFinded.getAccountFirstName())
                        .setAccountLastName(accountFinded.getAccountLastName())
                        .setAccountRole(accountFinded.getRole().getRoleTitle())
                        .build())
                .collect(Collectors.toList());
    }




}
