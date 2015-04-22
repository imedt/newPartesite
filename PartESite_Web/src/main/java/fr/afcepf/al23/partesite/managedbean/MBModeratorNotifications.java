package fr.afcepf.al23.partesite.managedbean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.w3c.dom.Text;

import fr.afcepf.al23.model.entities.Notification;
import fr.afcepf.al23.partesite.iservice.notification.IBusinessNotification;

@ManagedBean(name = "mbModeratorNotifications")
@SessionScoped
public class MBModeratorNotifications {

	@EJB
	IBusinessNotification buNotification;

	private List<Notification> listNotifications = new ArrayList<>();
	private String nomMembre, emailMembre, contentMessage, message;

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
		return listNotifications = buNotification.getByTarget(1);
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
	
	public String showMessage(){
		String copy = message;
		message = "";
		return copy;
	}
	public String sendNotification(){
		Notification n = new Notification();
		
		n.setContentNotification(
				"<h2>Envoyé par : "+nomMembre+"<br />Email :"+emailMembre+"<h2/><br />"+
				"<p>"+contentMessage+"</p>"
				);
		n.setCreatedDate(new Date());
		n.setIdTarget(1);
		n.setDisabled(false);
		buNotification.save(n);
		
		message = "<h2>Votre message a bien été envoyé au modérateur.</h2>";
		nomMembre = null;
		emailMembre = null;
		contentMessage = null;
		getListNotifications();
		return "";
	}
}
