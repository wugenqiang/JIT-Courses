
		
/*
* clps.oas 下午11:49:45
*
*/
	
		package com.clps.oas.sm.service.impl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clps.oas.common.ParamCommon;
import com.clps.oas.sm.dao.MenuMapper;

import com.clps.oas.sm.pojo.Menu;
import com.clps.oas.sm.service.IMenuService;


/**
* @desc: clps.oas
* @author: lxj
* @createTime: 2018年5月5日 下午11:49:45
* @version: v1.0
*/
@Service("menuService")
public class MenuServiceImpl implements IMenuService{

	@Autowired
	private MenuMapper menuMapper;
	
	/*
	*(non-Javadoc)
	* @see com.clps.oas.menu.service.MenuService#saveMenu(com.clps.oas.menu.pojo.Menu)
	*/
		
	@Override
	public String addMenu(Menu menu) {
		
		if(menu!=null)
		{
			if((menuMapper.addMenu(menu))>0){
				return ParamCommon.ADD_SUCCESS;
			}
			else{
				return ParamCommon.ADD_FAILURE;
			}
		}
		return ParamCommon.ADD_EMPTY;
			
	}

	
	/*
	*(non-Javadoc)
	* @see com.clps.oas.menu.service.MenuService#updateMenu(com.clps.oas.menu.pojo.Menu)
	*/
		
	@Override
	public String updateMenu(Menu menu) {
		
			if(menuMapper.updateMenu(menu)>0)
			{
				return ParamCommon.UPDATE_SUCCESS;
			}
			
			return ParamCommon.UPDATE_FAILURE;
			
	}

	
	/*
	*(non-Javadoc)
	* @see com.clps.oas.menu.service.MenuService#changeMenuState(com.clps.oas.menu.pojo.Menu)
	*/
		
	@Override
	public String updateMenuState(Menu menu) {
		
			if(menuMapper.updateMenuState(menu)>0)
			{
				return ParamCommon.CHANGE_SUCCESS;
			}
		
			return ParamCommon.CHANGE_FAILURE;	
			
	}

	
	/*
	*(non-Javadoc)
	* @see com.clps.oas.menu.service.MenuService#queryAllMenu()
	*/
		
	@Override
	public List<Menu> queryAllMenu() {
		
			
				return menuMapper.queryAllMenu();
			
	}

	
	/*
	*(non-Javadoc)
	* @see com.clps.oas.menu.service.MenuService#queryMenuSortIdIsRepeat(int, int, int)
	*/
		
	@Override
	public String queryMenuSortIdIsRepeat(int menuSortId, int menuLevel, int menuParentId) {
		
				if(menuMapper.queryMenuSortIdIsRepeat(menuSortId, menuLevel, menuParentId)>0)
				return ParamCommon.QUERY_SUCCESS;
				
				return ParamCommon.QUERY_FAILURE;
			
	}

	
	/*
	*(non-Javadoc)
	* @see com.clps.oas.menu.service.MenuService#queryMenuUrlIsRepeat(java.lang.String)
	*/
		
	@Override
	public String queryMenuUrlIsRepeat(String menuUrl) {
		
		if(menuMapper.queryMenuUrlIsRepeat(menuUrl)>0)
			return ParamCommon.QUERY_SUCCESS;
			
			return ParamCommon.QUERY_FAILURE;	
			
	}

	
	/*
	*(non-Javadoc)
	* @see com.clps.oas.menu.service.MenuService#queryMenuNameIsRepeat(java.lang.String, int, int)
	*/
		
	@Override
	public String queryMenuNameIsRepeat(String menuName, int menuLevel, int menuParentId) {
		
		if(menuMapper.queryMenuNameIsRepeat(menuName, menuLevel, menuParentId)>0)
			return ParamCommon.QUERY_SUCCESS;
			
			return ParamCommon.QUERY_FAILURE;	
			
			
	}


	
	/*
	*(non-Javadoc)
	* @see com.clps.oas.menu.service.MenuService#selectMenuById(int)
	*/
		
	@Override
	public Menu queryMenuById(int menuId) {
		

				return menuMapper.queryMenuById(menuId);
			
	}


	
	/*
	*(non-Javadoc)
	* @see com.clps.oas.menu.service.MenuService#queryMenuByCondition(java.lang.String, int)
	*/
		
	@Override
	public List<Menu> queryMenuByCondition(String key, int date) {
		
			
				return menuMapper.queryMenuByCondition(key, date);
			
	}

}

	