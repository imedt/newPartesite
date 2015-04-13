package fr.afcepf.al23.partesite.managedbean.transaction;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.afcepf.al23.model.entities.UserOrder;
import fr.afcepf.al23.partesite.iservice.transaction.IBusinessOrder;
import fr.afcepf.al23.partesite.iservice.transaction.IBusinessOrderRow;
import fr.afcepf.al23.partesite.managedbean.MBConnexion;

@ManagedBean(name="mbOrder")
@SessionScoped
public class MBOrder {
	
	@EJB
	IBusinessOrder buOrder;
	@EJB
	IBusinessOrderRow buOrderRow;
	
	@ManagedProperty(value = "#{mbConnexion}")
	private MBConnexion MBCnx;

	private UserOrder backing;
	List<UserOrder> orders;
	double totalAmount;

	public IBusinessOrder getBuOrder() {
		return buOrder;
	}

	public void setBuOrder(IBusinessOrder buOrder) {
		this.buOrder = buOrder;
	}

	public MBConnexion getMBCnx() {
		return MBCnx;
	}

	public void setMBCnx(MBConnexion mBCnx) {
		MBCnx = mBCnx;
	}

	public List<UserOrder> getOrders() {
		return buOrder.getByIdentity(MBCnx.getId());
	}

	public void setOrders(List<UserOrder> orders) {
		this.orders = orders;
	}

	public IBusinessOrderRow getBuOrderRow() {
		return buOrderRow;
	}

	public void setBuOrderRow(IBusinessOrderRow buOrderRow) {
		this.buOrderRow = buOrderRow;
	}

	public UserOrder getBacking() {
		return backing;
	}

	public void setBacking(UserOrder backing) {
		this.backing = backing;
	}

	public double getTotalAmount() {
		double total = 0;
		List<UserOrder> orders = this.getOrders();
		for (UserOrder order : orders) {
			total = total + order.getTotalAmount();
		}
		return total;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String updateBacking(UserOrder uO){
		backing = new UserOrder();
		setBacking(uO);
		return "";
	}
	
}
