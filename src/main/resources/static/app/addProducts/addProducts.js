'use strict';

angular.module('myApp.addProducts', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/addProducts', {
                    templateUrl: 'addProducts/addProducts.html',
                    controller: 'ViewAddProductosCtrl'
                });
            }])


        .controller('ViewAddProductosCtrl', ['$scope', 'GetProduct', 'PostProduct', function ($scope, GetProduct, PostProduct) {
                $scope.checkProductos=false;
                
                var product = {};
                $scope.postProductsAgregar = function () {
                     product = {idProductos: $scope.idProducto,zones:{} ,nameProduct:$scope.nombreAddProducts , buyPrice:$scope.buyPriceAddProducts ,percentage:$scope.porcentajeAddProduct ,weight:$scope.pesoAddProduct};
                     PostProduct.save(product, function () {
                            alert("Agrego producto: "+ product.idProductos);
                            $scope.registrado = true;
                        });
                    };
                    
                 
                $scope.postProductsModificar = function () {
                    var response = GetProduct.get({id: $scope.idProducto});
                     response.$promise.then(function (data) {
                      $scope.product = data; 
                      alert("Agrego producto: "+ $scope.product.nameProduct);
                     });
                };
                     /**$scope.checkProductos=true;
                    var response = GetProduct.get({id: $scope.idProducto});
                    response.$promise.then(function (data) {
                        $scope.product = data;
                        $scope.nombreAddProducts=$scope.product.nameProduct;
                        $scope.buyPriceAddProducts=$scope.product.buyPrice;
                        $scope.porcentajeAddProduct=$scope.product.percentage;
                        alert("Nombre " + $scope.product.name_product);
                        **/
                    
 
                 $scope.cancelarPostProductos=function(){
                     
                     $scope.checkProductos=false;
                     
                 };
            }]);