/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pelaksanaan.micro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name="kegiatan")
public class Kegiatan {
    
    @ManyToOne
    @JoinColumn(name="id_bidang",
                nullable = false, updatable = false)
    @NotNull
    private Bidang bidang;
    
    @Id
    @Column(name = "id_kegiatan", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "kode_kegiatan")
    private String kode;
    
    @Column(name = "nama_kegiatan")
    private String nama;
    
    @Column(name = "waktu")
    private String waktu;
    
    @Column(name = "nama_pptkd")
    private String nama_pptkd;
    
    @Column(name = "keluaran")
    private String keluaran;

    public Kegiatan(Bidang bidang, Long id, String kode, String nama, String waktu, String nama_pptkd, String keluaran) {
        this.bidang = bidang;
        this.id = id;
        this.kode = kode;
        this.nama = nama;
        this.waktu = waktu;
        this.nama_pptkd = nama_pptkd;
        this.keluaran = keluaran;
    }

    public Kegiatan() {
    }

    public Bidang getBidang() {
        return bidang;
    }

    public void setBidang(Bidang bidang) {
        this.bidang = bidang;
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

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public String getNama_pptkd() {
        return nama_pptkd;
    }

    public void setNama_pptkd(String nama_pptkd) {
        this.nama_pptkd = nama_pptkd;
    }

    public String getKeluaran() {
        return keluaran;
    }

    public void setKeluaran(String keluaran) {
        this.keluaran = keluaran;
    }
}
