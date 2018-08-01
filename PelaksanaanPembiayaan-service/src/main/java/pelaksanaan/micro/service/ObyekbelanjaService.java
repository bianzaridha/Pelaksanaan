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
}
