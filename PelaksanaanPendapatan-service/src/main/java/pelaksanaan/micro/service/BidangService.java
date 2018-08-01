/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pelaksanaan.micro.service;

import pelaksanaan.micro.config.HibernateUtil;
import pelaksanaan.micro.model.Pelaksanaan;
import pelaksanaan.micro.model.Bidang;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author bianza
 */
public class BidangService {
    
    public Bidang save(Bidang bidang){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.save(bidang);
        session.getTransaction().commit();
        session.close();

        return bidang;
    }
    
    public void batchSave(List<Bidang> list) {
        for (Bidang live : list) {
          this.save(live);
        }
    }
    
   public List<Bidang> getAll() {
    String query = "from Bidang";
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    List<Bidang> list = (List<Bidang>) session.createQuery(
        query).list();
    session.getTransaction().commit();
    session.close();
    return list;
  }
   
  public List<Bidang> findById(Long id) {
    String query = "from Bidang where id_bidang=:id";
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    List<Bidang> bidang = (List<Bidang>) session.createQuery(
        query).setParameter("id", id).list();
    session.getTransaction().commit();
    session.close();
    return bidang;
  }
  
  public List<Bidang> getAllByPelaksanaan(Long id) {
    String query = "from Bidang where id_pelaksanaan=:id";
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    List<Bidang> bidang = (List<Bidang>) session.createQuery(
        query).setParameter("id", id).list();
    session.getTransaction().commit();
    session.close();
    return bidang;
  }
  
  public List<Bidang> getAllByJenisdanPelaksanaan(Integer jenis, Long id) {
    String query = "from Bidang where jenis_bidang=:jenis and id_pelaksanaan= :id";
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    List<Bidang> bidang = (List<Bidang>) session.createQuery(
        query).setParameter("jenis", jenis).setParameter("id", id).list();
    session.getTransaction().commit();
    session.close();
    return bidang;
  }
  
  public void delete(Bidang bidang) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    KegiatanService ks = new KegiatanService();
    ks.batchDeleteByBidang(bidang.getId());
    
    KelompokpendapatanService kpens = new KelompokpendapatanService();
    kpens.batchDeleteByBidang(bidang.getId());
    
    KelompokpembiayaanService kpems = new KelompokpembiayaanService();
    kpems.batchDeleteByBidang(bidang.getId());
    
    
    session.delete(bidang);
    session.getTransaction().commit();
    session.close();
  }
  
  public void batchDeleteByPelaksanaan (Long id){
    List<Bidang> list = this.getAllByPelaksanaan(id);
    for (Bidang kill : list) {
      this.delete(kill);
    }
  }
  
  public void update(Bidang bidang) {
    String query = "update Bidang set nama_bidang= :name, jenis_bidang= :jenis where id_bidang= :id";
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    int result = session.createQuery(
        query)
            .setParameter("name", bidang.getNama())
            .setParameter("id", bidang.getKode())
            .setParameter("jenis", bidang.getJenis())
            .executeUpdate();
    session.getTransaction().commit();
    session.close();
  } 
    
}
