package fr.afcepf.al23.partesite.iservice.transaction;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import fr.afcepf.al23.model.entities.UserOrderState;

@Remote
public interface IBusinessOrderState {
	public void save(UserOrderState orderState);
	public UserOrderState get(Integer idOrderState);
	public List<UserOrderState> getAll();
	public List<UserOrderState> getByName(String name);
	public List<UserOrderState> getByCreatedBy(Integer idIdentity);
	public List<UserOrderState> getByCreatedDate(Date createdDate);	
	public List<UserOrderState> getByDisabled(Boolean disabled);	
	public List<UserOrderState> getByUpdatedBy(Integer idIdentity);
	public List<UserOrderState> getByUpdatedDate(Date updatedDate);	
}
