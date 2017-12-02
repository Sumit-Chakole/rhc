/*
 * App routes
 */

app.config(function ($routeProvider, $locationProvider) {

    $routeProvider.when('/', {
        templateUrl: 'partial_views/dashboard.html?v='+appVersion,
        controller: 'dashBoardController',
        controllerAs: 'lvm'
    }).otherwise({
    	redirectTo:'/'
    });
    
    $locationProvider.html5Mode({
    	  enabled: true
    	});
});