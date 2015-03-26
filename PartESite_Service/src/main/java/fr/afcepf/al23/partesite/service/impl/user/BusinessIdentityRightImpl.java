package fr.afcepf.al23.partesite.service.impl.user;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import fr.afcepf.al23.partesite.idao.user.IDaoIdentityRight;
import fr.afcepf.al23.partesite.iservice.user.IBusinessIdentityRight;
import fr.afcepf.al23.partesite.model.entities.IdentityRight;
@Stateless
public class BusinessIdentityRightImpl implements IBusinessIdentityRight {

	@EJB
	private IDaoIdentityRight daoIRi;
	
	@Override
	public IdentityRight save(IdentityRight identityRight) {
		if(identityRight.getIdIdentityRight() == 0)
			daoIRi.add(identityRight);
		else
			daoIRi.update(identityRight);
		return identityRight;
	}

	@Override
	public IdentityRight get(int idIdentityRight) {
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
	public List<IdentityRight> getByIdRole(int idIdentityRole) {
		List<IdentityRight> identityRights = null;
		identityRights = daoIRi.getByIdRole(idIdentityRole);
		return identityRights;
	}

}
