package fr.afcepf.al23.partesite.iservice.user;

import java.util.List;

import javax.ejb.Remote;

import fr.afcepf.al23.partesite.model.entities.Civility;
@Remote
public interface IBusinessCivility {
public Civility save(Civility civility);
public Civility get(int idCivility);
public List<Civility> getAll();
}
