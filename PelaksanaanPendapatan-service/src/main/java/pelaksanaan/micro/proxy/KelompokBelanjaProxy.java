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
public class KelompokBelanjaProxy {
    
    private Long id_kegiatan;
    private Long id;
    private String akun;
    private String nama;

    public Long getId_kegiatan() {
        return id_kegiatan;
    }

    public void setId_kegiatan(Long id_kegiatan) {
        this.id_kegiatan = id_kegiatan;
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
