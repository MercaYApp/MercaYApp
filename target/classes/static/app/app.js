'use strict';

// Declare app level module which depends on views, and components
angular.module('myApp', [
    'ngRoute',
    //'myApp.viewLogin',
    'myApp.viewSignUp',
    'myApp.view1',
    'myApp.view3',
    'service.modulo1',
    'myApp.version'
])

        .config(['$routeProvider', '$httpProvider', function ($routeProvider, $httpProvider) {
                $routeProvider.otherwise({redirectTo: '/view1'});
                $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
            }])

        /*.controller('ViewPrincipal', ['$rootScope', '$scope', '$http', '$location', function ($rootScope, $scope, $http, $location) {
                $scope.logout = function () {
                    $http.post('/logout', {}).success(function () {
                        $rootScope.authenticated = false;
                        $location.path("/");
                    }).error(function () {
                        $rootScope.authenticated = false;
                    });
                };
            }]);
            */
