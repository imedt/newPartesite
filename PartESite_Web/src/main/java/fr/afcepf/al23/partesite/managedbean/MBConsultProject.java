package fr.afcepf.al23.partesite.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;

import fr.afcepf.al23.model.entities.Pack;
import fr.afcepf.al23.model.entities.Project;
import fr.afcepf.al23.model.entities.ProjectContent;
import fr.afcepf.al23.partesite.iservice.offer.IBusinessPack;
import fr.afcepf.al23.partesite.iservice.offer.IBusinessProject;
import fr.afcepf.al23.partesite.iservice.offer.IBusinessProjectContent;
import fr.afcepf.al23.partesite.webutil.PackWrap;

@ManagedBean(name = "mbConsultProject")
@SessionScoped
public class MBConsultProject {
	private Logger log = Logger.getLogger(MBConsultProject.class);
	
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
	private ArrayList<SelectItem> listOfAvailableItemsToBuyPack = new ArrayList<>();
	private Integer availableItemsToBuyPack;
	private List<PackWrap> wrappedPack;
	private int i = 0;
	
	public void init(){
		log.info("in preRenderView");
		packs = getPacks();
		wrappedPack = new ArrayList<PackWrap>();
		for(Pack pack : packs){
			PackWrap pw = new PackWrap(pack);
			wrappedPack.add(pw); 
		}
		log.info("there is : "+wrappedPack.size()+" packs");
	}
	
	// pour le panier : nbCommand�
	private int nbPackToOrder;

	public Project getP() {
		return p;
	}

	public void setP(Project p) {
		this.p = p;
	}

	public ArrayList<SelectItem> getListOfAvailableItemsToBuyPack() {
		return listOfAvailableItemsToBuyPack;
	}
	

	public Integer getAvailableItemsToBuyPack() {
		return availableItemsToBuyPack;
	}


	public ProjectContent getContentProjectAuthor() {
		log.info("Getting author : "+p.getIdProject());
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
		log.info("in get Packs method");
		packs = buPacks.getByidProject(getP().getIdProject());

		return packs;
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

	public ArrayList<SelectItem> remplirList(Pack p){
		listOfAvailableItemsToBuyPack = new ArrayList<>();
		setAvailableItemsToBuyPack((p.getStock()-p.getNbSale()));
		for (int i = 1; i <=availableItemsToBuyPack; i++) {
			SelectItem si = new SelectItem();
			si.setValue(i);
			si.setLabel(String.valueOf(i));
			listOfAvailableItemsToBuyPack.add(si);
		}
		return listOfAvailableItemsToBuyPack;
	}

	public void setAvailableItemsToBuyPack(Integer availableItemsToBuyPack) {
		this.availableItemsToBuyPack = availableItemsToBuyPack;
	}

	public IBusinessProject getBuProjects() {
		return buProjects;
	}

	public void setBuProjects(IBusinessProject buProjects) {
		this.buProjects = buProjects;
	}

	public IBusinessProjectContent getBuProjectContent() {
		return buProjectContent;
	}

	public void setBuProjectContent(IBusinessProjectContent buProjectContent) {
		this.buProjectContent = buProjectContent;
	}

	public IBusinessPack getBuPacks() {
		return buPacks;
	}

	public void setBuPacks(IBusinessPack buPacks) {
		this.buPacks = buPacks;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public void setPacks(List<Pack> packs) {
		this.packs = packs;
	}

	public void setAucunContenu(ProjectContent aucunContenu) {
		this.aucunContenu = aucunContenu;
	}

	public void setContentProjectAuthor(ProjectContent contentProjectAuthor) {
		this.contentProjectAuthor = contentProjectAuthor;
	}

	public void setContentProjectImage(ProjectContent contentProjectImage) {
		this.contentProjectImage = contentProjectImage;
	}

	public void setContentProjectVideo(ProjectContent contentProjectVideo) {
		this.contentProjectVideo = contentProjectVideo;
	}

	public void setContentProjectConcept(ProjectContent contentProjectConcept) {
		this.contentProjectConcept = contentProjectConcept;
	}

	public void setListOfAvailableItemsToBuyPack(
			ArrayList<SelectItem> listOfAvailableItemsToBuyPack) {
		this.listOfAvailableItemsToBuyPack = listOfAvailableItemsToBuyPack;
	}

	public void setNbPackToOrder(Integer nbPackToOrder) {
		this.nbPackToOrder = nbPackToOrder;
	}

	public List<PackWrap> getWrappedPack() {
		return wrappedPack;
	}

	public void setWrappedPack(List<PackWrap> wrappedPack) {
		this.wrappedPack = wrappedPack;
	}
	
}
