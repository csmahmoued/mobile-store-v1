package net.store.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.store.model.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	List<Product> findByProductNameContains(String name);
	
	Product findByProductName(String name);
	
	
	
}
