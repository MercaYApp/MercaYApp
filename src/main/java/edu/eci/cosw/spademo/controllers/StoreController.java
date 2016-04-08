/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.spademo.controllers;

import edu.eci.cosw.spademo.model.Store;
import edu.eci.cosw.spademo.model.Product;
import edu.eci.cosw.spademo.persistence.ServicesMercaYAppException;
import edu.eci.cosw.spademo.stub.IStub;
import java.util.List;
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
@RequestMapping("/stores")

public class StoreController {
    @Autowired
    IStub stub;
    
    @RequestMapping(method = RequestMethod.GET)
    public List<Store> getStores()throws ServicesMercaYAppException{
        return stub.getStores();
        
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public void postStore(@RequestBody Store store)throws ServicesMercaYAppException{
        stub.postStore(store);
        
        
    }
    
    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Store getStoreById(@PathVariable int id)throws ServicesMercaYAppException{
        return stub.getStoreById(id);
    }
    
   
}