package edu.eci.cosw.spademo.model;
// Generated 10-abr-2016 9:50:56 by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ZonesId generated by hbm2java
 */
@Embeddable
public class ZoneId  implements java.io.Serializable {


     private int idZones;
     private int storesIdStores;
     private int storesSuperMarketId;

    public ZoneId() {
    }

    public ZoneId(int idZones, int storesIdStores, int storesSuperMarketId) {
       this.idZones = idZones;
       this.storesIdStores = storesIdStores;
       this.storesSuperMarketId = storesSuperMarketId;
    }
   


    @Column(name="id_zones", nullable=false)
    public int getIdZones() {
        return this.idZones;
    }
    
    public void setIdZones(int idZones) {
        this.idZones = idZones;
    }


    @Column(name="stores_id_stores", nullable=false, insertable=false, updatable=false)
    public int getStoresIdStores() {
        return this.storesIdStores;
    }
    
    public void setStoresIdStores(int storesIdStores) {
        this.storesIdStores = storesIdStores;
    }


    @Column(name="stores_supermarkets_id_supermarkets", nullable=false)
    public int getStoresSuperMarketId() {
        return this.storesSuperMarketId;
    }
    
    public void setStoresSuperMarketId(int storesSuperMarketId) {
        this.storesSuperMarketId = storesSuperMarketId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ZoneId) ) return false;
		 ZoneId castOther = ( ZoneId ) other; 
         
		 return (this.getIdZones()==castOther.getIdZones())
 && (this.getStoresIdStores()==castOther.getStoresIdStores())
 && (this.getStoresSuperMarketId()==castOther.getStoresSuperMarketId());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdZones();
         result = 37 * result + this.getStoresIdStores();
         result = 37 * result + this.getStoresSuperMarketId();
         return result;
   }   


}


