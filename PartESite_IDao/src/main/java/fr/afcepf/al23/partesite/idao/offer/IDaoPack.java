package fr.afcepf.al23.partesite.idao.offer;

import java.util.List;

import javax.ejb.Remote;

import fr.afcepf.al23.model.entities.Pack;


@Remote
public interface IDaoPack {

	public Pack add(Pack pack);
	public Pack update(Pack pack);
	public Pack get(Integer idPack);
	public List<Pack> getAll();

	public List<Pack> getByidProject(Integer idProject);

	public Integer getNbSale(Pack pack);

}
