package fr.afcepf.al23.partesite.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the identity_role database table.
 * 
 */
@Entity
@Table(name="identity_role")
@NamedQuery(name="IdentityRole.findAll", query="SELECT i FROM IdentityRole i")
public class IdentityRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_identity_role")
	private Integer idIdentityRole;

	@Column(name="created_by")
	private Integer createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_date")
	private Date createdDate;

	private Boolean disabled;

	@Column(name="role_name")
	private String roleName;

	@Column(name="updated_by")
	private Integer updatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_date")
	private Date updatedDate;

	//bi-directional many-to-one association to Identity
	@OneToMany(mappedBy="identityRole")
	private List<Identity> identities;

	//bi-directional many-to-one association to IdentityRight
	@OneToMany(mappedBy="identityRole")
	private List<IdentityRight> identityRights;

	public IdentityRole() {
	}

	public Integer getIdIdentityRole() {
		return this.idIdentityRole;
	}

	public void setIdIdentityRole(Integer idIdentityRole) {
		this.idIdentityRole = idIdentityRole;
	}

	public Integer getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Boolean getDisabled() {
		return this.disabled;
	}

	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Integer getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public List<Identity> getIdentities() {
		return this.identities;
	}

	public void setIdentities(List<Identity> identities) {
		this.identities = identities;
	}

	public Identity addIdentity(Identity identity) {
		getIdentities().add(identity);
		identity.setIdentityRole(this);

		return identity;
	}

	public Identity removeIdentity(Identity identity) {
		getIdentities().remove(identity);
		identity.setIdentityRole(null);

		return identity;
	}

	public List<IdentityRight> getIdentityRights() {
		return this.identityRights;
	}

	public void setIdentityRights(List<IdentityRight> identityRights) {
		this.identityRights = identityRights;
	}

	public IdentityRight addIdentityRight(IdentityRight identityRight) {
		getIdentityRights().add(identityRight);
		identityRight.setIdentityRole(this);

		return identityRight;
	}

	public IdentityRight removeIdentityRight(IdentityRight identityRight) {
		getIdentityRights().remove(identityRight);
		identityRight.setIdentityRole(null);

		return identityRight;
	}

}