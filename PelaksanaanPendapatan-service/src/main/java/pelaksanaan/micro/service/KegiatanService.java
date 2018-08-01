/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pelaksanaan.micro.service;

import java.util.List;
import org.hibernate.Session;
import org.springframework.web.client.RestTemplate;
import pelaksanaan.micro.config.HibernateUtil;
import pelaksanaan.micro.model.Kegiatan;
import pelaksanaan.micro.model.Bidang;

/**
 *
 * @author bianza
 */
public class KegiatanService {
  
  public List<Kegiatan> getAllByBidang(Long id) {
    String query = "from Kegiatan where id_bidang=:id";
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    List<Kegiatan> kegiatan = (List<Kegiatan>) session.createQuery(
        query).setParameter("id", id).list();
    session.getTransaction().commit();
    session.close();
    return kegiatan;
  }
  
  
  public void delete(Kegiatan keg) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    KelompokbelanjaService kbs = new KelompokbelanjaService();
    kbs.batchDeleteByKegiatan(keg.getId());
    
    
    session.delete(keg);
    session.getTransaction().commit();
    session.close();
  }
  
  public void batchDeleteByBidang (Long id){
    List<Kegiatan> list = this.getAllByBidang(id);
    for (Kegiatan kill : list) {
      this.delete(kill);
    }
  }
}
