
		
/*
* clps.oas 下午11:55:30
*
*/
	
		package com.clps.oas.sm.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


import com.clps.oas.sm.pojo.Menu;
import com.clps.oas.sm.service.IMenuService;

/**
* @desc: clps.oas
* @author: lxj
* @createTime: 2018年5月5日 下午11:55:30
* @version: v1.0
*/
@Controller
@RequestMapping(value="/sm")
public class MenuController {

	@Autowired
	@Qualifier("menuService")
	private IMenuService menuService;
	public static Log log = LogFactory.getLog(MenuController.class);

	/**
	* insert menu
	* @author: lxj
	* @createTime: 2018年5月8日 下午10:55:50
	* @param mv
	* @param request
	* @return ModelAndView
	*/
	@RequestMapping(value="/menuAdd",method=RequestMethod.POST)
	public ModelAndView insertMenu(ModelAndView mv,HttpServletRequest request,Menu menu){
	
		String parent=request.getParameter("menuId");
		if(parent==null)
		{
			mv.addObject("message","the input is null");
		}
		else{
			int menuParentid=Integer.parseInt(parent); 
		    String result1=menuService.queryMenuNameIsRepeat(menu.getMenuName(), menu.getMenuLevel(), menuParentid);
		    String result2=menuService.queryMenuSortIdIsRepeat(menu.getMenuSortId(), menu.getMenuLevel(), menuParentid);
		    String result3=menuService.queryMenuUrlIsRepeat(menu.getMenuUrl());
		    int r1=Integer.parseInt(result1);
		    int r2=Integer.parseInt(result2);
		    int r3=Integer.parseInt(result3);
		    if(r1>0||r2>0||r3>0){
		    	mv.addObject("message","the input is repeat");
		    	mv.setViewName("sm/menu_add");
		    }else{
		    	 	menu.setMenuId(null);
				    menu.setMenuParentid(menuParentid);
				    menu.setMenuCreatedDatetime(new Timestamp(new Date().getTime()));
				    menu.setMenuCreatedName(1);
				    menu.setMenuUpdatedDatetime(new Timestamp(new Date().getTime()));
				    menu.setMenuUpdatedName(1);
		    	String result=menuService.addMenu(menu);
		   	    int r=Integer.parseInt(result);
		   	    if(r>0)
		   	    {
		   	    	mv.setView(new RedirectView("/clps.oas/sm/menu_list"));
		   	    }else{
		   	    	mv.addObject("message","insert failure");
		   	    	mv.setViewName("sm/menu_add");
		   	    }
		    }
	}
		
		return mv;
	}

	/**
	* find menu by id to update
	* @author: lxj
	* @createTime: 2018年5月8日 下午11:02:37
	* @param model
	* @param request
	* @param session
	* @return String
	*/
	@RequestMapping(value="/findMenuById")
	public String findMenu(Model model,HttpServletRequest request,HttpSession session){
		
		 String menuId = request.getParameter("menuId");
		 if(menuId==null||menuId.equals("")){
			// mv.setView(new RedirectView("/clps.oas/querymenu"));
			 return "sm/menu_list";
		 }else{
			 int id=Integer.parseInt(menuId);
			  Menu menu=menuService.queryMenuById(id);
				if(menu!=null){
					model.addAttribute("menuInfo", menu);
					session.setAttribute("menuInfo", menu);
					return "sm/menu_edit";
				
				}else{
					return "sm/menu_list";
				}
		 }
		
	}
	
	/**
	* update menu
	* @author: lxj
	* @createTime: 2018年5月8日 下午11:02:58
	* @param mv
	* @param request
	* @param session
	* @return ModelAndView
	*/
	@RequestMapping(value="/menuUpdate",method=RequestMethod.POST)
	public ModelAndView updateMenu(ModelAndView mv,HttpSession session,Menu menu){
		
		String result1=menuService.queryMenuNameIsRepeat(menu.getMenuName(), menu.getMenuLevel(), menu.getMenuParentid());
		String result2=menuService.queryMenuSortIdIsRepeat(menu.getMenuSortId(), menu.getMenuLevel(), menu.getMenuParentid());
		String result3=menuService.queryMenuUrlIsRepeat(menu.getMenuUrl());
		int r1=Integer.parseInt(result1);
		int r2=Integer.parseInt(result2);
		int r3=Integer.parseInt(result3);
		if(r1>0||r2>0||r3>0){
			mv.addObject("message","the update is repeat");
			 Menu m=menuService.queryMenuById(menu.getMenuId());
				if(m!=null){
					mv.addObject("menuInfo", m);
					session.setAttribute("menuInfo", m);
					mv.setViewName("sm/menu_edit");
				}else{
					mv.addObject("message","the update is repeat");
				}
		
		}else{

		    menu.setMenuUpdatedDatetime(new Timestamp(new Date().getTime()));
		    menu.setMenuUpdatedName(1);
		
		String result=menuService.updateMenu(menu);
		int r=Integer.parseInt(result);
	
		if(r>0)
		{
			mv.setView(new RedirectView("/clps.oas/sm/menu_list"));
		}else{
			mv.addObject("message","the input is null");
			mv.setViewName("sm/menu_edit");
		}
		}
	
		return mv;	
	}
	
	/**
	* change menu's isvariable
	* @author: lxj
	* @createTime: 2018年5月8日 下午11:03:51
	* @param mv
	* @param request
	* @param session
	* @return ModelAndView
	*/
	@RequestMapping(value="/changeMenuState")
	public ModelAndView changeMenuState(ModelAndView mv,HttpServletRequest request,HttpSession session){
		
		
		String id=request.getParameter("menuId");
		
		if(id==null)
		{
			mv.addObject("message","change the menu state fail");
		}else{
			@SuppressWarnings("unchecked")
			List<Menu> list=(List<Menu>)session.getAttribute("listMenu");
			int menuId=Integer.parseInt(id);
			menuId--;
			Menu menu =list.get(menuId);
			
			String result=menuService.updateMenuState(menu);
			int r=Integer.parseInt(result);
			if(r>0)
			{
				mv.setView(new RedirectView("/clps.oas/sm/menu_list"));
			}else{
				mv.addObject("message","the input is null");
				
			}
		}
		
		return mv;
		
	}

	/**
	* query all menu or query menu by condition
	* @author: lxj
	* @createTime: 2018年5月8日 下午11:04:21
	* @param model
	* @param request
	* @param session
	* @return String
	*/
	@RequestMapping(value="/menu_list")
	public String queryMenuByCondition(Model model,HttpServletRequest request,HttpSession session){
		
		String key = request.getParameter("keyWord");
		String date = request.getParameter("date");
		
		List<Menu> list=new ArrayList<>();
		if(key==null){
			if(date==null)
			{
				list = menuService.queryMenuByCondition(null, 0);
			}else{
				int d=Integer.parseInt(date);
				 list = menuService.queryMenuByCondition(null, d);
			}
			
		}else{
			if(date==null){
				 list = menuService.queryMenuByCondition(key, 0);
			}else{
				int d=Integer.parseInt(date);
				 list = menuService.queryMenuByCondition(key, d);
			}
			
		}

		
		model.addAttribute("listMenu", list);
		session.setAttribute("listMenu", list);
		return "sm/menu_list";
	}

	/**
	* go to menu_add
	* @author: lxj
	* @createTime: 2018年5月14日 上午11:28:10
	* @return String
	*/
	@RequestMapping(value="/menu_add")
	public String menuAdd(){
		
		return "sm/menu_add";
	}
}

	