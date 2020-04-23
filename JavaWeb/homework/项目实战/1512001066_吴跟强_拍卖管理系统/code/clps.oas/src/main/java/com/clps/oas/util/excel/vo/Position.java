/**    
 * @Title: Position.java  
 * @Package com.clps.oas.util.excel.vo  
 * @Description: 职位信息导入导出部分字段  
 * @author weigion.wu(吴跟强)    
 * @date  2018-05-21 22:00:48
 * @version V1.0    
 */
package com.clps.oas.util.excel.vo;


/**
 * @ClassName: Position
 * @Description: 职位信息导入导出部分字段
 * @author weigion.wu
 * @date 2018-05-21 22:00:48
 */
public class Position {

	private String positionId;					//职位编号

	private String positionName;				//职位名称

	private String positionDescription;			//职位描述

	private String positionLevel;				//职位等级

	private String positionDepartmentId;		//部门编号

	/**
	 * @return the positionId
	 */
	public String getPositionId() {
		return positionId;
	}

	/**
	 * @param positionId
	 *            the positionId to set
	 */
	public void setPositionId(String positionId) {
		this.positionId = positionId;
	}

	/**
	 * @return the positionName
	 */
	public String getPositionName() {
		return positionName;
	}

	/**
	 * @param positionName
	 *            the positionName to set
	 */
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	/**
	 * @return the positionDescription
	 */
	public String getPositionDescription() {
		return positionDescription;
	}

	/**
	 * @param positionDescription
	 *            the positionDescription to set
	 */
	public void setPositionDescription(String positionDescription) {
		this.positionDescription = positionDescription;
	}

	/**
	 * @return the positionLevel
	 */
	public String getPositionLevel() {
		return positionLevel;
	}

	/**
	 * @param positionLevel
	 *            the positionLevel to set
	 */
	public void setPositionLevel(String positionLevel) {
		this.positionLevel = positionLevel;
	}

	/**
	 * @return the positionDepartmentId
	 */
	public String getPositionDepartmentId() {
		return positionDepartmentId;
	}

	/**
	 * @param positionDepartmentId
	 *            the positionDepartmentId to set
	 */
	public void setPositionDepartmentId(String positionDepartmentId) {
		this.positionDepartmentId = positionDepartmentId;
	}

	/*
	 * (non-Javadoc) <p>Title: toString</p> <p>Description: </p>
	 * 
	 * @return
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Position [positionId=" + positionId + ", positionName=" + positionName + ", positionDescription="
				+ positionDescription + ", positionLevel=" + positionLevel + ", positionDepartmentId="
				+ positionDepartmentId + "]";
	}

}
