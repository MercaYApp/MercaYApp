/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.spademo.controllers;

import edu.eci.cosw.spademo.model.Zone;
import edu.eci.cosw.spademo.persistence.ServicesMercaYAppException;
import edu.eci.cosw.spademo.stub.IStub;
import java.util.List;
import java.util.Map;
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
@RequestMapping("/zones")

public class ZoneController {
    @Autowired
    IStub stub;
    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Zone>> getZones()throws ServicesMercaYAppException{
        List<Zone> c=stub.getZones();
        return new ResponseEntity<>(c, HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> postZone(@RequestBody Zone zone)throws ServicesMercaYAppException{
        stub.postZone(zone);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ResponseEntity<Zone> getZoneById(@PathVariable int id)throws ServicesMercaYAppException{
        Zone c=stub.getZoneById(id); 
        return new ResponseEntity<>(c, HttpStatus.OK);
        
    }
    
    
}
