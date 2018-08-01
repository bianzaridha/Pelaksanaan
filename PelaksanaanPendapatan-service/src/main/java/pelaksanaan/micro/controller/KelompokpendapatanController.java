/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pelaksanaan.micro.controller;

import pelaksanaan.micro.model.KelompokPendapatan;
import pelaksanaan.micro.proxy.KelJenProxy;
import pelaksanaan.micro.service.PelaksanaanService;
import pelaksanaan.micro.service.BidangService;
import pelaksanaan.micro.service.KelompokpendapatanService;
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
@RequestMapping(path = "/kelompokpendapatan")
@Api(value = "KelompokPendapatanController" , produces = MediaType.APPLICATION_JSON_VALUE)
@ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = KelompokPendapatan.class)})
public class KelompokpendapatanController {
    
    KelompokpendapatanService kpserv = new KelompokpendapatanService();
    RencanaService rserv = new RencanaService();
    BidangService bserv = new BidangService();
    
    @RequestMapping(method = RequestMethod.GET)
    public List<KelompokPendapatan> getAll(){
        return kpserv.getAll();
    }
    
    @RequestMapping(path = "/rencanakelompok/{id:.+}",method = RequestMethod.GET)
    public List<RencanaKelompok> getAllRencanaKelompok(@PathVariable("id") String id){
        return rserv.getAllKelompokByBidang(id);
    }
    
    @RequestMapping(path = "/{id}",method = RequestMethod.GET)
    public List<KelompokPendapatan> getByid(@PathVariable("id") long id){
        return kpserv.findById(id);
    }
    
    @RequestMapping(path = "/bidang/{id}",method = RequestMethod.GET)
    public List<KelompokPendapatan> getByBidang(@PathVariable("id") long id){
        return kpserv.getAllByBidang(id);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public KelompokPendapatan insert(@RequestBody KelJenProxy kjop){
        KelompokPendapatan kp = new KelompokPendapatan(
                        bserv.findById(kjop.getId_parent()).get(0),
                        kjop.getId(),
                        kjop.getAkun(),
                        kjop.getNama());
        
        
        kpserv.save(kp);
        return kp;
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public String update(@RequestBody KelompokPendapatan kp){
        kpserv.update(kp);
        return "updated";
    }
    
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String delete(@PathVariable("id") long id){
        kpserv.delete(kpserv.findById(id).get(0));
        
        return "Kelompok Pendapatan with id "+ id +" deleted";
    }
    
}
