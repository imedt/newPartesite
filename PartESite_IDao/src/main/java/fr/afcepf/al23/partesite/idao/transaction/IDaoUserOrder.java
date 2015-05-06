package fr.afcepf.al23.partesite.idao.transaction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import fr.afcepf.al23.model.entities.Identity;
import fr.afcepf.al23.model.entities.UserOrder;

@Remote
public interface IDaoUserOrder {
	public Integer add(UserOrder userOrder);
	public UserOrder update(UserOrder userOrder);
	public UserOrder get(Integer idUserOrder);
	public List<UserOrder> getAll();
	public List<UserOrder> getByIdentity(Identity identity);
	public List<UserOrder> getByTotalAmount(Double  totalAmount);
	public List<UserOrder> getByCreatedBy(Integer idIdentity);
	public List<UserOrder> getByCreatedDate(Date createdDate);	
	public List<UserOrder> getByDisabled(Boolean disabled);	
	public List<UserOrder> getByUpdatedBy(Integer idIdentity); 
	public List<UserOrder> getByUpdatedDate(Date updatedDate);
	public List<Object> getSalesByDate();	
}
