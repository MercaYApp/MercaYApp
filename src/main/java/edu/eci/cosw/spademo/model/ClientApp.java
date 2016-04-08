/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.spademo.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author MercaYApp
 */
@Entity
@Table(name="CLIENTS_APP")
public class ClientApp implements Serializable {
    private int id;
    private String name;
    private String email;
    private String password;
    private Rol rol;
    private Set<Invoice> invoice = new HashSet<>(0);
    private Set<Supermarket> supermarkets = new HashSet<>(0);

    public ClientApp(int id, String name, String email, String password, Rol rol) {

        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.rol = rol;
    }
    
    public ClientApp(int id, String name, String email, String password, Rol rol, Set<Invoice> invoice, Set<Supermarket> supermarkets) {

        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.rol = rol;
        this.invoice = invoice;
        this.supermarkets = supermarkets;
    }

    public ClientApp() {
    }
   
    @Id
    @Column(name="id_clients")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="name_client_app")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name="password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the rol
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "Roles_id", nullable = false)
    public Rol getRol() {
        return rol;
    }

    /**
     * @param rol the rol to set
     */
    public void setRol(Rol rol) {
        this.rol = rol;
    }    

    /**
     * @return the supermarkets
     */
    @ManyToMany( mappedBy = "clients")
    @Fetch(FetchMode.JOIN)
    public Set<Supermarket> getSupermarkets() {
        return supermarkets;
    }

    /**
     * @param supermarkets the supermarkets to set
     */
    public void setSupermarkets(Set<Supermarket> supermarkets) {
        this.supermarkets = supermarkets;
    }

    /**
     * @return the invoice
     */
    @OneToMany(cascade = CascadeType.ALL)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "invoicesClientsApp", nullable = false)
    public Set<Invoice> getInvoice() {
        return invoice;
    }

    /**
     * @param invoice the invoice to set
     */
    public void setInvoice(Set<Invoice> invoice) {
        this.invoice = invoice;
    }
}
