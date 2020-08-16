package com.example.demo.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, Integer>{

	public void delete(Product product);
	
	/*
	 * @Query(value="{ 'firstname' : ?0 }", fields="{ '' : 1, 'lastname' : 1}")
	 * List<Product> findByTheProductFirstname(String name);
	 */

}
