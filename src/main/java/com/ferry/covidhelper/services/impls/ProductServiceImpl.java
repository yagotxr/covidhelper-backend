package com.ferry.covidhelper.services.impls;

import com.ferry.covidhelper.domains.Product;
import com.ferry.covidhelper.domains.Store;
import com.ferry.covidhelper.exceptions.NotFound;
import com.ferry.covidhelper.payloads.requests.ProductRegistrationRequest;
import com.ferry.covidhelper.repositories.ProductRepository;
import com.ferry.covidhelper.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product registerProduct(ProductRegistrationRequest registrationRequest, Store store) {
        Product product = Product.of(registrationRequest, store);
        return productRepository.insert(product);
    }

    @Override
    public Product getSpecificProduct(String productId, Store store) {
        return productRepository.findByIdAndStoreId(productId, store.getId())
                .orElseThrow(() -> new NotFound("Product not found in this store."));
    }

    @Override
    public List<Product> getProductByStore(String storeId) {
        return productRepository.findAllByStoreId(storeId);
    }

    @Override
    public Product editProduct(Product product, ProductRegistrationRequest registrationRequest) {
        product.setName(registrationRequest.getName());
        product.setDescription(registrationRequest.getDescription());
        product.setStock(registrationRequest.getStock());
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }
}
