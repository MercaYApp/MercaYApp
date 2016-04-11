'use strict';

angular.module('myApp.viewSignUp', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/viewSignUp', {
                    templateUrl: 'viewSignUp/viewSignUp.html',
                    controller: 'signUpController'
                });
            }])

        .controller('signUpController', ['$scope', 'GetClient', 'PostClientApp', 'GetSupermarket', function ($scope, GetClient, PostClientApp, GetSupermarket) {
                $scope.id1 = 69;
                $scope.nombre = "";
                $scope.correo = "";
                $scope.password = "";
                $scope.confirmPassword = "";
                $scope.check = false;
                $scope.registrado = false;
                //$scope.supermarket;
                $scope.client = {};
                $scope.postSupermarket = {};
                $scope.consult = function () {
                    /*var response = GetClient.get({superm: $scope.supermarket, id: $scope.id1});
                    response.$promise.then(function (data) {
                        $scope.client = data;
                        if (("" + $scope.client.id) === $scope.id1.toString()) {
                            $scope.check = true;
                            $scope.id1 = parseInt(response.id);
                            $scope.nombre = response.name;
                            $scope.correo = response.email;
                            //$scope.password = response.password;
                            //$scope.supermarket = $scope.client.supermarkets;
                            alert("SE PUEDE REGISTRAR EL CLIENTE");
                         } else {
                            alert("No se puede registrar usuario con ID: " + $scope.id1);
                         }
                    });
                    */
                    $scope.check = true;
                };

                $scope.postClientApp = function () {
                    var response = GetSupermarket.get({id: $scope.supermarket});
                    response.$promise.then(function (data) {
                        $scope.postSupermarket = data;
                        alert("postSupermarket: "+$scope.postSupermarket.idSupermarkets);
                        if ($scope.password !== "" && $scope.confirmPassword === $scope.password) {

                            
                            /*$scope.client = {id: $scope.id1, roles: {idRoles: 1, descripcion: "Cliente"}, name: $scope.nombre, email: $scope.correo, password: $scope.password, 
                                supermarketses: {idSupermarkets: $scope.postSupermarket.idSupermarkets, nameSupermarket: $scope.postSupermarket.nameSupermarket, clientsApps: $scope.postSupermarket.clientsApps, storeses: $scope.postSupermarket.storeses}, invoiceses: {}};
                                */
                               $scope.client = {idClients: $scope.id1, roles: {idRoles: 1, descripcion: "Cliente"}, nameClientApp: $scope.nombre, email: $scope.correo, password: $scope.password,
                                    supermarketses: {idSupermarkets: $scope.postSupermarket.idSupermarkets, nameSupermarket: $scope.postSupermarket.nameSupermarket}, invoiceses: [{idInvoices:110,dateInvoice:1460349587153}]};
                            //postData={id:$scope.id1, name:$scope.nombre, email:$scope.correo, password:$scope.password, invoices:{}, supermarkets:[$scope.supermarket]};
                            PostClientApp.save($scope.client, function () {
                                alert("El usuario con identificacion '" + $scope.client.idClients + "' ha sido registrado exitosamente en: "+$scope.postSupermarket.nameSupermarket);
                                $scope.registrado = true;
                            }
                            );
                        } else {
                            alert("Las contraseñas no coinciden. ");
                        }
                    });
                };
            }]);
        