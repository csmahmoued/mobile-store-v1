package net.store.service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import net.store.errors.NotFoundException;
import net.store.model.Product;
import net.store.model.ProductGalary;
import net.store.repository.ProductGalaryRepository;
import net.store.repository.ProductRepository;

@Service
@Transactional
public class ProductGalaryServic {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ProductGalaryRepository galaryRepository;
	
	public ProductGalary saveProductGalary(String productName,String productImageDesc,MultipartFile productImage,int id) {
		
		Product product=productRepository.findByProductName(productName);
		if(product == null)  throw new NotFoundException(productName+" not found in db");
		
		ProductGalary galary=new ProductGalary();
		try {
			galary.setProductImageDesc(productImageDesc);
			galary.setProductImage(new ProductService().compressBytes(productImage.getBytes()));
			galary.setProduct(product);
			galary.setId(id);
			galaryRepository.save(galary);
		} catch (IOException e) {
			e.printStackTrace();
		}		
		
		return galary;
	}
	
	
	public List<ProductGalary> getAllGalary(String productName){
		
		Product product=productRepository.findByProductName(productName);
		if(product == null)  throw new NotFoundException(productName+" not found in db");
		List<ProductGalary> galaryList= galaryRepository.findByProduct(product);
		if(galaryList.isEmpty()) throw new NotFoundException(productName+" there is no images for this product");

		galaryList.stream().map( galary->{
				ProductGalary g=new ProductGalary();
				g.setId(galary.getId());
				g.setProduct(g.getProduct());
				g.setProductImageDesc(g.getProductImageDesc());
				g.setProductImage(new ProductService().decompressBytes(galary.getProductImage()));
				return g;
		}).collect(Collectors.toList());
			return galaryList;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
