
package com.ts.rhc.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.ts.rhc.mapper.AlcoholLevelDataMapper;
import com.ts.rhc.model.AlcoholLevelData;
import com.ts.rhc.model.AppWSOutput;
import com.ts.rhc.util.AppSPConstants;
import com.ts.rhc.util.AppWSStatusCodes;

/**
 * The Class UserResposibilityDaoImpl.
 */
public class AlcoholLevelDataDao extends BaseDAO{

	/**
	 * Create Alcohol Level Data
	 *
	 * @param alcoholLevelData		Alcohol Level Data
	 * 
	 * @return operationStatusCode	Operation Status
	 */


	public int createAlcoholLevelData(AlcoholLevelData alcoholLevelData) throws Exception {
        int operationStatus= AppWSStatusCodes.UNKNOWNERROR;
        
        if (alcoholLevelData!=null && alcoholLevelData.getAlocholLevelData()!=null && alcoholLevelData.getDeviceSerialNumber()!=null){
        	Map<String, Object> inParamMap = new HashMap<String, Object>();
            inParamMap.put(AppSPConstants.SPIN_DEVICE_SERIAL_NUMBER, alcoholLevelData.getDeviceSerialNumber());
            inParamMap.put(AppSPConstants.SPIN_ALCOHOL_LEVEL_DATA, alcoholLevelData.getAlocholLevelData());
            
            Map<String, Object> outParam= executeStoreProcedure(AppSPConstants.SPNAME_CREATEALCOHOLLEVELDATA, inParamMap);
            
            operationStatus= (Integer) outParam.get(AppSPConstants.SPOUT_STATUS);
        }

		return operationStatus;
	}
	
	/**
	 * Get all Alcohol Level Records
	 * 
	 * @return the alcoholLevelRecords		List of Alcohol Level data
	 */
	public ArrayList<AlcoholLevelData> getAllAlcoholLevelRecords() throws Exception{
		return (ArrayList<AlcoholLevelData>) executeStoreProcedure(AppSPConstants.SPNAME_GETALLALCOHOLLEVELRECORDS, null, new AlcoholLevelDataMapper(), AlcoholLevelData.class);
	}
}
