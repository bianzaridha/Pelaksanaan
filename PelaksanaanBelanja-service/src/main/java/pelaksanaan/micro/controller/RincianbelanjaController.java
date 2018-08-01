/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pelaksanaan.micro.controller;

import pelaksanaan.micro.model.RincianBelanja;
import pelaksanaan.micro.proxy.RincianProxy;
import pelaksanaan.micro.service.ObyekbelanjaService;
import pelaksanaan.micro.service.RincianbelanjaService;
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
@RequestMapping(path = "/rincianbelanja")
@Api(value = "RincianBelanjaController" , produces = MediaType.APPLICATION_JSON_VALUE)
@ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = RincianBelanja.class)})
public class RincianbelanjaController {
    
    RincianbelanjaService rbserv = new RincianbelanjaService();
    ObyekbelanjaService observ = new ObyekbelanjaService();
    
    @RequestMapping(method = RequestMethod.GET)
    public List<RincianBelanja> getAll(){
        return rbserv.getAll();
    }
    
    @RequestMapping(path = "/obyek/{id}",method = RequestMethod.GET)
    public List<RincianBelanja> getByObyek(@PathVariable("id") long id){
        return rbserv.getAllByObyek(id);
    }
    
    @RequestMapping(path = "/{id}",method = RequestMethod.GET)
    public List<RincianBelanja> getByid(@PathVariable("id") long id){
        return rbserv.findById(id);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public RincianBelanja insert(@RequestBody RincianProxy rp){
        Long jumtot = rp.getJumlah() * rp.getHs();
        RincianBelanja rb = new RincianBelanja(
                        observ.findById(rp.getId_parent()).get(0),
                        rp.getId(),
                        rp.getNorut(),
                        rp.getUraian(),
                        rp.getJumlah(),
                        rp.getSatuan(),
                        rp.getHs(),
                        rp.getSumberdana(),
                        jumtot);
        
        
        rbserv.save(rb);
        return rb;
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public String update(@RequestBody RincianBelanja rb){
        rbserv.update(rb);
        return "updated";
    }
    
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String delete(@PathVariable("id") long id){
        rbserv.delete(rbserv.findById(id).get(0));
        
        return "Rincian Belanja with id "+ id +" deleted";
    }
    
}
