package fr.afcepf.al23.partesite.dao.jpa.user;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.afcepf.al23.model.entities.Phone;
import fr.afcepf.al23.partesite.idao.user.IDaoPhone;
@Stateless
public class DaoPhoneImpl implements IDaoPhone {

	public DaoPhoneImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext(unitName = "PartESite_Dao")
	private EntityManager em;

	@Override
	public Phone add(Phone phone) {
		em.persist(phone);
		em.flush();
		return phone;
	}

	@Override
	public Phone update(Phone phone) {
		em.merge(phone);
		em.flush();
		return phone;
	}

	@Override
	public Phone get(Integer  idPhone) {
		Phone phone = null;
		Query hql = em.createQuery(
				"SELECT ph FROM Phone ph WHERE ph.idPhone = :id_phone")
				.setParameter("id_phone", idPhone);
		phone = (Phone) hql.getSingleResult();
		return phone;
	}

	@Override
	public List<Phone> getByIdIdentity(Integer  idIdentity) {
		List<Phone> phones = null;
		Query hql = em.createQuery(
				"SELECT ph FROM Phone ph WHERE ph.identity.idIdentity = :id_Identity")
				.setParameter("id_Identity", idIdentity);
		phones = hql.getResultList();
		return phones;
	}

	@Override
	public Boolean phoneExist(String phoneNumber) {
		Phone phone = null;
		Query hql = em.createQuery(
				"SELECT ph FROM Phone ph WHERE ph.phoneNumber = :phoneNumber")
				.setParameter("phoneNumber", phoneNumber);
		phone = (Phone) hql.getSingleResult();
		if (phone != null)
			return true;
		else
			return false;
	}

}
