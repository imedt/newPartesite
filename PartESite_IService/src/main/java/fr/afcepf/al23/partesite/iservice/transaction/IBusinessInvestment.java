package fr.afcepf.al23.partesite.iservice.transaction;

import javax.ejb.Remote;

import fr.afcepf.al23.partesite.model.entities.Identity;

@Remote
public interface IBusinessInvestment {	
	int getNbInvestment(Identity identity);
	int getNbGift(Identity identity);
}
