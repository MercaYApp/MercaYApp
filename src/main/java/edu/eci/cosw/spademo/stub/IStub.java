/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.spademo.stub;

import edu.eci.cosw.spademo.model.Supermarket;
import edu.eci.cosw.spademo.model.ClientApp;
import edu.eci.cosw.spademo.model.Product;
import edu.eci.cosw.spademo.model.Zone;
import edu.eci.cosw.spademo.model.Invoice;
import edu.eci.cosw.spademo.model.Store;
import edu.eci.cosw.spademo.model.*;
import java.util.List;
import java.util.Set;

/**
 *
 * @author MercaYApp
 */
public interface  IStub {
    public List<Supermarket> getSupermarkets();
    public List<Store> getStores();
    public List<Zone> getZones();
    public List<Product> getProducts();
    public List<Invoice> getInvoices();
    //public List<ClientApp> getClients();
    public List<ClientApp> getClientsApp();
    public List<Rol> getRoles();
    
    public Supermarket getSupermarketByName(String name);
    public Supermarket getSupermarketById(int id);
    public ClientApp getSupermarketByIdClientsById(String superm, Integer id);

    public Store getStoreById(StoreId id);
    public Zone getZoneById(Integer id, Integer store, Integer supermarket);
    public Product getProductById(Long id);
    public Invoice getInvoiceById(Long id);
    public ClientApp getClientAppById(Integer id);
    public Rol getRolById(Integer id);
    
    public Set<Invoice> getInvoiceByClient(Integer c);
    public Set<Product> getProductListById(Long c);

    public void postSupermarket(Supermarket s);
    public void postStore(Store s);
    public void postZone(Zone z);
    public void postProduct(Product p);
    public void postInvoice(Invoice i);
    public void postClient(ClientApp c);
    public void postClientApp(Supermarket s, ClientApp c); 
    public void deleteClientApp(int c);
    public void postEmail(int id);
    public void putProduct(Product product);
    public void postRol(Rol rol);
    public void putClient(ClientApp cliente);

    public void postSupermarketClient(ClientApp cliente);




}
