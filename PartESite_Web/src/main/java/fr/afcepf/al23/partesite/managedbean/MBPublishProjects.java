package fr.afcepf.al23.partesite.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.afcepf.al23.model.entities.Project;
import fr.afcepf.al23.partesite.iservice.offer.IBusinessProject;

@ManagedBean(name = "mbPublishProjects")
@SessionScoped
public class MBPublishProjects {


	@EJB
	IBusinessProject buProject;

	private List<Project> projects = new ArrayList<>();

	public List<Project> getProjects() {
		return projects= buProject.getAllProjectsToPublish();
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

}
