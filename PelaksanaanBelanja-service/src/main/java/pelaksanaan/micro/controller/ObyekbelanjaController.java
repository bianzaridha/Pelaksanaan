/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pelaksanaan.micro.controller;

import pelaksanaan.micro.model.ObyekBelanja;
import pelaksanaan.micro.proxy.ObyekProxy;
import pelaksanaan.micro.service.JenisbelanjaService;
import pelaksanaan.micro.service.ObyekbelanjaService;
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
import pelaksanaan.micro.model.RencanaObyek;
import pelaksanaan.micro.service.RencanaService;

/**
 *
 * @author bianza
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/obyekbelanja")
@Api(value = "ObyekBelanjaController" , produces = MediaType.APPLICATION_JSON_VALUE)
@ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = ObyekBelanja.class)})
public class ObyekbelanjaController {
    
    JenisbelanjaService jbserv = new JenisbelanjaService();
    RencanaService rserv = new RencanaService();
    ObyekbelanjaService observ = new ObyekbelanjaService();
    
    @RequestMapping(method = RequestMethod.GET)
    public List<ObyekBelanja> getAll(){
        return observ.getAll();
    }
    
    @RequestMapping(path = "/rencanaobyek/{id:.+}",method = RequestMethod.GET)
    public List<RencanaObyek> getAllRencanaObyek(@PathVariable("id") String id){
        return rserv.getAllObyekByJenis(id);
    }
    
    @RequestMapping(path = "/jenis/{id}",method = RequestMethod.GET)
    public List<ObyekBelanja> getByJenis(@PathVariable("id") long id){
        return observ.getAllByJenis(id);
    }
    
    @RequestMapping(path = "/{id}",method = RequestMethod.GET)
    public List<ObyekBelanja> getByid(@PathVariable("id") long id){
        return observ.findById(id);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ObyekBelanja insert(@RequestBody ObyekProxy kjop){
        ObyekBelanja ob = new ObyekBelanja(
                        jbserv.findById(kjop.getId_parent()).get(0),
                        kjop.getId(),
                        kjop.getAkun(),
                        kjop.getNama(),
                        kjop.getAnggaran());
        
        
        observ.save(ob);
        return ob;
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public String update(@RequestBody ObyekBelanja ob){
        observ.update(ob);
        return "updated";
    }
    
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String delete(@PathVariable("id") long id){
        observ.delete(observ.findById(id).get(0));
        
        return "Obyek Belanja with id "+ id +" deleted";
    }
    
    
}
