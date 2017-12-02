(function() {
	'use strict';

	app.controller('dashBoardController', dashBoardController);

	dashBoardController.$inject = ['$scope', 'datasource',
			 'serverEndpoints', 'strings'];
	function dashBoardController($scope, datasource,
			 serverEndpoints, strings) {

		console.log("dashBoardController()----> Start");

		var lvm = this;
        var vm = $scope.$parent.vm;

            // Fetching existing orders
            lvm.getAlcoholLevelData = function() {

                datasource
                    .getData(
                        serverEndpoints.getAllAlcoholLevelRecords,
                        {},
                        {},
                        function(isSuccess, data) {
                            lvm.alcoholLevelRecords=[];

                            if (isSuccess) {
                                lvm.alcoholLevelRecords = data;
								
								if (lvm.alcoholLevelRecords.length<=0){
									lvm.listErrorMessage = strings.msg_no_orders_exists;
								}

                            } else {

                                if (data != null) {
									lvm.listErrorMessage = strings.msg_failed_loading_alcohol_level_data
										+ " " + data;
                                } else {
                                    lvm.listErrorMessage = strings.msg_failed_loading_alcohol_level_data;
                                }

                            }
                        });
            }

            lvm.getAlcoholLevelData();

		console.log("dashBoardController()---->End");
	}

})();
