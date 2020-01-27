package net.store.service;

import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import net.store.errors.NotFoundException;
import net.store.mapper.BillMapper;
import net.store.model.Customer;
import net.store.model.CustomerOrders;
import net.store.model.Product;
import net.store.modelView.Bill;
import net.store.repository.CustomerOrdersRepository;
import net.store.repository.CustomerRepository;
import net.store.repository.ProductRepository;

@Service
@Transactional
public class CustomerOrdersService {

	@Autowired
	private CustomerOrdersRepository customerOrdersRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	

	public CustomerOrders saveOrder(String custName,String productName,int itemQuantity) {

		Customer customer=customerRepository.findByCustName(custName);
		Product product=productRepository.findByProductName(productName);
		
		if(customer==null ||product == null) throw new NotFoundException("customer or product not found in database ");
				
		CustomerOrders order=new CustomerOrders();
		  
		order.setCustom(customer);
		order.setProduct(product);
		order.setOrderQuantatiy(itemQuantity);
		
		return customerOrdersRepository.save(order);
	}
	

	public List<Bill> getCustomerBill(String custName ){
		
		if(customerRepository.findByCustName(custName) ==null) throw new NotFoundException(" customer "+custName+" not found");
	
		Customer customer=customerRepository.findByCustName(custName);
		BillMapper mapper=new BillMapper();
		List<CustomerOrders> list= customerOrdersRepository.findByCustom(customer);
		
		if(list.isEmpty())  throw new NotFoundException("customer ("+custName+" ) did not  make any order ");
		
		List<Bill> customerBill=list.stream()
				.map(cust -> mapper.convertCustomerOrderToBill(cust))
				.collect(Collectors.toList());
		
		
		return customerBill;
	}
	
	
	public List<Bill> getAllOrders(){
		
		BillMapper mapper=new BillMapper();
		List<CustomerOrders> list= customerOrdersRepository.findAll();
		
		if(list.isEmpty())  throw new NotFoundException("no orders yet ");
		
		List<Bill> customerBill=list.stream()
				.map(cust -> mapper.convertCustomerOrderToBill(cust))
				.collect(Collectors.toList());
		
		
		return customerBill;
		
	}
	
	
	public void delteOrder(int id) {
		 try{customerOrdersRepository.deleteById(id);}
		catch(EmptyResultDataAccessException e) {throw new NotFoundException("order with id :"+id+" not found in db to delete  ");}

	}
	
	
	
}
