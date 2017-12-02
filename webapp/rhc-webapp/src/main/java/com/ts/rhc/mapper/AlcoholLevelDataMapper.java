package com.ts.rhc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ts.rhc.model.AlcoholLevelData;

public class AlcoholLevelDataMapper implements RowMapper<AlcoholLevelData> {
	public AlcoholLevelData mapRow(ResultSet rs, int rowNum) throws SQLException {
		AlcoholLevelData alcoholLevelData = new AlcoholLevelData();
		
		try {
			//alcoholLevelData.setOrderStatus(rs.getString(AppSPConstants.SPOUT_ORDERSTATUS));
		} catch (Exception e) {
			//e.printStackTrace();
		}
		
		return alcoholLevelData;
	}

}
