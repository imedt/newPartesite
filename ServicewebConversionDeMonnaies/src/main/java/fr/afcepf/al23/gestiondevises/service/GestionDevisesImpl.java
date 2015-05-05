package fr.afcepf.al23.gestiondevises.service;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.jws.WebService;

import net.webservicex.Currency;
import net.webservicex.CurrencyConvertor;
import net.webservicex.CurrencyConvertorSoap;

@Remote(IGestionDevises.class)
@Stateless
@WebService
public class GestionDevisesImpl implements IGestionDevises {
	public double returnChangeByDevise(String deviseSource, String deviseCible){
		CurrencyConvertor service = new CurrencyConvertor();
		CurrencyConvertorSoap proxy = service.getCurrencyConvertorSoap();
			
		return proxy.conversionRate(Currency.fromValue(deviseSource), Currency.fromValue(deviseCible));
	}
}
