package fr.afcepf.al23.partesite.service.impl.user;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import fr.afcepf.al23.model.entities.IdentityRole;
import fr.afcepf.al23.partesite.idao.user.IDaoIdentityRole;
import fr.afcepf.al23.partesite.iservice.user.IBusinessIdentityRole;
@Stateless
public class BusinessIdentityRoleImpl implements IBusinessIdentityRole {
	
	@EJB
private IDaoIdentityRole daoIR;
	
	@Override
	public IdentityRole save(IdentityRole identityRole) {
		if(identityRole.getIdIdentityRole() == null)
			daoIR.add(identityRole);
		else
			daoIR.update(identityRole);
		return identityRole;
	}

	@Override
	public IdentityRole get(Integer idIdentityRole) {
		IdentityRole identityRole = null;
		identityRole = daoIR.get(idIdentityRole);
		return identityRole;
	}

	@Override
	public List<IdentityRole> getAll() {
		List<IdentityRole> identityRoles = null;
		identityRoles = daoIR.getAll();
		return identityRoles;
	}

}
