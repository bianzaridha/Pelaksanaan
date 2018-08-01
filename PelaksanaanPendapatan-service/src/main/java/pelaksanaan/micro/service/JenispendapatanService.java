/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pelaksanaan.micro.service;

import pelaksanaan.micro.config.HibernateUtil;
import pelaksanaan.micro.model.JenisPendapatan;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author bianza
 */
public class JenispendapatanService {
        
    public JenisPendapatan save(JenisPendapatan jpen){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.save(jpen);
        session.getTransaction().commit();
        session.close();

        return jpen;
    }
    
  public void batchSave(List<JenisPendapatan> list) {
    for (JenisPendapatan live : list) {
      this.save(live);
    }
  }
  
  public List<JenisPendapatan> getAll() {
    String query = "from JenisPendapatan";
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    List<JenisPendapatan> list = (List<JenisPendapatan>) session.createQuery(
        query).list();
    session.getTransaction().commit();
    session.close();
    return list;
  }
  
  public List<JenisPendapatan> findById(Long id) {
    String query = "from JenisPendapatan where id_jenispendapatan=:id";
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    List<JenisPendapatan> jpen = (List<JenisPendapatan>) session.createQuery(
        query).setParameter("id", id).list();
    session.getTransaction().commit();
    session.close();
    return jpen;
  }
  
    public List<JenisPendapatan> getAllByKelompok(Long id) {
    String query = "from JenisPendapatan where id_kelompokpendapatan=:id";
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    List<JenisPendapatan> jpen = (List<JenisPendapatan>) session.createQuery(
        query).setParameter("id", id).list();
    session.getTransaction().commit();
    session.close();
    return jpen;
  }
    
  public void delete(JenisPendapatan jpen) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    ObyekpendapatanService ops = new ObyekpendapatanService();
    ops.batchDeleteByJenis(jpen.getId());
    
    session.delete(jpen);
    session.getTransaction().commit();
    session.close();
  }
  
  public void batchDeleteByKelompok (Long id){
    List<JenisPendapatan> list = this.getAllByKelompok(id);
    for (JenisPendapatan kill : list) {
      this.delete(kill);
    }
  }
  
  public void update(JenisPendapatan jpen) {
    String query = "update JenisPendapatan set "
            + "akun_jenispendapatan= :akun, "
            + "nama_jenispendapatan= :nama "
            + "where id_jenispendapatan= :id";
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    int result = session.createQuery(
        query).setParameter("akun", jpen.getAkun())
            .setParameter("nama", jpen.getNama())
            .setParameter("id", jpen.getId())
            .executeUpdate();
    session.getTransaction().commit();
    session.close();
  }
}
