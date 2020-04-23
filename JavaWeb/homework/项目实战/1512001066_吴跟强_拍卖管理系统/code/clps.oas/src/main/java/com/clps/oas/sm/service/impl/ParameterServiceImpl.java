package com.clps.oas.sm.service.impl;

import java.util.ArrayList;
import java.util.List;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clps.oas.common.ParamCommon;
import com.clps.oas.sm.dao.ParameterMapper;
import com.clps.oas.sm.pojo.Parameter;
import com.clps.oas.sm.service.IParameterService;

/**
 * 
 * ClassName: ParameterServiceImpl
 * Function: ADD FUNCTION.
 * Reason: 
 * date: 2018年5月11日 上午11:28:08
 *
 * @author hjq
 * @version v1.0
 * @since JDK 1.8
 */
//告诉spring创建一个实现类的实例
@Service("patService")
public class ParameterServiceImpl implements IParameterService{
	
	@Autowired
	private ParameterMapper patDao;
	private Logger logger=Logger.getLogger(ParameterServiceImpl.class);
	
	public void init(){
		System.out.println("ParameterService init() invoke...");
		
	}

	/**
	 * 
	 * 新增参数.
	 * @see com.clps.oas.sm.service.IParameterService#addParameter(com.clps.oas.sm.pojo.Parameter)
	 */
	@Override
	public String addParameter(Parameter parameter) {

		if(parameter!=null){
			if(this.patDao.insertParameter(parameter)>0){
				return ParamCommon.ADD_SUCCESS;
			}
		}else{
			return ParamCommon.ADD_EMPTY;
		}
		return ParamCommon.ADD_FAILURE;
	}

	/**
	 * 
	 * 查询所有参数
	 * @see com.clps.oas.sm.service.IParameterService#showParameters()
	 */
	@Override
	public List<Parameter> showParameters() {
		logger.info("...");
		List<Parameter> pat=new ArrayList<Parameter>();
		pat=this.patDao.queryAllParameters();
		return pat;
	}

	/**
	 * 
	 *  删除参数通过Id
	 * @see com.clps.oas.sm.service.IParameterService#delectParameter(java.lang.Integer)
	 */
	@Override
	public String delectParameter(Integer parameterId) {
		if(parameterId!=null){
			if(this.patDao.deleteParameterById(parameterId)>0){
				return ParamCommon.DELETE_SUCCESS;
			}
		}else{
			return ParamCommon.ADD_EMPTY;
		}
		return ParamCommon.DELETE_FAILURE;
	}

	/**
	 * 
	 *  更新参数.
	 * @see com.clps.oas.sm.service.IParameterService#updateParameter(com.clps.oas.sm.pojo.Parameter)
	 */
	@Override
	public String updateParameter(Parameter parameter) {
		
		if(parameter!=null){
			if(patDao.updateParameter(parameter)>0){
				return ParamCommon.UPDATE_SUCCESS;
			}
		}else{
			return ParamCommon.ADD_EMPTY;
		}
		return ParamCommon.UPDATE_FAILURE;
	}
	
	/**
	 * 
	 * 通过Id查询参数.
	 * @see com.clps.oas.sm.service.IParameterService#queryParameterById(java.lang.Integer)
	 */
	@Override
	public Parameter queryParameterById(Integer parameterId) {
		
		
		return patDao.queryParameterById(parameterId);
		
	}

}
