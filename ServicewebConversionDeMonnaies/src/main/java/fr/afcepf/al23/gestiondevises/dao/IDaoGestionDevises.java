package fr.afcepf.al23.gestiondevises.dao;

import javax.jws.WebMethod;

import fr.afcepf.al23.entity.Currency;

public interface IDaoGestionDevises {
	@WebMethod
	Currency getCurrency (String nomDevise);
	}
