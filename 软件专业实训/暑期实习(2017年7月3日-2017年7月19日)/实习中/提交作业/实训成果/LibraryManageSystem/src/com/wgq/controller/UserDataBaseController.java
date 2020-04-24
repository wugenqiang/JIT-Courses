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
			map.put("message", "用户名或者密码错误！");
			JOptionPane.showMessageDialog(null,"用户名或者密码错误！","错误提示！",JOptionPane.ERROR_MESSAGE);
			return "redirect:User_login.jsp";			
		}
		else{
			map.put("userName",u.getName());
			map.put("message","登陆成功！");
		}
		session.setAttribute("loginUser", u);
		System.out.println("user:"+user.getName()+",password:"+user.getPassword());
		if(u.getUsertype()==1)
			   JOptionPane.showMessageDialog(null,"管理员您好,欢迎登录图书管理系统！","正确提示！",0);
		else
			   JOptionPane.showMessageDialog(null,"用户您好,欢迎登录图书管理系统！","正确提示！",0);
		return "redirect:index.jsp";
	}
	
	//注册用户
	@RequestMapping(value = "/User_register.do",produces="text/html;charset=UTF-8")
	public String  registerUserPassword(HttpSession session, User user, ModelMap map) {
		
		if (service.registerUser(user) == 1) {
			map.put("message","注册成功！");
		    JOptionPane.showMessageDialog(null,"添加成功！","正确提示！",0);
		    System.out.println("用户添加成功:"+user.toString());
		}
		else{
			JOptionPane.showMessageDialog(null,"添加失败！","错误提示！",0);
			return "redirect:html/User_register.html";
		}			
		return "redirect:User_login.jsp";	
	}
	
}