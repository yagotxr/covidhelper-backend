package com.ferry.covidhelper.repositories.custom.impls;

import com.ferry.covidhelper.domains.Store;
import com.ferry.covidhelper.repositories.custom.CustomStoreRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

@AllArgsConstructor
public class CustomStoreRepositoryImpl implements CustomStoreRepository {

    private final MongoTemplate mongoTemplate;

    @Override
    public List<Store> findAllByCity(String city) {
        Query query = new Query(Criteria.where("address.city").is(city));
        return mongoTemplate.find(query, Store.class);
    }
}
