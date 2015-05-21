package aspiro;

import java.awt.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import fr.afcepf.al23.model.entities.Pack;
import fr.afcepf.al23.model.entities.Project;
import fr.afcepf.al23.model.entities.ProjectContent;


public class DAO {
	  private static final String PERSISTENCE_UNIT_NAME = "PartESite_Dao";
	  private static EntityManagerFactory factory;
	  private EntityManager em; 
	  public DAO(){ 
	    factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	    em = factory.createEntityManager();
	  }
	  public void save(Project p){ 
	        EntityTransaction tx = em.getTransaction();
	        try {
	            tx.begin();
	            em.persist(p);
	            for(ProjectContent pc : p.getProjectContents()){
	            	em.persist(pc);
	            }
	            for(Pack pack : p.getPacks()){
	            	em.persist(pack); 
	            }
	            tx.commit();
	        } catch (RuntimeException re) {
	            if(tx.isActive()) {
	                tx.rollback();
	            } 
	        }
	  }
	  public void close(){
		  em.close(); 
	  }
}
