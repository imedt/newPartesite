package fr.afcepf.al23.partesite.iservice.offer;

import java.util.List;

import javax.ejb.Remote;

import fr.afcepf.al23.model.entities.Item;
import fr.afcepf.al23.model.entities.Pack;

@Remote
public interface IBusinessItem {

	public Item createItem(Item item);
	public void updateItem(Item item);
	public void enableItem(Item item);
	public void disableItem(Item item);
	public List<Item> searchItem(Integer idItem, Double amount);
	public List<Item> getSaleByPack(Pack pack);
	public List<Item> getDispoByPack(Pack pack);	
	public List<Item> getByOrderRowId(int id);

} 
