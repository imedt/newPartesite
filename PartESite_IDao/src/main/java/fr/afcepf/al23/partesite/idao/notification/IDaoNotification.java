package fr.afcepf.al23.partesite.idao.notification;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import fr.afcepf.al23.model.entities.Notification;
import fr.afcepf.al23.model.entities.TargetType;


@Remote
public interface IDaoNotification {
	public Integer add(Notification notification);
	public Notification update(Notification notification);
	public Notification get(Integer idNotification);
	public List<Notification> getAll();
	public List<Notification> getByContent(String contentNotification);
	public List<Notification> getByCreatedBy(Integer idIdentity);
	public List<Notification> getByCreatedDate(Date createdDate);	
	public List<Notification> getByDisabled(Boolean  disabled);
	public List<Notification> getByTarget(Integer idTarget);
	public List<Notification> getByTargetType(TargetType targetType);
	public List<Notification> getByUpdatedBy(Integer idIdentity);
	public List<Notification> getByUpdatedDate(Date updatedDate);
}
