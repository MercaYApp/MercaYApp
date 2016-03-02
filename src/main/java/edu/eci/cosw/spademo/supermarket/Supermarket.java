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
    private HashSet<Client> clientsApp;
    

    public Supermarket(Integer id, HashSet<Store> stores,HashSet<Client> clients, HashSet<Client> clientsApp) {
        this.id = id;
        this.stores = stores;
        this.clients = clients;
        this.clientsApp = clientsApp;
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

    /**
     * @return the clientsApp
     */
    public HashSet<Client> getClientsApp() {
        return clientsApp;
    }

    /**
     * @param clientsApp the clientsApp to set
     */
    public void setClientsApp(HashSet<Client> clientsApp) {
        this.clientsApp = clientsApp;
    }
}
