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
@Table(name="rencanakelompok")
public class RencanaKelompok {
    
    @ManyToOne
    @JoinColumn(name="kode_bidang",
                nullable = false, updatable = false)
    @NotNull
    private RencanaBidang rb;
    
    @Id
    @Column(name = "akun_kelompok", nullable = false)
    private String akun;
    
    @Column(name = "nama_kelompok")
    private String nama;

    public RencanaKelompok(RencanaBidang rb, String akun, String nama) {
        this.rb = rb;
        this.akun = akun;
        this.nama = nama;
    }

    public RencanaKelompok() {
    }

    public RencanaBidang getRb() {
        return rb;
    }

    public void setRb(RencanaBidang rb) {
        this.rb = rb;
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
