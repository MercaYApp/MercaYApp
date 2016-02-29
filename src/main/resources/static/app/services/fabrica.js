'use strict';
angular.module('service.modulo1', ['ngRoute', 'ngResource'])

        /*.factory('servicio1', function () {
         var data = {
         listado: []
         };
         return {
         getListado: function () {
         return data.listado;
         },
         addTodo: function (todo) {
         data.listado.push(todo);
         }};
         })*/

         //---------------Post tareas---------------
        .factory('Post', function ($resource) {
            return $resource('/tareas');
        })
    
        //---------------Get tareas---------------
        .factory('Get', function ($resource) {
            return $resource('/tareas',{},
                {get: { method: 'GET', isArray: true}
            });
        })
        
        //---------------Get clients---------------
        .factory('GetClient', function ($resource) {
            return $resource('/clients/:id', {id:"@id"},
                {get: { method: 'GET', isArray : false}
            });
        })
        
        //---------------Post clients---------------
        .factory('PostClient', function ($resource) {
            return $resource('/clients');
        });