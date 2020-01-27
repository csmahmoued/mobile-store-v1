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

import net.store.model.Category;
import net.store.service.CategoryService;

@RestController
@CrossOrigin
public class CategoryControllers {

	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/add-catg")
	public ResponseEntity<Void> addNewCategory(@RequestBody Category category){
		categoryService.saveCategory(category);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	@GetMapping("/get-catg/{catgId}")
	public ResponseEntity<Category> SearchCategoryById(@PathVariable int catgId) {
		return new ResponseEntity<>(categoryService.getCategory(catgId),HttpStatus.OK);
	}
	
	@GetMapping("/search-catg/{catgName}")
	public ResponseEntity<List<Category>> allCategoryByName(@PathVariable String catgName){
		return new ResponseEntity<>(categoryService.getAllCategoryByName(catgName),HttpStatus.OK);
	}
	
	@GetMapping("/all-catg")
	public ResponseEntity<List<Category>> allCategory(){
		return new ResponseEntity<>(categoryService.getAllCategory(),HttpStatus.OK);
	}
	
	@DeleteMapping("del-catg/{catgId}")
	public ResponseEntity<Void> delCatg(@PathVariable int catgId){
		categoryService.deleteCategory(catgId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	
	
	
	
	
	
	
}
