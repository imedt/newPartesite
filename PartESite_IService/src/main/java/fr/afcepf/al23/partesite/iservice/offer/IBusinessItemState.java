package fr.afcepf.al23.partesite.iservice.offer;

import javax.ejb.Remote;

import fr.afcepf.al23.model.entities.ItemState;

@Remote
public interface IBusinessItemState {

	public ItemState save(ItemState itemState);
	public ItemState disable(ItemState itemState);
	public ItemState getByName(String name);
	
}
