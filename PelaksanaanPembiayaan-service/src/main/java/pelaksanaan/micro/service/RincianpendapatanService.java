/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pelaksanaan.micro.service;

import pelaksanaan.micro.config.HibernateUtil;
import pelaksanaan.micro.model.RincianPendapatan;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author bianza
 */
public class RincianpendapatanService {
   
    public List<RincianPendapatan> getAllByObyek(Long id) {
    String query = "from RincianPendapatan where id_obyekpendapatan=:id";
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    List<RincianPendapatan> rpen = (List<RincianPendapatan>) session.createQuery(
        query).setParameter("id", id).list();
    session.getTransaction().commit();
    session.close();
    return rpen;
  }
    
  public void delete(RincianPendapatan rpen) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    session.delete(rpen);
    session.getTransaction().commit();
    session.close();
  }
  
  public void batchDeleteByObyek (Long id){
    List<RincianPendapatan> list = this.getAllByObyek(id);
    for (RincianPendapatan kill : list) {
      this.delete(kill);
    }
  }     
}
