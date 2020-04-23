
package com.clps.oas.sm.service;

import java.util.List;

import com.clps.oas.sm.pojo.Account;
import com.clps.oas.sm.vo.AccountVo;

/**
 * 
 * @desc: clps.oas
 * @author: Jin_hx
 * @createTime: 2018年5月17日 上午10:36:53
 * @version: v1.0
 */
public interface IAccountService {

	/**
	 * 物理删除账户信息
	 * 
	 * @author: Jin_hx
	 * @createTime: 2018年5月8日 上午9:10:00
	 * @param accountId
	 * @return int
	 */
	int deleteAccountById(Integer accountId);

	/**
	 * 逻辑删除账户信息
	 * 
	 * @author: Jin_hx
	 * @createTime: 2018年5月8日 上午9:10:17
	 * @param accountId
	 * @return int
	 */
	int logicDeleteAccountById(Integer accountId);

	/**
	 * 新增账户信息
	 * 
	 * @author: Jin_hx
	 * @createTime: 2018年5月8日 上午9:10:48
	 * @param record
	 * @return int
	 */
	int insertAccountInfo(Account record);

	/**
	 * 条件查询
	 * 
	 * @author: Jin_hx
	 * @createTime: 2018年5月8日 上午9:12:15
	 * @param record
	 * @return List<StudentInfo>
	 */
	List<AccountVo> queryAccountsByReq(Account record);

	/**
	 * 查询所有账户信息
	 * 
	 * @author: Jin_hx
	 * @createTime: 2018年5月8日 上午9:12:42
	 * @history:
	 * @return List<StudentInfo>
	 */
	List<AccountVo> queryAllAccounts();

	/**
	 * 根据账户id查询账户信息
	 * 
	 * @author: Jin_hx
	 * @createTime: 2018年5月8日 上午9:13:12
	 * @return List<Account>
	 */
	Account queryAccountById(Integer accountId);

	/**
	 * 更新账户信息
	 * 
	 * @author: Jin_hx
	 * @createTime: 2018年5月8日 上午9:13:26
	 * @param record
	 * @return int
	 */
	int updateAccountInfo(Account record);
}
