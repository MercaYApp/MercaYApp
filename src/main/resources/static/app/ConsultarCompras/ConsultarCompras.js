'use strict';
//mercayapp
angular.module('myApp.ConsultarCompras', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/ConsultarCompras', {
                    templateUrl: 'ConsultarCompras/ConsultarCompras.html',
                    controller: 'ConsultarComprasCtrl'
                });
            }])


        .controller('ConsultarComprasCtrl', ['$scope', '$mdDialog', '$mdMedia', '$rootScope', 'GetClientInvoices', 'GetClientApp', 'GetProductInvoices', function ($scope, $mdDialog, $mdMedia, $rootScope, GetClientInvoices, GetClientApp, GetProductInvoices) {
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
                };
                $scope.showAlert();
                $scope.cargarProductos = function (ev, i) {
                    var products = GetProductInvoices.get({id: i.idInvoices});
                    products.$promise.then(function(data){
                        $rootScope.listadoProductos=data;
                        $scope.total=0;
                        $scope.peso=0;
                        for(var j=0; j<$rootScope.listadoProductos.length;j++){
                            var porcentaje=$rootScope.listadoProductos[j].percentage;
                            var compra=$rootScope.listadoProductos[j].buyPrice;
                            $scope.total=$scope.total+compra*(1+(porcentaje)/100);
                            $scope.peso=$scope.peso+$rootScope.listadoProductos[j].weight;  
                        }
                        //alert("VENTA: "+$scope.total+"  PESO:  "+$scope.peso);
                        console.log("v2 REST response------> VENTA: "+$scope.total+"  PESO:  "+$scope.peso)
                        var useFullScreen = ($mdMedia('sm') || $mdMedia('xs')) && $scope.customFullscreen;
                        alert($scope.listadoProductos);
                        $mdDialog.show({
                            //controller: ConsultarComprasCtrl,
                            templateUrl: 'ConsultarCompras/dialog1.tmpl.html',
                            parent: angular.element(document.body),
                            targetEvent: ev,
                            clickOutsideToClose: true,
                            locals: {
                                products: $scope.listadoProductos
                            },
                            controller: dialogController,
                            fullscreen: useFullScreen
                        })
                                .then(function (answer) {
                                    
                                    console.log("--->Evento dialogo");
                      
                                    $scope.status = 'You said the information was "' + answer + '".';
                                }, function () {
                      
                                    console.log("--->Evento dialogo 2");
                      
                                    $scope.status = 'You cancelled the dialog.';
                                });
                        $scope.$watch(function () {
                            return $mdMedia('xs') || $mdMedia('sm');
                        }, function (wantsFullScreen) {
                            $scope.customFullscreen = (wantsFullScreen === true);
                        });
                        
                    });
                    
                    function dialogController($scope, $mdDialog, products) {
                        $scope.listadoProdcutos = products;
                        $scope.closeDialog = function() {
                          $mdDialog.hide();
                        }
                      }
                };
            }]);