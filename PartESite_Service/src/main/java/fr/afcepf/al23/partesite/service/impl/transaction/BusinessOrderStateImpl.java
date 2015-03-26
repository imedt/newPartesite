/**
 * 
 */
package fr.afcepf.al23.partesite.service.impl.transaction;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import fr.afcepf.al23.partesite.idao.transaction.IDaoUserOrderState;
import fr.afcepf.al23.partesite.iservice.transaction.IBusinessOrderState;
import fr.afcepf.al23.partesite.model.entities.UserOrderState;

/**
 * @author awagu_000
 *
 */
@Stateless
public class BusinessOrderStateImpl implements IBusinessOrderState {

	private static Logger log = Logger.getLogger(BusinessOrderStateImpl.class);
	
	@EJB
	private IDaoUserOrderState daoOrderState;

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.iservice.transaction.IBusinessOrderState#update(fr.afcepf.al23.partesite.model.entities.UserOrderState)
	 */
	@Override
	public void save(UserOrderState orderState) {
		log.info("BusinessOrderImpl, save");
		if (daoOrderState.get(orderState.getIdUserOrderState()) != null){
			daoOrderState.update(orderState);
		} else {
			daoOrderState.add(orderState);
		}
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.iservice.transaction.IBusinessOrderState#get(java.lang.Integer)
	 */
	@Override
	public UserOrderState get(Integer idOrderState) {
		log.info("BusinessOrderImpl, get");
		return daoOrderState.get(idOrderState);
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.iservice.transaction.IBusinessOrderState#getAll()
	 */
	@Override
	public List<UserOrderState> getAll() {
		log.info("BusinessOrderImpl, getAll");
		return daoOrderState.getAll();
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.iservice.transaction.IBusinessOrderState#getByName(java.lang.String)
	 */
	@Override
	public List<UserOrderState> getByName(String name) {
		log.info("BusinessOrderImpl, getByName");
		return daoOrderState.getByName(name);
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.iservice.transaction.IBusinessOrderState#getByCreatedBy(int)
	 */
	@Override
	public List<UserOrderState> getByCreatedBy(int idIdentity) {
		log.info("BusinessOrderImpl, getByCreatedBy");
		return daoOrderState.getByCreatedBy(idIdentity);
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.iservice.transaction.IBusinessOrderState#getByCreatedDate(java.util.Date)
	 */
	@Override
	public List<UserOrderState> getByCreatedDate(Date createdDate) {
		log.info("BusinessOrderImpl, getByCreatedDate");
		return daoOrderState.getByCreatedDate(createdDate);
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.iservice.transaction.IBusinessOrderState#getByDisabled(boolean)
	 */
	@Override
	public List<UserOrderState> getByDisabled(boolean disabled) {
		log.info("BusinessOrderImpl, getByDisabled");
		return daoOrderState.getByDisabled(disabled);
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.iservice.transaction.IBusinessOrderState#getByUpdatedBy(int)
	 */
	@Override
	public List<UserOrderState> getByUpdatedBy(int idIdentity) {
		log.info("BusinessOrderImpl, getByUpdatedBy");
		return daoOrderState.getByUpdatedBy(idIdentity);
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.iservice.transaction.IBusinessOrderState#getByUpdatedDate(java.util.Date)
	 */
	@Override
	public List<UserOrderState> getByUpdatedDate(Date updatedDate) {
		log.info("BusinessOrderImpl, getByUpdatedDate");
		return daoOrderState.getByUpdatedDate(updatedDate);
	}

}
