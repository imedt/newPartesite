package fr.afcepf.al23.partesite.iservice.offer;

import java.util.List;

import javax.ejb.Remote;

import fr.afcepf.al23.model.entities.Pack;

@Remote
public interface IBusinessPack {

	public Pack save(Pack pack);
	public Pack disablePackage(Pack p);
	public List<Pack>  getByidProject(Integer idProject);
	public List<Pack>  getAllWithItemDispo();
	public Pack get(int idPack);
}
