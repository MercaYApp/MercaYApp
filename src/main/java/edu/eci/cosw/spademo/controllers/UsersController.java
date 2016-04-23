/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.spademo.controllers;

import java.security.Principal;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author MercaYApp
 */
@RestController
public class UsersController {  

    @RequestMapping("/app/user")
    public ResponseEntity<Principal> user(Principal user) {
        Principal c=user;
        return new ResponseEntity<>(c, HttpStatus.OK);
    }           
}