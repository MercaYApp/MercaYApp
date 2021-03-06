package edu.eci.cosw.spademo.model;
// Generated 10-abr-2016 9:50:56 by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * StoresId generated by hbm2java
 */
@Embeddable
public class StoreId  implements java.io.Serializable {


     private int idStores;
     private int superMarketId;

    public StoreId() {
    }

    public StoreId(int idStores, int superMarketId) {
       this.idStores = idStores;
       this.superMarketId = superMarketId;
    }
   


    @Column(name="id_stores", insertable = false, updatable = false)
    public int getIdStores() {
        return this.idStores;
    }
    
    public void setIdStores(int idStores) {
        this.idStores = idStores;
    }


    @Column(name="supermarkets_id_supermarkets", insertable = false, updatable = false)
    public int getSuperMarketId() {
        return this.superMarketId;
    }
    
    public void setSuperMarketId(int superMarketId) {
        this.superMarketId = superMarketId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof StoreId) ) return false;
		 StoreId castOther = ( StoreId ) other; 
         
		 return (this.getIdStores()==castOther.getIdStores())
 && (this.getSuperMarketId()==castOther.getSuperMarketId());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdStores();
         result = 37 * result + this.getSuperMarketId();
         return result;
   }   


}


