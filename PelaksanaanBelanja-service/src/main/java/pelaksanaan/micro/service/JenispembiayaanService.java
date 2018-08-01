/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pelaksanaan.micro.service;

import pelaksanaan.micro.config.HibernateUtil;
import pelaksanaan.micro.model.JenisPembiayaan;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author bianza
 */
public class JenispembiayaanService {
  
    public List<JenisPembiayaan> getAllByKelompok(Long id) {
    String query = "from JenisPembiayaan where id_kelompokpembiayaan=:id";
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    List<JenisPembiayaan> jpem = (List<JenisPembiayaan>) session.createQuery(
        query).setParameter("id", id).list();
    session.getTransaction().commit();
    session.close();
    return jpem;
  }
    
  public void delete(JenisPembiayaan jpem) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
     
    ObyekpembiayaanService ops = new ObyekpembiayaanService();
    ops.batchDeleteByJenis(jpem.getId());
    
    session.delete(jpem);
    session.getTransaction().commit();
    session.close();
  }
  
  public void batchDeleteByKelompok (Long id){
    List<JenisPembiayaan> list = this.getAllByKelompok(id);
    for (JenisPembiayaan kill : list) {
      this.delete(kill);
    }
  }
}
