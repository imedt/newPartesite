package fr.afcepf.al23.partesite.dao.offer;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import fr.afcepf.al23.model.entities.Item;
import fr.afcepf.al23.model.entities.ItemState;
import fr.afcepf.al23.model.entities.Pack;
import fr.afcepf.al23.partesite.idao.offer.IDaoItem;


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
				"pidItem", idItem);

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

	@Override
	public List<Item> holdItemByNbByPack(int nb, Pack pack,int idOrderRow) {
		
		log.info("holdItemByNbByPack");
		Query hql = em.createQuery(
				"SELECT i FROM Item i WHERE i.pack = :pPack AND i.itemState = 1")
				.setParameter("pPack", pack);
		log.info("Query : "+hql.toString());
		List<Item> is = null; 
		hql.setMaxResults(nb);
		is = hql.getResultList();
		log.info("nb item = "+ is.size());
		if(is.size() == nb)
		{
			ItemState itemS = new ItemState();
			itemS.setIdItemState(2);
			itemS.setItemStateName("RESERVE");
			for (Item item : is) {
				item.setIdOrderRow(idOrderRow);
				item.setItemState(itemS);
				item = em.merge(item);
				em.flush();
			}
		}
		return is;
	}

	@Override
	public List<Item> SaleItemByNbByPack(List<Item> items) {
		ItemState itemSt = new ItemState();
		itemSt.setIdItemState(3);
		itemSt.setItemStateName("VENDU");
		
		for (Item item : items) {
			item.setItemState(itemSt);
		}
		em.merge(items);
		
		return items;
	}

	@Override
	public List<Item> ClearItemByNbByPack(List<Item> items) {
		ItemState itemSt = new ItemState();
		itemSt.setIdItemState(1);
		itemSt.setItemStateName("DISPONIBLE");
		
		for (Item item : items) {
			item.setItemState(itemSt);
			item.setIdOrderRow(null);
		}
		em.merge(items);
		return items;
	}

	@Override
	public List<Item> getItemsByOrderRow(Integer idOrderRow) { 
		Query hql = em.createQuery("SELECT i FROM Item i WHERE i.idOrderRow = :idOrderRow").setParameter("idOrderRow", idOrderRow);
		return hql.getResultList();
	}

}
