package fr.afcepf.al23.dao.mongo;

import java.util.List;
import javax.ejb.Remote;
import fr.afcepf.al23.dto.Project;

@Remote
public interface ProjectDao {

	public List<Project> getAllPublish();
	public List<Project> getByCategory();
	public List<Project> getByPublishingDate();
	
}
