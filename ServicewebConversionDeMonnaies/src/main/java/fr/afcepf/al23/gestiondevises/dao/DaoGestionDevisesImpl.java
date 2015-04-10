package fr.afcepf.al23.gestiondevises.dao;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.al23.entity.Currency;

@Remote(IDaoGestionDevises.class)
@Stateless
public class DaoGestionDevisesImpl implements IDaoGestionDevises {

	@PersistenceContext(name="PartESite_Dao")
	private EntityManager em;
	
	@Override
	public Currency getCurrency(String nomDevise) {
		Query hql = em.createQuery("SELECT c FROM Currency c WHERE c.name =:pNomDevise").setParameter("pNomDevise", nomDevise);
		Currency c = null;
		c = (Currency) hql.getSingleResult();
		return c;
	}

}
