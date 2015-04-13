package fr.afcepf.al23.partesite.managedbean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.afcepf.al23.model.entities.Identity;
import fr.afcepf.al23.model.entities.Notification;
import fr.afcepf.al23.model.entities.Project;
import fr.afcepf.al23.partesite.iservice.notification.IBusinessNotification;
import fr.afcepf.al23.partesite.iservice.offer.IBusinessProject;
import fr.afcepf.al23.partesite.iservice.user.IBusinessIdentity;

@ManagedBean(name = "mbPublishProjects")
@SessionScoped
public class MBPublishProjects {

	@EJB
	IBusinessIdentity buIdentity;
	@EJB
	IBusinessProject buProject;
	@EJB
	IBusinessNotification buNotification;
	
	private List<Project> projects = new ArrayList<>();

	public List<Project> getProjects() {
		return projects= buProject.getAllProjectsToPublish();
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public void publish(Project p){
		
		p.setPublish(true);
		p.setPublishingDate(new Date());
		p.setUpdatedBy(1);
		p.setUpdatedDate(new Date());
		buProject.save(p);
		getProjects();
		
		Notification n = new Notification();
		n.setCreatedBy(1);
		n.setCreatedDate(new Date());
		n.setContentNotification("Votre projet "+"<strong>"+p.getProjectName()+"</strong>"+" est publié.");
		Identity moderator = buIdentity.get(1);
		n.setIdentity(moderator);
		n.setIdTarget(p.getIdentity().getIdIdentity());
		n.setDisabled(false);
		buNotification.save(n);

	}
}
