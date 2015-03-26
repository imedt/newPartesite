package fr.afcepf.al23.partesite.service.impl.user;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import fr.afcepf.al23.partesite.idao.user.IDaoAddress;
import fr.afcepf.al23.partesite.idao.user.IDaoIdentity;
import fr.afcepf.al23.partesite.idao.user.IDaoPhone;
import fr.afcepf.al23.partesite.iservice.user.IBusinessIdentity;
import fr.afcepf.al23.partesite.model.entities.Address;
import fr.afcepf.al23.partesite.model.entities.Identity;
import fr.afcepf.al23.partesite.model.entities.Phone;

@Stateless
public class BusinessIdentityImpl implements IBusinessIdentity {

	@EJB
	private IDaoIdentity daoIdent;
	@EJB
	private IDaoPhone daoPhone;
	@EJB
	private IDaoAddress daoAddr;

	@Override
	public Identity save(Identity identity) {

		if (identity.getIdIdentity() == null || identity.getIdIdentity() == 0)
			identity = daoIdent.add(identity);
		else
			identity = daoIdent.update(identity);
		return identity;
	}

	@Override
	public Identity get(int IdIdentity) {
		Identity ident = null;
		ident = daoIdent.get(IdIdentity);
		return ident;
	}

	@Override
	public Identity connexion(String email, String mdp) {
		Identity ident = null;
		ident = daoIdent.connexion(email, mdp);
		return ident;
	}

	@Override
	public Identity delete(Identity identity) {
		identity.setDisabled(true);
		daoIdent.update(identity);
		return identity;
	}

	@Override
	public Identity blackList(Identity identity) {

		return null;
	}

	@Override
	public List<Identity> getBlackList() {
		List<Identity> identities = daoIdent.getBlackList();
		return identities;
	}

	@Override
	public List<Identity> getAll() {
		List<Identity> identities = daoIdent.getAll();
		return identities;
	}

}
