
var App = angular.module('dashboard', [ 'ngResource' ]);


App.factory('AppResource', [ '$resource','$window', function($resource, $window) {
	//$resource() function returns an object of resource class
	
	return $resource($window._contextPath + '/doctor/appointment/list', {}, {
		save : {

			method : 'POST',
			headers : {
				'X-CSRF-TOKEN' : $window._csrftoken,
				'Content-Type' : 'application/json'
			}
		}
	}, {
		stripTrailingSlashes : false
	});
} ]);

App.controller('dashboardController', ['$scope', '$window', 'AppResource', function($scope, $window, AppResource) {
	var data = {
		'doctor' : $window._practitioner
	};
	var response = AppResource.save({}, data, function(){
		 $scope.appointmentList = response.appointmentList;
	});
}]);
