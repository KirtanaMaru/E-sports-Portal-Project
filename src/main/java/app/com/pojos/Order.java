package app.com.pojos;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "orders")
public class Order extends BaseEntity {

	@ManyToOne()
	@JoinColumn(name = "product_id")
	private Product prod;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pay_id")
	private Payment pay;
	
	private String status;
	public Order() {
		super();
	}
	public Product getProd() {
		return prod;
	}
	public void setProd(Product prod) {
		this.prod = prod;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Payment getPay() {
		return pay;
	}
	public void setPay(Payment pay) {
		this.pay = pay;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Order [prod=" + prod + ", user=" + user + ", pay=" + pay + "]";
	}
	
	
}
