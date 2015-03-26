package fr.afcepf.al23.partesite.service.impl.offer;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import fr.afcepf.al23.partesite.idao.offer.IDaoItem;
import fr.afcepf.al23.partesite.iservice.offer.IBusinessItem;
import fr.afcepf.al23.partesite.model.entities.Item;
import fr.afcepf.al23.partesite.model.entities.Pack;

@Stateless
public class BusinessItemImpl implements IBusinessItem {

	private static Logger log = Logger.getLogger(BusinessItemImpl.class);

	
	@EJB
	private IDaoItem dao;
	
	
	@Override
	public Item createItem(Double amount) {
		
		Item item = new Item();
		item.setAmount(amount);
		dao.add(item);
		
		return item;
	}

	@Override
	public void updateItem(Item item) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enableItem(Item item) {
		// TODO Auto-generated method stub

	}

	@Override
	public void disableItem(Item item) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Item> searchItem(Integer idItem, Double amount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item> getSaleByPack(Pack pack) {
		return dao.getSaleByPack(pack);
	}

	@Override
	public List<Item> getDispoByPack(Pack pack) {
		return dao.getDispoByPack(pack);
	}

}
