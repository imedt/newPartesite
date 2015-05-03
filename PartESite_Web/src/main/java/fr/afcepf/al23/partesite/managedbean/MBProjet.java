package fr.afcepf.al23.partesite.managedbean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

import fr.afcepf.al23.model.entities.Identity;
import fr.afcepf.al23.model.entities.Pack;
import fr.afcepf.al23.model.entities.Project;
import fr.afcepf.al23.model.entities.ProjectCategory;
import fr.afcepf.al23.model.entities.ProjectContent;
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
	private List<Project>allProjects;
	private Integer financedAmount;

	public String sliceText(String text,int max){ 
		return text.length() > max ? (text.substring(0, max)+"...") : text; 
	}
	public Integer getFinancedAmount() {
		return financedAmount;
	}
	public void setFinancedAmount(Integer financedAmount) {
		this.financedAmount = financedAmount;
	}
	public List<Project> getAllProjects() {
		allProjects=null;
		allProjects=buProject.getAllPublish();
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


}
