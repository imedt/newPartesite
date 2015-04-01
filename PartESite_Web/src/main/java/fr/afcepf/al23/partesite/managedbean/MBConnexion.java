package fr.afcepf.al23.partesite.managedbean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

import fr.afcepf.al23.model.entities.Identity;
import fr.afcepf.al23.partesite.iservice.user.IBusinessIdentity;

@ManagedBean(name = "mbConnexion")
@SessionScoped
public class MBConnexion {

	Logger log = Logger.getLogger(getClass());

	@EJB
	IBusinessIdentity buIdentity;

	@ManagedProperty(value="#{mbUser}")
	private MBUser user;

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

	public MBUser getUser() {
		return user;
	}

	public void setUser(MBUser user) {
		this.user = user;
	}

	public Identity getId() {
		return id;
	}

	public void setId(Identity id) {
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

	public String connexion() {
		id = null;

		try {
			id = buIdentity.connexion(login, password);
			
			if (id.getIdentityRole().getIdIdentityRole() == 3) {
				setDirection("/UserDashBoard.xhtml?faces-redirect=true");
			}
			if (id.getIdentityRole().getIdIdentityRole() == 2) {
				setDirection("/ModeratorDashBoard.xhtml?faces-redirect=true");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return direction;
	}

	public String deconnexion() {

		id = null;
		user.setIdentity(null);

		setDirection("/Home.xhtml?faces-redirect=true");
		return direction;
	}
}
