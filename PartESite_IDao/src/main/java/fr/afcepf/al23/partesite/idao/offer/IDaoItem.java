package fr.afcepf.al23.partesite.idao.offer;

import java.util.List;

import javax.ejb.Remote;

import fr.afcepf.al23.model.entities.Item;
import fr.afcepf.al23.model.entities.Pack;


@Remote
public interface IDaoItem {
	
	public Item add(Item item);
	public Item update(Item item);
	public Item get(Integer idItem);
	public List<Item> getSaleByPack(Pack pack);
	public List<Item> getDispoByPack(Pack pack);


}
