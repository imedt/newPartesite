package fr.afcepf.al23.gestiondevises.service;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.jws.WebService;

import fr.afcepf.al23.entity.Currency;
import fr.afcepf.al23.gestiondevises.dao.IDaoGestionDevises;
@Remote(IGestionDevises.class)
@Stateless
@WebService
public class GestionDevisesImpl implements IGestionDevises {

	@EJB
	private IDaoGestionDevises dao;
	
	@Override
	public double getCurrency(String nomDevise) {
		Currency c = dao.getCurrency(nomDevise);
		return c.getRate();
	}

}
