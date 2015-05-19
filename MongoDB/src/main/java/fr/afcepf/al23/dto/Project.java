package fr.afcepf.al23.dto;

import java.util.Date;



public class Project {

	private String project_name;
	private Date publishing_date;
	private Integer id_project;
	private Integer id_project_category;
	private Double aiming_amount;
	
	
	
	public Project() {
		super();
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	public Date getPublishing_date() {
		return publishing_date;
	}
	public void setPublishing_date(Date publishing_date) {
		this.publishing_date = publishing_date;
	}
	public Integer getId_project() {
		return id_project;
	}
	public void setId_project(Integer id_project) {
		this.id_project = id_project;
	}
	public Integer getId_project_category() {
		return id_project_category;
	}
	public void setId_project_category(Integer id_project_category) {
		this.id_project_category = id_project_category;
	}
	public Double getAiming_amount() {
		return aiming_amount;
	}
	public void setAiming_amount(Double aiming_amount) {
		this.aiming_amount = aiming_amount;
	}

	
}
