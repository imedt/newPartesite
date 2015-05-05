package fr.afcepf.al23.partesite.iservice.user;

import java.util.List;

import javax.ejb.Remote;

import fr.afcepf.al23.model.entities.IdentityRole;
@Remote
public interface IBusinessIdentityRole {
public IdentityRole save(IdentityRole identityRole);
public IdentityRole get(Integer idIdentityRole);
public List<IdentityRole> getAll();
}
