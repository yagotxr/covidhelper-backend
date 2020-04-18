package com.ferry.covidhelper.repositories;

import com.ferry.covidhelper.domains.Product;

import java.util.List;

public interface ProductService {

    Product getSpecificProduct(String productId);
    List<Product> getProductByStore(String storeId);
    Product updateStock(String productId);

}
