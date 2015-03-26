/**
 * 
 */
package fr.afcepf.al23.partesite.dao.jpa.notification;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import fr.afcepf.al23.partesite.dao.offer.DaoProjectImpl;
import fr.afcepf.al23.partesite.idao.notification.IDaoNotification;
import fr.afcepf.al23.partesite.model.entities.Notification;
import fr.afcepf.al23.partesite.model.entities.OrderRow;
import fr.afcepf.al23.partesite.model.entities.TargetType;

/**
 * @author awagu_000
 *
 */
@Stateless
public class DaoNotificationImpl implements IDaoNotification {

	private static Logger log = Logger.getLogger(DaoProjectImpl.class);

	@PersistenceContext (unitName="PartESite_Dao")
	private EntityManager em;

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.idao.notification.IDaoNotification#add(fr.afcepf.al23.partesite.model.entities.Notification)
	 */
	@Override
	public Integer add(Notification notification) {
		em.persist(notification);
		em.flush();
		return notification.getIdNotification();
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.idao.notification.IDaoNotification#update(fr.afcepf.al23.partesite.model.entities.Notification)
	 */
	@Override
	public void update(Notification notification) {
		em.merge(notification);
		em.flush();
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.idao.notification.IDaoNotification#get(java.lang.Integer)
	 */
	@Override
	public Notification get(Integer idNotification) {
		return em.find(Notification.class, idNotification);
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.idao.notification.IDaoNotification#getAll()
	 */
	@Override
	public List<Notification> getAll() {
		Query hql = em.createQuery("SELECT n FROM Notification n");
		List<Notification> list = hql.getResultList();
		return list;
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.idao.notification.IDaoNotification#getByContent(java.lang.String)
	 */
	@Override
	public List<Notification> getByContent(String content) {
		Query hql = em.createQuery("SELECT n FROM Notification n "
				+ "WHERE n.contentNotification LIKE :contentNotification")
				.setParameter("contentNotification", "%" + content + "%");
		List<Notification> list = hql.getResultList();
		return list;
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.idao.notification.IDaoNotification#getByCreatedBy(int)
	 */
	@Override
	public List<Notification> getByCreatedBy(int idIdentity) {
		Query hql = em.createQuery("SELECT n FROM Notification n "
				+ "WHERE n.createdBy = :idIdentity")
				.setParameter("createdBy", idIdentity);
		List<Notification> list = hql.getResultList();
		return list;
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.idao.notification.IDaoNotification#getByCreatedDate(java.util.Date)
	 */
	@Override
	public List<Notification> getByCreatedDate(Date createdDate) {
		Query hql = em.createQuery("SELECT n FROM Notification n "
				+ "WHERE n.createdDate = :createdDate")
				.setParameter("createdDate", createdDate);
		List<Notification> list = hql.getResultList();
		return list;
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.idao.notification.IDaoNotification#getByDisabled(boolean)
	 */
	@Override
	public List<Notification> getByDisabled(boolean disabled) {
		Query hql = em.createQuery("SELECT n FROM Notification n "
				+ "WHERE n.disabled = :disabled")
				.setParameter("disabled", disabled);
		List<Notification> list = hql.getResultList();
		return list;
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.idao.notification.IDaoNotification#getByTarget(int)
	 */
	@Override
	public List<Notification> getByTarget(int idTarget) {
		Query hql = em.createQuery("SELECT n FROM Notification n "
				+ "WHERE n.idTarget = :idTarget")
				.setParameter("idTarget", idTarget);
		List<Notification> list = hql.getResultList();
		return list;
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.idao.notification.IDaoNotification#getByTargetType(fr.afcepf.al23.partesite.model.entities.TargetType)
	 */
	@Override
	public List<Notification> getByTargetType(TargetType targetType) {
		Query hql = em.createQuery("SELECT n FROM Notification n "
				+ "WHERE n.targetType = :targetType")
				.setParameter("targetType", targetType);
		List<Notification> list = hql.getResultList();
		return list;
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.idao.notification.IDaoNotification#getByUpdatedBy(int)
	 */
	@Override
	public List<Notification> getByUpdatedBy(int idIdentity) {
		Query hql = em.createQuery("SELECT n FROM Notification n "
				+ "WHERE n.updatedBy = :updatedBy")
				.setParameter("updatedBy", idIdentity);
		List<Notification> list = hql.getResultList();
		return list;
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.idao.notification.IDaoNotification#getByUpdatedDate(java.util.Date)
	 */
	@Override
	public List<Notification> getByUpdatedDate(Date updatedDate) {
		Query hql = em.createQuery("SELECT n FROM Notification n "
				+ "WHERE n.updatedDate = :updatedDate")
				.setParameter("updatedDate", updatedDate);
		List<Notification> list = hql.getResultList();
		return list;
	}

}
