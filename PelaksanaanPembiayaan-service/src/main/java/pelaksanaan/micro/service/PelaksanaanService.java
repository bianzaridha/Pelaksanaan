/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pelaksanaan.micro.service;

import pelaksanaan.micro.config.HibernateUtil;
import pelaksanaan.micro.model.Pelaksanaan;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author bianza
 */
public class PelaksanaanService {
    
    public Pelaksanaan save(Pelaksanaan pelaksanaan){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.save(pelaksanaan);
        session.getTransaction().commit();
        session.close();

        return pelaksanaan;
    }
    
  public void batchSave(List<Pelaksanaan> list) {
    for (Pelaksanaan live : list) {
      this.save(live);
    }
  }
  
  public List<Pelaksanaan> getAll() {
    String query = "from Pelaksanaan";
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    List<Pelaksanaan> list = (List<Pelaksanaan>) session.createQuery(
        query).list();
    session.getTransaction().commit();
    session.close();
    return list;
  }
  
  public List<Pelaksanaan> findById(Long id) {
    String query = "from Pelaksanaan where id_pelaksanaan=:id";
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    List<Pelaksanaan> pelaksanaan = (List<Pelaksanaan>) session.createQuery(
        query).setParameter("id", id).list();
    session.getTransaction().commit();
    session.close();
    return pelaksanaan;
  }
  
    public List<Pelaksanaan> getAllByDesa(Long id) {
    String query = "from Pelaksanaan where kode_desa=:id";
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    List<Pelaksanaan> pelaksanaan = (List<Pelaksanaan>) session.createQuery(
        query).setParameter("id", id).list();
    session.getTransaction().commit();
    session.close();
    return pelaksanaan;
  }
    
  public void delete(Pelaksanaan pelaksanaan) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    BidangService bs = new BidangService();
    bs.batchDeleteByPelaksanaan(pelaksanaan.getId());
    
    
    session.delete(pelaksanaan);
    session.getTransaction().commit();
    session.close();
  }
  
  public void batchDeleteByDesa (Long id){
    List<Pelaksanaan> list = this.getAllByDesa(id);
    for (Pelaksanaan kill : list) {
      this.delete(kill);
    }
  }
  
  public void update(Pelaksanaan pelaksanaan) {
    String query = "update Pelaksanaan set tahun_anggaran= :ta where id_pelaksanaan= :id";
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    int result = session.createQuery(
        query).setParameter("ta", pelaksanaan.getTa())
            .setParameter("id", pelaksanaan.getId())
            .executeUpdate();
    session.getTransaction().commit();
    session.close();
  }
}
