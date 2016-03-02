/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.spademo.invoice;

import edu.eci.cosw.spademo.stub.IStub;
import edu.eci.cosw.spademo.tarea.TaskController;
import java.util.Set;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Felipe Brasil
 */
@RestController
@RequestMapping("/invoices")

public class InvoiceController {
    @Autowired
    IStub stub;
    
    @RequestMapping(method = RequestMethod.GET)
    public Set<Invoice> getInvoices(){
        LOG.info("lista invoicessss.");
        return stub.getInvoices();
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public void postInvoice(@RequestBody Invoice invoice){
        stub.postInvoice(invoice);
        LOG.info("Add invoice; "+invoice.getId());
    }
    
    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Invoice getInvoiceById(@PathVariable int id){
        return stub.getInvoiceById(id);
    }
    
    @RequestMapping(value="/client/{client}", method = RequestMethod.GET)
    public Set<Invoice> getInvoiceByClient(@PathVariable int client){
        return stub.getInvoiceByClient(client);
    }
    
    private static final Logger LOG = Logger.getLogger(TaskController.class.getName());  
    
}
