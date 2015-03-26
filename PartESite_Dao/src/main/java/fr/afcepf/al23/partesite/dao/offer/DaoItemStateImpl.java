package fr.afcepf.al23.partesite.dao.offer;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import fr.afcepf.al23.partesite.idao.offer.IDaoItemState;
import fr.afcepf.al23.partesite.model.entities.Item;
import fr.afcepf.al23.partesite.model.entities.ItemState;

@Stateless
public class DaoItemStateImpl implements IDaoItemState {

	private static Logger log = Logger.getLogger(DaoProjectImpl.class);

	@PersistenceContext(name = "PartESite_Dao")
	private EntityManager em;

	@Override
	public ItemState add(ItemState itemState) {

		em.persist(itemState);
		em.flush();

		return itemState;
	}

	@Override
	public ItemState update(ItemState itemState) {

		em.merge(itemState);
		em.flush();
		return itemState;
	}

	@Override
	public ItemState get(Integer idItemState) {

		Query hql = em.createQuery(
				"SELECT i FROM ItemState i WHERE i.idItemState=:pidItemState")
				.setParameter(":pidItemState", idItemState);
		ItemState i = null;

		i = (ItemState) hql.getSingleResult();

		return i;
	}

	@Override
	public List<ItemState> getAll() {

		Query hql = em.createQuery("SELECT is FROM ItemState is");

		List<ItemState> is = null;

		is = hql.getResultList();

		return is;
	}

	@Override
	public ItemState getByName(String itemStateName) {

		Query hql = em
				.createQuery(
						"SELECT i FROM ItemState i WHERE i.itemStateName=:pitemStateName")
				.setParameter(":pitemStateName", itemStateName);

		ItemState is = null;

		is = (ItemState) hql.getSingleResult();

		return is;
	}

}
