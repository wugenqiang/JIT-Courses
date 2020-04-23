
package com.clps.oas.util.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clps.oas.common.ParamCommon;
import com.clps.oas.util.dao.SendEmailMapper;
import com.clps.oas.util.pojo.SendEmail;
import com.clps.oas.util.service.ISendEmailService;



@Service("sendEmailService")
public class SendEmailServiceImpl implements ISendEmailService{
	
	@Autowired
    private SendEmailMapper sendemailMapper;
	
	public List<SendEmail> queryAllSendEmail() {
		
		return sendemailMapper.queryAllSendEmail();
	
	}
	/**
	 * 
	 * 
	 * @see com.clps.oas.util.service.ISendEmailService#insertSendEmail(com.clps.oas.util.pojo.SendEmail)
	 */
	
	public String insertSendEmail(SendEmail record) {
		
		if(sendemailMapper.insertSendEmail(record)>0){
			return ParamCommon.ADD_SUCCESS;
		}
		return ParamCommon.ADD_FAILURE;
	}
	/**
	 * 
	 *  
	 * @see com.clps.oas.util.service.ISendEmailService#deleteByEmailId(java.lang.Integer)
	 */
	
	public String deleteByEmailId(Integer emailId) {
		if(sendemailMapper.deleteByEmailId(emailId)>0){
			return ParamCommon.DELETE_SUCCESS;
		}
		return ParamCommon.DELETE_FAILURE;
	}
	/**
	 * 
	 * 
	 * @see com.clps.oas.util.service.ISendEmailService#updateSendEmail(com.clps.oas.util.pojo.SendEmail)
	 */

	public String updateSendEmail(SendEmail record) {
		if(sendemailMapper.updateSendEmail(record)>0){
			return ParamCommon.UPDATE_SUCCESS;
		}
		return ParamCommon.UPDATE_FAILURE;
	}
	/**
	 * 
	 * 
	 * @see com.clps.oas.util.service.ISendEmailService#querySendEmailByEmailId(java.lang.Integer)
	 */

	public SendEmail querySendEmailByEmailId(Integer emailId) {
		return sendemailMapper.querySendEmailByEmailId(emailId);
	
	}

}
