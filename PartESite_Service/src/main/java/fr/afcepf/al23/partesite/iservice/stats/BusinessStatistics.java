package fr.afcepf.al23.partesite.iservice.stats;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONString;

import fr.afcepf.al23.partesite.idao.offer.IDaoProject;
import fr.afcepf.al23.partesite.idao.transaction.IDaoPayment;
import fr.afcepf.al23.partesite.idao.transaction.IDaoUserOrder;
import fr.afcepf.al23.partesite.idao.user.IDaoIdentity;

@Remote(IBusinessStatistics.class)
@Stateless
public class BusinessStatistics implements IBusinessStatistics{
	private static Logger log = Logger.getLogger(BusinessStatistics.class);
	@EJB
	private IDaoProject daoProject;
	@EJB
	private IDaoIdentity daoIdentity;
	@EJB
	private IDaoUserOrder daoUserOrder;
	 
	@Override
	public String getProjectsByCategories() {
		ArrayList<Object> listProjects = (ArrayList<Object>) daoProject.getProjectsNumberByCategories();
		String result = "[";
		return formatToJSON(listProjects,result); 
	}

	@Override
	public String getUsersByCountry() {
		ArrayList<Object> list = (ArrayList<Object>) daoIdentity.getUsersByCountries();
		String result = "[['Pays','Membres'],";
		return formatToJSON(list,result);
	}
	
	@Override
	public String getSignUpByDate() {
		ArrayList<Object> list = (ArrayList<Object>) daoIdentity.getUsersBySigninDate();
		String result = "[['Date','Nombre inscription'],";
		return formatToJSON(list,result); 
	}

	@Override
	public String getSalesByDate() {
		ArrayList<Object> list = (ArrayList<Object>) daoUserOrder.getSalesByDate();
		String result = "[['Année', 'Ventes'],"; 
		return formatToJSON(list,result); 
	}
	private String formatToJSON(ArrayList<Object> list,String result){

		for(int i = 0; i < list.size();i++){
			Object[] oarray = (Object[]) list.get(i);
			String[] t1 = {oarray[0]+"",(oarray[1]+"")};
			result+="['"+oarray[0]+"',"+oarray[1]+"]";
			if(i < list.size()-1){ 
				result+=",";
			}
			
		} 
		return result+"]";
	}
	public IDaoProject getDaoProject() {
		return daoProject;
	}

	public void setDaoProject(IDaoProject daoProject) {
		this.daoProject = daoProject;
	}

	public IDaoIdentity getDaoIdentity() {
		return daoIdentity;
	}

	public void setDaoIdentity(IDaoIdentity daoIdentity) {
		this.daoIdentity = daoIdentity;
	}

	public IDaoUserOrder getDaoUserOrder() {
		return daoUserOrder;
	}

	public void setDaoUserOrder(IDaoUserOrder daoUserOrder) {
		this.daoUserOrder = daoUserOrder;
	}


}
