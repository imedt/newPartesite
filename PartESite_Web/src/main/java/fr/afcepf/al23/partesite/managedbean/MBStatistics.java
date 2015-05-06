package fr.afcepf.al23.partesite.managedbean;

import java.util.HashMap;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

import fr.afcepf.al23.partesite.iservice.stats.IBusinessStatistics;

@ManagedBean(name="mbStatistics")
@SessionScoped
public class MBStatistics {
	private static Logger log = Logger.getLogger(MBStatistics.class);
	@EJB
	private IBusinessStatistics buStats;
	private String listProjectByCategories;
	private String listUserByCountries;
	private String listUserBySigninDate;
	private String listSalesByDate;
	public void init(){ 
		listProjectByCategories = buStats.getProjectsByCategories();
		listUserByCountries = buStats.getUsersByCountry();
		listUserBySigninDate = buStats.getSignUpByDate();
		listSalesByDate = buStats.getSalesByDate();
	}
	public static Logger getLog() { 
		return log;
	}
	public static void setLog(Logger log) {
		MBStatistics.log = log;
	}
	public IBusinessStatistics getBuStats() {
		return buStats;
	}
	public void setBuStats(IBusinessStatistics buStats) {
		this.buStats = buStats;
	}
	public String getListProjectByCategories() {
		return listProjectByCategories;
	}
	public void setListProjectByCategories(String listProjectByCategories) {
		this.listProjectByCategories = listProjectByCategories;
	}
	public String getListUserByCountries() {
		return listUserByCountries;
	}
	public void setListUserByCountries(String listUserByCountries) {
		this.listUserByCountries = listUserByCountries;
	}
	public String getListUserBySigninDate() {
		return listUserBySigninDate;
	}
	public void setListUserBySigninDate(String listUserBySigninDate) {
		this.listUserBySigninDate = listUserBySigninDate;
	}
	public String getListSalesByDate() {
		return listSalesByDate;
	}
	public void setListSalesByDate(String listSalesByDate) {
		this.listSalesByDate = listSalesByDate;
	}

}
