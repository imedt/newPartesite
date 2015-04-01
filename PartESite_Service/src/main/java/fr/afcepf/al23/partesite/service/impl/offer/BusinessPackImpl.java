package fr.afcepf.al23.partesite.service.impl.offer;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

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
		if(pack.getIdPack() == null)
			pack = daoPack.add(pack);
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
	


}
