package fr.afcepf.al23.service;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import fr.afcepf.al23.dao.mongo.ProjectDao;
import fr.afcepf.al23.dto.Project;


@Stateless
public class ChartImpl implements Chart{

	@EJB
	private ProjectDao daoProject;

	@Override
	public List<Project> getByCategory() {
		return daoProject.getByCategory();
	}

	@Override
	public List<Project> getByPublishingDate() {
		return daoProject.getByPublishingDate();
	}
	
	
}
