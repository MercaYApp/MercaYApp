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
import java.util.List;
import java.util.HashMap;
import org.springframework.stereotype.Service;

/**
 *
 * @author Felipe Gomez - Oscar Ardila
 */
@Service
public class Stub implements IStub{
    List<Tarea> listaTareas=new ArrayList<>();
    
    HashMap<String, Supermarket> listSupermarkets= new HashMap<>();
    HashMap<Integer, Store> listStores=new HashMap<>();
    HashMap<Integer, Zone> listZones=new HashMap<>();
    HashMap<Integer, Product> listProducts=new HashMap<>();
    HashMap<Integer, Invoice> listInvoices=new HashMap<>();
    HashMap<Integer, Client> listClients=new HashMap<>();
    HashMap<Integer, Client> listClientsApp=new HashMap<>();
    
    public  Stub(){
        Invoice in=new Invoice(110, 110122, 23000,"chapinero","Jumbo");
        Invoice in1=new Invoice(111, 120221, 299000,"galerias","Exito");
        HashMap<Integer, Invoice> set=new HashMap<>();
        set.put(in.getId(), in);
        set.put(in1.getId(), in1);
        Client c=new Client(16, "Felipe", "Felipe@yo.com", "123", set, null);
        listClients.put(c.getId(), c);
        
        HashMap<Integer, Client> setClients=new HashMap<>();
        Client c1=new Client(69, "Oscar", "Oscar@yo.com", "123", null, null);
        setClients.put(c1.getId(), c1);
        setClients.put(c.getId(), c);
        HashMap<Integer, Client> setClientsApp=new HashMap<>();
        //setClientsApp.put(c1.getId(), c1);
        setClientsApp.put(c.getId(), c);
        
        Supermarket s=new Supermarket("Exito", null, setClients, setClientsApp);
        listSupermarkets.put(s.getId(), s);
        Supermarket s12=new Supermarket("Cencosud", null, setClients, null);
        listSupermarkets.put(s12.getId(), s12);
        Supermarket s13=new Supermarket("Olimpica", null, setClients, null);
        listSupermarkets.put(s13.getId(), s13);
        Supermarket s14=new Supermarket("Makro", null, setClients, null);
        listSupermarkets.put(s14.getId(), s14);
        
        Zone z=new Zone(13, null);
        listZones.put(z.getId(), z);
        
        Product p=new Product(14, "nada", 1, 2, 3);
        listProducts.put(p.getId(), p);
        
        Invoice i=new Invoice(15, 112294, 60000,"calera","jumbo");
        listInvoices.put(i.getId(), i);
        
        
        listClientsApp.put(c.getId(), c);
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
    public HashMap<String, Supermarket> getSupermarkets() {
        return listSupermarkets;
    }

    @Override
    public HashMap<Integer, Store> getStores() {
        return listStores;
    }

    @Override
    public HashMap<Integer, Zone> getZones() {
        return listZones;
    }

    @Override
    public HashMap<Integer, Product> getProducts() {
        return listProducts;
    }

    @Override
    public HashMap<Integer, Invoice> getInvoices() {
        return listInvoices;
    }
    
    @Override
    public HashMap<Integer, Client> getClients() {
        return listClients;
    }

    @Override
    public HashMap<Integer, Client> getClientsApp() {
        return listClientsApp;
    }
    
    @Override
    public Client getClientById(Integer id) {
        if(listClients.get(id)!=null){
            return listClients.get(id);
        }else{
            return null;
        }
    }
    
    @Override
    public Supermarket getSupermarketById(String id) {
        return listSupermarkets.get(id);
    }
    
    @Override
    public Client getSupermarketByIdClientsById(String superm, Integer id) {
        HashMap clients = getSupermarketById(superm).getClients();
        if(clients.size()>0){
            return getSupermarketById(superm).getClients().get(id);
        }else{
            return null;
        }
    }

    @Override
    public Store getStoreById(Integer id) {
        return listStores.get(id);
    }

    @Override
    public Zone getZoneById(Integer id) {
        return listZones.get(id);
    }

    @Override
    public Product getProductById(Integer id) {
        return listProducts.get(id);
    }
    
    @Override
    public Invoice getInvoiceById(Integer id) {
        return listInvoices.get(id);
    }
    
    @Override
    public HashMap<Integer, Invoice> getInvoiceByClient(Integer c) {
        Client client=getClientById(c);
        return client.getInvoices();        
    }
    
    @Override
    public void postSupermarket(Supermarket s) {
        listSupermarkets.put(s.getId(), s);
    }

    @Override
    public void postStore(Store s) {
        listStores.put(s.getId(), s);
    }

    @Override
    public void postZone(Zone z) {
        listZones.put(z.getId(), z);
    }

    @Override
    public void postProduct(Product p) {
        listProducts.put(p.getId(), p);
    }

    @Override
    public void postInvoice(Invoice i) {
        listInvoices.put(i.getId(), i);
    }

    @Override
    public void postClient(Client c) {
        listClients.put(c.getId(), c);
    }

    @Override
    //public void postClientApp( Client c) {          
    public void postClientApp(String s, Client c) {
        /*if (listSupermarkets.get(s).getClients().get(c.getId())!=null){
            listSupermarkets.get(s).getClientsApp().put(c.getId(), c);
        }else{
            System.out.println("No se puede agregar cliente.");
        }*/
        listSupermarkets.get(s).getClientsApp().put(c.getId(), c);
    }
}

