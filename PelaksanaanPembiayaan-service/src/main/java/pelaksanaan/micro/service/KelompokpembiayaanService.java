/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pelaksanaan.micro.service;

import pelaksanaan.micro.config.HibernateUtil;
import pelaksanaan.micro.model.KelompokPembiayaan;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author bianza
 */
public class KelompokpembiayaanService {
        
    public KelompokPembiayaan save(KelompokPembiayaan kpem){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.save(kpem);
        session.getTransaction().commit();
        session.close();

        return kpem;
    }
    
  public void batchSave(List<KelompokPembiayaan> list) {
    for (KelompokPembiayaan live : list) {
      this.save(live);
    }
  }
  
  public List<KelompokPembiayaan> getAll() {
    String query = "from KelompokPembiayaan";
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    List<KelompokPembiayaan> list = (List<KelompokPembiayaan>) session.createQuery(
        query).list();
    session.getTransaction().commit();
    session.close();
    return list;
  }
  
  public List<KelompokPembiayaan> findById(Long id) {
    String query = "from KelompokPembiayaan where id_kelompokpembiayaan=:id";
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    List<KelompokPembiayaan> kpem = (List<KelompokPembiayaan>) session.createQuery(
        query).setParameter("id", id).list();
    session.getTransaction().commit();
    session.close();
    return kpem;
  }
  
  public List<KelompokPembiayaan> getAllByBidang(Long id) {
    String query = "from KelompokPembiayaan where id_bidang=:id";
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    List<KelompokPembiayaan> kpem = (List<KelompokPembiayaan>) session.createQuery(
        query).setParameter("id", id).list();
    session.getTransaction().commit();
    session.close();
    return kpem;
  }

  public void delete(KelompokPembiayaan kpem) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    JenispembiayaanService jps = new JenispembiayaanService();
    jps.batchDeleteByKelompok(kpem.getId());
    
    session.delete(kpem);
    session.getTransaction().commit();
    session.close();
  }
  
  public void batchDeleteByBidang (Long id){
    List<KelompokPembiayaan> list = this.getAllByBidang(id);
    for (KelompokPembiayaan kill : list) {
      this.delete(kill);
    }
  }
  
  public void update(KelompokPembiayaan kpem) {
    String query = "update KelompokPembiayaan set "
            + "akun_kelompokpembiayaan= :akun, "
            + "nama_kelompokpembiayaan= :nama "
            + "where id_kelompokpembiayaan= :id";
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    int result = session.createQuery(
        query).setParameter("akun", kpem.getAkun())
            .setParameter("nama", kpem.getNama())
            .setParameter("id", kpem.getId())
            .executeUpdate();
    session.getTransaction().commit();
    session.close();
  }

}
