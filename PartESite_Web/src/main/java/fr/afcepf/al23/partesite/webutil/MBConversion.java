package fr.afcepf.al23.partesite.webutil;

import java.util.Hashtable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

import fr.afcepf.al23.conversion.service.ConversionImplService;
import fr.afcepf.al23.conversion.service.IConversion;
import fr.afcepf.al23.partesite.managedbean.MBConnexion;


@ManagedBean(name = "mbConversion")
@SessionScoped
public class MBConversion {

	private Logger log = Logger.getLogger(MBConversion.class);
	private static IConversion conversionService;
	
	@ManagedProperty(value = "#{mbConnexion}")
	private MBConnexion MBCnx; 
	private static Hashtable<String, String> tab;
	static{
		tab = new Hashtable<String, String>();
		tab.put("EUR", "€");
		tab.put("HRK", "kn");
		tab.put("CZK", "Kč");
		tab.put("DKK", "kr");
		tab.put("GBP", "£");
		tab.put("HUF", "Ft");
		tab.put("MKD", "ден");
		tab.put("NOK", "kr");
		tab.put("PLN", "zł");
		tab.put("SEK", "kr");
		tab.put("CHF", "CHF");
		tab.put("TRY", "TRY");
		conversionService = new ConversionImplService().getPort(IConversion.class);
} 

	public String getConvertedAmount(double amount){

		log.info("getConvertedAmount , amount =  " + amount + "  currency =  " + MBCnx.getDevise() );
		String currency = "EUR";
		String amountToReturn = "";
		if(MBCnx!=null && MBCnx.getDevise() != null)
			currency = MBCnx.getDevise();

		if(currency == "")
			currency = "EUR";
		//Definition BPEL

		double convertedAmount = conversionService.conversion(amount, "EUR", MBCnx.getDevise());
		
		return formatDecimal(convertedAmount)+" "+ tab.get(currency);
	}

	public String formatDecimal(double number) {
		double epsilon = 0.004d; // 4 tenths of a cent
		if (Math.abs(Math.round(number) - number) < epsilon) {
			return String.format("%10.0f", number); // sdb
		} else {
			return String.format("%10.2f", number); // dj_segfault
		}
	}

	public MBConnexion getMBCnx() {
		return MBCnx;
	}

	public void setMBCnx(MBConnexion mBCnx) {
		MBCnx = mBCnx;
	}

}
