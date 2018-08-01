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
@Table(name="rincian_belanja")
public class RincianBelanja {
    
    @ManyToOne
    @JoinColumn(name="id_obyekbelanja",
                nullable = false, updatable = false)
    @NotNull
    private ObyekBelanja obybelanja;
    
    @Id
    @Column(name = "id_rincianbelanja", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "no_urutbelanja")
    private Long norut;
    
    @Column(name = "uraian")
    private String uraian;
    
    @Column(name = "jumlah")
    private Long jumlah;
    
    @Column(name = "satuan")
    private String satuan;
    
    @Column(name = "harga_satuan")
    private Long hs;
    
    @Column(name = "sumberdana")
    private String sumberdana;
    
    @Column(name = "jumlahtotal")
    private Long jumtot;

    public RincianBelanja(ObyekBelanja obybelanja, Long id, Long norut, String uraian, Long jumlah, String satuan, Long hs, String sumberdana, Long jumtot) {
        this.obybelanja = obybelanja;
        this.id = id;
        this.norut = norut;
        this.uraian = uraian;
        this.jumlah = jumlah;
        this.satuan = satuan;
        this.hs = hs;
        this.sumberdana = sumberdana;
        this.jumtot = jumtot;
    }

    

    public RincianBelanja() {
    }

    public Long getJumlah() {
        return jumlah;
    }

    public void setJumlah(Long jumlah) {
        this.jumlah = jumlah;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }
    
    

    public ObyekBelanja getObybelanja() {
        return obybelanja;
    }

    public void setObybelanja(ObyekBelanja obybelanja) {
        this.obybelanja = obybelanja;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNorut() {
        return norut;
    }

    public void setNorut(Long norut) {
        this.norut = norut;
    }

    public String getUraian() {
        return uraian;
    }

    public void setUraian(String uraian) {
        this.uraian = uraian;
    }

    public Long getHs() {
        return hs;
    }

    public void setHs(Long hs) {
        this.hs = hs;
    }

    public String getSumberdana() {
        return sumberdana;
    }

    public void setSumberdana(String sumberdana) {
        this.sumberdana = sumberdana;
    }

    public Long getJumtot() {
        return jumtot;
    }

    public void setJumtot(Long jumtot) {
        this.jumtot = jumtot;
    }
    
}
