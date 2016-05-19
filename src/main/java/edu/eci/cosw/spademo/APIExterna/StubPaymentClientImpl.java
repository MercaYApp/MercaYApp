/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.spademo.APIExterna;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author GALVISESPITIADAVIDGU
 */
public class StubPaymentClientImpl implements StubPaymentClient {

     @Autowired
    PaymentRepository repositoryP;

    @Override
    public void registerPayment(Payment payment) {
        repositoryP.save(payment);
    }

    @Override
    public String comfirmPayment(String json) {
      RestTemplate restTemplate = new RestTemplate();
        String url = "http://paymentsgateway.herokuapp.com/rest/payments";
        String requestJson = json;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(requestJson, headers);
        String answer;
        try {
            answer = restTemplate.postForObject(url, entity, String.class);
        } catch (HttpClientErrorException e) {
            answer="";
        }

        System.out.println(answer);
        return answer;
    }
    
}
