package net.store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.store.model.Product;
import net.store.model.ProductGalary;

@Repository
public interface ProductGalaryRepository extends JpaRepository<ProductGalary, Integer> {

	List<ProductGalary> findByProduct(Product product);
}
