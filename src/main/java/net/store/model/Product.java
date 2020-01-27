package net.store.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	private String productName;
	private double productPrice;
	private int quantity;
	private String productDesc;
	
	@Lob
	private  byte [] productPreview;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "product",  cascade = CascadeType.ALL)
	private List<ProductGalary> productGalary;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="catgId")
	private Category  category;

	@JsonIgnore
	@OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
	private List<CustomerOrders> customerOrders;
	
	
	public List<CustomerOrders> getCustomerOrders() {
		return customerOrders;
	}

	public void setCustomerOrders(List<CustomerOrders> customerOrders) {
		this.customerOrders = customerOrders;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public byte[] getProductPreview() {
		return productPreview;
	}

	public void setProductPreview(byte[] productPreview) {
		this.productPreview = productPreview;
	}

	
	public List<ProductGalary> getProductGalary() {
		return productGalary;
	}

	public void setProductGalary(List<ProductGalary> productGalary) {
		this.productGalary = productGalary;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
		
	
}
