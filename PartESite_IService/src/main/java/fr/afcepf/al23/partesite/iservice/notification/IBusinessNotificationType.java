package fr.afcepf.al23.partesite.iservice.notification;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import fr.afcepf.al23.partesite.model.entities.TargetType;

@Remote
public interface IBusinessNotificationType {
	public void save(TargetType targetType);	
	public TargetType get(Integer idTargetType);
	public List<TargetType> getAll();
	public List<TargetType> getByName(String name);
	public List<TargetType> getByCreatedBy(int idIdentity);
	public List<TargetType> getByCreatedDate(Date createdDate);	
	public List<TargetType> getByDisabled(boolean disabled);	
	public List<TargetType> getByUpdatedBy(int idIdentity);
	public List<TargetType> getByUpdatedDate(Date updatedDate);	
}
