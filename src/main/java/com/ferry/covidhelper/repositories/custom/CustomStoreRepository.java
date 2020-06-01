package com.ferry.covidhelper.repositories.custom;

import com.ferry.covidhelper.domains.Store;

import java.util.List;

public interface CustomStoreRepository {

    List<Store> findAllByCity(String city);
}
