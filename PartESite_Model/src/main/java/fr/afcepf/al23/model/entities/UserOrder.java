package fr.afcepf.al23.model.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the user_order database table.
 * 
 */
@Entity
@Table(name="user_order")
@NamedQuery(name="UserOrder.findAll", query="SELECT u FROM UserOrder u")
public class UserOrder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_user_order")
	private Integer  idUserOrder;

	@Column(name="created_by")
	private Integer  createdBy;

	public UserOrder(Integer idUserOrder, Integer createdBy, Date createdDate,
			Boolean disabled, Double totalAmount, Integer updatedBy,
			Date updatedDate, List<OrderRow> orderRows, List<Payment> payments,
			Identity identity, UserOrderState userOrderState) {
		super();
		this.idUserOrder = idUserOrder;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.disabled = disabled;
		this.totalAmount = totalAmount;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.orderRows = orderRows;
		this.payments = payments;
		this.identity = identity;
		this.userOrderState = userOrderState;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_date")
	private Date createdDate;

	private Boolean  disabled;

	@Column(name="total_amount")
	private Double  totalAmount;

	@Column(name="updated_by")
	private Integer  updatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_date")
	private Date updatedDate;

	//bi-directional many-to-one association to OrderRow
	@OneToMany(mappedBy="userOrder")
	private List<OrderRow> orderRows;

	//bi-directional many-to-one association to Payment
	@OneToMany(mappedBy="userOrder")
	private List<Payment> payments;

	//bi-directional many-to-one association to UserOrderState
	@ManyToOne
	@JoinColumn(name="id_state")
	private UserOrderState userOrderState;

	//bi-directional many-to-one association to Identity
	@ManyToOne
	@JoinColumn(name="id_identity")
	private Identity identity;

	public UserOrder() {
	}

	public Integer  getIdUserOrder() {
		return this.idUserOrder;
	}

	public void setIdUserOrder(Integer  idUserOrder) {
		this.idUserOrder = idUserOrder;
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

	public Double  getTotalAmount() {
		return this.totalAmount;
	}

	public void setTotalAmount(Double  totalAmount) {
		this.totalAmount = totalAmount;
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

	public List<OrderRow> getOrderRows() {
		return this.orderRows;
	}

	public void setOrderRows(List<OrderRow> orderRows) {
		this.orderRows = orderRows;
	}

	public OrderRow addOrderRow(OrderRow orderRow) {
		getOrderRows().add(orderRow);
		orderRow.setUserOrder(this);

		return orderRow;
	}

	public OrderRow removeOrderRow(OrderRow orderRow) {
		getOrderRows().remove(orderRow);
		orderRow.setUserOrder(null);

		return orderRow;
	}

	public List<Payment> getPayments() {
		return this.payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public Payment addPayment(Payment payment) {
		getPayments().add(payment);
		payment.setUserOrder(this);

		return payment;
	}

	public Payment removePayment(Payment payment) {
		getPayments().remove(payment);
		payment.setUserOrder(null);

		return payment;
	}

	public UserOrderState getUserOrderState() {
		return this.userOrderState;
	}

	public void setUserOrderState(UserOrderState userOrderState) {
		this.userOrderState = userOrderState;
	}

	public Identity getIdentity() {
		return this.identity;
	}

	public void setIdentity(Identity identity) {
		this.identity = identity;
	}

}