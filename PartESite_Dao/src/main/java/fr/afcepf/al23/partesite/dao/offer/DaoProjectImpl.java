package fr.afcepf.al23.partesite.dao.offer;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import fr.afcepf.al23.partesite.idao.offer.IDaoProject;
import fr.afcepf.al23.partesite.model.entities.Identity;
import fr.afcepf.al23.partesite.model.entities.Project;
import fr.afcepf.al23.partesite.model.entities.ProjectCategory;

@Stateless
public class DaoProjectImpl implements IDaoProject {

	private static Logger log = Logger.getLogger(DaoProjectImpl.class);

	@PersistenceContext(name = "PartESite_Dao")
	private EntityManager em;

	@Override
	public Project add(Project project) {

		em.persist(project);
		em.flush();
		return project;
	}

	@Override
	public Project update(Project project) {

		em.merge(project);
		em.flush();
		return project;
	}

	@Override
	public Project get(Integer idProject) {

		Query hql = em.createQuery(
				"SELECT p FROM Project p WHERE p.idProject=:pidProject")
				.setParameter("pidProject", idProject);
		Project p = null;

		p = (Project) hql.getSingleResult();

		return p;
	}

	@Override
	public List<Project> getAll() {

		Query hql = em
				.createQuery("SELECT DISTINCT p FROM Project p inner join fetch p.packs ");

		List<Project> liste = null;

		liste = hql.getResultList();

		return liste;
	}

	@Override
	public List<Project> getByName(String name) {

		Query hql = em
				.createQuery("SELECT p FROM Project p WHERE p.projectName like :pprojectName");
		hql.setParameter("pprojectName", "'%" + name + "%'");

		hql.executeUpdate();

		List<Project> liste = null;

		liste = hql.getResultList();

		return liste;
	}

	@Override
	public List<Project> getByPublishingDate(Date publishingDate) {

		Query hql = em
				.createQuery("SELECT p FROM Project p WHERE p.publishingDate=:ppublishingDate");
		hql.setParameter("ppublishingDate", publishingDate);

		hql.executeUpdate();

		List<Project> liste = null;

		liste = hql.getResultList();

		return liste;
	}

	@Override
	public List<Project> searchProjectsBy(String name, Date publishingDate,
			Double aimingAmount, ProjectCategory projectCategory,
			Identity identity) {

		Query hql = em
				.createQuery("SELECT p FROM Project p WHERE p.publishingDate=:ppublishingDate"
						+ " AND p.projectName=:pname"
						+ " AND p.projectCategory=:pcategory"
						+ " AND p.aimingAmount=:paimingAmount"
						+ " AND p.identity=:pidentity");
		hql.setParameter(":ppublishingDate", publishingDate);
		hql.setParameter(":pname", name);
		hql.setParameter(":pcategory", projectCategory);
		hql.setParameter(":paimingAmount", aimingAmount);
		hql.setParameter(":pidentity", identity);

		hql.executeUpdate();

		List<Project> liste = null;

		liste = hql.getResultList();

		return liste;
	}

	@Override
	public List<Project> getAllPublish() {
		List<Project> projects = null;
		Query hql = em.createQuery(
				"SELECT p FROM Project p WHERE p.publish=:ppublish")
				.setParameter("ppublish", true);
		projects = hql.getResultList();
		return projects;
	}

	@Override
	public List<Project> getByIdentity(Identity identity) {
		List<Project> projects = null;
		Query hql = em.createQuery(
				"SELECT p FROM Project p  inner join fetch p.packs WHERE p.identity=:pidentity")
				.setParameter("pidentity", identity);
		projects = hql.getResultList();
		return projects;
	}

	@Override
	public List<Project> getByCategory(ProjectCategory projectCategory) {
		Query hql = em
				.createQuery(
						"SELECT p FROM Project p WHERE p.projectCategory = :pprojectCategory")
				.setParameter("pprojectCategory", projectCategory);

		List<Project> liste = null;

		liste = hql.getResultList();

		return liste;
	}

}
