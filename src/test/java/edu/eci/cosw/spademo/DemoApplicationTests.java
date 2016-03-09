package edu.eci.cosw.spademo;

import edu.eci.cosw.spademo.client.Client;
import edu.eci.cosw.spademo.invoice.Invoice;
import edu.eci.cosw.spademo.product.Product;
import edu.eci.cosw.spademo.store.Store;
import edu.eci.cosw.spademo.stub.IStub;
import edu.eci.cosw.spademo.supermarket.Supermarket;
import edu.eci.cosw.spademo.zone.Zone;
import java.util.ArrayList;
import java.util.HashMap;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
//@WebAppConfiguration
public class DemoApplicationTests {
        @Autowired
        IStub stub;
         
        @Test
        public void client1Test(){  
            
            Invoice i=new Invoice(10, 11122, 23000);
            HashMap<Integer, Invoice> set=new HashMap<>();
            ArrayList<Integer> supermarkets = new ArrayList<>();
            supermarkets.add(11);
            set.put(i.getId(), i);
            Client c=new Client(6, "David", "David@yo.com", "123", set, supermarkets);
            Client c1=new Client(61, "Andres", "Andres@yo.com", "123", set, supermarkets);
            stub.postClient(c);
            stub.postClient(c1);
            
            //int cantidad=stub.getClientsAppBySupermarket(supermarkets.get(supermarkets.size()-1)).size();
            int cantidad=stub.getSupermarketById(supermarkets.get(supermarkets.size()-1)).getClientsApp().size();
            stub.postClientApp(supermarkets.get(supermarkets.size()-1), c);
            
            //assertEquals(cantidad+1, stub.getSupermarketById(supermarkets.get(supermarkets.size()-1)).getClientsApp().size());
            
            
            stub.postClientApp(supermarkets.get(supermarkets.size()-1), c1);
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
        public void invoice1Test(){            
            Invoice i=new Invoice(10, 11122, 23000);
            stub.postInvoice(i);
            
            assertEquals(10, stub.getInvoiceById(10).getId());
            assertEquals(11122, stub.getInvoiceById(10).getDate());
            assertEquals(23000, stub.getInvoiceById(10).getTotal());
            assertTrue(stub.getInvoices().containsKey(i.getId()));   
        }
        
        @Test
        public void product1Test(){
            Product p=new Product(4, "Arroz", 1000, 20, 500);
            stub.postProduct(p);
            assertTrue(stub.getProducts().containsKey(p.getId()));
            
            assertEquals(4, stub.getProductById(4).getId());
            assertEquals("Arroz", stub.getProductById(4).getName());
            assertEquals(1000, stub.getProductById(4).getBuyPrice());
            assertEquals(20, stub.getProductById(4).getPercetage());
            assertEquals(500, stub.getProductById(4).getWeight());
        }
        
        @Test
        public void store1Test(){
            HashMap<Integer, Product> setP=new HashMap<>();
            Product p=new Product(4, "Arroz", 1000, 20, 500);
            setP.put(p.getId(), p);
            
            HashMap<Integer, Zone> setZ=new HashMap<>();
            Zone z=new Zone(3, setP);
            setZ.put(z.getId(), z);
            
            Store s=new Store(2, setZ);
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
        public void supermarket1Test(){            
            HashMap<Integer, Store> setS=new HashMap<>();
            Store st=new Store(2, null);
            setS.put(st.getId(), st);
            
            HashMap<Integer, Client> setC=new HashMap<>();
            Client c=new Client(6, "David", "David@yo.com", "123", null, null);
            setC.put(c.getId(), c);
            
            HashMap<Integer, Client> setCA=new HashMap<>();           
            setCA.put(c.getId(), c);
            
            Supermarket s=new Supermarket(1, setS, setC, setCA);
            stub.postSupermarket(s);
            assertTrue(stub.getSupermarkets().containsKey(s.getId()));
            
            assertEquals(1, stub.getSupermarketById(1).getId());
            assertTrue(stub.getSupermarketById(1).getStores().containsKey(st.getId()));
            assertEquals(setS, stub.getSupermarketById(1).getStores());
            assertTrue(stub.getSupermarketById(1).getClients().containsKey(c.getId()));
            assertEquals(setC, stub.getSupermarketById(1).getClients());
            
            assertEquals(6, stub.getSupermarketByIdClientsById(1, 6).getId());
            
        }

        @Test
        public void zone1Test(){
            HashMap<Integer, Product> setP=new HashMap<>();
            Product p=new Product(4, "Arroz", 1000, 20, 500);
            setP.put(p.getId(), p);
            
            Zone z=new Zone(3, setP);
            stub.postZone(z);
            assertTrue(stub.getZones().containsKey(z.getId()));
            
            assertEquals(3, stub.getZoneById(3).getId());
            assertTrue(stub.getZoneById(3).getProducts().containsKey(p.getId()));
            assertEquals(setP, stub.getZoneById(3).getProducts());
        }
}
