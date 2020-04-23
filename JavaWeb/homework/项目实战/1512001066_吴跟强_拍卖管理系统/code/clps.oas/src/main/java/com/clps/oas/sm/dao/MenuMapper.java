package com.clps.oas.sm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.clps.oas.sm.pojo.Menu;

/**
* 
* @desc: clps.oas
* @author: lxj
* @createTime: 2018年5月21日 上午9:07:14
* @version: v1.0
*/
public interface MenuMapper {
	
	/**
	* save menu's info
	* @author: lxj
	* @createTime: 2018年5月6日 下午2:54:45
	* @param menu
	* @return int
	*/
	public int addMenu(Menu menu);
	
	/**
	* update menu's info by param menu
	* @author: lxj
	* @createTime: 2018年5月6日 下午2:55:22
	* @param menu
	* @return int
	*/
	public int updateMenu(Menu menu);
	
	/**
	* change the menu's state by menuIsvariable
	* @author: lxj
	* @createTime: 2018年5月6日 下午2:56:53
	* @return int
	*/
	public int updateMenuState(Menu menu);
	
	/**
	* query all menu's info
	* @author: lxj
	* @createTime: 2018年5月6日 下午2:58:16
	* @return List<Menu>
	*/
	public List<Menu> queryAllMenu();
	
	/**
	* select menu by id
	* @author: lxj
	* @createTime: 2018年5月8日 上午11:23:21
	* @return Menu
	*/
	public Menu queryMenuById (int menuId);
	
	/**
	* query the menu's sort id isRepeat
	* @author: lxj
	* @createTime: 2018年5月6日 下午3:00:20
	* @param menuSortId
	* @param menuUrl
	* @param menuName
	* @return int
	*/
	public int queryMenuSortIdIsRepeat(@Param("menuSortId")int menuSortId,
			@Param("menuLevel")int menuLevel,@Param("menuParentId")int menuParentId);
	
	/**
	* query the menu's url isRepeat
	* @author: lxj
	* @createTime: 2018年5月6日 下午4:32:32
	* @param menuUrl
	* @return int
	*/
	public int queryMenuUrlIsRepeat(String menuUrl);
	
	/**
	* query the menu's name isRepeat
	* @author: lxj
	* @createTime: 2018年5月6日 下午4:32:36
	* @param menuName
	* @return int
	*/
	public int queryMenuNameIsRepeat(@Param("menuName")String menuName,
			@Param("menuLevel")int menuLevel,@Param("menuParentId")int menuParentId);
	
	/**
	* query menu by condition
	* @author: lxj
	* @createTime: 2018年5月8日 下午8:31:31
	* @param key
	* @param date
	* @return List<Menu>
	*/
	public List<Menu> queryMenuByCondition(@Param("key")String key,@Param("date")int date);
	
	/**
	* query menu by parentid
	* @author: lxj
	* @createTime: 2018年5月10日 下午11:30:28
	* @param menuId
	* @return List<Menu>
	*/
	public List<Menu> queryMenuByParentId(int menuId);
	
	
}