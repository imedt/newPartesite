package fr.afcepf.al23.partesite.dao.jpa.user;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.al23.model.entities.IdentityRight;
import fr.afcepf.al23.model.entities.IdentityRole;
import fr.afcepf.al23.partesite.idao.user.IDaoIdentityRole;
@Stateless
public class DaoIdentityRoleImpl implements IDaoIdentityRole {

	public DaoIdentityRoleImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext(unitName = "PartESite_Dao")
	private EntityManager em;
	
	@Override
	public IdentityRole add(IdentityRole identityRole) {
		em.persist(identityRole);
		em.flush();
		return identityRole;
	}

	@Override
	public IdentityRole update(IdentityRole identityRole) {
		em.merge(identityRole);
		em.flush();
		return identityRole;
	}

	@Override
	public IdentityRole get(Integer  idIdentityRole) {
		IdentityRole identityRole = null;
		Query hql = em
				.createQuery(
						"SELECT identRo FROM IdentityRole identRo WHERE identRo.idIdentityRole = :id_identityRole")
				.setParameter("id_identityRole", idIdentityRole);
		identityRole = (IdentityRole) hql.getSingleResult();
		return identityRole;
	}

	@Override
	public List<IdentityRight> getRights(Integer  idIdentityRole) {
		List<IdentityRight> identityRights = null;
		DaoIdentityRightImpl daoRight = new DaoIdentityRightImpl();
		identityRights = daoRight.getByIdRole(idIdentityRole);
		return identityRights;
	}

	@Override
	public Boolean roleExist(String roleName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<IdentityRole> getAll() {
		List<IdentityRole> identityRoles = null;
		Query hql = em
				.createQuery(
						"SELECT identRo FROM identityRole identRo");
		identityRoles =  hql.getResultList();
		return identityRoles;
	}

}
