package fr.afcepf.al23.partesite.webutil;

import java.util.ArrayList;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.afcepf.al23.model.entities.Pack;
import fr.afcepf.al23.partesite.iservice.offer.IBusinessProjectCategory;
import fr.afcepf.al23.partesite.managedbean.MBEditProject;
import fr.afcepf.al23.partesite.managedbean.MBUser;
import fr.afcepf.al23.partesite.managedbean.transaction.MBPayment;

@ManagedBean(name="mbDemo")
@SessionScoped
public class MBDemonstration {
	@ManagedProperty(value="#{mbUser}")
	private MBUser mbInscription;
		
	@ManagedProperty(value="#{mbEditProject}")
	private MBEditProject mbEditProject;
	
	@ManagedProperty(value="#{mbPayment}")
	private MBPayment mbPayment;
	 
	@EJB
	private IBusinessProjectCategory buProjectCategory;
	
	public String demoInscription(){
		mbInscription.setBirthdate("11/12/1984");
		mbInscription.setLastName("Besse");
		mbInscription.setFirstName("Lea");
		mbInscription.setEmail("lea.besse@afcepf.fr");
		mbInscription.setPassword("afcepf");
		mbInscription.setStreet("3 Rue Danton");
		mbInscription.setZipcode("92240");
		mbInscription.setCity("Malakoff");
		mbInscription.setIdCivility(2);
		return "";
	}
	public String demoCreationProjet(){
		mbEditProject.setProjectName("Manhattan, Top to Bottom: 42 Neighborhoods, 1 Photo Book");
		mbEditProject.setProjectCategory(buProjectCategory.get(5));
		mbEditProject.setAimingAmount(50000d);
		mbEditProject.setcPContentAuthor("In November 1999, I moved from Australia to a basement apartment in Manhattan. I spent three years in the most crowded county in the USA, and there wasn’t a lot I liked. ");
		mbEditProject.setcPContentConcept("Exploring the island from north to south and finding things to love in every neighborhood, from massive skyscrapers to tiny flowers.Marble Hill; Inwood; Washington Heights (Fort Washington); Harlem (Hamilton Heights, Sugar Hill, Astor Row, Manhattanville); East Harlem; Ward's Island and Randall's Island; Morningside Heights; Upper West Side (Manhattan Valley); Central Park; Upper East Side (Carnegie Hill, Lenox Hill, Yorkville); Roosevelt Island; Hell's Kitchen; Times Square; Midtown East; Turtle Bay (Sutton Place); Tudor City; Garment District; Murray Hill; Chelsea; Midtown South (Koreatown); NoMad; Rose Hill (Curry Hill); Flatiron District; Kips Bay; Peter Cooper Village and Stuyvesant Town; Union Square; Gramercy; Greenwich Village (West Village, Meatpacking District); NoHo; East Village (Alphabet City); SoHo (Hudson Square); NoLiTa; Little Italy; Lower East Side (Bowery, Cooperative Village); TriBeCa; Chinatown; Civic Center; Battery Park City (World Trade Center); Financial District (South Street Seaport); Governor's Island; Ellis Island; and Liberty Island. <br />The book is being laid out, designed and edited by Lucia Reed, a Brooklyn-based graphic designer whose portfolio of projects can be viewed at www.luciareed.com. The book will be printed by Blurb.com, a specialty provider of high-quality photo books. The funds raised through this Kickstarter will be used to pay for production expenses and print at least 50 copies of the book. We’ve made the book as inexpensive as we can: $65 is the absolute break-even figure on what it costs to print and ship one copy. Higher pledges help us offset the project’s substantial overhead. ");
		mbEditProject.setcPContentImage("http://25realty.com/wp-content/uploads/2014/04/brooklyn.jpg");
		mbEditProject.setcPContentVideo("https://youtu.be/G4D3nwqQwy8");
		mbEditProject.setPacks(new ArrayList<Pack>());
		Pack p1 = new Pack(); 
		p1.setAmount(50d);
		p1.setStock(200);
		p1.setPackName("Basic Book of the trip");
		p1.setDescription("THE BOOK. A signed first-edition copy of “Manhattan: Top to Bottom” at a pre-release price: All post-Kickstarter copies will retail for $80. Want more than one copy? No problem. This pledge also includes the set of 6 Manhattan postcards. Add an extra $65 to your pledge for any additional copies of the book, or for a matching copy of \"As Seen in Brooklyn.\"");
		mbEditProject.getPacks().add(p1);
		Pack p2 = new Pack();
		p2.setAmount(110d);
		p2.setStock(100);
		p2.setPackName("Book+print of the trip");
		p2.setDescription("BOOK + PRINT. The signed book and the Manhattan postcard set, plus a Kickstarter-exclusive, limited edition, signed and numbered 8 x 12 print of a Manhattan photo not in the book. This exclusive print (it’s a surprise – we’ll unveil it in a backer update shortly before the book ships) will only be available to Kickstarter backers and will never be reissued. Add an extra $65 to your pledge for any additional copies of the book, or for a matching copy of \"As Seen in Brooklyn.\"");
		mbEditProject.getPacks().add(p2);
		return ""; 
	}
	
	public	String demoPaiement(){
		mbPayment.setM_titulaireCarte("Lea Besse");
		mbPayment.setM_dateExpiration("11/2016");
		mbPayment.setM_numeroCarte("4978487564871523");
		mbPayment.setM_cryptogramme("488");  
		return "";
	}
	public MBUser getMbInscription() {
		return mbInscription;
	}
	public void setMbInscription(MBUser mbInscription) {
		this.mbInscription = mbInscription;
	}
	public MBEditProject getMbEditProject() {
		return mbEditProject;
	}
	public void setMbEditProject(MBEditProject mbEditProject) {
		this.mbEditProject = mbEditProject;
	}
	public MBPayment getMbPayment() {
		return mbPayment;
	}
	public void setMbPayment(MBPayment mbPayment) {
		this.mbPayment = mbPayment;
	}
	public IBusinessProjectCategory getBuProjectCategory() {
		return buProjectCategory;
	}
	public void setBuProjectCategory(IBusinessProjectCategory buProjectCategory) {
		this.buProjectCategory = buProjectCategory;
	}
	
	
}
