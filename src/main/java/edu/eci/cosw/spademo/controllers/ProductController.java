/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.spademo.controllers;

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
@RequestMapping("/products")

public class ProductController {
    @Autowired
    IStub stub;
    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Product>> getProducts()throws ServicesMercaYAppException{
        List<Product> c=stub.getProducts();
        return new ResponseEntity<>(c, HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> postProduct(@RequestBody Product product)throws ServicesMercaYAppException{
        stub.postProduct(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
      
    }
    
    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ResponseEntity<Product> getProductById(@PathVariable int id)throws ServicesMercaYAppException{
        Product c=stub.getProductById(id);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }
    

}
