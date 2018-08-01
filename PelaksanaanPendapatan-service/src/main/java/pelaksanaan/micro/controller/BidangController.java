/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pelaksanaan.micro.controller;

import pelaksanaan.micro.model.Bidang;
import pelaksanaan.micro.proxy.BidangProxy;
import pelaksanaan.micro.service.PelaksanaanService;
import pelaksanaan.micro.service.BidangService;
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
import pelaksanaan.micro.model.RencanaBidang;
import pelaksanaan.micro.service.RencanaService;

/**
 *
 * @author bianza
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/bidang")
@Api(value = "BidangController" , produces = MediaType.APPLICATION_JSON_VALUE)
@ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Bidang.class)})
public class BidangController {
    
    BidangService bserv = new BidangService();
    RencanaService rserv = new RencanaService();
    PelaksanaanService pelaksanaanserv = new PelaksanaanService();
    
    @RequestMapping(method = RequestMethod.GET)
    public List<Bidang> getAll(){
        return bserv.getAll();
    }
    
    @RequestMapping(path = "/rencanabidang",method = RequestMethod.GET)
    public List<RencanaBidang> getAllRencanaBidang(){
        return rserv.getAllBidang();
    }
    
    @RequestMapping(path = "/pelaksanaan/{id}",method = RequestMethod.GET)
    public List<Bidang> getByPelaksanaan(@PathVariable("id") long id){
        return bserv.getAllByPelaksanaan(id);
    }
    
    @RequestMapping(path = "/jenis/pelaksanaan/{jenis}/{id}",method = RequestMethod.GET)
    public List<Bidang> getByJenisdanPelaksanaan(@PathVariable("jenis") Integer jenis, @PathVariable("id") Long id){
        return bserv.getAllByJenisdanPelaksanaan(jenis, id);
    }
    
    @RequestMapping(path = "/{id}",method = RequestMethod.GET)
    public List<Bidang> getByid(@PathVariable("id") long id){
        return bserv.findById(id);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public Bidang insert(@RequestBody BidangProxy bp){
        Bidang bid = new Bidang(
                        pelaksanaanserv.findById(bp.getId_pelaksanaan()).get(0),
                        bp.getId(),
                        bp.getKode(),
                        bp.getNama(),
                        bp.getJenis());
        
        
        bserv.save(bid);
        return bid;
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public String update(@RequestBody Bidang bid){
        bserv.update(bid);
        return "updated";
    }
    
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String delete(@PathVariable("id") long id){
        bserv.delete(bserv.findById(id).get(0));
        
        return "Bidang with id "+ id +" deleted";
    }
    
    
}
