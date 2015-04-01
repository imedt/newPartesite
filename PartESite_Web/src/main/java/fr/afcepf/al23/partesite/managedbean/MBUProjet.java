package fr.afcepf.al23.partesite.managedbean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

import fr.afcepf.al23.model.entities.Project;
import fr.afcepf.al23.partesite.iservice.offer.IBusinessPack;
import fr.afcepf.al23.partesite.iservice.offer.IBusinessProject;

@ManagedBean(name = "mbUProjet")
@SessionScoped
public class MBUProjet {

	private Logger log = Logger.getLogger(getClass());

	@EJB
	IBusinessProject buProject;
	@EJB
	IBusinessPack buPack;

	@ManagedProperty(value = "#{mbConnexion}")
	MBConnexion cnx;

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

	public MBConnexion getCnx() {
		return cnx;
	}

	public void setCnx(MBConnexion cnx) {
		this.cnx = cnx;
	}

	public List<Project> getAllProjects() {
		allProjects=searchProjectByIdentity();
		return allProjects;
	}

	public void setAllProjects(List<Project> allProjects) {
		this.allProjects = allProjects;
	}

	private List<Project> allProjects;

	public List<Project> searchProjectByIdentity() {
		allProjects=null;
		allProjects=buProject.getByIdentity(cnx.getId());
		return allProjects;
	}

}
