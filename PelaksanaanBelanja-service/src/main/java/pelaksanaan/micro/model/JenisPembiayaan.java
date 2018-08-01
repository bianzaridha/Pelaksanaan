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
@Table(name="jenis_pembiayaan")
public class JenisPembiayaan {
    @ManyToOne
    @JoinColumn(name="id_kelompokpembiayaan",
                nullable = false, updatable = false)
    @NotNull
    private KelompokPembiayaan kelpembiayaan;
    
    @Id
    @Column(name = "id_jenispembiayaan", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "akun_jenispembiayaan")
    private String akun;
    
    @Column(name = "nama_jenispembiayaan")
    private String nama;

    public JenisPembiayaan(KelompokPembiayaan kelpembiayaan, Long id, String akun, String nama) {
        this.kelpembiayaan = kelpembiayaan;
        this.id = id;
        this.akun = akun;
        this.nama = nama;
    }

    public JenisPembiayaan() {
    }

    public KelompokPembiayaan getKelpembiayaan() {
        return kelpembiayaan;
    }

    public void setKelpembiayaan(KelompokPembiayaan kelpembiayaan) {
        this.kelpembiayaan = kelpembiayaan;
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
