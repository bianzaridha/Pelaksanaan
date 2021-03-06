/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pelaksanaan.micro.service;

import pelaksanaan.micro.config.HibernateUtil;
import pelaksanaan.micro.model.ObyekPendapatan;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author bianza
 */
public class ObyekpendapatanService {
  
    public List<ObyekPendapatan> getAllByJenis(Long id) {
    String query = "from ObyekPendapatan where id_jenispendapatan=:id";
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    List<ObyekPendapatan> open = (List<ObyekPendapatan>) session.createQuery(
        query).setParameter("id", id).list();
    session.getTransaction().commit();
    session.close();
    return open;
  }
    
  public void delete(ObyekPendapatan open) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    RincianpendapatanService rps = new RincianpendapatanService();
    rps.batchDeleteByObyek(open.getId());
    
    session.delete(open);
    session.getTransaction().commit();
    session.close();
  }
  
  public void batchDeleteByJenis (Long id){
    List<ObyekPendapatan> list = this.getAllByJenis(id);
    for (ObyekPendapatan kill : list) {
      this.delete(kill);
    }
  }
}
