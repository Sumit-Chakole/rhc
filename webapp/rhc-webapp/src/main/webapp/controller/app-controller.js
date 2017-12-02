/**
 * Meal Details view controller
 */
app
		.controller(
				"appController",
				function (strings, $route) {
				    console.log("appController()---->START");

				    var vm = this;

				    /*
					 * Fetching all string resources
					 */
				    vm.strings = strings;

				    vm.login= function(){
                        $route.reload();
					}

                    vm.orderStatus=['Cancelled','Completed','Delivered','Dispatch','Ready','Packaging','Production','BOM'];

				    console.log("appController()---->END");
				});
