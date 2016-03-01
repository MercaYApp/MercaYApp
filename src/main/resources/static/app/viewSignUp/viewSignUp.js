'use strict';

angular.module('myApp.viewSignUp', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/viewSignUp', {
                    templateUrl: 'viewSignUp/viewSignUp.html',
                    controller: 'signUpController'
                });
            }])

        .controller('signUpController', ['$scope', 'GetClient', function ($scope, GetClient) {
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
                            alert("SE REGISTRO EL CLIENTE");
                        } else {
                            alert("No se puede registrar usuario con ID: " + $scope.id1);
                        }
                    });
                };

                $scope.postClient = function () {
                    
                    var postData = {};
                    Post.save(postData, function () {
                        postData={id:id1, name:nombre, email:correo, password:password, invoices:[]};
                        console.info("Saved: " + postData.id);
                    }
                    );
                };
            }]);
        