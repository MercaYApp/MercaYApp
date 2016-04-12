'use strict';

angular.module('myApp.addProducts', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/addProducts', {
                    templateUrl: 'addProducts/addProducts.html',
                    controller: 'ViewAddProductosCtrl'
                });
            }])


        //.controller('ViewAddProductosCtrl', ['$scope', 'GetProduct', 'PostProduct', 'PostSupermarketClient', function ($scope, GetProduct, PostProduct, PostSupermarketClient) {
          .controller('ViewAddProductosCtrl', ['$scope', 'GetProduct', 'PostProduct', 'PutProduct', function ($scope, GetProduct, PostProduct, PutProduct) {    
            $scope.checkProductos = false;

                var product = {};
                $scope.postProductsAgregar = function () {
                    product = {idProductos: $scope.idProducto, zones: {}, nameProduct: $scope.nombreAddProducts, buyPrice: $scope.buyPriceAddProducts, percentage: $scope.porcentajeAddProduct, weight: $scope.pesoAddProduct};
                    PostProduct.save(product, function () {
                        alert("Agrego producto: " + product.idProductos);
                        $scope.registrado = true;
                    });
                };


                $scope.postProductsModificar = function () {
                    alert("VA LA entroooo");
                    var response = GetProduct.get({id: $scope.idProducto});
                    
                    response.$promise.then(function (data) {
                        $scope.product = data;
                        var producto = {idProductos: $scope.product.idProductos, zones: {}, nameProduct: $scope.product.nameProduct, buyPrice: $scope.buyPriceAddProducts, percentage: $scope.porcentajeAddProduct, weight: $scope.product.weight};
                        
                        PutProduct.save(producto, function () {
                            alert("Agrego producto: " + product.idProductos);

                        });

                    });
                };
                  $scope.cancelarPostProductos = function () {
                        alert("Cancelar: ");  
                };

            }]);