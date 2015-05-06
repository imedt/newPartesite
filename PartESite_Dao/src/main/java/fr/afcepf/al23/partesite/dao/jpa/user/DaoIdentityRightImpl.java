package fr.afcepf.al23.partesite.dao.jpa.user;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.al23.model.entities.IdentityRight;
import fr.afcepf.al23.partesite.idao.user.IDaoIdentityRight;
@Stateless
public class DaoIdentityRightImpl implements IDaoIdentityRight {

	public DaoIdentityRightImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext(unitName = "PartESite_Dao")
	private EntityManager em;

	@Override
	public IdentityRight add(IdentityRight identityRight) {
		em.persist(identityRight);
		em.flush();
		return identityRight;
	}

	@Override
	public IdentityRight update(IdentityRight identityRight) {
		em.merge(identityRight);
		em.flush();
		return identityRight;
	}

	@Override
	public IdentityRight get(Integer  idIdentityRight) {
		IdentityRight identityRight = null;
		Query hql = em
				.createQuery(
						"SELECT identRi FROM IdentityRight identRi WHERE identRi.idIdentityRight = :id_identityRight")
				.setParameter("id_identityRight", idIdentityRight);
		identityRight = (IdentityRight) hql.getSingleResult();
		return identityRight;
	}

	@Override
	public List<IdentityRight> getAll() {
		List<IdentityRight> identityRights = null;
		Query hql = em.createQuery("SELECT identRi FROM IdentityRight identRi");
		identityRights = hql.getResultList();
		return identityRights;
	}

	@Override
	public List<IdentityRight> getByIdRole(Integer  idIdentityRole) {
		List<IdentityRight> identityRights = null;
		Query hql = em
				.createQuery(
						"SELECT identRi FROM IdentityRight identRi WHERE identRi.idIdentityRole = :id_identityRole")
				.setParameter("id_identityRole", idIdentityRole);
		identityRights = hql.getResultList();
		return identityRights;
	}

	@Override
	public Boolean  rightExist(String actionName) {
		List<IdentityRight> identityRights = null;
		Query hql = em
				.createQuery(
						"SELECT identRi FROM IdentityRight identRi WHERE identRi.actionName = :actionName")
				.setParameter("actionName", actionName);
		identityRights = hql.getResultList();
		if (identityRights != null || !identityRights.isEmpty())
			return true;
		else
			return false;
	}

}
