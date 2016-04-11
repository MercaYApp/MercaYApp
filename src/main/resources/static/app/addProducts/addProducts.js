'use strict';

angular.module('myApp.addProducts', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/addProducts', {
                    templateUrl: 'addProducts/addProducts.html',
                    controller: 'ViewAddProductosCtrl'
                });
            }])


        .controller('ViewAddProductosCtrl', ['$scope', 'GetProduct', function ($scope, GetProduct) {
                $scope.checkProductos=false;
                $scope.product = {};
                $scope.consultarProductos = function () {

                    var response = GetProduct.get({id: $scope.idProducto});
                    response.$promise.then(function (data) {
                        $scope.product = data;
                        $scope.nombreAddProducts=$scope.product.nameProduct;
                        $scope.buyPriceAddProducts=$scope.product.buyPrice;
                        $scope.porcentajeAddProduct=$scope.product.percentage;
                        $scope.checkProductos=true;
                        
                        alert("Nombre " + $scope.product.name_product);
                    });

                 $scope.cancelarPostProductos=function(){
                     
                     $scope.checkProductos=false;
                     
                 };





                };
            }]);