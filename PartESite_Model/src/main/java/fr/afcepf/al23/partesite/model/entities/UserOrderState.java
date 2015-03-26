package fr.afcepf.al23.partesite.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the user_order_state database table.
 * 
 */
@Entity
@Table(name="user_order_state")
@NamedQuery(name="UserOrderState.findAll", query="SELECT u FROM UserOrderState u")
public class UserOrderState implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_user_order_state")
	private Integer idUserOrderState;

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

	@Column(name="user_order_state_name")
	private String userOrderStateName;

	//bi-directional many-to-one association to UserOrder
	@OneToMany(mappedBy="userOrderState")
	private List<UserOrder> userOrders;

	public UserOrderState() {
	}

	public Integer getIdUserOrderState() {
		return this.idUserOrderState;
	}

	public void setIdUserOrderState(Integer idUserOrderState) {
		this.idUserOrderState = idUserOrderState;
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

	public String getUserOrderStateName() {
		return this.userOrderStateName;
	}

	public void setUserOrderStateName(String userOrderStateName) {
		this.userOrderStateName = userOrderStateName;
	}

	public List<UserOrder> getUserOrders() {
		return this.userOrders;
	}

	public void setUserOrders(List<UserOrder> userOrders) {
		this.userOrders = userOrders;
	}

	public UserOrder addUserOrder(UserOrder userOrder) {
		getUserOrders().add(userOrder);
		userOrder.setUserOrderState(this);

		return userOrder;
	}

	public UserOrder removeUserOrder(UserOrder userOrder) {
		getUserOrders().remove(userOrder);
		userOrder.setUserOrderState(null);

		return userOrder;
	}

}