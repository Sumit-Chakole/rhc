package com.ts.rhc.controller;

import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.dao.TransientDataAccessResourceException;

import com.ts.rhc.util.AppWSStatusCodes;

public class BaseController {
	
	/*
	 * To determine kind of exception
	 * in general expections
	 */
	protected int getErrorCode(Exception e){
		if (e instanceof DataAccessResourceFailureException){
			return AppWSStatusCodes.REMOTESERVERDOWN;
		}else if (e instanceof InvalidDataAccessApiUsageException){
			return AppWSStatusCodes.REMOTESERVERDOWN;
		}else{
			return AppWSStatusCodes.UNKNOWNERROR;
		}
	}

}
