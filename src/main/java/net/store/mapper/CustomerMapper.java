package net.store.mapper;

import net.store.model.Customer;
import net.store.modelView.CustomerInfo;

public class CustomerMapper {

	/*
	 * method to view all customer info +(address)
	 * */
	public CustomerInfo convertCustomertoView(Customer customer) {
		var customerInfo=new CustomerInfo();
		 
		customerInfo.setCustId(customer.getCustId());
		customerInfo.setCustEmail(customer.getCustEmail());
		customerInfo.setCustPassword(customer.getCustPassword());
		customerInfo.setCustName(customer.getCustName());
		customerInfo.setCustPhone(customer.getCustPhone());
		
		customerInfo.setCity(customer.getAddress().getCity());
		customerInfo.setStr(customer.getAddress().getStr());
		customerInfo.setNbOrders(customer.getCustomerOrders().size());
		return customerInfo;
	}

	
	

	


}
