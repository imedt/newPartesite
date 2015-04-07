package fr.afcepf.al23.partesite.taxes.dao;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import fr.afcepf.al23.partesite.taxes.dao.interfaces.IDaoPays;
import fr.afcepf.al23.partesite.taxes.entity.Pays;
@Remote(IDaoPays.class)
@Stateless
public class DaoPays implements IDaoPays {

	@Override
	public Pays addPays(Pays pays) {
		return null;
	}

	@Override
	public Pays searchPaysByName(String name) {
		return null;
	}

	@Override
	public Pays searchPaysByIso(String iso) {
		return null;
	}

	@Override
	public Pays searchPaysById(Integer id) {
		return null;
	}
}