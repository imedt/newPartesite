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
	private String name, image, video, author, concept;

	//pour les packages
	private List<Pack> packs = new ArrayList<>();
	private Pack pack = new Pack();
	private Integer packAmount, packStock, availableItemsToBuy;
	private ProjectContent contentProjectAuthor, contentProjectImage, contentProjectVideo, contentProjectConcept;
	private ArrayList<Integer> listOfAvailableItemsToBuy = new ArrayList<>();

	public Project getP() {
		p= buProjects.get(26);
		return p;
	}

	public void setP(Project p) {
		this.p = p;
	}

	public String getName() {
		return name = p.getProjectName();
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getConcept() {
		return concept;
	}

	public void setConcept(String concept) {
		this.concept = concept;
	}

	public Integer getPackAmount() {
		return packAmount;
	}

	public void setPackAmount(Integer packAmount) {
		this.packAmount = packAmount;
	}

	public Integer getPackStock() {
		return packStock;
	}

	public void setPackStock(Integer packStock) {
		this.packStock = packStock;
	}

	public Integer getAvailableItemsToBuy() {
		availableItemsToBuy = pack.getStock() - pack.getNbSale();
		if (availableItemsToBuy!=null)
			return availableItemsToBuy;
		else return 0;
	}

	public void setAvailableItemsToBuy(Integer availableItemsToBuy) {
		this.availableItemsToBuy = availableItemsToBuy;
	}

	public Pack getPack() {
		List<Pack> packs = buPacks.getByidProject(p.getIdProject());
		pack = packs.get(0);
		return pack;
	}

	public void setPack(Pack pack) {
		this.pack = pack;
	}

	public ArrayList<Integer> getListOfAvailableItemsToBuy() {
		for (int i = 1; i==getAvailableItemsToBuy();i++)  {
			listOfAvailableItemsToBuy.add(i);
		}
		return listOfAvailableItemsToBuy;
	}

	public void setListOfAvailableItemsToBuy(
			ArrayList<Integer> listOfAvailableItemsToBuy) {
		this.listOfAvailableItemsToBuy = listOfAvailableItemsToBuy;
	}

	public IBusinessProject getBuProjects() {
		return buProjects;
	}

	public void setBuProjects(IBusinessProject buProjects) {
		this.buProjects = buProjects;
	}

	public IBusinessPack getBuPacks() {
		return buPacks;
	}

	public void setBuPacks(IBusinessPack buPacks) {
		this.buPacks = buPacks;
	}

	public IBusinessProjectContent getBuProjectContent() {
		return buProjectContent;
	}

	public void setBuProjectContent(IBusinessProjectContent buProjectContent) {
		this.buProjectContent = buProjectContent;
	}

	public ProjectContent getContentProjectAuthor() {
		List<ProjectContent> contents = buProjectContent.getByidProject(p.getIdProject());
		return contentProjectAuthor = contents.get(2);
	}

	public void setContentProjectAuthor(ProjectContent contentProjectAuthor) {
		this.contentProjectAuthor = contentProjectAuthor;
	}

	public ProjectContent getContentProjectImage() {
		List<ProjectContent> contents = buProjectContent.getByidProject(p.getIdProject());
		return contentProjectImage = contents.get(0);
	}

	public void setContentProjectImage(ProjectContent contentProjectImage) {
		this.contentProjectImage = contentProjectImage;
	}

	public ProjectContent getContentProjectVideo() {
		List<ProjectContent> contents = buProjectContent.getByidProject(p.getIdProject());
		return contentProjectVideo  = contents.get(1);
	}

	public void setContentProjectVideo(ProjectContent contentProjectVideo) {
		this.contentProjectVideo = contentProjectVideo;
	}

	public ProjectContent getContentProjectConcept() {
		List<ProjectContent> contents = buProjectContent.getByidProject(p.getIdProject());
		return contentProjectConcept = contents.get(3);
	}

	public void setContentProjectConcept(ProjectContent contentProjectConcept) {
		this.contentProjectConcept = contentProjectConcept;
	}

	public List<Pack> getPacks() {
		return packs = buPacks.getByidProject(p.getIdProject());
	}

	public void setPacks(List<Pack> packs) {
		this.packs = packs;
	}



}
