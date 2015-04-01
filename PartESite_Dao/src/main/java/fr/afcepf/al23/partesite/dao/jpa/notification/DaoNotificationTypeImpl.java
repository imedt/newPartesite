/**
 * 
 */
package fr.afcepf.al23.partesite.dao.jpa.notification;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import fr.afcepf.al23.model.entities.TargetType;
import fr.afcepf.al23.partesite.dao.offer.DaoProjectImpl;
import fr.afcepf.al23.partesite.idao.notification.IDaoNotificationType;

/**
 * @author awagu_000
 *
 */
@Stateless
public class DaoNotificationTypeImpl implements IDaoNotificationType {

	private static Logger log = Logger.getLogger(DaoProjectImpl.class);

	@PersistenceContext (unitName="PartESite_Dao")
	private EntityManager em;
	
	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.idao.notification.IDaoNotificationType#add(fr.afcepf.al23.partesite.model.entities.TargetType)
	 */
	@Override
	public Integer add(TargetType targetType) {
		em.persist(targetType);
		em.flush();
		return targetType.getIdTargetType();
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.idao.notification.IDaoNotificationType#update(fr.afcepf.al23.partesite.model.entities.TargetType)
	 */
	@Override
	public void update(TargetType targetType) {
		em.merge(targetType);
		em.flush();
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.idao.notification.IDaoNotificationType#get(java.lang.Integer)
	 */
	@Override
	public TargetType get(Integer idTargetType) {
		return em.find(TargetType.class, idTargetType);
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.idao.notification.IDaoNotificationType#getAll()
	 */
	@Override
	public List<TargetType> getAll() {
		Query hql = em.createQuery("SELECT t FROM TargetType t");
		List<TargetType> list = hql.getResultList();
		return list;
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.idao.notification.IDaoNotificationType#getByName(java.lang.String)
	 */
	@Override
	public List<TargetType> getByName(String name) {
		Query hql = em.createQuery("SELECT t FROM TargetType t "
				+ "WHERE t.targetTypeName LIKE :targetTypeName")
				.setParameter("targetTypeName", "%" + name + "%");
		List<TargetType> list = hql.getResultList();
		return list;
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.idao.notification.IDaoNotificationType#getByCreatedBy(int)
	 */
	@Override
	public List<TargetType> getByCreatedBy(Integer idIdentity) {
		Query hql = em.createQuery("SELECT t FROM TargetType t "
				+ "WHERE t.createdBy = :idIdentity")
				.setParameter("createdBy", idIdentity);
		List<TargetType> list = hql.getResultList();
		return list;
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.idao.notification.IDaoNotificationType#getByCreatedDate(java.util.Date)
	 */
	@Override
	public List<TargetType> getByCreatedDate(Date createdDate) {
		Query hql = em.createQuery("SELECT t FROM TargetType t "
				+ "WHERE t.createdDate = :createdDate")
				.setParameter("createdDate", createdDate);
		List<TargetType> list = hql.getResultList();
		return list;
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.idao.notification.IDaoNotificationType#getByDisabled(Boolean )
	 */
	@Override
	public List<TargetType> getByDisabled(Boolean  disabled) {
		Query hql = em.createQuery("SELECT t FROM TargetType t "
				+ "WHERE t.disabled = :disabled")
				.setParameter("disabled", disabled);
		List<TargetType> list = hql.getResultList();
		return list;
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.idao.notification.IDaoNotificationType#getByUpdatedBy(int)
	 */
	@Override
	public List<TargetType> getByUpdatedBy(Integer idIdentity) {
		Query hql = em.createQuery("SELECT t FROM TargetType t "
				+ "WHERE t.updatedBy = :updatedBy")
				.setParameter("updatedBy", idIdentity);
		List<TargetType> list = hql.getResultList();
		return list;
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.idao.notification.IDaoNotificationType#getByUpdatedDate(java.util.Date)
	 */
	@Override
	public List<TargetType> getByUpdatedDate(Date updatedDate) {
		Query hql = em.createQuery("SELECT t FROM TargetType t "
				+ "WHERE t.updatedDate = :updatedDate")
				.setParameter("updatedDate", updatedDate);
		List<TargetType> list = hql.getResultList();
		return list;
	}

}
