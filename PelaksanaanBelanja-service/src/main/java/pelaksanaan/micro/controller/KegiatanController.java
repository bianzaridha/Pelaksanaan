/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pelaksanaan.micro.controller;

import pelaksanaan.micro.model.Kegiatan;
import pelaksanaan.micro.proxy.KegiatanProxy;
import pelaksanaan.micro.service.BidangService;
import pelaksanaan.micro.service.KegiatanService;
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
import pelaksanaan.micro.model.RencanaKegiatan;
import pelaksanaan.micro.service.RencanaService;

/**
 *
 * @author bianza
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/kegiatan")
@Api(value = "KegiatanController" , produces = MediaType.APPLICATION_JSON_VALUE)
@ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Kegiatan.class)})
public class KegiatanController {
    
    KegiatanService kserv = new KegiatanService();
    RencanaService rserv = new RencanaService();
    BidangService bserv = new BidangService();
    
    @RequestMapping(method = RequestMethod.GET)
    public List<Kegiatan> getAll(){
        return kserv.getAll();
    }
    
    @RequestMapping(path = "/bidang/{id}",method = RequestMethod.GET)
    public List<Kegiatan> getByBidang(@PathVariable("id") long id){
        return kserv.getAllByBidang(id);
    }
    
    @RequestMapping(path = "/rencanakegiatan/{id:.+}",method = RequestMethod.GET)
    public List<RencanaKegiatan> getAllRencanaKegiatan(@PathVariable("id") String id){
        return rserv.getAllKegiatanByBidang(id);
    }
    
    @RequestMapping(path = "/{id}",method = RequestMethod.GET)
    public List<Kegiatan> getByid(@PathVariable("id") long id){
        return kserv.findById(id);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public Kegiatan insert(@RequestBody KegiatanProxy kp){
        Kegiatan keg = new Kegiatan(bserv.findById(kp.getId_bidang()).get(0),
                        kp.getId(),
                        kp.getKode(),
                        kp.getNama(),
                        kp.getWaktu(),
                        kp.getNama_pptkd(),
                        kp.getKeluaran());
        
        
        kserv.save(keg);
        return keg;
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public String update(@RequestBody Kegiatan keg){
        kserv.update(keg);
        return "updated";
    }
    
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String delete(@PathVariable("id") long id){
        kserv.delete(kserv.findById(id).get(0));
        
        return "Kegiatan with id "+ id +" deleted";
    }
    
}
