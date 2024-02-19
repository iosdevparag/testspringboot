package com.fsd.springboottest.springboottest.respositories;

import com.fsd.springboottest.springboottest.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {


}
