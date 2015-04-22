package fr.afcepf.al23.servicetaxes_frais.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.jws.WebService;

import entity.Country;
import fr.afcepf.al23.servicetaxes_frais.dao.IDaoServiceTaxes_Frais;

@Remote(IServiceTaxes_Frais.class)
@Stateless
@WebService
public class ServiceTaxes_FraisImpl implements IServiceTaxes_Frais {

	@EJB
	private IDaoServiceTaxes_Frais dao;

	@Override
	public double returnTvaCountry(Integer idCountry) {
		Country c = dao.getCountryById(idCountry);
		return c.getTva();
	}

	@Override
	public double applyTva(double montant, double tva, double commission) {
		double montantTTC;
		//Application de la tva
		montantTTC = montant+(montant*(tva/100));
		//Application de la commission
		montantTTC = montantTTC+(montantTTC*(commission/100));
		return montantTTC;
	}

	@Override
	public List<Country> getAllCountries() {
		return dao.getAllCountries();
	}

	@Override
	public Country findCountry(int id) {
		return dao.getCountryById(id);
	}
	
}
