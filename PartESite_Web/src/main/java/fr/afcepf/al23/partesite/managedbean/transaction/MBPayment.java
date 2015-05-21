package fr.afcepf.al23.partesite.managedbean.transaction;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import org.apache.log4j.Logger;

import fr.afcepf.al23.model.entities.OrderRow;
import fr.afcepf.al23.model.entities.Payment;
import fr.afcepf.al23.model.entities.UserOrder;
import fr.afcepf.al23.partesite.iservice.transaction.IBusinessOrder;
import fr.afcepf.al23.partesite.iservice.transaction.IBusinessPayment;
import fr.afcepf.al23.partesite.managedbean.MBConnexion;

@ManagedBean(name="mbPayment")
@SessionScoped
public class MBPayment {
	private Logger log = Logger.getLogger(MBPayment.class); 
	@ManagedProperty(value="#{mbOrder}")
	private MBOrder mbOrder;

	@ManagedProperty(value="#{mbConnexion}")
	private MBConnexion mbCnx;
	
	@EJB
	private IBusinessPayment busiPayment;
	@EJB
	private IBusinessOrder busiOrder;
	
	private String m_titulaireCarte;
	private String m_numeroCarte;
	private String m_dateExpiration;
	private String m_cryptogramme;
	
	public String accessPaymentForm(){
		return "paymentForm.xhtml?faces-redirect=true";
	}
	private Double totalPrice;
	
	public String finalizePayment(){ 
		mbOrder.setCart(busiOrder.getCurrentUserCart(mbCnx.getId()));
		if(mbOrder.getCart().getIdUserOrder() == null){
			return "/pages/index.xhtml?faces-redirect=true";
		}
		log.info("creation paiement");
		Payment payment = new Payment();
		payment.setCreatedDate(new Date());
		payment.setCreatedBy(mbCnx.getId().getIdIdentity());
		payment.setDisabled(false);
		payment.setUserOrder(mbOrder.getCart()); 
		log.info("save paiement");
		busiPayment.save(payment);
		log.info("pre validate cart");
		mbOrder.validateCart();  
		mbOrder.setCart(new UserOrder());
		return "/pages/congratulation.xhtml?faces-redirect=true";
	} 
	 
	public double computeTotal(){
		double total = 0;
		try{
			log.info("Cart : "+mbOrder.getCart().getIdUserOrder());
			for(OrderRow or : mbOrder.getCart().getOrderRows()){
				total+=or.getAmount();
			} 
			totalPrice = new Double(total);
			return total;
		}catch(Exception e){
			return totalPrice;
		}
	}
	
	public List<OrderRow> getCurrentCartOrderRows(){
		return mbOrder.getCart().getOrderRows();
	}
	public String validatePayment(){
		return "/pages/paymentResume.xhtml?faces-redirect=true";
	} 
	
	public void sendNotifications(){
		
	}

	public MBOrder getMbOrder() {
		return mbOrder;
	}

	public void setMbOrder(MBOrder mbOrder) {
		this.mbOrder = mbOrder;
	}

	public MBConnexion getMbCnx() {
		return mbCnx;
	}

	public void setMbCnx(MBConnexion mbCnx) {
		this.mbCnx = mbCnx;
	}

	public IBusinessPayment getBusiPayment() {
		return busiPayment;
	}

	public void setBusiPayment(IBusinessPayment busiPayment) {
		this.busiPayment = busiPayment;
	}

	public String getM_titulaireCarte() {
		return m_titulaireCarte;
	}

	public void setM_titulaireCarte(String m_titulaireCarte) {
		this.m_titulaireCarte = m_titulaireCarte;
	}

	public String getM_numeroCarte() {
		return m_numeroCarte;
	}

	public void setM_numeroCarte(String m_numeroCarte) {
		this.m_numeroCarte = m_numeroCarte;
	}

	public String getM_dateExpiration() {
		return m_dateExpiration;
	}

	public void setM_dateExpiration(String m_dateExpiration) {
		this.m_dateExpiration = m_dateExpiration;
	}

	public String getM_cryptogramme() {
		return m_cryptogramme;
	}

	public void setM_cryptogramme(String m_cryptogramme) {
		this.m_cryptogramme = m_cryptogramme;
	}
	
	
}
