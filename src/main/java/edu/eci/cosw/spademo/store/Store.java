/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.spademo.store;

import edu.eci.cosw.spademo.zone.Zone;
import java.util.HashMap;

/**
 *
 * @author Felipe Brasil
 */
public class Store {
    private int id;
    private HashMap<Integer, Zone> zones;
    
    public Store(){
    }

    public Store(int id, HashMap<Integer, Zone> zones) {
        this.id = id;
        this.zones = zones;
    }

    
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the zones
     */
    public HashMap<Integer, Zone> getZones() {
        return zones;
    }

    /**
     * @param zones the zones to set
     */
    public void setZones(HashMap<Integer, Zone> zones) {
        this.zones = zones;
    }
    
    
}
