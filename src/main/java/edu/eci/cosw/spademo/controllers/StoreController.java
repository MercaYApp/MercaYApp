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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Store>> getStores()throws ServicesMercaYAppException{
        List<Store> c=stub.getStores();
        return new ResponseEntity<>(c, HttpStatus.OK);
        
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> postStore(@RequestBody Store store)throws ServicesMercaYAppException{
        stub.postStore(store);
        return new ResponseEntity<>(HttpStatus.CREATED);
        
        
    }
    
    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ResponseEntity<Store> getStoreById(@PathVariable int id)throws ServicesMercaYAppException{
        Store c=stub.getStoreById(id);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }
    
   
}