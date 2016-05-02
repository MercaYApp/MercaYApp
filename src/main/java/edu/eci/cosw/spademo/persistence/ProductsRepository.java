/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.spademo.persistence;

import edu.eci.cosw.spademo.model.ClientApp;
import edu.eci.cosw.spademo.model.Product;
import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


/**
 *
 * @author MercaYApp
 */
public interface ProductsRepository extends JpaRepository<Product, Long> {

    /*@Query("from Paciente p where size(p.consultas) >= :n")
    List<Paciente> listaPacientes(@Param(value="n") int n);    */

}
