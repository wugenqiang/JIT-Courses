/**    
* @Title: DeaprtmentController.java  
* @Package com.clps.oas.sm.controller  
* @author ft   
* @date 2018年5月8日 上午9:40:21  
* @version V1.0    
*/
package com.clps.oas.sm.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



import com.clps.oas.common.ParamCommon;
import com.clps.oas.sm.pojo.Department;
import com.clps.oas.sm.service.IDepartmentService;

/**  
* @ClassName: DeaprtmentController  
* @author Aiden
* @date 2018年5月8日 上午9:40:21  
*    
*/
@Controller
@RequestMapping(value="/sm")
public class DeaprtmentController {
	@Autowired
	@Qualifier("departmentService")
	private IDepartmentService departmentService;
	@RequestMapping(value="/departmentList")
	public String showDepartment(Model model){
		List<Department>  departments= departmentService.showDepartment();
		model.addAttribute("departments", departments);
		return "sm/department_list";
	}
	@RequestMapping(value="/toAddDepartment")
	public String toAddDepartment(){
		return "sm/department_add";
	}
	@RequestMapping(value="/addDeaprtment",method=RequestMethod.POST)
	public String addDepartment(Model model,HttpServletRequest request){
		
		String depaName=request.getParameter("depaName");
	    String depaFatherNumber=request.getParameter("depaFatherNumber");
	    String depaChildNumber=request.getParameter("depaChildNumber");
	    String depaLevel=request.getParameter("depaLevel");
	    String depaEmail=request.getParameter("depaEmail");
	    String depaComment=request.getParameter("depaComment");
	    String depaCreateName=request.getParameter("depaCreateName");
	    String depaUpdatedName=request.getParameter("depaUpdatedName");
	    
	    Department department=new Department();
	    
	    department.setDepaName(depaName);
	    department.setDepaFatherNumber(depaFatherNumber);
	    department.setDepaChildNumber(depaChildNumber);
	    department.setDepaLevel(depaLevel);
	    department.setDepaEmail(depaEmail);
	    department.setDepaComment(depaComment);
	    department.setDepaCreateName(depaCreateName);
	    department.setDepaCreateDatetime(new Timestamp(new Date().getTime()));
	    department.setDepaUpdatedName(depaUpdatedName);
	    department.setDepaUpdatedDatetime(new Timestamp(new Date().getTime()));
	    String result= departmentService.insertSelective(department);
	    if(result.equals(ParamCommon.ADD_SUCCESS)==true)
	    {
	    	List<Department>  departments= departmentService.showDepartment();
			model.addAttribute("departments", departments);
			return "sm/department_list";
	    }
	    else{
	    	
	    return "sm/department_add";
	    }
	    
	}
	    
		
		
	
	@RequestMapping(value="/delDepartment")
	public String delDepartment(int depaNumber,Model model){
		
		 String result=departmentService.deleteByPrimaryKey(depaNumber);
		 if(result.equals(ParamCommon.DELETE_SUCCESS)==true)
		 {
			 List<Department>  departments= departmentService.showDepartment();
			 model.addAttribute("departments", departments);
		     return "sm/department_list";
		 }
		 else
			 return ParamCommon.DELETE_FAILURE;
			 
	}
	
	@RequestMapping(value="/updateView")
	public String updateView(HttpServletRequest request, Model model) {
		Integer id = Integer.parseInt(request.getParameter("depaNumber"));
		Department department=new Department();
		department=departmentService.queryDepartmentsById(id);
		model.addAttribute("department",department);
		return "sm/department_update";
	}
	

	@RequestMapping(value="/updateDepartment")
	public String updateDepartment( Model model,HttpServletRequest request){
		Integer id = Integer.parseInt(request.getParameter("depaNumber"));
		String depaName=request.getParameter("depaName");
	    String depaFatherNumber=request.getParameter("depaFatherNumber");
	    String depaChildNumber=request.getParameter("depaChildNumber");
	    String depaLevel=request.getParameter("depaLevel");
	    String depaEmail=request.getParameter("depaEmail");
	    String depaComment=request.getParameter("depaComment");
	    String depaCreateName=request.getParameter("depaCreateName");
	    String depaUpdatedName=request.getParameter("depaUpdatedName");
	    
	    Department department=new Department();
	    department.setDepaNumber(id);
	    department.setDepaName(depaName);
	    department.setDepaFatherNumber(depaFatherNumber);
	    department.setDepaChildNumber(depaChildNumber);
	    department.setDepaLevel(depaLevel);
	    department.setDepaEmail(depaEmail);
	    department.setDepaComment(depaComment);
	    department.setDepaCreateName(depaCreateName);
	    department.setDepaCreateDatetime(new Timestamp(new Date().getTime()));
	    department.setDepaUpdatedName(depaUpdatedName);
	    department.setDepaUpdatedDatetime(new Timestamp(new Date().getTime()));
	    String result= departmentService.updateByPrimaryKeySelective(department);
	    if(result.equals(ParamCommon.UPDATE_SUCCESS)==true)
	    {
	    	List<Department>  departments= departmentService.showDepartment();
			model.addAttribute("departments", departments);
			return "sm/department_list";
	    }
	    else
	    	return ParamCommon.UPDATE_FAILURE;
	    
	    
	}

}
