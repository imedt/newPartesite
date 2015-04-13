package fr.afcepf.al23.partesite.dao.offer;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import fr.afcepf.al23.model.entities.ProjectContent;
import fr.afcepf.al23.partesite.idao.offer.IDaoProjectContent;

@Stateless
public class DaoProjectContentImpl implements IDaoProjectContent {

	private static Logger log = Logger.getLogger(DaoProjectImpl.class);

	@PersistenceContext(name = "PartESite_Dao")
	private EntityManager em;

	@Override
	public ProjectContent add(ProjectContent projectContent) {

		em.persist(projectContent);
		em.flush();
		return projectContent;
	}

	@Override
	public ProjectContent update(ProjectContent projectContent) {

		em.merge(projectContent);
		em.flush();
		return projectContent;
	}

	@Override
	public ProjectContent get(Integer idProjectContent) {

		Query hql = em
				.createQuery(
						"SELECT p FROM ProjectContent p WHERE p.idContentProject=:pidContentProject")
				.setParameter(":pidContentProject", idProjectContent);
		ProjectContent cp = null;

		cp = (ProjectContent) hql.getSingleResult();

		return cp;

	}

	@Override
	public List<ProjectContent> getByidProject(int idProject) {

		Query hql = em
				.createQuery(
						"SELECT p FROM ProjectContent p WHERE p.project.idProject=:idProject")
				.setParameter("idProject", idProject);
		List<ProjectContent> cps = null;

		cps = hql.getResultList();

		return cps;

	}

}
