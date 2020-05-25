package com.ferry.covidhelper.services;

import com.ferry.covidhelper.domains.Product;
import com.ferry.covidhelper.domains.Store;

import java.util.List;

public interface ProductService {

    Product registerProduct(Product product);
    Product getSpecificProduct(String productId);
    List<Product> getProductByStore(String storeId);
    Product updateStock(Product product, long stockUpdate);
//    boolean existsById(String productId);
    void deleteProduct(Product product);

}
