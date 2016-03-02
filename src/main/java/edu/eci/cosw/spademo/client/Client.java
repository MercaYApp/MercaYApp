/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.spademo.client;


import edu.eci.cosw.spademo.invoice.Invoice;
import java.util.HashSet;

/**
 *
 * @author Felipe Brasil
 */
public class Client {
    private int id;
    private String name;
    private String email;
    private String password;
    private HashSet<Invoice> invoices;

    public Client(int id, String name, String email, String password, HashSet<Invoice> invoices) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.invoices = invoices;
    }

    public Client() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public HashSet<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(HashSet<Invoice> invoices) {
        this.invoices = invoices;
    }
    
    
}
