package fr.afcepf.al23.conversion.service;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.jws.WebService;

import fr.afcepf.al23.gestiondevises.service.GestionDevisesImpl;

@Remote(IConversion.class)
@Stateless
@WebService
public class ConversionImpl implements IConversion {

	@Override
	public double conversion(double montant, String monnaieSource, String monnaieCible) {
		GestionDevisesImpl s = new GestionDevisesImpl();
		return montant * s.returnChangeByDevises(monnaieSource, monnaieCible);
	}
}
