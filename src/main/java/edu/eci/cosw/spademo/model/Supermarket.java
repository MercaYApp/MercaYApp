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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 *
 * @author MercaYApp
 */
@Entity
@Table(name = "SUPERMARKETS")
public class Supermarket implements Serializable {
    private int id;
    private String name;
    private Set<ClientApp> clients = new HashSet<>(0);
    private Set<Store> stores = new HashSet<>(0);

    public Supermarket() {
    }

    public Supermarket(int id, String name, int longitud, int latitud) {
        this.id = id;
    }

    /**
     * @return the id
     */
    @Id
    @Column(name="id_supermarkets")
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
     * @return the clients
     */
    @ManyToMany
    @JoinTable(name="CLIENTS_MARKETS",            
            joinColumns = @JoinColumn(name = "SUPERMARKETS_id", referencedColumnName = "id_supermarkets"),
            inverseJoinColumns = @JoinColumn(name = "CLIENTS_APP_id", referencedColumnName = "id_clients")
    )    
    public Set<ClientApp> getClients() {
        return clients;
    }

    /**
     * @param clients the clients to set
     */
    public void setClients(Set<ClientApp> clients) {
        this.clients = clients;
    }

    /**
     * @return the stores
     */
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "storesSupermarket", nullable = false)
    public Set<Store> getStores() {
        return stores;
    }

    /**
     * @param stores the stores to set
     */
    public void setStores(Set<Store> stores) {
        this.stores = stores;
    }   

    /**
     * @return the name
     */
    @Column(name="name")
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