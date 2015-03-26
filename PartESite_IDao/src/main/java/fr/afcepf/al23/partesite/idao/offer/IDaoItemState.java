package fr.afcepf.al23.partesite.idao.offer;

import java.util.List;
import javax.ejb.Remote;
import fr.afcepf.al23.partesite.model.entities.ItemState;

@Remote
public interface IDaoItemState {
	
	
	
	public ItemState add(ItemState itemState);
	public ItemState update(ItemState itemState);
	public ItemState get(Integer idItemState);
	public List<ItemState> getAll();
	public ItemState getByName(String itemStateName);

}
