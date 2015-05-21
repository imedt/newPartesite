package fr.afcepf.al23.partesite.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.jsoup.Jsoup;

import fr.afcepf.al23.model.entities.Project;
import fr.afcepf.al23.model.entities.ProjectCategory;
import fr.afcepf.al23.partesite.iservice.offer.IBusinessProject;
import fr.afcepf.al23.partesite.iservice.offer.IBusinessProjectCategory;
import fr.afcepf.al23.partesite.webutil.MBConversion;


@ManagedBean(name="mbSearchProject")
@SessionScoped
public class MBSearchProject {
	@EJB
	private IBusinessProject buProject;
	@EJB
	private IBusinessProjectCategory buProjectCategory;
	@ManagedProperty(value="#{mbConversion}")
	private MBConversion mbConversion;
	@ManagedProperty(value="#{mbConnexion}")
	private MBConnexion mbConnexion;
	
	private ProjectCategory cat;
	private Integer idCategory;
	private String name;
	private List<ProjectCategory> categories;
	private List<Project> projects = new ArrayList<>();
	private Integer idProject;

	// Get & Set
	public void reinitProjects(){
		processConversion(projects); 
	}
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

	// Méthodes 

	public void searchByName() {
		projects = process(buProject.getByNameWithCategory(name));
	}  
	
	public void searchByCategory() {
		projects = process(buProject.getByCategory(getIdCategory()));
	}
	
	public void searchByCategory(ProjectCategory cat) {
		projects = process(buProject.getByCategory(cat.getIdProjectCategory()));
	}
  
	public void reset() { 
		projects = new ArrayList<>();
	}
	public MBConversion getMbConversion() {
		return mbConversion;
	}
	public void setMbConversion(MBConversion mbConversion) {
		this.mbConversion = mbConversion;
	}
	public MBConnexion getMbConnexion() {
		return mbConnexion;
	}
	public void setMbConnexion(MBConnexion mbConnexion) {
		this.mbConnexion = mbConnexion;
	}
	private List<Project> process(List<Project> projects){
		double taux = mbConversion.getTauxChange(mbConnexion.getDevise());
		for(Project p : projects){
			p.setAimingAmountEur(p.getAimingAmount());
			p.setAimingAmount(p.getAimingAmountEur()*taux);
			p.getProjectContents().get(3).setContent(Jsoup.parse(p.getProjectContents().get(3).getContent()).text());
		}      
		return projects;

	}
	private List<Project> processConversion(List<Project> projects){
		double taux = mbConversion.getTauxChange(mbConnexion.getDevise());
		for(Project p : projects){
			p.setAimingAmount(p.getAimingAmountEur()*taux);
			p.getProjectContents().get(3).setContent(Jsoup.parse(p.getProjectContents().get(3).getContent()).text());
		}      
		return projects;

	}
}
