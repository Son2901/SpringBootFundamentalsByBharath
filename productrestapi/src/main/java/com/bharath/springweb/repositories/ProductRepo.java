package com.bharath.springweb.repositories;

import com.bharath.springweb.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Integer> {
}
