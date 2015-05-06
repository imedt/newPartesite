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
import fr.afcepf.al23.partesite.iservice.notification.IBusinessNotification;
import fr.afcepf.al23.partesite.iservice.user.IBusinessIdentity;

@ManagedBean(name = "mbUserNotifications")
@SessionScoped
public class MBUserNotifications {

	@EJB
	IBusinessNotification buNotification;
	@EJB
	IBusinessIdentity buIdentity;
	@ManagedProperty(value = "#{mbConnexion}")
	private MBConnexion cnx;

	private List<Notification> listNotifications = new ArrayList<>();
	private String nomMembre, emailMembre, contentMessage, message, objet;
	private Integer targetId;

	public String getObjet() {
		return objet;
	}

	public void setObjet(String objet) {
		this.objet = objet;
	}

	public String getNomMembre() {
		return nomMembre;
	}

	public void setNomMembre(String nomMembre) {
		this.nomMembre = nomMembre;
	}

	public String getEmailMembre() {
		return emailMembre;
	}

	public void setEmailMembre(String emailMembre) {
		this.emailMembre = emailMembre;
	}

	public String getContentMessage() {
		return contentMessage;
	}

	public void setContentMessage(String contentMessage) {
		this.contentMessage = contentMessage;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	public List<Notification> getListNotifications() {
		return listNotifications = buNotification.getByTarget(cnx.getId()
				.getIdIdentity());
	}

	public void setListNotifications(List<Notification> listNotifications) {
		this.listNotifications = listNotifications;
	}

	public String disabled(Notification n) {
		n.setDisabled(true);
		buNotification.save(n);
		getListNotifications();
		return "";
	}

	public MBConnexion getCnx() {
		return cnx;
	}

	public void setCnx(MBConnexion cnx) {
		this.cnx = cnx;
	}

	public Integer getTargetId() {
		return targetId;
	}

	public void setTargetId(Integer targetId) {
		this.targetId = targetId;
	}

	public String showMessage(){
		String copy = message;
		message = "";
		return copy;
	}
	public String sendNotification(){
		Notification n = new Notification();
		
		Identity user = buIdentity.get(targetId);
		
		n.setContentNotification(
				"<h2>Envoyee par : "+cnx.getId().getFirstName()+"<h2/><br />"+
		"Objet "+getObjet()+
				"<p>"+getContentMessage()+"</p>"
				);
		n.setCreatedDate(new Date());
		n.setIdTarget(getTargetId());
		n.setDisabled(false);
		buNotification.save(n);
		
		message = "Votre message a bien ete envoye a :"+user.getEmail()+".";
		objet = null;
		nomMembre = null;
		emailMembre = null;
		contentMessage = null;
		getListNotifications();
		return "";
	}


}
