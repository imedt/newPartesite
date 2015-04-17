package fr.afcepf.al23.conversion.test;

import fr.afcepf.al23.conversion.service.ConversionImplService;
import fr.afcepf.al23.conversion.service.IConversion;
import fr.afcepf.al23.gestiondevises.service.GestionDevisesImplService;
import fr.afcepf.al23.gestiondevises.service.IGestionDevises;

public class Main {

	
	public static void main(String[] args) {
		ConversionImplService service = new ConversionImplService();
		IConversion proxy = service.getConversionImplPort();
				
		GestionDevisesImplService service2 = new GestionDevisesImplService();
		IGestionDevises proxy2 = service2.getGestionDevisesImplPort();
		
		System.out.println(proxy.conversion(12000, "EUR", "USD"));
		System.out.println(proxy.conversion(12000, "USD", "EUR"));
		
		System.out.println("Taux EURO vers USD : "+proxy2.returnChangeByDevises("EUR", "USD"));
		System.out.println("Taux USD vers EURO : "+proxy2.returnChangeByDevises("USD", "EUR"));
	}

}
