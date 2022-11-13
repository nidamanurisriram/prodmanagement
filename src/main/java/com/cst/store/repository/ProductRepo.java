package com.cst.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cst.store.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long>{

}
