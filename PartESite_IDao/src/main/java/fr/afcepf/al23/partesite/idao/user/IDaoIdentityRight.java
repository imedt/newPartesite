package fr.afcepf.al23.partesite.idao.user;

import java.util.List;

import javax.ejb.Remote;

import fr.afcepf.al23.model.entities.IdentityRight;

@Remote
public interface IDaoIdentityRight {
	public IdentityRight add(IdentityRight identityRight);
	public IdentityRight update(IdentityRight identityRight);
	public IdentityRight get(Integer idIdentityRight);
	public List<IdentityRight> getAll();
	public List<IdentityRight> getByIdRole(Integer idIdentityRole);
	public Boolean rightExist(String actionName);
}
