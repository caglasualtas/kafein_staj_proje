package com.example.kafein_staj.service.product;

import com.example.kafein_staj.entity.Product;
import com.example.kafein_staj.exception.EntityAlreadyExists;
import com.example.kafein_staj.exception.EntityNotFoundException;
import com.example.kafein_staj.exception.NoQuantityException;

public interface ProductService {
    Product findById(Long product_id) throws EntityNotFoundException;
    Product addNewProduct(Product newProduct) throws EntityAlreadyExists;
    void deleteById(Long product_id) throws EntityNotFoundException;
    int findQuantityById(Long product_id) throws NoQuantityException, EntityNotFoundException;

}
