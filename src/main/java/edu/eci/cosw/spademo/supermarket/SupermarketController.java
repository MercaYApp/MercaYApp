/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.spademo.supermarket;

import edu.eci.cosw.spademo.client.Client;
import edu.eci.cosw.spademo.stub.IStub;
import edu.eci.cosw.spademo.tarea.TaskController;
import java.util.Set;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Felipe Brasil
 */
@RestController
@RequestMapping("/supermarkets")

public class SupermarketController {
    @Autowired
    IStub stub;
    
    @RequestMapping(method = RequestMethod.GET)
    public Set<Supermarket> getSupermarket(){
       return stub.getSupermarkets();
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public void postSupermarket(@RequestBody Supermarket supermarket){
        stub.postSupermarket(supermarket);
        LOG.info("Agrego supermarket; "+supermarket.getId());
    }
    
    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Supermarket getSupermarketById(@PathVariable int id){
        return stub.getSupermarketById(id);
    }
    
    @RequestMapping(value="/{id}/clients", method = RequestMethod.GET)
    public Set<Client> getSupermarketClientsById(@PathVariable int id){
        return stub.getSupermarketById(id).getClients();  
    }
    
    @RequestMapping(value="/{id}/clientsApp", method = RequestMethod.GET)
    public Set<Client> getSupermarketClientsAppById(@PathVariable int id){
        return stub.getSupermarketById(id).getClientsApp();  
    }
    
    
    private static final Logger LOG = Logger.getLogger(TaskController.class.getName());

}
