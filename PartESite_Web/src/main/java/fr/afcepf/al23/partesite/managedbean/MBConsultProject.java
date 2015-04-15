package fr.afcepf.al23.partesite.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.afcepf.al23.model.entities.Pack;
import fr.afcepf.al23.model.entities.Project;
import fr.afcepf.al23.model.entities.ProjectContent;
import fr.afcepf.al23.partesite.iservice.offer.IBusinessPack;
import fr.afcepf.al23.partesite.iservice.offer.IBusinessProject;
import fr.afcepf.al23.partesite.iservice.offer.IBusinessProjectContent;

@ManagedBean(name = "mbConsultProject")
@SessionScoped
public class MBConsultProject {


	
	@EJB
	private IBusinessProject buProjects;
	@EJB
	private IBusinessProjectContent buProjectContent;
	@EJB
	private IBusinessPack buPacks;

	private Project p = new Project();

	// pour les packages
	private List<Pack> packs = new ArrayList<>();
	private ProjectContent aucunContenu = new ProjectContent();
	private ProjectContent contentProjectAuthor = new ProjectContent();
	private ProjectContent contentProjectImage  = new ProjectContent();
	private ProjectContent contentProjectVideo  = new ProjectContent();
	private ProjectContent contentProjectConcept = new ProjectContent();
	private ArrayList<Integer> listOfAvailableItemsToBuyPack = new ArrayList<>();
	private Integer availableItemsToBuyPack;
	private int i = 0;

	// pour le panier : nbCommand�
	private Integer nbPackToOrder;

	public Project getP() {
		return p;
	}

	public void setP(Project p) {
		this.p = p;
	}

	public ArrayList<Integer> getListOfAvailableItemsToBuyPack() {
		return listOfAvailableItemsToBuyPack;
	}
	

	public Integer getAvailableItemsToBuyPack() {
		return availableItemsToBuyPack;
	}


	public ProjectContent getContentProjectAuthor() {
		List<ProjectContent> contents = buProjectContent.getByidProject(p
				.getIdProject());
		if (contents.size() >= 3 && contents.get(2)!=null)
		return contentProjectAuthor = contents.get(2);
		else return getAucunContenu();
	}

	public ProjectContent getContentProjectImage() {
		List<ProjectContent> contents = buProjectContent.getByidProject(p
				.getIdProject()); 
		if (contents.size() >= 1 && contents.get(0)!=null)
		return contentProjectImage = contents.get(0);
		else return getAucunContenu();
	}

	public ProjectContent getContentProjectVideo() {
		List<ProjectContent> contents = buProjectContent.getByidProject(p
				.getIdProject());
		if (contents.size() >= 2 && contents.get(1)!=null)
		return contentProjectVideo = contents.get(1);
		else return getAucunContenu();
	}

	public ProjectContent getContentProjectConcept() {
		List<ProjectContent> contents = buProjectContent.getByidProject(p
				.getIdProject());
		if (contents.size() >= 4 && contents.get(3)!=null)
		return contentProjectConcept = contents.get(3);
		else return getAucunContenu();
	}

	public List<Pack> getPacks() {
		return packs = buPacks.getByidProject(getP().getIdProject());
	}

	public Integer getNbPackToOrder() {
		return nbPackToOrder;
	}
	
	public String detailProject(Project project){
		setP(project);
		return "/projectDetails.xhtml?faces-redirect=true";	
	}

	public ProjectContent getAucunContenu() {
		aucunContenu.setContent("aucun contenu disponible");
		return aucunContenu;
	}

	public ArrayList<Integer> remplirList(Pack p){
		listOfAvailableItemsToBuyPack = new ArrayList<>();
		setAvailableItemsToBuyPack((p.getStock()-p.getNbSale()));
		for (Integer i = 1; i <=availableItemsToBuyPack; i++) {
			listOfAvailableItemsToBuyPack.add(i);
		}
		return listOfAvailableItemsToBuyPack;
	}

	public void setAvailableItemsToBuyPack(Integer availableItemsToBuyPack) {
		this.availableItemsToBuyPack = availableItemsToBuyPack;
	}
	
}