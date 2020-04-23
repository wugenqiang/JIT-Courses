
package com.clps.oas.sm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clps.oas.sm.dao.AccountMapper;
import com.clps.oas.sm.pojo.Account;
import com.clps.oas.sm.service.IAccountService;
import com.clps.oas.sm.vo.AccountVo;

@Service("accountService")
public class AccountServiceImpl implements IAccountService {

	@Autowired
	private AccountMapper accountdao;

	@Override
	public int deleteAccountById(Integer accountId) {

		return this.accountdao.deleteAccountById(accountId);

	}

	@Override
	public int logicDeleteAccountById(Integer accountId) {

		return this.accountdao.logicDeleteAccountById(accountId);

	}

	@Override
	public int insertAccountInfo(Account record) {

		return this.accountdao.insertAccountInfo(record);

	}

	@Override
	public List<AccountVo> queryAccountsByReq(Account record) {

		return null;

	}

	@Override
	public List<AccountVo> queryAllAccounts() {

		return this.accountdao.queryAllAccounts();

	}

	@Override
	public Account queryAccountById(Integer accountId) {

		return this.accountdao.queryAccountById(accountId);

	}

	@Override
	public int updateAccountInfo(Account record) {

		return this.accountdao.updateAccountInfo(record);
	}

}
