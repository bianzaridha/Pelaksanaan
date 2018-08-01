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
@Table(name="obyek_pembiayaan")
public class ObyekPembiayaan {
    
    @ManyToOne
    @JoinColumn(name="id_jenispembiayaan",
                nullable = false, updatable = false)
    @NotNull
    private JenisPembiayaan jenpembiayaan;
    
    @Id
    @Column(name = "id_obyekpembiayaan", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "akun_obyekpembiayaan")
    private String akun;
    
    @Column(name = "nama_obyekpembiayaan")
    private String nama;
    
    @Column(name = "anggaran")
    private  Long anggaran;

    public ObyekPembiayaan(JenisPembiayaan jenpembiayaan, Long id, String akun, String nama, Long anggaran) {
        this.jenpembiayaan = jenpembiayaan;
        this.id = id;
        this.akun = akun;
        this.nama = nama;
        this.anggaran = anggaran;
    }

    public ObyekPembiayaan() {
    }
    

    public JenisPembiayaan getJenpembiayaan() {
        return jenpembiayaan;
    }

    public void setJenpembiayaan(JenisPembiayaan jenpembiayaan) {
        this.jenpembiayaan = jenpembiayaan;
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

    public Long getAnggaran() {
        return anggaran;
    }

    public void setAnggaran(Long anggaran) {
        this.anggaran = anggaran;
    }
}
