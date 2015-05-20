package main;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.mongodb.AggregationOutput;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

import fr.afcepf.al23.dto.Project;

public class MainTest {
	public static void main(String[] args) {
//		new Mongo().insertProjects();
	//	new Mongo().insertSales(); 
		for(int i = 0; i < 100;i++){
			new Mongo().generateUser();
		}
		System.out.println(getSales());
	//	System.out.println(getByPulishingDate());
	//	System.out.println(getByCategories());
	}
	
	private static String getByPulishingDate(){
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
		result = formatToJSON( cursor, result);
		return result;
	}
	
	private static String getSales(){
		MongoClient mongoClient = null;
		try {
			mongoClient = new MongoClient("localhost", 27017);
		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		}
		DB db = mongoClient.getDB("bpc");
		DBCollection coll = db.getCollection("ventes");
		
		DBObject byCategory = new BasicDBObject("_id","$sale_date");
		byCategory.put("nbVentes", new BasicDBObject("$sum","$amount"));
		DBObject group = new BasicDBObject("$group", byCategory);
		
		DBObject format = new BasicDBObject("format","%Y-%m"); //{format:"%Y-%M"}
		format.put("date", "$sale_date");//{format:"%Y-%M","date":"$publishing_date"}
		DBObject dateToString = new BasicDBObject("$dateToString",format); //{"$dateToString":{format:"%Y-%M","date":"$publishing_date"}}
		
		DBObject projectContent = new BasicDBObject("sale_date",dateToString); //{"publishing_date" : {"$dateToString":{format:"%Y-%M","date":"$publishing_date"}}}
		projectContent.put("amount", "$amount");
		DBObject project = new BasicDBObject("$project",projectContent); // {"$project":{"publishing_date" : {"$dateToString":{format:"%Y-%M","date":"$publishing_date"}}}}
		AggregationOutput output = coll.aggregate(project,group);
		System.out.println(project.toString());
		Iterator<DBObject> cursor = output.results().iterator();

		String result = "["; 
		result = formatToJSON( cursor, result);
		return result;
	}
	
	private static String getByCategories(){
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
		result = formatToJSON( cursor, result);
		return result;
	}
	private static String formatToJSON(Iterator<DBObject> list,String result){
		
		while(list.hasNext()){
			DBObject oarray = list.next();
			Set key = oarray.keySet();
			result+="[";
			Iterator<Object> keyIterator = key.iterator();
			while(keyIterator.hasNext()){
				Object k = keyIterator.next();
				result+=oarray.get((String) k);
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
