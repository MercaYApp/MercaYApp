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

    public Store getStoreById(Integer id);
    public Zone getZoneById(Integer id);
    public Product getProductById(Integer id);
    public Invoice getInvoiceById(Integer id);
    public ClientApp getClientAppById(Integer id);
    public Rol getRolById(Integer id);
    
    public Set<Invoice> getInvoiceByClient(Integer c);

    public void postSupermarket(Supermarket s);
    public void postStore(Store s);
    public void postZone(Zone z);
    public void postProduct(Product p);
    public void postInvoice(Invoice i);
    public void postClient(ClientApp c);
    public void postClientApp(Supermarket s, ClientApp c); 
    public void deleteClientApp(int c);
    public void postEmail(String email);
    public void putProduct(Product product);
    public void postRol(Rol rol);
    public void putClient(ClientApp cliente);

    public void postSupermarketClients(ClientApp cliente);

    public void postSupermarketClient(ClientApp cliente);




}
