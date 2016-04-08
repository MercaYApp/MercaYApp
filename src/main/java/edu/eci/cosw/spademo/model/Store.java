/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.spademo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "STORES")
public class Store implements Serializable {
    private StoreId id;
    private int longitud;
    private int latitud;
    private Set<Zone> zones= new HashSet<>(0);
    private Set<Invoice> invoices= new HashSet<>(0);
    private String name;
    
    public Store(){
    }

    public Store(StoreId id, int longitud, int latitud, String name) {
        this.id = id;
        this.longitud = longitud;
        this.latitud = latitud;
        this.name = name;
    }

    public Store(StoreId id, int longitud, int latitud, Set<Invoice> invoices, Set<Zone> zones, String name) {
        this.id = id;
        this.longitud = longitud;
        this.latitud = latitud;
        this.invoices = invoices;
        this.zones = zones;
        this.name = name;
    }
    
    /**
     * @return the id
     */
    @EmbeddedId
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name="id_stores")
    public StoreId getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(StoreId id) {
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
     * @return the invoice
     */
    @OneToMany(cascade = CascadeType.ALL)
    @Fetch(FetchMode.JOIN)
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
    @Fetch(FetchMode.JOIN)
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

    /**
     * @return the name
     */
    @Column(name="name_store")
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
}
