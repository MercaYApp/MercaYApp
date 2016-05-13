'use strict';
//mercayapp
angular.module('myApp.ConsultarCompras', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/ConsultarCompras', {
                    templateUrl: 'ConsultarCompras/ConsultarCompras.html',
                    controller: 'ConsultarComprasCtrl'
                });
            }])


        .controller('ConsultarComprasCtrl', ['$scope', '$mdDialog', '$mdMedia', '$rootScope', 'GetClientInvoices', 'GetClientApp', 'GetProductInvoices', /*'GetClientsExternos',*/ 
                                    function ($scope, $mdDialog, $mdMedia, $rootScope, GetClientInvoices, GetClientApp, GetProductInvoices/*, GetClientsExternos*/) {
                $scope.total=0;
                $scope.peso=0;
                $scope.clientListadoInvoices = {};
                $scope.listadoInvoices = {};
                $rootScope.listadoProductos = {};
                $scope.showAlert = function () {
                    var client = GetClientApp.get({id: $rootScope.credentials.username});
                    client.$promise.then(function (data) {
                        $scope.clientListadoInvoices = data;
                        var listado = GetClientInvoices.get({id: $rootScope.credentials.username});
                        listado.$promise.then(function (data) {
                            $scope.listadoInvoices = data;
                                /*////////////////BORRAR//////////////////////*///$scope.listadoProductos=$scope.listadoInvoices[0].productses;
                        });
                    });
                    
                    //PROBANDO API EXTERNO
                    /*var clientE = GetClientsExternos.get();
                    clientE.$promise.then(function (data2) {
                        $scope.clientExterno = data2;
                        alert($scope.clientExterno.clientes.size+"Cliente externo");
                        
                    });*/
                };
                $scope.showAlert();
                $scope.cargarProductos = function (ev, i) {
                    $rootScope.idInvoiceDetalle=i;
                    var products = GetProductInvoices.get({id: i.idInvoices});
                    products.$promise.then(function(data){
                        $rootScope.listadoProductos=data;
                        var useFullScreen = ($mdMedia('sm') || $mdMedia('xs')) && $scope.customFullscreen;
                        $mdDialog.show({
                            controller: DialogController,
                            templateUrl: 'ConsultarCompras/dialog1.tmpl.html',
                            parent: angular.element(document.body),
                            targetEvent: ev,
                            clickOutsideToClose: true,
                            fullscreen: useFullScreen
                        })
                                .then(function (answer) {
                                    $scope.status = 'You said the information was "' + answer + '".';
                                }, function () {
                                    $scope.status = 'You cancelled the dialog.';
                                });
                        $scope.$watch(function () {
                            return $mdMedia('xs') || $mdMedia('sm');
                        }, function (wantsFullScreen) {
                            $scope.customFullscreen = (wantsFullScreen === true);
                        });
                        
                    });
                    
                    function DialogController($scope, $mdDialog) {
                        $scope.listadoProductos=$rootScope.listadoProductos;
                        $scope.total=0;
                        $scope.peso=0;
                        $scope.invoiceDetalle=$rootScope.idInvoiceDetalle;
                        for(var j=0; j<$rootScope.listadoProductos.length;j++){
                            var porcentaje=$rootScope.listadoProductos[j].percentage;
                            var compra=$rootScope.listadoProductos[j].buyPrice;
                            $scope.total=$scope.total+compra*(1+(porcentaje)/100);
                            $scope.peso=$scope.peso+$rootScope.listadoProductos[j].weight;  
                        }
                        $scope.totalD=$scope.total;
                        $scope.pesoD=$scope.peso;
                        $scope.hide = function() {
                            $mdDialog.hide();
                          };
                          $scope.cancel = function() {

                              $mdDialog.cancel();

                          };
                          $scope.answer = function(answer) {
                            $mdDialog.hide(answer);
                          };
                      }
                };
            }]);