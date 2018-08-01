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
}
