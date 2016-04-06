/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.spademo.stub;

import edu.eci.cosw.spademo.model.*;
import edu.eci.cosw.spademo.persistence.*;
import edu.eci.cosw.spademo.mail.EnviadorMail;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MercaYApp
 */
//@Service
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

    /*
    HashMap<String, Supermarket> listSupermarkets = new HashMap<>();
    HashMap<Integer, Store> listStores = new HashMap<>();
    HashMap<Integer, Zone> listZones = new HashMap<>();
    HashMap<Integer, Product> listProducts = new HashMap<>();
    HashMap<Integer, Invoice> listInvoices = new HashMap<>();
    HashMap<Integer, ClientApp> listClients = new HashMap<>();
    HashMap<Integer, ClientApp> listClientsApp = new HashMap<>();
     */
    public Impl() {
        /*Invoice in = new Invoice(110, new Date(), "chapinero", client)
        Invoice in = new Invoice(110, 110122, 23000, "chapinero", "Jumbo");
        Invoice in1 = new Invoice(111, 120221, 299000, "galerias", "Exito");
        HashMap<Integer, Invoice> set = new HashMap<>();
        set.put(in.getId(), in);
        set.put(in1.getId(), in1);
        ArrayList<String> listSuper = new ArrayList<>();
        listSuper.add("Exito");
        Client c = new Client(16, "Felipe", "juan.pipe1122@gmail.com", "123", set, listSuper);
        listClients.put(c.getId(), c);

        HashMap<Integer, Client> setClients = new HashMap<>();
        Client c1 = new Client(69, "Oscar", "Oscar@yo.com", "123", null, null);
        setClients.put(c1.getId(), c1);
        setClients.put(c.getId(), c);
        HashMap<Integer, Client> setClientsApp = new HashMap<>();
        //setClientsApp.put(c1.getId(), c1);
        setClientsApp.put(c.getId(), c);

        Supermarket s = new Supermarket("Exito", null, setClients, setClientsApp);
        listSupermarkets.put(s.getId(), s);
        Supermarket s12 = new Supermarket("Cencosud", null, setClients, null);
        listSupermarkets.put(s12.getId(), s12);
        Supermarket s13 = new Supermarket("Olimpica", null, setClients, null);
        listSupermarkets.put(s13.getId(), s13);
        Supermarket s14 = new Supermarket("Makro", null, setClients, null);

        listSupermarkets.put(s14.getId(), s14);

        Zone z = new Zone(13, null);
        listZones.put(z.getId(), z);

        Product p = new Product(14, "nada", 1, 2, 3);
        listProducts.put(p.getId(), p);

        Invoice i = new Invoice(15, 112294, 60000, "calera", "jumbo");

        listInvoices.put(i.getId(), i);

        listClientsApp.put(c.getId(), c);
        
         */
    }

    /*  @Override
    public HashMap<String, Supermarket> getSupermarkets() {

        return listSupermarkets;
    }
     */
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
    public Supermarket getSupermarketById(int s) {

        return supermarketsR.findOne(s);
    }

    /*
    @Override
    public ClientApp getSupermarketByIdClientsById(String superm, Integer id) {
        HashMap clients = getSupermarketById(superm).getClients();
        if (clients.size() > 0) {
            return getSupermarketById(superm).getClients().get(id);
        } else {
            return null;
        }
    }
     */
    @Override
    public Store getStoreById(Integer id) {
        return storesR.findOne(id);
    }

    @Override
    public Zone getZoneById(Integer id) {
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
        //return client.getInvoices();
        return client.getInvoice();
    }

    /*
    @Override
    public void postSupermarket(Supermarket s) {
        listSupermarkets.put(s.getId(), s);
    }
     */
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

    /*
    @Override
    public void postInvoice(Invoice i) {
        listInvoices.put(i.getId(), i);
    }*/
    @Override
    public void postClient(ClientApp c) {
        clientsR.save(c);
    }

    /*@Override
    public void postClientApp(Supermarket s, ClientApp c) {
        if (listSupermarkets.get(s).getClients().get(c.getId()) != null) {
            if (listSupermarkets.get(s).getClientsApp().get(c.getId()) == null) {
                listSupermarkets.get(s).getClientsApp().put(c.getId(), c);
                //listClientsApp.put(c.getId(), c);
                
                listClientsApp.get(c.getId()).addSupermarkets(s);
            } else {
                System.out.println("Usuario ya registrado.");
            }

        } else {
            System.out.println("No se puede agregar cliente.");
        }
    }*/
    @Override
    public void postEmail(String email) {
        /*ClientApp c = clientsR.findOne(id);
        if (c != null && c.getEmail().equals(email)) {
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

}
