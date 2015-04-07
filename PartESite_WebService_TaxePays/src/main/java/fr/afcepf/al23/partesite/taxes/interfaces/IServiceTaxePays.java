package fr.afcepf.al23.partesite.taxes.interfaces;

import javax.jws.WebMethod;
import javax.jws.WebService;

import fr.afcepf.al23.partesite.taxes.entity.Frais;
import fr.afcepf.al23.partesite.taxes.entity.Pays;

@WebService
public interface IServiceTaxePays {
	@WebMethod
	public Frais getFrais(Pays origine, Pays destination);
}
