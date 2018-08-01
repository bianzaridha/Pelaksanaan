/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pelaksanaan.micro.service;

import pelaksanaan.micro.config.HibernateUtil;
import pelaksanaan.micro.model.KelompokPendapatan;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author bianza
 */
public class KelompokpendapatanService {
        
    public KelompokPendapatan save(KelompokPendapatan kpen){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.save(kpen);
        session.getTransaction().commit();
        session.close();

        return kpen;
    }
    
  public void batchSave(List<KelompokPendapatan> list) {
    for (KelompokPendapatan live : list) {
      this.save(live);
    }
  }
  
  public List<KelompokPendapatan> getAll() {
    String query = "from KelompokPendapatan";
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    List<KelompokPendapatan> list = (List<KelompokPendapatan>) session.createQuery(
        query).list();
    session.getTransaction().commit();
    session.close();
    return list;
  }
  
  public List<KelompokPendapatan> findById(Long id) {
    String query = "from KelompokPendapatan where id_kelompokpendapatan=:id";
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    List<KelompokPendapatan> kpen = (List<KelompokPendapatan>) session.createQuery(
        query).setParameter("id", id).list();
    session.getTransaction().commit();
    session.close();
    return kpen;
  }
  
  public List<KelompokPendapatan> getAllByBidang(Long id) {
    String query = "from KelompokPendapatan where id_bidang=:id";
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    List<KelompokPendapatan> kpen = (List<KelompokPendapatan>) session.createQuery(
        query).setParameter("id", id).list();
    session.getTransaction().commit();
    session.close();
    return kpen;
  }

  public void delete(KelompokPendapatan kpen) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    JenispendapatanService jps = new JenispendapatanService();
    jps.batchDeleteByKelompok(kpen.getId());
    
    session.delete(kpen);
    session.getTransaction().commit();
    session.close();
  }
  
  public void batchDeleteByBidang (Long id){
    List<KelompokPendapatan> list = this.getAllByBidang(id);
    for (KelompokPendapatan kill : list) {
      this.delete(kill);
    }
  }
  
  public void update(KelompokPendapatan kpen) {
    String query = "update KelompokPendapatan set "
            + "akun_kelompokpendapatan= :akun, "
            + "nama_kelompokpendapatan= :nama "
            + "where id_kelompokpendapatan= :id";
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    int result = session.createQuery(
        query).setParameter("akun", kpen.getAkun())
            .setParameter("nama", kpen.getNama())
            .setParameter("id", kpen.getId())
            .executeUpdate();
    session.getTransaction().commit();
    session.close();
  }

}
