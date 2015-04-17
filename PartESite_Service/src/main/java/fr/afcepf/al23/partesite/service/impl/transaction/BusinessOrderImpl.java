/**
 * 
 */
package fr.afcepf.al23.partesite.service.impl.transaction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import fr.afcepf.al23.model.entities.Identity;
import fr.afcepf.al23.model.entities.Item;
import fr.afcepf.al23.model.entities.ItemState;
import fr.afcepf.al23.model.entities.OrderRow;
import fr.afcepf.al23.model.entities.Pack;
import fr.afcepf.al23.model.entities.UserOrder;
import fr.afcepf.al23.model.entities.UserOrderState;
import fr.afcepf.al23.partesite.idao.offer.IDaoItem;
import fr.afcepf.al23.partesite.idao.offer.IDaoPack;
import fr.afcepf.al23.partesite.idao.transaction.IDaoOrderRow;
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
	@EJB
	private IDaoOrderRow daoOrderRow;
	@EJB
	private IDaoItem daoItem;
	
	@EJB
	private IDaoPack daoPack;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.afcepf.al23.partesite.iservice.transaction.IBusinessUserOrder#save
	 * (fr.afcepf.al23.partesite.model.entities.UserOrder)
	 */
	@Override
	public void save(UserOrder userOrder) {
		log.info("BusinessOrderImpl, save");
		if (userOrder.getIdUserOrder() != null) {
			daoUserOrder.update(userOrder);
		} else {
			daoUserOrder.add(userOrder);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.afcepf.al23.partesite.iservice.transaction.IBusinessUserOrder#get(
	 * java.lang.Integer)
	 */
	@Override
	public UserOrder get(Integer idUserOrder) {
		log.info("BusinessOrderImpl, get");
		return daoUserOrder.get(idUserOrder);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fr.afcepf.al23.partesite.iservice.transaction.IBusinessUserOrder#getAll()
	 */
	@Override
	public List<UserOrder> getAll() {
		log.info("BusinessOrderImpl, getAll");
		return daoUserOrder.getAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.afcepf.al23.partesite.iservice.transaction.IBusinessUserOrder#
	 * getByTotalAmount(double)
	 */
	@Override
	public List<UserOrder> getByTotalAmount(Double totalAmount) {
		log.info("BusinessOrderImpl, getByTotalAmount");
		return daoUserOrder.getByTotalAmount(totalAmount);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.afcepf.al23.partesite.iservice.transaction.IBusinessUserOrder#
	 * getByCreatedBy(Identity)
	 */
	@Override
	public List<UserOrder> getByCreatedBy(Identity identity) {
		log.info("BusinessOrderImpl, getByCreatedBy");
		return daoUserOrder.getByCreatedBy(identity.getIdIdentity());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.afcepf.al23.partesite.iservice.transaction.IBusinessUserOrder#
	 * getByCreatedDate(java.util.Date)
	 */
	@Override
	public List<UserOrder> getByCreatedDate(Date createdDate) {
		log.info("BusinessOrderImpl, getByCreatedDate");
		return daoUserOrder.getByCreatedDate(createdDate);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.afcepf.al23.partesite.iservice.transaction.IBusinessUserOrder#
	 * getByDisabled(boolean)
	 */
	@Override
	public List<UserOrder> getByDisabled(Boolean disabled) {
		log.info("BusinessOrderImpl, getByDisabled");
		return daoUserOrder.getByDisabled(disabled);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.afcepf.al23.partesite.iservice.transaction.IBusinessUserOrder#
	 * getByUpdatedBy(Identity)
	 */
	@Override
	public List<UserOrder> getByUpdatedBy(Identity identity) {
		log.info("BusinessOrderImpl, getByUpdatedBy");
		return daoUserOrder.getByUpdatedBy(identity.getIdIdentity());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.afcepf.al23.partesite.iservice.transaction.IBusinessUserOrder#
	 * getByUpdatedDate(java.util.Date)
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

	@Override
	public UserOrder addOrderRow(Identity identity, UserOrder oldOrder,
			Integer nb, Pack pack) {

		log.info("addOrderRow in BusinessOrderImpl ");
		log.info(pack.getIdPack());
		UserOrder newOrder = oldOrder;
		// si commande/panier inexistant => creation
		if (newOrder == null) {
			newOrder = new UserOrder(null, 1, new Date(), null, 0d, 1,
					new Date(), null, null, identity, new UserOrderState(1,
							null, null, null, null, null, "EN COURS", null));
			log.info("0");
			newOrder.setIdUserOrder(daoUserOrder.add(newOrder));
		}
		log.info("1");
		if (newOrder.getIdUserOrder() == null)
			return null;
		log.info("2");
		log.info("idOrder = " + newOrder.getIdUserOrder());
		// creation de la ligne de commande
		OrderRow newOR = new OrderRow(null, pack.getAmount() * nb, 1,
				new Date(), null, 1, new Date(), pack, newOrder);
		log.info("3");
		newOR = daoOrderRow.add(newOR);
		newOrder.setTotalAmount(newOrder.getTotalAmount() + newOR.getAmount());
		newOrder = daoUserOrder.update(newOrder);
		log.info("pre blocage item : "+nb+" "+pack+" "+newOR.getIdOrderRow());
		// reservation des items.
		newOR.setItems(daoItem.holdItemByNbByPack(nb, pack,
				newOR.getIdOrderRow()));
		log.info("idOrderRow = " + newOR.getIdOrderRow());
		List<OrderRow> orList = new ArrayList<OrderRow>();
		if (newOrder.getOrderRows() != null)
			orList = newOrder.getOrderRows();
		
		orList.add(newOR);

		newOrder.setOrderRows(orList);
		log.info("5");
		log.info(newOrder.getOrderRows().size());
		return newOrder;
	}

	@Override
	public UserOrder modifyOrderRow(UserOrder oldOrder, Integer nb, Pack pack) {
		for (OrderRow or : oldOrder.getOrderRows()) {
			if (or.getPack().getIdPack() == pack.getIdPack()) {
				if (nb == 0) {
					daoItem.ClearItemByNbByPack(or.getItems());
					or.setDisabled(true);
					daoOrderRow.update(or);
					oldOrder.getOrderRows().remove(or);
				} else {
					daoItem.ClearItemByNbByPack(or.getItems());
					or.setAmount(nb * pack.getAmount());
					or.setItems(daoItem.holdItemByNbByPack(nb, pack,
							or.getIdOrderRow()));
				}
				return oldOrder;
			}
		}
		return oldOrder;
	}

	@Override
	public UserOrder ReleaseOrder(UserOrder OrderToRelease) {
		for (OrderRow or : OrderToRelease.getOrderRows()) {
			daoItem.ClearItemByNbByPack(or.getItems());
			or.setDisabled(true);
			daoOrderRow.update(or);
		}
		OrderToRelease.setDisabled(true);
		daoUserOrder.update(OrderToRelease);
		return OrderToRelease;
	}

	@Override
	public UserOrder finalizeCart(UserOrder cart) {
		ItemState itemState = new ItemState();
		itemState.setIdItemState(3);
		itemState.setItemStateName("VENDU");
		UserOrderState userOrderState = new UserOrderState();
		userOrderState.setIdUserOrderState(2);
		userOrderState.setUserOrderStateName("PAYE");
		
		for(OrderRow row : cart.getOrderRows()){
			log.info("there is "+row.getItems().size()+" item in this row");
			for(Item item : row.getItems()){
				item.setItemState(itemState);
			}
			Pack pack = row.getPack();
			pack.setStock(pack.getStock() - row.getItems().size());
			daoPack.update(pack);
		} 
		cart = daoUserOrder.update(cart);
		return cart;
	}

}
