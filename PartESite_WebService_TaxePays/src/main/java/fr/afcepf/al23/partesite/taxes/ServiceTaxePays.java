package fr.afcepf.al23.partesite.taxes;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;

import org.apache.log4j.Logger;

import fr.afcepf.al23.partesite.taxes.dao.interfaces.IDaoFrais;
import fr.afcepf.al23.partesite.taxes.entity.Frais;
import fr.afcepf.al23.partesite.taxes.entity.Pays;
import fr.afcepf.al23.partesite.taxes.interfaces.IServiceTaxePays;

@WebService
@Remote(IServiceTaxePays.class)
@Stateless
public class ServiceTaxePays implements IServiceTaxePays {
	private static Logger log = Logger.getLogger(ServiceTaxePays.class);
	@EJB
	private IDaoFrais daoFrais;
	@WebMethod
	public Frais getFrais(Pays origine, Pays destination) {
		log.info("Dans le WS");
		log.info("origine : "+origine.getId());
		log.info("Destination : "+destination.getId());
		if(origine.getId() == null || destination.getId() == null){
			return null;
		}
		log.info("va chercher dans dao");
		return daoFrais.searchFraisByPays(origine,destination);
	}

}
