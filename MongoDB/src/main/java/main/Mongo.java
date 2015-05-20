package main;

import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import fr.afcepf.al23.dto.Project;

public class Mongo {

	MongoClient mongoClient = null;
	String[] cats;
	public Mongo() {
		cats = new String[]{"ART","GASTRONOMIE","JEUX","ARTISANAT","MUSIQUE","TECHNOLOGIE"};

		try {
			mongoClient = new MongoClient("localhost", 27017);
		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		}

	}
	public void generateUser(){
		DB db = mongoClient.getDB("bpc");
		DBCollection coll = db.getCollection("user");
		for(int i = 0 ; i < 10000; i++){
			DBObject user = new BasicDBObject("username","user n°"+i);
			user.put("country", randomCountrie());
			user.put("inscription_date", randomPublishingDate());
			coll.insert(user);
	
		}
	}
	public String randomCountrie(){
		String[]pays=new String[]{				"Autriche"			,
				"Belgique"			,
				"Finlande"			,
				"France"			,
				"France"			,
				"France"			,
				"France"			,
				"France"			,
				"France"			,
				"France"			,
				"France"			,
				"France"			,
				"France"			,
				"France"			,
				"France"			,
				"France"			,
				"France"			,
				"France"			,
				"France"			,
				"Allemagne"			,
				"Allemagne"			,
				"Allemagne"			,
				"Grèce"				,
				"Irlande"		,
				"Italie"			,
				"Luxembourg"		,
				"Monténégro"			,
				"Monténégro"			,
				"Monténégro"			,
				"Pays-Bas"			,
				"Portugal"			,
				"Slovaquie"			,
				"Slovénie"			,
				"Espagne"			,
				"Bosnie-Herzégovine"	,
				"Bulgarie"			,
				"Croatie"			,
				"Républiquetchèque"	,
				"Danemark"			,
				"Grande-Bretagne"	,
				"Grande-Bretagne"	,
				"Grande-Bretagne"	,
				"Grande-Bretagne"	,
				"Hongrie"			,
				"ARYMacédoine"		,
				"Norvège"			,
				"Pologne"			,
				"Roumanie"			,
				"Roumanie"			,
				"Roumanie"			,
				"Serbie"				,
				"Suède"				,
				"Suisse"				,
				"Suisse"				,
				"Suisse"				,
				"Suisse"				,
				"Suisse"				,
				"Suisse"				,
				"Suisse"				,
				"Suisse"				,
				"Suisse"				,
				"Suisse"				,
				"Suisse"				,
				"Suisse"				,
				"Suisse"				,
				"Turquie"		
		};
		return pays[(int) Math.round(Math.random()*(pays.length-1))] ;
	}  
	public int randomCategory(){

		return (int) Math.round(Math.random()*(cats.length-1));
	}

	public Date randomPublishingDate(){
		Date d = new Date();
		d.setTime(Math.round(Math.random()*d.getTime()));
		return d;
	}

	public double randomAimingAmount(){
		return (double) Math.round(Math.random()*100000+1);
	}



	public void insertProjects() {

		DB db = mongoClient.getDB("bpc");
		DBCollection coll = db.getCollection("projects");

		for (int i = 0 ; i < 10000; i++){

			DBObject project = new BasicDBObject();
			project.put("project_name", "Projet n° "+i);
			project.put("publishing_date", randomPublishingDate());
			project.put("id_project_category", cats[randomCategory()]);
			project.put("aiming_amount", randomAimingAmount()); 			
			System.out.println(project);

			coll.insert(project);
		}
	}

	public void insertSales(){
		DB db = mongoClient.getDB("bpc");
		DBCollection coll = db.getCollection("ventes");

		for (int i = 0 ; i < 10000; i++){

			DBObject project = new BasicDBObject();
			project.put("sale_date", randomPublishingDate());
			project.put("amount", randomAimingAmount());

			System.out.println(project);

			coll.insert(project);
		}

	}
	public List<Project> getAllPublish() {
		// TODO Auto-generated method stub
		return null;
	}


	public List<Project> getByCategory() {
		// TODO Auto-generated method stub
		return null;
	}


	public List<Project> getByPublishingDate() {
		// TODO Auto-generated method stub
		return null;
	}

}
