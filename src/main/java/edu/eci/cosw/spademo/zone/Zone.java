/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.spademo.zone;

import edu.eci.cosw.spademo.invoice.Invoice;
import edu.eci.cosw.spademo.product.Product;
import java.util.HashSet;

/**
 *
 * @author Felipe Brasil
 */
public class Zone {
    private int id;
    private HashSet<Product> products;
    
    public Zone(){
    }

    public Zone(int id, HashSet<Product> products) {
        this.id = id;
        this.products = products;
    }
   
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the products
     */
    public HashSet<Product> getProducts() {
        return products;
    }

    /**
     * @param products the products to set
     */
    public void setProducts(HashSet<Product> products) {
        this.products = products;
    }
    
}
