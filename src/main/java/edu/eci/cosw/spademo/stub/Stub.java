/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.spademo.stub;

import edu.eci.cosw.spademo.model.ClientApp;
import edu.eci.cosw.spademo.model.Invoice;
import edu.eci.cosw.spademo.mail.EnviadorMail;
import edu.eci.cosw.spademo.model.Store;
import edu.eci.cosw.spademo.model.Product;
import edu.eci.cosw.spademo.model.Supermarket;
import edu.eci.cosw.spademo.model.Zone;
import java.util.ArrayList;
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
        if (listClients.get(id) != null) {
            return listClients.get(id);
        } else {
            return null;
        }
    }

    @Override
    public Supermarket getSupermarketById(int s) {
        return listSupermarkets.get(s);
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
    public Set<Invoice> getInvoiceByClient(Integer c) {
        ClientApp client = getClientAppById(c);
        //return client.getInvoices();
        return null;
    }
    
    /*
    @Override
    public void postSupermarket(Supermarket s) {
        listSupermarkets.put(s.getId(), s);
    }
    */

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

    /*
    @Override
    public void postInvoice(Invoice i) {
        listInvoices.put(i.getId(), i);
    }*/

    @Override
    public void postClient(ClientApp c) {
        listClients.add(c);
    }

    /*
    @Override
    public void postClientApp(String s, ClientApp c) {
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
    }
    */
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
        for(int i=0; i<listClientsApp.size() && !banderita; i++){
            if(listClientsApp.get(i).getEmail().equals(email)){
                String asunto = "Este es el correo de recuperacion de contraseña!";
                String mensaje = "El mensaje de recuperación de su contraseña";
                EnviadorMail en = new EnviadorMail(email, asunto, mensaje);
                banderita = true;
                System.out.println("Envió email a: " + email);
            }
        }
        if (banderita == false){
            System.out.println("NO EXISTE EL CORREO");
        }
    }
    
    @Override
    public void deleteClientApp(int c) {
        boolean banderita = false;
        ClientApp client= null;
        System.out.println("deleteStub:elimina "+ c);
     
        for(int i=0; i<listClientsApp.size() && !banderita; i++){
            if(listClientsApp.get(i).getId()==c){
                banderita=true;
                client=listClientsApp.get(i);
            }
        }
       
        if(client!=null){
            listClientsApp.remove(listClientsApp.indexOf(client));
            Supermarket s= new Supermarket(1, "Exito", 1, 1);
            listSupermarkets.get(listSupermarkets.indexOf(s)).getClients().remove(client);
        }
    }

}
