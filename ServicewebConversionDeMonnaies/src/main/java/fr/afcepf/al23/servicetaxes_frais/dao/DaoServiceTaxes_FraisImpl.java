package fr.afcepf.al23.servicetaxes_frais.dao;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entity.Country;

@Remote(IDaoServiceTaxes_Frais.class)
@Stateless
public class DaoServiceTaxes_FraisImpl implements IDaoServiceTaxes_Frais {

	@PersistenceContext(name = "PartESite_Dao")
	private EntityManager em;

	@Override
	public Country getCountryById(Integer id) {
		Query hql = em.createQuery("SELECT c FROM Country c WHERE c.idCountry = :pId").setParameter("pId", id);
		Country c = null;
		c = (Country) hql.getSingleResult();
		return c;
	}

	@Override
	public Country getCountryByName(String nameCountry) {
		Query hql = em.createQuery("SELECT c FROM Country c WHERE c.name = :pNameCountry").setParameter("pNameCountry", nameCountry);
		Country c = null;
		c = (Country) hql.getSingleResult();
		return c;
	}

	@Override
	public List<Country> getAllCountries() {
		Query hql = em.createQuery("SELECT c FROM Country c");
		List<Country> list = hql.getResultList();
		return list;
	}
}
