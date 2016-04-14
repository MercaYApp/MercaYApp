package edu.eci.cosw.spademo;

import ch.qos.logback.core.joran.action.ActionUtil;
import edu.eci.cosw.spademo.model.Product;
import edu.eci.cosw.spademo.model.StoreId;
import edu.eci.cosw.spademo.model.Invoice;
import edu.eci.cosw.spademo.model.ClientApp;
import edu.eci.cosw.spademo.model.Zone;
import edu.eci.cosw.spademo.model.Store;
import edu.eci.cosw.spademo.model.Supermarket;
import edu.eci.cosw.spademo.model.Rol;
import edu.eci.cosw.spademo.model.ZoneId;
import edu.eci.cosw.spademo.persistence.ClientsRepository;
import edu.eci.cosw.spademo.persistence.InvoicesRepository;
import edu.eci.cosw.spademo.persistence.ProductsRepository;
import edu.eci.cosw.spademo.persistence.RolesRepository;
import edu.eci.cosw.spademo.persistence.StoresRepository;
import edu.eci.cosw.spademo.persistence.SupermarketsRepository;
import edu.eci.cosw.spademo.persistence.ZonesRepository;
import edu.eci.cosw.spademo.stub.IStub;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
//@WebAppConfiguration
@ActiveProfiles("test")

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DemoApplicationTests {

    @Autowired
    IStub stub;
    
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
    @Autowired
    RolesRepository rolesR;
    
    
    /*
    Se hacen en orden consecutivo los test, para evitar la creación de tantos 
    objetos de prueba
    */
    
    @Test
    public void aCreateSupermarket() {
        Set<Supermarket> setSuperm = new HashSet<>();
        Supermarket superm = new Supermarket(1, "Exito");
        setSuperm.add(superm);
        supermarketsR.save(superm);
    
        Set<Product> setProduct = new HashSet<>();
        Product produ = new Product(77, "Chocoramo", 1000, 20, 40);
        productsR.save(produ);
        setProduct.add(produ);
                
        Set<Invoice> setInvoice = new HashSet<>();
        Invoice inv = new Invoice(1, new Date(), setProduct);
        setInvoice.add(inv);
        invoicesR.save(inv);
               
        Rol r0 = new Rol(1, "Cliente");
        rolesR.save(r0);
        ClientApp c0 = new ClientApp(5, r0, "Daniel", "Daniel@yo.com", "123", setSuperm, setInvoice);
        clientsR.save(c0);       

    }

    @Test
    public void aNoSupermarketTest() {
        assertEquals(null, supermarketsR.findOne(3));
    }
    
    @Test
    public void aSiSupermarketTest() {
        assertEquals(1, supermarketsR.findOne(1).getIdSupermarkets());
    }

    @Test
    public void bNoProductTest() {        
        assertEquals(null, productsR.findOne(3));
    }
    
    @Test
    public void bSiProductTest() {        
        assertEquals(77, productsR.findOne(77).getIdProductos());
    }

    @Test
    public void cNoProductTest() {        
        assertEquals(null, invoicesR.findOne(3));
    }
    
    @Test
    public void cSiProductTest() {        
        assertEquals(1, invoicesR.findOne(1).getIdInvoices());
    }
    
    @Test
    public void dNoRolTest() {        
        assertEquals(null, rolesR.findOne(3));
    }
    
    @Test
    public void cSiRolTest() {        
        assertEquals(1, rolesR.findOne(1).getIdRoles());
    }
    
    @Test
    public void dNoClientsAppTest() {        
        assertEquals(null, clientsR.findOne(22));
    }
    
    @Test
    public void cSiClientsAppTest() {        
        assertEquals(5, clientsR.findOne(5).getIdClients());
    }
    
    @Test
    public void zone1Test() {
        /*Supermarket super0 = new Supermarket(21, "Exito");
        stub.postSupermarket(super0);
        
        
        Set<Product> setP = new HashSet<>();
        Product p = new Product(21, "Papaaya", 1000, 30, 500);
        stub.postProduct(p);
        setP.add(p);
        
        Set<Invoice> setI = new HashSet<>();
        Invoice i = new Invoice(1, new Date(), setP);
        stub.postInvoice(i);
        setI.add(i);
        
        
        StoreId s0Id = new StoreId(2, 21);
        Store s0 = new Store(s0Id, 10, 10, "Exito 134", setI, super0);
        stub.postStore(s0);
        
        ZoneId zId = new ZoneId(11, 2, 21);
        Zone z = new Zone(zId, "Fruta", s0, setP);
        stub.postZone(z);
       */
    }
}