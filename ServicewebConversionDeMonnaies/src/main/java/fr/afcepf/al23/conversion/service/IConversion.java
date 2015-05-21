package fr.afcepf.al23.conversion.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService 
public interface IConversion {

	@WebMethod
	@WebResult(name = "montantHTApresConversion", targetNamespace = "")
	public double conversion
	(		@WebParam(name = "montantHTAvantConversion", targetNamespace = "")
	double montant, 
	@WebParam(name = "deviseSource", targetNamespace = "")
	String monnaieSource,
	@WebParam(name = "deviseCible", targetNamespace = "")
	String monnaieCible);

	@WebMethod
	@WebResult(name="tauxChange",targetNamespace="")
	public double getTauxChange(		@WebParam(name = "monnaieSource", targetNamespace = "")
	String monnaieSource,	@WebParam(name = "monnaieCible", targetNamespace = "")
	String monnaieCible);
}
