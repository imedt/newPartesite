package fr.afcepf.al23.servicetaxes_frais.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import entity.Country;

@WebService
public interface IServiceTaxes_Frais {
	
	@WebMethod
	@WebResult(name = "tauxTva", targetNamespace = "")
	public double returnTvaCountry(
			@WebParam(name = "idCountry", targetNamespace = "")
			Integer idCountry);
	
	@WebMethod
	@WebResult(name = "montantTTC", targetNamespace = "")
	public double applyTva(
			@WebParam(name = "montantHT", targetNamespace = "")
			double montant, 
			@WebParam(name = "tauxTVA", targetNamespace = "")
			double tva, 
			@WebParam(name = "tauxCommission", targetNamespace = "")
			double commission);
	
	@WebMethod
	@WebResult(name="coutryList",targetNamespace="")
	public List<Country> getAllCountries();
	
	@WebMethod 
	@WebResult(name="country",targetNamespace="")
	public Country findCountry(int id); 
}
