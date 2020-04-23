package com.clps.oas.sm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.clps.oas.sm.pojo.Parameter;

@Service
public interface IParameterService {
	
	/**
	 * 
	 * @param parameter
	 * @return String
	 * 添加参数
	 */
	public String addParameter(Parameter parameter);
	
	/**
	 * 
	 * @return List<Parameter>
	 * 查询所有参数
	 */
	public List<Parameter> showParameters();
	
	/**
	 * 
	 * @param parameterId
	 * @return String
	 * 通过参数Id删除参数
	 */
	public String delectParameter(Integer parameterId);
	
	/**
	 * 
	 * @param parameter
	 * @return String
	 * 更新参数
	 */
	public String updateParameter(Parameter parameter);
	
	
/**
 * 	
 * queryParameterById:(通过Id查询参数). 
 * (要单独查询某参数时使用).
 *
 * @author hjq
 *
 * @since JDK 1.8
 */
	public Parameter queryParameterById(Integer parameterId);

}
