/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pelaksanaan.micro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author bianza
 */
@Entity
@Table(name="rencanabidang")
public class RencanaBidang {
    
    @Id
    @Column(name = "kode_bidang", nullable = false)
    private String kode;
    
    @Column(name = "nama_bidang")
    private String nama;
    
    @Column(name = "jenis_bidang")
    private Integer jenis;

    public RencanaBidang(String kode, String nama, Integer jenis) {
        this.kode = kode;
        this.nama = nama;
        this.jenis = jenis;
    }

    public RencanaBidang() {
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

    public Integer getJenis() {
        return jenis;
    }

    public void setJenis(Integer jenis) {
        this.jenis = jenis;
    }
}
