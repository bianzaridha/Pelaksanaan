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
  
    public List<ObyekPembiayaan> getAllByJenis(Long id) {
    String query = "from ObyekPembiayaan where id_jenispembiayaan=:id";
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    List<ObyekPembiayaan> opem = (List<ObyekPembiayaan>) session.createQuery(
        query).setParameter("id", id).list();
    session.getTransaction().commit();
    session.close();
    return opem;
  }
    
  public void delete(ObyekPembiayaan opem) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
     
    RincianpembiayaanService rps = new RincianpembiayaanService();
    rps.batchDeleteByObyek(opem.getId());
    
    session.delete(opem);
    session.getTransaction().commit();
    session.close();
  }
  
  public void batchDeleteByJenis (Long id){
    List<ObyekPembiayaan> list = this.getAllByJenis(id);
    for (ObyekPembiayaan kill : list) {
      this.delete(kill);
    }
  }
}
