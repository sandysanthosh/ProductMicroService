package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.ReviewRepository;


@RestController
@RequestMapping("/api")
public class productController{
	
	@Autowired
	private ProductRepository repo;
	
	@Autowired
	private ReviewRepository review;
	
	
	@GetMapping("/products")
	public List<Product> getAllUser() {
		return repo.findAll();
	}
	

	@GetMapping("/products/{id}") 
    public Optional<Product> getByIdUser(@PathVariable int id) 
	 { 
		return repo.findById(id); 
	  }

	@PostMapping("/productsall")
	public String addAllUser(@RequestBody Product Product) {
		repo.save(Product);
		return "User id";
	}


	 @DeleteMapping("/products/{id}") 
     public String deleteUser(@PathVariable int id) 
	 { 
		 repo.deleteById(id); 
	    return "User id";
	 }
	 
	 @RequestMapping("/products/{id}")
	    public String edit(@PathVariable int id, Model model) {
	        model.addAttribute("product", repo.findById(id).get());
	        return "edit";
	    }
	    
	 @PostMapping("/products/all")
	    public String update(@RequestBody Product product, @RequestParam int id, @RequestParam String prodName, @RequestParam String prodDesc, @RequestParam Double prodPrice) {
	        
	        product.setId(id);
	        product.setName(prodName);
	        product.setDescription(prodDesc);
	        product.setPrice(prodPrice);
	        
	        repo.save(product);

	       return "successlly updated";
	    }
	 
	 
	 @GetMapping("/products/{id}/reviews") 
      public Optional<Product> getByProductIdUser(@PathVariable int id) 
	 {   
		 return repo.findById(id); 
		  }
	 
	

}
