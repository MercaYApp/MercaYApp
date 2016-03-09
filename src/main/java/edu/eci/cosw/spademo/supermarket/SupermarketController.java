/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.spademo.supermarket;

import edu.eci.cosw.spademo.client.Client;
import edu.eci.cosw.spademo.stub.IStub;
import edu.eci.cosw.spademo.tarea.TaskController;
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
 * @author Felipe Gómez
 */
@RestController
@RequestMapping("/supermarkets")

public class SupermarketController {
    @Autowired
    IStub stub;
    
    @RequestMapping(method = RequestMethod.GET)
    public Map<Integer, Supermarket> getSupermarket(){
       return stub.getSupermarkets();
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public void postSupermarket(@RequestBody Supermarket supermarket){
        stub.postSupermarket(supermarket);
    }
    
    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Supermarket getSupermarketById(@PathVariable int id){
        return stub.getSupermarketById(id);
    }
    
    @RequestMapping(value="/{id}/clients", method = RequestMethod.GET)
    public Map<Integer, Client> getSupermarketClientsById(@PathVariable int id){
        return stub.getSupermarketById(id).getClients();  
    }
    
    @RequestMapping(value="/{id}/clientsApp", method = RequestMethod.GET)
    public Map<Integer, Client> getSupermarketClientsAppById(@PathVariable int id){
        return stub.getSupermarketById(id).getClientsApp();
        
    }
    
    @RequestMapping(value="/{superm}/clients/{id}", method = RequestMethod.GET)
    public Client getSupermarketByIdClientsById(@PathVariable int superm, @PathVariable int id){
        return stub.getSupermarketByIdClientsById(superm, id);
    }
    
    
    @RequestMapping(value="/clientsAppPost", method = RequestMethod.POST)
    public void postSupermarketClientsApp(@RequestBody Client client){
        stub.postClientApp(client.getSupermarkets().get(client.getSupermarkets().size()-1), client);
    }
    
    private static final Logger LOG = Logger.getLogger(TaskController.class.getName());

}
