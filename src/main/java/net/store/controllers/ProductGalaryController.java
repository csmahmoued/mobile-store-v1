package net.store.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import net.store.model.ProductGalary;
import net.store.service.ProductGalaryServic;

@RestController
@CrossOrigin
public class ProductGalaryController {
	
	@Autowired
	private ProductGalaryServic galaryServic;
	
	@PostMapping("/save-product-galary")
	public ResponseEntity<ProductGalary> addNewGalary(
	@RequestParam("productName") String productName,
	@RequestParam("productImageDesc") String productImageDesc,
	@RequestParam("productImage") MultipartFile productImage,
	@RequestParam("id") int id){
		
		galaryServic.saveProductGalary(productName, productImageDesc, productImage,id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	@GetMapping("/get-product-galaries/{productName}")
	public ResponseEntity<List<ProductGalary>> AllGalaries(@PathVariable String productName){
		return new ResponseEntity<>(galaryServic.getAllGalary(productName),HttpStatus.OK);
	}
	
	
}
