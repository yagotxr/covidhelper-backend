package com.ferry.covidhelper.controllers;

import com.ferry.covidhelper.domains.Product;
import com.ferry.covidhelper.domains.Store;
import com.ferry.covidhelper.domains.User;
import com.ferry.covidhelper.payloads.requests.ProductRegistrationRequest;
import com.ferry.covidhelper.payloads.responses.ProductResponse;
import com.ferry.covidhelper.security.user.UserPrincipal;
import com.ferry.covidhelper.services.ProductService;
import com.ferry.covidhelper.services.StoreService;
import com.ferry.covidhelper.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@RestController
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final StoreService storeService;
    private final UserService userService;

    @PostMapping("/stores/{storeId}/products")
    @ResponseStatus(CREATED)
    public ProductResponse registerProduct(@AuthenticationPrincipal UserPrincipal principal,
                                           @RequestBody ProductRegistrationRequest productRegistrationRequest,
                                           @PathVariable("storeId") String storeId) {
        User user = userService.findUser(principal.getName());
        Store store = storeService.getStore(storeId, user);
        Product product = productService.registerProduct(productRegistrationRequest, store);
        return ProductResponse.of(product);
    }

    @DeleteMapping("/stores/{storeId}/products/{productId}")
    @ResponseStatus(NO_CONTENT)
    public void deleteProduct(@AuthenticationPrincipal UserPrincipal principal,
                              @PathVariable("storeId") String storeId,
                              @PathVariable("productId") String productId) {
        User user = userService.findUser(principal.getName());
        Store store = storeService.getStore(storeId, user);
        Product product = productService.getSpecificProduct(productId, store);
        productService.deleteProduct(product);
    }

    @PutMapping("/stores/{storeId}/products/{productId}")
    @ResponseStatus(OK)
    public ProductResponse editProduct(@AuthenticationPrincipal UserPrincipal principal,
                                       @RequestBody ProductRegistrationRequest request,
                                       @PathVariable("storeId") String storeId,
                                       @PathVariable("productId") String productId) {
        User user = userService.findUser(principal.getName());
        Store store = storeService.getStore(storeId, user);
        Product product = productService.getSpecificProduct(productId, store);
        product = productService.editProduct(product, request);
        return ProductResponse.of(product);
    }

}
