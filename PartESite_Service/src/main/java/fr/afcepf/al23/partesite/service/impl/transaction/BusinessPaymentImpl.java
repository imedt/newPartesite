/**
 * 
 */
package fr.afcepf.al23.partesite.service.impl.transaction;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import fr.afcepf.al23.model.entities.Identity;
import fr.afcepf.al23.model.entities.Payment;
import fr.afcepf.al23.model.entities.UserOrder;
import fr.afcepf.al23.partesite.idao.transaction.IDaoPayment;
import fr.afcepf.al23.partesite.iservice.transaction.IBusinessPayment;

/**
 * @author awagu_000
 *
 */
@Stateless
public class BusinessPaymentImpl implements IBusinessPayment {

	private static Logger log = Logger.getLogger(BusinessPaymentImpl.class);
	
	@EJB
	private IDaoPayment daoPayment;

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.iservice.transaction.IBusinessPayment#save(fr.afcepf.al23.partesite.model.entities.Payment)
	 */
	@Override
	public void save(Payment payment) {
		log.info("BusinessPaymentImpl, save");
		if (payment.getIdPayment() != null){
			daoPayment.update(payment);
		} else {
			daoPayment.add(payment);
		}
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.iservice.transaction.IBusinessPayment#get(java.lang.Integer)
	 */
	@Override
	public Payment get(Integer idPayment) {
		log.info("BusinessPaymentImpl, get");
		return daoPayment.get(idPayment);
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.iservice.transaction.IBusinessPayment#getAll()
	 */
	@Override
	public List<Payment> getAll() {
		log.info("BusinessPaymentImpl, getAll");
		return daoPayment.getAll();
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.iservice.transaction.IBusinessPayment#getByCreatedBy(Integer )
	 */
	@Override
	public List<Payment> getByCreatedBy(Integer  idIdentity) {
		log.info("BusinessPaymentImpl, getByCreatedBy");
		return daoPayment.getByCreatedBy(idIdentity);
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.iservice.transaction.IBusinessPayment#getByCreatedDate(java.util.Date)
	 */
	@Override
	public List<Payment> getByCreatedDate(Date createdDate) {
		log.info("BusinessPaymentImpl, getByCreatedDate");
		return daoPayment.getByCreatedDate(createdDate);
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.iservice.transaction.IBusinessPayment#getByDisabled(boolean)
	 */
	@Override
	public List<Payment> getByDisabled(Boolean disabled) {
		log.info("BusinessPaymentImpl, getByDisabled");
		return daoPayment.getByDisabled(disabled);
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.iservice.transaction.IBusinessPayment#getByUpdatedBy(Integer )
	 */
	@Override
	public List<Payment> getByUpdatedBy(Integer  idIdentity) {
		log.info("BusinessPaymentImpl, getByUpdatedBy");
		return daoPayment.getByUpdatedBy(idIdentity);
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.iservice.transaction.IBusinessPayment#getByUpdatedDate(java.util.Date)
	 */
	@Override
	public List<Payment> getByUpdatedDate(Date updatedDate) {
		log.info("BusinessPaymentImpl, getByUpdatedDate");
		return daoPayment.getByUpdatedDate(updatedDate);
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.iservice.transaction.IBusinessPayment#getByUserOrder(fr.afcepf.al23.partesite.model.entities.UserOrder)
	 */
	@Override
	public List<Payment> getByUserOrder(UserOrder userOrder) {
		log.info("BusinessPaymentImpl, getByUserOrder");
		return daoPayment.getByUserOrder(userOrder);
	}

	@Override
	public List<Payment> getAllBuyByIdentity(Identity id) {
		return daoPayment.getAllBuyedByIdentity(id);
	}

}
