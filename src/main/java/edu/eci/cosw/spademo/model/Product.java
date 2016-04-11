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
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * Products generated by hbm2java
 */
@Entity
@Table(name = "PRODUCTS")
public class Product implements java.io.Serializable {

    private int idProductos;
    private Zone zones;
    private String nameProduct;
    private int buyPrice;
    private int percentage;
    private int weight;
    private Set<Invoice> invoiceses = new HashSet<>(0);

    public Product() {
    }

    public Product(int idProductos, Zone zones, String nameProduct, int buyPrice, int percentage, int weight) {
        this.idProductos = idProductos;
        this.zones = zones;
        this.nameProduct = nameProduct;
        this.buyPrice = buyPrice;
        this.percentage = percentage;
        this.weight = weight;
    }

    public Product(int idProductos, Zone zones, String nameProduct, int buyPrice, int percentage, int weight, Set<Invoice> invoiceses) {
        this.idProductos = idProductos;
        this.zones = zones;
        this.nameProduct = nameProduct;
        this.buyPrice = buyPrice;
        this.percentage = percentage;
        this.weight = weight;
        this.invoiceses = invoiceses;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_productos", unique = true, nullable = false)
    public int getIdProductos() {
        return this.idProductos;
    }

    public void setIdProductos(int idProductos) {
        this.idProductos = idProductos;
    }

  

    @Column(name = "name_product", nullable = false, length = 25)
    public String getNameProduct() {
        return this.nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    @Column(name = "buyPrice", nullable = false)
    public int getBuyPrice() {
        return this.buyPrice;
    }

    public void setBuyPrice(int buyPrice) {
        this.buyPrice = buyPrice;
    }

    @Column(name = "Percentage", nullable = false)
    public int getPercentage() {
        return this.percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    @Column(name = "weight", nullable = false)
    public int getWeight() {
        return this.weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @ManyToMany(mappedBy = "productses")    
    @Fetch(FetchMode.JOIN)
    @JsonIgnore
    /*@JoinTable(name = "LINE_INVOICE", catalog = "coswgr6", joinColumns = {
        @JoinColumn(name = "PRODUCTS_id_productos", nullable = false, updatable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "INVOICES_id_invoices", nullable = false, updatable = false)})
    */
    public Set<Invoice> getInvoiceses() {
        return this.invoiceses;
    }

    public void setInvoiceses(Set<Invoice> invoiceses) {
        this.invoiceses = invoiceses;
    }

}
