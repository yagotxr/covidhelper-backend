package com.ferry.covidhelper.repositories;

import com.ferry.covidhelper.domains.Store;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StoreRepository extends MongoRepository <Store, String> {

    boolean existsByCnpj(String cnpj);
}
