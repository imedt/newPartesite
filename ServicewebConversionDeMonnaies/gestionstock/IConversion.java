package fr.afcepf.al23.conversion.service.gestionstock;

import javax.jws.WebService;

@WebService
public interface IConversion {
	public double convertir(double montant, double monnaieSource,
			double monnaieCible);
}
