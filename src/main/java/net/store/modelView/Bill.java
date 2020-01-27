package net.store.modelView;

import java.util.Date;

public class Bill {

	private int id;
	private String productName;
	private int quantity;
	private double price;
	private double total;
	private Date date;
	
	
	

	public Bill() {
		this.date=new Date();
	}

	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public double getTotal() {
		return total;
	}


	public void setTotal(double total) {
		this.total = total;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	
	

}
