/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.spademo.APIExterna;

import java.util.Set;

/**
 *
 * @author Felipe 
 */
public class StoreAPI {
    private String nombre;
    private Set<ProductAPI> productos;
    private Set<ClientAPI> clientes;
    private String ubicacion;
    private String nit;
    
    public StoreAPI(){
    }

    public StoreAPI(String nombre, String ubicacion, String nit) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.nit = nit;
    }

    public StoreAPI(String nombre, Set<ProductAPI> productos, Set<ClientAPI> clientes, String ubicacion, String nit) {
        this.nombre = nombre;
        this.productos = productos;
        this.clientes = clientes;
        this.ubicacion = ubicacion;
        this.nit = nit;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the productos
     */
    public Set<ProductAPI> getProductos() {
        return productos;
    }

    /**
     * @param productos the productos to set
     */
    public void setProductos(Set<ProductAPI> productos) {
        this.productos = productos;
    }

    /**
     * @return the clientes
     */
    public Set<ClientAPI> getClientes() {
        return clientes;
    }

    /**
     * @param clientes the clientes to set
     */
    public void setClientes(Set<ClientAPI> clientes) {
        this.clientes = clientes;
    }

    /**
     * @return the ubicacion
     */
    public String getUbicacion() {
        return ubicacion;
    }

    /**
     * @param ubicacion the ubicacion to set
     */
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     * @return the nit
     */
    public String getNit() {
        return nit;
    }

    /**
     * @param nit the nit to set
     */
    public void setNit(String nit) {
        this.nit = nit;
    }
    
    
    
    
    
    
}
