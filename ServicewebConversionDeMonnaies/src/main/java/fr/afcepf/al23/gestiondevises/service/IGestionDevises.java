package fr.afcepf.al23.gestiondevises.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface IGestionDevises {
	@WebMethod
	double getCurrency (String nomDevise);
}
