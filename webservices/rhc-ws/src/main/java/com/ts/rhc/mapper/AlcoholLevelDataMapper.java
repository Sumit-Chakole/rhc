package com.ts.rhc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ts.rhc.model.AlcoholLevelData;
import com.ts.rhc.util.AppSPConstants;

public class AlcoholLevelDataMapper implements RowMapper<AlcoholLevelData> {
	public AlcoholLevelData mapRow(ResultSet rs, int rowNum) throws SQLException {
		AlcoholLevelData alcoholLevelData = new AlcoholLevelData();
		
		try {
			alcoholLevelData.setDeviceSerialNumber(rs.getString(AppSPConstants.SPOUT_DEVICE_SERIAL_NUMBER));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			alcoholLevelData.setAlocholLevelData(rs.getInt(AppSPConstants.SPOUT_ALCOHOL_LEVEL_DATA));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			alcoholLevelData.setCreatedOn(rs.getDate(AppSPConstants.SPOUT_CREATED_ON));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return alcoholLevelData;
	}

}
