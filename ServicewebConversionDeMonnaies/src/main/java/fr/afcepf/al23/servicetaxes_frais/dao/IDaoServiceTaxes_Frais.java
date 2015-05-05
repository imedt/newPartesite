package fr.afcepf.al23.servicetaxes_frais.dao;

import java.util.List;

import javax.jws.WebMethod;

import entity.Country;

public interface IDaoServiceTaxes_Frais {
	public Country getCountryById(Integer idCountry);
	public Country getCountryByName(String nameCountry);
	public List<Country> getAllCountries();
}
