'use strict';

angular.module('myApp.viewSignUp', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/viewSignUp', {
                    templateUrl: 'viewSignUp/viewSignUp.html',
                    controller: 'signUpController'
                });
            }])

        .controller('signUpController', ['$scope', 'GetClient', 'PostClientApp', function ($scope, GetClient, PostClientApp) { 
                $scope.id1 = 69;
                $scope.nombre = "";
                $scope.correo = "";
                $scope.password = "";
                $scope.confirmPassword = "";
                $scope.check = false;
                $scope.registrado = false;
                //$scope.supermarket;
                $scope.client = {};
                
                $scope.consult = function () {
                    var response = GetClient.get({superm: $scope.supermarket, id: $scope.id1});
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
                };

                $scope.postClientApp = function () {
                    if($scope.password!=="" && $scope.confirmPassword === $scope.password){
                        
                        var postData = {};

                        postData={id:$scope.id1, name:$scope.nombre, email:$scope.correo, password:$scope.password, invoices:{}, supermarkets:[$scope.supermarket]};
                            PostClientApp.save(postData, function(){
                                alert("El usuario con identificacion '"+ postData.id + "' ha sido registrado exitosamente!");
                                $scope.registrado = true;
                                }
                            );
                    }else{
                        alert("Las contraseñas no coinciden. ");
                    }
                };
            }]);
        