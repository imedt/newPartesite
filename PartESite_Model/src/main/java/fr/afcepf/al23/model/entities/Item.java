package fr.afcepf.al23.model.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the item database table.
 * 
 */
@Entity
@NamedQuery(name="Item.findAll", query="SELECT i FROM Item i")
@Table(name="item")
public class Item implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_item")
	private Integer idItem;


	public Item(Integer idItem, Integer idOrderRow, double amount,
			Integer createdBy, Date createdDate, Boolean disabled,
			Integer updatedBy, Date updatedDate, ItemState itemState, Pack pack) {
		super();
		this.idItem = idItem;
		this.idOrderRow = idOrderRow;
		this.amount = amount;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.disabled = disabled;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.itemState = itemState;
		this.pack = pack;
	}

	@Column(name="id_order_row")
	private Integer idOrderRow;
	
	public Integer getIdOrderRow() {
		return idOrderRow;
	}

	public void setIdOrderRow(Integer idOrderRow) {
		this.idOrderRow = idOrderRow;
	}

	private double amount;


	@Column(name="created_by")
	private Integer createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_date")
	private Date createdDate;

	private Boolean  disabled;

	@Column(name="updated_by")
	private Integer updatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_date")
	private Date updatedDate;

	//bi-directional many-to-one association to ItemState
	@ManyToOne
	@JoinColumn(name="id_state")
	private ItemState itemState;

	//bi-directional many-to-one association to Pack
	@ManyToOne
	@JoinColumn(name="id_pack")
	private Pack pack;


	public Item() {
	}

	public Integer getIdItem() {
		return this.idItem;
	}

	public void setIdItem(Integer idItem) {
		this.idItem = idItem;
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

	public Boolean  getDisabled() {
		return this.disabled;
	}

	public void setDisabled(Boolean  disabled) {
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

	public ItemState getItemState() {
		return this.itemState;
	}

	public void setItemState(ItemState itemState) {
		this.itemState = itemState;
	}

	public Pack getPack() {
		return this.pack;
	}

	public void setPack(Pack pack) {
		this.pack = pack;
	}


}