package fr.afcepf.al23.partesite.idao.user;

import java.util.List;

import javax.ejb.Remote;

import fr.afcepf.al23.model.entities.Civility;


@Remote
public interface IDaoCivility {
	public Civility add(Civility civility);
	public Civility update(Civility civility);
	public Civility get(Integer idCivility);
	public List<Civility> getall();
	public Boolean civilityExist(String civilityName);
}
