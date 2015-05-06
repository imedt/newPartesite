package fr.afcepf.al23.partesite.managedbean;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.w3c.dom.Text;

import fr.afcepf.al23.model.entities.Address;
import fr.afcepf.al23.model.entities.AddressType;
import fr.afcepf.al23.model.entities.Civility;
import fr.afcepf.al23.model.entities.Identity;
import fr.afcepf.al23.model.entities.Notification;
import fr.afcepf.al23.model.entities.Phone;
import fr.afcepf.al23.partesite.iservice.notification.IBusinessNotification;
import fr.afcepf.al23.partesite.iservice.user.IBusinessAddress;
import fr.afcepf.al23.partesite.iservice.user.IBusinessAddressType;
import fr.afcepf.al23.partesite.iservice.user.IBusinessCivility;
import fr.afcepf.al23.partesite.iservice.user.IBusinessIdentity;
import fr.afcepf.al23.partesite.iservice.user.IBusinessIdentityRole;
import fr.afcepf.al23.partesite.iservice.user.IBusinessPhone;
// import fr.afcepf.al23.partesite.model.entities.Civility;
import fr.afcepf.al23.servicetaxes_frais.service.Country;
import fr.afcepf.al23.servicetaxes_frais.service.IServiceTaxesFrais;
import fr.afcepf.al23.servicetaxes_frais.service.ServiceTaxesFraisImplService;

@ManagedBean(name="mbUser")
@SessionScoped
public class MBUser {

	@EJB
	private IBusinessIdentityRole buIdentityRole;
	@EJB
	private IBusinessIdentity buIdentity;
	@EJB
	private IBusinessCivility buCivility;
	@EJB
	private IBusinessPhone buPhone;
	@EJB
	private IBusinessAddress buAddress;
	@EJB
	private IBusinessAddressType buAddressType;
	@EJB
	private IBusinessNotification buNotification;

	@ManagedProperty(value="#{mbConnexion}")
	private MBConnexion cnx;

	
	//Civility
	private Integer idCivility;
	private List<Civility> civilities;

	//Identity
	private String firstName;
	private String lastName;
	private String birthdate;
	private String email;
	private String password;
	private Identity identity;
	private String direction;
	private List<Identity> usersList = new ArrayList<>();


	//Phone
	private List<Phone>phones=new ArrayList<>();
	private String typePhoneNumber;
	private String phoneNumber;

	//Address
	private String street;
	private String zipcode;
	private String city;
	private int country;
	private Integer idAddressType;
	private List<AddressType> addressTypes;
	private List<Address> addresses=new ArrayList<>();
	private List<Country> countries;

	//Message de validation de l'inscription
	private String message;
	public MBUser(){
		
	}
	@PostConstruct
	public void init(){
		IServiceTaxesFrais service = new ServiceTaxesFraisImplService().getPort(IServiceTaxesFrais.class);
		setCountries(service.getAllCountries());
	}
	//GET-SET EJBs
	public IBusinessIdentity getBuIdentity() {
		return buIdentity;
	}
	public IBusinessIdentityRole getBuIdentityRole() {
		return buIdentityRole;
	}
	public void setBuIdentityRole(IBusinessIdentityRole buIdentityRole) {
		this.buIdentityRole = buIdentityRole;
	}
	public void setBuIdentity(IBusinessIdentity buIdentity) {
		this.buIdentity = buIdentity;
	}
	public IBusinessCivility getBuCivility() {
		return buCivility;
	}
	public void setBuCivility(IBusinessCivility buCivility) {
		this.buCivility = buCivility;
	}
	public IBusinessPhone getBuPhone() {
		return buPhone;
	}
	public void setBuPhone(IBusinessPhone buPhone) {
		this.buPhone = buPhone;
	}
	public IBusinessAddress getBuAddress() {
		return buAddress;
	}
	public void setBuAddress(IBusinessAddress buAddress) {
		this.buAddress = buAddress;
	}
	public IBusinessAddressType getBuAddressType() {
		return buAddressType;
	}
	public void setBuAddressType(IBusinessAddressType buAddressType) {
		this.buAddressType = buAddressType;
	}
	public MBConnexion getCnx() {
		return cnx; 
	}
	public void setCnx(MBConnexion cnx) {
		this.cnx = cnx;
	}
	public String getFirstName() {
		return firstName;
	}public void setFirstName(String firstName) {
		this.firstName = firstName;
	}public String getLastName() {
		return lastName;
	}public void setLastName(String lastName) {
		this.lastName = lastName;
	}public String getBirthdate() {
		return birthdate;
	}public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}public String getEmail() {
		return email;
	}public void setEmail(String email) {
		this.email = email;
	}public String getPassword() {
		return password;
	}public void setPassword(String password) {
		this.password = password;
	}
	public Identity getIdentity() {
		try {
			if ( cnx.getId()!=null)
				identity = cnx.getId();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return identity;
		
	}public void setIdentity(Identity identity) {
		try {
			if ( cnx.getId()!=null)
				identity = cnx.getId();
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.identity = identity;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public Integer getIdCivility() {

		return idCivility;
	}
	public void setIdCivility(Integer idCivility) {
		this.idCivility = idCivility;
	}
	public List<Civility> getCivilities() {
		civilities = new ArrayList<Civility>();
		try {
			civilities  =  buCivility.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return civilities;
	}
	public void setCivilities(List<Civility> civilities) {
		this.civilities = civilities;
	}
	public List<Phone> getPhones() {
		if ( cnx.getId()!=null)
		{
			try {
				phones = buPhone.getByIdIdentity(cnx.getId().getIdIdentity());
				cnx.getId().setPhones(phones);
			} catch (Exception e) { 
				e.printStackTrace();
			}
		}
		else {
			phones = buPhone.getByIdIdentity(getIdentity().getIdIdentity());
		}
		return phones;
	}
	
	public String deleteAddress(Address a){
		buAddress.deleteAddress(a);
		return "";
	}
	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}
	public String getTypePhoneNumber() {
		return typePhoneNumber;
	}
	public void setTypePhoneNumber(String typePhoneNumber) {
		this.typePhoneNumber = typePhoneNumber;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getCountry() {
		return country;
	}
	public void setCountry(int country) {
		this.country = country;
	}
	public List<Address> getAddresses() {
		if ( cnx.getId()!=null) {
			try {
				addresses = buAddress.getByIdIdentity(cnx.getId().getIdIdentity());
				cnx.getId().setAddresses(addresses);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else {
			try {
				addresses = buAddress.getByIdIdentity(getIdentity().getIdIdentity());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}	
		return addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	public Integer getIdAddressType() {
		return idAddressType;
	}
	public void setIdAddressType(Integer idAddresstype) {
		this.idAddressType = idAddresstype;
	}
	public List<AddressType> getAddressTypes() {
		try {
			addressTypes=buAddressType.getAll();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return addressTypes;
	}
	public void setAddressTypes(List<AddressType> addressTypes) {
		this.addressTypes = addressTypes;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<Identity> getUsersList() {
		List<Identity> temp = new ArrayList<>();
		temp = buIdentity.getAll();
		for (Identity u : temp){
			if (u.getIdentityRole().getIdIdentityRole()!=2){
				usersList.add(u);
			}
		}
		return usersList;
	}
	public void setUsersList(List<Identity> usersList) {
		this.usersList = usersList;
	}

	
	//METHODES

	//M�hode inscription
	public String inscription()
	{
		identity = new Identity();

		identity.setIdentityRole(buIdentityRole.get(3));
		identity.setFirstName(firstName);
		identity.setLastName(lastName);
		identity.setEmail(email);
		identity.setMdp(password);
		identity.setCreatedDate(new Date());
		identity.setUpdatedDate(new Date());

		Civility civility = buCivility.get(idCivility);
		buCivility.save(civility);

		identity.setCivility(civility);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date date = null;

		try {
			date = sdf.parse(birthdate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		identity.setBirthdate(date);
		setIdentity(buIdentity.save(identity));
		addAddressToUser();
		
		if (identity!=null){
			setMessage("Bienvenue "+identity.getFirstName()+" ! Vous pouvez désormais vous connecter...");
			cnx.setId(identity);
		}
		
		setDirection("../pages/UserDashBoard.xhtml?faces-redirect=true");

		
		
		return direction;
	}

	//Enregistrement d'un nouveau t�l�phone
	public void addPhoneToUser(){

		Phone phone = new Phone();

		phone.setType(typePhoneNumber);
		phone.setPhoneNumber(phoneNumber);
		phone.setIdentity(getIdentity());
		buPhone.save(phone);
		

		phones.add(phone);
		identity.setPhones(phones);
		buIdentity.save(getIdentity());

	}

	public IBusinessNotification getBuNotification() {
		return buNotification;
	}
	public void setBuNotification(IBusinessNotification buNotification) {
		this.buNotification = buNotification;
	}
	//Enregistrement d'un nouveau t�l�phone
	public void addAddressToUser(){

		Address address = new Address();

		address.setStreet(street);
		address.setZipcode(zipcode);
		address.setCity(city);
		address.setCountry(country);
		AddressType addressType = buAddressType.get(2);
		address.setAddressType(addressType);

		address.setIdentity(getIdentity());
		buAddress.save(address);

		addresses.add(address);
		identity.setAddresses(addresses);
		buIdentity.save(getIdentity());

	}
	public List<Country> getCountries() {
		return countries;
	}
	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}

	public String deletePhoneNumber(Phone phone){
		buPhone.delete(phone);
		return "";
	}
	

	
	
	
}
