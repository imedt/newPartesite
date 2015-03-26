package fr.afcepf.al23.partesite.dao.jpa.user;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.al23.partesite.idao.user.IDaoAddress;
import fr.afcepf.al23.partesite.model.entities.Address;
import fr.afcepf.al23.partesite.model.entities.Project;
@Stateless
public class DaoAddressImpl implements IDaoAddress {

	@PersistenceContext(unitName = "PartESite_Dao")
	private EntityManager em;

	@Override
	public Address add(Address address) {
		em.persist(address);
		em.flush();
		return address;
	}


	public DaoAddressImpl() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public Address update(Address address) {
		em.merge(address);
		em.flush();
		return address;
	}

	@Override
	public Address get(int idAddress) {
		Address address = null;
		Query hql = em
				.createQuery(
						"SELECT add FROM Address add WHERE add.id_address = :id_address ")
				.setParameter("id_address", idAddress);
		address = (Address) hql.getSingleResult();
		return address;
	}

	@Override
	public List<Address> getByIdIdentity(int idIdentity) {
		List<Address> addresses = null;
		Query hql = em
				.createQuery(
						"SELECT add FROM Address add WHERE add.id_identity = :id_identity ")
				.setParameter("id_identity", idIdentity);
		addresses = hql.getResultList();
		return addresses;
	}

}
