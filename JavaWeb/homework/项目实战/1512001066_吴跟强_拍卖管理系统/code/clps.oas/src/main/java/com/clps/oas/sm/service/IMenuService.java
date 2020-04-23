
		
/*
* clps.oas 下午11:47:26
*
*/
	
		package com.clps.oas.sm.service;

import java.util.List;



import com.clps.oas.sm.pojo.Menu;

/**
* @desc: clps.oas
* @author: lxj
* @createTime: 2018年5月5日 下午11:47:26
* @version: v1.0
*/

public interface IMenuService {

	/**
	* save menu's info
	* @author: lxj
	* @createTime: 2018年5月6日 下午2:54:45
	* @param menu
	* @return int
	*/
	public String addMenu(Menu menu);
	
	/**
	* update menu's info by param menu
	* @author: lxj
	* @createTime: 2018年5月6日 下午2:55:22
	* @param menu
	* @return int
	*/
	public String updateMenu(Menu menu);
	
	/**
	* change the menu's state by menuIsvariable
	* @author: lxj
	* @createTime: 2018年5月6日 下午2:56:53
	* @return int
	*/
	public String updateMenuState(Menu menu);
	
	
	/**
	* select menu by id
	* @author: lxj
	* @createTime: 2018年5月8日 上午11:23:21
	* @return Menu
	*/
	public Menu queryMenuById (int menuId);
	
	/**
	* query all menu's info
	* @author: lxj
	* @createTime: 2018年5月6日 下午2:58:16
	* @return List<Menu>
	*/
	public List<Menu> queryAllMenu();
	
	/**
	* query the menu's sort id isRepeat
	* @author: lxj
	* @createTime: 2018年5月6日 下午3:00:20
	* @param menuSortId
	* @param menuUrl
	* @param menuName
	* @return int
	*/
	public String queryMenuSortIdIsRepeat(int menuSortId,
			int menuLevel,int menuParentId);
	
	/**
	* query the menu's url isRepeat
	* @author: lxj
	* @createTime: 2018年5月6日 下午4:32:32
	* @param menuUrl
	* @return int
	*/
	public String queryMenuUrlIsRepeat(String menuUrl);
	
	/**
	* query the menu's name isRepeat
	* @author: lxj
	* @createTime: 2018年5月6日 下午4:32:36
	* @param menuName
	* @return int
	*/
	public String queryMenuNameIsRepeat(String menuName,
			int menuLevel,int menuParentId);
	

	/**
	* query menu by condition
	* @author: lxj
	* @createTime: 2018年5月8日 下午8:31:31
	* @param key
	* @param date
	* @return List<Menu>
	*/
	public List<Menu> queryMenuByCondition(String key,int date);
}

	