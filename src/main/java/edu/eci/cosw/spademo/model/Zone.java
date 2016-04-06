/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.spademo.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author MercaYApp
 */
@Entity
@Table(name = "ZONES")
public class Zone implements Serializable {
    private int id;
    private String storeId;
    private Set<Product> products = new HashSet<>(0);
    private Store store;
    
    public Zone(){
    }

    public Zone(int id, String storeId) {
        this.id = id;
        this.storeId = storeId;
    }
    
    public Zone(int id, String storeId, Set<Product> products, Store store ) {
        this.id = id;
        this.storeId = storeId;
        this.products = products;
        this.store = store;
    }
   
    /**
     * @return the id
     */
    @Id
    @Column(name = "id_zones")
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
     * @return the storeId
     */
    @Column(name = "Store_id")
    public String getStoreId() {
        return storeId;
    }

    /**
     * @param storeId the storeId to set
     */
    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    /**
     * @return the products
     */
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "productos", nullable = false)
    public Set<Product> getProducts() {
        return products;
    }

    /**
     * @param products the products to set
     */
    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    /**
     * @return the store
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Store_id", nullable = false, insertable=false, updatable=false)
    public Store getStore() {
        return store;
    }

    /**
     * @param store the store to set
     */
    public void setStore(Store store) {
        this.store = store;
    }
}
