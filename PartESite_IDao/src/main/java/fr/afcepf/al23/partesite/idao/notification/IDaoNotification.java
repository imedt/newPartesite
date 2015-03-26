package fr.afcepf.al23.partesite.idao.notification;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import fr.afcepf.al23.partesite.model.entities.Notification;
import fr.afcepf.al23.partesite.model.entities.TargetType;

@Remote
public interface IDaoNotification {
	public Integer add(Notification notification);
	public void update(Notification notification);
	public Notification get(Integer idNotification);
	public List<Notification> getAll();
	public List<Notification> getByContent(String contentNotification);
	public List<Notification> getByCreatedBy(int idIdentity);
	public List<Notification> getByCreatedDate(Date createdDate);	
	public List<Notification> getByDisabled(boolean disabled);
	public List<Notification> getByTarget(int idTarget);
	public List<Notification> getByTargetType(TargetType targetType);
	public List<Notification> getByUpdatedBy(int idIdentity);
	public List<Notification> getByUpdatedDate(Date updatedDate);
}
