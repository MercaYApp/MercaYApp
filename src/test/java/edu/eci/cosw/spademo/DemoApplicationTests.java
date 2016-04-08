package edu.eci.cosw.spademo;

import edu.eci.cosw.spademo.model.*;
import edu.eci.cosw.spademo.stub.IStub;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
//@WebAppConfiguration
@ActiveProfiles("test")
public class DemoApplicationTests {

    @Autowired
    IStub stub;

    @Test
    public void client1Test() {
        List<ClientApp> clients = new ArrayList<>();
        Set<Supermarket> supermarkets = new HashSet<>();
        Set<Invoice> setInvoice0 = new HashSet<>();
        //Crear cliente0
        Supermarket super0 = new Supermarket(1, "Exito");
        supermarkets.add(super0);
        Store s0 = new Store(1, super0, 10, 10, "Exito 80");
        Rol r0 = new Rol(1, "Admin");
        ClientApp c0 = new ClientApp(22, "Juan ", "juan@yo.com", "123", r0);
        Invoice i0 = new Invoice(10, new Date(), s0, c0);
        setInvoice0.add(i0);
        c0.setInvoice(setInvoice0);
        c0.setSupermarkets(supermarkets);
        clients.add(c0);
        //Crear cliente
        Set<Invoice> setInvoice = new HashSet<>();
        ClientApp c = new ClientApp(6, "David", "David@yo.com", "123", r0);
        Invoice i = new Invoice(10, new Date(), s0, c);
        setInvoice.add(i);
        c.setInvoice(setInvoice);
        
        assertEquals(0, stub.getClientsApp().size());
        stub.postClientApp(super0, c0);
        assertEquals(1, stub.getClientsApp().size());
        assertEquals(1, stub.getSupermarketById(s0.getId()).getClients().size());
        //stub.postClient(c);
    
       /* stub.getSupermarketById(supermarkets.)
        int cantidad = stub.getSupermarketById(supermarkets.get(supermarkets.size() - 1)).getClientsApp().size();
        stub.postClientApp(supermarkets.get(supermarkets.size() - 1), c);

        //assertEquals(cantidad+1, stub.getSupermarketById(supermarkets.get(supermarkets.size()-1)).getClientsApp().size());
        //assertEquals(cantidad+1, stub.getClientsAppBySupermarket(supermarkets.get(supermarkets.size()-1)).size());
        stub.postClientApp(supermarkets.get(supermarkets.size() - 1), c1);
        //assertEquals(cantidad+1, stub.getClientsApp().size());

        assertEquals(6, stub.getClientById(6).getId());
        assertEquals("David", stub.getClientById(6).getName());
        assertEquals("David@yo.com", stub.getClientById(6).getEmail());
        assertEquals("123", stub.getClientById(6).getPassword());
        assertEquals(set, stub.getClientById(6).getInvoices());
        assertTrue(stub.getClients().containsKey(c.getId()));
        assertTrue(stub.getClientById(6).getInvoices().containsKey(i.getId()));
*/
    }

    @Test
    public void invoice1Test() {
        Supermarket super0 = new Supermarket(1, "Exito");
        Store s0 = new Store(1, super0, 10, 10, "Exito 80");
        Rol r0 = new Rol(1, "Admin");
        ClientApp c0 = new ClientApp(22, "Juan ", "juan@yo.com", "123", r0);
        Invoice i = new Invoice(10, new Date(), s0, c0);
       
        stub.postInvoice(i);

        assertEquals(i.getId(), stub.getInvoiceById(10).getId());
        assertEquals(i.getDate(), stub.getInvoiceById(10).getDate());
        assertEquals(i.getStore(), stub.getInvoiceById(10).getStore());
        assertEquals(i.getClient(), stub.getInvoiceById(10).getClient());
        assertTrue(stub.getInvoices().contains(i));
    }

    @Test
    public void product1Test() {
        Supermarket super0 = new Supermarket(1, "Exito");
        Store s0 = new Store(1, super0, 10, 10, "Exito 80");
        
//Zone z = new Zone(1, "Exito 80");
        Zone z = new Zone(1, s0);
        
        Product p = new Product(1, "Arroz", 1000, 30, 500, z);
        stub.postProduct(p);
        assertTrue(stub.getProducts().contains(p));

        assertEquals(p.getId(), stub.getProductById(p.getId()).getId());
        assertEquals(p.getName(), stub.getProductById(p.getId()).getName());
        assertEquals(p.getBuyPrice(), stub.getProductById(p.getId()).getBuyPrice());
        assertEquals(p.getPercetage(), stub.getProductById(p.getId()).getPercetage());
        assertEquals(p.getWeight(), stub.getProductById(p.getId()).getWeight());
    }

    @Test
    public void store1Test() {
        Supermarket super0 = new Supermarket(1, "Exito");
        Store s0 = new Store(1, super0, 10, 10, "Exito 80");
        
        Set<Zone> setZ = new HashSet<>();
//Zone z = new Zone(1, "Exito 80");
        Zone z = new Zone(1, s0);        
        
        Set<Product> setP = new HashSet<>();
        Product p = new Product(1, "Arroz", 1000, 30, 500, z);
        setP.add(p);
        z.setProducts(setP);
        
        setZ.add(z);
        s0.setZone(setZ);
        
        stub.postStore(s0);
        assertTrue(stub.getStores().contains(s0));

        //Test initializing values
        assertEquals(s0.getId(), stub.getStoreById(s0.getId()).getId());
        assertEquals(setZ, stub.getStoreById(s0.getId()).getZone());

        //Test the sets in other sets
        assertTrue(z.getProducts().contains(p));
        assertTrue(stub.getStoreById(s0.getId()).getZone().contains(z));
    }

    @Test
    public void supermarket1Test() {
        /*Supermarket super0 = new Supermarket(11, "Cencosud");
        Set<Store> setS = new HashSet<>();
        Store st = new Store(10, super0, 10, 10, "Cencosud 80");
        setS.add(st);

        Set<ClientApp> setC = new HashSet<>();
        Rol r0 = new Rol(11, "Admin");
        ClientApp c0 = new ClientApp(16, "David", "David@yo.com", "123", r0);
        setC.add(c0);

        List<ClientApp> setCA = new ArrayList<>();
        setCA.add(c0);

        super0.setStores(setS);
        assertEquals(setS, super0.getStores());
        
        super0.setClients(setC);
        assertEquals(setC, super0.getClients());
        
        stub.postSupermarket(super0);
        assertTrue(stub.getSupermarkets().contains(super0));
        
        assertEquals(setS, stub.getSupermarketById(super0.getId()).getStores());
        assertEquals(super0.getId(), stub.getSupermarketById(super0.getId()).getId());
        assertEquals(super0.getStores(), stub.getSupermarketById(super0.getId()).getStores());
        assertTrue(stub.getSupermarketById(super0.getId()).getStores().contains(st));
        assertTrue(stub.getSupermarketById(super0.getId()).getClients().contains(c0));
        assertEquals(setC, stub.getSupermarketById(super0.getId()).getClients());

        assertEquals(c0, stub.getSupermarketByIdClientsById(super0.getName(), c0.getId()));
        
        assertEquals(c0.getId(), stub.getSupermarketByIdClientsById(super0.getName(), c0.getId()).getId());
*/
    }

    @Test
    public void zone1Test() {
        Supermarket super0 = new Supermarket(21, "Exito");
        Store s0 = new Store(21, super0, 10, 10, "Exito 80");
        
        Set<Zone> setZ = new HashSet<>();
//Zone z = new Zone(21, "Exito 80");
        Zone z = new Zone(1, s0);        
        
        Set<Product> setP = new HashSet<>();
        Product p = new Product(21, "Papaya", 1000, 30, 500, z);
        setP.add(p);
        z.setProducts(setP);
        
     
        stub.postZone(z);
        assertTrue(stub.getZones().contains(z));

        assertEquals(z.getId(), stub.getZoneById(z.getId()).getId());
        assertTrue(stub.getZoneById(z.getId()).getProducts().contains(p));
        assertEquals(setP, stub.getZoneById(z.getId()).getProducts());
    }
}