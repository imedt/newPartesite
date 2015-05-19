package fr.afcepf.al23.dao.mongo;

import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.ejb.Stateless;
import com.mongodb.AggregationOutput;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import fr.afcepf.al23.dao.AbstractDao;
import fr.afcepf.al23.dto.Project;

@Stateless
public class MongoProjectDao extends AbstractDao implements ProjectDao {

	public MongoProjectDao() {
		MongoClient mongoClient = null;
		try {
			mongoClient = new MongoClient("localhost", 27017);
		} catch (UnknownHostException e) {
			System.out.println(e.getMessage());
		}
		DB db = mongoClient.getDB("partesite");
		DBCollection coll = db.getCollection("projects");
		setDbCollection(coll);
	}


	@Override
	public List<Project> getByCategory() {

		List<Project> projects = new ArrayList<>();

		DBObject groupFields = new BasicDBObject("_id", "$id_project_category");
	
		//TO DO : group by category
		
		
		
		AggregationOutput output = getDbCollection().aggregate(groupFields);
		Iterator<DBObject> cursor = output.results().iterator();

		Project project = null;

		while (cursor.hasNext()) {
			project = new Project();
			DBObject obj = cursor.next();
			project.setId_project(Integer.parseInt(obj.get("_id").toString()));
			project.setId_project_category(Integer.parseInt(obj.get("id_project_category").toString()));
			projects.add(project);
		}
		return projects;
	}

	@Override
	public List<Project> getByPublishingDate() {

		List<Project> projects = new ArrayList<>();

		DBObject groupFields = new BasicDBObject("_id", "$publishing_date");
		
		//TO DO : Group by Date (Par mois)
		
		
		AggregationOutput output = getDbCollection().aggregate(groupFields);
		Iterator<DBObject> cursor = output.results().iterator();

		Project project = null;

		while (cursor.hasNext()) {
			project = new Project();
			DBObject obj = cursor.next();
			project.setId_project(Integer.parseInt(obj.get("_id").toString()));

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			String pDate = obj.get("publishing_date").toString();
			Date date;

			try {
				date = sdf.parse(pDate);
				project.setPublishing_date(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}

			projects.add(project);
		}
		return projects;
	}


	@Override
	public List<Project> getAllPublish() {
		// TODO Auto-generated method stub
		return null;
	}

}
