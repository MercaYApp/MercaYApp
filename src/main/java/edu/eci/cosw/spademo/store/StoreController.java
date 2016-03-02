/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.spademo.store;

import edu.eci.cosw.spademo.product.Product;
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
@RequestMapping("/stores")

public class StoreController {
    @Autowired
    IStub stub;
    
    @RequestMapping(method = RequestMethod.GET)
    public Set<Store> getStores(){
        return stub.getStores();
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public void postStore(@RequestBody Store store){
        stub.postStore(store);
        LOG.info("Add store; "+store.getId());
    }
    
    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Store getStoreById(@PathVariable int id){
        return stub.getStoreById(id);
    }
    
    private static final Logger LOG = Logger.getLogger(TaskController.class.getName());
}
