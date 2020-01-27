package net.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.store.model.Address;
import net.store.model.Customer;

public interface AddressRepository extends JpaRepository<Address, Integer> {

	   Address findByCustomer(Customer customer);
}
