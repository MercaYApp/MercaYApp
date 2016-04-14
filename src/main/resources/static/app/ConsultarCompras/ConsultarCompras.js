'use strict';
//mercayapp
angular.module('myApp.ConsultarCompras', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/ConsultarCompras', {
                    templateUrl: 'ConsultarCompras/ConsultarCompras.html',
                    controller: 'ConsultarComprasCtrl'
                });
            }])


        .controller('ConsultarComprasCtrl', [ '$scope', '$rootScope', 'GetClientInvoices', 'GetClientApp', 'GetProduct', function ( $scope, $rootScope, GetClientInvoices, GetClientApp, GetProduct) {
                
                $scope.clientListadoInvoices = {};
                $scope.listadoInvoices = {};
                $scope.showAlert = function () {
                    var client = GetClientApp.get({id: $rootScope.credentials.username});
                    client.$promise.then(function (data) {
                        $scope.clientListadoInvoices = data;
                        alert("NADA: "+$scope.clientListadoInvoices.idClients);
                        
                        var listado = GetClientInvoices.get({id: $rootScope.credentials.username});
                        listado.$promise.then(function (data) {
                            $scope.listadoInvoices=data;    
                        });
                    });
                };
        
            }]);