
package com.ts.rhc.model;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * The Class UserResposibilityDto.
 */
public class AlcoholLevelData {

	private Integer id;
	private String alocholLevelData;
	private String deviceSerialNumber;
	private Date createdOn;
	private Date updatedOn;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAlocholLevelData() {
		return alocholLevelData;
	}
	public void setAlocholLevelData(String alocholLevelData) {
		this.alocholLevelData = alocholLevelData;
	}
	public String getDeviceSerialNumber() {
		return deviceSerialNumber;
	}
	public void setDeviceSerialNumber(String deviceSerialNumber) {
		this.deviceSerialNumber = deviceSerialNumber;
	}
	public Date getCreatedOn() {
		
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	
	}
	public Date getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}
	@Override
	public String toString() {
		return "AlcoholLevelData [id=" + id + ", alocholLevelData=" + alocholLevelData + ", deviceSerialNumber="
				+ deviceSerialNumber + ", createdOn=" + createdOn + ", updatedOn=" + updatedOn + "]";
	}
}
