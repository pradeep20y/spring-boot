package com.april04.ecommerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.april04.ecommerce.Entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
