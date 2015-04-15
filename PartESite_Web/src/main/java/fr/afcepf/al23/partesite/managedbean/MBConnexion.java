package fr.afcepf.al23.partesite.managedbean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.afcepf.al23.model.entities.Identity;
import fr.afcepf.al23.partesite.iservice.user.IBusinessIdentity;

@ManagedBean(name = "mbConnexion")
@SessionScoped
public class MBConnexion {


	@EJB
	IBusinessIdentity buIdentity;

	String statut;
	String login;
	String password;
	String bienvenue;
	String direction;
	Identity id;

	public MBConnexion() {
		super();
	}

	public IBusinessIdentity getBuIdentity() {
		return buIdentity;
	}

	public void setBuIdentity(IBusinessIdentity buIdentity) {
		this.buIdentity = buIdentity;
	}

	public Identity getId() {

		return id;
	}

	public void setId(Identity id) {

		id = buIdentity.connexion(login, password);	

		this.id = id;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBienvenue() {
		return bienvenue;
	}

	public void setBienvenue(String bienvenue) {
		this.bienvenue = bienvenue;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public String connexion() {
		id = new Identity();
		if ( id!= null){
			id = buIdentity.connexion(login, password);
			if (id.getIdentityRole().getIdIdentityRole() == 3) {
				setDirection("/UserDashBoard.xhtml?faces-redirect=true");
				setStatut("Utilisateur");
			}
			if (id.getIdentityRole().getIdIdentityRole() == 2) {
				setDirection("/ModeratorDashBoard.xhtml?faces-redirect=true");
				setStatut("Moderateur");
			}
		}
		return direction;
	}

	public String deconnexion() {
		try {
			setStatut(null);
			setId(null);
			setDirection("/Home.xhtml?faces-redirect=true");
		} catch (Exception e) {
			e.printStackTrace();
		}
		setDirection("/Home.xhtml?faces-redirect=true");
		return direction;
	}
}
