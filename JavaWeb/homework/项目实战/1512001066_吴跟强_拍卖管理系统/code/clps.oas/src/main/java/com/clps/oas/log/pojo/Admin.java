/**
 * 
 */
package com.clps.oas.log.pojo;

/**
 * @author LHBSY 
 *
 * 下午3:30:31
 */
public class Admin  {  
	  
    private Long adminId;//管理员帐号  
    private String passWd;//管理员密码  
    private String phoneNum;//电话号码  
	/**
	 * @return the adminId
	 */
	public Long getAdminId() {
		return adminId;
	}
	/**
	 * @param adminId the adminId to set
	 */
	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}
	/**
	 * @return the passWd
	 */
	public String getPassWd() {
		return passWd;
	}
	/**
	 * @param passWd the passWd to set
	 */
	public void setPassWd(String passWd) {
		this.passWd = passWd;
	}
	/**
	 * @return the phoneNum
	 */
	public String getPhoneNum() {
		return phoneNum;
	}
	/**
	 * @param phoneNum the phoneNum to set
	 */
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
  
   
} 
