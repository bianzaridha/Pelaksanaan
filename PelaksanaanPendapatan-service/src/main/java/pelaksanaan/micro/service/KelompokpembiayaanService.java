/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pelaksanaan.micro.service;

import pelaksanaan.micro.config.HibernateUtil;
import pelaksanaan.micro.model.KelompokPembiayaan;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author bianza
 */
public class KelompokpembiayaanService {
        
  public List<KelompokPembiayaan> getAllByBidang(Long id) {
    String query = "from KelompokPembiayaan where id_bidang=:id";
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    List<KelompokPembiayaan> kpem = (List<KelompokPembiayaan>) session.createQuery(
        query).setParameter("id", id).list();
    session.getTransaction().commit();
    session.close();
    return kpem;
  }
    

  public void delete(KelompokPembiayaan kpem) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    JenispembiayaanService jps = new JenispembiayaanService();
    jps.batchDeleteByKelompok(kpem.getId());
    
    session.delete(kpem);
    session.getTransaction().commit();
    session.close();
  }
  
  public void batchDeleteByBidang (Long id){
    List<KelompokPembiayaan> list = this.getAllByBidang(id);
    for (KelompokPembiayaan kill : list) {
      this.delete(kill);
    }
  }
  
}
