package fr.afcepf.al23.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the project database table.
 * 
 */
@Entity
@NamedQuery(name="Project.findAll", query="SELECT p FROM Project p")
public class Project implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_project")
	private Integer idProject;

	@Column(name="aiming_amount")
	private Double aimingAmount;

	@Column(name="created_by")
	private Integer createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_date")
	private Date createdDate;

	private Boolean disabled;

	@Column(name="project_name")
	private String projectName;

	private Boolean publish;

	@Temporal(TemporalType.DATE)
	@Column(name="publishing_date")
	private Date publishingDate;

	@Column(name="updated_by")
	private Integer updatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_date")
	private Date updatedDate;

	//bi-directional many-to-one association to Pack
	@OneToMany(mappedBy="project")
	private List<Pack> packs;

	//bi-directional many-to-one association to Identity
	@ManyToOne
	@JoinColumn(name="id_identity")
	private Identity identity;

	//bi-directional many-to-one association to ProjectCategory
	@ManyToOne
	@JoinColumn(name="id_project_category")
	private ProjectCategory projectCategory;

	//bi-directional many-to-one association to ProjectContent
	@OneToMany(mappedBy="project")
	private List<ProjectContent> projectContents;

	public Project() {
	}

	public Integer getIdProject() {
		return this.idProject;
	}

	public void setIdProject(Integer idProject) {
		this.idProject = idProject;
	}

	public Double getAimingAmount() {
		return this.aimingAmount;
	}

	public void setAimingAmount(Double aimingAmount) {
		this.aimingAmount = aimingAmount;
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

	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Boolean getPublish() {
		return this.publish;
	}

	public void setPublish(Boolean publish) {
		this.publish = publish;
	}

	public Date getPublishingDate() {
		return this.publishingDate;
	}

	public void setPublishingDate(Date publishingDate) {
		this.publishingDate = publishingDate;
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

	public List<Pack> getPacks() {
		return this.packs;
	}

	public void setPacks(List<Pack> packs) {
		this.packs = packs;
	}

	public Pack addPack(Pack pack) {
		getPacks().add(pack);
		pack.setProject(this);

		return pack;
	}

	public Pack removePack(Pack pack) {
		getPacks().remove(pack);
		pack.setProject(null);

		return pack;
	}

	public Identity getIdentity() {
		return this.identity;
	}

	public void setIdentity(Identity identity) {
		this.identity = identity;
	}

	public ProjectCategory getProjectCategory() {
		return this.projectCategory;
	}

	public void setProjectCategory(ProjectCategory projectCategory) {
		this.projectCategory = projectCategory;
	}

	public List<ProjectContent> getProjectContents() {
		return this.projectContents;
	}

	public void setProjectContents(List<ProjectContent> projectContents) {
		this.projectContents = projectContents;
	}

	public ProjectContent addProjectContent(ProjectContent projectContent) {
		getProjectContents().add(projectContent);
		projectContent.setProject(this);

		return projectContent;
	}

	public ProjectContent removeProjectContent(ProjectContent projectContent) {
		getProjectContents().remove(projectContent);
		projectContent.setProject(null);

		return projectContent;
	}

}