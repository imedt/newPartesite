package fr.afcepf.al23.partesite.idao.offer;

import java.util.List;
import javax.ejb.Remote;
import fr.afcepf.al23.partesite.model.entities.ProjectCategory;

@Remote
public interface IDaoProjectCategory {

	public ProjectCategory add(ProjectCategory projectCategory);
	public ProjectCategory update(ProjectCategory projectCategory);
	public ProjectCategory get(Integer idProjectCategory);
	public List<ProjectCategory> getAll();
	public List<ProjectCategory> getByName(String name);

}
