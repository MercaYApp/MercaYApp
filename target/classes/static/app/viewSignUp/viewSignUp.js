'use strict';

angular.module('myApp.viewSignUp', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/viewSignUp', {
                    templateUrl: 'viewSignUp/viewSignUp.html',
                    controller: 'signUpController'
                });
            }])

        .controller('signUpController', ['$scope', 'GetClient', 'PostClient', function ($scope, GetClient, PostClient) { 
                $scope.id1 = 16;
                $scope.nombre = "";
                $scope.correo = "";
                $scope.password = "";
                $scope.check = false;
                $scope.client = {};
                $scope.consult = function () {
                    var response = GetClient.get({id: 16});
                    response.$promise.then(function (data) {
                        $scope.client = data;
                        if (("" + $scope.client.id) === $scope.id1.toString()) {
                            $scope.check = true;
                            $scope.id1 = parseInt(response.id);
                            $scope.nombre = response.name;
                            $scope.correo = response.email;
                            $scope.password = response.password;
                            alert("SE REGISTRO EL CLIENTE");
                        } else {
                            alert("No se puede registrar usuario con ID: " + $scope.id1);
                        }
                    });
                };

                $scope.postClient = function () {
                    var postData = {};
                    
                    postData={id:$scope.id1, name:$scope.nombre, email:$scope.correo, password:$scope.password, invoices:[]};
                        PostClient.save(postData, function(){
                            alert("User saved");
                            }
                        );
                };
            }]);
        