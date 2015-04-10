package fr.afcepf.al23.main;

import fr.afcepf.al23.conversion.service.ConversionImplService;
import fr.afcepf.al23.conversion.service.IConversion;
import fr.afcepf.al23.gestiondevises.service.GestionDevisesImplService;
import fr.afcepf.al23.gestiondevises.service.IGestionDevises;

public class Main {
	public static void main(String[] args) {

		GestionDevisesImplService service = new GestionDevisesImplService();
		IGestionDevises proxy = service.getGestionDevisesImplPort();
		
		ConversionImplService service2 = new ConversionImplService();
		IConversion proxy2 = service2.getConversionImplPort();
		System.out.println("Le taux est : "+proxy.getCurrency("usd"));
		System.out.println("Résultat : "+proxy2.conversion(100, "euro", "usd"));
		
		
	}
}
