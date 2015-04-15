package fr.afcepf.al23.partesite.service.impl.user;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import fr.afcepf.al23.model.entities.Identity;
import fr.afcepf.al23.partesite.idao.user.IDaoAddress;
import fr.afcepf.al23.partesite.idao.user.IDaoIdentity;
import fr.afcepf.al23.partesite.idao.user.IDaoPhone;
import fr.afcepf.al23.partesite.iservice.user.IBusinessIdentity;

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

			if (identity.getIdIdentity() == null )
				identity = daoIdent.add(identity);
			else
				identity = daoIdent.update(identity);
	
		return identity;
	}

	//Verifier que l'identity n'existe pas d�j� dans la base
	@Override
	public String saveWithControlsBefore(Identity identity) {

		String message="";

			//On v�rifie que les champs sont bien remplis
			if ( identity.getCivility() != null
					&& identity.getFirstName()!= null
					&& identity.getLastName() != null
					&& identity.getEmail()!= null 
					&& identity.getMdp()!= null )
			{
				if ( daoIdent.emailExist(identity.getEmail())==false)
				{
					save(identity);
					message ="Inscription valid�e !";
				}
			}
			else 
			{
				message = "Email d�j� existant, veuillez vous connecter !";
			}

		return message;
	}

	@Override
	public Identity get(Integer IdIdentity) {
		Identity ident = null;
		try {
			ident = daoIdent.get(IdIdentity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ident;
	}

	@Override
	public Identity connexion(String email, String mdp) {
		Identity ident = null;
		try {
			ident = daoIdent.connexion(email, mdp);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
