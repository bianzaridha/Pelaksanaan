/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pelaksanaan.micro.service;

import pelaksanaan.micro.config.HibernateUtil;
import pelaksanaan.micro.model.KelompokBelanja;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author bianza
 */
public class KelompokbelanjaService {
        
    public KelompokBelanja save(KelompokBelanja kb){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.save(kb);
        session.getTransaction().commit();
        session.close();

        return kb;
    }
    
  public void batchSave(List<KelompokBelanja> list) {
    for (KelompokBelanja live : list) {
      this.save(live);
    }
  }
  
  public List<KelompokBelanja> getAll() {
    String query = "from KelompokBelanja";
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    List<KelompokBelanja> list = (List<KelompokBelanja>) session.createQuery(
        query).list();
    session.getTransaction().commit();
    session.close();
    return list;
  }
  
  public List<KelompokBelanja> findById(Long id) {
    String query = "from KelompokBelanja where id_kelompokbelanja=:id";
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    List<KelompokBelanja> kb = (List<KelompokBelanja>) session.createQuery(
        query).setParameter("id", id).list();
    session.getTransaction().commit();
    session.close();
    return kb;
  }
    
   public List<KelompokBelanja> getAllByKegiatan(Long id) {
    String query = "from KelompokBelanja where id_kegiatan=:id";
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    List<KelompokBelanja> kb = (List<KelompokBelanja>) session.createQuery(
        query).setParameter("id", id).list();
    session.getTransaction().commit();
    session.close();
    return kb;
  }
    

  public void delete(KelompokBelanja kb) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    JenisbelanjaService jbs = new JenisbelanjaService();
    jbs.batchDeleteByKelompok(kb.getId());
    
    session.delete(kb);
    session.getTransaction().commit();
    session.close();
  }
  

  public void batchDeleteByKegiatan (Long id){
    List<KelompokBelanja> list = this.getAllByKegiatan(id);
    for (KelompokBelanja kill : list) {
      this.delete(kill);
    }
  }
  
  public void update(KelompokBelanja jb) {
    String query = "update KelompokBelanja set "
            + "akun_kelompokbelanja= :akun, "
            + "nama_kelompokbelanja= :nama "
            + "where id_kelompokbelanja= :id";
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    int result = session.createQuery(
        query).setParameter("akun", jb.getAkun())
            .setParameter("nama", jb.getNama())
            .setParameter("id", jb.getId())
            .executeUpdate();
    session.getTransaction().commit();
    session.close();
  }
    
}
