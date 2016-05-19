/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.spademo.APIExterna;

import org.springframework.data.jpa.repository.JpaRepository;
import edu.eci.cosw.spademo.APIExterna.Payment;
import java.util.List;
/**
 *
 * @author GALVISESPITIADAVIDGU
 */
public interface StubPaymentClient  {
   
    void registerPayment(Payment payment);
    String comfirmPayment(String json);
}
