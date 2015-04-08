package fr.afcepf.al23.partesite.managedbean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.afcepf.al23.model.entities.Project;
import fr.afcepf.al23.model.entities.ProjectCategory;
import fr.afcepf.al23.partesite.iservice.offer.IBusinessProject;
import fr.afcepf.al23.partesite.iservice.offer.IBusinessProjectCategory;


@ManagedBean(name="mbSearchProject")
@SessionScoped
public class MBSearchProject {


	@EJB
	private IBusinessProject buProject;

	@EJB
	private IBusinessProjectCategory buProjectCategory;

	private ProjectCategory cat;
	private String category;
	private String name;
	private List<ProjectCategory> categories;
	private List<Project> projects;

	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public IBusinessProject getBuProject() {
		return buProject;
	}
	public void setBuProject(IBusinessProject buProject) {
		this.buProject = buProject;
	}
	public IBusinessProjectCategory getBuProjectCategory() {
		return buProjectCategory;
	}
	public void setBuProjectCategory(IBusinessProjectCategory buProjectCategory) {
		this.buProjectCategory = buProjectCategory;
	}
	public ProjectCategory getCat() {
		return cat;
	}
	public void setCat(ProjectCategory cat) {
		this.cat = cat;
	}
	public List<ProjectCategory> getCategories() {
		categories = buProjectCategory.getAll();
		return categories;
	}
	public void setCategories(List<ProjectCategory> categories) {
		this.categories = categories;
	}
	public List<Project> getProjects() {
		return projects;
	}
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}



	public List<Project> searchByName() {
		
		projects = buProject.getByName(name);

		return projects;
	}

	public List<Project> searchByCategory() {

		projects = buProject.getByCategory(cat);

		return projects;
	}

}
