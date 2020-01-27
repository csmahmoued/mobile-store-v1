package net.store.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import net.store.errors.NotFoundException;
import net.store.model.Category;
import net.store.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public Category saveCategory(Category category) {
		
		return categoryRepository.save(category);
	}
	
	public Category getCategory(int catgId) {
		try {return categoryRepository.findById(catgId).get();}
		catch(NoSuchElementException e) {throw new NotFoundException("there is no category withi this id ");}
	}
	

	
	public void deleteCategory(int catgId) {
		try {categoryRepository.deleteById(catgId);}
		catch (EmptyResultDataAccessException  e) {throw new NotFoundException("the  category id not  exists!");} 

	}
	
	public List<Category> getAllCategory(){
		if(categoryRepository.findAll().isEmpty()) throw new NotFoundException("there is no category database is empty");
		return categoryRepository.findAll();
	}
	
	public List<Category> getAllCategoryByName(String catgName){
		if(categoryRepository.findByCatgNameContains(catgName).isEmpty()) throw new NotFoundException(" category not found");
		 return categoryRepository.findByCatgNameContains(catgName);
	}
	
	
	
	
	
	
}
