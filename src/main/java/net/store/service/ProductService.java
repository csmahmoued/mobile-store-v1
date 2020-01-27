package net.store.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import net.store.errors.NotFoundException;
import net.store.mapper.ProductMapper;
import net.store.model.Category;
import net.store.model.Product;
import net.store.modelView.ProductModelView;
import net.store.repository.CategoryRepository;
import net.store.repository.ProductRepository;

@Service
@Transactional
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	
	public Product saveProduct(
		 int productId ,	
		 String productName,double productPrice,
		 int quantity,String productDesc,String catgName,
		 MultipartFile productPreview
		 ) throws IOException 
	{
		
		Category catg=categoryRepository.findByCatgName(catgName);
		if(catg ==null) {
			throw new NotFoundException("there is no category with ("+catgName+" please add category department ");
		}
		
		Product product=new Product();
		product.setProductId(productId);
			product.setProductDesc(productDesc);
			product.setProductPrice(productPrice);
			product.setQuantity(quantity);
			product.setProductName(productName);
			product.setCategory(categoryRepository.findByCatgName(catgName));
			product.setProductPreview(compressBytes(productPreview.getBytes()));
			
		return productRepository.save(product);
	}
	
	public ProductModelView getProduct(int productId) {
		
		try {
			 ProductMapper mapper=new ProductMapper();	 
			 Product p =productRepository.findById(productId).get();
		    return mapper.convetProductToView(p);
		}catch (NoSuchElementException e) {throw new NotFoundException("the product with this id not found !");}	
		
	}
	
	
	public List<ProductModelView> getProductName(String productName) {
	
		try {
			 ProductMapper mapper=new ProductMapper();
	       	  List<ProductModelView> p=productRepository.findByProductNameContains(productName)
				.stream()
				.map(info ->mapper.convetProductToView(info))
				.collect(Collectors.toList());
		 
		return p;
		} catch (NoSuchElementException e) {throw new NotFoundException("the product with this name not found");}
	
	}
	
	

	public List<ProductModelView> getAllProduct(){
		
		try {
			      ProductMapper mapper=new ProductMapper();
		       	  List<ProductModelView> p=productRepository.findAll()
					.stream()
					.map(info ->mapper.convetProductToView(info))
					.collect(Collectors.toList());
			 
			return p;
		}catch (NoSuchElementException e) {throw new NotFoundException("no products founds!");} 
	
	}
	
	
	public void deleteProduct(int productId) {
	
		try {
			productRepository.deleteById(productId);}
		catch (EmptyResultDataAccessException  e) {throw new NotFoundException("the  product id not  exists!");} 
				
	}

	// compress the image bytes before storing it in the database
		public static byte[] compressBytes(byte[] data) {
			Deflater deflater = new Deflater();
			deflater.setInput(data);
			deflater.finish();

			ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
			byte[] buffer = new byte[1024];
			while (!deflater.finished()) {
				int count = deflater.deflate(buffer);
				outputStream.write(buffer, 0, count);
			}
			try {
				outputStream.close();
			} catch (IOException e) {
			}
			System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);

			return outputStream.toByteArray();
		}

		// uncompress the image bytes before returning it to the angular application
		public static byte[] decompressBytes(byte[] data) {
			Inflater inflater = new Inflater();
			inflater.setInput(data);
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
			byte[] buffer = new byte[1024];
			try {
				while (!inflater.finished()) {
					int count = inflater.inflate(buffer);
					outputStream.write(buffer, 0, count);
				}
				outputStream.close();
			} catch (IOException ioe) {
			} catch (DataFormatException e) {
			}
			return outputStream.toByteArray();
		}
		
		
	
	
}
