package fr.afcepf.al23.conversion.service;

import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.jws.WebService;

import org.apache.log4j.Logger;

import fr.afcepf.al23.gestiondevises.service.GestionDevisesImpl;

@Remote(IConversion.class)
@Stateless
@WebService
public class ConversionImpl implements IConversion {
	private Logger log = Logger.getLogger(ConversionImpl.class);
	private GestionDevisesImpl service;
	@Override
	public double conversion(double montant, String monnaieSource, String monnaieCible) {
		if(service == null){
			service = new GestionDevisesImpl();
		} 
		double result = montant * service.returnChangeByDevise(monnaieSource, monnaieCible);
		//log.info(montant+" FROM "+monnaieSource+" TO "+monnaieCible+" = "+result);
		return result;
	}
	@Override
	public double getTauxChange(String monnaieSource, String monnaieCible) {
		service = new GestionDevisesImpl(); 
		return service.returnChangeByDevise(monnaieSource, monnaieCible);
	}
}
