package fr.afcepf.al23.partesite.model.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the order_row database table.
 * 
 */
@Entity
@Table(name="order_row")
@NamedQuery(name="OrderRow.findAll", query="SELECT o FROM OrderRow o")
public class OrderRow implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_order_row")
	private Integer idOrderRow;

	private Double  amount;

	public OrderRow(Integer idOrderRow, Double amount, Integer createdBy,
			Date createdDate, Boolean disabled, Integer updatedBy,
			Date updatedDate, Pack pack, UserOrder userOrder) {
		super();
		this.idOrderRow = idOrderRow;
		this.amount = amount;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.disabled = disabled;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.pack = pack;
		this.userOrder = userOrder;
	}

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
	
	@Transient
	private List<Item> items;

	
	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

		//bi-directional many-to-one association to OrderRow
		@ManyToOne
		@JoinColumn(name="id_pack")
		private Pack pack;


	public Pack getPack() {
			return pack;
		}

		public void setPack(Pack pack) {
			this.pack = pack;
		}

	//bi-directional many-to-one association to UserOrder
	@ManyToOne
	@JoinColumn(name="id_user_order")
	private UserOrder userOrder;

	public OrderRow() {
	}

	public Integer getIdOrderRow() {
		return this.idOrderRow;
	}

	public void setIdOrderRow(Integer idOrderRow) {
		this.idOrderRow = idOrderRow;
	}

	public Double  getAmount() {
		return this.amount;
	}

	public void setAmount(Double  amount) {
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

	public UserOrder getUserOrder() {
		return this.userOrder;
	}

	public void setUserOrder(UserOrder userOrder) {
		this.userOrder = userOrder;
	}

}