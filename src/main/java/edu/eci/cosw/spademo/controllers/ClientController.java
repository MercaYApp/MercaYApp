    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.spademo.controllers;

import edu.eci.cosw.spademo.model.ClientApp;
import edu.eci.cosw.spademo.model.Invoice;
import edu.eci.cosw.spademo.stub.IStub;
import java.util.HashMap;
import edu.eci.cosw.spademo.stub.IStub;
import edu.eci.cosw.spademo.model.Supermarket;
import edu.eci.cosw.spademo.persistence.ServicesMercaYAppException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author MercaYApp 
 */
@RestController
@RequestMapping("/clientsApp")


public class ClientController {
    @Autowired
    IStub stub;
    
    @RequestMapping(method = RequestMethod.GET)
    public List<ClientApp> getClientsApp() throws ServicesMercaYAppException{
        return stub.getClientsApp();
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public void postClientApp(@RequestBody ClientApp client){
        if(stub.getClientAppById(client.getId())!= null){
            stub.postClient(client);
        }  
    }
    
    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ClientApp getClientById(@PathVariable int id) throws ServicesMercaYAppException{
        return stub.getClientAppById(id);  
    }

    @RequestMapping(value="/{id}/invoices", method = RequestMethod.GET)
    public Set<Invoice> getClientInvoicetById(@PathVariable int id) throws ServicesMercaYAppException{
        return stub.getInvoiceByClient(id);
    }
    
    @RequestMapping(value="/clientsAppDelete/{id}", method = RequestMethod.DELETE)
    public void deleteSupermarketClientsApp(@PathVariable int id) throws ServicesMercaYAppException{
        //System.out.println("AQUI SI delete: "+id);
        stub.deleteClientApp(id);
    }
    
}