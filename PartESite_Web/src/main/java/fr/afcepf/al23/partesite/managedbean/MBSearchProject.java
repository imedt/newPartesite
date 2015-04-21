package fr.afcepf.al23.partesite.managedbean;

import java.util.ArrayList;
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
	private Integer idCategory;
	private String name;
	private List<ProjectCategory> categories;
	private List<Project> projects = new ArrayList<>();
	private Integer idProject;

	// Get & Set

	public List<ProjectCategory> getCategories() {
		categories = buProjectCategory.getAll();
		return categories;
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
		cat = buProjectCategory.get(getIdCategory());
		return cat;
	}
	public void setCat(ProjectCategory cat) {
		this.cat = cat;
	}
	public Integer getIdCategory() {
		return idCategory;
	}
	public void setIdCategory(Integer idCategory) {
		this.idCategory = idCategory;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCategories(List<ProjectCategory> categories) {
		this.categories = categories;
	}
	public Integer getIdProject() {
		return idProject;
	}
	public void setIdProject(Integer idProject) {
		this.idProject = idProject;
	}
	public List<Project> getProjects() {
		return projects;
	}
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	// M�thodes 
	public void searchByName() {
		projects = buProject.getByNameWithCategory(name);
	}

	public void searchByCategory() {
		projects = buProject.getByCategory(getIdCategory());
	}

	public void reset() {
		projects = new ArrayList<>();
	}
}
