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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author MercaYApp
 */
@Entity
@Table(name="ROLES")
public class Rol implements Serializable {
    private int id;
    private String descripcion;
    private Set<ClientApp> clients = new HashSet<>(0);
    
    public Rol() {
    }

    public Rol(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public Rol(int id, String descripcion, Set<ClientApp> clients) {
        this.id = id;
        this.descripcion = descripcion;
        this.clients = clients;
    }
    
    /**
     * @return the rol
     */
    @Id
    @Column(name="id_roles")
    public int getRol() {
        return id;
    }

    /**
     * @param id the rol to set
     */
    public void setRol(int id) {
        this.id = id;
    }

    /**
     * @return the descripcion
     */
    @Column(name="descripcion")
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the client
     */
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "clients", nullable = false)
    public Set<ClientApp> getClient() {
        return clients;
    }

    /**
     * @param clients set of clients
     */
    public void setClient(Set<ClientApp> clients) {
        this.clients = clients;
    }
    
    
}
