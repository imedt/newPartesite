package fr.afcepf.al23.partesite.iservice.user;

import java.util.List;

import javax.ejb.Remote;

import fr.afcepf.al23.model.entities.Civility;
@Remote
public interface IBusinessCivility {
public Civility save(Civility civility);
public Civility get(Integer idCivility);
public List<Civility> getAll();
}
