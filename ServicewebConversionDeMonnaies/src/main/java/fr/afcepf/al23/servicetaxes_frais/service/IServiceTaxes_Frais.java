package fr.afcepf.al23.servicetaxes_frais.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface IServiceTaxes_Frais {
	
	@WebMethod
	public double returnTvaCountry(Integer idCountry);
	@WebMethod
	public double applyTva(double montant, double tva, double commission);
}
