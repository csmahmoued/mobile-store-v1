package net.store.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int custId;	
	private String custName;
	private String custPassword;
	private String custEmail;
	private String custPhone;
	
	
	
	@JsonIgnore
	@OneToOne(mappedBy = "customer",cascade = CascadeType.ALL,orphanRemoval = true)
	private Address address;
	
 	@JsonIgnore
 	@OneToMany(mappedBy = "custom",cascade = CascadeType.ALL)
	private List<CustomerOrders> customerOrders;
	
 	
 	

	public List<CustomerOrders> getCustomerOrders() {
		return customerOrders;
	}

	public void setCustomerOrders(List<CustomerOrders> customerOrders) {
		this.customerOrders = customerOrders;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustPassword() {
		return custPassword;
	}

	public void setCustPassword(String custPassword) {
		this.custPassword = custPassword;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public String getCustPhone() {
		return custPhone;
	}

	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}

	

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	
	
	
}
