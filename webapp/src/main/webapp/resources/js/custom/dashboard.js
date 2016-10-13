angular.module('HelloWorldApp', [])
   .controller('HelloWorldController', function($scope) {
        $scope.NameChange = function () {
             $scope.greeting = "Hello " + $scope.name;
         };
});
