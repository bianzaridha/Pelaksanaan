/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pelaksanaan.micro.service;

import pelaksanaan.micro.config.HibernateUtil;
import pelaksanaan.micro.model.ObyekPembiayaan;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author bianza
 */
public class ObyekpembiayaanService {
    
    public ObyekPembiayaan save(ObyekPembiayaan open){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.save(open);
        session.getTransaction().commit();
        session.close();

        return open;
    }
    
  public void batchSave(List<ObyekPembiayaan> list) {
    for (ObyekPembiayaan live : list) {
      this.save(live);
    }
  }
  
  public List<ObyekPembiayaan> getAll() {
    String query = "from ObyekPembiayaan";
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    List<ObyekPembiayaan> list = (List<ObyekPembiayaan>) session.createQuery(
        query).list();
    session.getTransaction().commit();
    session.close();
    return list;
  }
  
  public List<ObyekPembiayaan> findById(Long id) {
    String query = "from ObyekPembiayaan where id_obyekpembiayaan=:id";
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    List<ObyekPembiayaan> open = (List<ObyekPembiayaan>) session.createQuery(
        query).setParameter("id", id).list();
    session.getTransaction().commit();
    session.close();
    return open;
  }
  
    public List<ObyekPembiayaan> getAllByJenis(Long id) {
    String query = "from ObyekPembiayaan where id_jenispembiayaan=:id";
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    List<ObyekPembiayaan> open = (List<ObyekPembiayaan>) session.createQuery(
        query).setParameter("id", id).list();
    session.getTransaction().commit();
    session.close();
    return open;
  }
    
  public void delete(ObyekPembiayaan open) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    RincianpembiayaanService rps = new RincianpembiayaanService();
    rps.batchDeleteByObyek(open.getId());
    
    session.delete(open);
    session.getTransaction().commit();
    session.close();
  }
  
  public void batchDeleteByJenis (Long id){
    List<ObyekPembiayaan> list = this.getAllByJenis(id);
    for (ObyekPembiayaan kill : list) {
      this.delete(kill);
    }
  }
  
  public void update(ObyekPembiayaan open) {
    String query = "update ObyekPembiayaan set "
            + "akun_obyekpembiayaan= :akun, "
            + "nama_obyekpembiayaan= :nama, "
            + "anggaran=:anggaran "
            + "where id_obyekpembiayaan= :id";
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    int result = session.createQuery(
        query).setParameter("akun", open.getAkun())
            .setParameter("nama", open.getNama())
            .setParameter("anggaran", open.getAnggaran())
            .setParameter("id", open.getId())
            .executeUpdate();
    session.getTransaction().commit();
    session.close();
  }      
}
