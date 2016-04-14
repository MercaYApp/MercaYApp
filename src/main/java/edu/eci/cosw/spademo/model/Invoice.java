package edu.eci.cosw.spademo.model;
// Generated 10-abr-2016 9:50:56 by Hibernate Tools 4.3.1


import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
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
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * Invoices generated by hbm2java
 */
@Entity
@Table(name="invoices")
public class Invoice  implements java.io.Serializable {


     private int idInvoices;
     private Date dateInvoice;
     private Set<Product> productses = new HashSet<>(0);
    public Invoice() {
    }

	
    public Invoice(int idInvoices, Date dateInvoice) {
        this.idInvoices = idInvoices;
        this.dateInvoice = dateInvoice;
    }
    public Invoice(int idInvoices, Date dateInvoice, Set<Product>  productses) {
       this.idInvoices = idInvoices;
       this.dateInvoice = dateInvoice;
       this.productses = productses;
    }
   
    @Id
    //@GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Column(name="id_invoices", unique=true, nullable=false)
    public int getIdInvoices() {
        return this.idInvoices;
    }
    
    public void setIdInvoices(int idInvoices) {
        this.idInvoices = idInvoices;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="date_invoice", nullable=false, length=10)
    public Date getDateInvoice() {
        return this.dateInvoice;
    }
    
    public void setDateInvoice(Date dateInvoice) {
        this.dateInvoice = dateInvoice;
    }

    @ManyToMany
    @Fetch(FetchMode.JOIN)

    @JoinTable(name="LINE_INVOICE", joinColumns = { 
        @JoinColumn(name="INVOICES_id_invoices", nullable = false)}, inverseJoinColumns = { 
        @JoinColumn(name="PRODUCTS_id_productos", nullable = false, insertable=false, updatable=false) })

    public Set<Product> getProductses() {
        return this.productses;
    }
    
    public void setProductses(Set<Product> productses) {
        this.productses = productses;
    }
    
}


