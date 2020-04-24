package com.wgq.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wgq.entity.User;
import com.wgq.service.UserDataBaseService;

@Controller
@Scope("prototype")
public class UserDataBaseController {
	
	@Resource
	private UserDataBaseService service;
	@RequestMapping(value = "/User_login.do",produces="text/html;charset=UTF-8")
	public String updateUserPassword(HttpSession session, User user, ModelMap map) {

		User u = service.queryUser(user);
		if (u == null) {
			map.put("name", user.getName());
			map.put("message", "�û��������������");
			JOptionPane.showMessageDialog(null,"�û��������������","������ʾ��",JOptionPane.ERROR_MESSAGE);
			return "redirect:User_login.jsp";			
		}
		else{
			map.put("userName",u.getName());
			map.put("message","��½�ɹ���");
		}
		session.setAttribute("loginUser", u);
		System.out.println("user:"+user.getName()+",password:"+user.getPassword());
		if(u.getUsertype()==1)
			   JOptionPane.showMessageDialog(null,"����Ա����,��ӭ��¼ͼ�����ϵͳ��","��ȷ��ʾ��",0);
		else
			   JOptionPane.showMessageDialog(null,"�û�����,��ӭ��¼ͼ�����ϵͳ��","��ȷ��ʾ��",0);
		return "redirect:index.jsp";
	}
	
	//ע���û�
	@RequestMapping(value = "/User_register.do",produces="text/html;charset=UTF-8")
	public String  registerUserPassword(HttpSession session, User user, ModelMap map) {
		
		if (service.registerUser(user) == 1) {
			map.put("message","ע��ɹ���");
		    JOptionPane.showMessageDialog(null,"��ӳɹ���","��ȷ��ʾ��",0);
		    System.out.println("�û���ӳɹ�:"+user.toString());
		}
		else{
			JOptionPane.showMessageDialog(null,"���ʧ�ܣ�","������ʾ��",0);
			return "redirect:html/User_register.html";
		}			
		return "redirect:User_login.jsp";	
	}
	
}