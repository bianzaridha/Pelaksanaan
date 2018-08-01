/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pelaksanaan.micro.proxy;

/**
 *
 * @author bianza
 */
public class BidangProxy {
    
    private Long id_pelaksanaan;
    
    private Long id;
    
    private String kode;
    
    private String nama;
    
    private Integer jenis;

    public Integer getJenis() {
        return jenis;
    }

    public void setJenis(Integer jenis) {
        this.jenis = jenis;
    }
    
    

    public Long getId_pelaksanaan() {
        return id_pelaksanaan;
    }

    public void setId_pelaksanaan(Long id_pelaksanaan) {
        this.id_pelaksanaan = id_pelaksanaan;
    }

    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    
    
    
}
