package com.ferry.covidhelper.repositories;

import com.ferry.covidhelper.domains.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {

    List<Product> findAllByStoreId(String storeId);
}
