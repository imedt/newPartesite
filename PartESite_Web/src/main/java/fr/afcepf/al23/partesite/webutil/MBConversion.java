package fr.afcepf.al23.partesite.webutil;

import java.util.HashMap;
import java.util.Hashtable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

import fr.afcepf.al23.partesite.managedbean.MBConnexion;


@ManagedBean(name = "mbConversion")
@SessionScoped
public class MBConversion {
	
	private Logger log = Logger.getLogger(MBConversion.class);
	
	@ManagedProperty(value = "#{mbConnexion}")
	private MBConnexion MBCnx;
	private Hashtable<String, String> tab = new Hashtable<String, String>();
	
	public String getConvertedAmount(double amount){
		
		
		String amountToReturn = "";
		String currency = MBCnx.getDevise();
		
		amountToReturn = String.valueOf(amount);
		tab.put("EUR", "&euro;");
		tab.put("BAM", "KM");
		tab.put("BGN", "&curren;");
		tab.put("HRK", "kn");
		tab.put("CZK", "Kč");
		tab.put("DKK", "kr");
		tab.put("GBP", "&pound;");
		tab.put("HUF", "Ft");
		tab.put("MKD", "ден");
		tab.put("NOK", "kr");
		tab.put("PLN", "zł");
		tab.put("RON", "lei");
		tab.put("RSD", "Дин.");
		tab.put("SEK", "kr");
		tab.put("CHF", "&curren;");
		tab.put("TRY", "&curren;");
		
		return amountToReturn+" "+ tab.get(currency);
	}

}
