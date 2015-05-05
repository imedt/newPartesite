package fr.afcepf.al23.partesite.dao.offer;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import fr.afcepf.al23.model.entities.ProjectCategory;
import fr.afcepf.al23.partesite.idao.offer.IDaoProjectCategory;

@Stateless
public class DaoProjectCategoryImpl implements IDaoProjectCategory {

	private static Logger log = Logger.getLogger(DaoProjectImpl.class);

	@PersistenceContext(name = "PartESite_Dao")
	private EntityManager em;

	@Override
	public ProjectCategory add(ProjectCategory projectCategory) {

		em.persist(projectCategory);
		em.flush();

		return projectCategory;
	}

	@Override
	public ProjectCategory update(ProjectCategory projectCategory) {

		em.merge(projectCategory);
		em.flush();

		return projectCategory;
	}

	@Override
	public ProjectCategory get(Integer idProjectCategory) {
		Query hql = em
				.createQuery(
						"SELECT pc FROM ProjectCategory pc WHERE pc.idProjectCategory=:pidProjectCategory")
				.setParameter("pidProjectCategory", idProjectCategory);

		ProjectCategory pc = null;
		pc = (ProjectCategory) hql.getSingleResult();

		return pc;
	}

	@Override
	public List<ProjectCategory> getAll() {

		Query hql = em.createQuery("SELECT pc FROM ProjectCategory pc");
		List<ProjectCategory> pcs = null;

		pcs = hql.getResultList();

		return pcs;
	}

	@Override
	public List<ProjectCategory> getByName(String name) {

		Query hql = em
				.createQuery("SELECT pc FROM ProjectCategory pc WHERE pc.category=:pcategory");

		hql.setParameter("pcategory", name);
		List<ProjectCategory> pcs = null;

		pcs = hql.getResultList();

		return pcs;
	}

}
