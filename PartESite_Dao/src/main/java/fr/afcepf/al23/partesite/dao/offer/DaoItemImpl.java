package fr.afcepf.al23.partesite.dao.offer;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import fr.afcepf.al23.partesite.idao.offer.IDaoItem;
import fr.afcepf.al23.partesite.model.entities.Item;
import fr.afcepf.al23.partesite.model.entities.Pack;
import fr.afcepf.al23.partesite.model.entities.ProjectCategory;

@Stateless
public class DaoItemImpl implements IDaoItem {

	private static Logger log = Logger.getLogger(DaoProjectImpl.class);

	@PersistenceContext(name = "PartESite_Dao")
	private EntityManager em;

	@Override
	public Item add(Item item) {

		em.persist(item);
		em.flush();

		return item;
	}

	@Override
	public Item update(Item item) {

		em.merge(item);
		em.flush();
		return item;
	}

	@Override
	public Item get(Integer idItem) {

		Query hql = em.createQuery(
				"SELECT i FROM Item i WHERE i.idItem=:pidItem").setParameter(
				":pidItem", idItem);

		Item i = null;

		i = (Item) hql.getSingleResult();

		return i;
	}

	@Override
	public List<Item> getSaleByPack(Pack pack) {

		Query hql = em.createQuery(
				"SELECT i FROM Item i WHERE i.pack=:pPack AND i.itemState = 2")
				.setParameter("pPack", pack);

		List<Item> is = null;

		is = hql.getResultList();

		return is;
	}

	@Override
	public List<Item> getDispoByPack(Pack pack) {
		Query hql = em.createQuery(
				"SELECT i FROM Item i WHERE i.pack=:pPack AND i.itemState = 1")
				.setParameter("pPack", pack);

		List<Item> is = null;

		is = hql.getResultList();

		return is;
	}

}
