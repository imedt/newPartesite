package fr.afcepf.al23.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the item_state database table.
 * 
 */
@Entity
@Table(name="item_state")
@NamedQuery(name="ItemState.findAll", query="SELECT i FROM ItemState i")
public class ItemState implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_item_state")
	private Integer  idItemState;

	@Column(name="created_by")
	private Integer  createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_date")
	private Date createdDate;

	private Boolean disabled;

	@Column(name="item_state_name")
	private String itemStateName;

	@Column(name="updated_by")
	private Integer  updatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_date")
	private Date updatedDate;

	//bi-directional many-to-one association to Item
	@OneToMany(mappedBy="itemState")
	private List<Item> items;

	public ItemState() {
	}

	public Integer  getIdItemState() {
		return this.idItemState;
	}

	public void setIdItemState(Integer  idItemState) {
		this.idItemState = idItemState;
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

	public Boolean getDisabled() {
		return this.disabled;
	}

	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}

	public String getItemStateName() {
		return this.itemStateName;
	}

	public void setItemStateName(String itemStateName) {
		this.itemStateName = itemStateName;
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

	public List<Item> getItems() {
		return this.items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Item addItem(Item item) {
		getItems().add(item);
		item.setItemState(this);

		return item;
	}

	public Item removeItem(Item item) {
		getItems().remove(item);
		item.setItemState(null);

		return item;
	}

}