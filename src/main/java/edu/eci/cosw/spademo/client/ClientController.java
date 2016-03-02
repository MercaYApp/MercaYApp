/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.spademo.client;

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
@RequestMapping("/clients")

public class ClientController {
    @Autowired
    IStub stub;
    
    @RequestMapping(method = RequestMethod.GET)
    public Set<Client> getClients(){
        return stub.getClients();
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public void postClient(@RequestBody Client client){
        if(!stub.getClients().contains(client)){
            stub.postClient(client);
        }
    }
    
    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Client getClientById(@PathVariable int id){
        return stub.getClientById(id);
    }
    
    private static final Logger LOG = Logger.getLogger(TaskController.class.getName());
}
