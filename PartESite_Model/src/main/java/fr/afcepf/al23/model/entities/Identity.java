package fr.afcepf.al23.model.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the identity database table.
 * 
 */
@Entity
@NamedQuery(name="Identity.findAll", query="SELECT i FROM Identity i")
@Table(name="identity")
public class Identity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_identity")
	private Integer  idIdentity;

	@Temporal(TemporalType.TIMESTAMP)
	private Date birthdate;

	private Boolean  blacklist;

	@Column(name="created_by")
	private Integer  createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_date")
	private Date createdDate;

	private Boolean  disabled;

	private String email;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	private String mdp;

	@Column(name="updated_by")
	private Integer  updatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_date")
	private Date updatedDate;

	//bi-directional many-to-one association to Address
	@OneToMany(mappedBy="identity")
	private List<Address> addresses;

	//bi-directional many-to-one association to Civility
	@ManyToOne
	@JoinColumn(name="id_civility")
	private Civility civility;

	//bi-directional many-to-one association to IdentityRole
	@ManyToOne
	@JoinColumn(name="id_identity_role")
	private IdentityRole identityRole;

	//bi-directional many-to-one association to Notification
	@OneToMany(mappedBy="identity")
	private List<Notification> notifications;

	//bi-directional many-to-one association to Phone
	@OneToMany(mappedBy="identity")
	private List<Phone> phones;

	//bi-directional many-to-one association to Project
	@OneToMany(mappedBy="identity")
	private List<Project> projects;

	//bi-directional many-to-one association to UserOrder
	@OneToMany(mappedBy="identity")
	private List<UserOrder> userOrders;

	public Identity() {
	}

	public Integer  getIdIdentity() {
		return this.idIdentity;
	}

	public void setIdIdentity(Integer  idIdentity) {
		this.idIdentity = idIdentity;
	}

	public Date getBirthdate() {
		return this.birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public Boolean  getBlacklist() {
		return this.blacklist;
	}

	public void setBlacklist(Boolean  blacklist) {
		this.blacklist = blacklist;
	}

	public Integer  getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Integer  createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Boolean  getDisabled() {
		return this.disabled;
	}

	public void setDisabled(Boolean  disabled) {
		this.disabled = disabled;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMdp() {
		return this.mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public Integer  getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(Integer  updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public List<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Address addAddress(Address address) {
		getAddresses().add(address);
		address.setIdentity(this);

		return address;
	}

	public Address removeAddress(Address address) {
		getAddresses().remove(address);
		address.setIdentity(null);

		return address;
	}

	public Civility getCivility() {
		return this.civility;
	}

	public void setCivility(Civility civility) {
		this.civility = civility;
	}

	public IdentityRole getIdentityRole() {
		return this.identityRole;
	}

	public void setIdentityRole(IdentityRole identityRole) {
		this.identityRole = identityRole;
	}

	public List<Notification> getNotifications() {
		return this.notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}

	public Notification addNotification(Notification notification) {
		getNotifications().add(notification);
		notification.setIdentity(this);

		return notification;
	}

	public Notification removeNotification(Notification notification) {
		getNotifications().remove(notification);
		notification.setIdentity(null);

		return notification;
	}

	public List<Phone> getPhones() {
		return this.phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	public Phone addPhone(Phone phone) {
		getPhones().add(phone);
		phone.setIdentity(this);

		return phone;
	}

	public Phone removePhone(Phone phone) {
		getPhones().remove(phone);
		phone.setIdentity(null);

		return phone;
	}

	public List<Project> getProjects() {
		return this.projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public Project addProject(Project project) {
		getProjects().add(project);
		project.setIdentity(this);

		return project;
	}

	public Project removeProject(Project project) {
		getProjects().remove(project);
		project.setIdentity(null);

		return project;
	}

	public List<UserOrder> getUserOrders() {
		return this.userOrders;
	}

	public void setUserOrders(List<UserOrder> userOrders) {
		this.userOrders = userOrders;
	}

	public UserOrder addUserOrder(UserOrder userOrder) {
		getUserOrders().add(userOrder);
		userOrder.setIdentity(this);

		return userOrder;
	}

	public UserOrder removeUserOrder(UserOrder userOrder) {
		getUserOrders().remove(userOrder);
		userOrder.setIdentity(null);

		return userOrder;
	}

}