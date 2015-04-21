package fr.afcepf.al23.partesite.idao.user;

import java.util.List;

import javax.ejb.Remote;

import fr.afcepf.al23.model.entities.IdentityRight;
import fr.afcepf.al23.model.entities.IdentityRole;

@Remote
public interface IDaoIdentityRole {
	public IdentityRole add(IdentityRole identityRole);
	public IdentityRole update(IdentityRole identityRole);
	public IdentityRole get(Integer idIdentityRole);
	public List<IdentityRole> getAll();
	public List<IdentityRight> getRights(Integer idIdentityRole);
	public Boolean roleExist(String roleName);
}
