package fr.afcepf.al23.conversion.service;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.jws.WebService;

import fr.afcepf.al23.entity.Currency;
import fr.afcepf.al23.gestiondevises.dao.IDaoGestionDevises;

@Remote(IConversion.class)
@Stateless
@WebService
public class ConversionImpl implements IConversion {

	@EJB
	private IDaoGestionDevises dao;

	@Override
	public double conversion(double montant, String monnaieSource,
			String monnaieCible) {

		Currency c = dao.getCurrency(monnaieCible);
		return montant * c.getRate();
	}
}
