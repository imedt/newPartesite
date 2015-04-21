package fr.afcepf.al23.partesite.managedbean;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.afcepf.al23.model.entities.Notification;
import fr.afcepf.al23.partesite.iservice.notification.IBusinessNotification;

@ManagedBean(name = "mbUserNotifications")
@SessionScoped
public class MBUserNotifications {

	
	@EJB
	IBusinessNotification buNotification;
	@ManagedProperty(value="#{mbConnexion}")
	private MBConnexion cnx;

	private List<Notification> listNotifications = new ArrayList<>();


	public List<Notification> getListNotifications() {
		return listNotifications= buNotification.getByTarget(cnx.getId().getIdIdentity());
	}


	public void setListNotifications(List<Notification> listNotifications) {
		this.listNotifications = listNotifications;
	}
	
	public String disabled(Notification n){
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
	
	
}
