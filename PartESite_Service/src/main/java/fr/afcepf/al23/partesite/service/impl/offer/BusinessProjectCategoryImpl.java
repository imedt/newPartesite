package fr.afcepf.al23.partesite.service.impl.offer;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import fr.afcepf.al23.partesite.idao.offer.IDaoProjectCategory;
import fr.afcepf.al23.partesite.iservice.offer.IBusinessProjectCategory;
import fr.afcepf.al23.partesite.model.entities.ProjectCategory;

@Stateless
public class BusinessProjectCategoryImpl implements IBusinessProjectCategory {
	
	private Logger log = Logger.getLogger(getClass());

	@EJB
	private IDaoProjectCategory daoCateg;
	
	@Override
	public ProjectCategory save(ProjectCategory projectCategory) {
		if(projectCategory.getIdProjectCategory() == null)
			projectCategory = daoCateg.add(projectCategory);
		else
			projectCategory = daoCateg.update(projectCategory);
		return projectCategory;
	}

	@Override
	public ProjectCategory disable(ProjectCategory projectCategory) {
		projectCategory.setDisabled(true);
		projectCategory = save(projectCategory);
		return projectCategory;
	}

	@Override
	public ProjectCategory get(Integer idProjectCategory) {
		ProjectCategory projectCategory = daoCateg.get(idProjectCategory);
		return projectCategory;
	}

	@Override
	public List<ProjectCategory> getAll() {
		List<ProjectCategory> categories = daoCateg.getAll();
		return categories;
	}

	@Override
	public List<ProjectCategory> getByName(String name) {
		List<ProjectCategory> categories = daoCateg.getByName(name);
		return categories;
	}

	

	
}
