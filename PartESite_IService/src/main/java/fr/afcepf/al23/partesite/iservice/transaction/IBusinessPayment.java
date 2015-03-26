package fr.afcepf.al23.partesite.iservice.transaction;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import fr.afcepf.al23.partesite.model.entities.Payment;
import fr.afcepf.al23.partesite.model.entities.UserOrder;

@Remote
public interface IBusinessPayment {
	public void save(Payment payment);
	public Payment get(Integer idPayment);
	public List<Payment> getAll();
	public List<Payment> getByCreatedBy(int idIdentity);
	public List<Payment> getByCreatedDate(Date createdDate);	
	public List<Payment> getByDisabled(boolean disabled);	
	public List<Payment> getByUpdatedBy(int idIdentity);
	public List<Payment> getByUpdatedDate(Date updatedDate);
	public List<Payment> getByUserOrder(UserOrder userOrder);
}
