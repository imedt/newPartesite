package fr.afcepf.al23.partesite.managedbean.transaction;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.afcepf.al23.partesite.iservice.transaction.IBusinessInvestment;
import fr.afcepf.al23.partesite.iservice.user.IBusinessIdentity;
import fr.afcepf.al23.partesite.managedbean.MBConnexion;

@ManagedBean(name="mbInvestment")
@SessionScoped
public class MBInvestment {
	
	@EJB
	IBusinessInvestment buInvestment;
	
	@ManagedProperty(value = "#{mbConnexion}")
	private MBConnexion MBCnx;

	int nbInvestment;
	int nbGift;
	
	public MBInvestment() {
		super();
	}


	public void setBuInvestment(IBusinessInvestment buInvestment) {
		this.buInvestment = buInvestment;
	}

	public int getNbInvestment() {
		return buInvestment.getNbInvestment(MBCnx.getId());
	}


	public void setNbInvestment(int nbInvestment) {
		this.nbInvestment = nbInvestment;
	}


	public int getNbGift() {
		return buInvestment.getNbGift(MBCnx.getId());
	}


	public void setNbGift(int nbGift) {
		this.nbGift = nbGift;
	}


	public MBConnexion getMBCnx() {
		return MBCnx;
	}

	public void setMBCnx(MBConnexion mBCnx) {
		MBCnx = mBCnx;
	}

}
