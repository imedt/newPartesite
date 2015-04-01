package fr.afcepf.al23.partesite.managedbean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

import fr.afcepf.al23.model.entities.Identity;
import fr.afcepf.al23.model.entities.Project;
import fr.afcepf.al23.model.entities.ProjectCategory;
import fr.afcepf.al23.partesite.iservice.offer.IBusinessProject;

@ManagedBean(name="mbProjet")
@SessionScoped
public class MBProjet {

	private Logger log = Logger.getLogger(getClass());
	
	@EJB
	IBusinessProject buProject;
	
	private Identity identity;
	
	
	private String projectName;
	private ProjectCategory projectCategory;
	private String publishingDate;
	private Double aimingAmount;
	private List<Project>liste;
	private List<Project>allProjects;
	
	
	public List<Project> getAllProjects() {
		allProjects=null;
		allProjects=buProject.getAllWithItems();
		return allProjects;
	}
	public void setAllProjects(List<Project> allProjects) {
		this.allProjects = allProjects;
	}
	public String getPublishingDate() {
		return publishingDate;
	}
	public void setPublishingDate(String publishingDate) {
		this.publishingDate = publishingDate;
	}
	public IBusinessProject getBuProject() {
		return buProject;
	}
	public void setBuProject(IBusinessProject buProject) {
		this.buProject = buProject;
	}
	public Identity getIdentity() {
		return identity;
	}
	public void setIdentity(Identity identity) {
		this.identity = identity;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public ProjectCategory getProjectCategory() {
		return projectCategory;
	}
	public void setProjectCategory(ProjectCategory projectCategory) {
		this.projectCategory = projectCategory;
	}
	public Double getAimingAmount() {
		return aimingAmount;
	}
	public void setAimingAmount(Double aimingAmount) {
		this.aimingAmount = aimingAmount;
	}

	public List<Project> getListe() {
		
		return liste;
	}
	public void setListe(List<Project> liste) {
		this.liste = liste;
	}
	
	public String search(){
		liste=null;
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date date=null;
		try {
			date = sdf.parse(publishingDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		liste=buProject.searchProjectsBy(projectName, new java.sql.Date(date.getTime()), aimingAmount, projectCategory, identity);
		
		log.info(liste.size());
		return "";
	}
	

	
	public String create(){
		liste=null;
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date date=null;
		try {
			date = sdf.parse(publishingDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		

		log.info(liste.size());
		return "";
	}
}
