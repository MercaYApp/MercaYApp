'use strict';
//mercayapp
angular.module('myApp.ConsultarCompras', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/ConsultarCompras', {
                    templateUrl: 'ConsultarCompras/ConsultarCompras.html',
                    controller: 'ConsultarComprasCtrl'
                });
            }])

        .controller('ConsultarComprasCtrl', ['$scope', 'GetClientInvoices', function ($scope, GetClientInvoices) {
                //$scope.listadoInvoices=GetClientInvoices.get({id: $scope.id});
                $scope.listadoInvoices = GetClientInvoices.get({id: 16});
            }]);