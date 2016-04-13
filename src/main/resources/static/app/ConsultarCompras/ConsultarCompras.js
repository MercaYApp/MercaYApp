'use strict';
//mercayapp
angular.module('myApp.ConsultarCompras', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/ConsultarCompras', {
                    templateUrl: 'ConsultarCompras/ConsultarCompras.html',
                    controller: 'ConsultarComprasCtrl'
                });
            }])

        .controller('ConsultarComprasCtrl', ['$scope', '$rootScope', 'GetClientInvoices', 'GetClientApp', function ($scope, $rootScope, GetClientInvoices, GetClientApp) {
                //$scope.listadoInvoices=GetClientInvoices.get({id: $scope.id});
                $scope.clientListadoInvoices = GetClientApp.get({id: $rootScope.credentials.username});
                $scope.listadoInvoices = GetClientInvoices.get({id: $rootScope.credentials.username});
            }]);