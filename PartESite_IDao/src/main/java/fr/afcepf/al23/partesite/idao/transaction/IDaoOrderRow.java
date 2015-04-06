package fr.afcepf.al23.partesite.idao.transaction;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import fr.afcepf.al23.partesite.model.entities.Item;
import fr.afcepf.al23.partesite.model.entities.OrderRow;
import fr.afcepf.al23.partesite.model.entities.UserOrder;

@Remote
public interface IDaoOrderRow {
	public OrderRow add(OrderRow orderRow);
	public OrderRow update(OrderRow orderRow);
	public OrderRow get(Integer idOrderRow);
	public List<OrderRow> getAll();
	public List<OrderRow> getByAmount(double amount);
	public List<OrderRow> getByCreatedBy(int idIdentity);
	public List<OrderRow> getByCreatedDate(Date createdDate);	
	public List<OrderRow> getByDisabled(boolean disabled);	
	public List<OrderRow> getByUpdatedBy(int idIdentity);
	public List<OrderRow> getByUpdatedDate(Date updatedDate);
	public List<OrderRow> getByItem(Item item);
	public List<OrderRow> getByUserRow(UserOrder userOrder);
}
