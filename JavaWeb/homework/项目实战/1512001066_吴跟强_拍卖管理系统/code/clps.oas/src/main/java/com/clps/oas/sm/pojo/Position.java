package com.clps.oas.sm.pojo;

import java.util.Date;

public class Position {
	
    private Integer positionId;

    private String positionName;

    private String positionDescription;

    private String positionLevel;

    private Integer positionDepartmentId;

    private Date positionCreatedDatetime;

    private Integer positionCreatedName;

    private Date positionUpdatedDatetime;

    private Integer positionUpdatedName;

    private String positionDefault1;

    private String positionDefault2;

    private Integer positionIsvalued;

	public Position() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Position(Integer positionId, String positionName, String positionDescription, String positionLevel,
			Integer positionDepartmentId, Date positionCreatedDatetime, Integer positionCreatedName,
			Date positionUpdatedDatetime, Integer positionUpdatedName, String positionDefault1, String positionDefault2,
			Integer positionIsvalued) {
		super();
		this.positionId = positionId;
		this.positionName = positionName;
		this.positionDescription = positionDescription;
		this.positionLevel = positionLevel;
		this.positionDepartmentId = positionDepartmentId;
		this.positionCreatedDatetime = positionCreatedDatetime;
		this.positionCreatedName = positionCreatedName;
		this.positionUpdatedDatetime = positionUpdatedDatetime;
		this.positionUpdatedName = positionUpdatedName;
		this.positionDefault1 = positionDefault1;
		this.positionDefault2 = positionDefault2;
		this.positionIsvalued = positionIsvalued;
	}

	public Integer getPositionId() {
		return positionId;
	}

	public void setPositionId(Integer positionId) {
		this.positionId = positionId;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public String getPositionDescription() {
		return positionDescription;
	}

	public void setPositionDescription(String positionDescription) {
		this.positionDescription = positionDescription;
	}

	public String getPositionLevel() {
		return positionLevel;
	}

	public void setPositionLevel(String positionLevel) {
		this.positionLevel = positionLevel;
	}

	public Integer getPositionDepartmentId() {
		return positionDepartmentId;
	}

	public void setPositionDepartmentId(Integer positionDepartmentId) {
		this.positionDepartmentId = positionDepartmentId;
	}

	public Date getPositionCreatedDatetime() {
		return positionCreatedDatetime;
	}

	public void setPositionCreatedDatetime(Date positionCreatedDatetime) {
		this.positionCreatedDatetime = positionCreatedDatetime;
	}

	public Integer getPositionCreatedName() {
		return positionCreatedName;
	}

	public void setPositionCreatedName(Integer positionCreatedName) {
		this.positionCreatedName = positionCreatedName;
	}

	public Date getPositionUpdatedDatetime() {
		return positionUpdatedDatetime;
	}

	public void setPositionUpdatedDatetime(Date positionUpdatedDatetime) {
		this.positionUpdatedDatetime = positionUpdatedDatetime;
	}

	public Integer getPositionUpdatedName() {
		return positionUpdatedName;
	}

	public void setPositionUpdatedName(Integer positionUpdatedName) {
		this.positionUpdatedName = positionUpdatedName;
	}

	public String getPositionDefault1() {
		return positionDefault1;
	}

	public void setPositionDefault1(String positionDefault1) {
		this.positionDefault1 = positionDefault1;
	}

	public String getPositionDefault2() {
		return positionDefault2;
	}

	public void setPositionDefault2(String positionDefault2) {
		this.positionDefault2 = positionDefault2;
	}

	public Integer getPositionIsvalued() {
		return positionIsvalued;
	}

	public void setPositionIsvalued(Integer positionIsvalued) {
		this.positionIsvalued = positionIsvalued;
	}

	@Override
	public String toString() {
		return "Position [positionId=" + positionId + ", positionName=" + positionName + ", positionDescription="
				+ positionDescription + ", positionLevel=" + positionLevel + ", positionDepartmentId="
				+ positionDepartmentId + ", positionCreatedDatetime=" + positionCreatedDatetime
				+ ", positionCreatedName=" + positionCreatedName + ", positionUpdatedDatetime="
				+ positionUpdatedDatetime + ", positionUpdatedName=" + positionUpdatedName + ", positionDefault1="
				+ positionDefault1 + ", positionDefault2=" + positionDefault2 + ", positionIsvalued=" + positionIsvalued
				+ "]";
	}

    
}