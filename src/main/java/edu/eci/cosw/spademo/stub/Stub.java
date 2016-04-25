/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.spademo.stub;

import edu.eci.cosw.spademo.model.Supermarket;
import edu.eci.cosw.spademo.model.ZoneId;
import edu.eci.cosw.spademo.model.ClientApp;
import edu.eci.cosw.spademo.model.Product;
import edu.eci.cosw.spademo.model.Rol;
import edu.eci.cosw.spademo.model.StoreId;
import edu.eci.cosw.spademo.model.Zone;
import edu.eci.cosw.spademo.model.Invoice;
import edu.eci.cosw.spademo.model.Store;
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

//@Service
public class Stub implements IStub {

    List<Supermarket> listSupermarkets = new ArrayList<>();
    List<Store> listStores = new ArrayList<>();
    List<Zone> listZones = new ArrayList<>();
    List<Product> listProducts = new ArrayList<>();
    List<Invoice> listInvoices = new ArrayList<>();
    List<ClientApp> listClients = new ArrayList<>();
    List<ClientApp> listClientsApp = new ArrayList<>();
    List<Rol> listRoles = new ArrayList<>();
    
    public Stub() {
        Set<Store> setStores= new HashSet<>();
        StoreId s0Id = new StoreId(1, 1);
        Store s0 = new Store(s0Id, 10, 10, "Exito 80");
        listStores.add(s0);
        setStores.add(s0);
        
        Set<Product> setP=new HashSet<>();
        Product p = new Product(1,"Jabon", 1000, 30, 500);
        setP.add(p);
        listProducts.add(p);
        
        Supermarket super0 = new Supermarket(1, "Exito");
        Rol r0 = new Rol(1, "Admin");
        listRoles.add(r0);
        ClientApp c0 = new ClientApp(1122,r0, "Felipe", "yo@yo.com", "123", null, null);

        Invoice in = new Invoice(110, new Date(), setP);
        Set<Invoice> setInvoice = new HashSet<>();
        setInvoice.add(in);
        c0.setInvoiceses(setInvoice);

        listClients.add(c0);
        
        
        Set<Supermarket> listSuper = new HashSet<>();
        listSuper.add(super0);
        
        ClientApp c = new ClientApp(16, r0, "Felipe", "juan.pipe1122@gmail.com", "123", listSuper, null);
        c.setInvoiceses(setInvoice);
        c.setSupermarketses(listSuper);
       
        Set<ClientApp> setClients = new HashSet<>();
        ClientApp c1 = new ClientApp(69, r0, "Oscar", "Oscar@yo.com", "123", null, null);
        setClients.add(c1);
        setClients.add(c);
        
        
        super0.setClientsApps(setClients);
        //super0.setStoreses(setStores);

       
        listSupermarkets.add(super0);
        Supermarket s12 = new Supermarket(2, "Cencosud", setClients);
        listSupermarkets.add(s12);
        Supermarket s13 = new Supermarket(3, "Olimpica");
        listSupermarkets.add(s13);
        Supermarket s14 = new Supermarket(4, "Makro");

        listSupermarkets.add(s14);
        
        
        ZoneId zId = new ZoneId(1, 1, 1);
        Zone z = new Zone(zId, "Aseo", s0, setP);
        
        
        Invoice i = new Invoice(15, new Date(), setP);

        listInvoices.add(i);
        listClientsApp.add(c1);
        listClientsApp.add(c);
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
        return listClientsApp;
    }

    @Override
    public ClientApp getClientAppById(Integer id) {
        boolean banderita = false;
        ClientApp cli = null;
        for (int i = 0; i < listClientsApp.size() && !banderita; i++) {
            if (listClientsApp.get(i).getIdClients()== id) {
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
            if (listSupermarkets.get(i).getNameSupermarket().equals(s)) {
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
            if (listSupermarkets.get(i).getIdSupermarkets()== id) {
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
            if (listSupermarkets.get(i).getNameSupermarket().equals(sup)) {
                superm = listSupermarkets.get(i);
                banderita1 = true;
            }
        }
        
        //buscar cliente en supermercado
        Set<ClientApp> setClients = getSupermarketById(superm.getIdSupermarkets()).getClientsApps();
        
        Iterator<ClientApp> iterator = setClients.iterator();
        ClientApp client=null;
        boolean banderita=false;
        while (iterator.hasNext() && !banderita) {
            
            client = iterator.next();
            if (client.getIdClients()==id) {
                banderita=true;
            }
        }
        if(client!=null)
            System.out.println("cliente gsbicbi"+client.getIdClients());
        return client;
    }

    @Override
    public Store getStoreById(StoreId id) {
        Store store = null;
        boolean banderita = false;
        for (int i = 0; i < listStores.size() && !banderita; i++) {
            if (listStores.get(i).getId().equals(id)) {
                store = listStores.get(i);
                banderita = true;
            }
        }
        return store;
    }
    
    

    @Override
    public Zone getZoneById(Integer id, Integer store, Integer supermarket) {
        Zone zone = null;
        boolean banderita = false;
        for (int i = 0; i < listZones.size() && !banderita; i++) {
            if (listZones.get(i).getId().equals(id)) {
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
            if (listProducts.get(i).getIdProductos() == id) {
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
            if (listInvoices.get(i).getIdInvoices()== id) {
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
        return client.getInvoiceses();
    }
    
    @Override
    public Set<Product> getProductListById(Integer c) {
        Invoice invoice = getInvoiceById(c);
        //return client.getInvoices();
        return invoice.getProductses();
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
        boolean banderita=false;
        int j=-1;
        for(j=0; j<getClientsApp().size() && !banderita; j++){
            if(getClientsApp().get(j).getIdClients()==c.getIdClients()){
                System.out.println("ESTE MAN EXISTE");
            }
        }
        
        Set<ClientApp> nuevoSetClients= s.getClientsApps();
        Set<Supermarket> nuevoSetSuper= c.getSupermarketses();
        nuevoSetSuper.add(s);
        nuevoSetClients.add(c);
        getSupermarketById(s.getIdSupermarkets()).setClientsApps(nuevoSetClients);
        
        if(j==-1){
            getClientsApp().get(j).setSupermarketses(nuevoSetSuper);
        }else{
            listClientsApp.add(c);
        }
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
            if (listClientsApp.get(i).getIdClients()== c) {
                banderita = true;
                client = listClientsApp.get(i);
            }
        }

        if (client != null) {
            listClientsApp.remove(listClientsApp.indexOf(client));
            Supermarket s = new Supermarket(1, "Exito");
            listSupermarkets.get(listSupermarkets.indexOf(s)).getClientsApps().remove(client);
        }
    }

    @Override
    public void putProduct(Product product) {
        boolean banderita=false;
       for (int i = 0; i < listProducts.size() && !banderita; i++) {
            if (listProducts.get(i).getIdProductos()==product.getIdProductos() ) {
                
                banderita = true;
                if(listProducts.get(i).getBuyPrice()!=product.getBuyPrice() || listProducts.get(i).getPercentage()!= product.getPercentage()){
                    listProducts.get(i).setBuyPrice(product.getBuyPrice());
                    listProducts. get(i).setPercentage(product.getPercentage());
                }
            }
        } 
    }
    @Override
    public void putClient(ClientApp cliente) {
         boolean banderita = false;
        for (int i = 0; i < listClientsApp.size() && !banderita; i++) {
            banderita = true;
            if (!listClientsApp.get(i).getEmail().equals(cliente.getEmail())) {
                listClientsApp.get(i).setEmail(cliente.getEmail());
                listClientsApp.get(i).setPassword(cliente.getPassword());

            }
        }
    }
   

    public void postRol(Rol rol) {
        listRoles.add(rol);
    }
    
    @Override
    public Rol getRolById(Integer id) {
        Rol r=null;
        for(int i=0; i<listRoles.size(); i++){
            if(listRoles.get(i).getIdRoles()==id){
                r=listRoles.get(i);
            }
        }
        return r;
    }

    @Override
    public List<Rol> getRoles() {
        return listRoles;
    }


    @Override
    public void postSupermarketClient(ClientApp cliente) {
         boolean banderita=false;
        for (int i = 0; i < listClientsApp.size() && !banderita; i++) {
            banderita = true;
            
                listClientsApp.get(i).setSupermarketses(cliente.getSupermarketses());
        
        }
    }

    

    
    
    


}
