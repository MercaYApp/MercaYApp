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
@Table(name = "STORES")
public class Store implements Serializable {
    private int id;
    private int longitud;
    private int latitud;
    private Supermarket supermarketId;
    private Set<Zone> zones= new HashSet<>(0);
    private Set<Invoice> invoices= new HashSet<>(0);
    
    
    public Store(){
    }

    public Store(int id, Supermarket supermarketId) {
        this.id = id;
        this.supermarketId=supermarketId;
    }

    public Store(int id, Supermarket supermarketId, Set<Invoice> invoices, Set<Zone> zones) {
        this.id = id;
        this.supermarketId=supermarketId;
        this.invoices = invoices;
        this.zones = zones;
    }
    
    /**
     * @return the id
     */
    @Id
    @Column(name="id_stores")
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
     * @return the longitud
     */
    @Column(name = "longitud")
    public int getLongitud() {
        return longitud;
    }

    /**
     * @param longitud the longitud to set
     */
    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    /**
     * @return the latitud
     */
    @Column(name = "latitud")
    public int getLatitud() {
        return latitud;
    }

    /**
     * @param latitud the latitud to set
     */
    public void setLatitud(int latitud) {
        this.latitud = latitud;
    }
    
    /**
     * @return the supermarketId
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SuperMarket_id", nullable = false, insertable=false, updatable=false)
    public Supermarket getSupermarketId() {
        return supermarketId;
    }

    /**
     * @param supermarketId the supermarketId to set
     */
    public void setSupermarketId(Supermarket supermarketId) {
        this.supermarketId = supermarketId;
    }

    /**
     * @return the invoice
     */
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "invoicesStore", nullable = false)
    public Set<Invoice> getInvoice() {
        return invoices;
    }

    /**
     * @param invoice the invoice to set
     */
    public void setInvoice(Set<Invoice> invoice) {
        this.invoices = invoice;
    }

    /**
     * @return the zone
     */
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "zoneStore", nullable = false)
    public Set<Zone> getZone() {
        return zones;
    }

    /**
     * @param zones the zone to set
     */
    public void setZone(Set<Zone> zones) {
        this.zones = zones;
    }
    
}