package fr.afcepf.al23.partesite.model.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
 * The persistent class for the package database table.
 * 
 */
@Entity
@Table(name="pack")
@NamedQuery(name="Pack.findAll", query="SELECT p FROM Pack p")
public class Pack implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_pack")
	private Integer idPack;

	private Double amount;

	@Column(name="created_by")
	private Integer createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_date")
	private Date createdDate;

	@Lob
	private String description;

	private Boolean disabled;

	@Column(name="pack_name")
	private String packName;

	private Boolean reward;

	private Integer stock;

	@Column(name="updated_by")
	private Integer updatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_date")
	private Date updatedDate;

	//bi-directional many-to-one association to Item
	@OneToMany(mappedBy="pack")
	private List<Item> items;
	
	//bi-directional many-to-one association to OrderRow
		@OneToMany(mappedBy="order_row")
		private List<OrderRow> orderrows;

	//bi-directional many-to-one association to Project
	@ManyToOne
	@JoinColumn(name="id_project")
	private Project project;
	
	@Transient
	private Integer nbSale;

	public Pack() {
	}

	public Integer getIdPack() {
		return this.idPack;
	}

	public void setIdPack(Integer idPack) {
		this.idPack = idPack;
	}

	public Double getAmount() {
		return this.amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
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

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getDisabled() {
		return this.disabled;
	}

	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}

	public String getPackName() {
		return this.packName;
	}

	public void setPackName(String packName) {
		this.packName = packName;
	}

	public Boolean getReward() {
		return this.reward;
	}

	public void setReward(Boolean reward) {
		this.reward = reward;
	}

	public Integer getStock() {
		return this.stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
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

	public List<Item> getItems() {
		return this.items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Item addItem(Item item) {
		getItems().add(item);
		item.setPack(this);

		return item;
	}

	public Item removeItem(Item item) {
		getItems().remove(item);
		item.setPack(null);

		return item;
	}
	
	///////
	
	public List<OrderRow> getOrderrows() {
		return orderrows;
	}

	public void setOrderrows(List<OrderRow> orderrows) {
		this.orderrows = orderrows;
	}
	
	public OrderRow addItem(OrderRow orderrow) {
		getOrderrows().add(orderrow);
		orderrow.setPack(this);

		return orderrow;
	}

	public OrderRow removeItem(OrderRow orderrow) {
		getOrderrows().remove(orderrow);
		orderrow.setPack(null);

		return orderrow;
	}
	//////

	public Project getProject() {
		return this.project;
	}

	

	public void setProject(Project project) {
		this.project = project;
	}

}