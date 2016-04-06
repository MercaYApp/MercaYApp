/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.spademo.controllers;

import edu.eci.cosw.spademo.model.Product;
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
@RequestMapping("/products")

public class ProductController {
    @Autowired
    IStub stub;
    
    @RequestMapping(method = RequestMethod.GET)
    public List<Product> getProducts(){
        return stub.getProducts();
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public void postProduct(@RequestBody Product product){
        stub.postProduct(product);
      
    }
    
    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Product getProductById(@PathVariable int id){
        return stub.getProductById(id);
    }
    

}
