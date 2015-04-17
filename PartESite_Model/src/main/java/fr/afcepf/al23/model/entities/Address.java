package fr.afcepf.al23.model.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the address database table.
 * 
 */
@Entity
@NamedQuery(name="Address.findAll", query="SELECT a FROM Address a")
@Table(name="address")
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_address")
	private Integer  idAddress;

	private String city;

	private String country;

	@Column(name="created_by")
	private Integer  createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_date")
	private Date createdDate;

	private Boolean  disabled;

	private String street;

	@Column(name="updated_by")
	private Integer  updatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_date")
	private Date updatedDate;

	private String zipcode;

	//bi-directional many-to-one association to AddressType
	@ManyToOne
	@JoinColumn(name="id_address_type")
	private AddressType addressType;

	//bi-directional many-to-one association to Identity
	@ManyToOne
	@JoinColumn(name="id_identity")
	private Identity identity;

	public Address() {
	}

	public Integer  getIdAddress() {
		return this.idAddress;
	}

	public void setIdAddress(Integer  idAddress) {
		this.idAddress = idAddress;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
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

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
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

	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public AddressType getAddressType() {
		return this.addressType;
	}

	public void setAddressType(AddressType addressType) {
		this.addressType = addressType;
	}

	public Identity getIdentity() {
		return this.identity;
	}

	public void setIdentity(Identity identity) {
		this.identity = identity;
	}

}