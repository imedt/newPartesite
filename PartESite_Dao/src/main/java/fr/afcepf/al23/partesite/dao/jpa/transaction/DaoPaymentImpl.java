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

import fr.afcepf.al23.model.entities.Payment;
import fr.afcepf.al23.model.entities.UserOrder;
import fr.afcepf.al23.partesite.dao.offer.DaoProjectImpl;
import fr.afcepf.al23.partesite.idao.transaction.IDaoPayment;

/**
 * @author awagu_000
 *
 */
@Stateless
public class DaoPaymentImpl implements IDaoPayment {

	private static Logger log = Logger.getLogger(DaoProjectImpl.class);

	@PersistenceContext (unitName="PartESite_Dao")
	private EntityManager em;

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.idao.transaction.IDaoPayment#add(fr.afcepf.al23.partesite.model.entities.Payment)
	 */
	@Override
	public Integer add(Payment payment) {
		em.persist(payment);
		em.flush();
		return payment.getIdPayment();
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.idao.transaction.IDaoPayment#update(fr.afcepf.al23.partesite.model.entities.Payment)
	 */
	@Override
	public void update(Payment payment) {
		em.merge(payment);
		em.flush();
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.idao.transaction.IDaoPayment#get(java.lang.Integer)
	 */
	@Override
	public Payment get(Integer idPayment) {
		return em.find(Payment.class, idPayment);
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.idao.transaction.IDaoPayment#getAll()
	 */
	@Override
	public List<Payment> getAll() {
		Query hql = em.createQuery("SELECT p FROM Payment p");
		List<Payment> list = hql.getResultList();
		return list;
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.idao.transaction.IDaoPayment#getByCreatedBy(int)
	 */
	@Override
	public List<Payment> getByCreatedBy(Integer idIdentity) {
		Query hql = em.createQuery("SELECT p FROM Payment p "
				+ "WHERE p.createdBy = :createdBy");
		hql.setParameter("createdBy", idIdentity);
		List<Payment> list = hql.getResultList();
		return list;
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.idao.transaction.IDaoPayment#getByCreatedDate(java.util.Date)
	 */
	@Override
	public List<Payment> getByCreatedDate(Date createdDate) {
		Query hql = em.createQuery("SELECT p FROM Payment p "
				+ "WHERE p.createdDate = :createdDate");
		hql.setParameter("createdDate", createdDate);
		List<Payment> list = hql.getResultList();
		return list;
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.idao.transaction.IDaoPayment#getByDisabled(boolean)
	 */
	@Override
	public List<Payment> getByDisabled(Boolean disabled) {
		Query hql = em.createQuery("SELECT p FROM Payment p "
				+ "WHERE p.disabled = :disabled");
		hql.setParameter("disabled", disabled);
		List<Payment> list = hql.getResultList();
		return list;
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.idao.transaction.IDaoPayment#getByUpdatedBy(int)
	 */
	@Override
	public List<Payment> getByUpdatedBy(Integer idIdentity) {
		Query hql = em.createQuery("SELECT p FROM Payment p "
				+ "WHERE p.updatedBy = :updatedBy");
		hql.setParameter("updatedBy", idIdentity);
		List<Payment> list = hql.getResultList();
		return list;
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.idao.transaction.IDaoPayment#getByUpdatedDate(java.util.Date)
	 */
	@Override
	public List<Payment> getByUpdatedDate(Date updatedDate) {
		Query hql = em.createQuery("SELECT p FROM Payment p "
				+ "WHERE p.updatedDate = :updatedDate");
		hql.setParameter("updatedDate", updatedDate);
		List<Payment> list = hql.getResultList();
		return list;
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.idao.transaction.IDaoPayment#getByUserOrder(fr.afcepf.al23.partesite.model.entities.UserOrder)
	 */
	@Override
	public List<Payment> getByUserOrder(UserOrder userOrder) {
		Query hql = em.createQuery("SELECT p FROM Payment p "
				+ "WHERE p.userOrder = :userOrder");
		hql.setParameter("userOrder", userOrder);
		List<Payment> list = hql.getResultList();
		return list;
	}

}
