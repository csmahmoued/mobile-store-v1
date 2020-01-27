package net.store.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CustomerOrders {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int orderQuantatiy;
	
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yy hh:mm:ss")
    private Date date;
   
    
	@ManyToOne
	@JoinColumn(name ="productId")
	private Product product;

	@ManyToOne
	@JoinColumn(name ="custId")
	private Customer custom;
	
	
	public CustomerOrders() {
		this.date=new Date();
	}
	
	

	
	public Customer getCustom() {
		return custom;
	}

	public void setCustom(Customer custom) {
		this.custom = custom;
	}


	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getOrderQuantatiy() {
		return orderQuantatiy;
	}

	public void setOrderQuantatiy(int orderQuantatiy) {
		this.orderQuantatiy = orderQuantatiy;
	}
	
	
	
	
	
}
