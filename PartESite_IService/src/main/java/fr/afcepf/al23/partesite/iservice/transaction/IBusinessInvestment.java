package fr.afcepf.al23.partesite.iservice.transaction;

import javax.ejb.Remote;

import fr.afcepf.al23.model.entities.Identity;

@Remote
public interface IBusinessInvestment {	
	Integer getNbInvestment(Identity identity);
	Integer getNbGift(Identity identity);
}
