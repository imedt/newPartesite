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
import fr.afcepf.al23.model.entities.UserOrder;
import fr.afcepf.al23.partesite.idao.transaction.IDaoUserOrder;
import fr.afcepf.al23.partesite.iservice.transaction.IBusinessOrder;

/**
 * @author awagu_000
 *
 */
@Stateless
public class BusinessOrderImpl implements IBusinessOrder {

	private Logger log = Logger.getLogger(getClass());
	
	@EJB
	private IDaoUserOrder daoUserOrder;

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.iservice.transaction.IBusinessUserOrder#save(fr.afcepf.al23.partesite.model.entities.UserOrder)
	 */
	@Override
	public void save(UserOrder userOrder) {
		log.info("BusinessOrderImpl, save");
		if (daoUserOrder.get(userOrder.getIdUserOrder()) != null){
			daoUserOrder.update(userOrder);
		} else {
			daoUserOrder.add(userOrder);
		}
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.iservice.transaction.IBusinessUserOrder#get(java.lang.Integer)
	 */
	@Override
	public UserOrder get(Integer idUserOrder) {
		log.info("BusinessOrderImpl, get");
		return daoUserOrder.get(idUserOrder);
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.iservice.transaction.IBusinessUserOrder#getAll()
	 */
	@Override
	public List<UserOrder> getAll() {
		log.info("BusinessOrderImpl, getAll");
		return daoUserOrder.getAll();
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.iservice.transaction.IBusinessUserOrder#getByTotalAmount(double)
	 */
	@Override
	public List<UserOrder> getByTotalAmount(Double totalAmount) {
		log.info("BusinessOrderImpl, getByTotalAmount");
		return daoUserOrder.getByTotalAmount(totalAmount);
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.iservice.transaction.IBusinessUserOrder#getByCreatedBy(Identity)
	 */
	@Override
	public List<UserOrder> getByCreatedBy(Identity identity) {
		log.info("BusinessOrderImpl, getByCreatedBy");
		return daoUserOrder.getByCreatedBy(identity.getIdIdentity());
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.iservice.transaction.IBusinessUserOrder#getByCreatedDate(java.util.Date)
	 */
	@Override
	public List<UserOrder> getByCreatedDate(Date createdDate) {
		log.info("BusinessOrderImpl, getByCreatedDate");
		return daoUserOrder.getByCreatedDate(createdDate);
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.iservice.transaction.IBusinessUserOrder#getByDisabled(boolean)
	 */
	@Override
	public List<UserOrder> getByDisabled(Boolean disabled) {
		log.info("BusinessOrderImpl, getByDisabled");
		return daoUserOrder.getByDisabled(disabled);
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.iservice.transaction.IBusinessUserOrder#getByUpdatedBy(Identity)
	 */
	@Override
	public List<UserOrder> getByUpdatedBy(Identity identity) {
		log.info("BusinessOrderImpl, getByUpdatedBy");
		return daoUserOrder.getByUpdatedBy(identity.getIdIdentity());
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.iservice.transaction.IBusinessUserOrder#getByUpdatedDate(java.util.Date)
	 */
	@Override
	public List<UserOrder> getByUpdatedDate(Date updatedDate) {
		log.info("BusinessOrderImpl, getByUpdatedDate");
		return daoUserOrder.getByUpdatedDate(updatedDate);
	}

	@Override
	public List<UserOrder> getByIdentity(Identity identity) {
		log.info("BusinessOrderImpl, getByIdentity");
		return daoUserOrder.getByIdentity(identity);
	}

}
