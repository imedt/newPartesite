/**
 * 
 */
package fr.afcepf.al23.partesite.service.impl.notification;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import fr.afcepf.al23.model.entities.TargetType;
import fr.afcepf.al23.partesite.idao.notification.IDaoNotificationType;
import fr.afcepf.al23.partesite.iservice.notification.IBusinessNotificationType;

/**
 * @author awagu_000
 *
 */
@Stateless
public class BusinessNotificationTypeImpl implements IBusinessNotificationType {

	private static Logger log = Logger.getLogger(BusinessNotificationTypeImpl.class);
	
	@EJB
	private IDaoNotificationType daoTargetType;

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.iservice.notification.IBusinessNotificationType#save(fr.afcepf.al23.partesite.model.entities.TargetType)
	 */
	@Override
	public void save(TargetType targetType) {
		log.info("BusinessNotificationTypeImpl, save");
		if (daoTargetType.get(targetType.getIdTargetType()) != null){
			daoTargetType.update(targetType);
		} else {
			daoTargetType.add(targetType);
		}
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.iservice.notification.IBusinessNotificationType#get(java.lang.Integer)
	 */
	@Override
	public TargetType get(Integer idTargetType) {
		log.info("BusinessNotificationTypeImpl, get");
		return daoTargetType.get(idTargetType);
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.iservice.notification.IBusinessNotificationType#getAll()
	 */
	@Override
	public List<TargetType> getAll() {
		log.info("BusinessNotificationTypeImpl, getAll");
		return daoTargetType.getAll();
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.iservice.notification.IBusinessNotificationType#getByName(java.lang.String)
	 */
	@Override
	public List<TargetType> getByName(String name) {
		log.info("BusinessNotificationTypeImpl, getByName");
		return daoTargetType.getByName(name);
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.iservice.notification.IBusinessNotificationType#getByCreatedBy(int)
	 */
	@Override
	public List<TargetType> getByCreatedBy(Integer idIdentity) {
		log.info("BusinessNotificationTypeImpl, getByCreatedBy");
		return daoTargetType.getByCreatedBy(idIdentity);
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.iservice.notification.IBusinessNotificationType#getByCreatedDate(java.util.Date)
	 */
	@Override
	public List<TargetType> getByCreatedDate(Date createdDate) {
		log.info("BusinessNotificationTypeImpl, getByCreatedDate");
		return daoTargetType.getByCreatedDate(createdDate);
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.iservice.notification.IBusinessNotificationType#getByDisabled(boolean)
	 */
	@Override
	public List<TargetType> getByDisabled(Boolean disabled) {
		log.info("BusinessNotificationTypeImpl, getByDisabled");
		return daoTargetType.getByDisabled(disabled);
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.iservice.notification.IBusinessNotificationType#getByUpdatedBy(int)
	 */
	@Override
	public List<TargetType> getByUpdatedBy(Integer idIdentity) {
		log.info("BusinessNotificationTypeImpl, getByUpdatedBy");
		return daoTargetType.getByUpdatedBy(idIdentity);
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.iservice.notification.IBusinessNotificationType#getByUpdatedDate(java.util.Date)
	 */
	@Override
	public List<TargetType> getByUpdatedDate(Date updatedDate) {
		log.info("BusinessNotificationTypeImpl, getByUpdatedDate");
		return daoTargetType.getByUpdatedDate(updatedDate);
	}

}
