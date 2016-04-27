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
import java.util.Iterator;

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
    public Zone getZoneById(Integer id, Integer store, Integer supermarket) {
        ZoneId zId = new ZoneId(id, store, supermarket);
        return zonesR.findOne(zId);
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
        //Agregar Cliente a la tabla de clientes
        Set<Supermarket> superm = c.getSupermarketses();
        superm.add(s);
        //Agregar Supermercados al cliente
        c.setSupermarketses(superm);
        clientsR.save(c);

        Set<ClientApp> setClients = s.getClientsApps();
        setClients.add(clientsR.findOne(c.getIdClients()));
        //Agregar cliente a el supermercado
        supermarketsR.findOne(s.getIdSupermarkets()).setClientsApps(setClients);
        supermarketsR.save(supermarketsR.findOne(s.getIdSupermarkets()));
    }

    @Override
    public void postEmail(int id) {
        try {
            ClientApp c = clientsR.findOne(id);
            String asunto = "Recuperacion de contraseña MercaYApp!";
            String mensaje = "Hola " + c.getNameClientApp() + ", este es el mensaje de recuperación de su contraseña. \n Su contraseña  de MercaYApp es: " + c.getPassword()
                    + "\n Por favor ingrese y recuerde cambiar su contraseña en http://mercayapp1.herokuapp.com/app/index.html#/viewConfiguracion "
                    + "dando click en 'Actualizar datos'";
            EnviadorMail en = new EnviadorMail(c.getEmail(), asunto, mensaje);
            System.out.println("Envió email a: " + c.getEmail());
        } catch (NullPointerException e) {
            System.out.println("No existe cliente con este id");
        }
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
        if (productsR.findOne(product.getIdProductos()).getBuyPrice() != product.getBuyPrice()) {
            productsR.findOne(product.getIdProductos()).setBuyPrice(product.getBuyPrice());
        }
        if (productsR.findOne(product.getIdProductos()).getPercentage() != product.getPercentage()) {
            productsR.findOne(product.getIdProductos()).setPercentage(product.getPercentage());
        }
        productsR.save(productsR.findOne(product.getIdProductos()));
    }

    @Override
    public void putClient(ClientApp cliente) {
        if (clientsR.findOne(cliente.getIdClients()) != null) {
            if (!clientsR.findOne(cliente.getIdClients()).getEmail().equals(cliente.getEmail())) {
                clientsR.findOne(cliente.getIdClients()).setEmail(cliente.getEmail());
            }
            if (!clientsR.findOne(cliente.getIdClients()).getPassword().equals(cliente.getPassword())) {
                clientsR.findOne(cliente.getIdClients()).setPassword(cliente.getPassword());
            }
            clientsR.save(clientsR.findOne(cliente.getIdClients()));
        }
    }

    @Override
    public void postSupermarketClient(ClientApp cliente) {
        ClientApp c = clientsR.findOne(cliente.getIdClients());
        Supermarket supermarket = null;

        Set<Supermarket> setSuperm = clientsR.findOne(cliente.getIdClients()).getSupermarketses();
        setSuperm.addAll(cliente.getSupermarketses());
        
        //Agregar supermercado al cliente
        clientsR.findOne(cliente.getIdClients()).setSupermarketses(setSuperm);
        clientsR.save(clientsR.findOne(cliente.getIdClients()));
        
        //Agregar cliente a la tabla de supermercados
        Iterator<Supermarket> iterator = cliente.getSupermarketses().iterator();
        while (iterator.hasNext()) {
            supermarket = iterator.next();
        }
        Set<ClientApp> setClients = supermarketsR.findOne(supermarket.getIdSupermarkets()).getClientsApps();
        setClients.add(clientsR.findOne(cliente.getIdClients()));
        supermarketsR.findOne(supermarket.getIdSupermarkets()).setClientsApps(setClients);
        supermarketsR.save(supermarketsR.findOne(supermarket.getIdSupermarkets()));
    }

}
