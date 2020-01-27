package net.store.mapper;

import net.store.model.CustomerOrders;
import net.store.modelView.Bill;

public class BillMapper {

	/*
	 * this mathod conert customerOrder [by cust name ] to bill information
	 * */
	public Bill convertCustomerOrderToBill(CustomerOrders cust) {
		var bill=new Bill();
		bill.setId(cust.getId());
		bill.setProductName(cust.getProduct().getProductName());
		bill.setQuantity(cust.getOrderQuantatiy());
		bill.setPrice(cust.getProduct().getProductPrice());
		bill.setTotal(cust.getProduct().getProductPrice()*cust.getOrderQuantatiy());	
		bill.setDate(cust.getDate());
		
		return bill;
	}
	
}
