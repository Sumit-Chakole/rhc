package com.ts.rhc.service;
import com.ts.rhc.dao.AlcoholLevelDataDao;
import com.ts.rhc.model.AlcoholLevelData;

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
}
