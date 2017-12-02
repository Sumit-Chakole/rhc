/**
 * ============================================================
 * File : BaseDAO.java
 * Description : 
 * 
 * Package : com.ge.energy.Aeroapp.dao
 * Author : iGATE
 * Last Edited By :
 * Version : 1.0
 * Created on : June 20, 2013
 * History
 * Modified By : Initial Release
 * Classification : GE Confidential
 * Copyright (C) 2012 General Electric Company. All rights reserved
 *
 * ============================================================
 */
package com.ts.rhc.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import java.util.List;
import java.util.Map;

/**
 * The Class BaseDAO.
 */
public class BaseDAO {
	
	protected JdbcTemplate template;

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	protected <T> List<T> executeStoreProcedure(String storedProcedureName, Map<String, ?> inParamMap, Object mapper, Class<T> returnObjectClass){
		
		if (storedProcedureName!=null && !storedProcedureName.isEmpty() && mapper!=null && mapper instanceof RowMapper){
			SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(template).withProcedureName(storedProcedureName)
					.returningResultSet("resultSet", (RowMapper<?>) mapper);

			SqlParameterSource in = new MapSqlParameterSource(inParamMap);

			Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(in);
			
			List<T> resultSet= (List<T>) simpleJdbcCallResult.get("resultSet");

			return resultSet;
		}
		
		return null;
	}
	
	/**
	 * Execute stored proceduure
	 * which returns out params
	 * 
	 * @param storedProcedureName	Stored Procedure name
	 * @param inParamMap			In params
	 * @return
	 */
	protected Map<String, Object> executeStoreProcedure(String storedProcedureName, Map<String, ?> inParamMap){
		
		if (storedProcedureName!=null && !storedProcedureName.isEmpty()){
			
			SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(template).withProcedureName(storedProcedureName);
			SqlParameterSource in = new MapSqlParameterSource(inParamMap);

			return simpleJdbcCall.execute(in);
		}
		
		return null;
	}
	
}
