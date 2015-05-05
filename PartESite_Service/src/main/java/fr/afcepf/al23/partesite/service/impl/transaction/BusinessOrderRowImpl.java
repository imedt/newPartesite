/**
 * 
 */
package fr.afcepf.al23.partesite.service.impl.transaction;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import fr.afcepf.al23.model.entities.Item;
import fr.afcepf.al23.model.entities.OrderRow;
import fr.afcepf.al23.model.entities.UserOrder;
import fr.afcepf.al23.partesite.idao.transaction.IDaoOrderRow;
import fr.afcepf.al23.partesite.iservice.transaction.IBusinessOrderRow;

/**
 * @author awagu_000
 *
 */
@Stateless
public class BusinessOrderRowImpl implements IBusinessOrderRow {

	private  Logger log = Logger.getLogger(getClass());
	
	@EJB
	private IDaoOrderRow daoOrderRow;

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.iservice.transaction.IBusinessOrderRow#save(fr.afcepf.al23.partesite.model.entities.OrderRow)
	 */
	@Override
	public void save(OrderRow orderRow) {
		log.info("BusinessOrderRowImpl, save");
		if(daoOrderRow.get(orderRow.getIdOrderRow()) != null){
			daoOrderRow.update(orderRow);
		} else {
			daoOrderRow.add(orderRow);
		}

	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.iservice.transaction.IBusinessOrderRow#get(java.lang.Integer)
	 */
	@Override
	public OrderRow get(Integer idOrderRow) {
		log.info("BusinessOrderRowImpl, get");
		return daoOrderRow.get(idOrderRow);
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.iservice.transaction.IBusinessOrderRow#getAll()
	 */
	@Override
	public List<OrderRow> getAll() {
		log.info("BusinessOrderRowImpl, getAll");
		return daoOrderRow.getAll();
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.iservice.transaction.IBusinessOrderRow#getByAmount(double)
	 */
	@Override
	public List<OrderRow> getByAmount(Double amount) {
		log.info("BusinessOrderRowImpl, getByAmount");
		return daoOrderRow.getByAmount(amount);
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.iservice.transaction.IBusinessOrderRow#getByCreatedBy(int)
	 */
	@Override
	public List<OrderRow> getByCreatedBy(Integer idIdentity) {
		log.info("BusinessOrderRowImpl, getByCreatedBy");
		return daoOrderRow.getByCreatedBy(idIdentity);
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.iservice.transaction.IBusinessOrderRow#getByCreatedDate(java.util.Date)
	 */
	@Override
	public List<OrderRow> getByCreatedDate(Date createdDate) {
		log.info("BusinessOrderRowImpl, getByCreatedDate");
		return daoOrderRow.getByCreatedDate(createdDate);
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.iservice.transaction.IBusinessOrderRow#getByDisabled(boolean)
	 */
	@Override
	public List<OrderRow> getByDisabled(Boolean disabled) {
		log.info("BusinessOrderRowImpl, getByDisabled");
		return daoOrderRow.getByDisabled(disabled);
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.iservice.transaction.IBusinessOrderRow#getByUpdatedBy(int)
	 */
	@Override
	public List<OrderRow> getByUpdatedBy(Integer idIdentity) {
		log.info("BusinessOrderRowImpl, getByUpdatedBy");
		return daoOrderRow.getByUpdatedBy(idIdentity);
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.iservice.transaction.IBusinessOrderRow#getByUpdatedDate(java.util.Date)
	 */
	@Override
	public List<OrderRow> getByUpdatedDate(Date updatedDate) {
		log.info("BusinessOrderRowImpl, getByUpdatedDate");
		return daoOrderRow.getByUpdatedDate(updatedDate);
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.iservice.transaction.IBusinessOrderRow#getByItem(fr.afcepf.al23.partesite.model.entities.Item)
	 */
	@Override
	public List<OrderRow> getByItem(Item item) {
		log.info("BusinessOrderRowImpl, getByItem");
		return daoOrderRow.getByItem(item);
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al23.partesite.iservice.transaction.IBusinessOrderRow#getByUserRow(fr.afcepf.al23.partesite.model.entities.UserOrder)
	 */
	@Override
	public List<OrderRow> getByUserRow(UserOrder userOrder) {
		log.info("BusinessOrderRowImpl, getByUserRow");
		return daoOrderRow.getByUserRow(userOrder);
	}

}
