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
}
