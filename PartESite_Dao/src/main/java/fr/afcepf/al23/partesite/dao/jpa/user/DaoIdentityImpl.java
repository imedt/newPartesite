package fr.afcepf.al23.partesite.dao.jpa.user;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import fr.afcepf.al23.model.entities.Address;
import fr.afcepf.al23.model.entities.Identity;
import fr.afcepf.al23.model.entities.IdentityRight;
import fr.afcepf.al23.model.entities.Phone;
import fr.afcepf.al23.partesite.idao.user.IDaoIdentity;

@Stateless
public class DaoIdentityImpl implements IDaoIdentity {
	private Logger log = Logger.getLogger(getClass());

	public DaoIdentityImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext(unitName = "PartESite_Dao")
	private EntityManager em;



	@Override
	public Identity add(Identity identity) {
		//Civility civ = em.find(Civility.class, identity.getCivility());
		//identity.setCivility(civ);
		em.persist(identity);
		em.flush();
		return identity;
	}

	@Override
	public Identity update(Identity identity) {
		em.merge(identity);
		em.flush();
		return identity;
	}

	@Override
	public Identity get(Integer idIdentity) {
		Identity identity = null;
		log.info(em);
		
		try {
			Query hql = em
				.createQuery("SELECT ident FROM Identity ident WHERE ident.idIdentity = :id_identity")
				.setParameter("id_identity", idIdentity);
		identity = (Identity) hql.getSingleResult(); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return identity;
	}

	@Override
	public List<IdentityRight> getIdentityRights(Integer  idIdentityRole) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Address> getAddresses(Integer  idIdentity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Phone> getPhones(Integer  idIdentity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Identity connexion(String email, String mdp) {
		Identity identity = null;
		Query hql = em
				.createQuery(
						"SELECT ident FROM Identity ident WHERE ident.email = :email AND ident.mdp = :mdp")
				.setParameter("email", email).setParameter("mdp", mdp);
		if ( hql.getResultList().size()==1 )
		{
		identity = (Identity) hql.getSingleResult();
		}
		return identity;
	}

	@Override
	public Boolean  phoneExist(String phoneNumber) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Boolean  emailExist(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Identity> getBlackList() {
		List<Identity> identities = null;
		Query hql = em.createQuery(
				"SELECT ident FROM Identity ident WHERE ident.blacklist = :pblack")
				.setParameter("pblack", true);
		identities = hql.getResultList();
		return identities;
	}

	@Override
	public List<Identity> getAll() {
		List<Identity> identities = null;
		Query hql = em.createQuery(
				"SELECT DISTINCT ident FROM Identity ident ORDER BY ident.lastName ASC");
		identities = hql.getResultList();
		return identities;
	}

}
