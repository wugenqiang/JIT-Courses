package com.clps.oas.sm.service;

import java.util.List;

import com.clps.oas.sm.pojo.Position;

public interface IPositionService {

	/**
	 * 
	 * 添加position对象
	 * date: 2018年5月17日 上午11:28:04.
	 * @author WangZJ 
	 * @return String  
	 * @since JDK 1.8
	 */
	public String savePosition(Position position);
	
	/**
	 * 
	 * 更新
	 * date: 2018年5月17日 上午11:28:20.
	 * @author WangZJ 
	 * @return String  
	 * @since JDK 1.8
	 */
	public String updatePosition(Position position);
	
	
	
	/**
	 * 
	 * 通过id号查询position
	 * date: 2018年5月17日 上午11:28:30.
	 * @author WangZJ 
	 * @return Position  
	 * @since JDK 1.8
	 */
	public Position queryPositionById (int positionId);
	
	/**
	 * 
	 * 查询所有position对象
	 * date: 2018年5月17日 上午11:30:37.
	 * @author WangZJ 
	 * @return List<Position>  
	 * @since JDK 1.8
	 */
	public List<Position> queryAllPosition();
	
	/**
	 * 
	 * 通过昵称查询position
	 * date: 2018年5月17日 上午11:31:02.
	 * @author WangZJ 
	 * @return List<Position>  
	 * @since JDK 1.8
	 */
	public List<Position> queryPositionByName (String positionName);
	
	/**
	 * 逻辑删除position
	 * 
	 * date: 2018年5月17日 上午11:31:26.
	 * @author WangZJ 
	 * @return int  
	 * @since JDK 1.8
	 */
	public int deletePositionbyId(int positionId);
}
