/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.spademo.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


/**
 *
 * @author MercaYApp
 */
@Entity
@Table(name = "INVOICES")
public class Invoice implements Serializable {
    private int id;
    private Date date;
    private Store store;
    private ClientApp client;
    private Set<Product> products = new HashSet<>(0);

    public Invoice(){
    }
    
    public Invoice(int id, Date date, Store store, ClientApp client) {
        this.date = date;
        this.store=store; 
        this.client=client;
        this.id=id;
    }
    
    public Invoice(int id, Date date, Store store, ClientApp client, Set<Product> products) {
        this.date = date;
        this.store=store; 
        this.client=client;
        this.id=id;
        this.products=products;
    }
    
    /**
     * @return the id
     */
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name="id_invoices")
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
     * @return the date
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="date_invoice")
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the store
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @Fetch(FetchMode.JOIN)
    @JsonIgnore
    //@JoinColumn(name = "Store_id", nullable = false, insertable=false, updatable=false)
    @JoinColumn(name = "Store_id", nullable = false)
    public Store getStore() {
        return store;
    }

    /**
     * @param store the store to set
     */
    public void setStore(Store store) {
        this.store = store;
    }

    /**
     * @return the client
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @Fetch(FetchMode.JOIN)
    @JsonIgnore
    @JoinColumn(name = "CLIENTS_APP_id", nullable = true)
    public ClientApp getClient() {
        return client;
    }

    /**
     * @param client the client to set
     */
    public void setClient(ClientApp client) {
        this.client = client;
    }

    /**
     * @return the products
     */
    @ManyToMany
    @Fetch(FetchMode.JOIN)
    @JsonIgnore
    @JoinTable(name="LINE_INVOICE",
            joinColumns =   @JoinColumn(name = "INVOICES_id", referencedColumnName = "id_invoices"),
            inverseJoinColumns = @JoinColumn(name = "PRODUCTS_id", referencedColumnName = "id_products")
     )
    public Set<Product> getProducts() {
        return products;
    }

    /**
     * @param products the products to set
     */
    public void setProducts(Set<Product> products) {
        this.products = products;
    } 
}
