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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author MercaYApp
 */
@Entity
@Table(name = "PRODUCTS")
public class Product implements Serializable {
    private int id;
    private String name;
    private int buyPrice;
    private int percetage;
    private int weight;
    private Set<Invoice> invoices = new HashSet<>(0);
    private Zone zone;

    /**
     * 
     * @param id
     * @param name
     * @param buyPrice pesos Colombianos
     * @param percetage values in 0-100
     * @param weight in grams
     * @param zone
     */
    public Product(int id, String name, int buyPrice, int percetage, int weight, Zone zone) {
        this.id = id;
        this.name = name;
        this.buyPrice = buyPrice;
        this.percetage = percetage;
        this.weight = weight;
        this.zone = zone;
    }
    
    /**
     * 
     * @param id
     * @param name
     * @param buyPrice pesos Colombianos
     * @param percetage values in 0-100
     * @param weight in grams
     * @param invoices
     * @param zone
     */
    public Product(int id, String name, int buyPrice, int percetage, int weight, Set<Invoice> invoices, Zone zone) {
        this.id = id;
        this.name = name;
        this.buyPrice = buyPrice;
        this.percetage = percetage;
        this.weight = weight;
        this.invoices = invoices;
        this.zone = zone;
    }
    

    public Product(){
    
    }

    /**
     * @return the id
     */
    @Id
    @Column(name="id_products")
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
     * @return the name
     */
    @Column(name = "name")
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */ 
    
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the weight
     */
    @Column(name = "weight")
    public int getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * @return the buyPrice
     */
    @Column(name = "buyPrice")
    public int getBuyPrice() {
        return buyPrice;
    }

    /**
     * @param buyPrice the buyPrice to set
     */
    public void setBuyPrice(int buyPrice) {
        this.buyPrice = buyPrice;
    }

    /**
     * @return the percetage
     */
    @Column(name = "Percentage")
    public int getPercetage() {
        return percetage;
    }

    /**
     * @param percetage the percetage to set
     */
    public void setPercetage(int percetage) {
        this.percetage = percetage;
    }

    /**
     * @return the products
     */
    
    @ManyToMany(mappedBy = "products")
    public Set<Invoice> getInvoices() {
        return invoices;
    }

    /**
     * @param invoices the products to set
     */
    public void setInvoices(Set<Invoice> invoices) {
        this.invoices = invoices;
    }

    /**
     * @return the zone
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ZONES_id", nullable = false, insertable=false, updatable=false)
    public Zone getZone() {
        return zone;
    }

    /**
     * @param zone the zone to set
     */
    public void setZone(Zone zone) {
        this.zone = zone;
    }
}
