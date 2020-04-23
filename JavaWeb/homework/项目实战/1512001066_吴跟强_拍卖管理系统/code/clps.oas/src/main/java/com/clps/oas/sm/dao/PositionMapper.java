package com.clps.oas.sm.dao;


import java.util.List;

import com.clps.oas.sm.pojo.Position;


public interface PositionMapper {
	/**
	 * 
	 * 通过id逻辑删除Position 
	 * date: 2018年5月17日 上午11:13:39.
	 * @author WangZJ   
	 * @param positionId
	 * @return   
	 * @since JDK 1.8
	 */
    int deletePositionById(Integer positionId);
   /**
    * 添加position
    * date: 2018年5月17日 上午11:14:20. 
    * @author WangZJ   
    * @param position
    * @return   
    * @since JDK 1.8
    */
    int insertPosition(Position position);
    /**
     * 
     * 通过id查找Position
     * date: 2018年5月17日 上午11:14:42. 
     * @author WangZJ   
     * @param positionId
     * @return   
     * @since JDK 1.8
     */
    Position queryPositionById(Integer positionId);
    /**
     * 通过position对象更新position
     * date: 2018年5月17日 上午11:18:22.
     * @author WangZJ 
     * @param position
     * @return   
     * @since JDK 1.8
     */
    int updatePosition(Position position);
    /**
     * 
     * 查找所有Position对象
     * date: 2018年5月17日 上午11:19:40.
     * @author WangZJ 
     * @return   
     * @since JDK 1.8
     */
    List<Position> queryAllPositions();
    /**
     * 
     * 通过昵称查找position对象
     * date: 2018年5月17日 上午11:22:06.
     * @author WangZJ 
     * @return List<Position>  
     * @since JDK 1.8
     */
    List<Position> queryPositionByName(String positionname);
    
}