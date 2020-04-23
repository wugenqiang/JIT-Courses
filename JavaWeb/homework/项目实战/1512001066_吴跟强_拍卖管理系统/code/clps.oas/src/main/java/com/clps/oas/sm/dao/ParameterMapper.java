package com.clps.oas.sm.dao;

import java.util.List;

import com.clps.oas.sm.pojo.Parameter;

public interface ParameterMapper {
	
	/**
	 * 
	 * @param parameterId
	 * @return int
	 * 通过ID删除参数
	 */
    int deleteParameterById(Integer parameterId);

    /**
     * 
     * @param record
     * @return int
     * 添加参数
     */
    int insertParameter(Parameter record);

    /**
     * 
     * @param parameterId
     * @return Parameter
     * 通过Id查询参数
     * 
     */
    Parameter queryParameterById(Integer parameterId);

    /**
     * 
     * @param parameterId
     * @return int
     * 更新参数
     */
    int updateParameter(Parameter record);

    /**
     * @param parameterId
     * @return List<Parameter>
     * 查询全部参数
     */
    List<Parameter> queryAllParameters();
}