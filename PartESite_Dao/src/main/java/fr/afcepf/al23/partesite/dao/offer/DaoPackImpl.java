package fr.afcepf.al23.partesite.dao.offer;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import fr.afcepf.al23.model.entities.Pack;
import fr.afcepf.al23.partesite.idao.offer.IDaoPack;

@Stateless
public class DaoPackImpl implements IDaoPack {

	private static Logger log = Logger.getLogger(DaoProjectImpl.class);

	@PersistenceContext(name = "PartESite_Dao")
	private EntityManager em;

	@Override
	public Pack add(Pack pack) {
		em.persist(pack);
		em.flush();

		return pack;
	}

	@Override
	public Pack update(Pack pack) {
		em.merge(pack);
		em.flush();
		return pack;
	}

	@Override
	public Pack get(Integer idPack) {

		Query hql = em.createQuery(
				"SELECT p FROM Pack p WHERE p.idPack=:pidPack").setParameter(
				"pidPack", idPack);

		Pack pack = null;

		pack = (Pack) hql.getSingleResult();
		pack.setNbSale(getNbSale(pack));

		return pack;
	}

	@Override
	public List<Pack> getAll() {

		Query hql = em.createQuery("SELECT* FROM Pack");

		List<Pack> packs = null;

		packs = hql.getResultList();
		for (Pack pack : packs) {
			pack.setNbSale(getNbSale(pack));
		}

		return packs;
	}

	@Override
	public List<Pack> getByidProject(Integer idProject) {
		//log.info("getByidProject = " + idProject);

		Query hql = em.createQuery(

		"SELECT p FROM Pack p WHERE p.project.idProject=:pidproject")

		.setParameter("pidproject", idProject);
		List<Pack> packs = null;

		packs = hql.getResultList();
		for (Pack pack : packs) {
			pack.setNbSale(getNbSale(pack));
		}

		return packs;
	}

	@Override
	public Integer getNbSale(Pack pack) {
		Integer nbSale = 0;
		//log.info("getNbSale");
		Query hql = em
				.createQuery(
						"SELECT count(*) FROM Item i WHERE i.pack = :ppack and i.itemState.idItemState = 3")
				.setParameter("ppack", pack);
		long nbTemp = 0;
		nbTemp = (long) hql.getSingleResult();
		nbSale = (Integer) (int) (long) nbTemp;
		//log.info(nbSale);
		return nbSale;
	}

}
