package net.store.mapper;

import net.store.model.Product;
import net.store.modelView.ProductModelView;
import net.store.service.ProductService;


public class ProductMapper {

	
	public ProductModelView convetProductToView(Product product) {
		
		var productModelView =new ProductModelView();
		productModelView.setProductId(product.getProductId());
		productModelView.setProductName(product.getProductName());
		productModelView.setProductPrice(product.getProductPrice());
		productModelView.setQuantity(product.getQuantity());
		productModelView.setProductDesc(product.getProductDesc());
		productModelView.setCatgId(product.getCategory().getCatgId());
		productModelView.setCatgDesc(product.getCategory().getCatgDesc());
		productModelView.setCatgName(product.getCategory().getCatgName());
		productModelView.setNbImages(product.getProductGalary().size());
		productModelView.setNbOrders(product.getCustomerOrders().size());
		productModelView.setProductPreview(new ProductService().decompressBytes(product.getProductPreview()));
		
		return productModelView;
	}
	
}
