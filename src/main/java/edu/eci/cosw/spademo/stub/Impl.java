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
import edu.eci.cosw.spademo.persistence.*;
import edu.eci.cosw.spademo.mail.EnviadorMail;

import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author MercaYApp
 */
@Service
public class Impl implements IStub {

    @Autowired
    ClientsRepository clientsR;
    @Autowired
    ProductsRepository productsR;
    @Autowired
    InvoicesRepository invoicesR;
    @Autowired
    StoresRepository storesR;
    @Autowired
    ZonesRepository zonesR;
    @Autowired
    SupermarketsRepository supermarketsR;
    @Autowired
    RolesRepository rolesR;
   
    public Impl() {
       
    }

    @Override
    public List<Supermarket> getSupermarkets() {
        return supermarketsR.findAll();
    }
     
    @Override
    public List<Store> getStores() {
        return storesR.findAll();
    }

    @Override
    public List<Zone> getZones() {
        return zonesR.findAll();
    }

    @Override
    public List<Product> getProducts() {
        return productsR.findAll();
    }

    @Override
    public List<Invoice> getInvoices() {
        return invoicesR.findAll();
    }

    @Override
    public List<ClientApp> getClientsApp() {
        return clientsR.findAll();
    }

    @Override
    public ClientApp getClientAppById(Integer id) {
        return clientsR.findOne(id);
    }

    @Override
    public Supermarket getSupermarketByName(String s) {
        return null;
        //return supermarketsR.getByName(s);
    }

    @Override
    public Supermarket getSupermarketById(int id) {
        return supermarketsR.findOne(id);
    }
    
    
    @Override
    public ClientApp getSupermarketByIdClientsById(String superm, Integer id) {
        System.out.println("entro a getSupermarketByIdClientsById");
        return null;
        //return supermarketsR.getByIdClientsById(superm, id);
    }
     
    @Override
    public Store getStoreById(StoreId id) {
        return storesR.findOne(id);
    }

    @Override
    public Zone getZoneById(ZoneId id) {
        return zonesR.findOne(id);
    }

    @Override
    public Product getProductById(Integer id) {
        return productsR.findOne(id);
    }

    @Override
    public Invoice getInvoiceById(Integer id) {
        return invoicesR.findOne(id);
    }

    @Override
    public Set<Invoice> getInvoiceByClient(Integer c) {
        ClientApp client = getClientAppById(c);
        return client.getInvoiceses();
    }
      @Override
    public Set<Product> getProductListById(Integer c) {
        Invoice i = invoicesR.findOne(c);
        return i.getProductses();
    }
   
    @Override
    public void postSupermarket(Supermarket s) {
        supermarketsR.save(s);
    }
     
    @Override
    public void postStore(Store s) {
        storesR.save(s);
    }

    @Override
    public void postZone(Zone z) {
        zonesR.save(z);
    }

    @Override
    public void postProduct(Product p) {
        productsR.save(p);
    }

    @Override
    public void postInvoice(Invoice i) {
        invoicesR.save(i);
    }
    
    @Override
    public void postClient(ClientApp c) {
        clientsR.save(c);
    }

    @Override
    public void postClientApp(Supermarket s, ClientApp c) {
        System.out.println("ENTRO AL POSTTT");
        Set<Supermarket> superm = c.getSupermarketses();
        superm.add(s);
        clientsR.save(c);
        System.out.println("Entro al post AGREGO CLIENTE: "+c.getNameClientApp());
        clientsR.findOne(c.getIdClients()).setSupermarketses(superm);
        System.out.println("ENTRO AL POST CLIENT APP agrego: "+s.getNameSupermarket());
    }
    @Override
    public void postEmail(String email) {
        /*ClientApp c = clientsR.findByEmail(email);
        System.out.println("ENCONTRO EL CORREO: "+c.getNameClientApp());
        /*if (c != null && c.getEmail().equals(email)) {
            String asunto = "Este es el correo de recuperacion de contraseña!";
            String mensaje = "El mensaje de recuperación de su contraseña";
            EnviadorMail en = new EnviadorMail(email, asunto, mensaje);
            System.out.println("Envió email a: " + email);
        }else{
            System.out.println("No coinciden los datos");
        }*/
    }

    @Override
    public void deleteClientApp(int c) {
        clientsR.delete(c);

        //listSupermarkets.get("Exito").getClientsApp().remove(c);
    }
    

    @Override
    public List<Rol> getRoles() {
        return rolesR.findAll();
    }

    @Override
    public Rol getRolById(Integer id) {
        return rolesR.findOne(id);
    }

    @Override
    public void postRol(Rol rol) {
        rolesR.save(rol);
    }

    @Override
    public void putProduct(Product product) {
        if(productsR.findOne(product.getIdProductos())!=null){
            if(productsR.findOne(product.getIdProductos()).getBuyPrice()!=product.getBuyPrice()){
                productsR.findOne(product.getIdProductos()).setBuyPrice(product.getBuyPrice());
            }
            if(productsR.findOne(product.getIdProductos()).getPercentage()!=product.getPercentage()){
                productsR.findOne(product.getPercentage()).setPercentage(product.getPercentage());
            }
        }
    }

    @Override
    public void putClient(ClientApp cliente) {
        if(clientsR.findOne(cliente.getIdClients())!=null){
            System.out.println("ENTRO a CAMBIAR EL CLIENTE");
            if(!clientsR.findOne(cliente.getIdClients()).getEmail().equals(cliente.getEmail())){
                clientsR.findOne(cliente.getIdClients()).setEmail(cliente.getEmail());
                System.out.println("cambio email a: "+clientsR.findOne(cliente.getIdClients()).getEmail());
            }
            if(!clientsR.findOne(cliente.getIdClients()).getPassword().equals(cliente.getPassword())){
                clientsR.findOne(cliente.getIdClients()).setPassword(cliente.getPassword());
                System.out.println("cambio el password");
            }
            
        }
    }

    @Override
    public void postSupermarketClient(ClientApp cliente) {
        ClientApp c = clientsR.findOne(cliente.getIdClients());
        if(c!=null){
            clientsR.findOne(cliente.getIdClients()).setSupermarketses(cliente.getSupermarketses());
        }

    }

 

 

}
