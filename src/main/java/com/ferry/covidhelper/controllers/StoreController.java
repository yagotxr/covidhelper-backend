package com.ferry.covidhelper.controllers;

import com.ferry.covidhelper.domains.Store;
import com.ferry.covidhelper.payloads.requests.StoreRegisterRequest;
import com.ferry.covidhelper.services.StoreService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@AllArgsConstructor
public class StoreController {

    private final StoreService storeService;

    @PostMapping("/stores")
    public Store registerStore(@RequestBody StoreRegisterRequest request){
        Store newStore = Store.of(request);
        return storeService.registerNewStore(newStore);
    }

    @ResponseStatus(NO_CONTENT)
    @DeleteMapping("/stores/{id}")
    public void unregisterStore(@PathVariable("id") String storeId){
        storeService.deleteStore(storeId);
    }


}
