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
	private String resultPays;
	public void init(){ 
		resultPays = buStats.getProjectsByCategories();
		log.info(resultPays);
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
	public String getResultPays() {
		return resultPays;
	}
	public void setResultPays(String resultPays) {
		this.resultPays = resultPays;
	}
}
