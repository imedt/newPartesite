/**
 * 
 */
package fr.afcepf.al23.partesite.dao.jpa.transaction;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import fr.afcepf.al23.partesite.dao.offer.DaoProjectImpl;
import fr.afcepf.al23.partesite.idao.transaction.IDaoOrderRow;
import fr.afcepf.al23.partesite.model.entities.Item;
import fr.afcepf.al23.partesite.model.entities.OrderRow;
import fr.afcepf.al23.partesite.model.entities.UserOrder;

/**
 * @author awagu_000
 *
 */
@Stateless
public class DaoOrderRowImpl implements IDaoOrderRow {

	private static Logger log = Logger.getLogger(DaoProjectImpl.class);

	@PersistenceContext (unitName="PartESite_Dao")
	private EntityManager em;

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.idao.transaction.IDaoOrderRow#add(fr.afcepf.al23.partesite.model.entities.OrderRow)
	 */
	@Override
	public OrderRow add(OrderRow orderRow) {
		em.persist(orderRow);
		em.flush();
		return orderRow;
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.idao.transaction.IDaoOrderRow#update(fr.afcepf.al23.partesite.model.entities.OrderRow)
	 */
	@Override
	public OrderRow update(OrderRow orderRow) {
		em.merge(orderRow);
		em.flush();
		return orderRow;
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.idao.transaction.IDaoOrderRow#get(java.lang.Integer)
	 */
	@Override
	public OrderRow get(Integer idOrderRow) {
		return em.find(OrderRow.class, idOrderRow);
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.idao.transaction.IDaoOrderRow#getAll()
	 */
	@Override
	public List<OrderRow> getAll() {
		Query hql = em.createQuery("SELECT o FROM OrderRow o");
		List<OrderRow> list = hql.getResultList();
		return list;
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.idao.transaction.IDaoOrderRow#getByAmount(double)
	 */
	@Override
	public List<OrderRow> getByAmount(double amount) {
		Query hql = em.createQuery("SELECT o FROM OrderRow o "
				+ "WHERE o.amount = :amount")
				.setParameter("amount", amount);
		List<OrderRow> list = hql.getResultList();
		return list;
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.idao.transaction.IDaoOrderRow#getByCreatedBy(int)
	 */
	@Override
	public List<OrderRow> getByCreatedBy(int idIdentity) {
		Query hql = em.createQuery("SELECT o FROM OrderRow o "
				+ "WHERE o.createdBy = :createdBy");
		hql.setParameter("createdBy", idIdentity);
		List<OrderRow> list = hql.getResultList();
		return list;
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.idao.transaction.IDaoOrderRow#getByCreatedDate(java.util.Date)
	 */
	@Override
	public List<OrderRow> getByCreatedDate(Date createdDate) {
		Query hql = em.createQuery("SELECT o FROM OrderRow o "
				+ "WHERE o.createdDate = :createdDate")
				.setParameter("createdDate", createdDate);
		List<OrderRow> list = hql.getResultList();
		return list;
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.idao.transaction.IDaoOrderRow#getByDisabled(boolean)
	 */
	@Override
	public List<OrderRow> getByDisabled(boolean disabled) {
		Query hql = em.createQuery("SELECT o FROM OrderRow o "
				+ "WHERE o.disabled = :disabled")
				.setParameter("disabled", disabled);
		List<OrderRow> list = hql.getResultList();
		return list;
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.idao.transaction.IDaoOrderRow#getByUpdatedBy(int)
	 */
	@Override
	public List<OrderRow> getByUpdatedBy(int idIdentity) {
		Query hql = em.createQuery("SELECT o FROM OrderRow o "
				+ "WHERE o.updatedBy = :updatedBy")
				.setParameter("updatedBy", idIdentity);
		List<OrderRow> list = hql.getResultList();
		return list;
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.idao.transaction.IDaoOrderRow#getByUpdatedDate(java.util.Date)
	 */
	@Override
	public List<OrderRow> getByUpdatedDate(Date updatedDate) {
		Query hql = em.createQuery("SELECT o FROM OrderRow o "
				+ "WHERE o.updatedDate = :updatedDate")
				.setParameter("updatedDate", updatedDate);
		List<OrderRow> list = hql.getResultList();
		return list;
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.idao.transaction.IDaoOrderRow#getByItem(fr.afcepf.al23.partesite.model.entities.Item)
	 */
	@Override
	public List<OrderRow> getByItem(Item item) {
		Query hql = em.createQuery("SELECT o FROM OrderRow o "
				+ "WHERE o.item = :item")
				.setParameter("item", item);
		List<OrderRow> list = hql.getResultList();
		return list;
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.idao.transaction.IDaoOrderRow#getByUserRow(fr.afcepf.al23.partesite.model.entities.UserOrder)
	 */
	@Override
	public List<OrderRow> getByUserRow(UserOrder userOrder) {
		Query hql = em.createQuery("SELECT o FROM OrderRow o "
				+ "WHERE o.userOrder = :userOrder")
				.setParameter("userOrder", userOrder);
		List<OrderRow> list = hql.getResultList();
		return list;
	}

}
