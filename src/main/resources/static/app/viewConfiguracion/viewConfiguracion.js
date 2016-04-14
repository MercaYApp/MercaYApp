'use strict';

angular.module('myApp.viewConfiguracion', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/viewConfiguracion', {
                    templateUrl: 'viewConfiguracion/viewConfiguracion.html',
                    controller: 'ViewConfiguracionController'
                });
            }])


        .controller('ViewConfiguracionController', ['$scope','$rootScope', '$location', 'GetClient','GetSupermarket', 'GetClientApp','PostClientApp', 'DeleteClientApp','PutClient','PostSupermarketClientes', function ($scope,$rootScope, $location, GetClient,GetSupermarket, GetClientApp, PostClientApp, DeleteClientApp,PutClient,PostSupermarketClientes) {


                $scope.selectConfiguracion = 'selectAgregar';
                $scope.supermarketConfiguracion = 'Exito';
                $scope.banderaAgregaSuper = false;
                $scope.idConfiguracion = $rootScope.credentials.username;
                $scope.idConfiguracionmMercado=16;
                $scope.nombreConfiguracion = "Felipe";
                $scope.clientConfiguracion = {};
                var postDataConfiguracion = {};

                $scope.AgregarSupermercado= function(){
                    var response = GetClientApp.get({id:$scope.idConfiguracionmMercado});
                    
                    
                     response.$promise.then(function (data) {
                        $scope.client = data;
                       // var cliente ={idClients:$scope.idConfiguracion ,roles:{},nameClientApp:$scope.client.nameClientApp ,email:$scope.client.email ,password:$scope.client.password,supermarketses:{},invoiceses:{}};               
                       
                        var response = GetSupermarket.get({id: $scope.idConfiguracionmMercado});
                        response.$promise.then(function (data) {
                            $scope.supermarketPost = data;
                        });
                        
                        var supermercado ={idSupermarkets:$scope.SupermarketId,nameSupermarket:$scope.nombreSupermarket};
                        var cliente ={idClients:$scope.idConfiguracionmMercado ,roles:{},nameClientApp:$scope.client.nameClientApp ,email:$scope.correoConfiguracion ,password:$scope.passwordConfiguracion,supermarketses:[supermercado],invoiceses:[]};               

                        alert("Agrego supermercado al cliente : " + cliente.idClients);
                        
                        PostSupermarketClientes.save(cliente, function () {
                        $location.path("/");    

                        });
                    });
                };
                
                $scope.actualizarDatosClienteConfiguracion= function(){
                    var response = GetClientApp.get({id:$scope.idConfiguracion});
                     response.$promise.then(function (data) {
                        $scope.client = data;
                        var cliente ={idClients:$scope.idConfiguracion ,roles:$scope.client.roles, nameClientApp:$scope.client.nameClientApp ,email:$scope.correoConfiguracion ,password:$scope.passwordConfiguracion};
                        PutClient.save(cliente, function () {
                            alert("Actualizo el cliente:  : " + cliente.email);
                            $location.path("/");

                        });

                      
                    });
                };
                /*$scope.agregarMasSupermercadosConfiguracion = function () {
                    alert("Quiere agregar mas supermercados de Configuracion");
>>>>>>> ca8e30a85b7724f444ef0fd81959b6ed7a0d5e7e
                    var response = GetClientApp.get({id: $scope.idConfiguracion});
                    response.$promise.then(function (data) {
                        $scope.clientConfiguracion = data;
                        if (("" + $scope.clientConfiguracion.id) === $scope.idConfiguracion + "") {
                            alert("aAAAAAAAAAAAAAAAAAAAaaaaaaaaa:" + response.invoices);
                            postDataConfiguracion = {id: response.id, name: response.name, email: response.email, password: response.password, invoices: {}, supermarkets: [$scope.supermarketConfiguracion]};
                            PostClientApp.save(postDataConfiguracion, function () {
                                alert("El usuario con identificacion '" + postDataConfiguracion.id + "' ha sido registrado exitosamente!");

                            }
                            );
                        } else {
                            alert("No se puede registrar usuario con ID: " + $scope.idConfiguracion);
                        }
                    });
                };
                */

                $scope.cargarDatosClientesConfiguracion = function () {
                    var response = GetClientApp.get({id: $scope.idConfiguracion});
                    response.$promise.then(function (data) {
                        $scope.nombreConfiguracion = response.name;
                        $scope.clientConfiguracion = data;
                        if (("" + $scope.clientConfiguracion.id) === $scope.idConfiguracion + "") {
                            //alert("aAAAAAAAAAAAAAAAAAAAaaaaaaaaa:"+response.invoices);
                            $scope.nombreConfiguracion = response.name;
                            $scope.correoConfiguracion = response.email;
                        } else {
                            alert("No se puede registrar usuario con ID: " + $scope.idConfiguracion);
                        }
                    });
                };


                /*$scope.actualizarDatosClienteConfiguracion = function () {
                    alert("Quiere actualizar datos del cliente");
                    var response = GetClientApp.get({id: $scope.idConfiguracion});
                    response.$promise.then(function (data) {
                        $scope.clientConfiguracion = data;
                        if (("" + $scope.clientConfiguracion.id) === $scope.idConfiguracion + "") {
                            alert("aAAAAAAAAAAAAAAAAAAAaaaaaaaaa:" + response.name);
                            //postDataConfiguracion = {id: response.id, name: response.name, email: response.email, password: response.password, invoices: {}, supermarkets: [$scope.supermarketConfiguracion]};
                            postDataConfiguracion={id:$scope.idConfiguracion, name:$scope.nombreConfiguracion, email:$scope.correoConfiguracion, password:$scope.passwordConfiguracion, invoices:{}, supermarkets:[$scope.supermarketConfiguracion]};
                            //DeleteClientApp.get({id: $scope.idConfiguracion});
                            PostClientApp.save(postDataConfiguracion, function () {
                                alert("El usuario con identificacion '" + postDataConfiguracion.id + "' ha sido registrado exitosamente!");
                            }
                            );
                        } else {
                            alert("No se puede registrar usuario con ID: " + $scope.idConfiguracion);
                        }
                    });
                };*/
                

              }]);