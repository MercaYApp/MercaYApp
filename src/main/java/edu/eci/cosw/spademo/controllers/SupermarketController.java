/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.spademo.controllers;

import edu.eci.cosw.spademo.model.Supermarket;
import edu.eci.cosw.spademo.model.ClientApp;
import edu.eci.cosw.spademo.persistence.ServicesMercaYAppException;
import edu.eci.cosw.spademo.stub.IStub;
import java.util.List;
import java.util.Set;
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
    public List<Supermarket> getSupermarket()throws ServicesMercaYAppException{
       return stub.getSupermarkets();
       
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public void postSupermarket(@RequestBody Supermarket supermarket)throws ServicesMercaYAppException{
        //stub.postSupermarket(supermarket);
        System.out.println("entro a postSupermarket");
    }
    
    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Supermarket getSupermarketById(@PathVariable int id)throws ServicesMercaYAppException{
        return stub.getSupermarketById(id);
        
    }
    
    @RequestMapping(value="/{id}/clients", method = RequestMethod.GET)
    public Set<ClientApp> getSupermarketClientsById(@PathVariable String id)throws ServicesMercaYAppException{
        return stub.getSupermarketByName(id).getClients();
        
        /*System.out.println("entro a /{id}/clients");
        return null;*/
    }
    
    @RequestMapping(value="/{id}/clientsApp", method = RequestMethod.GET)
    public Set<ClientApp> getSupermarketClientsAppById(@PathVariable String id)throws ServicesMercaYAppException{
        return stub.getSupermarketByName(id).getClients();
        /*System.out.println("/{id}/clientsApp");
        return null;*/
        
    }
    
    @RequestMapping(value="/{superm}/clients/{id}", method = RequestMethod.GET)
    public ClientApp getSupermarketByIdClientsById(@PathVariable String superm, @PathVariable int id)throws ServicesMercaYAppException{
        ClientApp c=null;
        if(stub.getSupermarketByName(superm)!=null){
            c = stub.getSupermarketByIdClientsById(superm, id);
        }
        
        return c;
       
    }
    
    
    @RequestMapping(value="/clientsAppPost", method = RequestMethod.POST)
    public void postSupermarketClientsApp(@RequestBody ClientApp client)throws ServicesMercaYAppException{
        System.out.println("entro a postSupermarketClientsApp");
        //stub.postClientApp(client.getSupermarkets().get(client.getSupermarkets().size()-1), client);
        
    }
    

}
