package fr.afcepf.al23.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the identity_right database table.
 * 
 */
@Entity
@Table(name="identity_right")
@NamedQuery(name="IdentityRight.findAll", query="SELECT i FROM IdentityRight i")
public class IdentityRight implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_identity_right")
	private Integer  idIdentityRight;

	@Column(name="action_name")
	private String actionName;

	@Column(name="created_by")
	private Integer  createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_date")
	private Date createdDate;

	private Boolean  disabled;

	@Column(name="updated_by")
	private Integer  updatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_date")
	private Date updatedDate;

	@Column(name="value_right")
	private Boolean  valueRight;

	//bi-directional many-to-one association to IdentityRole
	@ManyToOne
	@JoinColumn(name="id_identity_role")
	private IdentityRole identityRole;

	public IdentityRight() {
	}

	public Integer  getIdIdentityRight() {
		return this.idIdentityRight;
	}

	public void setIdIdentityRight(Integer  idIdentityRight) {
		this.idIdentityRight = idIdentityRight;
	}

	public String getActionName() {
		return this.actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
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

	public Boolean  getValueRight() {
		return this.valueRight;
	}

	public void setValueRight(Boolean  valueRight) {
		this.valueRight = valueRight;
	}

	public IdentityRole getIdentityRole() {
		return this.identityRole;
	}

	public void setIdentityRole(IdentityRole identityRole) {
		this.identityRole = identityRole;
	}

}