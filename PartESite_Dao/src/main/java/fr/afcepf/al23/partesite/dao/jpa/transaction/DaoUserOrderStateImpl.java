/**
 * 
 */
package fr.afcepf.al23.partesite.dao.jpa.transaction;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import fr.afcepf.al23.model.entities.UserOrderState;
import fr.afcepf.al23.partesite.dao.offer.DaoProjectImpl;
import fr.afcepf.al23.partesite.idao.transaction.IDaoUserOrderState;

/**
 * @author awagu_000
 *
 */
@Stateless
public class DaoUserOrderStateImpl implements IDaoUserOrderState {

	private static Logger log = Logger.getLogger(DaoProjectImpl.class);

	@PersistenceContext (unitName="PartESite_Dao")
	private EntityManager em;

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.idao.transaction.IDaoUserOrderState#add(fr.afcepf.al23.partesite.model.entities.UserOrderState)
	 */
	@Override
	public Integer add(UserOrderState userOrderState) {
		em.persist(userOrderState);
		em.flush();
		return userOrderState.getIdUserOrderState();
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.idao.transaction.IDaoUserOrderState#update(fr.afcepf.al23.partesite.model.entities.UserOrderState)
	 */
	@Override
	public void update(UserOrderState userOrderState) {
		em.merge(userOrderState);
		em.flush();
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.idao.transaction.IDaoUserOrderState#get(java.lang.Integer)
	 */
	@Override
	public UserOrderState get(Integer idUserOrderState) {
		return em.find(UserOrderState.class, idUserOrderState);
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.idao.transaction.IDaoUserOrderState#getAll()
	 */
	@Override
	public List<UserOrderState> getAll() {
		Query hql = em.createQuery("SELECT uos FROM UserOrderState uos ");
		List<UserOrderState> list = hql.getResultList();
		return list;
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.idao.transaction.IDaoUserOrderState#getByName(java.lang.String)
	 */
	@Override
	public List<UserOrderState> getByName(String name) {
		Query hql = em.createQuery("SELECT uos FROM UserOrderState uos "
				+ "WHERE uos.userOrderStateName LIKE :name");
		hql.setParameter("name", "%" + name + "%");
		List<UserOrderState> list = hql.getResultList();
		return list;
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.idao.transaction.IDaoUserOrderState#getByCreatedBy(int)
	 */
	@Override
	public List<UserOrderState> getByCreatedBy(Integer idIdentity) {
		Query hql = em.createQuery("SELECT uos FROM UserOrderState uos "
				+ "WHERE uos.createdBy = :createdBy");
		hql.setParameter("createdBy", idIdentity);
		List<UserOrderState> list = hql.getResultList();
		return list;
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.idao.transaction.IDaoUserOrderState#getByCreatedDate(java.util.Date)
	 */
	@Override
	public List<UserOrderState> getByCreatedDate(Date createdDate) {
		Query hql = em.createQuery("SELECT uos FROM UserOrderState uos "
				+ "WHERE uos.createdDate = :createdDate");
		hql.setParameter("createdDate", createdDate);
		List<UserOrderState> list = hql.getResultList();
		return list;
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.idao.transaction.IDaoUserOrderState#getByDisabled(boolean)
	 */
	@Override
	public List<UserOrderState> getByDisabled(Boolean disabled) {
		Query hql = em.createQuery("SELECT uos FROM UserOrderState uos "
				+ "WHERE uos.disabled = :disabled");
		hql.setParameter("disabled", disabled);
		List<UserOrderState> list = hql.getResultList();
		return list;
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.idao.transaction.IDaoUserOrderState#getByUpdatedBy(int)
	 */
	@Override
	public List<UserOrderState> getByUpdatedBy(Integer idIdentity) {
		Query hql = em.createQuery("SELECT uos FROM UserOrderState uos "
				+ "WHERE uos.updatedBy = :updatedBy");
		hql.setParameter("updatedBy", idIdentity);
		List<UserOrderState> list = hql.getResultList();
		return list;
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.idao.transaction.IDaoUserOrderState#getByUpdatedDate(java.util.Date)
	 */
	@Override
	public List<UserOrderState> getByUpdatedDate(Date updatedDate) {
		Query hql = em.createQuery("SELECT uos FROM UserOrderState uos "
				+ "WHERE uos.updatedDate = :updatedDate");
		hql.setParameter("updatedDate", updatedDate);
		List<UserOrderState> list = hql.getResultList();
		return list;
	}

}
