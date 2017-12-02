/*
 * Navigation service
 */
app.service('navigation', function($location, $window) {
	
	var transitionData=null;
	var navigationStack= [];
	
	/*
	 * Function to fetch transition data
	 */
	var getTransitionData= function(){
		
		var data= transitionData;
		transitionData=null;
		return data;
	}
	
	/*
	 * Distroy screen
	 */
	var destroyScreen= function(route, data){
		transitionData= data;
		
		if (navigationStack.length>1){
			$window.history.back();
		}else{
			routeTo(route, false, data);
		}
		
	}
	
	/**
	 * Browser back
	 */
	var navigateBack= function(){
		$window.history.back();
	}
	
	/*
	 * This function will route page to specified path
	 */
	var routeTo = function(route, keepHistory, data) {
		
		if (keepHistory==null || keepHistory){
			$location.path("/" + route);
			navigationStack.push(route);
		}else{
			$location.path("/" + route).replace();
			navigationStack.pop();
			navigationStack.push(route);
		}
			
		transitionData= data;
	};

	/*
	 * Routes keys
	 */
	var routes = {
		MANAGEORDER: "orders",
		UPDATEORDER:"order/edit",
		MANAGEPARTY: "parties",
		UPDATEPARTY:"party/edit"
	};
	
	return {
		routeTo : routeTo,
		routes : routes,
		getTransitionData: getTransitionData,
		destroyScreen: destroyScreen,
		navigateBack: navigateBack
	}

});
