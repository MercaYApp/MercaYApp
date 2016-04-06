/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.spademo.controllers;

import edu.eci.cosw.spademo.model.Supermarket;
import edu.eci.cosw.spademo.model.ClientApp;
import edu.eci.cosw.spademo.stub.IStub;
import java.util.Map;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author MercaYApp
 */
@RestController
@RequestMapping("/supermarkets")

public class SupermarketController {
    @Autowired
    IStub stub;
    
    @RequestMapping(method = RequestMethod.GET)
    public Map<String, Supermarket> getSupermarket(){
       //return stub.getSupermarkets();
        System.out.println("entro a getSupermarket");
       return null;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public void postSupermarket(@RequestBody Supermarket supermarket){
        //stub.postSupermarket(supermarket);
        System.out.println("entro a postSupermarket");
    }
    
    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Supermarket getSupermarketById(@PathVariable String id){
        //return stub.getSupermarketById(id);
        System.out.println("/{id}");
        return null;
    }
    
    @RequestMapping(value="/{id}/clients", method = RequestMethod.GET)
    public Map<Integer, ClientApp> getSupermarketClientsById(@PathVariable String id){
        //return stub.getSupermarketById(id).getClients();  
        System.out.println("entro a /{id}/clients");
        return null;
    }
    
    @RequestMapping(value="/{id}/clientsApp", method = RequestMethod.GET)
    public Map<Integer, ClientApp> getSupermarketClientsAppById(@PathVariable String id){
        //return stub.getSupermarketById(id).getClientsApp();
        System.out.println("/{id}/clientsApp");
        return null;
        
    }
    
    @RequestMapping(value="/{superm}/clients/{id}", method = RequestMethod.GET)
    public ClientApp getSupermarketByIdClientsById(@PathVariable String superm, @PathVariable int id){
        /*ClientApp c=null;
        if(stub.getSupermarketById(superm)!=null){
            c = stub.getSupermarketByIdClientsById(superm, id);
        }
        return c;*/
        System.out.println("entro a /{superm}/clients/{id}");
        return null;
    }
    
    
    @RequestMapping(value="/clientsAppPost", method = RequestMethod.POST)
    public void postSupermarketClientsApp(@RequestBody ClientApp client){
        System.out.println("Entro a a /clientsAppPost");
        //stub.postClientApp(client.getSupermarkets().get(client.getSupermarkets().size()-1), client);
        
    }
    

}
