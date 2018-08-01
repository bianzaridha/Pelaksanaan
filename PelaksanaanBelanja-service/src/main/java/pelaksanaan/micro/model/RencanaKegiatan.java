/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pelaksanaan.micro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author bianza
 */
@Entity
@Table(name="rencanakegiatan")
public class RencanaKegiatan {
    
    @ManyToOne
    @JoinColumn(name="kode_bidang",
                nullable = false, updatable = false)
    @NotNull
    private RencanaBidang rb;
    
    @Id
    @Column(name = "kode_kegiatan", nullable = false)
    private String kode;
    
    @Column(name = "nama_kegiatan")
    private String nama;

    public RencanaKegiatan(RencanaBidang rb, String kode, String nama) {
        this.rb = rb;
        this.kode = kode;
        this.nama = nama;
    }

    public RencanaKegiatan() {
    }

    public RencanaBidang getRb() {
        return rb;
    }

    public void setRb(RencanaBidang rb) {
        this.rb = rb;
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
