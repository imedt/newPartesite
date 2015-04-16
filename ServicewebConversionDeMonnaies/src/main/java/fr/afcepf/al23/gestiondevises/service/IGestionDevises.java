package fr.afcepf.al23.gestiondevises.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface IGestionDevises {

	@WebMethod
	public double returnChangeByDevise(String deviseSource, String deviseCible);
}
