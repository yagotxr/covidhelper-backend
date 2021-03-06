package com.ferry.covidhelper.services;

import com.ferry.covidhelper.domains.Store;
import com.ferry.covidhelper.domains.User;
import com.ferry.covidhelper.payloads.requests.StoreRegistrationRequest;

import java.util.List;

public interface StoreService {

    Store registerNewStore(StoreRegistrationRequest request, User user);

    void deleteStore(Store store);

    Store getStore(String storeId, User user);

    boolean existsById(String storeId);

    List<Store> findStoresByCity(String city);

    List<Store> getUserStore(String userId);

    Store getStoreById(String storeId);
}
