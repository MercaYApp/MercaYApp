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
import java.util.List;
import java.util.Set;

/**
 *
 * @author Felipe Gomez - Oscar Ardila
 */
public interface  IStub {
    public List<Tarea> getTarea();
    public void postTarea(Tarea t);
    
    public Set<Supermarket> getSupermarkets();
    public Set<Store> getStores();
    public Set<Zone> getZones();
    public Set<Product> getProducts();
    public Set<Invoice> getInvoices();
    public Set<Client> getClients();
    public Set<Client> getClientsApp();
    
    
    public Supermarket getSupermarketById(int id);
    public Store getStoreById(int id);
    public Zone getZoneById(int id);
    public Product getProductById(int id);
    public Invoice getInvoiceById(int id);
    public Client getClientById(int id);
    
    
    public Set<Invoice> getInvoiceByClient(int c);
    
    
    public void postSupermarket(Supermarket s);
    public void postStore(Store s);
    public void postZone(Zone z);
    public void postProduct(Product p);
    public void postInvoice(Invoice i);
    public void postClient(Client c);
    public void postClientApp(Client c);
    
}
