package fr.afcepf.al23.service;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import fr.afcepf.al23.dto.Project;

@Remote
public interface Chart {

	public List<Project> getByCategory();
	public List<Project> getByPublishingDate();

}
