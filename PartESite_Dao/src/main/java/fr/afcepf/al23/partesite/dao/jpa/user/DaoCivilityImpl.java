package fr.afcepf.al23.partesite.dao.jpa.user;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.al23.model.entities.Civility;
import fr.afcepf.al23.partesite.idao.user.IDaoCivility;
@Stateless
public class DaoCivilityImpl implements IDaoCivility {

	public DaoCivilityImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext(unitName = "PartESite_Dao")
	private EntityManager em;

	@Override
	public Civility add(Civility civility) {
		em.persist(civility);
		em.flush();
		return civility;
	}

	@Override
	public Civility update(Civility civility) {
		em.merge(civility);
		em.flush();
		return civility;
	}

	@Override
	public Civility get(Integer idCivility) {
		Civility civility = null;
		Query hql = em
				.createQuery(
						"SELECT civ FROM Civility civ WHERE civ.idCivility = :id_civility")
				.setParameter("id_civility", idCivility);
		civility = (Civility) hql.getSingleResult();
		return civility;
	}

	@Override
	public List<Civility> getall() {
		List<Civility> civilities = null;
		Query hql = em.createQuery(
				"SELECT civ FROM Civility civ");
		civilities = hql.getResultList();
		return civilities;
	}

	@Override
	public Boolean civilityExist(String civilityName) {
		Civility civility = null;
		Query hql = em.createQuery(
				"SELECT civ FROM Civility civ WHERE civ.civility = :civility")
				.setParameter("civility", civilityName);
		civility = (Civility) hql.getSingleResult();
		if (civility != null)
			return true;
		else
			return false;
	}

}
