package fr.afcepf.al23.partesite.managedbean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.afcepf.al23.model.entities.Identity;
import fr.afcepf.al23.model.entities.Notification;
import fr.afcepf.al23.model.entities.Project;
import fr.afcepf.al23.partesite.iservice.notification.IBusinessNotification;
import fr.afcepf.al23.partesite.iservice.offer.IBusinessProject;
import fr.afcepf.al23.partesite.iservice.user.IBusinessIdentity;
import fr.afcepf.al23.partesite.webutil.MBConversion;

@ManagedBean(name = "mbPublishProjects")
@SessionScoped
public class MBPublishProjects {

	@EJB
	private IBusinessIdentity buIdentity;
	@EJB
	private IBusinessProject buProject;
	@EJB
	private IBusinessNotification buNotification;
	
	@ManagedProperty(value="#{mbConnexion}")
	private MBConnexion mbCnx;
	
	@ManagedProperty(value="#{mbConversion}")
	private MBConversion mbConversion;

	
	private List<Project> projects = new ArrayList<>();

	
	
	
	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	
	public void preRender(){
		projects = mbConversion.processConversion(buProject.getAllProjectsToPublish(),mbCnx.getDevise());
	}
	 
	public void publish(Project p){
		
		p.setPublish(true);
		p.setPublishingDate(new Date());
		p.setUpdatedBy(1);
		p.setUpdatedDate(new Date());
		buProject.save(p);
		
		Notification n = new Notification();
		n.setCreatedBy(1);
		n.setCreatedDate(new Date());
		n.setContentNotification("Votre projet "+p.getProjectName()+" est publié.");
		n.setIdentity(mbCnx.getId()); 
		n.setIdTarget(p.getIdentity().getIdIdentity());
		n.setDisabled(false); 
		buNotification.save(n);
	}

	public IBusinessIdentity getBuIdentity() {
		return buIdentity;
	}

	public void setBuIdentity(IBusinessIdentity buIdentity) {
		this.buIdentity = buIdentity;
	}

	public IBusinessProject getBuProject() {
		return buProject;
	}

	public void setBuProject(IBusinessProject buProject) {
		this.buProject = buProject;
	}

	public IBusinessNotification getBuNotification() {
		return buNotification;
	}

	public void setBuNotification(IBusinessNotification buNotification) {
		this.buNotification = buNotification;
	}

	public MBConnexion getMbCnx() {
		return mbCnx;
	}

	public void setMbCnx(MBConnexion mbCnx) {
		this.mbCnx = mbCnx;
	}

	public MBConversion getMbConversion() {
		return mbConversion;
	}

	public void setMbConversion(MBConversion mbConversion) {
		this.mbConversion = mbConversion;
	}
	
}
