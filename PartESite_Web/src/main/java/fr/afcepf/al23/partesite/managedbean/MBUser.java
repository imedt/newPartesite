package fr.afcepf.al23.partesite.managedbean;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.afcepf.al23.partesite.iservice.user.IBusinessCivility;
import fr.afcepf.al23.partesite.iservice.user.IBusinessIdentity;
import fr.afcepf.al23.partesite.iservice.user.IBusinessIdentityRole;
import fr.afcepf.al23.partesite.model.entities.Civility;
import fr.afcepf.al23.partesite.model.entities.Identity;
import fr.afcepf.al23.partesite.model.entities.IdentityRole;

@ManagedBean(name="mbUser")
@SessionScoped
public class MBUser {

	@EJB
	private IBusinessIdentity buIdentity;
	
	@EJB
	private IBusinessIdentityRole buIdentityRole;
	
	@EJB
	private IBusinessCivility buCivility;
	
	public IBusinessCivility getBuCivility() {
		return buCivility;
	}
	public void setBuCivility(IBusinessCivility buCivility) {
		this.buCivility = buCivility;
	}
	public MBConnexion getCnx() {
		return cnx;
	}
	public void setCnx(MBConnexion cnx) {
		this.cnx = cnx;
	}
	private Integer civilite;
	public IBusinessIdentityRole getBuIdentityRole() {
		return buIdentityRole;
	}
	public void setBuIdentityRole(IBusinessIdentityRole buIdentityRole) {
		this.buIdentityRole = buIdentityRole;
	}
	public Integer getCivilite() {
		return civilite;
	}
	public void setCivilite(Integer civilite) {
		this.civilite = civilite;
	}
	private String firstName;
	private String lastName;
	private String birthdate;
	private String email;
	private String password;
	private Identity identity;
	private String direction;
	
	@ManagedProperty(value="#{mbConnexion}")
	MBConnexion cnx;

	public IBusinessIdentity getBuIdentity() {
		return buIdentity;
	}
	public void setBuIdentity(IBusinessIdentity buIdentity) {
		this.buIdentity = buIdentity;
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
		identity=cnx.buIdentity.get(identity.getIdIdentity());
		return identity;
	}public void setIdentity(Identity identity) {
		this.identity = identity;
	}

	public String inscription()
	{
		
		identity = new Identity();
		
		identity.setCreatedDate(new Date());
		
		identity.setUpdatedDate(new Date());
		
		identity.setFirstName(firstName);
		identity.setLastName(lastName);
		identity.setEmail(email);
		identity.setMdp(password);
		identity.setBirthdate(new Date());
		/*
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		
		try {
			date = sdf.parse("birthdate");
			
		} catch (ParseException e) {
			e.printStackTrace();
		}*/
		
		

		if ( identity != null)
		{
			setDirection("/Home.xhtml?faces-redirect=true");
		}
		else
		{
			setDirection("/UserDashBoard.xhtml?faces-redirect=true");
		}
		
		
		identity = buIdentity.save(identity);
		
			
		return direction;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	
	
}
