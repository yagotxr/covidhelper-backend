package com.ferry.covidhelper.controllers;

import com.ferry.covidhelper.domains.Store;
import com.ferry.covidhelper.domains.User;
import com.ferry.covidhelper.payloads.requests.StoreRegistrationRequest;
import com.ferry.covidhelper.payloads.responses.StoreResponse;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

@RestController
@AllArgsConstructor
public class StoreController {

    private final StoreService storeService;
    private final UserService userService;
    private final ProductService productService;

    @PostMapping("/account/stores")
    @ResponseStatus(CREATED)
    public StoreResponse registerStore(@AuthenticationPrincipal UserPrincipal principal,
                                       @RequestBody StoreRegistrationRequest request){
        User user = userService.findUser(principal.getName());
        Store store = storeService.registerNewStore(request, user);
        return StoreResponse.of(store);
    }

    @GetMapping("/account/stores/{storeId}")
    @ResponseStatus(OK)
    public StoreResponse getStoreProfile(@AuthenticationPrincipal UserPrincipal principal,
                                         @PathVariable("storeId") String storeId){
        User user = userService.findUser(principal.getName());
        Store store = storeService.getStore(storeId, user);
        return StoreResponse.of(store);
    }

    @DeleteMapping("/account/stores/{storeId}")
    @ResponseStatus(NO_CONTENT)
    public void deleteStore(@AuthenticationPrincipal UserPrincipal principal,
                            @PathVariable("storeId") String storeId){
        User user = userService.findUser(principal.getName());
        Store store = storeService.getStore(storeId, user);
        productService.deleteProductByStore(store);
        storeService.deleteStore(store);
    }

    @GetMapping("/account/users/stores")
    @ResponseStatus(OK)
    public List<StoreResponse> getUsersStores(@AuthenticationPrincipal UserPrincipal principal){
        User user = userService.findUser(principal.getName());
            List<Store> stores = storeService.findUserStores(user.getId());
            return stores.stream().map(StoreResponse::of).collect(toList());
    }
}
