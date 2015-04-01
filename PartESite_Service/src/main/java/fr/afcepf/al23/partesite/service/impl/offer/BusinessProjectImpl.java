package fr.afcepf.al23.partesite.service.impl.offer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import fr.afcepf.al23.model.entities.Identity;
import fr.afcepf.al23.model.entities.Item;
import fr.afcepf.al23.model.entities.Pack;
import fr.afcepf.al23.model.entities.Project;
import fr.afcepf.al23.model.entities.ProjectCategory;
import fr.afcepf.al23.partesite.idao.offer.IDaoItem;
import fr.afcepf.al23.partesite.idao.offer.IDaoPack;
import fr.afcepf.al23.partesite.idao.offer.IDaoProject;
import fr.afcepf.al23.partesite.iservice.offer.IBusinessProject;

@Stateless
public class BusinessProjectImpl implements IBusinessProject {

	@EJB
	IDaoProject daoProj;
	@EJB
	IDaoPack daoPack;
	@EJB
	IDaoItem daoItem;

	@Override
	public List<Project> searchProjectsBy(String name, Date publishingDate,
			Double aimingAmount, ProjectCategory projectCategory,
			Identity identity) {

		List<Project> projects = null;
		projects = daoProj.searchProjectsBy(name, publishingDate, aimingAmount,
				projectCategory, identity);

		return projects;
	}

	@Override
	public Project save(Project project) {
		if(project.getIdProject() == null)
			return daoProj.add(project);
		else
			return daoProj.update(project);
	}

	@Override
	public Project get(int idProject) {
		
		return daoProj.get(idProject);
	}

	@Override
	public Project publishProject(Project project) {
		project.setPublish(true);
		project.setPublishingDate(new Date());
		project = daoProj.update(project);
		return project;
	}

	@Override
	public Project disableProject(Project project) {
		project.setDisabled(true);
		project = daoProj.update(project);
		return project;
	}

	@Override
	public List<Project> getAll() {

		List<Project> projects = daoProj.getAll();

		return projects;
	}

	@Override
	public List<Project> getAllPublish() {
		List<Project> projects = daoProj.getAllPublish();
		return projects;
	}

	@Override
	public List<Project> getByIdentity(Identity identity) {
		List<Project> projects = daoProj.getByIdentity(identity);
		return projects;
	}

	@Override
	public List<Project> getAllWithItems() {

		List<Project> projects = daoProj.getAll();
		if (projects != null)
			for (Project project : projects) {
				if (project.getPacks() != null)
					for (Pack pack : project.getPacks()) {
						pack.setItems(daoItem.getSaleByPack(pack));
					}

			}
		return projects;
	}

	@Override
	public List<Project> getAllFinancedProjects() {

		List<Project> projectsToReturn = new ArrayList<Project>();
		List<Project> projects = daoProj.getAll();
		if (projects != null)
			for (Project project : projects) {
				Double amountTemp = (double)0;
				if (project.getPacks() != null) {
					for (Pack pack : project.getPacks()) {
						pack.setItems(daoItem.getSaleByPack(pack));
						for (Item item : pack.getItems()) {
							amountTemp += item.getAmount();
						}
					}
				}
				
				if(project.getAimingAmount() <= amountTemp)
				{
					projectsToReturn.add(project);
				}
				
				
			}
		return projectsToReturn;
	}

	@Override
	public List<Project> waitingProjects() {
		List<Project> projects = daoProj.getAll();
		List<Project> projectsToReturn = new ArrayList<Project>();
		for (Project project : projects) {
			if(project.getPublish())
			{
				projectsToReturn.add(project);
			}
		}
		return projectsToReturn;
	}

	@Override
	public List<Project> getByCategory(ProjectCategory projectCategory) {
		// TODO Auto-generated method stub
		return daoProj.getByCategory(projectCategory);
	}

	@Override
	public List<Project> getByName(String name) {
		// TODO Auto-generated method stub
		return daoProj.getByName(name);
	}

}
