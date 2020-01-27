package net.store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.store.model.Customer;
import net.store.model.CustomerOrders;
import net.store.model.Product;
@Repository
public interface CustomerOrdersRepository extends JpaRepository<CustomerOrders, Integer> {

	List<CustomerOrders> findByCustom(Customer customer);
	List<CustomerOrders> findByProduct(Product product);
	
}
