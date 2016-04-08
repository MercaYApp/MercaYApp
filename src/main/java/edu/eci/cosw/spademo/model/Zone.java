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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author MercaYApp
 */
@Entity
@Table(name = "ZONES")
public class Zone implements Serializable {
    private int id;
    private Set<Product> products = new HashSet<>(0);
    private Store store;
    
    public Zone(){
    }

    public Zone(int id, Store store) {
        this.id = id;
        this.store = store;
    }
    
    public Zone(int id, Store store, Set<Product> products) {
        this.id = id;
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
     * @return the products
     */
    @OneToMany(cascade = CascadeType.ALL)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "productos", nullable = true)
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
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "STORE_id_stores", nullable = false)
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
