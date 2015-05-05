package fr.afcepf.al23.partesite.webutil;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

import fr.afcepf.al23.partesite.managedbean.MBConnexion;

@ManagedBean(name = "mbDevise")
@SessionScoped
public class MBDevise {
	private static Logger log = Logger.getLogger(MBDevise.class);
	@ManagedProperty(value = "#{mbConnexion}")
	private MBConnexion MBCnx;
	private List<String> list;

	public List getListDevise() {
		log.info("devise : "+MBCnx.getDevise());
		list = new ArrayList<String>();
		list.add("EUR");
		list.add("HRK");
		list.add("CZK");
		list.add("DKK");
		list.add("GBP");
		list.add("HUF");
		list.add("MKD");
		list.add("NOK");
		list.add("PLN");
		list.add("SEK");
		list.add("CHF");
		list.add("TRY");
		return list; 
	}

	public MBConnexion getMBCnx() {
		return MBCnx;
	}

	public void setMBCnx(MBConnexion mBCnx) {
		MBCnx = mBCnx;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}
	
}
