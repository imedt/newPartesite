package fr.afcepf.al23.partesite.idao.offer;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import fr.afcepf.al23.model.entities.Identity;
import fr.afcepf.al23.model.entities.Project;
import fr.afcepf.al23.model.entities.ProjectCategory;

@Remote
public interface IDaoProject {

	public Project add(Project project);
	public Project update(Project project);
	public Project get(Integer idProject);
	public List<Project> getAll();
<<<<<<< HEAD
	public List<Project> getAllWithContents();
=======
>>>>>>> origin/master
	public List<Project> getAllPublish();
	public List<Project> getByIdentity(Identity identity);
	public List<Project> getByCategory(Integer idProjectCategory);
	public List<Project> getByName(String name);
	public List<Project> getByNameWithCategory(String name);
	public List<Project> getByPublishingDate(Date publishingDate);
	public List<Project> searchProjectsBy(String name,
			Date publishingDate, Double aimingAmount, ProjectCategory projectCategory,
			Identity identity);
	public List<Project> getAllProjectsToPublish();
	
}
