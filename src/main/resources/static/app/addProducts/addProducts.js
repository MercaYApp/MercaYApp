'use strict';

angular.module('myApp.addProducts', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/addProducts', {
                    templateUrl: 'addProducts/addProducts.html',
                    controller: 'ViewAddProductosCtrl'
                });
            }])


        //.controller('ViewAddProductosCtrl', ['$scope', 'GetProduct', 'PostProduct', 'PostSupermarketClient', function ($scope, GetProduct, PostProduct, PostSupermarketClient) {
        .controller('ViewAddProductosCtrl', ['$scope', 'GetProduct', 'PostProduct', 'PutProduct', 'GetZone', function ($scope, GetProduct, PostProduct, PutProduct, GetZone) {
                $scope.checkProductos = false;
                $scope.zone={};
                $scope.addProducts="Modificar";
                $scope.addZoneProduct = function(){
                    var response1 = GetZone.get({id: $scope.idZonaAddProducts, store: $scope.idStoreAddProducts, supermarket: $scope.idSupermarketAddProducts});
                    response1.$promise.then(function (data1) {
                        $scope.zone = data1;
                        var zoneId = {idZones: $scope.zone.id.idZones, storesIdStores: $scope.zone.id.storesIdStores, storesSuperMarketId: $scope.zone.id.storesSuperMarketId};
                        var zone = {id: zoneId, nameZone: $scope.zone.nameZone};
                        //alert("ESTA BIEN LA ZONA: "+ $scope.zone.nameZone);
                        
                    });
                };
                
                $scope.cambiaEstadoAgregar= function(){
                    $scope.addProducts = 'Agregar';  
                };
                
                $scope.cambiaEstadoModificar= function(){
                    $scope.addProducts = 'Modificar';
                };

                var product = {};
                $scope.postProductsAgregar = function () {
                    $scope.addZoneProduct();
                    product = {idProductos: $scope.idProducto, nameProduct: $scope.nombreAddProducts, buyPrice: $scope.buyPriceAddProducts, 
                                percentage: $scope.porcentajeAddProduct, weight: $scope.pesoAddProduct, invoiceses: {}, zoneses: [$scope.zone]};
                    PostProduct.save(product, function () {
                        alert("Agrego producto correctamente: " + product.idProductos);

                        $scope.registrado = true;
                    });
                };

                $scope.postProductsModificar = function () {

                    var response = GetProduct.get({id: $scope.idProducto});

                    response.$promise.then(function (data) {
                        $scope.product = data;
                        alert("AQUIIIIIIIIIII");
                        var producto = {idProductos: $scope.product.idProductos, nameProduct: $scope.product.nameProduct, buyPrice: $scope.buyPriceAddProducts, percentage: $scope.porcentajeAddProduct, weight: $scope.product.weight};
                        PutProduct.save(producto, function () {
                            alert("Agrego producto: " + $scope.product.idProductos);

                        });

                    });
                };
                $scope.cancelarPostProductos = function () {
                    alert("Cancelar: ");
                };

            }]);