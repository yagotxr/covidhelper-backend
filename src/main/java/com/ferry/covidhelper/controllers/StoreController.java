package com.ferry.covidhelper.controllers;

import com.ferry.covidhelper.domains.Store;
import com.ferry.covidhelper.domains.User;
import com.ferry.covidhelper.payloads.requests.StoreRegistrationRequest;
import com.ferry.covidhelper.payloads.responses.StoreResponse;
import com.ferry.covidhelper.security.user.UserPrincipal;
import com.ferry.covidhelper.services.StoreService;
import com.ferry.covidhelper.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@RestController
@AllArgsConstructor
public class StoreController {

    private final StoreService storeService;
    private final UserService userService;

    @PostMapping("/stores")
    @ResponseStatus(CREATED)
    public StoreResponse registerStore(@AuthenticationPrincipal UserPrincipal principal,
                                       @RequestBody StoreRegistrationRequest request){
        User user = userService.findUser(principal.getName());
        Store store = storeService.registerNewStore(request, user);
        return StoreResponse.of(store);
    }

    @GetMapping("/stores/{storeId}")
    @ResponseStatus(OK)
    public StoreResponse getStoreProfile(@AuthenticationPrincipal UserPrincipal principal,
                                         @PathVariable("storeId") String storeId){
        User user = userService.findUser(principal.getName());
        Store store = storeService.getStore(storeId, user);
        return StoreResponse.of(store);
    }

    @DeleteMapping("/stores/{storeId}")
    @ResponseStatus(NO_CONTENT)
    public void deleteStore(@AuthenticationPrincipal UserPrincipal principal,
                            @PathVariable("storeId") String storeId){
        User user = userService.findUser(principal.getName());
        Store store = storeService.getStore(storeId, user);
        storeService.deleteStore(store);
    }
}
