/**
 * End points for server 
 */

app.service('serverEndpoints', function() {

	return {
		
		/****** URLs ****************/

        baseUrl:"/rhcws/",

		getAllAlcoholLevelRecords:"getAllAlcoholLevelRecords",

		/******* Headers ********/
		contentType: "Content-Type",
			
		/****** Models *******/
		
		/*Order*/
        alcoholDataId:"orderId",
		deviceSerialNumber:"quantity",
		alcoholLevel:"squareFeet",
		
		/*Authentication Token*/
		authenticationToken:"authenticationToken",
		
		/*Base Service Response*/
		operationStatus:"operationStatus",
		resultSet:"resultSet"
	}
});