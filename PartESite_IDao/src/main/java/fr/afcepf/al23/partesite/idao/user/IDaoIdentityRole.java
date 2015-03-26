package fr.afcepf.al23.partesite.idao.user;

import java.util.List;

import javax.ejb.Remote;

import fr.afcepf.al23.partesite.model.entities.IdentityRight;
import fr.afcepf.al23.partesite.model.entities.IdentityRole;

@Remote
public interface IDaoIdentityRole {
	public IdentityRole add(IdentityRole identityRole);
	public IdentityRole update(IdentityRole identityRole);
	public IdentityRole get(int idIdentityRole);
	public List<IdentityRole> getAll();
	public List<IdentityRight> getRights(int idIdentityRole);
	public boolean roleExist(String roleName);
}
