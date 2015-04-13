package fr.afcepf.al23.partesite.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
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
	private Project projetARecuperer;
	private String name, image, video, author, concept;

	// pour les packages
	private List<Pack> packs = new ArrayList<>();
	private Pack pack1 = new Pack();
	private Pack pack2 = new Pack();
	private Pack pack3 = new Pack();
	private ProjectContent aucunContenu = new ProjectContent();
	private ProjectContent contentProjectAuthor = new ProjectContent();
	private ProjectContent contentProjectImage  = new ProjectContent();
	private ProjectContent contentProjectVideo  = new ProjectContent();
	private ProjectContent contentProjectConcept = new ProjectContent();
	private ArrayList<Integer> listOfAvailableItemsToBuyPack1 = new ArrayList<>();
	private ArrayList<Integer> listOfAvailableItemsToBuyPack2 = new ArrayList<>();
	private ArrayList<Integer> listOfAvailableItemsToBuyPack3 = new ArrayList<>();
	private Integer availableItemsToBuyPack1, availableItemsToBuyPack2,
			availableItemsToBuyPack3;
	private int i = 0;

	// pour le panier : nbCommandé
	private Integer nbPackToOrder;

	public Project getP() {
		return p;
	}

	public Project getProjetARecuperer() {
		return projetARecuperer;
	}

	public void setProjetARecuperer(Project projetARecuperer) {
		this.projetARecuperer = projetARecuperer;
	}

	public void setP(Project p) {
		this.p = p;
	}

	public String getName() {
		return name = p.getProjectName();
	}

	public void getPack() {
		List<Pack> packs = buPacks.getByidProject(p.getIdProject());
			pack1 = packs.get(0);
			pack2 = packs.get(1);
			pack3 = packs.get(2);
	}

	public ArrayList<Integer> getListOfAvailableItemsToBuyPack1() {
		for (Integer i = 1; i <= getAvailableItemsToBuyPack1(); i++) {
			listOfAvailableItemsToBuyPack1.add(i);
		}
		return listOfAvailableItemsToBuyPack1;
	}
	
	public ArrayList<Integer> getListOfAvailableItemsToBuyPack2() {
		for (Integer i = 1; i <= getAvailableItemsToBuyPack2(); i++) {
			listOfAvailableItemsToBuyPack2.add(i);
		}
		return listOfAvailableItemsToBuyPack2;
	}

	public ArrayList<Integer> getListOfAvailableItemsToBuyPack3() {
		for (Integer i = 1; i <= getAvailableItemsToBuyPack3(); i++) {
			listOfAvailableItemsToBuyPack3.add(i);
		}
		return listOfAvailableItemsToBuyPack3;
	}

	public ProjectContent getContentProjectAuthor() {
		List<ProjectContent> contents = buProjectContent.getByidProject(p
				.getIdProject());
		if ( contents.get(2)!=null)
		return contentProjectAuthor = contents.get(2);
		else return getAucunContenu();
	}

	public ProjectContent getContentProjectImage() {
		List<ProjectContent> contents = buProjectContent.getByidProject(p
				.getIdProject());
		if ( contents.get(0)!=null)
		return contentProjectImage = contents.get(0);
		else return getAucunContenu();
	}

	public ProjectContent getContentProjectVideo() {
		List<ProjectContent> contents = buProjectContent.getByidProject(p
				.getIdProject());
		if ( contents.get(1)!=null)
		return contentProjectVideo = contents.get(1);
		else return getAucunContenu();
	}

	public ProjectContent getContentProjectConcept() {
		List<ProjectContent> contents = buProjectContent.getByidProject(p
				.getIdProject());
		if ( contents.get(3)!=null)
		return contentProjectConcept = contents.get(3);
		else return getAucunContenu();
	}

	public List<Pack> getPacks() {
		return packs = buPacks.getByidProject(p.getIdProject());
	}


	public Pack getPack1() {
		return pack1 = getPacks().get(0);
	}

	public Pack getPack2() {
		return pack2 = getPacks().get(1);
	}

	public Pack getPack3() {
		return pack3 = getPacks().get(2);
	}

	public Integer getAvailableItemsToBuyPack1() {
		if ( getPack1()!=null)
		return availableItemsToBuyPack1 = packs.get(0).getStock() - packs.get(0).getNbSale();
		else return 0;

	}

	public Integer getAvailableItemsToBuyPack2() {
		if (  getPack2()!=null)
		return availableItemsToBuyPack2 = packs.get(1).getStock() - packs.get(1).getNbSale();
		else return 0;
	}

	public Integer getAvailableItemsToBuyPack3() {
		if (  getPack3()!=null)
		return availableItemsToBuyPack3 = packs.get(2).getStock() - packs.get(2).getNbSale();
		else return 0;
	}

	public Integer getNbPackToOrder() {
		return nbPackToOrder;
	}

	public void setNbPackToOrder(Integer nbPackToOrder) {
		this.nbPackToOrder = nbPackToOrder;
	}
	
	public String detailProject(Project project){
		setP(project);
		return "/projectDetails.xhtml?faces-redirect=true";	
	}

	public ProjectContent getAucunContenu() {
		aucunContenu.setContent("aucun contenu disponible");
		return aucunContenu;
	}

}
