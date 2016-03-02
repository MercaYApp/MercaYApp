'use strict';
angular.module('service.modulo1', ['ngRoute', 'ngResource'])

        //---------------Post tareas---------------
        .factory('Post', function ($resource) {
            return $resource('/tareas');
        })

        //---------------Get tareas---------------
        .factory('Get', function ($resource) {
            return $resource('/tareas', {},
                    {get: {method: 'GET', isArray: true}
                    });
        })

        //---------------Get clients---------------
        .factory('GetClient', function ($resource) {
            var cliente = $resource('/clients/:id', {id: "@id"},
                    {get: {method: 'GET'}}
            );
            return cliente;
        })
        
        //---------------Get clients---------------
        .factory('GetClients', function ($resource) {
            var clientes = $resource('/supermarkets/:id/clientsApp', {id: "@id"},
                    {get: {method: 'GET'}}
            );
            return clientes;
        })

        //---------------Post clients---------------
        .factory('PostClient', function ($resource) {
            return $resource('/clients');
        });