/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.spademo.supermarket;

import edu.eci.cosw.spademo.client.Client;
import edu.eci.cosw.spademo.store.Store;
import java.util.HashMap;

/**
 *
 * @author Felipe Brasil
 */
public class Supermarket {
    private String id;
    private HashMap<Integer, Store> stores;
    private HashMap<Integer, Client> clients;
    private HashMap<Integer, Client> clientsApp;
    
    public Supermarket(String id, HashMap<Integer, Store> stores, HashMap<Integer, Client> clients, HashMap<Integer, Client> clientsApp) {
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
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */

    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the stores
     */
    public HashMap<Integer, Store> getStores() {
        return stores;
    }

    /**
     * @param stores the stores to set
     */
    public void setStores(HashMap<Integer, Store> stores) {
        this.stores = stores;
    }

    /**
     * @return the clients
     */
    public HashMap<Integer, Client> getClients() {
        return clients;
    }

    /**
     * @param clients the clients to set
     */
    public void setClients(HashMap<Integer, Client> clients) {
        this.clients = clients;
    }

    /**
     * @return the clientsApp
     */
    public HashMap<Integer, Client> getClientsApp() {
        return clientsApp;
    }

    /**
     * @param clientsApp the clientsApp to set
     */
    public void setClientsApp(HashMap<Integer, Client> clientsApp) {
        this.clientsApp = clientsApp;
    }
}
