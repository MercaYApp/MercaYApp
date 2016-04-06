/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.spademo.controllers;

import edu.eci.cosw.spademo.model.Zone;
import edu.eci.cosw.spademo.stub.IStub;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Zone> getZones(){
        return stub.getZones();
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public void postZone(@RequestBody Zone zone){
        stub.postZone(zone);
    }
    
    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Zone getZoneById(@PathVariable int id){
        return stub.getZoneById(id);
    }
    
    
}
