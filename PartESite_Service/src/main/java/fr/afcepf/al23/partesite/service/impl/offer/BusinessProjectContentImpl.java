package fr.afcepf.al23.partesite.service.impl.offer;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import fr.afcepf.al23.model.entities.ProjectContent;
import fr.afcepf.al23.partesite.idao.offer.IDaoProjectContent;
import fr.afcepf.al23.partesite.iservice.offer.IBusinessProjectContent;

@Stateless
public class BusinessProjectContentImpl implements IBusinessProjectContent {

	private Logger log = Logger.getLogger(getClass());


	@EJB
	private IDaoProjectContent daoPC;


	@Override
	public ProjectContent save(ProjectContent projectContent) {
		if(projectContent.getIdContentProject() == null)
			projectContent = daoPC.add(projectContent);
		else
			projectContent = daoPC.update(projectContent);
		return projectContent;
	}


	@Override
	public ProjectContent disable(ProjectContent projectContent) {
		projectContent.setDisabled(true);
		projectContent = save(projectContent);
		return projectContent;
	}


	@Override
	public ProjectContent get(Integer idProjectContent) {
		ProjectContent pc = daoPC.get(idProjectContent);
		return pc;
	}


	@Override
	public List<ProjectContent> getByidProject(Integer idProject) {
		List<ProjectContent> projectContents=new ArrayList<>();
		try {
			projectContents = daoPC.getByidProject(idProject);
		} catch (Exception e) {
		e.printStackTrace();
		}
		return projectContents;
	}
	
	
	

}
