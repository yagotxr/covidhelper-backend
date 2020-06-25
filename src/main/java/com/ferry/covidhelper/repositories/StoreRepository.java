package com.ferry.covidhelper.repositories;

import com.ferry.covidhelper.domains.Store;
import com.ferry.covidhelper.repositories.custom.CustomStoreRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StoreRepository extends MongoRepository<Store, String>, CustomStoreRepository {

    boolean existsByCnpj(String cnpj);

    List<Store> findAllByUserId(String userId);
}
