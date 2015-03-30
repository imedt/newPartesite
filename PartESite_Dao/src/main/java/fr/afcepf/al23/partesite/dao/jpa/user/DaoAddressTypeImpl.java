package fr.afcepf.al23.partesite.dao.jpa.user;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.al23.partesite.idao.user.IDaoAddressType;
import fr.afcepf.al23.partesite.model.entities.AddressType;

@Stateless
public class DaoAddressTypeImpl implements IDaoAddressType {

	
	public DaoAddressTypeImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext(unitName = "PartESite_Dao")
	EntityManager em;
	
	@Override
	public AddressType add(AddressType addressType) {
		em.persist(addressType);
		em.flush();
		return addressType;
	}

	@Override
	public AddressType update(AddressType addressType) {
		em.merge(addressType);
		em.flush();
		return addressType;
	}

	@Override
	public AddressType get(Integer idAddressType) {
		AddressType addressType = null;
		Query hql = em
				.createQuery(
						"SELECT add FROM AddressType add WHERE add.idAddressType = :id_addressType ")
				.setParameter("id_addressType", idAddressType);
		addressType = (AddressType) hql.getSingleResult();
		return addressType;
	}

	@Override
	public List<AddressType> getall() {
		List<AddressType> addressTypes = null;
		Query hql = em
				.createQuery(
						"SELECT at FROM AddressType at");
		addressTypes = hql.getResultList();
		return addressTypes;
	}

}
