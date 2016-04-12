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
                //$scope.listadoInvoices=GetClientInvoices.get({id: $scope.id});
                //$scope.clientListadoInvoices = GetClientApp.get({id: $rootScope.credentials.username});
                $scope.listadoInvoices = {};
                $scope.listadoInvoices = GetClientInvoices.get({id: $rootScope.credentials.username});
               
                //$scope.showAlert = showAlert;
                $scope.showAlert = function () {
                    alert("product here");
                };


                /*alert("entro a la funcion");
                 var clientesI = GetClientInvoices.get({id: $scope.id});
                 var listadoI = GetClientInvoices.get({id: $rootScope.credentials.username});
                 alert(clientesI);
                 alert(listadoI);
                 clientesI.$promise.then(function (data) {
                 $scope.clientListadoInvoices = data;
                 listadoI.$promise.then(function (data1) {
                 $scope.listadoInvoices = data1;
                 $scope.showAlert = function (ev, i) {
                 var a = i.IdInvoices;
                 alert(a);
                 };
                 });
                 
                 
                 });*/
        
            }]);