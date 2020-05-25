package com.ferry.covidhelper.services.impls;

import com.ferry.covidhelper.domains.Product;
import com.ferry.covidhelper.domains.Store;
import com.ferry.covidhelper.exceptions.BadRequestException;
import com.ferry.covidhelper.exceptions.NotFoundException;
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
    public Product registerProduct(Product product) {
        return productRepository.insert(product);
    }

    @Override
    public Product getSpecificProduct(String productId) {
            return productRepository.findById(productId).orElseThrow(() -> new NotFoundException("Product not found"));
    }

    @Override
    public List<Product> getProductByStore(String storeId) {
        return productRepository.findAllByStoreId(storeId);
    }

    @Override
    public Product updateStock(Product product, long stockUpdate) {
        if(stockUpdate < 0){
            throw new BadRequestException("Stocks must not be less then 0;");
        }
        product.setStock(stockUpdate);
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }
}
