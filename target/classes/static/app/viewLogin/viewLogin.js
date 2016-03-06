'use strict';

angular.module('myApp.viewLogin', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/viewLogin', {
                    templateUrl: 'viewLogin/viewLogin.html',
                    controller: 'ViewLoginCtrl'
                });
        }])

        .controller('ViewLoginCtrl', ['$rootScope', '$scope', '$http', '$location', function ($rootScope, $scope, $http, $location) {
                var authenticate = function (credentials, callback) {

                    var headers = credentials ? {authorization: "Basic "
                                + btoa(credentials.username + ":" + credentials.password)
                    } : {};
                    $http.get('user', {headers: headers}).success(function (data) {
                        if (data.name) {
                            $rootScope.authenticated = true;                            
                        } else {
                            $rootScope.authenticated = false;
                        }
                        callback && callback();
                    }).error(function () {                                               
                        $rootScope.authenticated = false;
                        callback && callback();
                    });

                };

                authenticate();
                $scope.credentials = {};
                $scope.login = function () {                    
                    authenticate($scope.credentials, function () {
                        alert("internooooto autenticar: "+ $scope.credentials.password);
                        if ($rootScope.authenticated) {
                            $location.path("/");
                            $scope.error = false;
                        } else {
                            $location.path("/login");
                            $scope.error = true;
                        }
                    });
                };


            }]);