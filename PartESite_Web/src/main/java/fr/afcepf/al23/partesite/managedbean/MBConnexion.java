package fr.afcepf.al23.partesite.managedbean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

import fr.afcepf.al23.partesite.iservice.user.IBusinessIdentity;
import fr.afcepf.al23.partesite.model.entities.Identity;

@ManagedBean(name="mbConnexion")
@SessionScoped
public class MBConnexion {

	Logger log = Logger.getLogger(getClass());

	@EJB
	IBusinessIdentity buIdentity;

	String login;
	String password;
	String bienvenue;
	public Logger getLog() {
		return log;
	}

	public void setLog(Logger log) {
		this.log = log;
	}

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

	public String connexion()
	{
		direction="";
		id=null;
		id = buIdentity.connexion(login, password);

		if ( id != null)
		{
			if ( id.getIdentityRole().getIdIdentityRole()==2)
			{
				setDirection("/ModeratorDashBoard.xhtml?faces-redirect=true");
			}
			else 
			{
				setDirection("/UserDashBoard.xhtml?faces-redirect=true");
			}
			setBienvenue(" "+id.getFirstName()+" !");//à récupérer dans la page UserDashBoard
		}
		else
		{
			setDirection("/Home.xhtml?faces-redirect=true");
			setBienvenue("Identification erronée !");
		}

		return direction;
	}

	public String deconnexion()
	{

		id=null;

		setDirection("/Home.xhtml?faces-redirect=true");


		return direction;
	}
}
