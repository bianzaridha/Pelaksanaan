/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pelaksanaan.micro.controller;

import pelaksanaan.micro.model.Pelaksanaan;
import pelaksanaan.micro.service.PelaksanaanService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author bianza
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/pelaksanaan")
@Api(value = "PelaksanaanController" , produces = MediaType.APPLICATION_JSON_VALUE)
@ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Pelaksanaan.class)})
public class PelaksanaanController {
    
    PelaksanaanService pelaksanaanserv = new PelaksanaanService();
    
    @RequestMapping(method = RequestMethod.GET)
    public List<Pelaksanaan> getAll(){
        return pelaksanaanserv.getAll();
    }
    
    @RequestMapping(path = "/desa/{id}",method = RequestMethod.GET)
    public List<Pelaksanaan> getByRpjm(@PathVariable("id") long id){
        return pelaksanaanserv.getAllByDesa(id);
    }
    
    @RequestMapping(path = "/{id}",method = RequestMethod.GET)
    public List<Pelaksanaan> getByid(@PathVariable("id") long id){
        return pelaksanaanserv.findById(id);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public Pelaksanaan insert(@RequestBody Pelaksanaan ap){
        
        pelaksanaanserv.save(ap);
        return ap;
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public String update(@RequestBody Pelaksanaan ap){
        pelaksanaanserv.update(ap);
        return "updated";
    }
    
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String delete(@PathVariable("id") long id){
        pelaksanaanserv.delete(pelaksanaanserv.findById(id).get(0));
        
        return "Pelaksanaan with id "+ id +" deleted";
    }
    
    @RequestMapping(path = "/desa/{id}", method = RequestMethod.DELETE)
    public String deleteByDesa(@PathVariable("id") long id){
        pelaksanaanserv.batchDeleteByDesa(id);
        
        return "Pelaksanaan with id Desa "+ id +" deleted";
    }
    
}
