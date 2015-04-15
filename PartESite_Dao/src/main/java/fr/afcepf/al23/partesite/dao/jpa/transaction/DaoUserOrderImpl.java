/**
 * 
 */
package fr.afcepf.al23.partesite.dao.jpa.transaction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import fr.afcepf.al23.model.entities.Identity;
import fr.afcepf.al23.model.entities.UserOrder;
import fr.afcepf.al23.partesite.dao.offer.DaoProjectImpl;
import fr.afcepf.al23.partesite.idao.transaction.IDaoUserOrder;

/**
 * @author awagu_000
 *
 */
@Stateless
public class DaoUserOrderImpl implements IDaoUserOrder {

	private static Logger log = Logger.getLogger(DaoProjectImpl.class);

	@PersistenceContext (unitName="PartESite_Dao")
	private EntityManager em;

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.idao.transaction.IDaoUserOrder#add(fr.afcepf.al23.partesite.model.entities.UserOrder)
	 */
	@Override
	public Integer add(UserOrder userOrder) {
		em.persist(userOrder);
		em.flush();
		return userOrder.getIdUserOrder();
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.idao.transaction.IDaoUserOrder#update(fr.afcepf.al23.partesite.model.entities.UserOrder)
	 */
	@Override
	public UserOrder update(UserOrder userOrder) {
		userOrder = em.merge(userOrder);
		em.flush();
		return userOrder;
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.idao.transaction.IDaoUserOrder#get(java.lang.Integer)
	 */
	@Override
	public UserOrder get(Integer idUserOrder) {
		return em.find(UserOrder.class, idUserOrder);
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.idao.transaction.IDaoUserOrder#getAll()
	 */
	@Override
	public List<UserOrder> getAll() {
		Query hql = em.createQuery("SELECT DISTINCT uo FROM UserOrder uo inner join fetch uo.orderRows ");
		List<UserOrder> list = hql.getResultList();
		return list;
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.idao.transaction.IDaoUserOrder#getByTotalAmount(double)
	 */
	@Override
	public List<UserOrder> getByTotalAmount(Double totalAmount) {
		Query hql = em.createQuery("SELECT DISTINCT uo FROM UserOrder uo inner join fetch uo.orderRows "
				+ "WHERE uo.totalAmount = :totalAmount");
		hql.setParameter("totalAmount", totalAmount);
		List<UserOrder> list = hql.getResultList();
		return list;
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.idao.transaction.IDaoUserOrder#getByCreatedBy(int)
	 */
	@Override
	public List<UserOrder> getByCreatedBy(Integer idIdentity) {
		Query hql = em.createQuery("SELECT DISTINCT uo FROM UserOrder uo inner join fetch uo.orderRows "
				+ "WHERE uo.createdBy = :createdBy");
		hql.setParameter("createdBy", idIdentity);
		List<UserOrder> list = hql.getResultList();
		return list;
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.idao.transaction.IDaoUserOrder#getByCreatedDate(java.util.Date)
	 */
	@Override
	public List<UserOrder> getByCreatedDate(Date createdDate) {
		Query hql = em.createQuery("SELECT DISTINCT uo FROM UserOrder uo "
				+ "WHERE uo.createdDate = :createdDate");
		hql.setParameter("createdDate", createdDate);
		List<UserOrder> list = hql.getResultList();
		return list;
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.idao.transaction.IDaoUserOrder#getByDisabled(boolean)
	 */
	@Override
	public List<UserOrder> getByDisabled(Boolean disabled) {
		Query hql = em.createQuery("SELECT uo FROM UserOrder uo "
				+ "WHERE uo.disabled = :disabled");
		hql.setParameter("disabled", disabled);
		List<UserOrder> list = hql.getResultList();
		return list;
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.idao.transaction.IDaoUserOrder#getByUpdatedBy(int)
	 */
	@Override
	public List<UserOrder> getByUpdatedBy(Integer idIdentity) {
		Query hql = em.createQuery("SELECT uo FROM UserOrder uo "
				+ "WHERE uo.updatedBy = :updatedBy");
		hql.setParameter("updatedBy", idIdentity);
		List<UserOrder> list = hql.getResultList();
		return list;
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.idao.transaction.IDaoUserOrder#getByUpdatedDate(java.util.Date)
	 */
	@Override
	public List<UserOrder> getByUpdatedDate(Date updatedDate) {
		Query hql = em.createQuery("SELECT uo FROM UserOrder uo "
				+ "WHERE uo.updatedDate = :updatedDate");
		hql.setParameter("updatedDate", updatedDate);
		List<UserOrder> list = hql.getResultList();
		return list;
	}

	@Override
	public List<UserOrder> getByIdentity(Identity identity) {
		List<UserOrder> list = new ArrayList<>();
		try {
			Query hql = em.createQuery("SELECT DISTINCT uo FROM UserOrder uo inner join fetch uo.orderRows "
					+ "WHERE uo.identity = :identity");
			hql.setParameter("identity", identity);
			list = hql.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
