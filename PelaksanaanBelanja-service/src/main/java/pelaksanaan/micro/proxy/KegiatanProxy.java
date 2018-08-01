/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pelaksanaan.micro.proxy;

/**
 *
 * @author bianza
 */
public class KegiatanProxy {
   
    private Long id_bidang;
    private Long id;
    private String kode;
    private String nama;
    private String waktu;
    private String nama_pptkd;
    private String keluaran;

    public Long getId_bidang() {
        return id_bidang;
    }

    public void setId_bidang(Long id_bidang) {
        this.id_bidang = id_bidang;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public String getNama_pptkd() {
        return nama_pptkd;
    }

    public void setNama_pptkd(String nama_pptkd) {
        this.nama_pptkd = nama_pptkd;
    }

    public String getKeluaran() {
        return keluaran;
    }

    public void setKeluaran(String keluaran) {
        this.keluaran = keluaran;
    }
    
    
}
