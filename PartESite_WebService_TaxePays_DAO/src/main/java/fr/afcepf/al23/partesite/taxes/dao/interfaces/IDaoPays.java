package fr.afcepf.al23.partesite.taxes.dao.interfaces;

import fr.afcepf.al23.partesite.taxes.entity.Pays;

public interface IDaoPays {
	public Pays addPays(Pays pays);
	public Pays searchPaysByName(String name);
	public Pays searchPaysByIso(String iso);
	public Pays searchPaysById(Integer id);
}
