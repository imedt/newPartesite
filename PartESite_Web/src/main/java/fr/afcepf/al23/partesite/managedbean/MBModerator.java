package fr.afcepf.al23.partesite.managedbean;

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
	private int projectsEnCours;
	private Double projectsEnCoursMontant;
	private int projectsFinanced;
	private Double projectsFinancedMontant;
	private int userBlackList;
	private Double rentabilite;
	
	private String rentabiliteString;
	private String projectsFinancedMontantString;
	private String projectsEnCoursMontantString;
	
	@ManagedProperty(value = "#{mbConversion}")
	private MBConversion conversion;
	

	public MBConversion getConversion() {
		return conversion;
	}

	public void setConversion(MBConversion conversion) {
		this.conversion = conversion;
	}

	public String getRentabiliteString() {		
		rentabiliteString = conversion.getConvertedAmount(rentabilite);
		return rentabiliteString ;
	}

	public void setRentabiliteString(String rentabiliteString) {
		this.rentabiliteString = rentabiliteString;
	}

	public String getProjectsFinancedMontantString() {
		projectsFinancedMontantString = conversion.getConvertedAmount(projectsFinancedMontant);
		return projectsFinancedMontantString;
	}

	public void setProjectsFinancedMontantString(
			String projectsFinancedMontantString) {
		this.projectsFinancedMontantString = projectsFinancedMontantString;
	}

	public String getProjectsEnCoursMontantString() {
		projectsEnCoursMontantString = conversion.getConvertedAmount(projectsEnCoursMontant);
		return projectsEnCoursMontantString;
	}

	public void setProjectsEnCoursMontantString(String projectsEnCoursMontantString) {
		this.projectsEnCoursMontantString = projectsEnCoursMontantString;
	}

	public Logger getLog() {
		return log;
	}

	public void setLog(Logger log) {
		this.log = log;
	}

	public IBusinessProject getBuProject() {
		return buProject;
	}

	public void setBuProject(IBusinessProject buProject) {
		this.buProject = buProject;
	}

	public int getUserBlackList() {
		return userBlackList;
	}

	public void setUserBlackList(int userBlackList) {
		this.userBlackList = userBlackList;
	}

	public String getFirstName() {
		return firstName;
	}

	public Double getRentabilite() {
		List<Project> temp = buProject.getAllFinancedProjects();
		projectsFinancedMontant = (double) 0;
		for (Project project : temp) {
			for (Pack pack : project.getPacks()) {
				projectsFinancedMontant += pack.getAmount() * pack.getNbSale();
			}
		}
		rentabilite = projectsFinancedMontant / 10;
		temp.clear();
		return rentabilite;
	}

	public void setRentabilite(Double rentabilite) {
		this.rentabilite = rentabilite;
	}

	public int getProjectsFinanced() {
		List<Project> temp = buProject.getAllFinancedProjects();
		projectsFinanced = temp.size();
		log.info(temp);
		log.info(temp.size());
		temp.clear();
		return projectsFinanced;
	}

	public int getProjectsEnCours() {
		List<Project> temp = buProject.getAllWithItems();
		projectsEnCours = temp.size();
		log.info(temp);
		log.info(temp.size());
		temp.clear();
		return projectsEnCours;
	}

	public Double getProjectsEnCoursMontant() {
		List<Project> temp = buProject.getAllWithItems();
		projectsEnCoursMontant = (double) 0;
		for (Project project : temp) {
			for (Pack pack : project.getPacks()) {
				projectsEnCoursMontant += pack.getAmount() * pack.getNbSale();
			}
		}
		log.info(temp);
		log.info(temp.size());
		temp.clear();
		return projectsEnCoursMontant;
	}

	public Double getProjectsFinancedMontant() {
		List<Project> temp = buProject.getAllFinancedProjects();
		projectsFinancedMontant = (double) 0;
		for (Project project : temp) {
			for (Pack pack : project.getPacks()) {
				projectsEnCoursMontant += pack.getAmount() * pack.getNbSale();
			}
		}
		log.info(temp);
		log.info(temp.size());
		temp.clear();
		return projectsFinancedMontant;
	}

	public void setProjectsEnCoursMontant(Double projectsEnCoursMontant) {
		this.projectsEnCoursMontant = projectsEnCoursMontant;
	}

	public void setProjectsEnCours(int projectsEnCours) {
		this.projectsEnCours = projectsEnCours;
	}

	public void setProjectsFinancedMontant(Double projectsFinancedMontant) {
		this.projectsFinancedMontant = projectsFinancedMontant;
	}

	public void setProjectsFinanced(int projectsFinanced) {
		this.projectsFinanced = projectsFinanced;
	}

	public IBusinessIdentity getBuIdentity() {
		return buIdentity;
	}

	public void setBuIdentity(IBusinessIdentity buIdentity) {
		this.buIdentity = buIdentity;
	}

	// public String getFirstName() {
	// firstName = cnx.getId().getFirstName();
	// return firstName;
	// }

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Identity getIdentity() {
		return identity;
	}

	public void setIdentity(Identity identity) {
		this.identity = identity;
	}

	public String inscription() {

		identity = new Identity();
		identity.setFirstName(firstName);

		/*
		 * SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); Date date
		 * = null;
		 * 
		 * try { date = sdf.parse("birthdate"); } catch (ParseException e) {
		 * e.printStackTrace(); }
		 * 
		 * identity.setBirthdate(date);
		 */

		if (identity != null) {
			setDirection("/Home.xhtml?faces-redirect=true");
		} else {
			setDirection("/UserDashBoard.xhtml?faces-redirect=true");
		}

		identity = buIdentity.save(identity);

		return direction;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

}
