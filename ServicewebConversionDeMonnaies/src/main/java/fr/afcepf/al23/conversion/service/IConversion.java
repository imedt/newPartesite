package fr.afcepf.al23.conversion.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface IConversion {
	
	@WebMethod
	public double conversion(double montant, String monnaieSource,
			String monnaieCible);
}
