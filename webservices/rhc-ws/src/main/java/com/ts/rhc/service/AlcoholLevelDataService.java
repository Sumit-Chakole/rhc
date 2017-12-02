package com.ts.rhc.service;
import java.util.ArrayList;

import com.ts.rhc.dao.AlcoholLevelDataDao;
import com.ts.rhc.model.AlcoholLevelData;
import com.ts.rhc.model.AppWSOutput;

/**
 * The Class UserResposibilityServiceImpl.
 */
public class AlcoholLevelDataService {

	private final static AlcoholLevelDataService instance = new AlcoholLevelDataService();

	public static AlcoholLevelDataService getInstance() {

		return instance;
	}

	AlcoholLevelDataDao alcoholLevelDataDao;
	
	public AlcoholLevelDataDao getAlcoholLevelDataDao() {
		return alcoholLevelDataDao;
	}

	public void setAlcoholLevelDataDao(AlcoholLevelDataDao alcoholLevelDataDao) {
		this.alcoholLevelDataDao = alcoholLevelDataDao;
	}

	/**
	 * Create Alcohol Level Data
	 * 
	 * @param alcoholLevelData		Alcohol Level Data
	 * 
	 * @return operationStatusCode	Operation Status
	 */
	
	
	public int createAlcoholLevelData(AlcoholLevelData alcoholLevelData) throws Exception {

		return alcoholLevelDataDao.createAlcoholLevelData(alcoholLevelData);
	}
	
	/**
	 * Get all Alcohol Level Records
	 * 
	 * @return the alcoholLevelRecords		List of Alcohol Level data
	 */
	public ArrayList<AlcoholLevelData> getAllAlcoholLevelRecords() throws Exception{
		return alcoholLevelDataDao.getAllAlcoholLevelRecords();
	}
}
