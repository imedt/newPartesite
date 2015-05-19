package fr.afcepf.al23.dao;


import javax.ejb.Stateless;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;


@Stateless
public class AbstractDao {

	//Attribut
	private DBCollection dbCollection;

	//Constructeur
	public AbstractDao(){
	}

	//Get & Set
	public DBCollection getDbCollection() {
		return dbCollection;
	}

	public void setDbCollection(DBCollection dbCollection) {
		this.dbCollection = dbCollection;
	}	

	//Méthodes

	public void insert(BasicDBObject dbObject){
		dbCollection.insert(dbObject);
	}

	public void remove(BasicDBObject dbObject){
		dbCollection.remove(dbObject);
	}

	public void update(BasicDBObject old, BasicDBObject dbObject){
		dbCollection.update(old, dbObject);
	}

	public DBObject getById(Integer id){
		DBObject returnObject=null;
		BasicDBObject query = new BasicDBObject();
		query.put("id", new Integer(id));
		DBCursor find = dbCollection.find(query);
		while(find.hasNext()){
			returnObject=find.next();
		}
		return returnObject;
	}

}
