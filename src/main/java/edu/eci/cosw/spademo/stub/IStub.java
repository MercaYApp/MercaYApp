/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.spademo.stub;

import edu.eci.cosw.spademo.client.Client;
import edu.eci.cosw.spademo.invoice.Invoice;
import edu.eci.cosw.spademo.store.Store;
import edu.eci.cosw.spademo.product.Product;
import edu.eci.cosw.spademo.supermarket.Supermarket;
import edu.eci.cosw.spademo.tarea.Tarea;
import edu.eci.cosw.spademo.zone.Zone;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Felipe Gomez - Oscar Ardila
 */
public interface  IStub {
    public List<Tarea> getTarea();
    public void postTarea(Tarea t);
    public HashMap<String, Supermarket> getSupermarkets();
    public HashMap<Integer, Store> getStores();
    public HashMap<Integer, Zone> getZones();
    public HashMap<Integer, Product> getProducts();
    public HashMap<Integer, Invoice> getInvoices();
    public HashMap<Integer, Client> getClients();
    public HashMap<Integer, Client> getClientsApp();
    
    public Supermarket getSupermarketById(String id);
    public Client getSupermarketByIdClientsById(String superm, Integer id);

    public Store getStoreById(Integer id);
    public Zone getZoneById(Integer id);
    public Product getProductById(Integer id);
    public Invoice getInvoiceById(Integer id);
    public Client getClientById(Integer id);
    
    
    
    public Map<Integer, Invoice> getInvoiceByClient(Integer c);
    
    
    public void postSupermarket(Supermarket s);
    public void postStore(Store s);
    public void postZone(Zone z);
    public void postProduct(Product p);
    public void postInvoice(Invoice i);
    public void postClient(Client c);
    //public void postClientApp(Client c);   
    public void postClientApp(String s, Client c);   

}
