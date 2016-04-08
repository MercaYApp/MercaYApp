/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.spademo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author 2092724
 */
@Embeddable
public class StoreId implements Serializable{
    private int idStore;
    private Supermarket idSupermarket;

    public StoreId() {
    }

    public StoreId(int idStore, Supermarket idSupermarket) {
        this.idStore = idStore;
        this.idSupermarket = idSupermarket;
    }

    /**
     * @return the idStore
     */
    @Column(name = "id_stores")
    public int getIdStore() {
        return idStore;
    }

    /**
     * @param idStore the idStore to set
     */
    public void setIdStore(int idStore) {
        this.idStore = idStore;
    }

    /**
     * @return the idSupermarket
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @Fetch(FetchMode.JOIN)
    @JsonIgnore
    @JoinColumn(name = "SuperMarket_id", nullable = false)
    public Supermarket getIdSupermarket() {
        return idSupermarket;
    }

    /**
     * @param idSupermarket the idSupermarket to set
     */
    public void setIdSupermarket(Supermarket idSupermarket) {
        this.idSupermarket = idSupermarket;
    }    
    
    
}
