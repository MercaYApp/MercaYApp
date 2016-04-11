'use strict';
//mercayapp
angular.module('myApp.ConsultarCompras', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/ConsultarCompras', {
                    templateUrl: 'ConsultarCompras/ConsultarCompras.html',
                    controller: 'ConsultarComprasCtrl'
                });
            }])

        .controller('ConsultarComprasCtrl', ['$scope', 'GetClientInvoices', 'GetClientApp', function ($scope, GetClientInvoices, GetClientApp) {
                //$scope.listadoInvoices=GetClientInvoices.get({id: $scope.id});
                $scope.clientListadoInvoices = GetClientApp.get({id: 16});
                $scope.listadoInvoices = GetClientInvoices.get({id: 16});
            }]);