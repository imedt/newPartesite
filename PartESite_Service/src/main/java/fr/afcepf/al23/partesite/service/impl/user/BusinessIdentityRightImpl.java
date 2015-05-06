package fr.afcepf.al23.partesite.service.impl.user;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import fr.afcepf.al23.model.entities.IdentityRight;
import fr.afcepf.al23.partesite.idao.user.IDaoIdentityRight;
import fr.afcepf.al23.partesite.iservice.user.IBusinessIdentityRight;
@Stateless
public class BusinessIdentityRightImpl implements IBusinessIdentityRight {

	@EJB
	private IDaoIdentityRight daoIRi;
	
	@Override
	public IdentityRight save(IdentityRight identityRight) {
		if(identityRight.getIdIdentityRight() == null)
			daoIRi.add(identityRight);
		else
			daoIRi.update(identityRight);
		return identityRight;
	}

	@Override
	public IdentityRight get(Integer idIdentityRight) {
		IdentityRight identityRight = null;
		identityRight = daoIRi.get(idIdentityRight);
		return identityRight;
	}

	@Override
	public List<IdentityRight> getAll() {
		List<IdentityRight> identityRights = null;
		identityRights = daoIRi.getAll();
		return identityRights;
	}

	@Override
	public List<IdentityRight> getByIdRole(Integer idIdentityRole) {
		List<IdentityRight> identityRights = null;
		identityRights = daoIRi.getByIdRole(idIdentityRole);
		return identityRights;
	}

}
