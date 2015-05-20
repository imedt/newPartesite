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
		listProjectByCategories = getByCategories();
		listUserByCountries = getUserByCountries(); 
		listUserBySigninDate = getUserBySignUpDate(); 
		getSales();      
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
		result = formatToJSON( cursor, result,false);
		return result;
	}
	
	public String getByCategories(){
		MongoClient mongoClient = null;
		try {
			mongoClient = new MongoClient("localhost", 27017);
		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		}
		DB db = mongoClient.getDB("bpc");
		DBCollection coll = db.getCollection("projects");
		//Construction string json
		
		DBObject values = new BasicDBObject("_id","$id_project_category");
		values.put("nbProjet", new BasicDBObject("$sum",1));
		DBObject group = new BasicDBObject("$group",values);
		AggregationOutput output = coll.aggregate(group);
		Iterator<DBObject> cursor = output.results().iterator();

		String result = "["; 
		result = formatToJSON( cursor, result,false);
		return result;
	}
	private String formatToJSON(Iterator<DBObject> list,String result,boolean reverse){
		
		while(list.hasNext()){
			DBObject oarray = list.next();
			Set key = oarray.keySet();
			result+="[";
			Iterator<Object> keyIterator = key.iterator();
			while(keyIterator.hasNext()){
				Object k = keyIterator.next();
				if(oarray.get((String)k) instanceof Integer || oarray.get((String)k) instanceof Float || oarray.get((String)k) instanceof Double){
					result+=oarray.get((String) k)+"";  
  
				}else{
					result+="'"+oarray.get((String) k)+"'";	
				}
				if(keyIterator.hasNext()){ 
					result+=",";
				} 
			}
			result+="]";
			if(list.hasNext()){
				result+=",";
			}
			//			result+="['"+oarray[0]+"',"+oarray[1]+"]";
		} 
		return result+"]";
	}
	
	public String getSales(){
		MongoClient mongoClient = null;
		try {
			mongoClient = new MongoClient("localhost", 27017);
		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		}
		DB db = mongoClient.getDB("bpc");
		DBCollection coll = db.getCollection("ventes");
		 
		DBObject project = (DBObject) JSON.parse("{$project:{year:{$year:'$sale_date'},month:{$month:'$sale_date'},amount:'$amount'}}");
		DBObject sort = (DBObject) JSON.parse("{$sort:{'_id.month':1}}");
		DBObject group = (DBObject) JSON.parse("{$group:{'_id':{year:'$year',month:'$month'},'ventes':{'$sum':'$amount'}}}");
		DBObject findYear = (DBObject) JSON.parse("{'$match':{'year':"+salesYearSelect+"}}");  
		DBObject reproject = (DBObject) JSON.parse("{'$project':{'_id':0,'sale_date':{$concat:[{'$substr':['$_id.year',0,4]},'-',{'$substr':['$_id.month',0,2]}]},'zventes':'$ventes'}}");
		log.info(reproject.toString());  
		AggregationOutput output = coll.aggregate(project,findYear,group,sort,reproject);  
		log.info("updated");  
		System.out.println(project.toString()); 
		Iterator<DBObject> cursor = output.results().iterator();
 
		String result = "[['Année', 'Ventes'],";  
		result = formatToJSON( cursor, result,true); 
		this.listSalesByDate = result; 
		return result;
	}
	
	public String getUserBySignUpDate(){
		MongoClient mongoClient = null;
		try {
			mongoClient = new MongoClient("localhost", 27017);
		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		}
		DB db = mongoClient.getDB("bpc");
		DBCollection coll = db.getCollection("user");
		 
		DBObject project = (DBObject) JSON.parse("{$project:{year:{$year:'$inscription_date'},month:{$month:'$inscription_date'}}}");
		DBObject findYear = (DBObject) JSON.parse("{'$match':{'year':"+userDateYearSelect+"}}");  
		DBObject group = (DBObject) JSON.parse("{$group:{'_id':{year:'$year',month:'$month'},'nbInscription':{'$sum':1}}}");
		DBObject sort = (DBObject) JSON.parse("{$sort:{'_id.month':1}}");
		DBObject reproject = (DBObject) JSON.parse("{'$project':{'_id':0,'inscriptiondate':{$concat:[{'$substr':['$_id.year',0,4]},'-',{'$substr':['$_id.month',0,2]}]},'nbinscription':'$nbInscription'}}");
		log.info(reproject.toString());    
		AggregationOutput output = coll.aggregate(project,findYear,group,sort,reproject);   
		log.info("updated");    
		System.out.println(project.toString()); 
		Iterator<DBObject> cursor = output.results().iterator(); 
  
		String result = "[['Année', 'nombre inscription'],";  
		result = formatToJSON( cursor, result,true); 
		this.listUserBySigninDate = result;
		return result;
	}
	public String getUserByCountries(){
		MongoClient mongoClient = null;
		try {
			mongoClient = new MongoClient("localhost", 27017);
		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		}
		DB db = mongoClient.getDB("bpc");
		DBCollection coll = db.getCollection("user");
		 
		DBObject groupUser = (DBObject) JSON.parse("{$group:{'_id':'$country','nbUser':{$sum:1}}}");
		AggregationOutput output = coll.aggregate(groupUser);  
		System.out.println(groupUser.toString()); 
		Iterator<DBObject> cursor = output.results().iterator();
  
		String result = "[['Pays','Nombre inscription'],";  
		result = formatToJSON( cursor, result,true); 
		this.listUserByCountries = result;
		return result; 
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
