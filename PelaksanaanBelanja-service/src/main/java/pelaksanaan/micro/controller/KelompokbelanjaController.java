/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pelaksanaan.micro.controller;

import pelaksanaan.micro.model.KelompokBelanja;
import pelaksanaan.micro.proxy.KelJenProxy;
import pelaksanaan.micro.service.PelaksanaanService;
import pelaksanaan.micro.service.KegiatanService;
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
import pelaksanaan.micro.model.RencanaKelompok;
import pelaksanaan.micro.service.RencanaService;

/**
 *
 * @author bianza
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/kelompokbelanja")
@Api(value = "KelompokBelanjaController" , produces = MediaType.APPLICATION_JSON_VALUE)
@ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = KelompokBelanja.class)})
public class KelompokbelanjaController {
    
    KelompokbelanjaService kbserv = new KelompokbelanjaService();
    RencanaService rserv = new RencanaService();
    KegiatanService kegserv = new KegiatanService();
    
    @RequestMapping(method = RequestMethod.GET)
    public List<KelompokBelanja> getAll(){
        return kbserv.getAll();
    }
    
    @RequestMapping(path = "/rencanakelompok/{id:.+}",method = RequestMethod.GET)
    public List<RencanaKelompok> getAllRencanaKelompok(@PathVariable("id") String id){
        return rserv.getAllKelompokByBidang(id);
    }
    
    @RequestMapping(path = "/kegiatan/{id}",method = RequestMethod.GET)
    public List<KelompokBelanja> getByKegiatan(@PathVariable("id") long id){
        return kbserv.getAllByKegiatan(id);
    }
    
    @RequestMapping(path = "/{id}",method = RequestMethod.GET)
    public List<KelompokBelanja> getByid(@PathVariable("id") long id){
        return kbserv.findById(id);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public KelompokBelanja insert(@RequestBody KelJenProxy kbp){
        KelompokBelanja kb = new KelompokBelanja(
                        kegserv.findById(kbp.getId_parent()).get(0),
                        kbp.getId(),
                        kbp.getAkun(),
                        kbp.getNama());
        
        
        kbserv.save(kb);
        return kb;
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public String update(@RequestBody KelompokBelanja kb){
        kbserv.update(kb);
        return "updated";
    }
    
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String delete(@PathVariable("id") long id){
        kbserv.delete(kbserv.findById(id).get(0));
        
        return "Kelompok Belanja with id "+ id +" deleted";
    }
    
}
