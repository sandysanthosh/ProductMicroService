package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Product;
import com.example.demo.model.Review;

@Repository
public interface ReviewRepository extends MongoRepository<Review, Integer>{

		public void delete(Review Review);
}