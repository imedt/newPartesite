/**
 * 
 */
package fr.afcepf.al23.partesite.service.impl.notification;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import fr.afcepf.al23.model.entities.Notification;
import fr.afcepf.al23.model.entities.TargetType;
import fr.afcepf.al23.partesite.idao.notification.IDaoNotification;
import fr.afcepf.al23.partesite.iservice.notification.IBusinessNotification;

/**
 * @author awagu_000
 *
 */
@Stateless
public class BusinessNotificationImpl implements IBusinessNotification {

	private static Logger log = Logger.getLogger(BusinessNotificationImpl.class);
	
	@EJB
	private IDaoNotification daoNotification;

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.iservice.notification.IBusinessNotification#save(fr.afcepf.al23.partesite.model.entities.Notification)
	 */

	@Override
	public void save(Notification notification) {
		log.info("BusinessNotificationImpl, save");
		if (notification.getIdNotification() != null){
			notification = daoNotification.update(notification);
		} else {
			daoNotification.add(notification);
		}
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.iservice.notification.IBusinessNotification#get(java.lang.Integer)
	 */
	@Override
	public Notification get(Integer idNotification) {
		log.info("BusinessNotificationImpl, get");
		return daoNotification.get(idNotification);
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.iservice.notification.IBusinessNotification#getAll()
	 */
	@Override
	public List<Notification> getAll() {
		log.info("BusinessNotificationImpl, getAll");
		return daoNotification.getAll();
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.iservice.notification.IBusinessNotification#getByContent(java.lang.String)
	 */
	@Override
	public List<Notification> getByContent(String contentNotification) {
		log.info("BusinessNotificationImpl, getByContent");
		return daoNotification.getByContent(contentNotification);
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.iservice.notification.IBusinessNotification#getByCreatedBy(int)
	 */
	@Override
	public List<Notification> getByCreatedBy(Integer idIdentity) {
		log.info("BusinessNotificationImpl, getByCreatedBy");
		return daoNotification.getByCreatedBy(idIdentity);
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.iservice.notification.IBusinessNotification#getByCreatedDate(java.util.Date)
	 */
	@Override
	public List<Notification> getByCreatedDate(Date createdDate) {
		log.info("BusinessNotificationImpl, getByCreatedDate");
		return daoNotification.getByCreatedDate(createdDate);
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.iservice.notification.IBusinessNotification#getByDisabled(boolean)
	 */
	@Override
	public List<Notification> getByDisabled(Boolean disabled) {
		log.info("BusinessNotificationImpl, getByDisabled");
		return daoNotification.getByDisabled(disabled);
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.iservice.notification.IBusinessNotification#getByTarget(int)
	 */
	@Override
	public List<Notification> getByTarget(Integer idTarget) {
		log.info("BusinessNotificationImpl, getByTarget "+idTarget);
		return daoNotification.getByTarget(idTarget);
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.iservice.notification.IBusinessNotification#getByTargetType(fr.afcepf.al23.partesite.model.entities.TargetType)
	 */
	@Override
	public List<Notification> getByTargetType(TargetType targetType) {
		log.info("BusinessNotificationImpl, getByTargetType");
		return daoNotification.getByTargetType(targetType);
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.iservice.notification.IBusinessNotification#getByUpdatedBy(int)
	 */
	@Override
	public List<Notification> getByUpdatedBy(Integer idIdentity) {
		log.info("BusinessNotificationImpl, getByUpdatedBy");
		return daoNotification.getByUpdatedBy(idIdentity);
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.iservice.notification.IBusinessNotification#getByUpdatedDate(java.util.Date)
	 */
	@Override
	public List<Notification> getByUpdatedDate(Date updatedDate) {
		log.info("BusinessNotificationImpl, getByUpdatedDate");
		return daoNotification.getByUpdatedDate(updatedDate);
	}

}
