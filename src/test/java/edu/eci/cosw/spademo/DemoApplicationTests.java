package edu.eci.cosw.spademo;

import edu.eci.cosw.spademo.client.Client;
import edu.eci.cosw.spademo.invoice.Invoice;
import edu.eci.cosw.spademo.product.Product;
import edu.eci.cosw.spademo.store.Store;
import edu.eci.cosw.spademo.stub.IStub;
import edu.eci.cosw.spademo.supermarket.Supermarket;
import edu.eci.cosw.spademo.zone.Zone;
import java.util.HashSet;
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
            HashSet<Invoice> set=new HashSet<>();
            set.add(i);
            Client c=new Client(6, "Felipe", "Felipe@yo.com", "123", set);
            Client c1=new Client(61, "Oscar", "Oscar@yo.com", "123", set);
            stub.postClient(c);
            
            int cantidad = stub.getClientsApp().size();
            stub.postClientApp(c);
            assertEquals(cantidad+1, stub.getClientsApp().size());
            
            stub.postClientApp(c1);
            assertEquals(cantidad+1, stub.getClientsApp().size());
            
            assertEquals(6, stub.getClientById(6).getId());
            assertEquals("Felipe", stub.getClientById(6).getName());
            assertEquals("Felipe@yo.com", stub.getClientById(6).getEmail());
            assertEquals("123", stub.getClientById(6).getPassword());
            assertEquals(set, stub.getClientById(6).getInvoices());
            assertTrue(stub.getClients().contains(c));            
            assertTrue(stub.getClientById(6).getInvoices().contains(i));   
        }
        
        @Test
        public void invoice1Test(){            
            Invoice i=new Invoice(10, 11122, 23000);
            stub.postInvoice(i);
            
            assertEquals(10, stub.getInvoiceById(10).getId());
            assertEquals(11122, stub.getInvoiceById(10).getDate());
            assertEquals(23000, stub.getInvoiceById(10).getTotal());
            assertTrue(stub.getInvoices().contains(i));   
        }
        
        @Test
        public void product1Test(){
            Product p=new Product(4, "Arroz", 1000, 20, 500);
            stub.postProduct(p);
            assertTrue(stub.getProducts().contains(p));
            
            assertEquals(4, stub.getProductById(4).getId());
            assertEquals("Arroz", stub.getProductById(4).getName());
            assertEquals(1000, stub.getProductById(4).getBuyPrice());
            assertEquals(20, stub.getProductById(4).getPercetage());
            assertEquals(500, stub.getProductById(4).getWeight());
        }
        
        @Test
        public void store1Test(){
            HashSet<Product> setP=new HashSet<>();
            Product p=new Product(4, "Arroz", 1000, 20, 500);
            setP.add(p);
            
            HashSet<Zone> setZ=new HashSet<>();
            Zone z=new Zone(3, setP);
            setZ.add(z);
            
            Store s=new Store(2, setZ);
            stub.postStore(s);
            assertTrue(stub.getStores().contains(s));
            
            //Test initializing values
            assertEquals(2, stub.getStoreById(2).getId());
            assertEquals(setZ, stub.getStoreById(2).getZones());
            
            //Test the sets in other sets
            assertTrue(z.getProducts().contains(p));
            assertTrue(stub.getStoreById(2).getZones().contains(z));
        }
        
        @Test
        public void supermarket1Test(){            
            HashSet<Store> setS=new HashSet<>();
            Store st=new Store(2, null);
            setS.add(st);
            
            HashSet<Client> setC=new HashSet<>();
            Client c=new Client(6, "Felipe", "Felipe@yo.com", "123", null);
            setC.add(c);
            
            HashSet<Client> setCA=new HashSet<>();           
            setCA.add(c);
            
            Supermarket s=new Supermarket(1, setS, setC, setCA);
            stub.postSupermarket(s);
            assertTrue(stub.getSupermarkets().contains(s));
            
            assertEquals(1, stub.getSupermarketById(1).getId());
            assertTrue(stub.getSupermarketById(1).getStores().contains(st));
            assertEquals(setS, stub.getSupermarketById(1).getStores());
            assertTrue(stub.getSupermarketById(1).getClients().contains(c));
            assertEquals(setC, stub.getSupermarketById(1).getClients());
        }

        @Test
        public void zone1Test(){
            HashSet<Product> setP=new HashSet<>();
            Product p=new Product(4, "Arroz", 1000, 20, 500);
            setP.add(p);
            
            Zone z=new Zone(3, setP);
            stub.postZone(z);
            assertTrue(stub.getZones().contains(z));
            
            assertEquals(3, stub.getZoneById(3).getId());
            assertTrue(stub.getZoneById(3).getProducts().contains(p));
            assertEquals(setP, stub.getZoneById(3).getProducts());
        }
}
