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
@Table(name="kelompok_pendapatan")
public class KelompokPendapatan {
    
    @ManyToOne
    @JoinColumn(name="id_bidang",
                nullable = false, updatable = false)
    @NotNull
    private Bidang bidang;
    
    @Id
    @Column(name = "id_kelompokpendapatan", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "akun_kelompokpendapatan")
    private String akun;
    
    @Column(name = "nama_kelompokpendapatan")
    private String nama;
    

    public KelompokPendapatan(Bidang bidang, Long id, String akun, String nama) {
        this.bidang = bidang;
        this.id = id;
        this.akun = akun;
        this.nama = nama;
    }

    public KelompokPendapatan() {
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

    public String getAkun() {
        return akun;
    }

    public void setAkun(String akun) {
        this.akun = akun;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

}
