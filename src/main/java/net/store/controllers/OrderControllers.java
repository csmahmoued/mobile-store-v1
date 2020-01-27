package net.store.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import net.store.modelView.Bill;
import net.store.service.CustomerOrdersService;

@RestController
@CrossOrigin
public class OrderControllers {

	@Autowired
	private CustomerOrdersService customerOrdersService;
	

	@GetMapping("/customer-bill/{custName}")
	public List<Bill> customerBills( @PathVariable String custName){
		return customerOrdersService.getCustomerBill(custName);
	}
	
	@GetMapping("/all-orders")
	public List<Bill> allOrders(){
		return customerOrdersService.getAllOrders();
	} 
	
	@DeleteMapping("/del-order/{id}")
	public ResponseEntity<Void> delOrder(@PathVariable int id){
		customerOrdersService.delteOrder(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("/make-order")
	public ResponseEntity<Void> makeOrder(
			@RequestParam("custName") String custName,
			@RequestParam("productName") String productName,
			@RequestParam("itemQuantity") int itemQuantity)
	{
		customerOrdersService.saveOrder(custName, productName, itemQuantity);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	
}
