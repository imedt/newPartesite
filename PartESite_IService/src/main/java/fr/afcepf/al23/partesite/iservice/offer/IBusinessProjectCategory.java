
package fr.afcepf.al23.partesite.iservice.offer;

import java.util.List;

import javax.ejb.Remote;

import fr.afcepf.al23.model.entities.ProjectCategory;

@Remote
public interface IBusinessProjectCategory {

	public ProjectCategory save(ProjectCategory projectCategory);
	public ProjectCategory disable(ProjectCategory projectCategory);
	public ProjectCategory get(Integer idProjectCategory);
	public List<ProjectCategory> getAll();
	public List<ProjectCategory> getByName(String name);
	
}
