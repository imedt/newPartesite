package fr.afcepf.al23.partesite.iservice.transaction;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import fr.afcepf.al23.model.entities.Item;
import fr.afcepf.al23.model.entities.OrderRow;
import fr.afcepf.al23.model.entities.UserOrder;

@Remote
public interface IBusinessOrderRow {
	public void save(OrderRow orderRow);
	public OrderRow get(Integer idOrderRow);
	public List<OrderRow> getAll();
	public List<OrderRow> getByAmount(Double amount);
	public List<OrderRow> getByCreatedBy(Integer idIdentity);
	public List<OrderRow> getByCreatedDate(Date createdDate);	
	public List<OrderRow> getByDisabled(Boolean disabled);	
	public List<OrderRow> getByUpdatedBy(Integer idIdentity);
	public List<OrderRow> getByUpdatedDate(Date updatedDate);
	public List<OrderRow> getByItem(Item item);
	public List<OrderRow> getByUserRow(UserOrder userOrder);
	public void changeUserOrder(UserOrder cart, UserOrder currentCart);
}
