/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bajuonline;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author YUMMY
 */
public class QueryB0nline {
     public void Add (Object object){
        
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("BajuOnlinePU");
        EntityManager em = emf.createEntityManager();  
        em.getTransaction().begin();
        try {
                em.persist(object);
                em.getTransaction().commit();
        } catch (Exception e) {
                e.printStackTrace();
                em.getTransaction().rollback();
        } finally {
                em.close();
        }
    }
    
    public void update(long id,String nama,String alamat){
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("BajuOnlinePU");
        EntityManager em = emf.createEntityManager();  
        em.getTransaction().begin();
        em.createQuery("UPDATE onlinebaju e SET e.nama=?1,e.alamat=?2 WHERE e.id=?3",onlinebaju.class)
                .setParameter(1, nama)
                .setParameter(2, alamat)
                
                .setParameter(3,id)
                .executeUpdate();       
        em.getTransaction().commit();
  }
    
    
public void hapus(long id){
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("BajuOnlinePU");
        EntityManager em = emf.createEntityManager();  
        em.getTransaction().begin();
        int hapusyu=em.createQuery("DELETE FROM onlinebaju e WHERE e.id=:par").setParameter("par", id).executeUpdate();
        em.getTransaction().commit();
}
  public void Show() {
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("BajuOnlinePU");
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT e FROM onlinebaju e");
        List<onlinebaju> result = query.getResultList();
        for (onlinebaju e : result) {
                 System.out.println("ID AGEN :"+ e.getId() + "\n NAMA :" + e.getNama()+"\n Alamat :"+ e.getAlamat());   
        }
    }
}
