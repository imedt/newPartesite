package fr.afcepf.al23.partesite.iservice.user;

import java.util.List;

import javax.ejb.Remote;

import fr.afcepf.al23.partesite.model.entities.IdentityRight;
@Remote
public interface IBusinessIdentityRight {
public IdentityRight save(IdentityRight identityRight);
public IdentityRight get(int idIdentityRight);
public List<IdentityRight> getAll();
public List<IdentityRight> getByIdRole(int idIdentityRole);
}
