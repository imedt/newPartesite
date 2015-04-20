package fr.afcepf.al23.partesite.managedbean.transaction;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

import fr.afcepf.al23.model.entities.Identity;
import fr.afcepf.al23.model.entities.Item;
import fr.afcepf.al23.model.entities.ItemState;
import fr.afcepf.al23.model.entities.Notification;
import fr.afcepf.al23.model.entities.OrderRow;
import fr.afcepf.al23.model.entities.Pack;
import fr.afcepf.al23.model.entities.UserOrder;
import fr.afcepf.al23.partesite.iservice.notification.IBusinessNotification;
import fr.afcepf.al23.partesite.iservice.offer.IBusinessItem;
import fr.afcepf.al23.partesite.iservice.offer.IBusinessPack;
import fr.afcepf.al23.partesite.iservice.transaction.IBusinessOrder;
import fr.afcepf.al23.partesite.iservice.transaction.IBusinessOrderRow;
import fr.afcepf.al23.partesite.iservice.user.IBusinessIdentity;
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
	@EJB
	IBusinessItem buItem;
	@EJB
	IBusinessNotification buNotification;
	@EJB
	IBusinessIdentity buIdentity;
	@EJB
	IBusinessPack buPack;
	
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
	
	public String addToCart( PackWrap wrappedPack) {
		log.info("wanted quantity = "+wrappedPack.getQuantity());
		cart = buOrder.addOrderRow(MBCnx.getId(), cart, wrappedPack.getQuantity(), wrappedPack.getPack());
		return "consulterPanier.xhtml"; 
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
		log.info("info cart : "+cart);
		buOrder.finalizeCart(cart); 
		
		log.info("creating notification");
		for(OrderRow orderRow : cart.getOrderRows()){
			Notification n = new Notification();
			n.setCreatedBy(1);
			n.setCreatedDate(new Date());
			n.setContentNotification("vous avez vendu "+buItem.getByOrderRowId(orderRow.getIdOrderRow()).size()+" package : "+orderRow.getPack().getPackName());
			n.setIdentity(buIdentity.get(1));
			log.info("createur du package : "+orderRow.getPack().getCreatedBy());
			log.info("ORder parck : "+orderRow.getPack());
			n.setIdTarget(buIdentity.get(buPack.get(orderRow.getPack().getIdPack()).getCreatedBy()).getIdIdentity());
			n.setDisabled(false);
			log.info("save notification");
			
			buNotification.save(n);
			log.info("creating notification 2");
		} 

		Notification n1 = new Notification();
		n1.setCreatedBy(1);
		n1.setCreatedDate(new Date());
		n1.setContentNotification("Votre achat a bien été pris en compte.");
		n1.setIdentity(buIdentity.get(1));
		n1.setIdTarget(MBCnx.getId().getIdIdentity());
		n1.setDisabled(false);
		log.info("save notification 2");
		buNotification.save(n1);	
		this.cart = new UserOrder();
	}
	
	public String removePack(OrderRow or){
		this.cart.getOrderRows().remove(or); 
		return "";
	}
	public static Logger getLog() {
		return log;
	}

	public static void setLog(Logger log) {
		MBOrder.log = log;
	}

	public IBusinessNotification getBuNotification() {
		return buNotification;
	}

	public void setBuNotification(IBusinessNotification buNotification) {
		this.buNotification = buNotification;
	}

	public IBusinessIdentity getBuIdentity() {
		return buIdentity;
	}

	public void setBuIdentity(IBusinessIdentity buIdentity) {
		this.buIdentity = buIdentity;
	}

	public IBusinessItem getBuItem() {
		return buItem;
	}

	public void setBuItem(IBusinessItem buItem) {
		this.buItem = buItem;
	}

	public IBusinessPack getBuPack() {
		return buPack;
	}

	public void setBuPack(IBusinessPack buPack) {
		this.buPack = buPack;
	}

}
