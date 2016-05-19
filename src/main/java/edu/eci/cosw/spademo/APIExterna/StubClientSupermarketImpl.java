/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.spademo.APIExterna;

import edu.eci.cosw.spademo.APIExterna.ClientAPI;
import edu.eci.cosw.spademo.APIExterna.StubClientSupermarket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author GALVISESPITIADAVIDGU
 */
public class StubClientSupermarketImpl implements StubClientSupermarket {

    private List<String> clientes = new ArrayList<>();
    
    @Override
    public ClientAPI validarCliente(String codigo) {      
        RestTemplate rt = new RestTemplate();
        Map<String, String> vars = new HashMap<String, String>();
        vars.put("nit", "nit");
        ClientAPI respuesta = rt.getForObject("https://damp-dusk-55729.herokuapp.com/rest/peticiones/proveedoresysupermecados/332351289-0/{clientes}", ClientAPI.class, codigo);
        return respuesta;
    }
    
}
