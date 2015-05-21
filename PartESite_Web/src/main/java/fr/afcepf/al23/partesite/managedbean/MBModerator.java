package fr.afcepf.al23.partesite.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

import fr.afcepf.al23.model.entities.Identity;
import fr.afcepf.al23.model.entities.Item;
import fr.afcepf.al23.model.entities.Pack;
import fr.afcepf.al23.model.entities.Project;
import fr.afcepf.al23.partesite.iservice.offer.IBusinessProject;
import fr.afcepf.al23.partesite.iservice.user.IBusinessIdentity;
import fr.afcepf.al23.partesite.webutil.MBConversion;

@ManagedBean(name = "mbModerator")
@SessionScoped
public class MBModerator {

	private Logger log = Logger.getLogger(getClass());

	@EJB
	private IBusinessIdentity buIdentity;
	@EJB
	private IBusinessProject buProject;

	// @ManagedProperty(value = "#{mbConnexion}")
	// private MBConnexion cnx;
	private String firstName;
	private Identity identity;
	private String direction;
	private Integer projectsEnCours;
	private Double projectsEnCoursMontant;
	private Integer projectsFinanced;
	private Double projectsFinancedMontant;
	private Integer userBlackList;
	private Double rentabilite;
	
	private String rentabiliteString;
	private String projectsFinancedMontantString;
	private String projectsEnCoursMontantString;
	
	@ManagedProperty(value = "#{mbConversion}")
	private MBConversion conversion;

	public void preRender(){
		ArrayList<Project> lProjet = (ArrayList<Project>) buProject.getAllCurrentlyPublished();
		projectsEnCours = lProjet.size();
		projectsFinanced = 0; 
		rentabilite = 0d;
		Double buff = 0d;
		for (Project p : lProjet) {
			Double aiming = p.getAimingAmount();
			Double current = 0d;
			for (Pack pack : p.getPacks()) {
				current += (pack.getAmount() * (pack.getTotalQuantity() - pack
						.getStock()));
			}
			if (aiming < current) {
				projectsFinanced++;
			}
			buff+=current; 
			rentabilite+=((current*10)/100);
		} 
		rentabiliteString = conversion.getConvertedAmount(rentabilite);
	} 

	public void loadUnpublishedProjects(){
		
	}
	public Logger getLog() {
		return log;
	}

	public void setLog(Logger log) {
		this.log = log;
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Identity getIdentity() {
		return identity;
	}

	public void setIdentity(Identity identity) {
		this.identity = identity;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public Integer getProjectsEnCours() {
		return projectsEnCours;
	}

	public void setProjectsEnCours(Integer projectsEnCours) {
		this.projectsEnCours = projectsEnCours;
	}

	public Double getProjectsEnCoursMontant() {
		return projectsEnCoursMontant;
	}

	public void setProjectsEnCoursMontant(Double projectsEnCoursMontant) {
		this.projectsEnCoursMontant = projectsEnCoursMontant;
	}

	public Integer getProjectsFinanced() {
		return projectsFinanced;
	}

	public void setProjectsFinanced(Integer projectsFinanced) {
		this.projectsFinanced = projectsFinanced;
	}

	public Double getProjectsFinancedMontant() {
		return projectsFinancedMontant;
	}

	public void setProjectsFinancedMontant(Double projectsFinancedMontant) {
		this.projectsFinancedMontant = projectsFinancedMontant;
	}

	public Integer getUserBlackList() {
		return userBlackList;
	}

	public void setUserBlackList(Integer userBlackList) {
		this.userBlackList = userBlackList;
	}

	public Double getRentabilite() {
		return rentabilite;
	}
 
	public void setRentabilite(Double rentabilite) {
		this.rentabilite = rentabilite;
	}

	public String getRentabiliteString() {
		return rentabiliteString;
	}

	public void setRentabiliteString(String rentabiliteString) {
		this.rentabiliteString = rentabiliteString;
	}

	public String getProjectsFinancedMontantString() {
		return projectsFinancedMontantString;
	}

	public void setProjectsFinancedMontantString(
			String projectsFinancedMontantString) {
		this.projectsFinancedMontantString = projectsFinancedMontantString;
	}

	public String getProjectsEnCoursMontantString() {
		return projectsEnCoursMontantString;
	}

	public void setProjectsEnCoursMontantString(String projectsEnCoursMontantString) {
		this.projectsEnCoursMontantString = projectsEnCoursMontantString;
	}

	public MBConversion getConversion() {
		return conversion;
	}

	public void setConversion(MBConversion conversion) {
		this.conversion = conversion;
	}
	


}
