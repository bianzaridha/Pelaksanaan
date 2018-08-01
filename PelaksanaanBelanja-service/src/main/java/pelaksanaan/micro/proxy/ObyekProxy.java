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
public class ObyekProxy {
    
    private Long id_parent;
    private Long id;
    private String akun;
    private String nama;
    private Long anggaran;

    public Long getId_parent() {
        return id_parent;
    }

    public void setId_parent(Long id_parent) {
        this.id_parent = id_parent;
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
