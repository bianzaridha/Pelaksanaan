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
@Table(name="jenis_belanja")
public class JenisBelanja {
    
    @ManyToOne
    @JoinColumn(name="id_kelompokbelanja",
                nullable = false, updatable = false)
    @NotNull
    private KelompokBelanja kelbelanja;
    
    @Id
    @Column(name = "id_jenisbelanja", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "akun_jenisbelanja")
    private String akun;
    
    @Column(name = "nama_jenisbelanja")
    private String nama;

    public JenisBelanja(KelompokBelanja kelbelanja, Long id, String akun, String nama) {
        this.kelbelanja = kelbelanja;
        this.id = id;
        this.akun = akun;
        this.nama = nama;
    }

    public JenisBelanja() {
    }

    public KelompokBelanja getKelbelanja() {
        return kelbelanja;
    }

    public void setKelbelanja(KelompokBelanja kelbelanja) {
        this.kelbelanja = kelbelanja;
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
