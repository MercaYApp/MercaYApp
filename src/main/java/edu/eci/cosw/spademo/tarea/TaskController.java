/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.spademo.tarea;

import edu.eci.cosw.spademo.tarea.Tarea;
import edu.eci.cosw.spademo.stub.IStub;
import edu.eci.cosw.spademo.supermarket.Supermarket;
import java.security.Principal;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 2092724
 */
@RestController
@RequestMapping("/tareas")


public class TaskController {
    @Autowired
    IStub stub;
    
    @RequestMapping(method = RequestMethod.GET)
    public List<Tarea> getTarea(){
        if(stub.getTarea().size()>0){
            LOG.info("Agrego tarea 0; "+stub.getTarea().get(stub.getTarea().size()-1).getNombre());
        }
        return stub.getTarea();
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public void postTarea(@RequestBody Tarea tarea){
        stub.postTarea(tarea);
        LOG.info("Agrego tarea; "+tarea.getNombre());
    }
  
    private static final Logger LOG = Logger.getLogger(TaskController.class.getName());

}

