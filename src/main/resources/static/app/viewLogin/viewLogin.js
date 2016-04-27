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
                            $location.path("/");
                            $scope.error = false;
                        } else {
                            $rootScope.credentials.password = "";
                            alert("Usuario o contrasena incorrectos!");

                            //$location.path("/login");
                            $scope.error = true;
                        }
                    });
                };

                $scope.olvidoContrasena = false;
                $scope.idCorreoOlvidado = "";
                //Ocultar datos de login
                $scope.olvideContrasena = function () {
                    $scope.olvidoContrasena = true;
                }
                //Enviar correo para recuperacion de contrase??a, y mostrar datos para el login
                $scope.correoContrasena = function () {
                    var postData = {};
                    //Crear objeto JSON para envio de correo
                    postData = {mailReceptor: $scope.idCorreoOlvidado};
                    alert("Si el cliente con Id "+postData.mailReceptor+" está registrado se enviara un correo.");
                    $scope.olvidoContrasena = true;
                    if (postData !== {}) {
                        PostEmail.save(postData.mailReceptor, function () {
                            //alert("El usuario con correo '" + postData.mailReceptor + " olvid?? contrase??a!");
                            $scope.registrado = true;
                        }
                        );
                    }
                    $scope.olvidoContrasena = false;
                };
            }]);