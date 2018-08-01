/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pelaksanaan.micro.controller;

import pelaksanaan.micro.model.JenisBelanja;
import pelaksanaan.micro.proxy.KelJenProxy;
import pelaksanaan.micro.service.JenisbelanjaService;
import pelaksanaan.micro.service.KelompokbelanjaService;
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
import pelaksanaan.micro.model.RencanaJenis;
import pelaksanaan.micro.service.RencanaService;

/**
 *
 * @author bianza
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/jenisbelanja")
@Api(value = "JenisBelanjaController" , produces = MediaType.APPLICATION_JSON_VALUE)
@ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = JenisBelanja.class)})
public class JenisbelanjaController {
    
    JenisbelanjaService jbserv = new JenisbelanjaService();
    RencanaService rserv = new RencanaService();
    KelompokbelanjaService kbserv = new KelompokbelanjaService();
    
    @RequestMapping(method = RequestMethod.GET)
    public List<JenisBelanja> getAll(){
        return jbserv.getAll();
    }
    
    @RequestMapping(path = "/rencanajenis/{id:.+}",method = RequestMethod.GET)
    public List<RencanaJenis> getAllRencanaJenis(@PathVariable("id") String id){
        return rserv.getAllJenisByKelompok(id);
    }
    
    @RequestMapping(path = "/kelompok/{id}",method = RequestMethod.GET)
    public List<JenisBelanja> getByKelompok(@PathVariable("id") long id){
        return jbserv.getAllByKelompok(id);
    }
    
    @RequestMapping(path = "/{id}",method = RequestMethod.GET)
    public List<JenisBelanja> getByid(@PathVariable("id") long id){
        return jbserv.findById(id);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public JenisBelanja insert(@RequestBody KelJenProxy kjop){
        JenisBelanja jb = new JenisBelanja(
                        kbserv.findById(kjop.getId_parent()).get(0),
                        kjop.getId(),
                        kjop.getAkun(),
                        kjop.getNama());
        
        
        jbserv.save(jb);
        return jb;
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public String update(@RequestBody JenisBelanja jb){
        jbserv.update(jb);
        return "updated";
    }
    
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String delete(@PathVariable("id") long id){
        jbserv.delete(jbserv.findById(id).get(0));
        
        return "Jenis Belanja with id "+ id +" deleted";
    }
    
}
