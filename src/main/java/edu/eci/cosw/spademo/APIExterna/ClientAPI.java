/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.spademo.APIExterna;

/**
 *
 * @author Felipe Brasil
 */
public class ClientAPI {
    private String nombre;
    private String tipo;
    private long gastoAcumulado;
    private long codigo;

    public ClientAPI(String nombre, String tipo, long gastoAcumulado, long codigo) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.gastoAcumulado = gastoAcumulado;
        this.codigo = codigo;
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
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the gastoAcumulado
     */
    public long getGastoAcumulado() {
        return gastoAcumulado;
    }

    /**
     * @param gastoAcumulado the gastoAcumulado to set
     */
    public void setGastoAcumulado(long gastoAcumulado) {
        this.gastoAcumulado = gastoAcumulado;
    }

    /**
     * @return the codigo
     */
    public long getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }
    
    
}
