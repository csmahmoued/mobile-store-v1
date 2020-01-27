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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import net.store.modelView.CustomerInfo;
import net.store.service.CustomerService;

@RestController
@CrossOrigin
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	
	@PostMapping("/save-cust-info")
	public ResponseEntity<CustomerInfo> addCustomerInfo(@RequestBody CustomerInfo customerInfo){
		customerService.saveCustomerInfo(customerInfo);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/all-customers")
	public ResponseEntity<List<CustomerInfo>> allCustomers(){
		return new ResponseEntity<>(customerService.getAllCustomers(),HttpStatus.OK);
	}
	
	@GetMapping("/get-customer/{customerId}")
	public ResponseEntity<CustomerInfo> getCustomerById(@PathVariable int customerId){
		return new ResponseEntity<>(customerService.getCustomerInfoById(customerId),HttpStatus.OK);
	}
	
	@GetMapping("/get-customer-byname/{custName}")
	public ResponseEntity<List<CustomerInfo>> getCustomerByCustname(@PathVariable String custName){
		return new ResponseEntity<>(customerService.getCustomerByCustName(custName),HttpStatus.OK);
	}
	
	@DeleteMapping("/del-customer/{custId}")
	public ResponseEntity<Void> delCustomerById(@PathVariable int custId){
		customerService.deletCustomer(custId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	


	
		
}
