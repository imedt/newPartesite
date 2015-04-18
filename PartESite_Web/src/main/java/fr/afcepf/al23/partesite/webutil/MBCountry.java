package fr.afcepf.al23.partesite.webutil;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.afcepf.al23.servicetaxes_frais.service.Country;
import fr.afcepf.al23.servicetaxes_frais.service.IServiceTaxesFrais;
import fr.afcepf.al23.servicetaxes_frais.service.ServiceTaxesFraisImplService;
@ManagedBean(name="mbCountry")
@SessionScoped
public class MBCountry {
	public Country findCountry(int id){
		IServiceTaxesFrais service = new ServiceTaxesFraisImplService().getPort(IServiceTaxesFrais.class);
		Country c = service.findCountry(id);
		return c;
	}
}
