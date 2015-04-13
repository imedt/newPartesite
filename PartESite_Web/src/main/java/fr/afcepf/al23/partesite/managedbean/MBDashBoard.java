package fr.afcepf.al23.partesite.managedbean;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
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
	// on initialise les montants à comparer pour chaque projet
	private Double aimingAmount = 0.00;
	private Double backings = 0.00;


	public Integer getAllMyProjectsCount() {
		return allMyProjectsCount = this.allMyProjects();
	}

	public Integer getAllMyProjectsDisabledCount() {
		return allMyProjectsDisabledCount = this.allMyProjectsDisabled();
	}

	public Integer getAllMyProjectsOnlineCount() {
		return allMyProjectsOnlineCount = this.allMyProjectsOnline();
	}

	public Integer getAllMyProjectsFinancedCount() {
		return allMyProjectsFinancedCount = this.allMyProjectsFinanced();
	}

	public Integer getAllMyBackingsWithRewardCount() {
		return allMyBackingsWithRewardCount = this.allMyBackingsWithReward();
	}

	public Integer getAllMyNotificationsCount() {
		return allMyNotificationsCount = this.allMyNotifications();
	}

	public IBusinessProject getBuProjects() {
		return buProjects;
	}

	public IBusinessIdentity getBuIdentity() {
		return buIdentity;
	}

	public MBConnexion getCnx() {
		return cnx;
	}

	public void setAllMyProjectsCount(Integer allMyProjectsCount) {
		this.allMyProjectsCount = allMyProjectsCount;
	}

	public void setAllMyProjectsDisabledCount(Integer allMyProjectsDisabledCount) {
		this.allMyProjectsDisabledCount = allMyProjectsDisabledCount;
	}

	public void setAllMyProjectsOnlineCount(Integer allMyProjectsOnlineCount) {
		this.allMyProjectsOnlineCount = allMyProjectsOnlineCount;
	}

	public void setAllMyProjectsFinancedCount(Integer allMyProjectsFinancedCount) {
		this.allMyProjectsFinancedCount = allMyProjectsFinancedCount;
	}

	public void setAllMyBackingsWithRewardCount(
			Integer allMyBackingsWithRewardCount) {
		this.allMyBackingsWithRewardCount = allMyBackingsWithRewardCount;
	}

	public void setAllMyNotificationsCount(Integer allMyNotificationsCount) {
		this.allMyNotificationsCount = allMyNotificationsCount;
	}

	public void setBuProjects(IBusinessProject buProjects) {
		this.buProjects = buProjects;
	}

	public void setBuIdentity(IBusinessIdentity buIdentity) {
		this.buIdentity = buIdentity;
	}

	public void setCnx(MBConnexion cnx) {
		this.cnx = cnx;
	}

	public Integer getAllMyGivingsCount() {
		return allMyGivingsCount = this.allMyGivings();
	}

	public void setAllMyGivingsCount(Integer allMyGivingsCount) {
		this.allMyGivingsCount = allMyGivingsCount;
	}

	public IBusinessPack getBuPacks() {
		return buPacks;
	}

	public void setBuPacks(IBusinessPack buPacks) {
		this.buPacks = buPacks;
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

	public IBusinessOrder getBuUserOrder() {
		return buUserOrder;
	}

	public void setBuUserOrder(IBusinessOrder buUserOrder) {
		this.buUserOrder = buUserOrder;
	}

	public List<Project> getProjects() {
		return projects = buProjects.getByIdentity(cnx.getId());
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public List<Project> getListOnline() {
		List<Project> list = buProjects.getByIdentity(cnx.getId());
		listOnline = new ArrayList<>();
		for (Project p : list) {
			if (p.getPublish() == true) {
				listOnline.add(p);
			}
		}
		return listOnline;
	}

	public void setListOnline(List<Project> listOnline) {
		this.listOnline = listOnline;
	}

	public List<Project> getListFinanced() {
		List<Project> list;
		try {
			list = buProjects.getByIdentity(cnx.getId());
			listFinanced = new ArrayList<>();

			for (Project p : list) {

				// on recupere le montant a financer
				aimingAmount = p.getAimingAmount();

				List<Pack> packs = buPacks.getByidProject(p.getIdProject());
				System.out.println("id projet : " + p.getIdProject());

				for (Pack pack : packs) {
					backings += (double) (pack.getAmount() * pack.getNbSale());
				}
				if (backings >= aimingAmount) {
					listFinanced.add(p);
				}
				aimingAmount = 0.00;
				backings = 0.00;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listFinanced;
	}

	public void setListFinanced(List<Project> listFinanced) {
		this.listFinanced = listFinanced;
	}

	public List<Project> getListDisabled() {
		List<Project> list = buProjects.getByIdentity(cnx.getId());
		listDisabled = new ArrayList<>();
		for (Project p : list) {
			if (p.getDisabled() == true) {
				listDisabled.add(p);
			}
		}
		return listDisabled;
	}

	public void setListDisabled(List<Project> listDisabled) {
		this.listDisabled = listDisabled;
	}

	public List<UserOrder> getListBackingsWithReward() {
		List<UserOrder> list = buUserOrder.getByIdentity(cnx.getId());
		listBackingsWithReward = new ArrayList<>();
		for (UserOrder uo : list) {
			for (OrderRow or : uo.getOrderRows()) {
				if (or.getPack().getReward() == true) {
					listBackingsWithReward.add(uo);
				}
			}
		}
		return listBackingsWithReward;
	}

	public void setListBackingsWithReward(List<UserOrder> listBackingsWithReward) {
		this.listBackingsWithReward = listBackingsWithReward;
	}

	public List<UserOrder> getListGivings() {
		List<UserOrder> list = buUserOrder.getByIdentity(cnx.getId());
		listGivings = new ArrayList<>();
		for (UserOrder uo : list) {
			for (OrderRow or : uo.getOrderRows()) {
				if (or.getPack().getReward() == false) {
					listGivings.add(uo);
				}
			}
		}
		return listGivings;
	}

	public void setListGivings(List<UserOrder> listGivings) {
		this.listGivings = listGivings;
	}

	public List<Notification> getListNotifications() {
		return listNotifications = buNotification.getByTarget(cnx.getId()
				.getIdIdentity());
	}

	public void setListNotifications(List<Notification> listNotifications) {
		this.listNotifications = listNotifications;
	}

	public IBusinessNotification getBuNotification() {
		return buNotification;
	}

	public void setBuNotification(IBusinessNotification buNotification) {
		this.buNotification = buNotification;
	}

	public Double getBackingsAmount() {
		return backingsAmount;
	}

	public void setBackingsAmount(Double backingsAmount) {
		this.backingsAmount = backingsAmount;
	}

	// Méthodes
	public Integer allMyProjects() {
		projects = buProjects.getByIdentity(cnx.getId());
		if (projects.size() != 0)
			return allMyProjectsCount = projects.size();
		else
			return 0;
	}

	public Integer allMyProjectsOnline() {
		List<Project> list = buProjects.getByIdentity(cnx.getId());
		listOnline = new ArrayList<>();
		for (Project p : list) {
			if (p.getPublish() == true) {
				listOnline.add(p);
			}
		}
		if (listOnline.size() != 0)
			return allMyProjectsOnlineCount = listOnline.size();
		else
			return 0;
	}

	public Integer allMyProjectsDisabled() {
		List<Project> list = buProjects.getByIdentity(cnx.getId());
		listDisabled = new ArrayList<>();
		for (Project p : list) {
			if (p.getDisabled() == true) {
				listDisabled.add(p);
			}
		}
		if (listDisabled.size() != 0)
			return allMyProjectsDisabledCount = listDisabled.size();
		else
			return 0;
	}

	public Integer allMyProjectsFinanced() {
		List<Project> list;
		try {
			list = buProjects.getByIdentity(cnx.getId());
			listFinanced = new ArrayList<>();

			for (Project p : list) {

				// on recupere le montant a financer
				aimingAmount = p.getAimingAmount();

				List<Pack> packs = buPacks.getByidProject(p.getIdProject());
				System.out.println("id projet : " + p.getIdProject());

				for (Pack pack : packs) {
					backings += (double) (pack.getAmount() * pack.getNbSale());
				}
				if (backings >= aimingAmount) {
					listFinanced.add(p);
				}
				aimingAmount = 0.00;
				backings = 0.00;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (listFinanced.size() != 0)
			return allMyProjectsFinancedCount = listFinanced.size();
		else
			return 0;
	}

	public Integer allMyBackingsWithReward() {
		List<UserOrder> list = buUserOrder.getByIdentity(cnx.getId());
		listBackingsWithReward = new ArrayList<>();
		for (UserOrder uo : list) {
			for (OrderRow or : uo.getOrderRows()) {
				if (or.getPack().getReward() == true) {
					listBackingsWithReward.add(uo);
				}
			}
		}
		if (listBackingsWithReward.size() != 0)
			return allMyBackingsWithRewardCount = listBackingsWithReward.size();
		else
			return 0;
	}

	public Integer allMyGivings() {
		List<UserOrder> list = buUserOrder.getByIdentity(cnx.getId());
		listGivings = new ArrayList<>();
		for (UserOrder uo : list) {
			for (OrderRow or : uo.getOrderRows()) {
				if (or.getPack().getReward() == false) {
					listGivings.add(uo);
				}
			}
		}
		if (listGivings.size() != 0)
			return allMyGivingsCount = listGivings.size();
		else
			return 0;
	}

	public Integer allMyNotifications() {
		listNotifications = buNotification.getByTarget(cnx.getId()
				.getIdIdentity());
		if (listNotifications.size() != 0)
			return allMyNotificationsCount = listNotifications.size();
		else
			return 0;
	}
}
