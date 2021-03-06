package fr.afcepf.al23.partesite.service.impl.offer;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import fr.afcepf.al23.model.entities.Item;
import fr.afcepf.al23.model.entities.ItemState;
import fr.afcepf.al23.model.entities.Pack;
import fr.afcepf.al23.partesite.idao.offer.IDaoItem;
import fr.afcepf.al23.partesite.idao.offer.IDaoPack;
import fr.afcepf.al23.partesite.iservice.offer.IBusinessPack;


@Stateless
public class BusinessPackImpl implements IBusinessPack {

	private Logger log = Logger.getLogger(getClass());

	@PersistenceContext (name="PartESite_Dao")
	private EntityManager em;
	
	@EJB
	private IDaoPack daoPack;
	@EJB
	private IDaoItem daoItem;

	@Override
	public Pack save(Pack pack) {
		if(pack.getIdPack() == null){
			pack = daoPack.add(pack);
			ItemState itemSt = new ItemState();
			itemSt.setIdItemState(1);
			itemSt.setItemStateName("DISPONIBLE");
			for (int i = 0; i < pack.getStock(); i++) {
				Item item = new Item(null, null, pack.getAmount(), 1, new Date(), null, 1, new Date(), itemSt, pack);
				daoItem.add(item);
			}
		}
		else
			pack = daoPack.update(pack);
		return pack;
	}

	@Override
	public Pack disablePackage(Pack pack) {
		pack.setDisabled(true);
		pack = save(pack);
		return pack;
	}

	@Override
	public List<Pack> getByidProject(Integer idProject) {
		List<Pack> packs = daoPack.getByidProject(idProject);
		return packs;
	}

	@Override
	public List<Pack> getAllWithItemDispo() {
		List<Pack> packs = daoPack.getAll();
		if(packs != null)
		for (Pack pack : packs) {
			pack.setItems(daoItem.getDispoByPack(pack));
		}
		return packs;
	}

	@Override
	public Pack get(int idPack) {
		return daoPack.get(idPack);
	}
	


}
