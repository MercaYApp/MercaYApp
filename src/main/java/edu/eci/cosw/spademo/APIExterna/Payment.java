/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.spademo.APIExterna;

/**
 *
 * @author GALVISESPITIADAVIDGU
 */

import edu.eci.cosw.spademo.model.Invoice;
 import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Pago generated by hbm2java
 */
@Entity
@Table(name = "Pagos")
public class Payment implements java.io.Serializable {

    private Integer id;
    private Invoice invoice;
    private boolean aknowledge;
    private String codigo;

    public Payment() {
    }

    public Payment(Invoice invoice, boolean complete, String codigo) {
        this.invoice = invoice;
        this.aknowledge = complete;
        this.codigo = codigo;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "completado", nullable = false)
    public boolean isComplete() {
        return this.aknowledge;
    }

    public void setCompletado(boolean complete) {
        this.aknowledge = complete;
    }

    @Column(name = "codigo", nullable = true)
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setVenta(Invoice invoice) {
        this.invoice = invoice;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_invoices", nullable = false, insertable = true, updatable = false)
    public Invoice getInvoice() {
        return invoice;
    }
}

