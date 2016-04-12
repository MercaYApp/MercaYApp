'use strict';

angular.module('myApp.viewLogin', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/viewLogin', {
                    templateUrl: 'viewLogin/viewLogin.html',
                    controller: 'ViewLoginCtrl'
                });
            }])

        .controller('ViewLoginCtrl', ['$rootScope', '$scope', '$http', '$location', 'PostEmail', function ($rootScope, $scope, $http, $location, PostEmail) {
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
                $rootScope.credentials = {};
                $scope.login = function () {
                    authenticate($rootScope.credentials, function () {
                        if ($rootScope.authenticated) {
                            alert("Autentico: " + $rootScope.credentials.password);
                            $location.path("/");
                            $scope.error = false;
                        } else {
                            $rootScope.credentials.password="";
                            alert("Usuario o contrase??a incorrectos!");
                            
                            //$location.path("/login");
                            $scope.error = true;
                        }
                    });
                };

                $scope.olvidoContrasena = false;
                $scope.correoOlvidado = "";
                //Ocultar datos de login
                $scope.olvideContrasena = function () {
                    $scope.olvidoContrasena = true;
                }
                //Enviar correo para recuperacion de contrase??a, y mostrar datos para el login
                $scope.correoContrasena = function () {
                    alert($scope.correoOlvidado);
                    var postData = {};
                        //Crear objeto JSON para envio de correo
                        postData={mailReceptor:$scope.correoOlvidado};
                            PostEmail.save(postData.mailReceptor, function(){
                                //alert("El usuario con correo '" + postData.mailReceptor + " olvid?? contrase??a!");
                                $scope.registrado = true;
                                }
                            );
                    $scope.olvidoContrasena = false;
                 };
            }]);