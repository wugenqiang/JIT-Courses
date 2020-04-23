/**    
 * @Title: Account.java  
 * @Package com.clps.oas.util.excel.vo  
 * @Description:账户信息导入导出部分字段   
 * @author weigion.wu(吴跟强)    
 * @date  2018-05-21 22:02:09
 * @version V1.0    
 */
package com.clps.oas.util.excel.vo;

/**
 * @ClassName: Account
 * @Description:账户信息导入导出部分字段
 * @author weigion.wu
 * @date 2018-05-21 22:02:09
 */
public class Account {

	private String accountId;				//账户编号

	private String accountName;				//账户名称

	private String accountRealName;			//账户的真实姓名

	private String accountMail;				//账户邮箱编号

	private String accountProvince;		    //账户省份

	private String accountCity;				//账户城市

	private String accountDistrict;			//账户所在地区

	private String accountAddress;			//账户地址

	private String accountPhone;			//账户电话

	private String accountTelephone;		//座机

	private String accountRoleId;			//角色编号

	private String accountPositionId;		//职位编号

	private String accountDepartmentId;	//部门编号

	private String accountCompanyId;		//公司编号

	/**
	 * @return the accountId
	 */
	public String getAccountId() {
		return accountId;
	}

	/**
	 * @param accountId
	 *            the accountId to set
	 */
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	/**
	 * @return the accountName
	 */
	public String getAccountName() {
		return accountName;
	}

	/**
	 * @param accountName
	 *            the accountName to set
	 */
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	/**
	 * @return the accountRealName
	 */
	public String getAccountRealName() {
		return accountRealName;
	}

	/**
	 * @param accountRealName
	 *            the accountRealName to set
	 */
	public void setAccountRealName(String accountRealName) {
		this.accountRealName = accountRealName;
	}

	/**
	 * @return the accountMail
	 */
	public String getAccountMail() {
		return accountMail;
	}

	/**
	 * @param accountMail
	 *            the accountMail to set
	 */
	public void setAccountMail(String accountMail) {
		this.accountMail = accountMail;
	}

	/**
	 * @return the accountProvince
	 */
	public String getAccountProvince() {
		return accountProvince;
	}

	/**
	 * @param accountProvince
	 *            the accountProvince to set
	 */
	public void setAccountProvince(String accountProvince) {
		this.accountProvince = accountProvince;
	}

	/**
	 * @return the accountCity
	 */
	public String getAccountCity() {
		return accountCity;
	}

	/**
	 * @param accountCity
	 *            the accountCity to set
	 */
	public void setAccountCity(String accountCity) {
		this.accountCity = accountCity;
	}

	/**
	 * @return the accountDistrict
	 */
	public String getAccountDistrict() {
		return accountDistrict;
	}

	/**
	 * @param accountDistrict
	 *            the accountDistrict to set
	 */
	public void setAccountDistrict(String accountDistrict) {
		this.accountDistrict = accountDistrict;
	}

	/**
	 * @return the accountAddress
	 */
	public String getAccountAddress() {
		return accountAddress;
	}

	/**
	 * @param accountAddress
	 *            the accountAddress to set
	 */
	public void setAccountAddress(String accountAddress) {
		this.accountAddress = accountAddress;
	}

	/**
	 * @return the accountPhone
	 */
	public String getAccountPhone() {
		return accountPhone;
	}

	/**
	 * @param accountPhone
	 *            the accountPhone to set
	 */
	public void setAccountPhone(String accountPhone) {
		this.accountPhone = accountPhone;
	}

	/**
	 * @return the accountTelephone
	 */
	public String getAccountTelephone() {
		return accountTelephone;
	}

	/**
	 * @param accountTelephone
	 *            the accountTelephone to set
	 */
	public void setAccountTelephone(String accountTelephone) {
		this.accountTelephone = accountTelephone;
	}

	/**
	 * @return the accountRoleId
	 */
	public String getAccountRoleId() {
		return accountRoleId;
	}

	/**
	 * @param accountRoleId
	 *            the accountRoleId to set
	 */
	public void setAccountRoleId(String accountRoleId) {
		this.accountRoleId = accountRoleId;
	}

	/**
	 * @return the accountPositionId
	 */
	public String getAccountPositionId() {
		return accountPositionId;
	}

	/**
	 * @param accountPositionId
	 *            the accountPositionId to set
	 */
	public void setAccountPositionId(String accountPositionId) {
		this.accountPositionId = accountPositionId;
	}

	/**
	 * @return the accountDepartmentId
	 */
	public String getAccountDepartmentId() {
		return accountDepartmentId;
	}

	/**
	 * @param accountDepartmentId
	 *            the accountDepartmentId to set
	 */
	public void setAccountDepartmentId(String accountDepartmentId) {
		this.accountDepartmentId = accountDepartmentId;
	}

	/**
	 * @return the accountCompanyId
	 */
	public String getAccountCompanyId() {
		return accountCompanyId;
	}

	/**
	 * @param accountCompanyId
	 *            the accountCompanyId to set
	 */
	public void setAccountCompanyId(String accountCompanyId) {
		this.accountCompanyId = accountCompanyId;
	}

	/*
	 * (non-Javadoc) <p>Title: toString</p> <p>Description: </p>
	 * 
	 * @return
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountName=" + accountName + ", accountRealName="
				+ accountRealName + ", accountMail=" + accountMail + ", accountProvince=" + accountProvince
				+ ", accountCity=" + accountCity + ", accountDistrict=" + accountDistrict + ", accountAddress="
				+ accountAddress + ", accountPhone=" + accountPhone + ", accountTelephone=" + accountTelephone
				+ ", accountRoleId=" + accountRoleId + ", accountPositionId=" + accountPositionId
				+ ", accountDepartmentId=" + accountDepartmentId + ", accountCompanyId=" + accountCompanyId + "]";
	}

}
