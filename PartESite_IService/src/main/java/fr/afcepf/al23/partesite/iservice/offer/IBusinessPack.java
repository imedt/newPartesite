package fr.afcepf.al23.partesite.iservice.offer;

import java.util.List;

import javax.ejb.Remote;

import fr.afcepf.al23.partesite.model.entities.Pack;

@Remote
public interface IBusinessPack {

	public Pack save(Pack pack);
	public Pack disablePackage(Pack p);
	public List<Pack>  getByidProject(int idProject);
	public List<Pack>  getAllWithItemDispo();
}
