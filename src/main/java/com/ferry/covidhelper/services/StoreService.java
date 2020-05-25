package com.ferry.covidhelper.services;

import com.ferry.covidhelper.domains.Store;
import com.ferry.covidhelper.domains.User;

public interface StoreService {

    Store registerNewStore(Store newStore);
    void deleteStore(Store store);
    Store getUserStore(String storeId, User user);
    boolean existsById(String storeId);
}
