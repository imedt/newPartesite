package fr.afcepf.al23.partesite.iservice.stats;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONString;

import com.mongodb.AggregationOutput;
import com.mongodb.DBObject;

import fr.afcepf.al23.partesite.idao.offer.IDaoProject;
import fr.afcepf.al23.partesite.idao.transaction.IDaoPayment;
import fr.afcepf.al23.partesite.idao.transaction.IDaoUserOrder;
import fr.afcepf.al23.partesite.idao.user.IDaoIdentity;
import fr.afcepf.al23.partesite.mongo.stats.IDaoStats;

@Remote(IBusinessStatistics.class)
@Stateless 
public class BusinessStatistics implements IBusinessStatistics{
	private static Logger log = Logger.getLogger(BusinessStatistics.class);
	@EJB
	private IDaoStats daoStats;
	 
	@Override
	public String getProjectsByCategories() {
		return daoStats.getProjectsByCategories();
	}

	@Override 
	public String getUsersByCountry() {
		return daoStats.getUsersByCountries();
	}

	@Override
	public String getSalesByDate(int year){
		return daoStats.getSalesByDate(year);
	}
 
	@Override
	public String getUsersBySignInDate(int year) {
		return daoStats.getUsersBySignInDate(year);
	}
	
	public IDaoStats getDaoStats() {
		return daoStats;
	}

	public void setDaoStats(IDaoStats daoStats) {
		this.daoStats = daoStats;
	}

	


}
