package fr.afcepf.al23.partesite.idao.offer;

import java.util.List;
import javax.ejb.Remote;
import org.w3c.dom.Text;
import fr.afcepf.al23.partesite.model.entities.ProjectContent;

@Remote
public interface IDaoProjectContent {

	public ProjectContent add(ProjectContent projectContent);
	public ProjectContent update(ProjectContent projectContent);
	public ProjectContent get(Integer idProjectContent);
	public List<ProjectContent> getByidProject(int idProject);	
}
