
package com.ts.rhc.model;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * The Class UserResposibilityDto.
 */
public class AlcoholLevelData {

	private Integer id;
	private Integer alocholLevelData;
	private String deviceSerialNumber;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAlocholLevelData() {
		return alocholLevelData;
	}
	public void setAlocholLevelData(Integer alocholLevelData) {
		this.alocholLevelData = alocholLevelData;
	}
	public String getDeviceSerialNumber() {
		return deviceSerialNumber;
	}
	public void setDeviceSerialNumber(String deviceSerialNumber) {
		this.deviceSerialNumber = deviceSerialNumber;
	}
	@Override
	public String toString() {
		return "AlcoholLevelData [id=" + id + ", alocholLevelData=" + alocholLevelData + ", deviceSerialNumber="
				+ deviceSerialNumber + "]";
	}

    
}
