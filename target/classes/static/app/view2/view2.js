'use strict';

angular.module('myApp.view2', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/view2', {
    templateUrl: 'view2/view2.html',
    controller: 'View2Ctrl'
  });
}])

.controller('View2Ctrl', ['$scope', '$filter', 'Get' ,function($scope, $filter, Get){ 
    var orderBy = $filter('orderBy');
//    $scope.listado= servicio1.getListado();
    
        Get.get(function(data){ 
                $scope.listado=data; 
            });

    $scope.order = function(predicate) {
        $scope.predicate = predicate;
        $scope.reverse = ($scope.predicate === predicate) ? !$scope.reverse : false;
        $scope.listado = orderBy($scope.listado, predicate, $scope.reverse);

    };
    $scope.order('nombre', true);
}]);