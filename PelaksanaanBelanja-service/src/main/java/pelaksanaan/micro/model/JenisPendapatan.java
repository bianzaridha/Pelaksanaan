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
@Table(name="jenis_pendapatan")
public class JenisPendapatan {
    @ManyToOne
    @JoinColumn(name="id_kelompokpendapatan",
                nullable = false, updatable = false)
    @NotNull
    private KelompokPendapatan kelpendapatan;
    
    @Id
    @Column(name = "id_jenispendapatan", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "akun_jenispendapatan")
    private String akun;
    
    @Column(name = "nama_jenispendapatan")
    private String nama;

    public JenisPendapatan(KelompokPendapatan kelpendapatan, Long id, String akun, String nama) {
        this.kelpendapatan = kelpendapatan;
        this.id = id;
        this.akun = akun;
        this.nama = nama;
    }

    public JenisPendapatan() {
    }

    public KelompokPendapatan getKelpendapatan() {
        return kelpendapatan;
    }

    public void setKelpendapatan(KelompokPendapatan kelpendapatan) {
        this.kelpendapatan = kelpendapatan;
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
