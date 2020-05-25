package com.ferry.covidhelper.controllers;

import com.ferry.covidhelper.domains.Store;
import com.ferry.covidhelper.domains.User;
import com.ferry.covidhelper.payloads.requests.StoreRegisterRequest;
import com.ferry.covidhelper.payloads.responses.StoreResponse;
import com.ferry.covidhelper.security.user.UserPrincipal;
import com.ferry.covidhelper.services.StoreService;
import com.ferry.covidhelper.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@AllArgsConstructor
public class StoreController {

    private final StoreService storeService;
    private final UserService userService;

    @PostMapping("/stores")
    @ResponseStatus(CREATED)
    public StoreResponse registerStore(@AuthenticationPrincipal UserPrincipal principal,
                                       @RequestBody StoreRegisterRequest request){
        User user = userService.findUser(principal.getName());
        Store store = storeService.registerNewStore(Store.of(request, user));
        return StoreResponse.of(store);
    }

}
