package com.clps.oas.sm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.clps.oas.sm.pojo.Account;
import com.clps.oas.sm.service.IAccountService;
import com.clps.oas.sm.vo.AccountVo;

@Controller
@RequestMapping(value = "/sm")
public class AccountController {

	@Autowired
	@Qualifier("accountService")
	private IAccountService ias;

	@RequestMapping(value = "/accountList")
	public String showAccountList(Model model) {
		List<AccountVo> accounts = ias.queryAllAccounts();
		model.addAttribute("accounts", accounts);
		return "sm/account_list";
	}

	@RequestMapping("/account_updateView")
	public String updateView(HttpServletRequest request, Model model) {

		Integer accountId = Integer.parseInt(request.getParameter("accountId"));
		Account account = new Account();
		account = ias.queryAccountById(accountId);
		model.addAttribute("account", account);
		return "sm/account_update";
	}

	@RequestMapping(value = "/updateAccount")
	public String updateAccount(HttpServletRequest request, @ModelAttribute Account account) {
		if (ias.updateAccountInfo(account) == 1) {
			return "sm/account_succeed";
		} else {
			return "sm/account_fail";
		}

	}

	@RequestMapping("/account_addView")
	public String addView() {
		return "sm/account_add";
	}

	@RequestMapping(value = "/addAccount")
	public String addAccount(HttpServletRequest request,@ModelAttribute Account account) {

		if (ias.insertAccountInfo(account) == 1) {
			return "sm/account_succeed";
		} else {
			return "sm/account_fail";
		}

	}

	@RequestMapping(value = "/logicDelAccount")
	public String logicDelAccount(int accountId) {

		if (ias.logicDeleteAccountById(accountId) == 1) {
			return "sm/account_succeed";
		} else {
			return "sm/account_fail";
		}

	}

}
