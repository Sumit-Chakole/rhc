package com.ts.rhc.controller;

import com.ts.rhc.framework.SpringApplicationContext;
import com.ts.rhc.model.AppWSOutput;
import com.ts.rhc.model.AlcoholLevelData;
import com.ts.rhc.service.AlcoholLevelDataService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin
public class AlcoholLevelDataWS extends BaseController {

	/**
	 * Create Order
	 * 
	 * @param deviceSerialNumber	Device Serial Number
	 * @param alocoholLevel			Alcohol Level Data
	 * 
	 * @return the AppWSOutput		Operation Status
	 */

	@RequestMapping(value = "/createAlcoholLevelData", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public AppWSOutput createAlcoholLevelData(@RequestParam("deviceSerialNumber") String deviceSerialNumber, @RequestParam("alcoholLevel") int alocoholLevel) {

		AlcoholLevelDataService alcoholLevelDataService = (AlcoholLevelDataService) SpringApplicationContext
				.getBean("alcoholLevelDataService");

		AppWSOutput nvieinWSOutput = new AppWSOutput();
		nvieinWSOutput.setResultSet(null);
		
		AlcoholLevelData alcoholLevelData= new AlcoholLevelData();
		alcoholLevelData.setAlocholLevelData(alocoholLevel);
		alcoholLevelData.setDeviceSerialNumber(deviceSerialNumber);
		
		try {
			int operationStatus = alcoholLevelDataService.createAlcoholLevelData(alcoholLevelData);
			nvieinWSOutput.setOperationStatus(operationStatus);

		} catch (Exception e) {

			nvieinWSOutput.setOperationStatus(getErrorCode(e));
			e.printStackTrace();
		}

		return nvieinWSOutput;
	}
	
}