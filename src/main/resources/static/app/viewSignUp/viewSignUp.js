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
                $scope.supermarket;
                $scope.client = {};
                
                $scope.consult = function () {
                    var response = GetClient.get({superm: $scope.supermarket, id: $scope.id1});
                    response.$promise.then(function (data) {
                        $scope.client = data;
                        if (("" + $scope.client.id) === $scope.id1.toString() ) {
                            
                            $scope.check = true;
                            $scope.id1 = parseInt(response.id);
                            $scope.nombre = response.name;
                            $scope.correo = response.email;
                            $scope.password = response.password;
                            alert("SE PUEDE REGISTRAR EL CLIENTE");
                        } else {
                            alert("No se puede registrar usuario con ID: " + $scope.id1);
                        }
                    });
                };

                $scope.postClientApp = function () {
                    var postData = {};
                    postData={id:$scope.id1, name:$scope.nombre, email:$scope.correo, password:$scope.password, invoices:{}, supermarkets:[11]};
                        //PostClientApp.save(postData, {superm : $scope.supermarket}, function(){
                        PostClientApp.save(postData, function(){
                            alert("User saved: "+ postData.id);
                            $scope.registrado = true;
                            }
                        );
                };
            }]);
        