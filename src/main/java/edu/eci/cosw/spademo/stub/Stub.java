/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.spademo.stub;

import edu.eci.cosw.spademo.mail.EnviadorMail;
import edu.eci.cosw.spademo.model.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.springframework.stereotype.Service;

/**
 *
 * @author MercaYApp
 */

@Service
public class Stub implements IStub {

    List<Supermarket> listSupermarkets = new ArrayList<>();
    List<Store> listStores = new ArrayList<>();
    List<Zone> listZones = new ArrayList<>();
    List<Product> listProducts = new ArrayList<>();
    List<Invoice> listInvoices = new ArrayList<>();
    List<ClientApp> listClients = new ArrayList<>();
    List<ClientApp> listClientsApp = new ArrayList<>();

    public Stub() {
        Supermarket super0 = new Supermarket(1, "Exito");        
        StoreId sId0 = new StoreId(1, super0);
        Store s0 = new Store(sId0, 10, 10, "Exito 80");
        Rol r0 = new Rol(1, "Admin");
        ClientApp c0 = new ClientApp(1122, "Felipe", "yo@yo.com", "123", r0);
        Invoice in = new Invoice(110, new Date(), s0, c0);
        Invoice in1 = new Invoice(111, new Date(), s0, c0);
        Set<Invoice> setInvoice = new HashSet<>();
        Set<Store> setStores = new HashSet<>();
        setInvoice.add(in);
        setInvoice.add(in1);
        c0.setInvoice(setInvoice);
        listClients.add(c0);
        
        
        ArrayList<String> listSuper = new ArrayList<>();
        listSuper.add("Exito");
        
        ClientApp c = new ClientApp(16, "Felipe", "juan.pipe1122@gmail.com", "123", r0);
        c.setInvoice(setInvoice);
        listClients.add(c);

        Set<ClientApp> setClients = new HashSet<>();
        ClientApp c1 = new ClientApp(69, "Oscar", "Oscar@yo.com", "123", r0);
        setClients.add(c1);
        setClients.add(c);
        super0.setClients(setClients);
        super0.setStores(setStores);

       
        listSupermarkets.add(super0);
        Supermarket s12 = new Supermarket(2, "Cencosud");
        listSupermarkets.add(s12);
        Supermarket s13 = new Supermarket(3, "Olimpica");
        listSupermarkets.add(s13);
        Supermarket s14 = new Supermarket(4, "Makro");

        listSupermarkets.add(s14);

        Zone z = new Zone(13, null);
        listZones.add(z);

        Product p = new Product(2, "Jabon", 1000, 30, 150, z);
        listProducts.add(p);

        Invoice i = new Invoice(15, new Date(), s0, c1);

        listInvoices.add(i);

        listClientsApp.add(c);
        listClientsApp.add(c1);

    }

    @Override
    public List<Supermarket> getSupermarkets() {

        return listSupermarkets;
    }

    @Override
    public List<Store> getStores() {
        return listStores;
    }

    @Override
    public List<Zone> getZones() {
        return listZones;
    }

    @Override
    public List<Product> getProducts() {
        return listProducts;
    }

    @Override
    public List<Invoice> getInvoices() {
        return listInvoices;
    }

    @Override
    public List<ClientApp> getClientsApp() {
        return listClients;
    }

    @Override
    public ClientApp getClientAppById(Integer id) {
        boolean banderita = false;
        ClientApp cli = null;
        for (int i = 0; i < listClientsApp.size() && !banderita; i++) {
            if (listClientsApp.get(i).getId() == id) {
                cli = listClientsApp.get(i);
                banderita = true;
            }
        }
        return cli;
    }

    @Override
    public Supermarket getSupermarketByName(String s) {
        boolean banderita = false;
        Supermarket superm = null;
        for (int i = 0; i < listSupermarkets.size() && !banderita; i++) {
            if (listSupermarkets.get(i).getName().equals(s)) {
                superm = listSupermarkets.get(i);
                banderita = true;
            }
        }
        return superm;
    }

    @Override
    public Supermarket getSupermarketById(int id) {
        boolean banderita = false;
        Supermarket superm = null;
        for (int i = 0; i < listSupermarkets.size() && !banderita; i++) {
            if (listSupermarkets.get(i).getId() == id) {
                superm = listSupermarkets.get(i);
                banderita = true;
            }
        }
        return superm;
    }

    @Override
    public ClientApp getSupermarketByIdClientsById(String sup, Integer id) {
        //Buscar supermercado
        boolean banderita1 = false;
        Supermarket superm = null;
        for (int i = 0; i < listSupermarkets.size() && !banderita1; i++) {
            if (listSupermarkets.get(i).getName().equals(sup)) {
                superm = listSupermarkets.get(i);
                banderita1 = true;
            }
        }
        
        //buscar cliente en supermercado
        Set<ClientApp> setClients = getSupermarketById(superm.getId()).getClients();
        
        Iterator<ClientApp> iterator = setClients.iterator();
        ClientApp client=null;
        boolean banderita=false;
        while (iterator.hasNext() && !banderita) {
            
            client = iterator.next();
            if (client.getId()==id) {
                banderita=true;
            }
        }
        if(client!=null)
            System.out.println("cliente gsbicbi"+client.getId());
        return client;
    }

    @Override
    public Store getStoreById(Integer id) {
        Store store = null;
        boolean banderita = false;
        for (int i = 0; i < listStores.size() && !banderita; i++) {
            if (listStores.get(i).getId().getIdStore() == id) {
                store = listStores.get(i);
                banderita = true;
            }
        }
        return store;
    }

    @Override
    public Zone getZoneById(Integer id) {
        Zone zone = null;
        boolean banderita = false;
        for (int i = 0; i < listZones.size() && !banderita; i++) {
            if (listZones.get(i).getId() == id) {
                zone = listZones.get(i);
                banderita = true;
            }
        }
        return zone;
    }

    @Override
    public Product getProductById(Integer id) {
        Product prod = null;
        boolean banderita = false;
        for (int i = 0; i < listProducts.size() && !banderita; i++) {
            if (listProducts.get(i).getId() == id) {
                prod = listProducts.get(i);
                banderita = true;
            }
        }
        return prod;

    }

    @Override
    public Invoice getInvoiceById(Integer id) {
        Invoice inv = null;
        boolean banderita = false;
        for (int i = 0; i < listInvoices.size() && !banderita; i++) {
            if (listInvoices.get(i).getId() == id) {
                inv = listInvoices.get(i);
                banderita = true;
            }
        }
        return inv;
    }

    @Override
    public Set<Invoice> getInvoiceByClient(Integer c) {
        ClientApp client = getClientAppById(c);
        //return client.getInvoices();
        return client.getInvoice();
    }

    @Override
    public void postSupermarket(Supermarket s) {
        listSupermarkets.add(s);
    }

    @Override
    public void postStore(Store s) {
        listStores.add(s);
    }

    @Override
    public void postZone(Zone z) {
        listZones.add(z);
    }

    @Override
    public void postProduct(Product p) {
        listProducts.add(p);
    }

    
    @Override
    public void postInvoice(Invoice i) {
        listInvoices.add(i);
    }
    
    @Override
    public void postClient(ClientApp c) {
        listClients.add(c);
    }

    @Override
    public void postClientApp(Supermarket s, ClientApp c) {
        System.out.println("ENTRO A ESTO==");
        listSupermarkets.get(listSupermarkets.indexOf(s)).getClients().add(c);
        listClientsApp.add(c);
    }

    @Override
    public void postEmail(String email) {
        /*if(listClientsApp.get(listClientsApp.indexOf(getClientAppById(id))).getEmail().equals(email)){
            String asunto = "Este es el correo de recuperacion de contraseña!";
                String mensaje = "El mensaje de recuperación de su contraseña";
                EnviadorMail en = new EnviadorMail(email, asunto, mensaje);
                System.out.println("Envió email a: " + email);
        }else{
            System.out.println("NO coinciden los datos");
        }*/
        boolean banderita = false;
        for (int i = 0; i < listClientsApp.size() && !banderita; i++) {
            if (listClientsApp.get(i).getEmail().equals(email)) {
                String asunto = "Este es el correo de recuperacion de contraseña!";
                String mensaje = "El mensaje de recuperación de su contraseña";
                EnviadorMail en = new EnviadorMail(email, asunto, mensaje);
                banderita = true;
                System.out.println("Envió email a: " + email);
            }
        }
        if (banderita == false) {
            System.out.println("NO EXISTE EL CORREO");
        }
    }

    @Override
    public void deleteClientApp(int c) {
        boolean banderita = false;
        ClientApp client = null;
        System.out.println("deleteStub:elimina " + c);

        for (int i = 0; i < listClientsApp.size() && !banderita; i++) {
            if (listClientsApp.get(i).getId() == c) {
                banderita = true;
                client = listClientsApp.get(i);
            }
        }

        if (client != null) {
            listClientsApp.remove(listClientsApp.indexOf(client));
            Supermarket s = new Supermarket(1, "Exito");
            listSupermarkets.get(listSupermarkets.indexOf(s)).getClients().remove(client);
        }
    }

}
