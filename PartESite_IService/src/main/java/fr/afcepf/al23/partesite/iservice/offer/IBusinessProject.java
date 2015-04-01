package fr.afcepf.al23.partesite.iservice.offer;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import fr.afcepf.al23.model.entities.Identity;
import fr.afcepf.al23.model.entities.Project;
import fr.afcepf.al23.model.entities.ProjectCategory;

@Remote
public interface IBusinessProject {
 
	public Project save(Project project);
	
	public Project get(int idProject);
		
	
	public Project publishProject(Project project);
		
	public Project disableProject(Project project);
	
	public List<Project> getAll();
	public List<Project> getAllWithItems();
	public List<Project> getAllFinancedProjects();
	public List<Project> waitingProjects();
	public List<Project> getByCategory(ProjectCategory projectCategory);
	public List<Project> getByName(String name);
	
	public List<Project> searchProjectsBy(
			String name,
			Date publishingDate,
			Double aimingAmount,
			ProjectCategory projectCategory,
			Identity identity
			);
	
	public List<Project> getAllPublish();
	public List<Project> getByIdentity(Identity identity);
}
