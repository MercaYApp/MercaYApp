'use strict';

angular.module('myApp.viewConfiguracion', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/viewConfiguracion', {
                    templateUrl: 'viewConfiguracion/viewConfiguracion.html',
                    controller: 'ViewConfiguracionController'
                });
            }])

        .controller('ViewConfiguracionController', ['$scope', 'GetClient', 'GetClientApp', 'PostClientApp', 'DeleteClientApp', function ($scope, GetClient, GetClientApp, PostClientApp, DeleteClientApp) {

                $scope.selectConfiguracion = 'selectAgregar';
                $scope.supermarketConfiguracion = 'Exito';
                $scope.banderaAgregaSuper = false;
                $scope.idConfiguracion = 16;
                $scope.clientConfiguracion = {};
                var postDataConfiguracion = {};


                $scope.agregarMasSupermercadosConfiguracion = function () {
                    alert("Quiere agregar mas supermercados de Configuracion");
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


                $scope.actualizarDatosClienteConfiguracion = function () {
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
                };

                $scope.cancelarConfiguracion = function () {
                    alert("Quiere cancelar configuracion");
                };
            }]);