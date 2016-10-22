/**
 * 
 */

var App = angular.module('newappointment', ['ui.bootstrap']);
//
//
// App.factory('AppResource', [ '$resource','$window', function($resource,
// $window) {
// //$resource() function returns an object of resource class
//	
// return $resource($window._contextPath + '/doctor/appointment/list', {}, {
// save : {
//
// method : 'POST',
// headers : {
// 'X-CSRF-TOKEN' : $window._csrftoken,
// 'Content-Type' : 'application/json'
// }
// }
// }, {
// stripTrailingSlashes : false
// });
// } ]);

App.controller('appointController', [
		'$scope',
		'$window',
		'$http',
		function($scope, $window, $http) {

			$scope.getPatients = function(val) {
				var request = {
					method : 'POST',
					url : $window._contextPath + '/patient/search',
					headers : {
						'X-CSRF-TOKEN' : $window._csrftoken,
						'Content-Type' : 'application/json'
					},
					data : {
						patientName : val
					}
				};

				return $http(request).then(function(response) {
					return response.data.patientList.map(function(item) {
						return item;
					});
				});
			};

		}]);
