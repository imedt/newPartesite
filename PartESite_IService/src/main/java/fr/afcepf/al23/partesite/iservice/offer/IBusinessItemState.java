package fr.afcepf.al23.partesite.iservice.offer;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import fr.afcepf.al23.partesite.model.entities.Item;
import fr.afcepf.al23.partesite.model.entities.ItemState;

@Remote
public interface IBusinessItemState {

	public ItemState save(ItemState itemState);
	public ItemState disable(ItemState itemState);
	public ItemState getByName(String name);
	
}
