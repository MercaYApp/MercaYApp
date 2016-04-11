package edu.eci.cosw.spademo.model;
// Generated 10-abr-2016 9:50:56 by Hibernate Tools 4.3.1


import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * Supermarkets generated by hbm2java
 */
@Entity
@Table(name="SUPERMARKETS"
    ,catalog="coswgr6"
)
public class Supermarket  implements java.io.Serializable {


     private int idSupermarkets;
     private String nameSupermarket;
     private Set<ClientApp> clientsApps = new HashSet<>();
     private Set<Store> storeses = new HashSet<>();

    public Supermarket() {
    }

	
    public Supermarket(int idSupermarkets, String nameSupermarket) {
        this.idSupermarkets = idSupermarkets;
        this.nameSupermarket = nameSupermarket;
    }
    
    public Supermarket(int idSupermarkets, String nameSupermarket, Set<ClientApp> clientsApps) {
       this.idSupermarkets = idSupermarkets;
       this.nameSupermarket = nameSupermarket;
       this.clientsApps = clientsApps;
    }
    
    public Supermarket(int idSupermarkets, String nameSupermarket, Set<ClientApp> clientsApps, Set<Store> storeses) {
       this.idSupermarkets = idSupermarkets;
       this.nameSupermarket = nameSupermarket;
       this.clientsApps = clientsApps;
       this.storeses = storeses;
    }
   
     @Id 
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name="id_supermarkets", unique=true, nullable=false)
    public int getIdSupermarkets() {
        return this.idSupermarkets;
    }
    
    public void setIdSupermarkets(int idSupermarkets) {
        this.idSupermarkets = idSupermarkets;
    }

    
    @Column(name="name_supermarket", nullable=false, length=25)
    public String getNameSupermarket() {
        return this.nameSupermarket;
    }
    
    public void setNameSupermarket(String nameSupermarket) {
        this.nameSupermarket = nameSupermarket;
    }

@ManyToMany(fetch=FetchType.LAZY)
@Fetch(FetchMode.JOIN)
    @JsonIgnore
    @JoinTable(name="CLIENTS_MARKETS", catalog="coswgr6", joinColumns = { 
        @JoinColumn(name="SUPERMARKETS_id", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="CLIENTS_APP_id", nullable=false, updatable=false) })
    public Set<ClientApp> getClientsApps() {
        return this.clientsApps;
    }
    
    public void setClientsApps(Set<ClientApp> clientsApps) {
        this.clientsApps = clientsApps;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @Fetch(FetchMode.JOIN)
    @JsonIgnore
    @JoinColumn(name = "storesSupermarket", nullable = false)
    public Set<Store> getStoreses() {
        return this.storeses;
    }
    
    public void setStoreses(Set<Store> storeses) {
        this.storeses = storeses;
    }




}


