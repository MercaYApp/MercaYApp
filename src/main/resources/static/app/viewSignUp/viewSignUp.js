'use strict';

angular.module('myApp.viewSignUp', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/viewSignUp', {
                    templateUrl: 'viewSignUp/viewSignUp.html',
                    controller: 'signUpController'
                });
            }])

        .controller('signUpController', ['$scope', '$rootScope', 'GetClientApp', 'PostClientApp', 'GetSupermarket', 'GetSupermarkets', 'GetRol', function ($scope, $rootScope, GetClientApp, PostClientApp, GetSupermarket, GetSupermarkets, GetRol) {
                $scope.id1 = 69;
                $scope.nombre = "";
                $scope.correo = "";
                $scope.password = "";
                $scope.confirmPassword = "";
                $scope.check = false;
                $scope.registrado = false;
                $scope.supermarket = {};
                $rootScope.listSupermarkets = {};
                $scope.rol = {};
                $scope.clientPost = {};
                $scope.supermarketPost = {};


                $scope.consult = function () {
                    //var response = GetClient.get({superm: $scope.supermarket, id: $scope.id1});
                    var response = GetClientApp.get({id: $scope.id1});
                    response.$promise.then(function (data) {
                        $scope.client = data;
                        /*if (("" + $scope.client.id) === $scope.id1.toString()) {
                         $scope.check = true;
                         $scope.id1 = parseInt(response.id);
                         $scope.nombre = response.name;
                         $scope.correo = response.email;
                         //$scope.password = response.password;
                         //$scope.supermarket = $scope.client.supermarkets;
                         alert("SE PUEDE REGISTRAR EL CLIENTE");
                         } else {
                         alert("No se puede registrar usuario con ID: " + $scope.id1);
                         }*/
                        $scope.check = true;
                        alert("SE PUEDE REGISTRAR EL CLIENTE");
                    });
                };

                $scope.seleccionaSupermercado = function (supermercado) {
                    $scope.supermarket = supermercado;
                    alert("SELECCIONO SUPERMERCADO: " + $scope.supermarket);
                };

                $scope.cargarSupermarkets = function () {
                    var response = GetSupermarkets.get();
                    response.$promise.then(function (data) {
                        $scope.listSupermarkets = data;
                    });
                };

                //CARGAR TODOS LOS SUPERMERCADOS REGISTRADOS
                $scope.cargarSupermarkets();

                $scope.demeRol = function () {
                    var response = GetRol.get({id: 1});
                    response.$promise.then(function (data) {
                        $scope.rol = data;
                    });
                };


                $scope.postClientApp = function () {
                    if ($scope.password !== "" && $scope.confirmPassword === $scope.password) {
                        $scope.demeRol();//Cargar rol de cliente

                        var response = GetSupermarket.get({id: $scope.supermarket});
                        response.$promise.then(function (data) {
                            $scope.supermarketPost = data;
                            alert("EN EL POST SUPERMARKET: " + $scope.supermarketPost.idSupermarkets);
                            $scope.clientPost = {idClients: $scope.id1, roles: $scope.rol, nameClientApp: $scope.nombre, email: $scope.correo, password: $scope.password, supermarketses: [$scope.supermarketPost], invoiceses: []};
                            PostClientApp.save($scope.clientPost, function () {
                                alert("El usuario con identificacion '" + $scope.clientPost.idClients + "' ha sido registrado exitosamente en:" + $scope.supermarketPost.nameSupermarket);
                                $scope.registrado = true;
                                $location.path("/");  
                            }
                            );
                        });
                    } else {
                        alert("Las contraseñas no coinciden. ");
                    }
                };
            }]);
        