package fr.afcepf.al23.bpc.mongo.stats;

import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.Set;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import com.mongodb.AggregationOutput;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

import fr.afcepf.al23.partesite.mongo.stats.IDaoStats;
@Remote(IDaoStats.class)
@Stateless
public class MongoDaoStat implements IDaoStats {
	private static Logger log = Logger.getLogger(MongoDaoStat.class);
	private static DB db;
	static{
		MongoClient mongoClient = null;
		try {
			mongoClient = new MongoClient("localhost", 27017);
		} catch (UnknownHostException e) {
			e.printStackTrace(); 
		}
		db = mongoClient.getDB("bpc");
	}
	
	@Override
	public String getSalesByDate(int salesYearSelect) {
		DBCollection coll = db.getCollection("ventes");
		DBObject project = (DBObject) JSON.parse("{$project:{year:{$year:'$sale_date'},month:{$month:'$sale_date'},amount:'$amount'}}");
		DBObject sort = (DBObject) JSON.parse("{$sort:{'_id.month':1}}");
		DBObject group = (DBObject) JSON.parse("{$group:{'_id':{year:'$year',month:'$month'},'ventes':{'$sum':'$amount'}}}");
		DBObject findYear = (DBObject) JSON.parse("{'$match':{'year':"+salesYearSelect+"}}");  
		DBObject reproject = (DBObject) JSON.parse("{'$project':{'_id':0,'sale_date':{$concat:[{'$substr':['$_id.year',0,4]},'-',{'$substr':['$_id.month',0,2]}]},'zventes':'$ventes'}}");
		log.info(reproject.toString());   
		AggregationOutput output = coll.aggregate(project,findYear,group,sort,reproject);  
		log.info("updated");  
		Iterator<DBObject> cursor = output.results().iterator();
		String result = "[['Année', 'Ventes'],"; 
		return formatToJSON(cursor,result); 
	}

	@Override
	public String getUsersByCountries() {
		DBCollection coll = db.getCollection("user"); 
		DBObject groupUser = (DBObject) JSON.parse("{$group:{'_id':'$country','nbUser':{$sum:1}}}");
		AggregationOutput output = coll.aggregate(groupUser);  
		Iterator<DBObject> cursor = output.results().iterator();
		String result = "[['Pays','Membres'],";
		return formatToJSON(cursor,result);

	} 

	@Override
	public String getProjectsByCategories() {
		DBCollection coll = db.getCollection("projects");
		DBObject values = new BasicDBObject("_id","$id_project_category");
		values.put("nbProjet", new BasicDBObject("$sum",1));
		DBObject group = new BasicDBObject("$group",values);
		AggregationOutput output = coll.aggregate(group);
		Iterator<DBObject> cursor = output.results().iterator();
		String result = "[";
		return formatToJSON(cursor,result); 
	}


	@Override
	public String getUsersBySignInDate(int signInDate) {
		DBCollection coll = db.getCollection("user");
		 
		DBObject project = (DBObject) JSON.parse("{$project:{year:{$year:'$inscription_date'},month:{$month:'$inscription_date'}}}");
		DBObject findYear = (DBObject) JSON.parse("{'$match':{'year':"+signInDate+"}}");  
		DBObject group = (DBObject) JSON.parse("{$group:{'_id':{year:'$year',month:'$month'},'nbInscription':{'$sum':1}}}");
		DBObject sort = (DBObject) JSON.parse("{$sort:{'_id.month':1}}");
		DBObject reproject = (DBObject) JSON.parse("{'$project':{'_id':0,'inscriptiondate':{$concat:[{'$substr':['$_id.year',0,4]},'-',{'$substr':['$_id.month',0,2]}]},'nbinscription':'$nbInscription'}}");
		log.info(reproject.toString());    
		AggregationOutput output = coll.aggregate(project,findYear,group,sort,reproject);   
		log.info("updated");    
		Iterator<DBObject> cursor = output.results().iterator(); 
		String result = "[['Date','Nombre inscription'],";
		return formatToJSON(cursor,result); 
	}
	private String formatToJSON(Iterator<DBObject> list,String result){
		while(list.hasNext()){
			DBObject oarray = list.next();
			Set key = oarray.keySet();
			result+="[";
			Iterator<Object> keyIterator = key.iterator();
			while(keyIterator.hasNext()){
				Object k = keyIterator.next();
				if(oarray.get((String)k) instanceof Integer || oarray.get((String)k) instanceof Float || oarray.get((String)k) instanceof Double){
					result+=(oarray.get((String) k))+"";  
  
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


}
