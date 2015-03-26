package fr.afcepf.al23.partesite.iservice.transaction;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import fr.afcepf.al23.partesite.model.entities.Identity;
import fr.afcepf.al23.partesite.model.entities.UserOrder;

@Remote
public interface IBusinessOrder {
	public void save(UserOrder userOrder);
	public UserOrder get(Integer idUserOrder);
	public List<UserOrder> getAll();
	public List<UserOrder> getByTotalAmount(double totalAmount);
	public List<UserOrder> getByIdentity(Identity identity);	
	public List<UserOrder> getByCreatedBy(Identity identity);
	public List<UserOrder> getByCreatedDate(Date createdDate);	
	public List<UserOrder> getByDisabled(boolean disabled);	
	public List<UserOrder> getByUpdatedBy(Identity identity);
	public List<UserOrder> getByUpdatedDate(Date updatedDate);	
}
