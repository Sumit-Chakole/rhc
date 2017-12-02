
package com.ts.rhc.dao;

import com.ts.rhc.mapper.AlcoholLevelDataMapper;
import com.ts.rhc.model.AlcoholLevelData;
import com.ts.rhc.util.AppConstants;
import com.ts.rhc.util.AppSPConstants;
import com.ts.rhc.util.AppWSStatusCodes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
}
