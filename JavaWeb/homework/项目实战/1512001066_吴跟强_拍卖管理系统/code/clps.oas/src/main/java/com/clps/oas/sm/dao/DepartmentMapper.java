package com.clps.oas.sm.dao;

import java.util.List;

import com.clps.oas.sm.pojo.Department;

public interface DepartmentMapper {
	/**
	
    * @Title: deleteByPrimaryKey  
	
	* @param @param depaNumber
	* @param @return    
	* @return int    
	* @throws
	 */
    int deleteByPrimaryKey(Integer depaNumber);

    int insert(Department record);
    /**
     * 
    * @Title: insertSelective  
   
    * @param @param record
    * @param @return    
    * @return int    
    * @throws
     */
    int insertSelective(Department record);
    
    /**
     * 
    * @Title: selectByPrimaryKey  
    
    * @param @param depaNumber
    * @param @return    
    * @return Department    
    * @throws
     */
    Department selectByPrimaryKey(Integer depaNumber);
    
    /**
     * 
    * @Title: updateByPrimaryKeySelective  
    
    * @param @param record
    * @param @return    
    * @return int    
    * @throws
     */
    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);
    /**
     * 
    * @Title: queryAllDepartments  
     
    * @param @return    
    * @return List<Department>    
    * @throws
     */
    List<Department> queryAllDepartments();
    /**
     * 
    * @Title: queryDepartmentsById  
  
    * @param @param depaNumber
    * @param @return    
    * @return Department    
    * @throws
     */
    
    Department queryDepartmentsById(Integer depaNumber);
    
    /**
     * 
    * @Title: queryDepartmentsByName  
    
    * @param @param depaName
    * @param @return    
    * @return List<Department>    
    * @throws
     */
    List<Department> queryDepartmentsByName(String depaName);
}