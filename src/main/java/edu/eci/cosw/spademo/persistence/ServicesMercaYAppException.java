/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.spademo.persistence;

/**
 *
 * @author Felipe Brasil
 */
public class ServicesMercaYAppException extends Exception{
    

    public ServicesMercaYAppException(String message) {
        super(message);
    }

    public ServicesMercaYAppException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServicesMercaYAppException(Throwable cause) {
        super(cause);
    }
}
