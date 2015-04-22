package net.webservicex.gestiondevises.service;

import net.webservicex.Currency;
import net.webservicex.CurrencyConvertor;
import net.webservicex.CurrencyConvertorSoap;

public class ServiceGestionDevises {
	public double retourChanges(String deviseSource, String deviseCible){
		CurrencyConvertor service = new CurrencyConvertor();
		CurrencyConvertorSoap proxy = service.getCurrencyConvertorSoap();
			
		return proxy.conversionRate(Currency.fromValue(deviseSource), Currency.fromValue(deviseCible));
	}
}
