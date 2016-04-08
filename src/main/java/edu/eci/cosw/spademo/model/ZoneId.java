/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.spademo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author 2092724
 */
public class ZoneId 
{
    private int idZone;
    private Store store;
    
    

    public ZoneId() {
    }

    public ZoneId(int idZone, Store store)
    {
        this.idZone = idZone;
        this.store = store;
        
    }

    /**
     * @return the idStore
     */
    @Column(name = "id_zones")
    public int getIdZone() {
        return idZone;
    }

    /**
     * @param idStore the idStore to set
     */
    public void setIdZone(int idZone) {
        this.idZone = idZone;
    }
    
    /**
     * @return the idStore
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @Fetch(FetchMode.JOIN)
    @JsonIgnore
    public Store getIdStore() {
        return this.store;
    }

    /**
     * @param setIdStore the idStore to set
     */
    public void setIdStore(Store store) {
        this.store = store;
    }    


}
