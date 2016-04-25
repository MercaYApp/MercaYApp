/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.spademo.mail;

import edu.eci.cosw.spademo.model.Invoice;
import edu.eci.cosw.spademo.stub.IStub;
import java.util.HashMap;
import edu.eci.cosw.spademo.stub.IStub;
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
@RequestMapping("/email")


public class EnviadorMailController {
    @Autowired
    IStub stub;
    
   
    @RequestMapping(method = RequestMethod.POST)
    public void postCorreoOlvidado(@RequestBody Integer id){
        stub.postEmail(id);
        
    }    

}