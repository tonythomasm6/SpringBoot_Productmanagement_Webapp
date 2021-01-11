package com.springboot_productmanagement_webapp.productmanagement_webapp.repository;

import com.springboot_productmanagement_webapp.productmanagement_webapp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {


}
