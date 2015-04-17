package fr.afcepf.al23.partesite.service.impl.offer;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import fr.afcepf.al23.model.entities.ItemState;
import fr.afcepf.al23.partesite.idao.offer.IDaoItemState;
import fr.afcepf.al23.partesite.iservice.offer.IBusinessItemState;

@Stateless
public class BusinessItemStateImpl implements IBusinessItemState {

	private Logger log = Logger.getLogger(getClass());

	@EJB
	private IDaoItemState daoIS;

	@Override
	public ItemState save(ItemState itemState) {
		if(itemState.getIdItemState() == null)
		  itemState = daoIS.add(itemState);
		else
			itemState = daoIS.update(itemState);
		return itemState;
	}

	@Override
	public ItemState disable(ItemState itemState) {
		itemState.setDisabled(true);
		itemState = save(itemState);
		return itemState;
	}

	@Override
	public ItemState getByName(String name) {
		ItemState itemState = daoIS.getByName(name);
		return itemState;
	}
	
	
}
