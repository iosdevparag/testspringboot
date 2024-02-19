package com.fsd.springboottest.springboottest.services;

import com.fsd.springboottest.springboottest.entities.Product;
import com.fsd.springboottest.springboottest.exections.EntitynotFoundException;
import com.fsd.springboottest.springboottest.respositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll(){
        return  productRepository.findAll();
    }

    public Product getProduct(Long id){
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isPresent()){
            return optionalProduct.get();
        }
        throw new EntitynotFoundException("Product with given id not found");
    }

    public Product createProduct(Product product){
       Product newProduct = productRepository.save(product);
       return newProduct;
    }

    public Product updateProduct(Product updatedProduct){
        Optional<Product> optionalProduct = productRepository.findById(updatedProduct.getId());
        Product newProduct = optionalProduct.get();
        newProduct.setName(updatedProduct.getName());
        newProduct.setDescription(updatedProduct.getDescription());
        newProduct.setPrice(updatedProduct.getPrice());
        newProduct.setId(updatedProduct.getId());
        if(optionalProduct.isPresent()){
            productRepository.save(newProduct);
            return newProduct;
        }
        throw new EntitynotFoundException("Product with given id not found");
    }

    public void deleteProduct(Long id){
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isPresent()){
           productRepository.delete(optionalProduct.get());
        }
        throw new EntitynotFoundException("Product with given id not found");
    }




}
