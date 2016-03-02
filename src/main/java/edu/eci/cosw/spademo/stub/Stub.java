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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.springframework.stereotype.Service;

/**
 *
 * @author Felipe Gomez - Oscar Ardila
 */
@Service
public class Stub implements IStub{
    List<Tarea> listaTareas=new ArrayList<>();
    
    Set<Supermarket> listSupermarkets= new HashSet<>();
    Set<Store> listStores=new HashSet<>();
    Set<Zone> listZones=new HashSet<>();
    Set<Product> listProducts=new HashSet<>();
    Set<Invoice> listInvoices=new HashSet<>();
    Set<Client> listClients=new HashSet<>();
    Set<Client> listClientsApp=new HashSet<>();
    
    public  Stub(){
        HashSet<Client> setClient=new HashSet<>();
        Client c1=new Client(69, "Oscar", "Oscar@yo.com", "123", null);
        setClient.add(c1);
        
        Supermarket s=new Supermarket(11, null, setClient, setClient);
        listSupermarkets.add(s);
        
        Zone z=new Zone(13, null);
        listZones.add(z);
        
        Product p=new Product(14, "nada", 1, 2, 3);
        listProducts.add(p);
        
        Invoice i=new Invoice(15, 112294, 60000);
        listInvoices.add(i);
        
        Invoice in=new Invoice(110, 11122, 23000);
        HashSet<Invoice> set=new HashSet<>();
        set.add(in);
        Client c=new Client(16, "Felipe", "Felipe@yo.com", "123", set);
        listClients.add(c);
        
        listClientsApp.add(c);
    }
    
    public List<Tarea> getTarea() {
        Tarea t= new Tarea("Estudiar", 2);
        
        listaTareas.add(t);
        return listaTareas;
    }
    
    public void postTarea(Tarea t) {
        listaTareas.add(t);
    }
 
    @Override
    public Set<Supermarket> getSupermarkets() {
        /*Supermarket s=new Supermarket(1, null, null);
        listSupermarkets.add(s);
        */
        return listSupermarkets;
    }

    @Override
    public Set<Store> getStores() {
        /*Store s=new Store(2, null);
        listStores.add(s);
        */
        return listStores;
    }

    @Override
    public Set<Zone> getZones() {
        /*Zone z=new Zone(3, null);
        listZones.add(z);
        */
        return listZones;
    }

    @Override
    public Set<Product> getProducts() {
        /*Product p=new Product(4, "nada", 1, 2, 3);
        listProducts.add(p);
        */
        return listProducts;
    }

    @Override
    public Set<Invoice> getInvoices() {
        /*Invoice i=new Invoice(5, 112294, 60000);
        listInvoices.add(i);
        */
        return listInvoices;
    }
    
    @Override
    public Set<Client> getClients() {
        /*Invoice i=new Invoice(10, 11122, 23000);
        HashSet<Invoice> set=new HashSet<>();
        set.add(i);
        Client c=new Client(6, "Felipe", "Felipe@yo.com", "123", set);
        listClients.add(c);
        */
        return listClients;
    }

    @Override
    public Set<Client> getClientsApp() {
        /*Invoice i=new Invoice(100, 11122, 23000);
        HashSet<Invoice> set=new HashSet<>();
        set.add(i);
        Client c=new Client(60, "Felipe", "Felipe@yo.com", "123", set);
        listClients.add(c);
        */
        return listClientsApp;
    }
    
    @Override
    public Client getClientById(int id) {
        System.out.println("Id cliente recibido en stub: "+id);
        boolean flag=false;
        Client c=null;
        for (Iterator<Client> i = listClients.iterator(); i.hasNext();) {
            if(flag==false){
                Client f = i.next();
                if (f.getId()==id){
                    System.out.println("Client found: "+f);
                    c=f;
                }
            }
        }
        return c;
    }
    
    @Override
    public Supermarket getSupermarketById(int id) {
        boolean flag=false;
        Supermarket supermarket=null;
        for (Iterator<Supermarket> i = listSupermarkets.iterator(); i.hasNext();) {
            if(flag==false){
                Supermarket f = i.next();
                if (f.getId()==id){
                    System.out.println("Supermarket found: "+f);
                    supermarket=f;
                }
            }
        }
        return supermarket;
    }

    @Override
    public Store getStoreById(int id) {
        boolean flag=false;
        Store s=null;
        for (Iterator<Store> i = listStores.iterator(); i.hasNext();) {
            if(flag==false){
                Store f = i.next();
                if (f.getId()==id){
                    System.out.println("Stores found: "+f);
                    s=f;
                }
            }
        }
        return s;
    }

    @Override
    public Zone getZoneById(int id) {
        boolean flag=false;
        Zone z=null;
        for (Iterator<Zone> i = listZones.iterator(); i.hasNext();) {
            if(flag==false){
                Zone f = i.next();
                if (f.getId()==id){
                    System.out.println("Zones found: "+f);
                    z=f;
                }
            }
        }
        return z;
    }

    @Override
    public Product getProductById(int id) {
        boolean flag=false;
        Product p=null;
        for (Iterator<Product> i = listProducts.iterator(); i.hasNext();) {
            if(flag==false){
                Product f = i.next();
                if (f.getId()==id){
                    System.out.println("Products found: "+f);
                    p=f;
                }
            }
        }
        return p;
    }
    
    @Override
    public Invoice getInvoiceById(int id) {
        boolean flag=false;
        Invoice in=null;
        for (Iterator<Invoice> i = listInvoices.iterator(); i.hasNext();) {
            if(flag==false){
                Invoice f = i.next();
                if (f.getId()==id){
                    System.out.println("Invoices found: "+f);
                    in=f;
                }
            }
        }
        return in;
    }
    
    @Override
    public Set<Invoice> getInvoiceByClient(int c) {
        Client client=getClientById(c);
        System.out.println("Client stub: "+client.getId());
        return client.getInvoices();        
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
    public void postClient(Client c) {
        listClients.add(c);
    }

    @Override
    public void postClientApp(Client c) {
        if(listClients.contains(c)){
            listClientsApp.add(c);
        }else{
            System.out.println("No se puede agregar cliente.");
        }
    }
}
