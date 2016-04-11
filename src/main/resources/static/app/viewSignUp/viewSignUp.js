'use strict';

angular.module('myApp.viewSignUp', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/viewSignUp', {
                    templateUrl: 'viewSignUp/viewSignUp.html',
                    controller: 'signUpController'
                });
            }])

        .controller('signUpController', ['$scope', 'GetClientApp', 'PostClientApp', 'GetSupermarket',function ($scope, GetClientApp, PostClientApp, GetSupermarket) { 
                $scope.id1 = 69;
                $scope.nombre = "";
                $scope.correo = "";
                $scope.password = "";
                $scope.confirmPassword = "";
                $scope.check = false;
                $scope.registrado = false;
                //$scope.supermarket;
                $scope.clientPost = {};
                $scope.supermarketPost={};
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

                $scope.postClientApp = function () {
                    if($scope.password!=="" && $scope.confirmPassword === $scope.password){
                        var response = GetSupermarket.get({id: $scope.supermarket});
                        response.$promise.then(function (data) {
                            $scope.supermarketPost = data;
                            $scope.clientPost={idClients:$scope.id1, rol:{}, nameClientApp:$scope.nombre, email:$scope.correo, password:$scope.password, supermarketses: [$scope.supermarketPost], inveoiceses: {}};
                                PostClientApp.save($scope.clientPost, function(){
                                    alert("El usuario con identificacion '"+ $scope.clientPost.idClientApp + "' ha sido registrado exitosamente en:"+$scope.supermarketPost.nameSupermarket);
                                    $scope.registrado = true;
                                    }
                                );
                            });
                    }else{
                        alert("Las contraseñas no coinciden. ");
                    }
                };
            }]);
        