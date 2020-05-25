package com.ferry.covidhelper.services;

import com.ferry.covidhelper.domains.Store;
import com.ferry.covidhelper.domains.User;
import com.ferry.covidhelper.payloads.requests.StoreRegistrationRequest;

public interface StoreService {

    Store registerNewStore(StoreRegistrationRequest request, User user);

    void deleteStore(Store store);

    Store getStore(String storeId, User user);

    boolean existsById(String storeId);
}
