package com.humanup.adminmatrix.bs;

import com.humanup.adminmatrix.dao.entities.Account;
import com.humanup.adminmatrix.vo.AccountVO;

import java.util.List;

public interface AccountBS {

    boolean createAccount(AccountVO Account);
    AccountVO findByAccountLastName(String accountLastName);
    List<AccountVO> findListAccount();
    List<AccountVO> findListRolesByProfileTitle(String roleTitle);


}
