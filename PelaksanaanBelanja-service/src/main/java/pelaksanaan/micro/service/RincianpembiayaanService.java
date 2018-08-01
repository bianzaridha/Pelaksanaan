/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pelaksanaan.micro.service;

import pelaksanaan.micro.config.HibernateUtil;
import pelaksanaan.micro.model.RincianPembiayaan;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author bianza
 */
public class RincianpembiayaanService {
  
    public List<RincianPembiayaan> getAllByObyek(Long id) {
    String query = "from RincianPembiayaan where id_obyekpembiayaan=:id";
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    List<RincianPembiayaan> rpem = (List<RincianPembiayaan>) session.createQuery(
        query).setParameter("id", id).list();
    session.getTransaction().commit();
    session.close();
    return rpem;
  }
    
  public void delete(RincianPembiayaan rpem) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    session.delete(rpem);
    session.getTransaction().commit();
    session.close();
  }
  
  public void batchDeleteByObyek (Long id){
    List<RincianPembiayaan> list = this.getAllByObyek(id);
    for (RincianPembiayaan kill : list) {
      this.delete(kill);
    }
  }
}
