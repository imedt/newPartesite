package fr.afcepf.al23.partesite.managedbean;


import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

import fr.afcepf.al23.model.entities.Project;
import fr.afcepf.al23.partesite.iservice.offer.IBusinessPack;
import fr.afcepf.al23.partesite.iservice.offer.IBusinessProject;

@ManagedBean(name="mbEditProject")
@SessionScoped
public class MBEditProject {

	private Logger log = Logger.getLogger(getClass());

	@ManagedProperty(value="#{mbConnexion}")
	MBConnexion cnx;
	
	@EJB
	IBusinessProject buProject;

	@EJB
	IBusinessPack buPack;

	private Project p;
	private String projectName;
	private Double aimingAmount;
	private String  contentConcept;
	private String direction;

	
	public MBConnexion getCnx() {
		return cnx;
	}
	public void setCnx(MBConnexion cnx) {
		this.cnx = cnx;
	}
	public IBusinessProject getBuProject() {
		return buProject;
	}
	public void setBuProject(IBusinessProject buProject) {
		this.buProject = buProject;
	}

	public IBusinessPack getBuPack() {
		return buPack;
	}
	public void setBuPack(IBusinessPack buPack) {
		this.buPack = buPack;
	}
	public Project getP() {
		return p;
	}
	public void setP(Project p) {
		this.p = p;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Double getAimingAmount() {
		return aimingAmount;
	}
	public void setAimingAmount(Double aimingAmount) {
		this.aimingAmount = aimingAmount;
	}
	public String  getContentConcept() {
		return contentConcept;
	}
	public void setContentConcept(String  contentConcept) {
		this.contentConcept = contentConcept;
	}


	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}

public String create(){
		
		p = new Project();
		p.setAimingAmount(aimingAmount);
		p.setProjectName(projectName);
		p.setIdentity(cnx.getId());
		p.setPublish(true);
		p.setCreatedDate(new Date());
		p.setPublishingDate(new Date());
		p.setUpdatedDate(new Date());
		p.setCreatedBy(cnx.getId().getIdIdentity());
		p.setUpdatedBy(cnx.getId().getIdIdentity());
		
		p = buProject.save(p);
		
		
		setDirection("/UserProjects.xhtml?faces-redirect=true");
		
		return "";
	}

}
