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
@Table(name="pelaksanaan")
public class Pelaksanaan {
    
    @Id
    @Column(name = "id_pelaksanaan", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "kode_desa", nullable = false)
    private Long kode_desa;
    
    @Column(name = "tahun_anggaran")
    private String ta;

    public Pelaksanaan(Long id, Long kode_desa, String ta) {
        this.id = id;
        this.kode_desa = kode_desa;
        this.ta = ta;
    }

    public Pelaksanaan() {
    }
    

    public Long getKode_desa() {
        return kode_desa;
    }

    public void setKode_desa(Long kode_desa) {
        this.kode_desa = kode_desa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTa() {
        return ta;
    }

    public void setTa(String ta) {
        this.ta = ta;
    }
    
}
