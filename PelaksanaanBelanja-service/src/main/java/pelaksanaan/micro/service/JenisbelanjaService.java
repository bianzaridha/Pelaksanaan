/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pelaksanaan.micro.service;

import pelaksanaan.micro.config.HibernateUtil;
import pelaksanaan.micro.model.JenisBelanja;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author bianza
 */
public class JenisbelanjaService {
    
    public JenisBelanja save(JenisBelanja jb){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.save(jb);
        session.getTransaction().commit();
        session.close();

        return jb;
    }
    
  public void batchSave(List<JenisBelanja> list) {
    for (JenisBelanja live : list) {
      this.save(live);
    }
  }
  
  public List<JenisBelanja> getAll() {
    String query = "from JenisBelanja";
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    List<JenisBelanja> list = (List<JenisBelanja>) session.createQuery(
        query).list();
    session.getTransaction().commit();
    session.close();
    return list;
  }
  
  public List<JenisBelanja> findById(Long id) {
    String query = "from JenisBelanja where id_jenisbelanja=:id";
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    List<JenisBelanja> jb = (List<JenisBelanja>) session.createQuery(
        query).setParameter("id", id).list();
    session.getTransaction().commit();
    session.close();
    return jb;
  }
  
    public List<JenisBelanja> getAllByKelompok(Long id) {
    String query = "from JenisBelanja where id_kelompokbelanja=:id";
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    List<JenisBelanja> jb = (List<JenisBelanja>) session.createQuery(
        query).setParameter("id", id).list();
    session.getTransaction().commit();
    session.close();
    return jb;
  }
    
  public void delete(JenisBelanja jb) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    ObyekbelanjaService obs = new ObyekbelanjaService();
    obs.batchDeleteByJenis(jb.getId());
            
    session.delete(jb);
    session.getTransaction().commit();
    session.close();
  }
  
  public void batchDeleteByKelompok (Long id){
    List<JenisBelanja> list = this.getAllByKelompok(id);
    for (JenisBelanja kill : list) {
      this.delete(kill);
    }
  }
  
  public void update(JenisBelanja jb) {
    String query = "update JenisBelanja set "
            + "akun_jenisbelanja= :akun, "
            + "nama_jenisbelanja= :nama "
            + "where id_jenisbelanja= :id";
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
