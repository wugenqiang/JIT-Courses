package com.clps.oas.sm.pojo;
import java.io.Serializable;
/** 
* @author  noah.zhou 
* @date 创建时间：2018年5月11日 上午10:40:00
* @des  Permission Entity
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
import java.util.Date;

public class Permission implements Serializable{
    
	private static final long serialVersionUID = -8102237062820932041L;

	private Integer permissionId;//权限编号

    private String permissionName;//权限名字

    private Integer permissionContent;//权限内容

    private String permissionComment;//权限描述

    private Integer permissionLevel;//权限等级

    private Date permissionCreatedDatetime;//权限创建时间

    private Integer permissionCreatedName;//权限创建人编号

    private Date permissionUpdatedDatetime;//权限更新时间

    private Integer permissionUpdatedName;//权限更新人编号

    private Date maintenanceTime;//上次维护时间

    private Date checkTime;//上次审核时间

    private Integer isVisible;//是否有效（是否审核通过）

    //无参构造方法
    public Permission() {
		super();
		// TODO Auto-generated constructor stub
	}

    
	public Permission(Integer permissionId, String permissionName, Integer permissionContent, String permissionComment,
			Integer permissionLevel, Date permissionCreatedDatetime, Integer permissionCreatedName,
			Date permissionUpdatedDatetime, Integer permissionUpdatedName, Date maintenanceTime, Date checkTime,
			Integer isVisible) {
		super();
		this.permissionId = permissionId;
		this.permissionName = permissionName;
		this.permissionContent = permissionContent;
		this.permissionComment = permissionComment;
		this.permissionLevel = permissionLevel;
		this.permissionCreatedDatetime = permissionCreatedDatetime;
		this.permissionCreatedName = permissionCreatedName;
		this.permissionUpdatedDatetime = permissionUpdatedDatetime;
		this.permissionUpdatedName = permissionUpdatedName;
		this.maintenanceTime = maintenanceTime;
		this.checkTime = checkTime;
		this.isVisible = isVisible;
	}


	

	public Integer getPermissionId() {
		return permissionId;
	}


	public void setPermissionId(Integer permissionId) {
		this.permissionId = permissionId;
	}


	public String getPermissionName() {
		return permissionName;
	}


	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}


	public Integer getPermissionContent() {
		return permissionContent;
	}


	public void setPermissionContent(Integer permissionContent) {
		this.permissionContent = permissionContent;
	}


	public String getPermissionComment() {
		return permissionComment;
	}


	public void setPermissionComment(String permissionComment) {
		this.permissionComment = permissionComment;
	}


	public Integer getPermissionLevel() {
		return permissionLevel;
	}


	public void setPermissionLevel(Integer permissionLevel) {
		this.permissionLevel = permissionLevel;
	}


	public Date getPermissionCreatedDatetime() {
		return permissionCreatedDatetime;
	}


	public void setPermissionCreatedDatetime(Date permissionCreatedDatetime) {
		this.permissionCreatedDatetime = permissionCreatedDatetime;
	}


	public Integer getPermissionCreatedName() {
		return permissionCreatedName;
	}


	public void setPermissionCreatedName(Integer permissionCreatedName) {
		this.permissionCreatedName = permissionCreatedName;
	}


	public Date getPermissionUpdatedDatetime() {
		return permissionUpdatedDatetime;
	}


	public void setPermissionUpdatedDatetime(Date permissionUpdatedDatetime) {
		this.permissionUpdatedDatetime = permissionUpdatedDatetime;
	}


	public Integer getPermissionUpdatedName() {
		return permissionUpdatedName;
	}


	public void setPermissionUpdatedName(Integer permissionUpdatedName) {
		this.permissionUpdatedName = permissionUpdatedName;
	}


	public Date getMaintenanceTime() {
		return maintenanceTime;
	}


	public void setMaintenanceTime(Date maintenanceTime) {
		this.maintenanceTime = maintenanceTime;
	}


	public Date getCheckTime() {
		return checkTime;
	}


	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}


	public Integer getIsVisible() {
		return isVisible;
	}


	public void setIsVisible(Integer isVisible) {
		this.isVisible = isVisible;
	}


	@Override
	public String toString() {
		return "Permission [permissionId=" + permissionId + ", permissionName=" + permissionName
				+ ", permissionContent=" + permissionContent + ", permissionComment=" + permissionComment
				+ ", permissionLevel=" + permissionLevel + ", permissionCreatedDatetime=" + permissionCreatedDatetime
				+ ", permissionCreatedName=" + permissionCreatedName + ", permissionUpdatedDatetime="
				+ permissionUpdatedDatetime + ", permissionUpdatedName=" + permissionUpdatedName + ", maintenanceTime="
				+ maintenanceTime + ", checkTime=" + checkTime + ", isVisible=" + isVisible + "]";
	}
    
    
}