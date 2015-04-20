package fr.afcepf.al23.partesite.webutil;

import java.util.HashMap;
import java.util.Hashtable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import localhost._8080.ode.processes.conversionprocess.ConversionProcess;
import localhost._8080.ode.processes.conversionprocess.ConversionProcessPortType;
import localhost._8080.ode.processes.conversionprocess.ConversionProcessRequest;
import localhost._8080.ode.processes.conversionprocess.ConversionProcessResponse;

import org.apache.log4j.Logger;

import fr.afcepf.al23.partesite.managedbean.MBConnexion;


@ManagedBean(name = "mbConversion")
@SessionScoped
public class MBConversion {

	private Logger log = Logger.getLogger(MBConversion.class);

	@ManagedProperty(value = "#{mbConnexion}")
	private MBConnexion MBCnx;
	private static Hashtable<String, String> tab;
	private static ConversionProcessPortType cpt;
	private static ConversionProcessRequest cpr;
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
		cpt = new ConversionProcess().getPort(ConversionProcessPortType.class);
		cpr = new ConversionProcessRequest();  
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
		cpr.setDeviseCible("EUR");
		cpr.setDeviseSource(MBCnx.getDevise()); 
		cpr.setMontantHT(amount);
		cpr.setCommission(10);
		if(MBCnx.getId() != null){
			cpr.setIdPays(MBCnx.getId().getAddresses().get(0).getCountry());
		}else{
			cpr.setIdPays(1);
		}
		cpr.setIsHT(true);
		ConversionProcessResponse cpresponse  = cpt.process(cpr);
		double convertedAmount = cpresponse.getMontantTTC();
		
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
