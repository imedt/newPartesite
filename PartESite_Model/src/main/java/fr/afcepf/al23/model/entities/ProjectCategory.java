package fr.afcepf.al23.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the project_category database table.
 * 
 */
@Entity
@Table(name="project_category")
@NamedQuery(name="ProjectCategory.findAll", query="SELECT p FROM ProjectCategory p")
public class ProjectCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_project_category")
	private Integer idProjectCategory;

	private String category;

	@Column(name="created_by")
	private Integer createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_date")
	private Date createdDate;

	private Boolean disabled;

	@Column(name="updated_by")
	private Integer updatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_date")
	private Date updatedDate;

	//bi-directional many-to-one association to Project
	@OneToMany(mappedBy="projectCategory")
	private List<Project> projects;

	public ProjectCategory() {
	}

	public Integer getIdProjectCategory() {
		return this.idProjectCategory;
	}

	public void setIdProjectCategory(Integer idProjectCategory) {
		this.idProjectCategory = idProjectCategory;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
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

	public List<Project> getProjects() {
		return this.projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public Project addProject(Project project) {
		getProjects().add(project);
		project.setProjectCategory(this);

		return project;
	}

	public Project removeProject(Project project) {
		getProjects().remove(project);
		project.setProjectCategory(null);

		return project;
	}

}