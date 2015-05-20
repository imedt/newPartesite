package fr.afcepf.al23.partesite.managedbean;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

import com.mongodb.AggregationOutput;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

import fr.afcepf.al23.partesite.iservice.stats.IBusinessStatistics;
import fr.afcepf.al23.partesite.webutil.MBConversion;

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
	private int salesYearSelect;
	private int userDateYearSelect;
	private ArrayList<Integer> listYears;
	
	@PostConstruct
	public void postcons(){ 
		log.info("in post construct");
		listYears = new ArrayList<Integer>(); 
		salesYearSelect = 2015;
		userDateYearSelect = 2015;
		for(int i = 2015; i >= 1975;i--){   
			listYears.add(new Integer(i));   
		}
	}
	public void init(){ 
		listProjectByCategories = buStats.getProjectsByCategories();
		listUserByCountries = buStats.getUsersByCountry();  
		listUserBySigninDate = buStats.getUsersBySignInDate(userDateYearSelect); 
		listSalesByDate = buStats.getSalesByDate(salesYearSelect);
	}
	
	public String getByPulishingDate(){
		MongoClient mongoClient = null;
		try {
			mongoClient = new MongoClient("localhost", 27017);
		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		}
		DB db = mongoClient.getDB("bpc");
		DBCollection coll = db.getCollection("projects");
		
		DBObject byCategory = new BasicDBObject("_id","$publishing_date");
		byCategory.put("nbProjet", new BasicDBObject("$sum",1));
		DBObject group = new BasicDBObject("$group", byCategory);
		
		DBObject format = new BasicDBObject("format","%Y-%m"); //{format:"%Y-%M"}
		format.put("date", "$publishing_date");//{format:"%Y-%M","date":"$publishing_date"}
		DBObject dateToString = new BasicDBObject("$dateToString",format); //{"$dateToString":{format:"%Y-%M","date":"$publishing_date"}}
		
		DBObject projectContent = new BasicDBObject("publishing_date",dateToString); //{"publishing_date" : {"$dateToString":{format:"%Y-%M","date":"$publishing_date"}}}
		DBObject project = new BasicDBObject("$project",projectContent); // {"$project":{"publishing_date" : {"$dateToString":{format:"%Y-%M","date":"$publishing_date"}}}}
		AggregationOutput output = coll.aggregate(project,group);
		Iterator<DBObject> cursor = output.results().iterator();

		String result = "["; 
	//	result = formatToJSON( cursor, result,false);
		return result;
	}
	

	public void getUserBySignUpDate(){
		listUserBySigninDate = buStats.getUsersBySignInDate(userDateYearSelect);
	}  
	public void getSales(){
		listUserBySigninDate = buStats.getSalesByDate(salesYearSelect);
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
	public int getSalesYearSelect() {
		return salesYearSelect;
	}
	public void setSalesYearSelect(int salesYearSelect) {
		this.salesYearSelect = salesYearSelect;
	}
	public ArrayList<Integer> getListYears() {
		return listYears;
	}
	public void setListYears(ArrayList<Integer> listYears) {
		this.listYears = listYears;
	}
	public int getUserDateYearSelect() {
		return userDateYearSelect;
	}
	public void setUserDateYearSelect(int userDateYearSelect) {
		this.userDateYearSelect = userDateYearSelect;
	}
	

}
