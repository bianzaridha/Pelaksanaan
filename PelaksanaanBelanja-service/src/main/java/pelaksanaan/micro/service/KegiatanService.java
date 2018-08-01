/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pelaksanaan.micro.service;

import java.util.List;
import org.hibernate.Session;
import org.springframework.web.client.RestTemplate;
import pelaksanaan.micro.config.HibernateUtil;
import pelaksanaan.micro.model.Kegiatan;
import pelaksanaan.micro.model.Bidang;

/**
 *
 * @author bianza
 */
public class KegiatanService {
        
  public Kegiatan save(Kegiatan kegiatan){
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    session.save(kegiatan);
    session.getTransaction().commit();
    session.close();
    
    return kegiatan;
    } 

    public void batchSave(List<Kegiatan> list) {
        for (Kegiatan live : list) {
        this.save(live);
        }
    } 
    
    public List<Kegiatan> getAll() {
        String query = "from Kegiatan";
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        @SuppressWarnings("unchecked")
        List<Kegiatan> list = (List<Kegiatan>) session.createQuery(
            query).list();
        session.getTransaction().commit();
        session.close();
        return list;
    }
    
  public List<Kegiatan> findById(Long id) {
    String query = "from Kegiatan where id_kegiatan=:id";
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    List<Kegiatan> kegiatan = (List<Kegiatan>) session.createQuery(
        query).setParameter("id", id).list();
    session.getTransaction().commit();
    session.close();
    return kegiatan;
  }
  
  public List<Kegiatan> getAllByBidang(Long id) {
    String query = "from Kegiatan where id_bidang=:id";
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    List<Kegiatan> kegiatan = (List<Kegiatan>) session.createQuery(
        query).setParameter("id", id).list();
    session.getTransaction().commit();
    session.close();
    return kegiatan;
  }
  
  
  public void delete(Kegiatan keg) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    KelompokbelanjaService kbs = new KelompokbelanjaService();
    kbs.batchDeleteByKegiatan(keg.getId());
    
    
    session.delete(keg);
    session.getTransaction().commit();
    session.close();
  }
  
  public void batchDeleteByBidang (Long id){
    List<Kegiatan> list = this.getAllByBidang(id);
    for (Kegiatan kill : list) {
      this.delete(kill);
    }
  }
  
    public void update(Kegiatan kegiatan) {
    String query = "update Kegiatan set kode_kegiatan= :kode, "
                     + "nama_kegiatan= :name, "
                     + "waktu= :waktu, "
                     + "nama_pptkd= :npptkd, "
                     + "keluaran= :keluaran "
                     + "where id_kegiatan= :id";
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    int result = session.createQuery(
        query)
            .setParameter("kode", kegiatan.getKode())
            .setParameter("name", kegiatan.getNama())
            .setParameter("waktu", kegiatan.getWaktu())
            .setParameter("keluaran", kegiatan.getKeluaran())
            .setParameter("npptkd", kegiatan.getNama_pptkd())
            .setParameter("id", kegiatan.getId())
            .executeUpdate();
    session.getTransaction().commit();
    session.close();
  }
}
