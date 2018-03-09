
package com.ts.rhc.util;

public class AppSPConstants {
	
	/******** Common for all operations ******/

	// In param name

	// Output mapping keys
	public static String SPOUT_STATUS="vOperationStatus";

	/******* Alcohol Level Data Management *********/
	// SP Names
	public static String SPNAME_CREATEALCOHOLLEVELDATA="AlcoholLevelDataManagement_public_sp_getAllRecords";
	public static String SPNAME_GETALLALCOHOLLEVELRECORDS="AlcoholLevelDataManagement_public_sp_getAllRecords";

    //In param names
    public static String SPIN_DEVICE_SERIAL_NUMBER="vDeviceSerialNumber";
    public static String SPIN_ALCOHOL_LEVEL_DATA="vAlcoholLevelData";
	
	// Output mapping keys
    public static String SPOUT_DEVICE_SERIAL_NUMBER="rhc_device_serial_number";
    public static String SPOUT_ALCOHOL_LEVEL_DATA="rhc_alcohol_level";
    public static String SPOUT_CREATED_ON="createdOn";
}
