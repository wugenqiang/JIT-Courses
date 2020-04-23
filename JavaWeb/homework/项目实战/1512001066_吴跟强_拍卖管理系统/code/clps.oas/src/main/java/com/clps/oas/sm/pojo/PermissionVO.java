package com.clps.oas.sm.pojo;

import java.io.Serializable;

/** 
* @description  this is PermissionVO
* @author  noah.zhou 
* @date 创建时间：2018年5月21日 下午2:24:23 
* @version 1.0 
*/
public class PermissionVO implements Serializable{

	private static final long serialVersionUID = 2187923381095225365L;

    private String permissionName;//权限名字

    private Integer permissionContent;//权限内容

    private String permissionComment;//权限描述

    private Integer permissionLevel;//权限等级

	public PermissionVO() {
		super();
	}

	public PermissionVO(String permissionName, Integer permissionContent, String permissionComment,
			Integer permissionLevel) {
		super();
		this.permissionName = permissionName;
		this.permissionContent = permissionContent;
		this.permissionComment = permissionComment;
		this.permissionLevel = permissionLevel;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "PermissionVO [permissionName=" + permissionName + ", permissionContent=" + permissionContent
				+ ", permissionComment=" + permissionComment + ", permissionLevel=" + permissionLevel + "]";
	}


}
