/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pelaksanaan.micro.service;

import java.util.List;
import org.hibernate.Session;
import pelaksanaan.micro.config.HibernateUtil;
import pelaksanaan.micro.model.RencanaBidang;
import pelaksanaan.micro.model.RencanaJenis;
import pelaksanaan.micro.model.RencanaKegiatan;
import pelaksanaan.micro.model.RencanaKelompok;
import pelaksanaan.micro.model.RencanaObyek;

/**
 *
 * @author bianza
 */
public class RencanaService {
    
   public List<RencanaBidang> getAllBidang() {
    String query = "from RencanaBidang";
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    List<RencanaBidang> list = (List<RencanaBidang>) session.createQuery(
        query).list();
    session.getTransaction().commit();
    session.close();
    return list;
  }
   
  public List<RencanaKegiatan> getAllKegiatanByBidang(String kb) {
    String query = "from RencanaKegiatan where kode_bidang=:id";
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    List<RencanaKegiatan> list = (List<RencanaKegiatan>) session.createQuery(
        query).setParameter("id", kb).list();
    session.getTransaction().commit();
    session.close();
    return list;
  } 
   
  public List<RencanaKelompok> getAllKelompokByBidang(String kb) {
    String query = "from RencanaKelompok where kode_bidang=:id";
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    List<RencanaKelompok> list = (List<RencanaKelompok>) session.createQuery(
        query).setParameter("id", kb).list();
    session.getTransaction().commit();
    session.close();
    return list;
  }
    
  public List<RencanaJenis> getAllJenisByKelompok(String ak) {
    String query = "from RencanaJenis where akun_kelompok=:id";
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    List<RencanaJenis> list = (List<RencanaJenis>) session.createQuery(
        query).setParameter("id", ak).list();
    session.getTransaction().commit();
    session.close();
    return list;
  }
  
  public List<RencanaObyek> getAllObyekByJenis(String aj) {
    String query = "from RencanaObyek where akun_jenis=:id";
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    @SuppressWarnings("unchecked")
    List<RencanaObyek> list = (List<RencanaObyek>) session.createQuery(
        query).setParameter("id", aj).list();
    session.getTransaction().commit();
    session.close();
    return list;
  }
}
