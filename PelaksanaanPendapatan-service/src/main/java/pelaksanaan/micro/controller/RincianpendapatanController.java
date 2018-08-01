/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pelaksanaan.micro.controller;

import pelaksanaan.micro.model.RincianPendapatan;
import pelaksanaan.micro.proxy.RincianProxy;
import pelaksanaan.micro.service.ObyekpendapatanService;
import pelaksanaan.micro.service.RincianpendapatanService;
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
@RequestMapping(path = "/rincianpendapatan")
@Api(value = "RincianPendapatanController" , produces = MediaType.APPLICATION_JSON_VALUE)
@ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = RincianPendapatan.class)})
public class RincianpendapatanController {
    
    RincianpendapatanService rpenserv = new RincianpendapatanService();
    ObyekpendapatanService openserv = new ObyekpendapatanService();
    
    @RequestMapping(method = RequestMethod.GET)
    public List<RincianPendapatan> getAll(){
        return rpenserv.getAll();
    }
    
    @RequestMapping(path = "/obyek/{id}",method = RequestMethod.GET)
    public List<RincianPendapatan> getByObyek(@PathVariable("id") long id){
        return rpenserv.getAllByObyek(id);
    }
    
    @RequestMapping(path = "/{id}",method = RequestMethod.GET)
    public List<RincianPendapatan> getByid(@PathVariable("id") long id){
        return rpenserv.findById(id);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public RincianPendapatan insert(@RequestBody RincianProxy rp){
        Long jumtot = rp.getJumlah() * rp.getHs();
        RincianPendapatan rpen = new RincianPendapatan(
                        openserv.findById(rp.getId_parent()).get(0),
                        rp.getId(),
                        rp.getNorut(),
                        rp.getUraian(),
                        rp.getJumlah(),
                        rp.getSatuan(),
                        rp.getHs(),
                        rp.getSumberdana(),
                        jumtot);
        
        
        rpenserv.save(rpen);
        return rpen;
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public String update(@RequestBody RincianPendapatan rpen){
        rpenserv.update(rpen);
        return "updated";
    }
    
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String delete(@PathVariable("id") long id){
        rpenserv.delete(rpenserv.findById(id).get(0));
        
        return "Rincian Pendapatan with id "+ id +" deleted";
    }
    
}
