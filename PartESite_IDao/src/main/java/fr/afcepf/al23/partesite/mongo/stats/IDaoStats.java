package fr.afcepf.al23.partesite.mongo.stats;

import java.util.Iterator;

import com.mongodb.AggregationOutput;
import com.mongodb.Cursor;
import com.mongodb.DBObject;

public interface IDaoStats {
	public String getSalesByDate(int salesYearSelect);
	public String getUsersBySignInDate(int signInDate);
	public String getUsersByCountries();
	public String getProjectsByCategories();
} 
