/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.spademo.controllers;

import edu.eci.cosw.spademo.model.Supermarket;
import edu.eci.cosw.spademo.model.ClientApp;
import edu.eci.cosw.spademo.persistence.ServicesMercaYAppException;
import edu.eci.cosw.spademo.stub.IStub;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
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
@RequestMapping("/supermarkets")

public class SupermarketController {

    @Autowired
    IStub stub;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Supermarket>>getSupermarket() throws ServicesMercaYAppException {
        List<Supermarket> c=stub.getSupermarkets();
        return new ResponseEntity<>(c, HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> postSupermarket(@RequestBody Supermarket supermarket) throws ServicesMercaYAppException {
        //stub.postSupermarket(supermarket);
        System.out.println("entro a postSupermarket");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Supermarket> getSupermarketById(@PathVariable int id) throws ServicesMercaYAppException {
        Supermarket c=stub.getSupermarketById(id);
        return new ResponseEntity<>(c, HttpStatus.OK);

    }

    @RequestMapping(value = "/{id}/clients", method = RequestMethod.GET)
    public ResponseEntity<Set<ClientApp>> getSupermarketClientsById(@PathVariable String id) throws ServicesMercaYAppException {
        Set<ClientApp> c=stub.getSupermarketByName(id).getClientsApps();
        return new ResponseEntity<>(c, HttpStatus.OK);

        /*System.out.println("entro a /{id}/clients");
        return null;*/
    }

    @RequestMapping(value = "/{id}/clientsApp", method = RequestMethod.GET)
    public ResponseEntity<Set<ClientApp>> getSupermarketClientsAppById(@PathVariable String id) throws ServicesMercaYAppException {
        Set<ClientApp> c=stub.getSupermarketByName(id).getClientsApps();
        /*System.out.println("/{id}/clientsApp");
        return null;*/
        return new ResponseEntity<>(c, HttpStatus.OK);

    }

    @RequestMapping(value = "/{superm}/clients/{id}", method = RequestMethod.GET)
    public ResponseEntity<ClientApp> getSupermarketByIdClientsById(@PathVariable String superm, @PathVariable int id) throws ServicesMercaYAppException {
        ClientApp c = null;
        if (stub.getSupermarketByName(superm) != null) {
            c = stub.getSupermarketByIdClientsById(superm, id);
            return new ResponseEntity<>(c, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        

    }

    @RequestMapping(value = "/clientsAppPost", method = RequestMethod.POST)
    public ResponseEntity<Void> postSupermarketClientsApp(@RequestBody ClientApp client) throws ServicesMercaYAppException {
        System.out.println("NULOOO??: "+stub.getClientAppById(client.getIdClients())!= null);
        Set<Supermarket> set = client.getSupermarketses();
        System.out.println("ENTRO A SET: "+set.isEmpty());
        int cont=0;
        Supermarket s=null;
        Iterator<Supermarket> iterator = set.iterator();
        while (iterator.hasNext()) {
            cont+=1;
            s = iterator.next();
            if (cont==(set.size()-1)){
                set.add(s);
            }
        }
        
        System.out.println("entro a postSupermarketClientsApp, post super: "+s.getNameSupermarket());
        
        stub.postClientApp(s, client);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
