/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.spademo.supermarket;

import edu.eci.cosw.spademo.client.Client;
import edu.eci.cosw.spademo.store.Store;
import java.util.HashSet;

/**
 *
 * @author Felipe Brasil
 */
public class Supermarket {
    private int id;
    private HashSet<Store> stores;
    private HashSet<Client> clients;

    public Supermarket(Integer id, HashSet<Store> stores,HashSet<Client> clients) {
        this.id = id;
        this.stores = stores;
        this.clients = clients;   
    }

    
    public Supermarket(){
    
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
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the stores
     */
    public HashSet<Store> getStores() {
        return stores;
    }

    /**
     * @param stores the stores to set
     */
    public void setStores(HashSet<Store> stores) {
        this.stores = stores;
    }

    /**
     * @return the clients
     */
    public HashSet<Client> getClients() {
        return clients;
    }

    /**
     * @param clients the clients to set
     */
    public void setClients(HashSet<Client> clients) {
        this.clients = clients;
    }
}
