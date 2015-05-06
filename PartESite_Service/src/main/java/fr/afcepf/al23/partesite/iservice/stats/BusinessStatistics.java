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

import fr.afcepf.al23.partesite.idao.offer.IDaoProject;
import fr.afcepf.al23.partesite.idao.transaction.IDaoPayment;
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
	private IDaoPayment daoPayment;
	
	@Override
	public String getProjectsByCategories() {
		ArrayList<Object> listProjects = (ArrayList<Object>) daoProject.getProjectsNumberByCategories();
		String result = "[";
		for(int i = 0; i < listProjects.size();i++){
			Object[] oarray = (Object[]) listProjects.get(i);
			String[] t1 = {(String) oarray[0],(String) (oarray[1]+"")};
			log.info(new JSONObject(t1).toString());
			log.info(((String) oarray[0])+" "+((Long)oarray[1]));
			result+="['"+oarray[0]+"',"+oarray[1]+"]";
			if(i < listProjects.size()-1){
				result+=",";
			}
			
		}
		return result+"]";
	}

	@Override
	public String getSignUpByDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSalesByDate() {
		// TODO Auto-generated method stub
		return null;
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

	public IDaoPayment getDaoPayment() {
		return daoPayment;
	}

	public void setDaoPayment(IDaoPayment daoPayment) {
		this.daoPayment = daoPayment;
	}

}
