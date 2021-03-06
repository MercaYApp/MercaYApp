'use strict';
angular.module('service.modulo1', ['ngRoute', 'ngResource'])

        //---------------Get clients---------------
        .factory('GetClient', function ($resource) {
            var cliente = $resource('/supermarkets/:superm/clients/:id', {super:"@superm", id: "@id"},
                    {get: {method: 'GET'}}
            );
            return cliente;
            
        })
        
        //---------------Get clients App---------------
        .factory('GetClientApp', function ($resource) {
            var cliente = $resource('/clientsApp/:id', {id: "@id"},
                    {get: {method: 'GET'}}
            );
            return cliente;
            
        })
        
        //---------------Post clients---------------
        .factory('PostClientApp', function ($resource) {
            return $resource('/supermarkets/clientsAppPost');
        })
        
        //---------------Delete clients App---------------
        .factory('DeleteClientApp', function ($resource) {
            var cliente = $resource('/clientsApp/clientsAppDelete/:id', {id: "@id"},
                 {get: {method: 'DELETE'}}
            );
            return cliente;
        })
        
        
        
        //---------------Get invoices of clients---------------
        .factory('GetClientInvoices', function ($resource) {
            var invoices = $resource('/clientsApp/:id/invoices', {id: "@id"},
                    {get: {method: 'GET', isArray: true}}
            );
            return invoices;
            
        })
        
        //---------------Get supermarkets---------------
        .factory('GetSupermarkets', function ($resource) {
            var supermarkets = $resource('/supermarkets', {}, 
                    {get: {method: 'GET', isArray: true}}
            );
            return supermarkets;
            
        })
        

        //---------------Post email---------------
        .factory('PostEmail', function ($resource) {
            return $resource('/email');
        })
        
        //---------------Post supermarket Client---------------
        .factory('PostSupermarketClient', function ($resource) {
            return $resource('/postSupermarketClients');
        })
        
        .factory('PostSupermarketClientes', function ($resource) {
            return $resource('/clientsApp/actualizaClientes');
        })
        
        
        //---------------Get supermarket---------------
        .factory('GetSupermarket', function ($resource) {
            var supermarket = $resource('/supermarkets/:id', {id: "@id"},
                    {get: {method: 'GET'}}
            );
            return supermarket;
        })

        .factory('GetProduct', function ($resource){
            var product = $resource('/products/:id', {id: "@id"},
                {get: {method: 'GET', isArray: false}}
            );
            return product;
        })
        
        //---------------Get rol---------------
        .factory('GetRol', function ($resource){
            var product = $resource('/roles/:id', {id: "@id"},
                {get: {method: 'GET', isArray: false}}
            );
            return product;
        })
        
            //---------------Get invoices of clients---------------
        .factory('PostProduct', function ($resource) {
            return $resource('/products');
        })
        //-------------------Get productos Invoices--------------------
        .factory('GetProductInvoices', function ($resource){
            var product = $resource('/invoices/:id/products', {id: "@id"},
                {get: {method: 'GET', isArray: true}}
            );
            return product;
        })    
  
       
            //---------------Get invoices of clients---------------
        .factory('PutProduct', function ($resource) {
            return $resource('/products/actualiza');
        })
        
        .factory('PutClient', function ($resource) {
            return $resource('/clientsApp/actualizaClient');
        })

        //---------------Get zone---------------
        .factory('GetZone', function ($resource) {
            var zone = $resource('/zones/:id/:store/:supermarket', {id: "@id", store: "@store", supermarket: "@supermarket"},
                    {get: {method: 'GET'}}
            );
            return zone;
        })
        
        
        //------------------GET CLIENTS API EXTERNO --------------
        /*.factory('GetClientsExternos', function ($resource) {
            var clienteE = $resource('/clientsAPI', {}, 
                    {get: {method: 'GET'} }
            );
            return clienteE;
        });*/