package fr.afcepf.al23.partesite.iservice.offer;

import java.util.List;

import javax.ejb.Remote;

import org.w3c.dom.Text;

import fr.afcepf.al23.partesite.model.entities.ProjectContent;


@Remote
public interface IBusinessProjectContent {

	public ProjectContent save(ProjectContent projectContent);
	public ProjectContent disable(ProjectContent projectContent);
	public ProjectContent get(Integer idProjectContent);
	public List<ProjectContent> getByidProject(int idProject);	
}
