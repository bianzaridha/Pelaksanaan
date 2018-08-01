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
@Table(name="obyek_belanja")
public class ObyekBelanja {
    @ManyToOne
    @JoinColumn(name="id_jenisbelanja",
                nullable = false, updatable = false)
    @NotNull
    private JenisBelanja jenbelanja;
    
    @Id
    @Column(name = "id_obyekbelanja", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "akun_obyekbelanja")
    private String akun;
    
    @Column(name = "nama_obyekbelanja")
    private String nama;
    
    @Column(name = "anggaran")
    private  Long anggaran;

    public ObyekBelanja(JenisBelanja jenbelanja, Long id, String akun, String nama, Long anggaran) {
        this.jenbelanja = jenbelanja;
        this.id = id;
        this.akun = akun;
        this.nama = nama;
        this.anggaran = anggaran;
    }

    public ObyekBelanja() {
    }

    public JenisBelanja getJenbelanja() {
        return jenbelanja;
    }

    public void setJenbelanja(JenisBelanja jenbelanja) {
        this.jenbelanja = jenbelanja;
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
