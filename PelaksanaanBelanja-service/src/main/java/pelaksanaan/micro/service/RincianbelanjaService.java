/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pelaksanaan.micro.service;

import pelaksanaan.micro.config.HibernateUtil;
import pelaksanaan.micro.model.RincianBelanja;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author bianza
 */
public class RincianbelanjaService {
    
    public RincianBelanja save(RincianBelanja rb){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.save(rb);
        session.getTransaction().commit();
        session.close();

        return rb;
    }
    
  public void batchSave(List<RincianBelanja> list) {
    for (RincianBelanja live : list) {
      this.save(live);
    }
  }
  
  public List<RincianBelanja> getAll() {
    String query = "from RincianBelanja";
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    List<RincianBelanja> list = (List<RincianBelanja>) session.createQuery(
        query).list();
    session.getTransaction().commit();
    session.close();
    return list;
  }
  
  public List<RincianBelanja> findById(Long id) {
    String query = "from RincianBelanja where id_rincianbelanja=:id";
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    List<RincianBelanja> rb = (List<RincianBelanja>) session.createQuery(
        query).setParameter("id", id).list();
    session.getTransaction().commit();
    session.close();
    return rb;
  }
  
    public List<RincianBelanja> getAllByObyek(Long id) {
    String query = "from RincianBelanja where id_obyekbelanja=:id";
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    List<RincianBelanja> rb = (List<RincianBelanja>) session.createQuery(
        query).setParameter("id", id).list();
    session.getTransaction().commit();
    session.close();
    return rb;
  }
    
  public void delete(RincianBelanja rb) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    session.delete(rb);
    session.getTransaction().commit();
    session.close();
  }
  
  public void batchDeleteByObyek (Long id){
    List<RincianBelanja> list = this.getAllByObyek(id);
    for (RincianBelanja kill : list) {
      this.delete(kill);
    }
  }
  
  public void update(RincianBelanja rb) {
    String query = "update RincianBelanja set "
            + "no_urutbelanja= :norut, "
            + "uraian= :uraian, "
            + "jumlah= :jumlah, "
            + "satuan= :satuan, "
            + "harga_satuan= :hs, "
            + "sumberdana= :sumberdana, "
            + "jumlahtotal=:jumtot "
            + "where id_rincianbelanja= :id";
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    Long jumtot = rb.getJumlah() * rb.getHs();
    
    @SuppressWarnings("unchecked")
    int result = session.createQuery(
        query).setParameter("norut",rb.getNorut())
            .setParameter("uraian", rb.getUraian())
            .setParameter("jumlah", rb.getJumlah())
            .setParameter("satuan", rb.getSatuan())
            .setParameter("hs", rb.getHs())
            .setParameter("sumberdana", rb.getSumberdana())
            .setParameter("jumtot", jumtot)
            .setParameter("id", rb.getId())
            .executeUpdate();
    session.getTransaction().commit();
    session.close();
  }    
}
