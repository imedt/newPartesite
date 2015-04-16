package fr.afcepf.al23.servicetaxes_frais.dao;

import javax.jws.WebMethod;

import entity.Country;

public interface IDaoServiceTaxes_Frais {

	@WebMethod
	public Country getCountryById(Integer idCountry);

	@WebMethod
	public Country getCountryByName(String nameCountry);
}
