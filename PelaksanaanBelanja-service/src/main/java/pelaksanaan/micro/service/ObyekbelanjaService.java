/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pelaksanaan.micro.service;

import pelaksanaan.micro.config.HibernateUtil;
import pelaksanaan.micro.model.ObyekBelanja;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author bianza
 */
public class ObyekbelanjaService {
    
    public ObyekBelanja save(ObyekBelanja ob){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.save(ob);
        session.getTransaction().commit();
        session.close();

        return ob;
    }
    
  public void batchSave(List<ObyekBelanja> list) {
    for (ObyekBelanja live : list) {
      this.save(live);
    }
  }
  
  public List<ObyekBelanja> getAll() {
    String query = "from ObyekBelanja";
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    List<ObyekBelanja> list = (List<ObyekBelanja>) session.createQuery(
        query).list();
    session.getTransaction().commit();
    session.close();
    return list;
  }
  
  public List<ObyekBelanja> findById(Long id) {
    String query = "from ObyekBelanja where id_obyekbelanja=:id";
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    List<ObyekBelanja> ob = (List<ObyekBelanja>) session.createQuery(
        query).setParameter("id", id).list();
    session.getTransaction().commit();
    session.close();
    return ob;
  }
  
    public List<ObyekBelanja> getAllByJenis(Long id) {
    String query = "from ObyekBelanja where id_jenisbelanja=:id";
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    List<ObyekBelanja> ob = (List<ObyekBelanja>) session.createQuery(
        query).setParameter("id", id).list();
    session.getTransaction().commit();
    session.close();
    return ob;
  }
    
  public void delete(ObyekBelanja ob) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    RincianbelanjaService rbs = new RincianbelanjaService();
    rbs.batchDeleteByObyek(ob.getId());
    
    session.delete(ob);
    session.getTransaction().commit();
    session.close();
  }
  
  public void batchDeleteByJenis (Long id){
    List<ObyekBelanja> list = this.getAllByJenis(id);
    for (ObyekBelanja kill : list) {
      this.delete(kill);
    }
  }
  
  public void update(ObyekBelanja ob) {
    String query = "update ObyekBelanja set "
            + "akun_obyekbelanja= :akun, "
            + "nama_obyekbelanja= :nama, "
            + "anggaran= :anggaran "
            + "where id_obyekbelanja= :id";
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    int result = session.createQuery(
        query).setParameter("akun", ob.getAkun())
            .setParameter("nama", ob.getNama())
            .setParameter("anggaran", ob.getAnggaran())
            .setParameter("id", ob.getId())
            .executeUpdate();
    session.getTransaction().commit();
    session.close();
  }
}
