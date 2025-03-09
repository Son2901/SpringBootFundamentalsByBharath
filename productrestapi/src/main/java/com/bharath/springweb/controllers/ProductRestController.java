package com.bharath.springweb.controllers;

import com.bharath.springweb.entities.Product;
import com.bharath.springweb.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductRestController {

    @Autowired
    ProductRepo repo;

    @GetMapping("/products")
    public List<Product> getProducts(){
        return repo.findAll();
    }

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable("id") int id){
        return repo.findById(id).get();
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product){
        return repo.save(product);
    }

    @PutMapping("/products")
    public Product updateProduct(@RequestBody Product product){
        return repo.save(product);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable("id") int id){
        repo.deleteById(id);
    }
}
