package edu.eci.cosw.spademo.model;
// Generated 10-abr-2016 9:50:56 by Hibernate Tools 4.3.1


import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * Stores generated by hbm2java
 */
@Entity
@Table(name="stores")
public class Store  implements java.io.Serializable {


     private StoreId id;
     private double longitud;
     private double latitud;
     private String nameStore;
     private Set<Invoice> invoiceses = new HashSet<>();
     private Supermarket supermarket;

    public Store() {
    }

	
    public Store(StoreId id, int longitud, int latitud, String nameStore) {
        this.id = id;
        this.longitud = longitud;
        this.latitud = latitud;
        this.nameStore = nameStore;
    }
    public Store(StoreId id, int longitud, int latitud, String nameStore, Set<Invoice> invoiceses, Supermarket supermarket) {
       this.id = id;
       this.longitud = longitud;
       this.latitud = latitud;
       this.nameStore = nameStore;
       this.invoiceses = invoiceses;
       this.supermarket = supermarket;
    }
   
    @EmbeddedId
    public StoreId getId() {
        return this.id;
    }
    
    public void setId(StoreId id) {
        this.id = id;
    }

    
    @ManyToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name="supermarkets_id_supermarkets", nullable = false, insertable=false, updatable=false)
    public Supermarket getSupermarket() {
        return this.supermarket;
    }
    
    public void setSupermarket(Supermarket supermarket) {
        this.supermarket = supermarket;
    }
    
    
    @Column(name="longitud", nullable=false)
    public double getLongitud() {
        return this.longitud;
    }
    
    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    
    @Column(name="latitud", nullable=false)
    public double getLatitud() {
        return this.latitud;
    }
    
    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    
    @Column(name="name_store", nullable=false, length=25)
    public String getNameStore() {
        return this.nameStore;
    }
    
    public void setNameStore(String nameStore) {
        this.nameStore = nameStore;
    }


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Fetch(FetchMode.JOIN)
    @JsonIgnore
    @JoinColumns({
        @JoinColumn(name = "stores_id_stores", insertable=false, updatable = false),
        @JoinColumn(name = "stores_supermarkets_id_supermarkets", insertable=false, updatable = false)
    })
    public Set<Invoice> getInvoiceses() {
        return this.invoiceses;
    }
    
    public void setInvoiceses(Set<Invoice> invoiceses) {
        this.invoiceses = invoiceses;
    }




}


