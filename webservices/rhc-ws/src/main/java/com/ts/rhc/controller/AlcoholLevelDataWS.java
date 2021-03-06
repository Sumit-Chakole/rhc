package com.ts.rhc.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.*;

import com.ts.rhc.framework.SpringApplicationContext;
import com.ts.rhc.model.AlcoholLevelData;
import com.ts.rhc.model.AppWSOutput;
import com.ts.rhc.service.AlcoholLevelDataService;
import com.ts.rhc.util.AppWSStatusCodes;

import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AlcoholLevelDataWS extends BaseController {

	/**
	 * Create Alcohol Level Record
	 * 
	 * @param deviceSerialNumber	Device Serial Number
	 * @param alocoholLevel			Alcohol Level Data
	 * 
	 * @return the AppWSOutput		Operation Status
	 */

	@RequestMapping(value = "/createAlcoholLevelData", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public AppWSOutput createAlcoholLevelData(@RequestBody AlcoholLevelData alcoholLevelData) {

		AlcoholLevelDataService alcoholLevelDataService = (AlcoholLevelDataService) SpringApplicationContext
				.getBean("alcoholLevelDataService");

		AppWSOutput nvieinWSOutput = new AppWSOutput();
		nvieinWSOutput.setResultSet(null);
		
		try {
			int operationStatus = alcoholLevelDataService.createAlcoholLevelData(alcoholLevelData);
			nvieinWSOutput.setOperationStatus(operationStatus);

		} catch (Exception e) {

			nvieinWSOutput.setOperationStatus(getErrorCode(e));
			e.printStackTrace();
		}

		return nvieinWSOutput;
	}
	
	/**
	 * Get all Alcohol Level Records
	 * 
	 * @return the AppWSOutput		List of Alcohol Level data
	 */

	@RequestMapping(value = "/getAllAlcoholLevelRecords", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public AppWSOutput getAllAlcoholLevelRecords() {

		AlcoholLevelDataService alcoholLevelDataService = (AlcoholLevelDataService) SpringApplicationContext
				.getBean("alcoholLevelDataService");

		AppWSOutput nvieinWSOutput = new AppWSOutput();
		nvieinWSOutput.setResultSet(null);
		
		try {
			ArrayList<AlcoholLevelData> alcoholLevelRecords = alcoholLevelDataService.getAllAlcoholLevelRecords();
			nvieinWSOutput.setOperationStatus(AppWSStatusCodes.OPERATIONSUCCESSFULL);
			nvieinWSOutput.setResultSet(alcoholLevelRecords);

		} catch (Exception e) {

			nvieinWSOutput.setOperationStatus(getErrorCode(e));
			e.printStackTrace();
		}

		return nvieinWSOutput;
	}
}