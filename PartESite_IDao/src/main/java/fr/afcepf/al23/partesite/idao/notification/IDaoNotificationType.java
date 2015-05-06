package fr.afcepf.al23.partesite.idao.notification;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import fr.afcepf.al23.model.entities.TargetType;

@Remote
public interface IDaoNotificationType {
	public Integer add(TargetType targetType);
	public void update(TargetType targetType);
	public TargetType get(Integer idTargetType);
	public List<TargetType> getAll();
	public List<TargetType> getByName(String name);
	public List<TargetType> getByCreatedBy(Integer idIdentity);
	public List<TargetType> getByCreatedDate(Date createdDate);	
	public List<TargetType> getByDisabled(Boolean disabled);	
	public List<TargetType> getByUpdatedBy(Integer idIdentity);
	public List<TargetType> getByUpdatedDate(Date updatedDate);	
}
