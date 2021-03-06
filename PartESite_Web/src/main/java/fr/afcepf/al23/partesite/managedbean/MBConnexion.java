package fr.afcepf.al23.partesite.managedbean;

import javax.ejb.EJB;
import javax.el.ELContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import fr.afcepf.al23.model.entities.Identity;
import fr.afcepf.al23.model.entities.UserOrder;
import fr.afcepf.al23.partesite.iservice.user.IBusinessIdentity;
import fr.afcepf.al23.partesite.managedbean.transaction.MBOrder;

@ManagedBean(name = "mbConnexion")
@SessionScoped
public class MBConnexion {
	private Logger log = Logger.getLogger(MBConnexion.class);

	@EJB
	private IBusinessIdentity buIdentity;

	private String statut;
	private String login;
	private String password;
	private String bienvenue;
	private String direction;
	private Identity id;
	private String devise = "EUR";

	public String getDevise() {
		return devise;
	}

	public void setDevise(String devise) {
		this.devise = devise;
	}

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
		log.info("In connexion");
		id = buIdentity.connexion(login, password);
		if ( id!= null){
			log.info("User found");
			if (id.getIdentityRole().getIdIdentityRole() == 3) {
				log.info("Account user");
				setDirection("../pages/UserInfo.xhtml?faces-redirect=true");
				setStatut("Utilisateur");
			}
			if (id.getIdentityRole().getIdIdentityRole() == 2) {
				log.info("Account Moderator");
				setDirection("../pages/ModeratorDashBoard.xhtml?faces-redirect=true");
				setStatut("Moderateur"); 
			}
			ELContext elContext = FacesContext.getCurrentInstance().getELContext();
			MBOrder mbOrder  = (MBOrder) FacesContext.getCurrentInstance().getApplication().getELResolver().getValue(elContext, null, "mbOrder");
			mbOrder.mergeCart();

		}else{
			direction = "Login.xhtml";
		}
		return direction;
	}

	public String deconnexion() {
		log.info("deconnexion");
		id = null;
		try {

			HttpServletRequest request = 
					(HttpServletRequest)FacesContext
					.getCurrentInstance()
					.getExternalContext().getRequest();

			MBOrder mbOrder = (MBOrder)request.getAttribute("mbOrder");
			mbOrder = new MBOrder();
			log.info("fin initialisisation mborder");
		} catch (Exception e) {
			log.info("erreur init");
			e.printStackTrace();
		}
		ELContext elContext = FacesContext.getCurrentInstance().getELContext();
		MBOrder mbOrder  = (MBOrder) FacesContext.getCurrentInstance().getApplication().getELResolver().getValue(elContext, null, "mbOrder");
		mbOrder.setCart(new UserOrder());
		log.info("direction : "+direction); 
		return "Home.xhtml?faces-redirect=true";
	}
 

}
