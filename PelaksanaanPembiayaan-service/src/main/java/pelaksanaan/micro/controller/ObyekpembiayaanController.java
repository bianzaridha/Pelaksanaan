/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pelaksanaan.micro.controller;

import pelaksanaan.micro.model.ObyekPembiayaan;
import pelaksanaan.micro.proxy.ObyekProxy;
import pelaksanaan.micro.service.JenispembiayaanService;
import pelaksanaan.micro.service.ObyekpembiayaanService;
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
@RequestMapping(path = "/obyekpembiayaan")
@Api(value = "ObyekPembiayaanController" , produces = MediaType.APPLICATION_JSON_VALUE)
@ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = ObyekPembiayaan.class)})
public class ObyekpembiayaanController {
    
    JenispembiayaanService jpemserv = new JenispembiayaanService();
    ObyekpembiayaanService openserv = new ObyekpembiayaanService();
    RencanaService rserv = new RencanaService();
    
    @RequestMapping(method = RequestMethod.GET)
    public List<ObyekPembiayaan> getAll(){
        return openserv.getAll();
    }
    
    @RequestMapping(path = "/rencanaobyek/{id:.+}",method = RequestMethod.GET)
    public List<RencanaObyek> getAllRencanaObyek(@PathVariable("id") String id){
        return rserv.getAllObyekByJenis(id);
    }
    
    @RequestMapping(path = "/jenis/{id}",method = RequestMethod.GET)
    public List<ObyekPembiayaan> getByJenis(@PathVariable("id") long id){
        return openserv.getAllByJenis(id);
    }
    
    @RequestMapping(path = "/{id}",method = RequestMethod.GET)
    public List<ObyekPembiayaan> getByid(@PathVariable("id") long id){
        return openserv.findById(id);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ObyekPembiayaan insert(@RequestBody ObyekProxy kjop){
        ObyekPembiayaan open = new ObyekPembiayaan(
                        jpemserv.findById(kjop.getId_parent()).get(0),
                        kjop.getId(),
                        kjop.getAkun(),
                        kjop.getNama(),
                        kjop.getAnggaran());
        
        
        openserv.save(open);
        return open;
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public String update(@RequestBody ObyekPembiayaan open){
        openserv.update(open);
        return "updated";
    }
    
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String delete(@PathVariable("id") long id){
        openserv.delete(openserv.findById(id).get(0));
        
        return "Obyek Pembiayaan with id "+ id +" deleted";
    }
    
    
}
