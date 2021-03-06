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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.IntStream.range;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

@RestController
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final StoreService storeService;
    private final UserService userService;

    @PostMapping("account/stores/{storeId}/products")
    @ResponseStatus(CREATED)
    public ProductResponse registerProduct(@AuthenticationPrincipal UserPrincipal principal,
                                           @RequestBody ProductRegistrationRequest productRegistrationRequest,
                                           @PathVariable("storeId") String storeId) {
        User user = userService.findUser(principal.getName());
        Store store = storeService.getStore(storeId, user);
        Product product = productService.registerProduct(productRegistrationRequest, store);
        return ProductResponse.of(product);
    }

    @DeleteMapping("account/stores/{storeId}/products/{productId}")
    @ResponseStatus(NO_CONTENT)
    public void deleteProduct(@AuthenticationPrincipal UserPrincipal principal,
                              @PathVariable("storeId") String storeId,
                              @PathVariable("productId") String productId) {
        User user = userService.findUser(principal.getName());
        Store store = storeService.getStore(storeId, user);
        Product product = productService.getSpecificProduct(productId, store);
        productService.deleteProduct(product);
    }

    @PutMapping("account/stores/{storeId}/products/{productId}")
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

    @GetMapping(value = "/products", params = {"city"})
    @ResponseStatus(OK)
    public Map<String, List<ProductResponse>> getProductsByCity(@RequestParam("city") String city) {
        List<String> storesByCity = storeService.findStoresByCity(city).stream()
                .map(Store::getId)
                .collect(toList());

        List<List<ProductResponse>> productsByStoreList = storesByCity.stream()
                .map(store -> productService.getProductByStore(store).stream()
                        .map(ProductResponse::of).collect(toList()))
                .collect(toList());

        return range(0, storesByCity.size())
                .boxed()
                .collect(toMap(storesByCity::get, productsByStoreList::get));
    }

    @GetMapping(value = "/account/stores/{storeId}/products")
    @ResponseStatus(OK)
    public List<ProductResponse> getProductsByStore(@AuthenticationPrincipal UserPrincipal principal,
                                                    @PathVariable("storeId") String storeId){
        User user = userService.findUser(principal.getName());
        Store store = storeService.getStore(storeId, user);
        return productService.getProductByStore(store.getId()).stream().map(
                ProductResponse::of
        ).collect(toList());
    }
}
