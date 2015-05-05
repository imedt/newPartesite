package fr.afcepf.al23.partesite.idao.transaction;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import fr.afcepf.al23.model.entities.UserOrderState;

@Remote
public interface IDaoUserOrderState {
	public Integer add(UserOrderState userOrderState);
	public void update(UserOrderState userOrderState);
	public UserOrderState get(Integer idUserOrderState);
	public List<UserOrderState> getAll();
	public List<UserOrderState> getByName(String name);
	public List<UserOrderState> getByCreatedBy(Integer idIdentity);
	public List<UserOrderState> getByCreatedDate(Date createdDate);	
	public List<UserOrderState> getByDisabled(Boolean disabled);	
	public List<UserOrderState> getByUpdatedBy(Integer idIdentity);
	public List<UserOrderState> getByUpdatedDate(Date updatedDate);	
}
