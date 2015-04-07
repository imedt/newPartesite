package fr.afcepf.al23.partesite.taxes.dao.interfaces;

import fr.afcepf.al23.partesite.taxes.entity.Pays;

import fr.afcepf.al23.partesite.taxes.entity.Frais;

public interface IDaoFrais {
	public Frais searchFraisByPays(Pays origine, Pays destination);
	public Frais searchFraisById(Integer id);
	public Frais addFrais(Frais frais);
	public Frais deleteFrais(Frais frais);
}
