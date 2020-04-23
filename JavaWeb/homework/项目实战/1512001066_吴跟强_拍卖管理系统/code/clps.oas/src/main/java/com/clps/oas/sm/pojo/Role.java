package com.clps.oas.sm.pojo;
/**  
* @Title: Role.java  
* @Package com.clps.oas.sm.pojo  
* @Description: TODO 
* @author leo.jiang  
* @date 2018年5月14日  
* @version V1.0  
*/
import java.util.Date;
/**
* @desc: clps.oas
* @author: leo.jiang
* @createTime: 2018年5月14日 下午1:57:16
* @history:
* @version: v1.0
*/
public class Role {
    private Integer roleId;

    private String roleName;

    private String roleComment;

    private String roleLevel;

    private Date roleCreatedDatetime;

    private String roleCreatedName;

    private Date roleUpdatedDatetime;

    private String roleUpdatedName;

    private String roleDefault1;

    private String roleDefault2;

    private Integer roleIsvaild;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleComment() {
        return roleComment;
    }

    public void setRoleComment(String roleComment) {
        this.roleComment = roleComment;
    }

    public String getRoleLevel() {
        return roleLevel;
    }

    public void setRoleLevel(String roleLevel) {
        this.roleLevel = roleLevel;
    }

    public Date getRoleCreatedDatetime() {
        return roleCreatedDatetime;
    }

    public void setRoleCreatedDatetime(Date roleCreatedDatetime) {
        this.roleCreatedDatetime = roleCreatedDatetime;
    }

    public String getRoleCreatedName() {
        return roleCreatedName;
    }

    public void setRoleCreatedName(String roleCreatedName) {
        this.roleCreatedName = roleCreatedName;
    }

    public Date getRoleUpdatedDatetime() {
        return roleUpdatedDatetime;
    }

    public void setRoleUpdatedDatetime(Date roleUpdatedDatetime) {
        this.roleUpdatedDatetime = roleUpdatedDatetime;
    }

    public String getRoleUpdatedName() {
        return roleUpdatedName;
    }

    public void setRoleUpdatedName(String roleUpdatedName) {
        this.roleUpdatedName = roleUpdatedName;
    }

    public String getRoleDefault1() {
        return roleDefault1;
    }

    public void setRoleDefault1(String roleDefault1) {
        this.roleDefault1 = roleDefault1;
    }

    public String getRoleDefault2() {
        return roleDefault2;
    }

    public void setRoleDefault2(String roleDefault2) {
        this.roleDefault2 = roleDefault2;
    }

    public Integer getRoleIsvaild() {
        return roleIsvaild;
    }

    public void setRoleIsvaild(Integer roleIsvaild) {
        this.roleIsvaild = roleIsvaild;
        
    }

	public Role() {
		super();

	}

	public Role(Integer roleId, String roleName, String roleComment, String roleLevel, Date roleCreatedDatetime,
			String roleCreatedName, Date roleUpdatedDatetime, String roleUpdatedName, String roleDefault1,
			String roleDefault2, Integer roleIsvaild) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.roleComment = roleComment;
		this.roleLevel = roleLevel;
		this.roleCreatedDatetime = roleCreatedDatetime;
		this.roleCreatedName = roleCreatedName;
		this.roleUpdatedDatetime = roleUpdatedDatetime;
		this.roleUpdatedName = roleUpdatedName;
		this.roleDefault1 = roleDefault1;
		this.roleDefault2 = roleDefault2;
		this.roleIsvaild = roleIsvaild;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + ", roleComment=" + roleComment + ", roleLevel="
				+ roleLevel + ", roleCreatedDatetime=" + roleCreatedDatetime + ", roleCreatedName=" + roleCreatedName
				+ ", roleUpdatedDatetime=" + roleUpdatedDatetime + ", roleUpdatedName=" + roleUpdatedName
				+ ", roleDefault1=" + roleDefault1 + ", roleDefault2=" + roleDefault2 + ", roleIsvaild=" + roleIsvaild
				+ "]";
	}
	
}