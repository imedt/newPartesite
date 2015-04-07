package com.main;

import org.apache.log4j.Logger;

import fr.afcepf.al23.partesite.taxes.IServiceTaxePays;
import fr.afcepf.al23.partesite.taxes.ServiceTaxePaysService;
import fr.afcepf.al23.partesite.taxes.interfaces.Frais;
import fr.afcepf.al23.partesite.taxes.interfaces.Pays;

public class Main {
	private static IServiceTaxePays istp;
	private static Logger log = Logger.getLogger(Main.class);
	public static void main(String[] args) {
		istp = new ServiceTaxePaysService().getPort(IServiceTaxePays.class);
		log.info("salut");
		Pays origine = new Pays();
		origine.setId(2);
		Pays destination = new Pays();
		destination.setId(2); 
		log.info(istp.toString());
		Frais f = istp.getFrais(origine, destination);
		log.info(f.toString());
	}

}
