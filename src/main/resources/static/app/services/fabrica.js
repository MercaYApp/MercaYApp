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
                    {get: {method: 'GET', isArray: false}}
            );
            return invoices;
            
        })

        //---------------Post email---------------
        .factory('PostEmail', function ($resource) {
            return $resource('/email');
        })
        
        //---------------Post supermarket Client---------------
        .factory('PostSupermarketClient', function ($resource) {
            return $resource('/postSupermarketClient');
        });