package fr.afcepf.al23.partesite.idao.transaction;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import fr.afcepf.al23.model.entities.Payment;
import fr.afcepf.al23.model.entities.UserOrder;

@Remote
public interface IDaoPayment {
	public Integer add(Payment payment);
	public void update(Payment payment);
	public Payment get(Integer idPayment);
	public List<Payment> getAll();
	public List<Payment> getByCreatedBy(Integer idIdentity);
	public List<Payment> getByCreatedDate(Date createdDate);	
	public List<Payment> getByDisabled(Boolean disabled);	
	public List<Payment> getByUpdatedBy(Integer idIdentity);
	public List<Payment> getByUpdatedDate(Date updatedDate);
	public List<Payment> getByUserOrder(UserOrder userOrder);
}
