package fr.afcepf.al23.partesite.managedbean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

import fr.afcepf.al23.model.entities.Identity;
import fr.afcepf.al23.model.entities.Item;
import fr.afcepf.al23.model.entities.ItemState;
import fr.afcepf.al23.model.entities.Notification;
import fr.afcepf.al23.model.entities.Pack;
import fr.afcepf.al23.model.entities.Project;
import fr.afcepf.al23.model.entities.ProjectCategory;
import fr.afcepf.al23.model.entities.ProjectContent;
import fr.afcepf.al23.partesite.iservice.notification.IBusinessNotification;
import fr.afcepf.al23.partesite.iservice.offer.IBusinessItem;
import fr.afcepf.al23.partesite.iservice.offer.IBusinessItemState;
import fr.afcepf.al23.partesite.iservice.offer.IBusinessPack;
import fr.afcepf.al23.partesite.iservice.offer.IBusinessProject;
import fr.afcepf.al23.partesite.iservice.offer.IBusinessProjectCategory;
import fr.afcepf.al23.partesite.iservice.offer.IBusinessProjectContent;
import fr.afcepf.al23.partesite.iservice.user.IBusinessIdentity;

@ManagedBean(name = "mbEditProject")
@SessionScoped
public class MBEditProject {

	private Logger log = Logger.getLogger(getClass());

	@ManagedProperty(value = "#{mbConnexion}")
	MBConnexion cnx;

	@EJB
	IBusinessIdentity buIdentity;
	@EJB
	IBusinessProject buProject;
	@EJB
	IBusinessPack buPack;
	@EJB
	IBusinessProjectCategory buProjectCategory;
	@EJB
	IBusinessProjectContent buProjectContent;
	@EJB
	IBusinessItem buItem;
	@EJB
	IBusinessItemState buItemState;
	@EJB
	IBusinessNotification buNotification;

	// Creation Projet à rattacher à l'Utilisateur
	private Project p;
	private Double aimingAmount;
	private String projectName;
	private List<Pack> packs = new ArrayList<>();
	private Integer idProjectCategory;
	private ProjectCategory projectCategory;
	private List<ProjectCategory> categories;
	private List<ProjectContent> projectContents = new ArrayList<>();

	// Creation Content à ajouter au Projet
	private ProjectContent cP;
	private Integer idContentProject;
	private String cPContentImage;
	private String cPContentVideo;
	private String cPContentAuthor;
	private String cPContentConcept;

	// Creation Pack à ajouter au Projet
	private Pack pack;
	private Integer idPack;
	private Double packAmount;
	private String description;
	private String packName;
	private Boolean reward;
	private Integer stock;
	private List<Item> items = new ArrayList<>();
	private Integer nbSale;

	// Creation Item à ajouter au Pack
	private Item i;
	private Integer idItem;
	private Integer idOrderRow;
	private double iAmount;
	private ItemState itemState;

	// Méthodes de création de Projet / Content / Pack / Item
	public void createProject() {

		p = new Project();
		p.setProjectName(projectName);
		p.setAimingAmount(aimingAmount);
		p.setCreatedBy(cnx.getId().getIdIdentity());
		p.setCreatedDate(new Date());

		// Seront modifiés par le modérateur à la publication
		p.setDisabled(false);
		p.setPublish(false);

		p.setIdentity(cnx.getId());
		projectCategory = new ProjectCategory();
		projectCategory = buProjectCategory.get(getIdProjectCategory());
		p.setProjectCategory(projectCategory);

		p = buProject.save(p);

		Notification n = new Notification();
		n.setCreatedBy(1);
		n.setCreatedDate(new Date());
		n.setContentNotification("Nouveau projet à publier : "+p.getProjectName());
		n.setIdentity(cnx.getId());
		n.setIdTarget(1);
		n.setDisabled(false);
		buNotification.save(n);

		Notification n1 = new Notification();
		n1.setCreatedBy(1);
		n1.setCreatedDate(new Date());
		n1.setContentNotification("Votre demande de publication du projet : "+p.getProjectName()+" a bien été recue.");
		Identity moderator = buIdentity.get(1);
		n1.setIdentity(moderator);
		n1.setIdTarget(cnx.getId().getIdIdentity());
		n1.setDisabled(false);
		buNotification.save(n1);

	}

	public void resetP() {

		p = new Project();
		pack = new Pack();
		cP = new ProjectContent();
		i = new Item();

		aimingAmount= null;
		projectName= null;
		idProjectCategory= null;
		projectCategory= null;
		categories= null;
		projectContents = null;
		idContentProject= null;
		cPContentImage= null;
		cPContentVideo= null;
		cPContentAuthor= null;
		cPContentConcept= null;
		idPack= null;
		packAmount= null;
		description= null;
		packName= null;
		reward= null;
		stock= null;
		items= null;
		nbSale= null;
		idItem= null;
		idOrderRow= null;
		iAmount= 0.00;
		itemState= null;
	}

	public void addPackToProject() {

		pack = new Pack();
		pack.setAmount(packAmount);
		pack.setCreatedBy(cnx.getId().getIdIdentity());
		pack.setCreatedDate(new Date());
		pack.setDescription(description);
		pack.setPackName(packName);
		pack.setReward(reward);
		pack.setStock(stock);

		// Seront modifiés par le modérateur à la publication
		pack.setDisabled(true);

		pack.setProject(p);
		// Enregistre le pack
		pack = buPack.save(pack);
		// Ajoute le pack au projet
		packs.add(pack);
		p.setPacks(packs);
		// Enregistre le projet après ajout du pack
		p = buProject.save(p);
	}

	public void addContentImageToProject() {

		cP = new ProjectContent();
		cP.setContent(cPContentImage);
		cP.setCreatedBy(cnx.getId().getIdIdentity());
		cP.setCreatedDate(new Date());

		// Seront modifiés par le modérateur à la publication
		cP.setDisabled(true);

		cP.setProject(p);
		// Enregistre le content
		cP = buProjectContent.save(cP);
		// Ajoute le content au projet
		projectContents.add(cP);
		p.setProjectContents(projectContents);
		// Enregistre le projet après ajout du content
		p = buProject.save(p);
	}

	public void addContentVideoToProject() {

		cP = new ProjectContent();
		cP.setContent(cPContentVideo);
		cP.setCreatedBy(cnx.getId().getIdIdentity());
		cP.setCreatedDate(new Date());

		// Seront modifiés par le modérateur à la publication
		cP.setDisabled(true);

		cP.setProject(p);
		// Enregistre le content
		cP = buProjectContent.save(cP);
		// Ajoute le content au projet
		projectContents.add(cP);
		p.setProjectContents(projectContents);
		// Enregistre le projet après ajout du content
		p = buProject.save(p);
	}

	public void addContentAuthorToProject() {

		cP = new ProjectContent();
		cP.setContent(cPContentAuthor);
		cP.setCreatedBy(cnx.getId().getIdIdentity());
		cP.setCreatedDate(new Date());

		// Seront modifiés par le modérateur à la publication
		cP.setDisabled(true);

		cP.setProject(p);
		// Enregistre le content
		cP = buProjectContent.save(cP);
		// Ajoute le content au projet
		projectContents.add(cP);
		p.setProjectContents(projectContents);
		// Enregistre le projet après ajout du content
		p = buProject.save(p);
	}

	public void addContentConceptToProject() {

		cP = new ProjectContent();
		cP.setContent(cPContentConcept);
		cP.setCreatedBy(cnx.getId().getIdIdentity());
		cP.setCreatedDate(new Date());

		// Seront modifiés par le modérateur à la publication
		cP.setDisabled(true);

		cP.setProject(p);
		// Enregistre le content
		cP = buProjectContent.save(cP);
		// Ajoute le content au projet
		projectContents.add(cP);
		p.setProjectContents(projectContents);
		// Enregistre le projet après ajout du content
		p = buProject.save(p);
	}

	public void addContentsToProject() {

		this.addContentImageToProject();
		this.addContentVideoToProject();
		this.addContentAuthorToProject();
		this.addContentConceptToProject();
	}

	public void addItemToProject() {

		i = new Item();
		i.setAmount(iAmount);
		i.setCreatedBy(cnx.getId().getIdIdentity());
		i.setCreatedDate(new Date());

		// Seront modifiés par le modérateur à la publication
		i.setDisabled(true);
		// Sera modifié à la commande
		i.setItemState(itemState);

		i.setPack(pack);
		// Enregistre l'item
		i = buItem.createItem(i);
		// Ajoute l'item au pack
		items.add(i);
		pack.setItems(items);
		// Enregistre le pack après ajout de l'item
		pack = buPack.save(pack);
	}

	// GET & SET
	public Logger getLog() {
		return log;
	}

	public void setLog(Logger log) {
		this.log = log;
	}

	public MBConnexion getCnx() {
		return cnx;
	}

	public void setCnx(MBConnexion cnx) {
		this.cnx = cnx;
	}

	public IBusinessProject getBuProject() {
		return buProject;
	}

	public void setBuProject(IBusinessProject buProject) {
		this.buProject = buProject;
	}

	public IBusinessPack getBuPack() {
		return buPack;
	}

	public void setBuPack(IBusinessPack buPack) {
		this.buPack = buPack;
	}

	public IBusinessProjectCategory getBuProjectCategory() {
		return buProjectCategory;
	}

	public void setBuProjectCategory(IBusinessProjectCategory buProjectCategory) {
		this.buProjectCategory = buProjectCategory;
	}

	public IBusinessProjectContent getBuProjectContent() {
		return buProjectContent;
	}

	public void setBuProjectContent(IBusinessProjectContent buProjectContent) {
		this.buProjectContent = buProjectContent;
	}

	public IBusinessItem getBuItem() {
		return buItem;
	}

	public void setBuItem(IBusinessItem buItem) {
		this.buItem = buItem;
	}

	public IBusinessItemState getBuItemState() {
		return buItemState;
	}

	public void setBuItemState(IBusinessItemState buItemState) {
		this.buItemState = buItemState;
	}

	public Project getP() {
		return p;
	}

	public void setP(Project p) {
		this.p = p;
	}

	public Double getAimingAmount() {
		return aimingAmount;
	}

	public void setAimingAmount(Double aimingAmount) {
		this.aimingAmount = aimingAmount;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public List<Pack> getPacks() {
		return packs;
	}

	public void setPacks(List<Pack> packs) {
		this.packs = packs;
	}

	public Integer getIdProjectCategory() {
		return idProjectCategory;
	}

	public void setIdProjectCategory(Integer idProjectCategory) {
		this.idProjectCategory = idProjectCategory;
	}

	public ProjectCategory getProjectCategory() {
		return projectCategory;
	}

	public void setProjectCategory(ProjectCategory projectCategory) {
		this.projectCategory = projectCategory;
	}

	public List<ProjectCategory> getCategories() {
		return categories = buProjectCategory.getAll();
	}

	public void setCategories(List<ProjectCategory> categories) {
		this.categories = categories;
	}

	public List<ProjectContent> getProjectContents() {
		return projectContents;
	}

	public void setProjectContents(List<ProjectContent> projectContents) {
		this.projectContents = projectContents;
	}

	public ProjectContent getcP() {
		return cP;
	}

	public void setcP(ProjectContent cP) {
		this.cP = cP;
	}

	public Integer getIdContentProject() {
		return idContentProject;
	}

	public void setIdContentProject(Integer idContentProject) {
		this.idContentProject = idContentProject;
	}

	public String getcPContentImage() {
		return cPContentImage;
	}

	public void setcPContentImage(String cPContentImage) {
		this.cPContentImage = cPContentImage;
	}

	public String getcPContentVideo() {
		return cPContentVideo;
	}

	public void setcPContentVideo(String cPContentVideo) {
		this.cPContentVideo = cPContentVideo;
	}

	public String getcPContentAuthor() {
		return cPContentAuthor;
	}

	public void setcPContentAuthor(String cPContentAuthor) {
		this.cPContentAuthor = cPContentAuthor;
	}

	public String getcPContentConcept() {
		return cPContentConcept;
	}

	public void setcPContentConcept(String cPContentConcept) {
		this.cPContentConcept = cPContentConcept;
	}

	public Pack getPack() {
		return pack;
	}

	public void setPack(Pack pack) {
		this.pack = pack;
	}

	public Integer getIdPack() {
		return idPack;
	}

	public void setIdPack(Integer idPack) {
		this.idPack = idPack;
	}

	public Double getPackAmount() {
		return packAmount;
	}

	public void setPackAmount(Double packAmount) {
		this.packAmount = packAmount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPackName() {
		return packName;
	}

	public void setPackName(String packName) {
		this.packName = packName;
	}

	public Boolean getReward() {
		return reward;
	}

	public void setReward(Boolean reward) {
		this.reward = reward;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Integer getNbSale() {
		return nbSale;
	}

	public void setNbSale(Integer nbSale) {
		this.nbSale = nbSale;
	}

	public Item getI() {
		return i;
	}

	public void setI(Item i) {
		this.i = i;
	}

	public Integer getIdItem() {
		return idItem;
	}

	public void setIdItem(Integer idItem) {
		this.idItem = idItem;
	}

	public Integer getIdOrderRow() {
		return idOrderRow;
	}

	public void setIdOrderRow(Integer idOrderRow) {
		this.idOrderRow = idOrderRow;
	}

	public double getiAmount() {
		return iAmount;
	}

	public void setiAmount(double iAmount) {
		this.iAmount = iAmount;
	}

	public ItemState getItemState() {
		return itemState = buItemState.getByName("Disponible");
	}

	public void setItemState(ItemState itemState) {
		this.itemState = itemState;
	}
}
