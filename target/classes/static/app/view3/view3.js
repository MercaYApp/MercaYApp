'use strict';

angular.module('myApp.view3', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/view3', {
                    templateUrl: 'view3/view3.html',
                    controller: 'PostCtrl'
                });
            }])

        .controller('PostCtrl', ['$scope', 'Post', function ($scope, Post) {
                $scope.nombre="";
                $scope.prioridad=1;
                                
                $scope.newPost=function(){
                    var postData={"nombre": $scope.nombre, "prioridad": $scope.prioridad};
                        Post.save(postData, function(){
                            console.info("Saved: "+postData.nombre);
                        }
                    );
                }
            }]);