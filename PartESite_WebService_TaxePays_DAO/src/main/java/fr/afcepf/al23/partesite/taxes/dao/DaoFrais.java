package fr.afcepf.al23.partesite.taxes.dao;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import fr.afcepf.al23.partesite.taxes.dao.interfaces.IDaoFrais;
import fr.afcepf.al23.partesite.taxes.dao.interfaces.IDaoPays;
import fr.afcepf.al23.partesite.taxes.entity.Frais;
import fr.afcepf.al23.partesite.taxes.entity.Pays;
@Remote(IDaoFrais.class)
@Stateless
public class DaoFrais implements IDaoFrais {
	private Logger log = Logger.getLogger(DaoFrais.class);
	@PersistenceContext (unitName="PartESite_WebService_TaxePays_DAO")
	private EntityManager em;
	@Override
	public Frais searchFraisByPays(Pays origine, Pays destination) {
		String hql = "SELECT t FROM Frais t WHERE t.paysOrigine = :sourceId AND t.paysDestination = :destinationId";
		Query q = em.createQuery(hql).setParameter("sourceId",origine).setParameter("destinationId", destination);
		log.info("SAlutaiton t'es dans le DAO");
		return (Frais) q.getSingleResult();
	}

	@Override
	public Frais searchFraisById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Frais addFrais(Frais frais) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Frais deleteFrais(Frais frais) {
		// TODO Auto-generated method stub
		return null;
	}

}
