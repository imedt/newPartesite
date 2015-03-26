package fr.afcepf.al23.partesite.iservice.user;

import java.util.List;

import javax.ejb.Remote;

import fr.afcepf.al23.partesite.model.entities.IdentityRole;;
@Remote
public interface IBusinessIdentityRole {
public IdentityRole save(IdentityRole identityRole);
public IdentityRole get(int idIdentityRole);
public List<IdentityRole> getAll();
}
