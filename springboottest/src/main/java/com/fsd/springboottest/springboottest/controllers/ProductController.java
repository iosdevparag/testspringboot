package com.fsd.springboottest.springboottest.controllers;

import com.fsd.springboottest.springboottest.entities.Product;
import com.fsd.springboottest.springboottest.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<Object> getProduct(@PathVariable Long id){

       Product product =  productService.getProduct(id);
       return new ResponseHandler().generateResponse("Product Found ", HttpStatus.OK,product);
    }

    @PostMapping("/")
    public ResponseEntity<Object> createProduct(@RequestBody Product product){

        Product productNew =  productService.createProduct(product);
        return new ResponseHandler().generateResponse("Product created ", HttpStatus.CREATED,product);
    }

    @PutMapping("/")
    public ResponseEntity<Object> updateProduct( @RequestBody Product product){

        Product productNew =  productService.updateProduct(product);
        return new ResponseHandler().generateResponse("Product updated ", HttpStatus.OK,product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return new ResponseHandler().generateResponse("Product Deleted ", HttpStatus.OK,null);
    }
}
