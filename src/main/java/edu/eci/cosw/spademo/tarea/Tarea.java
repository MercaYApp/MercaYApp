/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.spademo.tarea;

/**
 *
 * @author 2092724
 */
public class Tarea {
    private String nombre;
    private int prioridad;
    
    public Tarea(){
    }
    
    public Tarea(String nombre, int prioridad){
        this.nombre=nombre;
        this.prioridad=prioridad;
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
     * @return the nombre
     */
    public int getPrioridad() {
        return prioridad;
    }

    /**
     * @param prioridad the nombre to set
     */
    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }
    
}
