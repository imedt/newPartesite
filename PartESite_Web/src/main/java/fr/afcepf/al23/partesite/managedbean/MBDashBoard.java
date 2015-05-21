package fr.afcepf.al23.partesite.managedbean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import fr.afcepf.al23.model.entities.Notification;
import fr.afcepf.al23.model.entities.OrderRow;
import fr.afcepf.al23.model.entities.Pack;
import fr.afcepf.al23.model.entities.Project;
import fr.afcepf.al23.model.entities.UserOrder;
import fr.afcepf.al23.partesite.iservice.notification.IBusinessNotification;
import fr.afcepf.al23.partesite.iservice.offer.IBusinessPack;
import fr.afcepf.al23.partesite.iservice.offer.IBusinessProject;
import fr.afcepf.al23.partesite.iservice.transaction.IBusinessOrder;
import fr.afcepf.al23.partesite.iservice.user.IBusinessIdentity;

@ManagedBean(name = "mbDashboard")
@SessionScoped
public class MBDashBoard {
	private Logger log = Logger.getLogger(MBDashBoard.class);
	@EJB
	private IBusinessIdentity buIdentity;
	@EJB
	private IBusinessNotification buNotification;
	@EJB
	private IBusinessOrder buUserOrder;
	@EJB
	private IBusinessProject buProjects;
	@EJB
	private IBusinessPack buPacks;

	@ManagedProperty(value = "#{mbConnexion}")
	private MBConnexion cnx;


	private Integer allMyProjectsCount;
	private Integer allMyProjectsDisabledCount;
	private Integer allMyProjectsOnlineCount;
	private Integer allMyProjectsFinancedCount;
	private Integer allMyBackingsWithRewardCount;
	private Integer allMyGivingsCount;
	private Integer allMyNotificationsCount;
	private List<Project> projects = new ArrayList<>();
	private List<Project> listOnline = new ArrayList<>();
	private List<Project> listFinanced = new ArrayList<>();
	private List<Project> listDisabled = new ArrayList<>();
	private List<UserOrder> listBackingsWithReward = new ArrayList<>();
	private List<UserOrder> listGivings = new ArrayList<>();
	private List<Notification> listNotifications = new ArrayList<>();
	private Double backingsAmount;
	// on initialise les montants � comparer pour chaque projet
	private Double aimingAmount = 0.00;
	private Double backings = 0.00;

	public void preRender(){
		if(cnx.getId() == null){
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("Home.xhtml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.projects = buProjects.getByIdentity(cnx.getId());
		allMyProjectsCount = projects.size(); 
		allMyProjectsOnlineCount = 0;
		allMyProjectsFinancedCount = 0;
		for(Project p : projects){
			if(p.getPublish()){
				listOnline.add(p);   
				allMyProjectsOnlineCount++;
			}
			Double aiming = p.getAimingAmount();
			Double current = 0d;
			for(Pack pack : p.getPacks()){ 
				current += (pack.getAmount()*(pack.getTotalQuantity()-pack.getStock()));
			}
			if(aiming < current){
				listFinanced.add(p);
				allMyProjectsFinancedCount++; 
			}
		}
		listNotifications = buNotification.getByTarget(cnx.getId().getIdIdentity());
		allMyNotificationsCount = listNotifications.size();  
	} 
	public void reloadNotifications(){
		listNotifications = buNotification.getByTarget(cnx.getId().getIdIdentity());
		allMyNotificationsCount = listNotifications.size();  
	
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

	public IBusinessNotification getBuNotification() {
		return buNotification;
	}

	public void setBuNotification(IBusinessNotification buNotification) {
		this.buNotification = buNotification;
	}

	public IBusinessOrder getBuUserOrder() {
		return buUserOrder;
	}

	public void setBuUserOrder(IBusinessOrder buUserOrder) {
		this.buUserOrder = buUserOrder;
	}

	public IBusinessProject getBuProjects() {
		return buProjects;
	}

	public void setBuProjects(IBusinessProject buProjects) {
		this.buProjects = buProjects;
	}

	public IBusinessPack getBuPacks() {
		return buPacks;
	}

	public void setBuPacks(IBusinessPack buPacks) {
		this.buPacks = buPacks;
	}

	public MBConnexion getCnx() {
		return cnx;
	}

	public void setCnx(MBConnexion cnx) {
		this.cnx = cnx;
	}

	public Integer getAllMyProjectsCount() {
		return allMyProjectsCount;
	}

	public void setAllMyProjectsCount(Integer allMyProjectsCount) {
		this.allMyProjectsCount = allMyProjectsCount;
	}

	public Integer getAllMyProjectsDisabledCount() {
		return allMyProjectsDisabledCount;
	}

	public void setAllMyProjectsDisabledCount(Integer allMyProjectsDisabledCount) {
		this.allMyProjectsDisabledCount = allMyProjectsDisabledCount;
	}

	public Integer getAllMyProjectsOnlineCount() {
		return allMyProjectsOnlineCount;
	}

	public void setAllMyProjectsOnlineCount(Integer allMyProjectsOnlineCount) {
		this.allMyProjectsOnlineCount = allMyProjectsOnlineCount;
	}

	public Integer getAllMyProjectsFinancedCount() {
		return allMyProjectsFinancedCount;
	}

	public void setAllMyProjectsFinancedCount(Integer allMyProjectsFinancedCount) {
		this.allMyProjectsFinancedCount = allMyProjectsFinancedCount;
	}

	public Integer getAllMyBackingsWithRewardCount() {
		return allMyBackingsWithRewardCount;
	}

	public void setAllMyBackingsWithRewardCount(Integer allMyBackingsWithRewardCount) {
		this.allMyBackingsWithRewardCount = allMyBackingsWithRewardCount;
	}

	public Integer getAllMyGivingsCount() {
		return allMyGivingsCount;
	}

	public void setAllMyGivingsCount(Integer allMyGivingsCount) {
		this.allMyGivingsCount = allMyGivingsCount;
	}

	public Integer getAllMyNotificationsCount() {
		return allMyNotificationsCount;
	}

	public void setAllMyNotificationsCount(Integer allMyNotificationsCount) {
		this.allMyNotificationsCount = allMyNotificationsCount;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public List<Project> getListOnline() {
		return listOnline;
	}

	public void setListOnline(List<Project> listOnline) {
		this.listOnline = listOnline;
	}

	public List<Project> getListFinanced() {
		return listFinanced;
	}

	public void setListFinanced(List<Project> listFinanced) {
		this.listFinanced = listFinanced;
	}

	public List<Project> getListDisabled() {
		return listDisabled;
	}

	public void setListDisabled(List<Project> listDisabled) {
		this.listDisabled = listDisabled;
	}

	public List<UserOrder> getListBackingsWithReward() {
		return listBackingsWithReward;
	}

	public void setListBackingsWithReward(List<UserOrder> listBackingsWithReward) {
		this.listBackingsWithReward = listBackingsWithReward;
	}

	public List<UserOrder> getListGivings() {
		return listGivings;
	}

	public void setListGivings(List<UserOrder> listGivings) {
		this.listGivings = listGivings;
	}

	public List<Notification> getListNotifications() {
		return listNotifications;
	}

	public void setListNotifications(List<Notification> listNotifications) {
		this.listNotifications = listNotifications;
	}

	public Double getBackingsAmount() {
		return backingsAmount;
	}

	public void setBackingsAmount(Double backingsAmount) {
		this.backingsAmount = backingsAmount;
	}

	public Double getAimingAmount() {
		return aimingAmount;
	}

	public void setAimingAmount(Double aimingAmount) {
		this.aimingAmount = aimingAmount;
	}

	public Double getBackings() {
		return backings;
	}

	public void setBackings(Double backings) {
		this.backings = backings;
	}
	
}
