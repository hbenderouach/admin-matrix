package com.humanup.adminmatrix.bs;

import com.humanup.adminmatrix.dao.entities.Account;
import com.humanup.adminmatrix.vo.AccountVO;

import java.util.List;

public interface AccountBS {

    boolean createAccount(AccountVO Account);
    AccountVO findAccountByLastName(String accountLastName);
    AccountVO findAccountByMailAdresse(String accountMailAdresse);
    List<AccountVO> findListAccount();
    List<AccountVO> findListRolesByRoleTitle(String roleTitle);

}
