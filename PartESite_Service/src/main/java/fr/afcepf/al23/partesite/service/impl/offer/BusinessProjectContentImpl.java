package fr.afcepf.al23.partesite.service.impl.offer;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.w3c.dom.Text;

import fr.afcepf.al23.partesite.idao.offer.IDaoProjectContent;
import fr.afcepf.al23.partesite.iservice.offer.IBusinessProjectContent;
import fr.afcepf.al23.partesite.model.entities.ProjectContent;

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
	public List<ProjectContent> getByidProject(int idProject) {
		List<ProjectContent> projectContents = daoPC.getByidProject(idProject);
		
		return projectContents;
	}
	
	
	

}
