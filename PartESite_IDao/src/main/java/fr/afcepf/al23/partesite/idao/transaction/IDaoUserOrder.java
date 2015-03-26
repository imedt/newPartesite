package fr.afcepf.al23.partesite.idao.transaction;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import fr.afcepf.al23.partesite.model.entities.Identity;
import fr.afcepf.al23.partesite.model.entities.UserOrder;

@Remote
public interface IDaoUserOrder {
	public Integer add(UserOrder userOrder);
	public void update(UserOrder userOrder);
	public UserOrder get(Integer idUserOrder);
	public List<UserOrder> getAll();
	public List<UserOrder> getByIdentity(Identity identity);
	public List<UserOrder> getByTotalAmount(double totalAmount);
	public List<UserOrder> getByCreatedBy(int idIdentity);
	public List<UserOrder> getByCreatedDate(Date createdDate);	
	public List<UserOrder> getByDisabled(boolean disabled);	
	public List<UserOrder> getByUpdatedBy(int idIdentity);
	public List<UserOrder> getByUpdatedDate(Date updatedDate);	
}
