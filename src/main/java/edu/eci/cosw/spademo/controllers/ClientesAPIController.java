/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.spademo.controllers;

import edu.eci.cosw.spademo.APIExterna.ClientAPI;
import edu.eci.cosw.spademo.APIExterna.StoreAPI;
import edu.eci.cosw.spademo.model.ClientApp;
import edu.eci.cosw.spademo.persistence.ServicesMercaYAppException;
import edu.eci.cosw.spademo.stub.IStub;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Felipe 
 */

@RestController
@RequestMapping("/clientsAPI")

public class ClientesAPIController {
    @Autowired
    IStub stub;
    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<StoreAPI> getClientsAPI() throws ServicesMercaYAppException{
        /*RestTemplate restTemplate = new RestTemplate();
        StoreAPI result = restTemplate.getForObject("http://example.com/hotels/{hotel}/bookings/{booking}", StoreAPI.class);
        System.out.println("ESTE ES EL RESULT: "+ result.getNombre());
        return new ResponseEntity<>(result, HttpStatus.OK);*/
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}