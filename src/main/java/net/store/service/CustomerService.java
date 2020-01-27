package net.store.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import net.store.errors.NotFoundException;
import net.store.mapper.CustomerMapper;
import net.store.model.Address;
import net.store.model.Customer;
import net.store.modelView.CustomerInfo;
import net.store.repository.CustomerRepository;

@Service
@Transactional
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	
	public  List<CustomerInfo> getCustomerByCustName(String custName) {
		
		try{
				CustomerMapper mapper=new CustomerMapper();		
			   List<CustomerInfo> custInfo=customerRepository.findByCustNameContains(custName)
					 .stream()
					 .map(info->mapper.convertCustomertoView(info))
					 .collect(Collectors.toList());
					 
			return custInfo;		 
			
			}
			catch(EmptyResultDataAccessException e) {throw new NotFoundException("there is no customers database is empty");}

	}
	
	public List<CustomerInfo> getAllCustomers(){
		
	try{
			CustomerMapper mapper=new CustomerMapper();		
		   List<CustomerInfo> custInfo=customerRepository.findAll()
				 .stream()
				 .map(info->mapper.convertCustomertoView(info))
				 .collect(Collectors.toList());
				 
		return custInfo;		 
		
		}
		catch(EmptyResultDataAccessException e) {throw new NotFoundException("there is no customers database is empty");}
	}
	
	public void deletCustomer(int custId) {
		try{customerRepository.deleteById(custId);}
		catch(EmptyResultDataAccessException e) {throw new NotFoundException("customer with id :"+custId+" not found in db to delete  ");}
	}

	public CustomerInfo getCustomerInfoById(int custId) {		
	  try {
			CustomerMapper custInfo=new CustomerMapper();
			Customer customer=customerRepository.findById(custId).get();			
			return custInfo.convertCustomertoView(customer);
		
	  }catch(NoSuchElementException e) {throw new NotFoundException("there is no customer with that("+custId+" ) id " );}

	}
	
    public CustomerInfo saveCustomerInfo(CustomerInfo customerInfo) {
    	Address address=new Address();
	   Customer customer =new Customer();	
				customer.setCustId(customerInfo.getCustId());
				customer.setCustEmail(customerInfo.getCustEmail());
				customer.setCustPassword(customerInfo.getCustPassword());
				customer.setCustPhone(customerInfo.getCustPhone());
				customer.setCustName(customerInfo.getCustName());
				address.setAddressId(customerInfo.getAddressId());
				address.setCity(customerInfo.getCity());
				address.setStr(customerInfo.getStr());
				address.setCustomer(customer);	
				customer.setAddress(address);
				customerRepository.save(customer);
				  return customerInfo;	
	}
    
    
   

}
