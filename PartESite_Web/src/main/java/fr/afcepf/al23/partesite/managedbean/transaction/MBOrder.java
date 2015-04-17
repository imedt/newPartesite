package fr.afcepf.al23.partesite.managedbean.transaction;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

import fr.afcepf.al23.model.entities.Item;
import fr.afcepf.al23.model.entities.ItemState;
import fr.afcepf.al23.model.entities.OrderRow;
import fr.afcepf.al23.model.entities.Pack;
import fr.afcepf.al23.model.entities.UserOrder;
import fr.afcepf.al23.partesite.iservice.transaction.IBusinessOrder;
import fr.afcepf.al23.partesite.iservice.transaction.IBusinessOrderRow;
import fr.afcepf.al23.partesite.managedbean.MBConnexion;
import fr.afcepf.al23.partesite.webutil.PackWrap;

@ManagedBean(name = "mbOrder")
@SessionScoped
public class MBOrder {

	private static Logger log = Logger.getLogger(MBOrder.class);
	
	@EJB
	IBusinessOrder buOrder;
	@EJB
	IBusinessOrderRow buOrderRow;

	@ManagedProperty(value = "#{mbConnexion}")
	private MBConnexion MBCnx;
	


	private UserOrder backing;
	List<UserOrder> orders;
	double totalAmount;
	private UserOrder cart;

	public UserOrder getCart() {
		return cart;
	}

	public void setCart(UserOrder cart) {
		this.cart = cart;
	}

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

	public String updateBacking(UserOrder uO) {
		backing = new UserOrder();
		setBacking(uO);
		return "";
	}

	public int getNbByPack(Pack pack){
		int nb = 0;
		for (OrderRow ordR : cart.getOrderRows()) {
			if(ordR.getPack() == pack && ordR.getItems() != null)
				nb= ordR.getItems().size();
		}
		return nb;
	}
	
	public UserOrder addToCart( PackWrap wrappedPack) {
		log.info("wanted quantity = "+wrappedPack.getQuantity());
		cart = buOrder.addOrderRow(MBCnx.getId(), cart, wrappedPack.getQuantity(), wrappedPack.getPack());
		return cart;
	}

	public UserOrder modifyToCart(Integer nb, Pack pack) {
		cart = buOrder.modifyOrderRow(cart, nb, pack);
		return cart;
	}

	public UserOrder releaseCart() {
		buOrder.ReleaseOrder(cart);
		return cart;
	}

	public void validateCart() {		
		buOrder.finalizeCart(cart);
		this.cart = new UserOrder();
	}

}
