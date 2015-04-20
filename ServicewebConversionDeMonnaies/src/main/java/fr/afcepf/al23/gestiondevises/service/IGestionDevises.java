package fr.afcepf.al23.gestiondevises.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
public interface IGestionDevises {

	@WebMethod 
	@WebResult(name = "tauxDeChange", targetNamespace = "")
	public double returnChangeByDevise(
			@WebParam(name = "deviseSource", targetNamespace = "")
			String deviseSource, 
			@WebParam(name = "deviseSource", targetNamespace = "")
			String deviseCible);
}
