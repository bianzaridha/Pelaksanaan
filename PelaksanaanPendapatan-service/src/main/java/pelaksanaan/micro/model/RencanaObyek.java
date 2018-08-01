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
@Table(name="rencanaobyek")
public class RencanaObyek {
    
    @ManyToOne
    @JoinColumn(name="akun_jenis",
                nullable = false, updatable = false)
    @NotNull
    private RencanaJenis rj;
    
    @Id
    @Column(name = "akun_obyek", nullable = false)
    private String akun;
    
    @Column(name = "nama_obyek")
    private String nama;

    public RencanaObyek(RencanaJenis rj, String akun, String nama) {
        this.rj = rj;
        this.akun = akun;
        this.nama = nama;
    }

    public RencanaObyek() {
    }

    public RencanaJenis getRj() {
        return rj;
    }

    public void setRj(RencanaJenis rj) {
        this.rj = rj;
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
