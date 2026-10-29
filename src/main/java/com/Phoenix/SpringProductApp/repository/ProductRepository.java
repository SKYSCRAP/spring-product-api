package com.Phoenix.SpringProductApp.repository;

import com.Phoenix.SpringProductApp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

//JPA repository: It is primarily used to eliminate boilerplate data access code for database operations.
/*
 It provides a declarative way to perform CRUD (Create, Read, Update, Delete) operations
 and complex queries without writing manual implementation classes or SQL plumbing.
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
}
