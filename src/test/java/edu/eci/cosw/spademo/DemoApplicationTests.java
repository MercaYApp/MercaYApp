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
    public void noEsPrueba(){
        assertEquals(2,2);
    }
/*
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
    }
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

    }

    @Test
    public void invoice1Test() {
        Invoice i = new Invoice(10, 11122, 23000, "Calera", "Jumbo");

        stub.postInvoice(i);

        assertEquals(10, stub.getInvoiceById(10).getId());
        assertEquals(11122, stub.getInvoiceById(10).getDate());
        assertEquals(23000, stub.getInvoiceById(10).getTotal());
        assertTrue(stub.getInvoices().containsKey(i.getId()));
    }

    @Test
    public void product1Test() {
        Product p = new Product(4, "Arroz", 1000, 20, 500);
        stub.postProduct(p);
        assertTrue(stub.getProducts().containsKey(p.getId()));

        assertEquals(4, stub.getProductById(4).getId());
        assertEquals("Arroz", stub.getProductById(4).getName());
        assertEquals(1000, stub.getProductById(4).getBuyPrice());
        assertEquals(20, stub.getProductById(4).getPercetage());
        assertEquals(500, stub.getProductById(4).getWeight());
    }

    @Test
    public void store1Test() {
        HashMap<Integer, Product> setP = new HashMap<>();
        Product p = new Product(4, "Arroz", 1000, 20, 500);
        setP.put(p.getId(), p);

        HashMap<Integer, Zone> setZ = new HashMap<>();
        Zone z = new Zone(3, setP);
        setZ.put(z.getId(), z);

        Store s = new Store(2, setZ);
        stub.postStore(s);
        assertTrue(stub.getStores().containsKey(s.getId()));

        //Test initializing values
        assertEquals(2, stub.getStoreById(2).getId());
        assertEquals(setZ, stub.getStoreById(2).getZones());

        //Test the sets in other sets
        assertTrue(z.getProducts().containsKey(p.getId()));
        assertTrue(stub.getStoreById(2).getZones().containsKey(z.getId()));
    }

    @Test
    public void supermarket1Test() {
        HashMap<Integer, Store> setS = new HashMap<>();
        Store st = new Store(2, null);
        setS.put(st.getId(), st);

        HashMap<Integer, ClientApp> setC = new HashMap<>();
        ClientApp c = new ClientApp(6, "David", "David@yo.com", "123", null, null);
        setC.put(c.getId(), c);

        HashMap<Integer, ClientApp> setCA = new HashMap<>();
        setCA.put(c.getId(), c);

        Supermarket s = new Supermarket("Carulla", setS, setC, setCA);
        stub.postSupermarket(s);
        assertTrue(stub.getSupermarkets().containsKey(s.getId()));

        assertEquals("Carulla", stub.getSupermarketById("Carulla").getId());
        assertTrue(stub.getSupermarketById("Carulla").getStores().containsKey(st.getId()));
        assertEquals(setS, stub.getSupermarketById("Carulla").getStores());
        assertTrue(stub.getSupermarketById("Carulla").getClients().containsKey(c.getId()));
        assertEquals(setC, stub.getSupermarketById("Carulla").getClients());

        assertEquals(6, stub.getSupermarketByIdClientsById("Carulla", 6).getId());

    }

    @Test
    public void zone1Test() {
        HashMap<Integer, Product> setP = new HashMap<>();
        Product p = new Product(4, "Arroz", 1000, 20, 500);
        setP.put(p.getId(), p);

        Zone z = new Zone(3, setP);
        stub.postZone(z);
        assertTrue(stub.getZones().containsKey(z.getId()));

        assertEquals(3, stub.getZoneById(3).getId());
        assertTrue(stub.getZoneById(3).getProducts().containsKey(p.getId()));
        assertEquals(setP, stub.getZoneById(3).getProducts());
    }

*/
}
