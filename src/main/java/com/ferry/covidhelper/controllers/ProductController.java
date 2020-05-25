package com.ferry.covidhelper.controllers;

import com.ferry.covidhelper.domains.Product;
import com.ferry.covidhelper.domains.Store;
import com.ferry.covidhelper.payloads.requests.ProductRegisterRequest;
import com.ferry.covidhelper.services.ProductService;
import com.ferry.covidhelper.services.StoreService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

@RestController
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final StoreService storeService;

    @ResponseStatus(CREATED)
    @PostMapping("/stores/{id}/products")
    public Product registerProduct(@RequestBody ProductRegisterRequest productRegisterRequest,
                                   @PathVariable("id") String storeId){

        Store store = storeService.findStoreById(storeId);
        Product product = Product.of(productRegisterRequest, store);
        return productService.registerProduct(product);
    }

    @ResponseStatus(NO_CONTENT)
    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable("id") String productId){
        Product product = productService.getSpecificProduct(productId);
        productService.deleteProduct(product);
    }

    @ResponseStatus(OK)
    @PutMapping("/stores/{storeId}/products/{productId}")
    public Product updateProductStock(@PathVariable("storeId") String storeId,
                                      @PathVariable("productId") String productId,
                                      @RequestBody long newStock){
        Product product = productService.getSpecificProduct(productId);
        return productService.updateStock(product, newStock);
    }

}
