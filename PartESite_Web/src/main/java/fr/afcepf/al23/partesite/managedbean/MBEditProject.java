package fr.afcepf.al23.partesite.managedbean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.xml.ws.BindingProvider;

import localhost._8080.ode.processes.conversionprocess.ConversionProcess;
import localhost._8080.ode.processes.conversionprocess.ConversionProcessPortType;
import localhost._8080.ode.processes.conversionprocess.ConversionProcessRequest;

import org.apache.log4j.Logger;

import fr.afcepf.al23.model.entities.Identity;
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
import fr.afcepf.al23.partesite.iservice.user.IBusinessAddress;
import fr.afcepf.al23.partesite.iservice.user.IBusinessIdentity;

@ManagedBean(name = "mbEditProject")
@SessionScoped
public class MBEditProject {

	private Logger log = Logger.getLogger(getClass());

	@ManagedProperty(value="#{mbConnexion}")
	private MBConnexion cnx; 

	@EJB
	private IBusinessIdentity buIdentity;
	@EJB
	private IBusinessProject buProject;
	@EJB
	private IBusinessPack buPack;
	@EJB
	private IBusinessProjectCategory buProjectCategory;
	@EJB
	private IBusinessProjectContent buProjectContent;
	@EJB
	private IBusinessItem buItem;
	@EJB
	private IBusinessItemState buItemState;
	@EJB
	private IBusinessNotification buNotification;
	@EJB
	private IBusinessAddress buAddress;
	
 
	// Creation Projet a rattacher a l'Utilisateur
	private Project p;
	private Double aimingAmount;
	private String projectName;
	private List<Pack> packs = new ArrayList<>();
	private Integer idProjectCategory;
	private ProjectCategory projectCategory;
	private List<ProjectCategory> categories;
	private List<ProjectContent> projectContents = new ArrayList<>();

	// Creation Content a ajouter au Projet
	private ProjectContent cP;
	private Integer idContentProject;
	private String cPContentImage;
	private String cPContentVideo;
	private String cPContentAuthor;
	private String cPContentConcept;
	
	//BPEL
	private static ConversionProcessPortType cpt;

	public MBEditProject(){
		packs = new ArrayList<Pack>();
		packs.add(new Pack()); 
		cpt = new ConversionProcess().getPort(ConversionProcessPortType.class);
		BindingProvider pb = (BindingProvider) cpt;
		pb.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://localhost:8080/ode/processes/ConversionProcess.ConversionProcessPort/");
	}
	
	// Methodes de creation de Projet / Content / Pack / Item
	public void createProject() {
		log.info("Creating new project");
		p = new Project();
		projectCategory = new ProjectCategory();
		
		p.setProjectName(projectName);
		p.setAimingAmount(aimingAmount);
		p.setCreatedBy(cnx.getId().getIdIdentity());
		p.setCreatedDate(new Date());
		// Seront modifi�s par le mod�rateur � la publication
		p.setDisabled(false);
		p.setPublish(false);
		p.setIdentity(cnx.getId());
		projectCategory = buProjectCategory.get(getIdProjectCategory());
		p.setProjectCategory(projectCategory);
	}
	private void sendNotifications(){
		log.info("creating notification 1");
		Notification n = new Notification();
		n.setCreatedBy(1);
		n.setCreatedDate(new Date());
		n.setContentNotification("Nouveau projet à publier : "+p.getProjectName());
		n.setIdentity(cnx.getId());
		n.setIdTarget(1);
		n.setDisabled(false);
		log.info("save notification");

		buNotification.save(n);
		log.info("creating notification 2");

		Notification n1 = new Notification();
		n1.setCreatedBy(1);
		n1.setCreatedDate(new Date());
		n1.setContentNotification("Votre demande de publication du projet : "+p.getProjectName()+" a bien été recue.");
		Identity moderator = buIdentity.get(1);
		n1.setIdentity(moderator);
		n1.setIdTarget(cnx.getId().getIdIdentity());
		n1.setDisabled(false);
		log.info("save notification 2");
		buNotification.save(n1);
	}
	
	public String validateProject(){
		log.info("Validating project");
		this.createProject(); 
		log.info("Create project's content");
		this.addContentsToProject();
		log.info("add packs to project");
		this.addPacksToProject();
		log.info("save whole project");
		this.saveProject();
		return "UserNotifications.xhtml";
	}
	public void saveProject(){
		log.info("save project");
		p.setAimingAmount(cpt.process(createPayload(p.getAimingAmount())).getMontantTTC());
		p = buProject.save(p);
		log.info("save project content");
		for(ProjectContent pc : p.getProjectContents()){
			log.info("setting project to content"); 
			pc.setProject(p);
			log.info("saving content");
			buProjectContent.save(pc);
		}
		log.info("there is : "+packs.size() +" packs");
		for(Pack pp : packs){
			log.info("pack info : "+pp);
			if(pp != null && !pp.getPackName().equals("")){
				log.info("pack existing and gonna be created");  
				pp.setProject(p);
				pp.setAmount(cpt.process(createPayload(pp.getAmount())).getMontantTTC());
				buPack.save(pp);
			}
		}
		sendNotifications();
		resetP();
	}
	private ConversionProcessRequest createPayload(double montant){
		ConversionProcessRequest cpr = new ConversionProcessRequest();
		cpr.setCommission(10);
		cpr.setDeviseCible("EUR");
		cpr.setDeviseSource(cnx.getDevise());
		cpr.setIdPays(buAddress.getByIdIdentity(cnx.getId().getIdIdentity()).get(0).getCountry());
		cpr.setIsHT(true); 
		cpr.setMontantHT(montant);
		return cpr;
	}
	public void resetP() {

		p = new Project();
		cP = new ProjectContent();

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
	}

	public Project addPacksToProject() {
		for(Pack pack : packs){
			pack.setProject(p);
			pack.setCreatedBy(cnx.getId().getIdIdentity());
			pack.setCreatedDate(new Date()); 
			p.setPacks(packs);
		}		
		return p;
		// Enregistre le projet apres ajout du pack
	}

	public Project addContentToProject(String value){
		cP = new ProjectContent();
		cP.setContent(value);
		log.info("Cnx : "+cnx);
		log.info("Id : "+cnx.getId());
		cP.setCreatedBy(cnx.getId().getIdIdentity());
		cP.setCreatedDate(new Date());

		// Seront modifies par le moderateur a la publication
		cP.setDisabled(true);
		// Ajoute le content au projet
		projectContents.add(cP);
		p.setProjectContents(projectContents);
		return p; 
	}

	public void addContentsToProject() {

		this.addContentToProject(cPContentImage);
		this.addContentToProject(cPContentVideo);
		this.addContentToProject(cPContentAuthor);
		this.addContentToProject(cPContentConcept);
	}
	
    public void onButtonRemoveFieldClick(final Pack p_oField)
    {
    	log.info("ref to destroy : "+p_oField);
        for(Pack p : packs){
        	log.info("ref before : "+p);
        }
        packs.remove(p_oField);
        for(Pack p : packs){
        	log.info("ref after : "+p);
        }
  }
    
    public void onButtonAddFieldClick(AjaxBehaviorEvent p_oEvent)
    {
    	log.info("In event listener");
    	if(this.packs.size() < 3){ 
    		this.packs.add(new Pack());
    	}
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

	public IBusinessIdentity getBuIdentity() {
		return buIdentity;
	}
	public void setBuIdentity(IBusinessIdentity buIdentity) {
		this.buIdentity = buIdentity;
	}
	public IBusinessNotification getBuNotification() {
		return buNotification;
	}
	public void setBuNotification(IBusinessNotification buNotification) {
		this.buNotification = buNotification;
	}
	
	public int getNbTotalPack(){
		return packs.size();
	}
	public static ConversionProcessPortType getCpt() {
		return cpt;
	}
	public static void setCpt(ConversionProcessPortType cpt) {
		MBEditProject.cpt = cpt;
	}

	
	
}
