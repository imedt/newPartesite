package fr.afcepf.al23.partesite.managedbean;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.afcepf.al23.model.entities.Notification;
import fr.afcepf.al23.partesite.iservice.notification.IBusinessNotification;

@ManagedBean(name = "mbModeratorNotifications")
@SessionScoped
public class MBModeratorNotifications {

	
	@EJB
	IBusinessNotification buNotification;
	

	private List<Notification> listNotifications = new ArrayList<>();


	public List<Notification> getListNotifications() {
		return listNotifications= buNotification.getByTarget(1);
	}


	public void setListNotifications(List<Notification> listNotifications) {
		this.listNotifications = listNotifications;
	}
	
	public void disable(Notification n){
		n.setDisabled(true);
		buNotification.save(n);
	}
}
