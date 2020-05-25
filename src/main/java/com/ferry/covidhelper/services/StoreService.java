package com.ferry.covidhelper.services;

import com.ferry.covidhelper.domains.Store;
import com.ferry.covidhelper.domains.User;

public interface StoreService {

    Store registerNewStore(Store newStore);
    void deleteStore(String storeId);
    Store findStoreById(String storeId);
    boolean existsById(String storeId);
}
