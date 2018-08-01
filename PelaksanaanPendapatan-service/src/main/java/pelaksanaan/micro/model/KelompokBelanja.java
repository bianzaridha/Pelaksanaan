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
@Table(name="kelompok_belanja")
public class KelompokBelanja {
    
    @ManyToOne
    @JoinColumn(name="id_kegiatan",
                nullable = false, updatable = false)
    @NotNull
    private Kegiatan kegiatan;
    
    @Id
    @Column(name = "id_kelompokbelanja", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "akun_kelompokbelanja")
    private String akun;
    
    @Column(name = "nama_kelompokbelanja")
    private String nama;
    

    public KelompokBelanja(Kegiatan kegiatan, Long id, String akun, String nama) {
        this.kegiatan = kegiatan;
        this.id = id;
        this.akun = akun;
        this.nama = nama;
    }

    

    public KelompokBelanja() {
    }

    public Kegiatan getKegiatan() {
        return kegiatan;
    }

    public void setKegiatan(Kegiatan kegiatan) {
        this.kegiatan = kegiatan;
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
