package com.ferry.covidhelper.services;

import com.ferry.covidhelper.domains.Product;
import com.ferry.covidhelper.domains.Store;
import com.ferry.covidhelper.payloads.requests.ProductRegistrationRequest;

import java.util.List;

public interface ProductService {

    Product registerProduct(ProductRegistrationRequest registrationRequest, Store store);
    Product getSpecificProduct(String productId, Store store);
    List<Product> getProductByStore(String storeId);
    Product editProduct(Product product, ProductRegistrationRequest registrationRequest);
    void deleteProduct(Product product);
    void deleteProductByStore(Store store);
}
