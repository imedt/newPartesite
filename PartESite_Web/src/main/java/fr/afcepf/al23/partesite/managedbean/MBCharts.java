package fr.afcepf.al23.partesite.managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

import fr.afcepf.al23.dto.Project;
import fr.afcepf.al23.partesite.iservice.stats.IBusinessStatistics;
import fr.afcepf.al23.service.Chart;
import fr.afcepf.al23.service.ChartImpl;

@ManagedBean(name="mbCharts")
@SessionScoped
public class MBCharts implements Serializable{

	@EJB
	private Chart chartService = new ChartImpl();
	
	private List<Project> projects = null;
	
	private String projectsByCategorie;
	private String projectsByPublishingDate;

	
	public void init(){ 
		//projectsByCategorie = chartService.getByCategory();
		//projectsByPublishingDate = chartService.getByPublishingDate();
	}


	public Chart getChartService() {
		return chartService;
	}


	public void setChartService(Chart chartService) {
		this.chartService = chartService;
	}


	public List<Project> getProjects() {
		return projects;
	}


	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}


	public String getProjectsByCategorie() {
		return projectsByCategorie;
	}


	public void setProjectsByCategorie(String projectsByCategorie) {
		this.projectsByCategorie = projectsByCategorie;
	}


	public String getProjectsByPublishingDate() {
		return projectsByPublishingDate;
	}


	public void setProjectsByPublishingDate(String projectsByPublishingDate) {
		this.projectsByPublishingDate = projectsByPublishingDate;
	}

	

	
	
}
