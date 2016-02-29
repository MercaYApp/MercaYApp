'use strict';

angular.module('myApp.viewSignUp', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/viewSignUp', {
                    templateUrl: 'viewSignUp/viewSignUp.html',
                    controller: 'signUpController'
                });
            }])

        .controller('signUpController', ['$scope', 'GetClient', function ($scope, GetClient) {
                $scope.id1=16;
                $scope.check=false;
                //$scope.client={"id":16,"name":"Felipe","email":"Felipe@yo.com","password":"123","invoices":[{"id":110,"date":11122,"total":23000}]};
                $scope.consult=function(){
                    $scope.client = GetClient.get({id: $scope.id1});
                    console.log("Objeto JSON angular controller: "+$scope.client.id);
                    //if((""+$scope.client.id)===$scope.id1.toString()){
                    if((""+GetClient.get({id:$scope.id1}).id)===$scope.id1.toString()){
                        $scope.check=true;
                        alert("SE REGISTRO EL CLIENTE");
                    }else{
                        alert("No se puede registrar usuario con ID: "+$scope.id1);
                    }
                };
                
                $scope.postClient=function(){
                    var postData={"id": $scope.id1};
                        Post.save(postData, function(){
                            console.info("Saved: "+postData.nombre);
                        }
                    );
                }
            }]);
        