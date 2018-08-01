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
@Table(name="rencanajenis")
public class RencanaJenis {
    
    @ManyToOne
    @JoinColumn(name="akun_kelompok",
                nullable = false, updatable = false)
    @NotNull
    private RencanaKelompok rk;
    
    @Id
    @Column(name = "akun_jenis", nullable = false)
    private String akun;
    
    @Column(name = "nama_jenis")
    private String nama;

    public RencanaJenis(RencanaKelompok rk, String akun, String nama) {
        this.rk = rk;
        this.akun = akun;
        this.nama = nama;
    }

    public RencanaJenis() {
    }

    public RencanaKelompok getRk() {
        return rk;
    }

    public void setRk(RencanaKelompok rk) {
        this.rk = rk;
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
