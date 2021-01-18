package com.raj.springweb.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raj.springweb.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
