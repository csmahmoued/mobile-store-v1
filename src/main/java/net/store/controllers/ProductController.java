package net.store.controllers;

import java.io.IOException;
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
import org.springframework.web.multipart.MultipartFile;

import net.store.model.Product;
import net.store.modelView.ProductModelView;
import net.store.service.ProductService;

@RestController
@CrossOrigin
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping("/save-product")
	public ResponseEntity<Product> AddNewProduct
	(@RequestParam("productName") String productName
			,@RequestParam("productId") int productId
			,@RequestParam("productPrice") double productPrice
			,@RequestParam("quantity")  int quantity
			,@RequestParam("productDesc") String productDesc
			,@RequestParam("catgName") String catgName
			,@RequestParam("productPreview") MultipartFile productPreview) throws IOException{
		
		productService.saveProduct(productId,productName,productPrice, quantity, productDesc,catgName, productPreview);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/get-product/{productId}")
	public ResponseEntity<ProductModelView> getProductById(@PathVariable int productId){
		ProductModelView p=productService.getProduct(productId);
		return new ResponseEntity<>(p,HttpStatus.OK);
	}
	
	@GetMapping("/get-product-byname/{productName}")
	public ResponseEntity<List<ProductModelView>> getProductByName(@PathVariable String productName){
		List<ProductModelView> p= productService.getProductName(productName);
		return new ResponseEntity<>(p,HttpStatus.OK);
	}
	
	@GetMapping("/all-product")
	public ResponseEntity<List<ProductModelView>> AllProducts(){
		List<ProductModelView> p= productService.getAllProduct();
		return new ResponseEntity<>(p,HttpStatus.OK);
	}
	
	@DeleteMapping("del-product/{productId}")
	public ResponseEntity<Void> delProductById(@PathVariable int productId){
		productService.deleteProduct(productId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
		
	
}
