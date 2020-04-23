
package com.clps.oas.util.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.clps.oas.util.pojo.SendEmail;
import com.clps.oas.util.service.ISendEmailService;


/** 
* @ClassName: SendEmailController 
* @Description: 建立控制器
* @author love.chen
* @date 
*  
*/
@Controller
@RequestMapping(value="/sm")
public class SendEmailController {
	
	@Resource
	@Qualifier("sendEmailService")
	private ISendEmailService iss;
	
	
	@RequestMapping(value="/sendemailList")
	public String showSendEmail(Model model){
		List<SendEmail> sendemails=iss.queryAllSendEmail();
		model.addAttribute("sendemails", sendemails);
		
		return "sm/sendemail_list";
	}
	
	@RequestMapping(value="/toAddEmail")
	public String toAddEmail(){
		return "sm/sendemail_add";
	}
	
	@RequestMapping(value="/addEmail")
	public String addSendEmail(SendEmail record,Model model){
		iss.insertSendEmail(record);
		return "sm/sendemail_addResult";
		
	}
	
	@RequestMapping(value="/delEmail")
	public String delSendEmail(int emailId){
		
		iss.deleteByEmailId(emailId);
		
		return "sm/sendemail_delResult";
	}
	
	@RequestMapping(value="/getEmail")
	public String getEmail(int emailId,Model model){
		SendEmail sendemail = iss.querySendEmailByEmailId(emailId);
		model.addAttribute("sendemail",sendemail);
		return "sm/sendemail_update";
	}
	
	@RequestMapping(value="/updateEmail",method=RequestMethod.POST)
	public String updateEmail(SendEmail record,Model model){
		iss.updateSendEmail(record);	
		record = iss.querySendEmailByEmailId(record.getEmailId());
		return "sm/sendemail_updateResult";
	}
	
	
	
	

}
